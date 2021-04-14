package fr.bmarsaud.pickyuhc;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.metadata.FixedMetadataValue;
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

        getServer().getPluginManager().registerEvents(new PickyUHCListener(this), this);

        updateAllPlayersRegen();
    }

    public void loadConfig() {
        enabledPlayers = getConfig().getStringList("regen.enable");
        disabledPlayers = getConfig().getStringList("regen.disable");
        enabledByDefault = enabledPlayers.contains("*");
    }

    public void updatePlayerRegen(Player player) {
        boolean isRegenActive = enabledByDefault;
        if(enabledPlayers.contains(player.getName())) {
            isRegenActive = true;
        } else if(disabledPlayers.contains(player.getName())) {
            isRegenActive = false;
        }

        player.setSaturatedRegenRate(isRegenActive ? 10 : Integer.MAX_VALUE);
        player.setUnsaturatedRegenRate(isRegenActive ? 80 : Integer.MAX_VALUE);
        player.setMetadata("regen.enabled", new FixedMetadataValue(this, isRegenActive));
    }

    public void updateAllPlayersRegen() {
        for(Player player : getServer().getOnlinePlayers()) {
            updatePlayerRegen(player);
        }
    }
}
