package com.epicmod.creativemodetab;

import com.epicmod.Epicmod;
import com.epicmod.block.ModBlocks;
import com.epicmod.item.ModItems;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTabs {
    public static final CreativeModeTab FOOD_ITEM_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath(Epicmod.MOD_ID, "food_items"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModItems.FOOD))
                    .title(Component.translatable("creativemodetab.epicmod.food_items"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.FOOD);
                        output.accept(ModItems.CHISEL);

                    }).build());

    public static final CreativeModeTab BALL_ITEM_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath(Epicmod.MOD_ID, "ball_items"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BALL))
                    .title(Component.translatable("creativemodetab.epicmod.ball_items"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.BALL);


                    }).build());

    public static final CreativeModeTab FOOD_BLOCK_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath(Epicmod.MOD_ID, "food_block_items"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.FOOD_BLOCK))
                    .title(Component.translatable("creativemodetab.epicmod.food_block_items"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.FOOD_BLOCK);


                    }).build());

    public static final CreativeModeTab BALL_BLOCK_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath(Epicmod.MOD_ID, "ball_block_items"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.BALL_BLOCK))
                    .title(Component.translatable("creativemodetab.epicmod.ball_block_items"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.BALL_BLOCK);


                    }).build());


    public static void registerModCreativeModeTabs() {
        Epicmod.LOGGER.info("Registering Creative Mode Tabs for " + Epicmod.MOD_ID);
    }
}
