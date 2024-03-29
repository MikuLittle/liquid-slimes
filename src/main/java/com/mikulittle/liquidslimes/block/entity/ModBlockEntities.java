package com.mikulittle.liquidslimes.block.entity;

import com.mikulittle.liquidslimes.LiquidSlimes;
import com.mikulittle.liquidslimes.block.ModBlocks;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
        DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, LiquidSlimes.MODID);

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }

    public static final RegistryObject<BlockEntityType<CoreHolderEntity>> CORE_HOLDER_BE =
        BLOCK_ENTITIES.register("core_holder_be",
            () -> BlockEntityType.Builder.of(
                CoreHolderEntity::new,
                ModBlocks.CORE_HOLDER.get()
                ).build(null)
        );
}
