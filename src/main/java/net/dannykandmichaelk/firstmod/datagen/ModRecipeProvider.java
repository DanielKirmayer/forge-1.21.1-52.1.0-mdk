package net.dannykandmichaelk.firstmod.datagen;

import net.dannykandmichaelk.firstmod.FirstMod;
import net.dannykandmichaelk.firstmod.block.ModBlocks;
import net.dannykandmichaelk.firstmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> CRYONITE_SMELTABLES = List.of(ModItems.RAW_CRYONITE.get(),
                ModBlocks.CRYONITE_ORE.get(), ModBlocks.DEEPSLATE_CRYONITE_ORE.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CRYONITE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.CRYONITE.get())
                .unlockedBy(getHasName(ModItems.CRYONITE.get()), has(ModItems.CRYONITE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TRUMPIUM_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.TRUMPIUM.get())
                .unlockedBy(getHasName(ModItems.TRUMPIUM.get()), has(ModItems.TRUMPIUM.get())).save(pRecipeOutput);



        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CRYONITE_SWORD.get())
                        .pattern("A")
                        .pattern("A")
                        .pattern("B")
                        .define('A', ModItems.CRYONITE.get())
                        .define('B', Items.STICK)
                        .unlockedBy(getHasName(ModItems.CRYONITE.get()), has(ModItems.CRYONITE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CRYONITE_CLAYMORE.get())
                        .pattern("ABA")
                        .pattern(" C ")
                        .pattern(" C ")
                        .define('A', ModBlocks.CRYONITE_BLOCK.get())
                        .define('B', ModItems.CRYONITE.get())
                        .define('C', Items.STICK)
                        .unlockedBy(getHasName(ModItems.CRYONITE.get()), has(ModItems.CRYONITE.get())).save(pRecipeOutput);


        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CRYONITE_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .define('A', ModItems.CRYONITE.get())
                .unlockedBy(getHasName(ModItems.CRYONITE.get()), has(ModItems.CRYONITE.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CRYONITE_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.CRYONITE.get())
                .unlockedBy(getHasName(ModItems.CRYONITE.get()), has(ModItems.CRYONITE.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CRYONITE_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.CRYONITE.get())
                .unlockedBy(getHasName(ModItems.CRYONITE.get()), has(ModItems.CRYONITE.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CRYONITE_BOOTS.get())
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.CRYONITE.get())
                .unlockedBy(getHasName(ModItems.CRYONITE.get()), has(ModItems.CRYONITE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CRYONITE_PICKAXE.get())
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.CRYONITE.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.CRYONITE.get()), has(ModItems.CRYONITE.get())).save(pRecipeOutput);








        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CRYONITE.get(), 9)
                .requires(ModBlocks.CRYONITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.CRYONITE_BLOCK.get()), has(ModBlocks.CRYONITE_BLOCK.get())).save(pRecipeOutput);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TRUMPIUM.get(), 9)
                .requires(ModBlocks.TRUMPIUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.TRUMPIUM_BLOCK.get()), has(ModBlocks.TRUMPIUM_BLOCK.get())).save(pRecipeOutput);

//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TRUMPIUM.get(), 9)
//                .requires(ModBlocks.TRUMPIUM_BLOCK.get())// look at this if problems arise
//                .unlockedBy(getHasName(ModBlocks.TRUMPIUM_BLOCK.get()), has(ModBlocks.TRUMPIUM_BLOCK.get()))
//                .save(pRecipeOutput, FirstMod.MOD_ID + ":trumpium_from_trumpium_block");

        oreSmelting(pRecipeOutput, CRYONITE_SMELTABLES, RecipeCategory.MISC, ModItems.CRYONITE.get(), 0.25f, 200, "cryonite");
        oreBlasting(pRecipeOutput, CRYONITE_SMELTABLES, RecipeCategory.MISC, ModItems.CRYONITE.get(), 0.25f, 100, "cryonite");

    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, FirstMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}