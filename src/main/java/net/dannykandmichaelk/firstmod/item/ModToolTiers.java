package net.dannykandmichaelk.firstmod.item;
import net.dannykandmichaelk.firstmod.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;;


public class ModToolTiers {
    public static final Tier CRYONITE = new ForgeTier(1400, 14, 3f, 20,
            ModTags.Blocks.NEEDS_CRYONITE_TOOL, () -> Ingredient.of(ModItems.CRYONITE.get()),
            ModTags.Blocks.INCORRECT_FOR_CRYONITE_TOOL);

}