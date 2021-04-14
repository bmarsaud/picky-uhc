package fr.bmarsaud.pickyuhc;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent.RegainReason;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.metadata.FixedMetadataValue;

public class PickyUHCListener implements Listener {
    private PickyUHC pickyUHC;

    public PickyUHCListener(PickyUHC pickyUHC) {
        this.pickyUHC = pickyUHC;
    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        boolean isRegenActive = this.pickyUHC.isEnabledByDefault();
        if(this.pickyUHC.getEnabledPlayers().contains(event.getPlayer().getName())) {
            isRegenActive = true;
        } else if(this.pickyUHC.getDisabledPlayers().contains(event.getPlayer().getName())) {
            isRegenActive = false;
        }
        event.getPlayer().setMetadata("regen.enabled", new FixedMetadataValue(pickyUHC, isRegenActive));

        if(!isRegenActive) {
            event.getPlayer().setSaturatedRegenRate(Integer.MAX_VALUE);
            event.getPlayer().setUnsaturatedRegenRate(Integer.MAX_VALUE);
        }
    }

    @EventHandler
    public void onEntityRegainHealthEvent(EntityRegainHealthEvent event) {
        if(event.getEntity() instanceof Player && (event.getRegainReason() == RegainReason.SATIATED || event.getRegainReason() == RegainReason.REGEN)) {
            Player player = (Player) event.getEntity();
            event.setCancelled(!player.getMetadata("regen.enabled").get(0).asBoolean());
        }
    }
}
