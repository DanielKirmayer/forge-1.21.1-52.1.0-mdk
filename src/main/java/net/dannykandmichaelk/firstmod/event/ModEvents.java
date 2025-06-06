package net.dannykandmichaelk.firstmod.event;


import net.dannykandmichaelk.firstmod.FirstMod;
import net.dannykandmichaelk.firstmod.item.ModItems;
import net.dannykandmichaelk.firstmod.villager.ModVillagers;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;

@Mod.EventBusSubscriber(modid = FirstMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if (event.getType() == ModVillagers.ALFA_JEFE.get()) {
            var trades = event.getTrades();

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 45),
                    new ItemStack(ModItems.C17H21NO4_SEEDS.get(), 1), 6, 4, 0.05f));

            MerchantOffer offer = getMerchantOffer();

// Master level is index 5
            trades.get(1).add((trader, random) -> offer);

        }
    }

    private static @NotNull MerchantOffer getMerchantOffer() {
        ItemCost primaryCost = new ItemCost(Items.EMERALD_BLOCK, 50);
        ItemCost secondaryCost = new ItemCost(Items.NETHERITE_BLOCK, 3);

        ItemStack result = new ItemStack(ModItems.WEAKENED_SHARD_OF_THOR.get());

        MerchantOffer offer = new MerchantOffer(
                primaryCost,
                Optional.of(secondaryCost),
                result,
                1,        // maxUses
                4000,     // villager XP
                0.05f     // price multiplier
        );
        return offer;
    }

    @SubscribeEvent
    public static void addWanderingTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 12),
                new ItemStack(ModItems.SUPER_CHISEL.get(), 1), 1, 10, 0.2f
        ));

        rareTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.NETHERITE_INGOT, 8),
                new ItemStack(ModItems.KAUPEN_BOW.get(), 1), 1, 10, 0.2f
        ));
    }
}
