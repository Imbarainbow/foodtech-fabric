package com.teamfish.foodtech.block;

import com.teamfish.foodtech.FoodTech;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.block.pattern.BlockPatternBuilder;
import net.minecraft.block.pattern.CachedBlockPosition;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.predicate.block.BlockStatePredicate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;


public class FarmStorageBlockEntity extends LootableContainerBlockEntity {
    public DefaultedList<ItemStack> inv;
    public static BlockEntityType<FarmStorageBlockEntity> abe = Registry.register(Registry.BLOCK_ENTITY_TYPE, "test.abe", BlockEntityType.Builder.create(FarmStorageBlockEntity::new,AllTheBlocks.farm_storage).build(null));

    public FarmStorageBlockEntity() {
        this(abe);
    }

    protected  FarmStorageBlockEntity(BlockEntityType<?> blockEntityType) {
        super(blockEntityType);
        inv = DefaultedList.ofSize(27, ItemStack.EMPTY);
    }

    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);
        if (!this.serializeLootTable(tag)) {
            Inventories.toTag(tag, this.inv);
        }

        return tag;
    }

    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        this.inv = DefaultedList.ofSize(this.size(), ItemStack.EMPTY);
        if (!this.deserializeLootTable(tag)) {
            Inventories.fromTag(tag, this.inv);
        }

    }

    @Override
    protected DefaultedList<ItemStack> getInvStackList() {
        return inv;
    }

    @Override
    protected void setInvStackList(DefaultedList<ItemStack> list) {
        inv = list;
    }

    @Override
    protected Text getContainerName() {
        return new TranslatableText("f.aaa");
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new GUIHandler(ScreenHandlerType.GENERIC_9X3, 1, playerInventory,this, 3);
    }

    @Override
    public int size() {
        return 27;
    }
}
