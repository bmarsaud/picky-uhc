# picky-uhc

:apple: PickyUHC is a Minecraft plugin that allow you to deactivate natural regeneration only for a subset of players.
More casuals players can now play together with the more hardcore ones on the same server!

This plugin was developed and tested on Spigot 1.16.5 but is probably compatible with older version and other server flavours.

## Installation
Place the plugin JAR file in your `plugins` folder.

## Configuration
There are two ways to use this plugins: using permissions or using the configuration file.

### Configuration file
Edit the `PickyUHC/config.yml` file from your `plugins` folder.

Put under the `enable` section the list of players with natural regeneration activated and under the `disable` section the list of players with natural regeneration deactivated.

You can use the wildcard `'*'`  character to define if natural regeneration is enabled or disabled by default for all players. Note that if you don't specify a wildcard in any section, natural regeneration will be enabled by default.

Reload the configuration using the `/pickyuhc reload` command if the server is already started.

### Permissions
Use the `pickyuhc.regen.enable` to enable natural regeneration and `pickyuhc.regen.disable` to disable natural regeneration.

If a player has both permissions, natural regeneration will be enabled by default.

## Commands
|Command|Usage|
|---|---|
|`/pickyuhc reload`|Reload the configuration from file|
|`/pickyuhc <enable/disable> <Player>`|Enable or disable natural regeneration for the given Player|

## Permissions
|Permission|Usage|
|---|---|
|`pickyuhc.command`|Allow the use of the `/pickyuhc` command|
|`pickyuhc.regen.enable`|Enable natural regeneration for this player|
|`pickyuhc.regen.disable`|Disable natural regeneration for this player|