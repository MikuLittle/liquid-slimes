package com.mikulittle.resourcefulslimes.block;

import java.util.function.Supplier;

import com.mikulittle.resourcefulslimes.ResourcefulSlimes;
import com.mikulittle.resourcefulslimes.item.ModItems;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
        DeferredRegister.create(ForgeRegistries.BLOCKS, ResourcefulSlimes.MODID);

    public static final RegistryObject<Block> CORE_HOLDER = registerBlock("core_holder",
    () -> new Block(BlockBehaviour.Properties.of()));

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
