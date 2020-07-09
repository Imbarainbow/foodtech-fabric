package com.teamfish.foodtech.crops;

import com.teamfish.foodtech.block.AllTheBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;

import javax.swing.text.html.BlockView;

public class testcrop extends CropBlock {
    private static final VoxelShape[] AGE_TO_SHAPE = new VoxelShape[] {
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D,16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 5.0D,16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 7.0D,16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 9.0D,16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 12.0D,16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 15.0D,16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D,16.0D),};

    public testcrop(Settings settings) {
        super(settings);
    }

    protected ItemConvertible getSeedsItem() { return AllTheBlocks.test_crop; };

    protected VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ePos) {
        return AGE_TO_SHAPE[(Integer)state.get(this.getAgeProperty())];
    }
}