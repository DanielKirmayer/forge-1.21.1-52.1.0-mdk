package net.dannykandmichaelk.firstmod.entity.custom;

import net.dannykandmichaelk.firstmod.entity.ModEntities;
import net.dannykandmichaelk.firstmod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec2;

public class MjolnirProjectileEntity extends AbstractArrow {
    private float rotation;
    public Vec2 groundedOffset;
    private int boltsSpawned = 0;
    private float playerRot;

    public MjolnirProjectileEntity(EntityType<? extends AbstractArrow> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public MjolnirProjectileEntity(LivingEntity shooter, Level level) {
        super(ModEntities.MJOLNIR.get(), shooter, level, new ItemStack(ModItems.MJOLNIR.get()), null);
        playerRot = shooter.getYRot();
    }

    @Override
    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(ModItems.MJOLNIR.get());
    }

    public float getRenderingRotation() {
        rotation += 0.5f;
        if (rotation >= 360) {
            rotation = 0;
        }
        return rotation;
    }

    public boolean isGrounded() {
        return inGround;
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity entity = result.getEntity();
        entity.hurt(this.damageSources().thrown(this, this.getOwner()), 4);

        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte) 3);
            this.discard();
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        if (boltsSpawned < 1) {
            rayofBoltsLine();
            boltsSpawned++;
        }



        if (result.getDirection() == Direction.SOUTH) {
            groundedOffset = new Vec2(215f, 180f);
        }
        if (result.getDirection() == Direction.NORTH) {
            groundedOffset = new Vec2(215f, 0f);
        }
        if (result.getDirection() == Direction.EAST) {
            groundedOffset = new Vec2(215f, -90f);
        }
        if (result.getDirection() == Direction.WEST) {
            groundedOffset = new Vec2(215f, 90f);
        }
        if (result.getDirection() == Direction.DOWN) {
            groundedOffset = new Vec2(115f, 180f);
        }
        if (result.getDirection() == Direction.UP) {
            System.out.println(playerRot);
            groundedOffset = new Vec2(300f, -162f);
        }

        super.onHitBlock(result);


    }

    public void rayofBoltsLine() {
        double radians = Math.toRadians(playerRot);

        double dirX = -Math.sin(radians); // -sin because of Minecraft's coordinate system
        double dirZ = Math.cos(radians);

        double currX = this.getX();
        double currZ = this.getZ();
            for (int i = 0; i < 10; i++) {
                currX += dirX;
                currZ += dirZ;
                LightningBolt bolt = EntityType.LIGHTNING_BOLT.create(this.level());
                if (bolt != null)
                {
                        bolt.moveTo(currX, this.getY(), currZ, 0.0F, 0.0F);
                }
                    this.level().addFreshEntity(bolt);
                }
            }

    }
