package net.dannykandmichaelk.firstmod.datagen;

import net.dannykandmichaelk.firstmod.FirstMod;
import net.dannykandmichaelk.firstmod.block.ModBlocks;
import net.dannykandmichaelk.firstmod.item.ModArmorMaterials;
import net.dannykandmichaelk.firstmod.item.ModItems;
import net.dannykandmichaelk.firstmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture,
                              CompletableFuture<TagLookup<Block>> lookupCompletableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, completableFuture, lookupCompletableFuture, FirstMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.CRYONITE.get())
                .add(ModItems.RAW_CRYONITE.get())
                .add(Items.COAL)
                .add(Items.STICK)
                .add(Items.COMPASS);

        tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.EVERGREEN_LOG.get().asItem())
                .add(ModBlocks.EVERGREEN_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_EVERGREEN_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_EVERGREEN_WOOD.get().asItem());

        tag(ItemTags.PLANKS)
                .add(ModBlocks.EVERGREEN_PLANKS.get().asItem());

        tag(ItemTags.ARMOR_ENCHANTABLE)
                .add(ModItems.CRYONITE_HELMET.get())
                .add(ModItems.CRYONITE_CHESTPLATE.get())
                .add(ModItems.CRYONITE_LEGGINGS.get())
                .add(ModItems.CRYONITE_BOOTS.get());
        tag(ItemTags.HEAD_ARMOR_ENCHANTABLE)
                .add(ModItems.CRYONITE_HELMET.get());
        tag(ItemTags.FOOT_ARMOR_ENCHANTABLE)
                .add(ModItems.CRYONITE_BOOTS.get());
        tag(ItemTags.CHEST_ARMOR_ENCHANTABLE)
                .add(ModItems.CRYONITE_CHESTPLATE.get());
        tag(ItemTags.SWORD_ENCHANTABLE)
                .add(ModItems.CRYONITE_SWORD.get());
        tag(ItemTags.MINING_ENCHANTABLE)
                .add(ModItems.CRYONITE_PICKAXE.get());
        tag(ItemTags.EQUIPPABLE_ENCHANTABLE)
                .add(ModItems.CRYONITE_HELMET.get())
                .add(ModItems.CRYONITE_CHESTPLATE.get())
                .add(ModItems.CRYONITE_LEGGINGS.get())
                .add(ModItems.CRYONITE_BOOTS.get());
        tag(ItemTags.DURABILITY_ENCHANTABLE)
                .add(ModItems.CRYONITE_HELMET.get())
                .add(ModItems.CRYONITE_CHESTPLATE.get())
                .add(ModItems.CRYONITE_LEGGINGS.get())
                .add(ModItems.CRYONITE_BOOTS.get())
                .add(ModItems.CRYONITE_PICKAXE.get())
                .add(ModItems.CRYONITE_SWORD.get());
        tag(ItemTags.TURTLE_FOOD)
                .add(ModItems.CRYONITE_HELMET.get())
                .add(ModItems.CRYONITE_CHESTPLATE.get())
                .add(ModItems.CRYONITE_LEGGINGS.get())
                .add(ModItems.CRYONITE_BOOTS.get())
                .add(ModItems.CRYONITE_PICKAXE.get())
                .add(ModItems.CRYONITE_SWORD.get());





    }
}