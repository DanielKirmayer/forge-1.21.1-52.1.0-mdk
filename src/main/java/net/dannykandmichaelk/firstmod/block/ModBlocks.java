package net.dannykandmichaelk.firstmod.block;

import net.dannykandmichaelk.firstmod.FirstMod;
import net.dannykandmichaelk.firstmod.block.custom.ModFlammableRotatedPillarBlock;
import net.dannykandmichaelk.firstmod.item.ModItems;
import net.dannykandmichaelk.firstmod.worldgen.tree.ModTreeGrowers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {


    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FirstMod.MOD_ID);



    public static final RegistryObject<RotatedPillarBlock> EVERGREEN_LOG = registerBlock("evergreen_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final RegistryObject<RotatedPillarBlock> EVERGREEN_WOOD = registerBlock("evergreen_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_EVERGREEN_LOG = registerBlock("stripped_evergreen_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_EVERGREEN_WOOD = registerBlock("stripped_evergreen_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final RegistryObject<Block> EVERGREEN_PLANKS = registerBlock("evergreen_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

    public static final RegistryObject<Block> EVERGREEN_LEAVES = registerBlock("evergreen_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    public static final RegistryObject<Block> EVERGREEN_SAPLING = registerBlock("evergreen_sapling",
            () -> new SaplingBlock(ModTreeGrowers.EVERGREEN, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));


    public static final RegistryObject<Block> RAW_CRYONITE_BLOCK = registerBlock("raw_cryonite_block", () ->
            new Block(BlockBehaviour.Properties.of().strength(4.5f)
                    .requiresCorrectToolForDrops().sound(SoundType.POLISHED_TUFF).explosionResistance(10000f).friction(1.11f)));






    public static final RegistryObject<Block> CRYONITE_BLOCK = registerBlock("cryonite_block", () ->
                new Block(BlockBehaviour.Properties.of().strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.GILDED_BLACKSTONE).explosionResistance(10000f).ignitedByLava().friction(0.5f)));

    public static final RegistryObject<Block> CRYONITE_ORE = registerBlock("cryonite_ore", () ->
            new DropExperienceBlock(UniformInt.of(1,3),BlockBehaviour.Properties.of().strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.GILDED_BLACKSTONE).explosionResistance(10000f).ignitedByLava().friction(0.5f)));

    public static final RegistryObject<Block> DEEPSLATE_CRYONITE_ORE = registerBlock("deepslate_cryonite_ore", () ->
            new DropExperienceBlock(UniformInt.of(2,5),BlockBehaviour.Properties.of().strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.GILDED_BLACKSTONE).explosionResistance(10000f).ignitedByLava().friction(0.5f)));


    public static final RegistryObject<Block> TRUMPIUM_BLOCK = registerBlock("trumpium_block", () ->
            new Block(
                    BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()
                            .sound(SoundType.HEAVY_CORE).explosionResistance(10000f)
            ));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }


    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block)
    {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }

}
