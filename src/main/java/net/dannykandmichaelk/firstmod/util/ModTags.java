package net.dannykandmichaelk.firstmod.util;

import net.dannykandmichaelk.firstmod.FirstMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_CRYONITE_TOOL = createTag("needs_cryonite_tool");
        public static final TagKey<Block> INCORRECT_FOR_CRYONITE_TOOL = createTag("incorrect_for_cryonite_tool");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        public static final TagKey<Item> CRYONITE_REPARABLE = createTag("cryonite_repairable");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, name));
        }
    }
}