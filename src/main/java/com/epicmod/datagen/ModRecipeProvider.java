package com.epicmod.datagen;

import com.epicmod.block.ModBlocks;
import com.epicmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new RecipeProvider(registries, output) {
            @Override
            public void buildRecipes() {
                List<ItemLike> FOOD_SMELTABLES = List.of(ModItems.FOOD);

                oreSmelting(FOOD_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.FOOD, 0.25f, 200, "food");
                oreBlasting(FOOD_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.FOOD, 0.25f, 100, "food");

                nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.FOOD, RecipeCategory.BUILDING_BLOCKS, ModBlocks.FOOD_BLOCK);

                shaped(RecipeCategory.MISC, ModBlocks.BALL_BLOCK)
                        .pattern("RRR")
                        .pattern("RRR")
                        .pattern("RRR")
                        .define('R', ModItems.BALL)
                        .unlockedBy(getHasName(ModItems.BALL), has(ModItems.BALL))
                        .group("ball")
                        .save(output, "ball_block_from_ball");

                shaped(RecipeCategory.MISC, ModBlocks.FOOD_BLOCK)
                        .pattern("RRR")
                        .pattern("RRR")
                        .pattern("RRR")
                        .define('R', ModItems.FOOD)
                        .unlockedBy(getHasName(ModItems.FOOD), has(ModItems.FOOD))
                        .group("food")
                        .save(output, "food_block_from_food");

                shapeless(RecipeCategory.MISC, ModItems.FOOD, 9)
                        .requires(ModBlocks.FOOD_BLOCK)
                        .unlockedBy(getHasName(ModBlocks.FOOD_BLOCK), has(ModBlocks.FOOD_BLOCK))
                        .group("food")
                        .save(output, "food_from_food_block");

                shapeless(RecipeCategory.MISC, ModItems.BALL, 9)
                        .requires(ModBlocks.BALL_BLOCK)
                        .unlockedBy(getHasName(ModBlocks.BALL_BLOCK), has(ModBlocks.BALL_BLOCK))
                        .group("ball")
                        .save(output, "ball_from_ball_block");


            }
        };
    }

    @Override
    public String getName() {
        return "Epicmod Recipes";
    }
}
