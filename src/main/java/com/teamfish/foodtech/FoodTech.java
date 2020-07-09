package com.teamfish.foodtech;

import com.teamfish.foodtech.armor.AllTheArmors;
import com.teamfish.foodtech.block.AllTheBlocks;
import com.teamfish.foodtech.item.AllTheItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;

public class FoodTech implements ModInitializer {

	public void onInitialize() {
	}

	public static final ItemGroup OTHER_GROUP = FabricItemGroupBuilder.create(
			new Identifier("foodtech", "general")).icon(() -> {
				return new ItemStack(Items.BOWL);
			}).appendItems(stacks -> {
				stacks.add(new ItemStack(AllTheArmors.MEAT_HELMET));
				stacks.add(new ItemStack(AllTheArmors.MEAT_CHESTPLATE));
				stacks.add(new ItemStack(AllTheArmors.MEAT_LEGGINGS));
				stacks.add(new ItemStack(AllTheArmors.MEAT_BOOTS));
				stacks.add(new ItemStack(AllTheArmors.VEGE_HELMET));
				stacks.add(new ItemStack(AllTheArmors.VEGE_CHESTPLATE));
				stacks.add(new ItemStack(AllTheArmors.VEGE_LEGGINGS));
				stacks.add(new ItemStack(AllTheArmors.VEGE_BOOTS));
				stacks.add(new ItemStack(AllTheArmors.SUPREME_HELMET));
				stacks.add(new ItemStack(AllTheArmors.SUPREME_CHESTPLATE));
				stacks.add(new ItemStack(AllTheArmors.SUPREME_LEGGINGS));
				stacks.add(new ItemStack(AllTheArmors.SUPREME_BOOTS));
				stacks.add(new ItemStack(AllTheItems.meat_core));
				stacks.add(new ItemStack(AllTheItems.meat_ingot));
				stacks.add(new ItemStack(AllTheItems.compressed_meat));
				stacks.add(new ItemStack(AllTheItems.vege_core));
				stacks.add(new ItemStack(AllTheItems.vege_ingot));
				stacks.add(new ItemStack(AllTheItems.compressed_vege));
				stacks.add(new ItemStack(AllTheItems.compressed_basiccrop));
				stacks.add(new ItemStack(AllTheItems.supreme_ingot));
				stacks.add(new ItemStack(AllTheItems.basic_ingot));
				stacks.add(new ItemStack(AllTheBlocks.test_crop));
				stacks.add(new ItemStack(AllTheBlocks.BASIC_ORE));
				stacks.add(new ItemStack(AllTheItems.VEGE_AXE));
				stacks.add(new ItemStack(AllTheItems.VEGE_PICKAXE));
				stacks.add(new ItemStack(AllTheItems.VEGE_HOE));
				stacks.add(new ItemStack(AllTheItems.VEGE_SHOVEL));
				stacks.add(new ItemStack(AllTheItems.VEGE_SWORD));
				stacks.add(new ItemStack(AllTheItems.MEAT_AXE));
				stacks.add(new ItemStack(AllTheItems.MEAT_PICKAXE));
				stacks.add(new ItemStack(AllTheItems.MEAT_HOE));
				stacks.add(new ItemStack(AllTheItems.MEAT_SHOVEL));
				stacks.add(new ItemStack(AllTheItems.MEAT_SWORD));
				stacks.add(new ItemStack(AllTheItems.SUPREME_AXE));
				stacks.add(new ItemStack(AllTheItems.SUPREME_PICKAXE));
				stacks.add(new ItemStack(AllTheItems.SUPREME_HOE));
				stacks.add(new ItemStack(AllTheItems.SUPREME_SHOVEL));
				stacks.add(new ItemStack(AllTheItems.SUPREME_SWORD));
			})
			.build();

}
