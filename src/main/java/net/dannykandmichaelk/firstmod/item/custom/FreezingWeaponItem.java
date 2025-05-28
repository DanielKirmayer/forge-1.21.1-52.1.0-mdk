package net.dannykandmichaelk.firstmod.item.custom;

import net.dannykandmichaelk.firstmod.effect.ModEffects;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class FreezingWeaponItem extends SwordItem {

    public FreezingWeaponItem(Tier pTier, Item.Properties pProperties)
    {
        super(pTier, pProperties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
//        int fhitchance = 15;

//        target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, sduration, 1), attacker);

//        if (attacker.getRandom().nextInt(100) <= fhitchance) {
            target.addEffect(new MobEffectInstance(ModEffects.FREEZE.getHolder().get(), 200));
//        }

        return super.hurtEnemy(stack, target, attacker);

    }


}
