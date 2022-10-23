package me.aqua_tuor.arenawars.Items;

public enum CustomItemEnum {

    GRAPPLING_HOOK(1);

    private int customModelData;

    CustomItemEnum(int customModelData) {
        this.customModelData = customModelData;
    }

    public int getCustomModelData() {
        return customModelData;
    }

}
