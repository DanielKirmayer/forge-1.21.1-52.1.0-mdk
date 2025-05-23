package net.dannykandmichaelk.firstmod.worldgen.tree;

import net.dannykandmichaelk.firstmod.FirstMod;
import net.dannykandmichaelk.firstmod.worldgen.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower EVERGREEN = new TreeGrower(FirstMod.MOD_ID + ":evergreen",
            Optional.empty(), Optional.of(ModConfiguredFeatures.EVERGREEN_KEY), Optional.empty());
}
