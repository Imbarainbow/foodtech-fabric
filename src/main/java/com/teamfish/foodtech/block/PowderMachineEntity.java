package com.teamfish.foodtech.block;

import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.FurnaceScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

public class PowderMachineEntity extends AbstractFurnaceBlockEntity {
    public PowderMachineEntity() {
        super(BlockEntityType.FURNACE, RecipeType.SMELTING);
    }

    protected Text getContainerName() {
        return new TranslatableText("container.furnace");
    }

    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new FurnaceScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }
}