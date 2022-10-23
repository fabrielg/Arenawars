package me.aqua_tuor.arenawars.Items;

import me.aqua_tuor.arenawars.managers.GameManager;
import me.aqua_tuor.arenawars.managers.PlayerState;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

import java.util.Objects;

public class CustomItemListeners implements Listener {

    private GameManager gameManager;

    public CustomItemListeners(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @EventHandler
    public void onPlayerFishingRodUse(PlayerFishEvent event) {
        Player player = event.getPlayer();
        int itemCustomModelData;
        // Get the item in the player's hand custom model data
        if (player.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()) {
            itemCustomModelData = Objects.requireNonNull(player.getInventory().getItemInMainHand().getItemMeta()).getCustomModelData();
        } else {
            return;
        }

        // Check if the player is in the Arena
        if (gameManager.getPlayerManager().getPlayerState(player) == PlayerState.INARENA || player.getGameMode() == GameMode.CREATIVE) {

            // Check if the item is a grappling hook
            if (itemCustomModelData == CustomItemEnum.GRAPPLING_HOOK.getCustomModelData()) {
                // Multiply rod velocity by 2
                event.getHook().setVelocity(event.getHook().getVelocity().multiply(2));
                if (event.getState() == PlayerFishEvent.State.IN_GROUND || event.getState() == PlayerFishEvent.State.CAUGHT_ENTITY) {
                    Location playerLocation = player.getLocation();
                    Location hookLocation = event.getHook().getLocation();
                    Location changeLocation = hookLocation.subtract(playerLocation);
                    player.setVelocity(changeLocation.toVector().multiply(0.3));
                }
            }

        }
    }

}
