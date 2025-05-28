package net.dannykandmichaelk.firstmod.datagen;

import net.dannykandmichaelk.firstmod.block.ModBlocks;
import net.dannykandmichaelk.firstmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;


import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.CRYONITE_BLOCK.get());
        dropSelf(ModBlocks.TRUMPIUM_BLOCK.get());
        dropSelf(ModBlocks.RAW_CRYONITE_BLOCK.get());
        // dropSelf(ModBlocks.MAGIC_BLOCK.get());

        this.add(ModBlocks.CRYONITE_ORE.get(),
                block -> createOreDrop(ModBlocks.CRYONITE_ORE.get(), ModItems.RAW_CRYONITE.get()));
        this.add(ModBlocks.DEEPSLATE_CRYONITE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.DEEPSLATE_CRYONITE_ORE.get(), ModItems.RAW_CRYONITE.get(), 1, 2));


        this.dropSelf(ModBlocks.EVERGREEN_LOG.get());
        this.dropSelf(ModBlocks.EVERGREEN_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_EVERGREEN_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_EVERGREEN_WOOD.get());
        this.dropSelf(ModBlocks.EVERGREEN_PLANKS.get());
        this.dropSelf(ModBlocks.EVERGREEN_SAPLING.get());

        this.add(ModBlocks.EVERGREEN_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.EVERGREEN_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                pBlock, this.applyExplosionDecay(
                        pBlock, LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}