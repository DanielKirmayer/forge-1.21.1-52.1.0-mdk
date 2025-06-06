package net.dannykandmichaelk.firstmod.datagen;

import net.dannykandmichaelk.firstmod.FirstMod;
import net.dannykandmichaelk.firstmod.block.ModBlocks;
import net.dannykandmichaelk.firstmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, FirstMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent(ModItems.MRDAS_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        basicItem(ModItems.CRYONITE.get());
        basicItem(ModItems.RAW_CRYONITE.get());

        basicItem(ModItems.SUPER_CHISEL.get());
        basicItem(ModItems.TRUMPIUM.get());


        basicItem(ModItems.CRYONITE_HELMET.get());
        basicItem(ModItems.CRYONITE_CHESTPLATE.get());
        basicItem(ModItems.CRYONITE_LEGGINGS.get());
        basicItem(ModItems.CRYONITE_BOOTS.get());
        basicItem(ModItems.WEAKENED_SHARD_OF_THOR.get());

        handheldItem(ModItems.CRYONITE_SWORD);
        handheldItem(ModItems.CRYONITE_PICKAXE);
        handheldItem(ModItems.KAUPEN_BOW);

        saplingItem(ModBlocks.EVERGREEN_SAPLING);

        handheldItem(ModItems.C17H21NO4_SEEDS);
        handheldItem(ModItems.COCA_COLINA);
        basicItem(ModItems.BARNEY_DISC.get());






    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID,"block/" + item.getId().getPath()));
    }
}