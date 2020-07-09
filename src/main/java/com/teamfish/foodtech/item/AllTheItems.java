package com.teamfish.foodtech.item;

import com.teamfish.foodtech.tools.CustomAxe;
import com.teamfish.foodtech.tools.CustomHoe;
import com.teamfish.foodtech.tools.CustomPickaxe;
import com.teamfish.foodtech.tools.ToolMaterials;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AllTheItems implements ModInitializer {

    public void onInitialize() {

        Registry.register(Registry.ITEM, new Identifier("foodtech", "vege_shovel"), VEGE_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("foodtech", "vege_sword"), VEGE_SWORD);
        Registry.register(Registry.ITEM, new Identifier("foodtech", "vege_hoe"), VEGE_HOE);
        Registry.register(Registry.ITEM, new Identifier("foodtech", "vege_axe"), VEGE_AXE);
        Registry.register(Registry.ITEM, new Identifier("foodtech", "vege_pickaxe"), VEGE_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("foodtech", "meat_shovel"), MEAT_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("foodtech", "meat_sword"), MEAT_SWORD);
        Registry.register(Registry.ITEM, new Identifier("foodtech", "meat_hoe"), MEAT_HOE);
        Registry.register(Registry.ITEM, new Identifier("foodtech", "meat_axe"), MEAT_AXE);
        Registry.register(Registry.ITEM, new Identifier("foodtech", "meat_pickaxe"), MEAT_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("foodtech", "supreme_shovel"), SUPREME_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("foodtech", "supreme_sword"), SUPREME_SWORD);
        Registry.register(Registry.ITEM, new Identifier("foodtech", "supreme_hoe"), SUPREME_HOE);
        Registry.register(Registry.ITEM, new Identifier("foodtech", "supreme_axe"), SUPREME_AXE);
        Registry.register(Registry.ITEM, new Identifier("foodtech", "supreme_pickaxe"), SUPREME_PICKAXE);

        Registry.register(Registry.ITEM, new Identifier("foodtech", "meat_ingot"), meat_ingot);
        Registry.register(Registry.ITEM, new Identifier("foodtech", "vege_ingot"), vege_ingot);
        Registry.register(Registry.ITEM, new Identifier("foodtech", "basic_ingot"), basic_ingot);
        Registry.register(Registry.ITEM, new Identifier("foodtech", "supreme_ingot"), supreme_ingot);
        Registry.register(Registry.ITEM, new Identifier("foodtech", "compressed_basiccrop"), compressed_basiccrop);
        Registry.register(Registry.ITEM, new Identifier("foodtech", "compressed_meat"), compressed_meat);
        Registry.register(Registry.ITEM, new Identifier("foodtech", "compressed_vege"), compressed_vege);
        Registry.register(Registry.ITEM, new Identifier("foodtech", "meat_core"), meat_core);
        Registry.register(Registry.ITEM, new Identifier("foodtech", "vege_core"), vege_core);

    }

    public static ToolItem VEGE_SHOVEL = new ShovelItem(ToolMaterials.vege, 1, 1.0F, new Item.Settings());
    public static ToolItem VEGE_SWORD = new SwordItem(ToolMaterials.vege, 3, 1.0F, new Item.Settings());
    public static ToolItem VEGE_HOE = new CustomHoe(ToolMaterials.vege, 1, 1.0F, new Item.Settings());
    public static ToolItem VEGE_AXE = new CustomAxe(ToolMaterials.vege, 1, 1.0F, new Item.Settings());
    public static ToolItem VEGE_PICKAXE = new CustomPickaxe(ToolMaterials.vege, 1, 1.0F, new Item.Settings());
    public static ToolItem MEAT_SHOVEL = new ShovelItem(ToolMaterials.meat, 1, 1.0F, new Item.Settings());
    public static ToolItem MEAT_SWORD = new SwordItem(ToolMaterials.meat, 3, 1.0F, new Item.Settings());
    public static ToolItem MEAT_HOE = new CustomHoe(ToolMaterials.meat, 1, 1.0F, new Item.Settings());
    public static ToolItem MEAT_AXE = new CustomAxe(ToolMaterials.meat, 1, 1.0F, new Item.Settings());
    public static ToolItem MEAT_PICKAXE = new CustomPickaxe(ToolMaterials.meat, 1, 1.0F, new Item.Settings());
    public static ToolItem SUPREME_SHOVEL = new ShovelItem(ToolMaterials.supreme, 1, 1.0F, new Item.Settings());
    public static ToolItem SUPREME_SWORD = new SwordItem(ToolMaterials.supreme, 3, 1.0F, new Item.Settings());
    public static ToolItem SUPREME_HOE = new CustomHoe(ToolMaterials.supreme, 1, 1.0F, new Item.Settings());
    public static ToolItem SUPREME_AXE = new CustomAxe(ToolMaterials.supreme, 1, 1.0F, new Item.Settings());
    public static ToolItem SUPREME_PICKAXE = new CustomPickaxe(ToolMaterials.supreme, 1, 1.0F, new Item.Settings());

    public static final Item meat_ingot = new Item((new Item.Settings()));
    public static final Item vege_ingot = new Item((new Item.Settings()));
    public static final Item basic_ingot = new Item((new Item.Settings()));
    public static final Item supreme_ingot = new Item((new Item.Settings()));
    public static final Item compressed_meat = new Item((new Item.Settings().food(CustomFoodComponents.compressed_meat)));
    public static final Item compressed_vege= new Item((new Item.Settings().food(CustomFoodComponents.compressed_vege)));
    public static final Item compressed_basiccrop = new Item((new Item.Settings().food(CustomFoodComponents.compressed_basiccrop)));
    public static final Item meat_core = new Item((new Item.Settings()));
    public static final Item vege_core = new Item((new Item.Settings()));


}
