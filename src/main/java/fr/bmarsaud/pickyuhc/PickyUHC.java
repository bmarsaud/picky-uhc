package fr.bmarsaud.pickyuhc;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class PickyUHC extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        getLogger().info("Hello PickyUHC!");
    }
}
