package me.aqua_tuor.arenawars.Items;

import me.aqua_tuor.arenawars.managers.GameManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ItemsCommand implements CommandExecutor {

    private final GameManager gameManager;

    public ItemsCommand(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        gameManager.getItemsManager().openKitGUI(player);
        return true;
    }
}
