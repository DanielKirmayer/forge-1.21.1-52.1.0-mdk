package net.dannykandmichaelk.firstmod.item.custom;

import net.dannykandmichaelk.firstmod.entity.custom.MjolnirProjectileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.monster.Evoker;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.EvokerFangs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class MjolnirItem extends Item {

        public MjolnirItem(Properties pProperties) {
            super(pProperties);
        }

        @Override
        public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
            ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
            pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(),
                    SoundEvents.SNOWBALL_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (pLevel.getRandom().nextFloat() * 0.4F + 0.8F));
            if (!pLevel.isClientSide) {
                MjolnirProjectileEntity mjolnirProjectile = new MjolnirProjectileEntity(pPlayer, pLevel);
                mjolnirProjectile.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 0F);
                pLevel.addFreshEntity(mjolnirProjectile);
//                if (mjolnirProjectile.hasCollided)
//                {
//                    BlockPos toStrike = new BlockPos((int) (mjolnirProjectile.getX()), (int) (mjolnirProjectile.getY()), (int)(mjolnirProjectile.getZ()));
//                    EntityType.LIGHTNING_BOLT.spawn((ServerLevel) pLevel, toStrike, MobSpawnType.TRIGGERED);
//                }

            }

            pPlayer.awardStat(Stats.ITEM_USED.get(this));
            if (!pPlayer.getAbilities().instabuild) {
                itemstack.shrink(1);
            }

            return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
        }
    }
