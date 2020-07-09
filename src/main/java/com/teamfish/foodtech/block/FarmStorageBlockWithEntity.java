package com.teamfish.foodtech.block;

import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.block.pattern.BlockPatternBuilder;
import net.minecraft.block.pattern.CachedBlockPosition;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.PiglinBrain;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.predicate.block.BlockStatePredicate;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class FarmStorageBlockWithEntity extends BlockWithEntity {

    public FarmStorageBlockWithEntity(Settings settings) {
        super(settings);
    }

    private static BlockPattern FarmStoragePattern = null;

    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);
        if(!world.isClient) {
            BlockPattern blockPattern = getFarmStoragePattern();
            BlockPattern.Result result = blockPattern.searchAround(world, pos);
            if (result != null) {
                System.out.println("[FoodTech]:MultiBlock Structure completed");
            }
        }
    }

    private static BlockPattern getFarmStoragePattern() {
        if (FarmStoragePattern == null) {
            FarmStoragePattern = BlockPatternBuilder.start()
                    .aisle("###","###","###")
                    .aisle("$$$","$$$","$$$")
                    .aisle("###","###","###")
                    .where('$', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(Blocks.DIAMOND_BLOCK)))
                    .where('#', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(Blocks.STONE))).build();
        }
        return FarmStoragePattern;
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) {
            return ActionResult.SUCCESS;
        } else {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof FarmStorageBlockEntity && FarmStoragePattern != null) {
                player.openHandledScreen((FarmStorageBlockEntity)blockEntity);
                player.incrementStat(Stats.OPEN_BARREL);
                PiglinBrain.onGoldBlockBroken(player, true);
            }

            return ActionResult.CONSUME;
        }
    }

    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (!state.isOf(newState.getBlock())) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof Inventory) {
                ItemScatterer.spawn(world, pos, (Inventory)blockEntity);
                world.updateComparators(pos, this);
            }

            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new FarmStorageBlockEntity();
    }
}
