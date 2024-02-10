package com.mikulittle.resourcefulslimes.item;

import com.mikulittle.resourcefulslimes.ResourcefulSlimes;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, ResourcefulSlimes.MODID);

    public static final RegistryObject<Item> SLIME_CORE =
        ITEMS.register("slime_core",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
