package net.dannykandmichaelk.firstmod.sound;

import net.dannykandmichaelk.firstmod.FirstMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, FirstMod.MOD_ID);

    public static final RegistryObject<SoundEvent> DAS_HIT_1 = registerSoundEvent("das_hit_1");
    public static final RegistryObject<SoundEvent> DAS_HIT_2 = registerSoundEvent("das_hit_2");
    public static final RegistryObject<SoundEvent> DAS_HIT_3 = registerSoundEvent("das_hit_3");
    public static final RegistryObject<SoundEvent> DAS_HIT_4 = registerSoundEvent("das_hit_4");
    public static final RegistryObject<SoundEvent> DAS_HIT_5 = registerSoundEvent("das_hit_5");
    public static final RegistryObject<SoundEvent> DAS_HIT_6 = registerSoundEvent("das_hit_6");
    public static final RegistryObject<SoundEvent> DAS_HIT_7 = registerSoundEvent("das_hit_7");
    public static final RegistryObject<SoundEvent> DAS_HIT_8 = registerSoundEvent("das_hit_8");
    public static final RegistryObject<SoundEvent> DAS_HIT_9 = registerSoundEvent("das_hit_9");
    public static final RegistryObject<SoundEvent> DAS_HIT_10 = registerSoundEvent("das_hit_10");





    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}