package me.aqua_tuor.arenawars.Items;

import me.aqua_tuor.arenawars.managers.GameManager;
import me.aqua_tuor.arenawars.managers.PlayerState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;

public class CustomItemListeners implements Listener {

    private GameManager gameManager;

    public CustomItemListeners(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @EventHandler
    public void onPlayerFishingRodUse(PlayerFishEvent event) {
        Player player = event.getPlayer();

        // Check if the player is in the Arena
        if (gameManager.getPlayerManager().getPlayerState(player) == PlayerState.INARENA) {
            ItemStack item = player.getInventory().getItemInMainHand();
        }
    }

}
