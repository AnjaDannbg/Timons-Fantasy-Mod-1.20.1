package net.anjadannenberg.fantasymod.datagen;

import net.anjadannenberg.fantasymod.FantasyMod;
import net.anjadannenberg.fantasymod.block.ModBlocks;
import net.anjadannenberg.fantasymod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    private static final List<ItemLike> FIREMETAL_SMELTABLES = List.of(ModItems.RAW_FIREMETAL.get(),
            ModBlocks.FIREMETAL_ORE.get());
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, FIREMETAL_SMELTABLES, RecipeCategory.MISC, ModItems.FIREMETAL_INGOT.get(),
                0.7f, 200, "firemetal_ingot");
        oreBlasting(pWriter, FIREMETAL_SMELTABLES, RecipeCategory.MISC, ModItems.FIREMETAL_INGOT.get(),
                0.7f, 100, "firemetal_ingot");



        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.FIRE_SWORD.get())
                .pattern("#")
                .pattern("#")
                .pattern("!")
                .define('#', ModItems.FIREMETAL_INGOT.get())
                .define('!', Items.STICK)
                .unlockedBy(getHasName(ModItems.FIREMETAL_INGOT.get()), has(ModItems.FIREMETAL_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.FIRE_LONGSWORD.get())
                .pattern("#")
                .pattern("!")
                .define('#', ModItems.FIREMETAL_INGOT.get())
                .define('!', ModItems.FIRE_SWORD.get())
                .unlockedBy(getHasName(ModItems.FIRE_SWORD.get()), has(ModItems.FIRE_SWORD.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.FIREMETAL_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.FIREMETAL_INGOT.get())
                .unlockedBy(getHasName(ModItems.FIREMETAL_INGOT.get()), has(ModItems.FIREMETAL_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_FIREMETAL_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.RAW_FIREMETAL.get())
                .unlockedBy(getHasName(ModItems.RAW_FIREMETAL.get()), has(ModItems.RAW_FIREMETAL.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.FIREMETAL_INGOT.get(), 9)
                .requires(ModBlocks.FIREMETAL_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.FIREMETAL_BLOCK.get()), has(ModBlocks.FIREMETAL_BLOCK.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_FIREMETAL.get(), 9)
                .requires(ModBlocks.RAW_FIREMETAL_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAW_FIREMETAL_BLOCK.get()), has(ModBlocks.RAW_FIREMETAL_BLOCK.get()))
                .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, FantasyMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
