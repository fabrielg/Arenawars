package me.aqua_tuor.arenawars.listeners;

import me.aqua_tuor.arenawars.managers.GameManager;
import me.aqua_tuor.arenawars.managers.PlayerState;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerJoinQuitListener implements Listener {

    private GameManager gameManager;

    public PlayerJoinQuitListener(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        // Cancel join message
        event.setJoinMessage(null);

        // Get the player
        Player player = event.getPlayer();

        // Join message
        Bukkit.broadcastMessage("§7[§a+§7] " + player.getName());

        // Check if the player is OP
        if (player.isOp()) {
            return;
        }

        // Teleport the player to the lobby
        // Give the player the kit selector
        // Set the player's gamemode to survival, their health and food to max
        // Set PlayerState to LOBBY and the kit to default
        player.teleport(gameManager.getArenaManager().getArena().getLobby());
        gameManager.getPlayerManager().setPlayerStuffWhenJoin(player);
        gameManager.getPlayerManager().addPlayerState(player, PlayerState.LOBBY);
        gameManager.getPlayerManager().addPlayerKit(player, gameManager.getKitManager().getDefaultKit());

    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        // Cancel quit message
        event.setQuitMessage(null);

        // Get the player
        Player player = event.getPlayer();

        // Leave message
        Bukkit.broadcastMessage("§7[§c-§7] " + player.getName());

        // Remove the player from the playerState HashMap
        gameManager.getPlayerManager().getPlayerState().remove(player);
    }

}
