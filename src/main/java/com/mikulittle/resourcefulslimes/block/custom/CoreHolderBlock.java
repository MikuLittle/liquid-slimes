package com.mikulittle.resourcefulslimes.block.custom;

import javax.annotation.Nullable;

import com.mikulittle.resourcefulslimes.block.entity.CoreHolderEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class CoreHolderBlock extends BaseEntityBlock {

    public CoreHolderBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    @Nullable
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new CoreHolderEntity(pPos, pState);
    }

    // Override invisible default
    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pMovedByPiston) {
        // TODO drop inventory upon block breaking
        super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand,
            BlockHitResult pHit) {
        // TODO implement right click use
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

    @Override
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState,
            BlockEntityType<T> pBlockEntityType) {
        // only do things on server side
        if(pLevel.isClientSide()) {
            return null;
        }
        // TODO implement custom tick for progres, rather than super
        return super.getTicker(pLevel, pState, pBlockEntityType);
    }

}
