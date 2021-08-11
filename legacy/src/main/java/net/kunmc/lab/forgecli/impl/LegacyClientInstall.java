package net.kunmc.lab.forgecli.impl;

import java.io.File;
import java.util.function.Predicate;

import net.minecraftforge.installer.actions.ActionCanceledException;
import net.minecraftforge.installer.actions.ClientInstall;
import net.minecraftforge.installer.actions.ProgressCallback;
import net.minecraftforge.installer.json.Install;

public class LegacyClientInstall extends ClientInstall {
    public LegacyClientInstall(Install profile, ProgressCallback monitor) {
        super(profile, monitor);
    }

    @Override
    public boolean run(File target, Predicate<String> optionals) throws ActionCanceledException {
        return super.run(target, optionals);
    }
}
