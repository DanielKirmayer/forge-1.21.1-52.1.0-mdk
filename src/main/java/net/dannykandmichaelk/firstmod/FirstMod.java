package net.dannykandmichaelk.firstmod;

import com.mojang.logging.LogUtils;
import net.dannykandmichaelk.firstmod.block.ModBlocks;
import net.dannykandmichaelk.firstmod.block.entity.ModBlockEntities;
import net.dannykandmichaelk.firstmod.effect.ModEffects;
import net.dannykandmichaelk.firstmod.enchantment.ModEnchantmentEffects;
import net.dannykandmichaelk.firstmod.entity.ModEntities;
import net.dannykandmichaelk.firstmod.entity.client.MjolnirProjectileRenderer;
import net.dannykandmichaelk.firstmod.entity.client.MrDasRenderer;
import net.dannykandmichaelk.firstmod.entity.client.WerewolfRenderer;
import net.dannykandmichaelk.firstmod.item.ModCreativeModeTabs;
import net.dannykandmichaelk.firstmod.item.ModItems;
import net.dannykandmichaelk.firstmod.screen.ModMenuTypes;
import net.dannykandmichaelk.firstmod.screen.custom.CryoniteWorkbenchScreen;
import net.dannykandmichaelk.firstmod.sound.ModSounds;
import net.dannykandmichaelk.firstmod.villager.ModVillagers;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(FirstMod.MOD_ID)
public class FirstMod {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "firstmod";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public FirstMod(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEntities.register(modEventBus);
        ModSounds.register(modEventBus);
        ModEnchantmentEffects.register(modEventBus);
        ModEffects.MOB_EFFECTS.register(modEventBus);
        ModVillagers.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModBlockEntities.register(modEventBus);


        // Register the item to a creative tab
//        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
//        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){
//            event.accept(ModItems.TRUMPIUM);
//            event.accept(ModItems.RAW_CRYONITE);
//            event.accept(ModItems.SUPER_CHISEL);
//            event.accept(ModItems.CRYONITE);
//        }
//        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS){
//            event.accept(ModBlocks.RAW_CRYONITE_BLOCK);
//            event.accept(ModBlocks.TRUMPIUM_BLOCK);
//            event.accept(ModBlocks.CRYONITE_BLOCK);
//            event.accept(ModBlocks.DEEPSLATE_CRYONITE_ORE);
//            event.accept(ModBlocks.CRYONITE_ORE);
//        }

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.MRDAS.get(), MrDasRenderer::new);
            EntityRenderers.register(ModEntities.WEREWOLF.get(), WerewolfRenderer::new);
            EntityRenderers.register(ModEntities.MJOLNIR.get(), MjolnirProjectileRenderer::new);
            MenuScreens.register(ModMenuTypes.CRYONITE_WORKBENCH_MENU.get(), CryoniteWorkbenchScreen::new);

        }
    }
}
