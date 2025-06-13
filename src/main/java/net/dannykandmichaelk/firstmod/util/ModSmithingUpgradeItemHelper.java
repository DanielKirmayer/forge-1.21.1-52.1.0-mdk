package net.dannykandmichaelk.firstmod.util;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SmithingTemplateItem;

import java.util.List;

/**
 * Contains helper methods to generate Smithing Upgrade Template items, which have custom tooltips that require
 *  numerous ResourceLocations and styles.
 */
public class ModSmithingUpgradeItemHelper {
    //region COBALT-STEEL Components
    private static final Component THORIUM_UPGRADE = Component.literal("Thorium Upgrade").withStyle(ChatFormatting.GRAY);
    private static final Component THRORIUM_UPGRADE_APPLIES_TO = Component.literal("Egg").withStyle(ChatFormatting.BLUE);
    private static final Component THORIUM_UPGRADE_INGREDIENTS = Component.literal("Cryonite").withStyle(ChatFormatting.BLUE);
    private static final Component CRYONITE_UPGRADE_BASE_SLOT_DESCRIPTION = Component.literal(
            "Add egg");
    private static final Component CRYONITE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.literal(
            "Add Cryonite");
    //endregion


    //region EMPTY SLOT RESOURCE LOCATIONS

    private static final ResourceLocation EMPTY_SLOT_EMERALD = ResourceLocation.withDefaultNamespace("item/empty_slot_emerald");
    //endregion



    //SmithingTemplateItem CLASS HAS EXAMPLE OF CORRECT Component.translatable() USAGE
    //appendHoverComponent() IN SAME CLASS HAS super() METHOD CALLED FIRST WHICH PLACES THOSE ComponentS BELOW ENCHANTMENTS???

    /**
     * Creates a Gilded Upgrade Smithing Template, which has special tooltips that are handled in this
     *  method and class.
     * @return New Gilded Bronze SmithingTemplateItem
     */
    public static SmithingTemplateItem createCryoniteUpgradeTemplate() {
        return new SmithingTemplateItem(THRORIUM_UPGRADE_APPLIES_TO, THORIUM_UPGRADE_INGREDIENTS,
                THORIUM_UPGRADE, CRYONITE_UPGRADE_BASE_SLOT_DESCRIPTION, CRYONITE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION,
                createUpgradeIconList(), createUpgradeMaterialList());
    }




    /**
     * Generates a List of ResourceLocations pointing to empty equipment icons.
     * @return List of empty equipment icon ResourceLocations
     */
    private static List<ResourceLocation> createUpgradeIconList() {
        return List.of(EMPTY_SLOT_EMERALD);
    }


    private static List<ResourceLocation> createUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_EMERALD);
    }
}
