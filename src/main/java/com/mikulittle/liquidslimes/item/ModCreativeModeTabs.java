package com.mikulittle.liquidslimes.item;

import com.mikulittle.liquidslimes.LiquidSlimes;
import com.mikulittle.liquidslimes.block.ModBlocks;

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
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LiquidSlimes.MODID);

    @SuppressWarnings("null")
    public static final RegistryObject<CreativeModeTab> liquid_slimes_TAB =
        CREATIVE_MODE_TABS.register("liquid_slimes",
        () -> CreativeModeTab.builder()
        .icon(() -> new ItemStack(ModItems.SLIME_CORE.get()))
        .title(Component.translatable("creativetab.liquid_slimes_tab"))
        .displayItems((pParameters, pOutput) -> {
            pOutput.accept(ModItems.SLIME_CORE.get());
            pOutput.accept(Items.SLIME_BALL);
            pOutput.accept(ModBlocks.CORE_HOLDER.get());
        })
        .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
