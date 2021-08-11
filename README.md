# ForgeCLI

Allow Forge Installer to install Minecraft 1.13+ with Forge via command-line.

## How to use

1. Download Forge installer for Minecraft 1.13+ [here](https://files.minecraftforge.net/).
2. Download ForgeCLI jar file at the [release](https://github.com/TeamKun/ForgeCLI/releases) page.
3. Run the below command in terminal:
   ```
   java -jar <ForgeCLI.jar> --installer <forge-installer.jar> --target <install-location>
   ```
   3 arguments are required.
   * `--installer`: Forge Installer jar file  
     ex) forge-1.16.5-36.2.2-installer.jar  
   * `--target`: Minecraft Install Location  
     ex) %appdata%\.minecraft  
