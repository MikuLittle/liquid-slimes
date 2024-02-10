package com.mikulittle.resourcefulslimes.item;

import com.mikulittle.resourcefulslimes.ResourcefulSlimes;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ResourcefulSlimes.MODID);

    @SuppressWarnings("null")
    public static final RegistryObject<CreativeModeTab> RESOURCEFUL_SLIMES_TAB =
        CREATIVE_MODE_TABS.register("resourceful_slimes",
        () -> CreativeModeTab.builder()
        .icon(() -> new ItemStack(ModItems.SLIME_CORE.get()))
        .title(Component.translatable("creativetab.resourceful_slimes_tab"))
        .displayItems((pParameters, pOutput) -> {
            pOutput.accept(ModItems.SLIME_CORE.get());
            pOutput.accept(Items.SLIME_BALL);
        })
        .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
