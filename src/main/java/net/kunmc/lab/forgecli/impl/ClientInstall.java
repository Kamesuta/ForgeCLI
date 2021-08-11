package net.kunmc.lab.forgecli.impl;

import net.minecraftforge.installer.actions.ActionCanceledException;
import net.minecraftforge.installer.actions.ProgressCallback;
import net.minecraftforge.installer.json.Install;
import net.minecraftforge.installer.json.InstallV1;
import net.minecraftforge.installer.json.Util;

import java.io.File;
import java.util.function.Predicate;

public class ClientInstall extends net.minecraftforge.installer.actions.ClientInstall {
    public ClientInstall(Install profile, ProgressCallback monitor) {
        super(profile instanceof InstallV1 ? (InstallV1) profile : new InstallV1(profile), monitor);
    }

    @Override
    public boolean run(File target, Predicate<String> optionals, File installer) throws ActionCanceledException {
        return super.run(target, optionals, installer);
    }

    public static Install loadInstallProfile() {
        return Util.loadInstallProfile();
    }
}
