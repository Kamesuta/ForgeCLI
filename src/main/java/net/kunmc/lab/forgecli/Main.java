package net.kunmc.lab.forgecli;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws Throwable {
        List<String> argsList = Stream.of(args).collect(Collectors.toList());
        if (argsList.size() < 4) {
            System.out.println("Invalid arguments! Use: java -jar <ForgeCLI.jar> --installer <forge-installer.jar> --target <install-location>");
            System.exit(1);
            return;
        }
        Path installerJar = Paths.get(argsList.get(argsList.indexOf("--installer") + 1)).toAbsolutePath();
        Path targetDir = Paths.get(argsList.get(argsList.indexOf("--target") + 1)).toAbsolutePath();

        if (!Files.exists(installerJar)) {
            System.out.println("Forge Installer is not found!");
            System.exit(1);
            return;
        }
        try (URLClassLoader ucl = URLClassLoader.newInstance(new URL[]{
                Main.class.getProtectionDomain().getCodeSource().getLocation(),
                installerJar.toUri().toURL()
        }, getParentClassLoader())) {
            Class<?> installer = ucl.loadClass("net.kunmc.lab.forgecli.Installer");
            if (!(boolean) installer.getMethod("install", File.class, File.class).invoke(null, targetDir.toFile(), installerJar.toFile())) {
                return;
            }
        }

        ;//Class.forName(detector.getMainClass(forgeFullVersion)).getMethod("main", String[].class).invoke(null, new Object[] { args });
    }

    // https://github.com/MinecraftForge/Installer/blob/fe18a164b5ebb15b5f8f33f6a149cc224f446dc2/src/main/java/net/minecraftforge/installer/actions/PostProcessors.java#L287-L303
    private static ClassLoader getParentClassLoader() {
        if (!System.getProperty("java.version").startsWith("1.")) {
            try {
                return (ClassLoader) ClassLoader.class.getDeclaredMethod("getPlatformClassLoader").invoke(null);
            } catch (Exception e) {
                System.out.println("No platform classloader: " + System.getProperty("java.version"));
            }
        }
        return null;
    }
}
