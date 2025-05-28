package net.dannykandmichaelk.firstmod.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class FreezeEffect extends MobEffect {
    public double x;
    public double y;
    public double z;

    public FreezeEffect(MobEffectCategory MobEffectCategory, int color) {
        super (MobEffectCategory, color);
    }



    @Override
    public void onEffectAdded(LivingEntity pLivingEntity, int pAmplifier) {
       x = pLivingEntity.getX();
       y = pLivingEntity.getY();
       z = pLivingEntity.getZ();


        pLivingEntity.teleportTo(x, y, z);
        pLivingEntity.setDeltaMovement(0, 0, 0);

        super.onEffectAdded(pLivingEntity, pAmplifier);
    }


    @Override
    public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        pLivingEntity.teleportTo(x,y,z);
        pLivingEntity.setDeltaMovement(0, 0, 0);
        return super.applyEffectTick(pLivingEntity, pAmplifier);
    }
}
