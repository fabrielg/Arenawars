package me.aqua_tuor.arenawars.Items;

import me.aqua_tuor.arenawars.kits.Kit;
import me.aqua_tuor.arenawars.managers.GameManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;

public class ItemsManager {

    private GameManager gameManager;
    private HashMap<CustomItemEnum, CustomItem> customItems;

    public ItemsManager(GameManager gameManager) {
        this.gameManager = gameManager;
        this.customItems = new HashMap<>();
        initItems();
    }

    public void initItems() {
        // Init all items

        // Grappling hook
        createGrapplingHook();
    }

    private void createGrapplingHook() {
        CustomItem grapplingHook;

        CustomItemEnum customItemEnum = CustomItemEnum.GRAPPLING_HOOK;

        ItemStack itemStack = new ItemStack(Material.FISHING_ROD);
        ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.setDisplayName("§7Grappling Hook");
        itemMeta.setLore(new ArrayList<String>() {{
            add("§8Right click to use");
        }});

        // Set setCustomModelData
        itemMeta.setCustomModelData(customItemEnum.getCustomModelData());

        itemMeta.setUnbreakable(true);

        itemStack.setItemMeta(itemMeta);

        grapplingHook = new CustomItem(customItemEnum, itemStack);
        System.out.println("Grappling hook created");
        System.out.println(grapplingHook);

        // Add the item to the list of custom items
        this.addCustomItem(grapplingHook);
    }

    public HashMap<CustomItemEnum, CustomItem> getCustomItems() {
        return customItems;
    }

    public void addCustomItem(CustomItem customItem) {
        if (customItems.containsKey(customItem.getCustomItemEnum())) {
            customItems.replace(customItem.getCustomItemEnum(), customItem);
        } else {
            customItems.put(customItem.getCustomItemEnum(), customItem);
        }
    }

    public Inventory getItemGui() {
        Inventory inventory = gameManager.getPlugin().getServer().createInventory(null, 54, "Items");
        for (CustomItem customItem : customItems.values()) {
            inventory.addItem(customItem.getItemStack());
        }
        return inventory;
    }

    public void openKitGUI(Player player) {
        player.openInventory(getItemGui());
    }
}
