package net.dannykandmichaelk.firstmod.entity.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;

public class LightningStrikeEntity extends Entity {
    private final Entity target;
    private final Level level;
    private int ticksLived = 0;
    private final int maxTicks;

    public LightningStrikeEntity(Level level, Entity target, int maxTicks) {
        super(EntityType.LIGHTNING_BOLT, level);
        this.level = level;
        this.target = target;
        this.maxTicks = maxTicks;
        this.noPhysics = true;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder pBuilder) {

    }

    @Override
    public void tick() {
        super.tick();

        if (ticksLived >= maxTicks || !target.isAlive()) {
            this.discard();
            return;
        }

        // Get target's current X and Z, but strike the ground Y
        double x = target.getX();
        double z = target.getZ();
        int groundY = level.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z);

        LightningBolt bolt = EntityType.LIGHTNING_BOLT.create(level);
        if (bolt != null) {
            bolt.moveTo(x, groundY, z, 0.0F, 0.0F);
            level.addFreshEntity(bolt);
        }

        ticksLived++;
    }


    @Override protected void readAdditionalSaveData(CompoundTag tag) {}
    @Override protected void addAdditionalSaveData(CompoundTag tag) {}
}
