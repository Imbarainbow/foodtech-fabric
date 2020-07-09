package com.teamfish.foodtech.armor;

import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AllTheArmors implements ModInitializer {

    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("foodtech", "vege_helmet"), VEGE_HELMET);
        Registry.register(Registry.ITEM, new Identifier("foodtech", "vege_chestplate"), VEGE_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("foodtech", "vege_leggings"), VEGE_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("foodtech", "vege_boots"), VEGE_BOOTS);
        Registry.register(Registry.ITEM, new Identifier("foodtech", "meat_helmet"), MEAT_HELMET);
        Registry.register(Registry.ITEM, new Identifier("foodtech", "meat_chestplate"), MEAT_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("foodtech", "meat_leggings"), MEAT_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("foodtech", "meat_boots"), MEAT_BOOTS);
        Registry.register(Registry.ITEM, new Identifier("foodtech", "supreme_helmet"), SUPREME_HELMET);
        Registry.register(Registry.ITEM, new Identifier("foodtech", "supreme_chestplate"), SUPREME_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("foodtech", "supreme_leggings"), SUPREME_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("foodtech", "supreme_boots"), SUPREME_BOOTS);
    }

    public static ArmorItem VEGE_HELMET = new ArmorItem(ArmorMaterials.vege, EquipmentSlot.HEAD, new Item.Settings());
    public static ArmorItem VEGE_CHESTPLATE = new ArmorItem(ArmorMaterials.vege, EquipmentSlot.CHEST, new Item.Settings());
    public static ArmorItem VEGE_LEGGINGS = new ArmorItem(ArmorMaterials.vege, EquipmentSlot.LEGS, new Item.Settings());
    public static ArmorItem VEGE_BOOTS = new ArmorItem(ArmorMaterials.vege, EquipmentSlot.FEET, new Item.Settings());
    public static ArmorItem MEAT_HELMET = new ArmorItem(ArmorMaterials.meat, EquipmentSlot.HEAD, new Item.Settings());
    public static ArmorItem MEAT_CHESTPLATE= new ArmorItem(ArmorMaterials.meat, EquipmentSlot.CHEST, new Item.Settings());
    public static ArmorItem MEAT_LEGGINGS = new ArmorItem(ArmorMaterials.meat, EquipmentSlot.LEGS, new Item.Settings());
    public static ArmorItem MEAT_BOOTS = new ArmorItem(ArmorMaterials.meat, EquipmentSlot.FEET, new Item.Settings());
    public static ArmorItem SUPREME_HELMET = new ArmorItem(ArmorMaterials.supreme, EquipmentSlot.HEAD, new Item.Settings());
    public static ArmorItem SUPREME_CHESTPLATE= new ArmorItem(ArmorMaterials.supreme, EquipmentSlot.CHEST, new Item.Settings());
    public static ArmorItem SUPREME_LEGGINGS = new ArmorItem(ArmorMaterials.supreme, EquipmentSlot.LEGS, new Item.Settings());
    public static ArmorItem SUPREME_BOOTS = new ArmorItem(ArmorMaterials.supreme, EquipmentSlot.FEET, new Item.Settings());
}
