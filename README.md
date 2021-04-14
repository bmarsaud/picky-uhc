# picky-uhc

:apple: PickyUHC is a Minecraft plugin that allow you to deactivate natural regeneration only for a subset of players.
More casuals players can now play together with the more hardcore ones on the same server!

This plugin was developed and tested on Spigot 1.16.5 but is probably compatible with older version and other server flavours.

## Installation
Place the plugin JAR file in your `plugins` folder.

## Configuration
Edit the `PickyUHC/config.yml` from your `plugins` folder.

Put under the `enable` section the list of players with natural regeneration activated and under the `disable` section the list of players with natural regeneration deactivated.

You can use the wildcard `'*'`  character to specify all players (except the ones in the other section).

Reload the configuration using the `/pickyuhc reload` command if the server is already started.

## Commands
|Command|Usage|
|---|---|
|`/pickyuhc reload`|Reload the configuration from file|
|`/pickyuhc <enable/disable> <Player>`|Enable or disable natural regeneration for the given Player|

## Permissions
|Permission|Usage|
|---|---|
|`pickyuhc.command`|Allow the use of the `/pickyuhc` command|