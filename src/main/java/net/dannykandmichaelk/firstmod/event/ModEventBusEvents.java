package net.dannykandmichaelk.firstmod.event;


import net.dannykandmichaelk.firstmod.FirstMod;
import net.dannykandmichaelk.firstmod.entity.ModEntities;
import net.dannykandmichaelk.firstmod.entity.client.MjolnirProjectileModel;
import net.dannykandmichaelk.firstmod.entity.client.MrDasModel;
import net.dannykandmichaelk.firstmod.entity.client.WerewolfModel;
import net.dannykandmichaelk.firstmod.entity.custom.MrDasEntity;
import net.dannykandmichaelk.firstmod.entity.custom.WerewolfEntity;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FirstMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)

    public class ModEventBusEvents {
        @SubscribeEvent
        public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(MrDasModel.LAYER_LOCATION, MrDasModel::createOuterBodyLayer);
            event.registerLayerDefinition(WerewolfModel.LAYER_LOCATION, WerewolfModel::createBodyLayer);
            event.registerLayerDefinition(MjolnirProjectileModel.LAYER_LOCATION, MjolnirProjectileModel::createBodyLayer);
        }

        @SubscribeEvent
        public static void registerAttributes(EntityAttributeCreationEvent event) {
            event.put(ModEntities.MRDAS.get(), MrDasEntity.createAttributes().build());
            event.put(ModEntities.WEREWOLF.get(), WerewolfEntity.createAttributes().build());
        }
}
