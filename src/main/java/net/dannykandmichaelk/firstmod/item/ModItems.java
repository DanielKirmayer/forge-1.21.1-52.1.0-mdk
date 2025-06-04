package net.dannykandmichaelk.firstmod.item;

import net.dannykandmichaelk.firstmod.FirstMod;
import net.dannykandmichaelk.firstmod.block.ModBlocks;
import net.dannykandmichaelk.firstmod.block.custom.ModC17H21NO4;
import net.dannykandmichaelk.firstmod.entity.ModEntities;
import net.dannykandmichaelk.firstmod.item.custom.ChiselItem;
import net.dannykandmichaelk.firstmod.item.custom.FreezingWeaponItem;
import net.dannykandmichaelk.firstmod.item.custom.MjolnirItem;
import net.dannykandmichaelk.firstmod.item.custom.ModArmorItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraft.world.item.Items.registerItem;

public class ModItems implements JukeboxSongs{


    public static final FoodProperties FURIOUS_COCKTAIL = new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(1.2F)
            .effect(new MobEffectInstance(MobEffects.CONFUSION, 400, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.POISON, 400, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 400, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.REGENERATION, 400, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.ABSORPTION, 400, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.BAD_OMEN, 400, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.BLINDNESS, 400, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.CONDUIT_POWER, 400, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 400, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.DARKNESS, 400, 1), 1.0F)            .effect(new MobEffectInstance(MobEffects.CONFUSION, 400, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 400, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.DIG_SPEED, 400, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 400, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.GLOWING, 400, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.HARM, 0, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.HEAL, 0, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 400, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 400, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.WITHER, 400, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.HUNGER, 400, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.INFESTED, 400, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.INVISIBILITY, 400, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.JUMP, 400, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.LEVITATION, 400, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.LUCK, 400, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.UNLUCK, 400, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.HUNGER, 400, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 400, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.OOZING, 400, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.RAID_OMEN, 400, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.SATURATION, 5, 1), 1.0F)            .effect(new MobEffectInstance(MobEffects.CONFUSION, 400, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.SLOW_FALLING, 400, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.TRIAL_OMEN, 400, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.WATER_BREATHING, 400, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.WEAKNESS, 400, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.WEAVING, 400, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.WIND_CHARGED, 400, 1), 1.0F)




            .alwaysEdible()
            .build();



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

    public static final RegistryObject<Item> C17H21NO4_SEEDS = ITEMS.register("c17h21no4_seeds",
            () -> new ItemNameBlockItem(ModBlocks.C17H21NO4.get(),new Item.Properties()));

    public static final RegistryObject<Item> COCA_COLINA = ITEMS.register("coca_colina",
            () -> new Item(new Item.Properties().food(FURIOUS_COCKTAIL)));




    public static final RegistryObject<Item> CRYONITE_SWORD = ITEMS.register("cryonite_sword",
            () -> new SwordItem(ModToolTiers.CRYONITE, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.CRYONITE,5,-.5f))));

    public static final RegistryObject<Item> CRYONITE_CLAYMORE = ITEMS.register( "cryonite_claymore",
            () -> new FreezingWeaponItem(ModToolTiers.CRYONITE, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.CRYONITE, 10, -2f))));

    public static final RegistryObject<Item> CRYONITE_PICKAXE = ITEMS.register("cryonite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.CRYONITE, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.CRYONITE,2,-1f))));

    public static final RegistryObject<Item> KAUPEN_BOW = ITEMS.register("kaupen_bow",
            () -> new BowItem(new Item.Properties().durability(500).jukeboxPlayable(PIGSTEP)));

    public static final RegistryObject<Item> MRDAS_SPAWN_EGG = ITEMS.register("mrdas_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.MRDAS, 0x53524b, 0xdac741, new Item.Properties()));

    public static final RegistryObject<Item> MJOLNIR = ITEMS.register("mjolnir1",
            () -> new MjolnirItem(new Item.Properties().stacksTo(16)));






    public static void register(IEventBus eventbus){
        ITEMS.register(eventbus);
    }
}
