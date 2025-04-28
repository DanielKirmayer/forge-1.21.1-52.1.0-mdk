package net.dannykandmichaelk.firstmod.item;

import net.dannykandmichaelk.firstmod.FirstMod;
import net.dannykandmichaelk.firstmod.entity.ModEntities;
import net.dannykandmichaelk.firstmod.item.custom.ChiselItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FirstMod.MOD_ID);


    public static final RegistryObject<Item> TRUMPIUM = ITEMS.register("trumpium",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CRYONITE = ITEMS.register("cryonite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_CRYONITE = ITEMS.register("raw_cryonite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SUPER_CHISEL = ITEMS.register("super_chisel",
            () -> new ChiselItem(new Item.Properties().durability(50)));
    public static final RegistryObject<Item> CRYONITE_HELMET = ITEMS.register("cryonite_helmet",
            () -> new ArmorItem(ModArmorMaterials.CRYONITE_ARMOR_MATERIAL,ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem. Type.HELMET.getDurability(18))));
    public static final RegistryObject<Item> CRYONITE_CHESTPLATE = ITEMS.register("cryonite_chestplate",
            () -> new ArmorItem(ModArmorMaterials.CRYONITE_ARMOR_MATERIAL,ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem. Type.CHESTPLATE.getDurability(18))));
    public static final RegistryObject<Item> CRYONITE_LEGGINGS = ITEMS.register("cryonite_leggings",
            () -> new ArmorItem(ModArmorMaterials.CRYONITE_ARMOR_MATERIAL,ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem. Type.CHESTPLATE.getDurability(18))));
    public static final RegistryObject<Item> CRYONITE_BOOTS = ITEMS.register("cryonite_boots",
            () -> new ArmorItem(ModArmorMaterials.CRYONITE_ARMOR_MATERIAL,ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem. Type.BOOTS.getDurability(18))));





    public static void register(IEventBus eventbus){
        ITEMS.register(eventbus);
    }
}
