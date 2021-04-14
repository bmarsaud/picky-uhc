package fr.bmarsaud.pickyuhc;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class PickyUHC extends JavaPlugin implements Listener {
    private List<String> enabledPlayers;
    private List<String> disabledPlayers;
    private boolean enabledByDefault;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        loadConfig();

        getLogger().info("Natural regeneration is " + (enabledByDefault ? "enabled" : "disabled") + " by default");
        getLogger().info(enabledPlayers.size() + " players loaded with natural regeneration enabled");
        getLogger().info(disabledPlayers.size() + " players loaded with natural regeneration disabled");
    }

    public void loadConfig() {
        enabledPlayers = getConfig().getStringList("regen.enable");
        disabledPlayers = getConfig().getStringList("regen.disable");
        enabledByDefault = enabledPlayers.contains("*");
    }

    public List<String> getEnabledPlayers() {
        return enabledPlayers;
    }

    public List<String> getDisabledPlayers() {
        return disabledPlayers;
    }

    public boolean isEnabledByDefault() {
        return enabledByDefault;
    }
}
