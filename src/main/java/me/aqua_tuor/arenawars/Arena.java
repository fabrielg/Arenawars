package me.aqua_tuor.arenawars;


import org.bukkit.Location;
import org.bukkit.World;

public class Arena {

    private String name;
    private World world;
    private Location lobby;
    private Location[] region;

    public Arena(String name, World world, Location lobby, Location[] region) {
        this.name = name;
        this.world = world;
        this.lobby = lobby;
        this.region = region;
    }

    /** @return name of the arena */
    public String getName() {
        return name;
    }

    /** @return world of the arena */
    public World getWorld() {
        return world;
    }

    /** @return lobby of the arena */
    public Location getLobby() {
        return lobby;
    }

    /** @return region of the arena */
    public Location[] getRegion() {
        return region;
    }
}
