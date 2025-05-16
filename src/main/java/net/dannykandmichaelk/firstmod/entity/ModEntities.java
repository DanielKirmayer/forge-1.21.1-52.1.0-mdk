package net.dannykandmichaelk.firstmod.entity;

import net.dannykandmichaelk.firstmod.FirstMod;
import net.dannykandmichaelk.firstmod.entity.custom.MrDasEntity;
import net.dannykandmichaelk.firstmod.entity.custom.WerewolfEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, FirstMod.MOD_ID);

    public static final RegistryObject<EntityType<MrDasEntity>> MRDAS =
            ENTITY_TYPES.register("mrdas", () -> EntityType.Builder.of(MrDasEntity::new, MobCategory.CREATURE).sized(1f,1f).build("mrdas"));

    public static final RegistryObject<EntityType<WerewolfEntity>> WEREWOLF =
            ENTITY_TYPES.register("werewolf", () -> EntityType.Builder.of(WerewolfEntity::new, MobCategory.CREATURE).sized(1.5f,4f).build("werewolf"));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
