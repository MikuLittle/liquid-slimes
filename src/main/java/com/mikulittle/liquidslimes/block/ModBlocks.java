package com.mikulittle.liquidslimes.block;

import java.util.function.Supplier;

import com.mikulittle.liquidslimes.LiquidSlimes;
import com.mikulittle.liquidslimes.block.custom.CoreHolderBlock;
import com.mikulittle.liquidslimes.item.ModItems;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
        DeferredRegister.create(ForgeRegistries.BLOCKS, LiquidSlimes.MODID);

    public static final RegistryObject<Block> CORE_HOLDER = registerBlock("core_holder",
    () -> new CoreHolderBlock(
        BlockBehaviour.Properties.of()
        .sound(SoundType.GLASS)
        .strength(4.0f, 5.0f)
        .requiresCorrectToolForDrops()
    ));

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> reg = BLOCKS.register(name, block);
        registerBlockItem(name, reg);
        return reg;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
