package net.dannykandmichaelk.firstmod.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class FreezeEffect extends MobEffect {

    public FreezeEffect(MobEffectCategory MobEffectCategory, int color) {
        super (MobEffectCategory, color);
    }



    @Override
    public void onEffectAdded(LivingEntity pLivingEntity, int pAmplifier) {
        double x = pLivingEntity.getX();
        double y = pLivingEntity.getY();
        double z = pLivingEntity.getZ();


        pLivingEntity.teleportTo(x, y, z);
        pLivingEntity.setDeltaMovement(0, 0, 0);

        super.onEffectAdded(pLivingEntity, pAmplifier);
    }


    @Override
    public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        onEffectAdded(pLivingEntity, pAmplifier);
        return super.applyEffectTick(pLivingEntity, pAmplifier);
    }
}
