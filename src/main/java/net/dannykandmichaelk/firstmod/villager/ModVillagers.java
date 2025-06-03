package net.dannykandmichaelk.firstmod.villager;

import com.google.common.collect.ImmutableSet;
import net.dannykandmichaelk.firstmod.FirstMod;
import net.dannykandmichaelk.firstmod.block.ModBlocks;
import net.dannykandmichaelk.firstmod.sound.ModSounds;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, FirstMod.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, FirstMod.MOD_ID);

    public static final RegistryObject<PoiType> JEFE_POI = POI_TYPES.register("jefe_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.CRYONITE_INFUSED_CRYONITE_BLOCK.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<VillagerProfession> ALFA_JEFE = VILLAGER_PROFESSIONS.register("alfa_jefe",
            () -> new VillagerProfession("alfa_jefe", holder -> holder.value() == JEFE_POI.get(),
                    holder -> holder.value() == JEFE_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                    ModSounds.DAS_HIT_19.get()));



    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
