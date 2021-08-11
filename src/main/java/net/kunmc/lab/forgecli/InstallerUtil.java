package net.kunmc.lab.forgecli;

import net.kunmc.lab.forgecli.impl.ClientInstall;
import net.kunmc.lab.forgecli.impl.LegacyClientInstall;
import net.minecraftforge.installer.actions.ActionCanceledException;
import net.minecraftforge.installer.actions.ProgressCallback;
import net.minecraftforge.installer.json.Install;

import java.io.File;

public class InstallerUtil {
    public static boolean runClientInstall(ProgressCallback monitor, File target, File installerJar) {
        try {
            boolean v1;
            try {
                Class.forName("net.minecraftforge.installer.json.InstallV1");
                v1 = true;
            } catch (ClassNotFoundException e) {
                v1 = false;
            }
            if (v1) {
                Install profile = ClientInstall.loadInstallProfile();
                return new ClientInstall(profile, monitor).run(target, input -> true, installerJar);
            } else {
                Install profile = LegacyClientInstall.loadInstallProfile();
                return new LegacyClientInstall(profile, monitor).run(target, input -> true);
            }
        } catch (ActionCanceledException e) {
            throw new RuntimeException(e);
        }
    }
}
