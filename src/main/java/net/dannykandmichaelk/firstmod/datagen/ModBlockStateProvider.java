package net.dannykandmichaelk.firstmod.datagen;

import net.dannykandmichaelk.firstmod.FirstMod;
import net.dannykandmichaelk.firstmod.block.ModBlocks;
import net.dannykandmichaelk.firstmod.block.custom.ModC17H21NO4;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, FirstMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.CRYONITE_BLOCK);
        blockWithItem(ModBlocks.RAW_CRYONITE_BLOCK);

        blockWithItem(ModBlocks.CRYONITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_CRYONITE_ORE);

        blockWithItem(ModBlocks.TRUMPIUM_BLOCK);
        blockWithItem(ModBlocks.ICE_INFUSED_CRYONITE_BLOCK);
        blockWithItem(ModBlocks.PACKED_ICE_INFUSED_CRYONITE_BLOCK);
        blockWithItem(ModBlocks.BLUE_ICE_INFUSED_CRYONITE_BLOCK);
        blockWithItem(ModBlocks.CRYONITE_INFUSED_CRYONITE_BLOCK);
        blockWithItem(ModBlocks.CRYONITE_WORKBENCH);




        logBlock(ModBlocks.EVERGREEN_LOG.get());
        axisBlock(ModBlocks.EVERGREEN_WOOD.get(), blockTexture(ModBlocks.EVERGREEN_LOG.get()), blockTexture(ModBlocks.EVERGREEN_LOG.get()));
        logBlock(ModBlocks.STRIPPED_EVERGREEN_LOG.get());
        axisBlock(ModBlocks.STRIPPED_EVERGREEN_WOOD.get(), blockTexture(ModBlocks.STRIPPED_EVERGREEN_LOG.get()), blockTexture(ModBlocks.STRIPPED_EVERGREEN_LOG.get()));

        blockItem(ModBlocks.EVERGREEN_LOG);
        blockItem(ModBlocks.EVERGREEN_WOOD);
        blockItem(ModBlocks.STRIPPED_EVERGREEN_LOG);
        blockItem(ModBlocks.STRIPPED_EVERGREEN_WOOD);

        blockWithItem(ModBlocks.EVERGREEN_PLANKS);

        leavesBlock(ModBlocks.EVERGREEN_LEAVES);
        saplingBlock(ModBlocks.EVERGREEN_SAPLING);
        makeCrop(((CropBlock) ModBlocks.C17H21NO4.get()), "c17h21no4_crop_stage", "c17h21no4_crop_stage");
    }

    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((ModC17H21NO4) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "block/" + textureName + state.getValue(((ModC17H21NO4) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }


    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("firstmod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("firstmod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }



}