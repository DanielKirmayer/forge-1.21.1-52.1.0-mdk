package net.dannykandmichaelk.firstmod.item;

import net.dannykandmichaelk.firstmod.FirstMod;
import net.dannykandmichaelk.firstmod.entity.ModEntities;
import net.dannykandmichaelk.firstmod.item.custom.ChiselItem;
import net.dannykandmichaelk.firstmod.item.custom.ModArmorItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraft.world.item.Items.registerItem;

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
            () -> new ModArmorItem(ModArmorMaterials.CRYONITE_ARMOR_MATERIAL,ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem. Type.CHESTPLATE.getDurability(18))));
    public static final RegistryObject<Item> CRYONITE_LEGGINGS = ITEMS.register("cryonite_leggings",
            () -> new ArmorItem(ModArmorMaterials.CRYONITE_ARMOR_MATERIAL,ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem. Type.CHESTPLATE.getDurability(18))));
    public static final RegistryObject<Item> CRYONITE_BOOTS = ITEMS.register("cryonite_boots",
            () -> new ArmorItem(ModArmorMaterials.CRYONITE_ARMOR_MATERIAL,ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem. Type.BOOTS.getDurability(18))));



    public static final RegistryObject<Item> CRYONITE_SWORD = ITEMS.register("cryonite_sword",
            () -> new SwordItem(ModToolTiers.CRYONITE, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.CRYONITE,5,-.5f))));

    public static final RegistryObject<Item> CRYONITE_PICKAXE = ITEMS.register("cryonite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.CRYONITE, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.CRYONITE,2,-1f))));

    public static final RegistryObject<Item> MRDAS_SPAWN_EGG = ITEMS.register("mrdas_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.MRDAS, 0x53524b, 0xdac741, new Item.Properties()));





    public static void register(IEventBus eventbus){
        ITEMS.register(eventbus);
    }
}
