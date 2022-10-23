package me.aqua_tuor.arenawars.Items;

import org.bukkit.inventory.ItemStack;

public class CustomItem {

    private CustomItemEnum customItemEnum;
    private ItemStack itemStack;

    public CustomItem(CustomItemEnum customItemEnum, ItemStack itemStack) {
        this.customItemEnum = customItemEnum;
        this.itemStack = itemStack;
    }

    public CustomItemEnum getCustomItemEnum() {
        return customItemEnum;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

}
