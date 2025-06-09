package net.dannykandmichaelk.firstmod.block.entity;

import net.dannykandmichaelk.firstmod.FirstMod;
import net.dannykandmichaelk.firstmod.block.ModBlocks;
import net.dannykandmichaelk.firstmod.block.entity.custom.CryoniteWorkbenchBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, FirstMod.MOD_ID);


    public static final RegistryObject<BlockEntityType<CryoniteWorkbenchBlockEntity>> CRYONITE_WORKBENCH_BE =
            BLOCK_ENTITIES.register("cryonite_workbench_be", () -> BlockEntityType.Builder.of(
                    CryoniteWorkbenchBlockEntity::new, ModBlocks.CRYONITE_WORKBENCH.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
