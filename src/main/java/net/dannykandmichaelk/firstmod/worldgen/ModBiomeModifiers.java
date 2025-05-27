package net.dannykandmichaelk.firstmod.worldgen;



import net.dannykandmichaelk.firstmod.FirstMod;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_CRYONITE_ORE = registerKey("add_cryonite_ore");
    public static final ResourceKey<BiomeModifier> ADD_EVERGREEN_TREE = registerKey("add_tree_evergreen");



    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeature = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);




         context.register(ADD_CRYONITE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                 HolderSet.direct(biomes.getOrThrow(Biomes.ICE_SPIKES), biomes.getOrThrow(Biomes.SNOWY_PLAINS), biomes.getOrThrow(Biomes.SNOWY_BEACH), biomes.getOrThrow(Biomes.SNOWY_TAIGA), biomes.getOrThrow(Biomes.SNOWY_SLOPES), biomes.getOrThrow(Biomes.FROZEN_RIVER), biomes.getOrThrow(Biomes.FROZEN_OCEAN)),
                 HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.CRYONITE_ORE_PLACED_KEY)),
                 GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_EVERGREEN_TREE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.ICE_SPIKES), biomes.getOrThrow(Biomes.SNOWY_PLAINS), biomes.getOrThrow(Biomes.SNOWY_BEACH), biomes.getOrThrow(Biomes.SNOWY_TAIGA), biomes.getOrThrow(Biomes.SNOWY_SLOPES), biomes.getOrThrow(Biomes.FROZEN_RIVER), biomes.getOrThrow(Biomes.FROZEN_OCEAN)),
                HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.EVERGEEN_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));


    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, name));
    }
}
