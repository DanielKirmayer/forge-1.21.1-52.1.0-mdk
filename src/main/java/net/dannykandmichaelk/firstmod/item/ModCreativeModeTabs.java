package net.dannykandmichaelk.firstmod.item;

import net.dannykandmichaelk.firstmod.FirstMod;
import net.dannykandmichaelk.firstmod.block.ModBlocks;
import net.dannykandmichaelk.firstmod.enchantment.ModEnchantments;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FirstMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> SIGMA_ITEMS_TAB = CREATIVE_MODE_TABS.register("sigma_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TRUMPIUM.get()))
                    .title(Component.translatable("creativetab.firstmod.sigma_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.TRUMPIUM.get());
                        output.accept(ModItems.RAW_CRYONITE.get());
                        output.accept(ModItems.SUPER_CHISEL.get());
                        output.accept(ModItems.CRYONITE.get());
                        output.accept(ModItems.CRYONITE_HELMET.get());
                        output.accept(ModItems.CRYONITE_CHESTPLATE.get());
                        output.accept(ModItems.CRYONITE_LEGGINGS.get());
                        output.accept(ModItems.CRYONITE_BOOTS.get());
                        output.accept(ModBlocks.RAW_CRYONITE_BLOCK.get());
                        output.accept(ModBlocks.TRUMPIUM_BLOCK.get());
                        output.accept(ModBlocks.CRYONITE_BLOCK.get());
                        output.accept(ModBlocks.ICE_INFUSED_CRYONITE_BLOCK.get());
                        output.accept(ModBlocks.PACKED_ICE_INFUSED_CRYONITE_BLOCK.get());
                        output.accept(ModBlocks.BLUE_ICE_INFUSED_CRYONITE_BLOCK.get());
                        output.accept(ModBlocks.CRYONITE_INFUSED_CRYONITE_BLOCK.get());
                        output.accept(ModBlocks.DEEPSLATE_CRYONITE_ORE.get());
                        output.accept(ModBlocks.CRYONITE_ORE.get());
                        output.accept(ModItems.MRDAS_SPAWN_EGG.get());
                        output.accept(ModItems.CRYONITE_SWORD.get());
                        output.accept(ModItems.CRYONITE_CLAYMORE.get());
                        output.accept(ModItems.CRYONITE_PICKAXE.get());
                        output.accept(ModItems.MJOLNIR.get());
                        output.accept(ModItems.KAUPEN_BOW.get());



                        output.accept(ModBlocks.EVERGREEN_LOG.get());
                        output.accept(ModBlocks.EVERGREEN_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_EVERGREEN_LOG.get());
                        output.accept(ModBlocks.STRIPPED_EVERGREEN_WOOD.get());

                        output.accept(ModBlocks.EVERGREEN_PLANKS.get());
                        output.accept(ModBlocks.EVERGREEN_SAPLING.get());

                        output.accept(ModBlocks.EVERGREEN_LEAVES.get());

                        output.accept(ModBlocks.C17H21NO4.get());
                        output.accept(ModBlocks.CRYONITE_WORKBENCH.get());
                        output.accept(ModItems.C17H21NO4_SEEDS.get());
                        output.accept(ModItems.COCA_COLINA.get());
                        output.accept(ModItems.BARNEY_DISC.get());
                        output.accept(ModItems.WEAKENED_SHARD_OF_THOR.get());
                        output.accept(ModItems.SHARD_OF_THOR.get());

                    }).build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}