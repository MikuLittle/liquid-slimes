package com.mikulittle.liquidslimes.block.entity;

import javax.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class CoreHolderEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler ITEM_STACK_HANDLER =  new ItemStackHandler(1);
    private static final int INPUT_SLOT = 0;

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    public CoreHolderEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.CORE_HOLDER_BE.get(), pPos, pBlockState);
    }

    @Override
    public <T> @NotNull LazyOptional<T> getCapability(@NotNull Capability<T> cap,
            @org.jetbrains.annotations.Nullable Direction side) {
        if(cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> ITEM_STACK_HANDLER);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    @Nullable
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createMenu'");
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.liquid_slimes.core_holder");
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", ITEM_STACK_HANDLER.serializeNBT());
        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        ITEM_STACK_HANDLER.deserializeNBT(pTag.getCompound("inventory"));
    }

}
