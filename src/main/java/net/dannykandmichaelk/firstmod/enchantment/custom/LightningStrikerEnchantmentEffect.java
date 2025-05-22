package net.dannykandmichaelk.firstmod.enchantment.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;

public record LightningStrikerEnchantmentEffect() implements EnchantmentEntityEffect {
    public static final MapCodec<LightningStrikerEnchantmentEffect> CODEC = MapCodec.unit(LightningStrikerEnchantmentEffect::new);

    @Override
    public void apply(ServerLevel pLevel, int pEnchantmentLevel, EnchantedItemInUse pItem, Entity pEntity, Vec3 pOrigin) {
        if(pEnchantmentLevel == 1) {
            EntityType.LIGHTNING_BOLT.spawn(pLevel, pEntity.getOnPos(), MobSpawnType.TRIGGERED);
        }

        if(pEnchantmentLevel == 2) {
                EntityType.LIGHTNING_BOLT.spawn(pLevel, pEntity.getOnPos(), MobSpawnType.TRIGGERED);
            EntityType.LIGHTNING_BOLT.spawn(pLevel, pEntity.getOnPos(), MobSpawnType.TRIGGERED);
        }

        if (pEnchantmentLevel == 3)
        {
            for (int i = 0; i < 20; i++)
            {
                EntityType.LIGHTNING_BOLT.spawn(pLevel, pEntity.getOnPos(), MobSpawnType.TRIGGERED);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }
}
