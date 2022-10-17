package me.aqua_tuor.arenawars.managers;

import Items.ItemsManager;
import me.aqua_tuor.arenawars.Arenawars;
import me.aqua_tuor.arenawars.kits.Kit;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class GameManager {

    private final Arenawars plugin;
    private BlockManager blockManager;
    private PlayerManager playerManager;
    private KitManager kitManager;
    private ArenaManager arenaManager;
    private ItemsManager itemsManager;

    public String prefix = "§8[§6ArenaWars§8]§r ";

    public GameManager(Arenawars plugin) {
        this.plugin = plugin;
        this.blockManager = new BlockManager(this);
        this.playerManager = new PlayerManager(this, new HashMap<Player, Kit>(), new HashMap<Player, PlayerState>());
        this.kitManager = new KitManager(this);
        this.arenaManager = new ArenaManager(this);
        this.itemsManager = new ItemsManager(this);
    }

    public BlockManager getBlockManager() {
        return blockManager;
    }

    public PlayerManager getPlayerManager() {
        return playerManager;
    }

    public KitManager getKitManager() {
        return kitManager;
    }

    public ArenaManager getArenaManager() {
        return arenaManager;
    }

    public String getPrefix() {
        return prefix;
    }

    public Arenawars getPlugin() {
        return plugin;
    }

    public ItemsManager getItemsManager() {
        return itemsManager;
    }

}