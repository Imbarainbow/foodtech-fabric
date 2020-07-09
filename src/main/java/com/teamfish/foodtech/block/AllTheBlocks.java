package com.teamfish.foodtech.block;

import com.teamfish.foodtech.crops.testcrop;
import com.teamfish.foodtech.item.CustomFoodComponents;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AllTheBlocks implements ModInitializer {

    public void onInitialize() {

        BlockRenderLayerMap.INSTANCE.putBlock(test_crop, RenderLayer.getCutout());

        Registry.register(Registry.BLOCK, new Identifier("foodtech", "powder_machine"), powder_machine);
        Registry.register(Registry.ITEM, new Identifier("foodtech", "powder_machine"), new BlockItem(powder_machine, new Item.Settings()));
        Registry.register(Registry.BLOCK, new Identifier("foodtech", "farm_storage"), farm_storage);
        Registry.register(Registry.ITEM, new Identifier("foodtech", "farm_storage"), new BlockItem(farm_storage, new Item.Settings()));
        Registry.register(Registry.BLOCK, new Identifier("foodtech", "test_crop"), test_crop);
        Registry.register(Registry.ITEM, new Identifier("foodtech", "test_crop"), new BlockItem(test_crop, new Item.Settings().food(CustomFoodComponents.test_crop)));
        Registry.register(Registry.BLOCK, new Identifier("foodtech", "basic_ore"), BASIC_ORE);
        Registry.register(Registry.ITEM, new Identifier("foodtech", "basic_ore"), new BlockItem(BASIC_ORE, new Item.Settings()));
    }

    public static Block powder_machine = new PowderMachine(FabricBlockSettings.of(Material.METAL).hardness(4.0f));
    public static Block farm_storage = new FarmStorageBlockWithEntity(FabricBlockSettings.of(Material.METAL).hardness(4.0f));
    public static Block BASIC_ORE = new Block(FabricBlockSettings.of(Material.METAL).hardness(4.0f));
    public static Block test_crop = new testcrop(FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));
}
