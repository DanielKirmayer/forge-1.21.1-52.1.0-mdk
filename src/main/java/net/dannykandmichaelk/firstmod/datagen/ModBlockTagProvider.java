package net.dannykandmichaelk.firstmod.datagen;

import net.dannykandmichaelk.firstmod.FirstMod;
import net.dannykandmichaelk.firstmod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, FirstMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.CRYONITE_BLOCK.get())
                .add(ModBlocks.RAW_CRYONITE_BLOCK.get())
                .add(ModBlocks.CRYONITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_CRYONITE_ORE.get())
                .add(ModBlocks.TRUMPIUM_BLOCK.get())
                .add(ModBlocks.ICE_INFUSED_CRYONITE_BLOCK.get())
                .add(ModBlocks.PACKED_ICE_INFUSED_CRYONITE_BLOCK.get())
                .add(ModBlocks.BLUE_ICE_INFUSED_CRYONITE_BLOCK.get())
                .add(ModBlocks.CRYONITE_INFUSED_CRYONITE_BLOCK.get());




        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.DEEPSLATE_CRYONITE_ORE.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.RAW_CRYONITE_BLOCK.get());

        tag(BlockTags.PIGLIN_REPELLENTS)
                .add(ModBlocks.RAW_CRYONITE_BLOCK.get());

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.EVERGREEN_LOG.get())
                .add(ModBlocks.EVERGREEN_WOOD.get())
                .add(ModBlocks.STRIPPED_EVERGREEN_LOG.get())
                .add(ModBlocks.STRIPPED_EVERGREEN_WOOD.get());
    }
}