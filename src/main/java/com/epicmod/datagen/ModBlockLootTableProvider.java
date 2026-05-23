package com.epicmod.datagen;

import com.epicmod.block.ModBlocks;
import com.epicmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootSubProvider {
    public ModBlockLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {
        dropSelf(ModBlocks.FOOD_BLOCK);
        dropSelf(ModBlocks.BALL_BLOCK);

        add(ModBlocks.FOOD_BLOCK, createOreDrop(ModBlocks.FOOD_BLOCK, ModItems.FOOD));
        add(ModBlocks.BALL_BLOCK, createOreDrop(ModBlocks.BALL_BLOCK, ModItems.BALL));

        dropSelf(ModBlocks.MAGIC_BLOCK);
    }
}
