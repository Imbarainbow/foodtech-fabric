package com.teamfish.foodtech;

import com.teamfish.foodtech.armor.MeatArmor;
import com.teamfish.foodtech.armor.SupremeArmor;
import com.teamfish.foodtech.armor.VegeArmor;
import com.teamfish.foodtech.crops.testcrop;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class FoodTech implements ModInitializer {

	@Override
	public void onInitialize() {

		BlockRenderLayerMap.INSTANCE.putBlock(test_crop, RenderLayer.getCutout());

		Registry.register(Registry.BLOCK, new Identifier("foodtech", "test_crop"), test_crop);
		Registry.register(Registry.ITEM, new Identifier("foodtech", "test_crop"), new BlockItem(test_crop, new Item.Settings().group(FT_GENERAL)));
		Registry.register(Registry.BLOCK, new Identifier("foodtech", "basic_ore"), BASIC_ORE);
		Registry.register(Registry.ITEM, new Identifier("foodtech", "basic_ore"), new BlockItem(BASIC_ORE, new Item.Settings().group(FT_GENERAL)));

		Registry.register(Registry.ITEM, new Identifier("foodtech", "meat_ingot"), meat_ingot);
		Registry.register(Registry.ITEM, new Identifier("foodtech", "vege_ingot"), vege_ingot);
		Registry.register(Registry.ITEM, new Identifier("foodtech", "basic_ingot"), basic_ingot);
		Registry.register(Registry.ITEM, new Identifier("foodtech", "supreme_ingot"), supreme_ingot);
		Registry.register(Registry.ITEM, new Identifier("foodtech", "compressed_basiccrop"), compressed_basiccrop);
		Registry.register(Registry.ITEM, new Identifier("foodtech", "compressed_meat"), compressed_meat);
		Registry.register(Registry.ITEM, new Identifier("foodtech", "compressed_vege"), compressed_vege);
		Registry.register(Registry.ITEM, new Identifier("foodtech", "meat_core"), meat_core);
		Registry.register(Registry.ITEM, new Identifier("foodtech", "vege_core"), vege_core);

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

		//Loop over existing biomes
		Registry.BIOME.forEach(this::handleBiome);

		//Listen for other biomes being registered
		RegistryEntryAddedCallback.event(Registry.BIOME).register((i, identifier, biome) -> handleBiome(biome));

		System.out.println("Hello Fabric world!");
	}

	public static final ItemGroup FT_GENERAL = FabricItemGroupBuilder.build(
			new Identifier("foodtech", "item"),
			() -> new ItemStack(Items.STICK));

	public static final ItemGroup FT_ARMOR = FabricItemGroupBuilder.build(
			new Identifier("foodtech", "armor"),
			() -> new ItemStack(Items.IRON_CHESTPLATE));

	public static Block BASIC_ORE = new Block(FabricBlockSettings.of(Material.METAL).hardness(4.0f));
	public static Block test_crop = new testcrop(FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));

	public static final Item meat_ingot = new Item((new Item.Settings()).group(FT_GENERAL));
	public static final Item vege_ingot = new Item((new Item.Settings()).group(FT_GENERAL));
	public static final Item basic_ingot = new Item((new Item.Settings()).group(FT_GENERAL));
	public static final Item supreme_ingot = new Item((new Item.Settings()).group(FT_GENERAL));
	public static final Item compressed_meat = new Item((new Item.Settings()).group(FT_GENERAL));
	public static final Item compressed_vege= new Item((new Item.Settings()).group(FT_GENERAL));
	public static final Item compressed_basiccrop = new Item((new Item.Settings()).group(FT_GENERAL));
	public static final Item meat_core = new Item((new Item.Settings()).group(FT_GENERAL));
	public static final Item vege_core = new Item((new Item.Settings()).group(FT_GENERAL));

	public static ArmorItem VEGE_HELMET = new ArmorItem(VegeArmor.vege, EquipmentSlot.HEAD, new Item.Settings().group(FT_ARMOR));
	public static ArmorItem VEGE_CHESTPLATE = new ArmorItem(VegeArmor.vege, EquipmentSlot.CHEST, new Item.Settings().group(FT_ARMOR));
	public static ArmorItem VEGE_LEGGINGS = new ArmorItem(VegeArmor.vege, EquipmentSlot.LEGS, new Item.Settings().group(FT_ARMOR));
	public static ArmorItem VEGE_BOOTS = new ArmorItem(VegeArmor.vege, EquipmentSlot.FEET, new Item.Settings().group(FT_ARMOR));
	public static ArmorItem MEAT_HELMET = new ArmorItem(MeatArmor.meat, EquipmentSlot.HEAD, new Item.Settings().group(FT_ARMOR));
	public static ArmorItem MEAT_CHESTPLATE= new ArmorItem(MeatArmor.meat, EquipmentSlot.CHEST, new Item.Settings().group(FT_ARMOR));
	public static ArmorItem MEAT_LEGGINGS = new ArmorItem(MeatArmor.meat, EquipmentSlot.LEGS, new Item.Settings().group(FT_ARMOR));
	public static ArmorItem MEAT_BOOTS = new ArmorItem(MeatArmor.meat, EquipmentSlot.FEET, new Item.Settings().group(FT_ARMOR));
	public static ArmorItem SUPREME_HELMET = new ArmorItem(SupremeArmor.supreme, EquipmentSlot.HEAD, new Item.Settings().group(FT_ARMOR));
	public static ArmorItem SUPREME_CHESTPLATE= new ArmorItem(SupremeArmor.supreme, EquipmentSlot.CHEST, new Item.Settings().group(FT_ARMOR));
	public static ArmorItem SUPREME_LEGGINGS = new ArmorItem(SupremeArmor.supreme, EquipmentSlot.LEGS, new Item.Settings().group(FT_ARMOR));
	public static ArmorItem SUPREME_BOOTS = new ArmorItem(SupremeArmor.supreme, EquipmentSlot.FEET, new Item.Settings().group(FT_ARMOR));

	private void handleBiome(Biome biome) {
		if(biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND) {
			biome.addFeature(
					GenerationStep.Feature.UNDERGROUND_ORES,
					Feature.ORE.configure(
							new OreFeatureConfig(
									OreFeatureConfig.Target.NATURAL_STONE,
									BASIC_ORE.getDefaultState(),
									4 //Ore vein size
							)).createDecoratedFeature(
							Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(
									4, //Number of veins per chunk
									0, //Bottom Offset
									0, //Min y level
									64 //Max y level
							))));
		}
	}

}
