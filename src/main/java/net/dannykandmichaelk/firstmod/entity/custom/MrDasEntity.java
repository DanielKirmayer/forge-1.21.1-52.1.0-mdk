package net.dannykandmichaelk.firstmod.entity.custom;

import com.mojang.brigadier.Command;
import net.dannykandmichaelk.firstmod.entity.ModEntities;
import net.dannykandmichaelk.firstmod.item.ModItems;
import net.dannykandmichaelk.firstmod.sound.ModSounds;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.OutgoingChatMessage;
import net.minecraft.network.chat.PlayerChatMessage;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.commands.ExecuteCommand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.behavior.warden.SonicBoom;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.allay.Allay;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.item.EggItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.scores.PlayerTeam;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.CommandEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.UUID;

import static net.dannykandmichaelk.firstmod.entity.ModEntities.*;

public class MrDasEntity extends Ghast implements  NeutralMob {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public final AnimationState attackAnimationState = new AnimationState();
    private int timesHit = 0;
    private int remainingPersistentAngerTime;
    private UUID persistentAngerTarget;
    private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 39);
    private int ticksUntilNextAlert;
    private static final UniformInt ALERT_INTERVAL = TimeUtil.rangeOfSeconds(1, 2);
    private static final ResourceLocation SPEED_MODIFIER_ATTACKING_ID = ResourceLocation.withDefaultNamespace("attacking");
    private static final AttributeModifier SPEED_MODIFIER_ATTACKING = new AttributeModifier(SPEED_MODIFIER_ATTACKING_ID, 0.05, AttributeModifier.Operation.ADD_VALUE);
    private int playFirstAngerSoundIn;
    private static final UniformInt FIRST_ANGER_SOUND_DELAY = TimeUtil.rangeOfSeconds(0, 1);




    public MrDasEntity(EntityType<? extends Ghast> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(7, new GhastShootFireballGoal(this));
        this.goalSelector.addGoal(5, new MrDasEntity.RandomFloatAroundGoal(this));
        this.goalSelector.addGoal(7, new MrDasEntity.GhastLookGoal(this));
        this.targetSelector
                .addGoal(
                        1, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, p_341441_ -> Math.abs(p_341441_.getY() - this.getY()) <= 4.0)
                );
    }
    static class GhastMoveControl extends MoveControl {
        private final Ghast ghast;
        private int floatDuration;

        public GhastMoveControl(Ghast pGhast) {
            super(pGhast);
            this.ghast = pGhast;
        }

        @Override
        public void tick() {
            if (this.operation == MoveControl.Operation.MOVE_TO) {
                if (this.floatDuration-- <= 0) {
                    this.floatDuration = this.floatDuration + this.ghast.getRandom().nextInt(5) + 2;
                    Vec3 vec3 = new Vec3(
                            this.wantedX - this.ghast.getX(), this.wantedY - this.ghast.getY(), this.wantedZ - this.ghast.getZ()
                    );
                    double d0 = vec3.length();
                    vec3 = vec3.normalize();
                    if (this.canReach(vec3, Mth.ceil(d0))) {
                        this.ghast.setDeltaMovement(this.ghast.getDeltaMovement().add(vec3.scale(0.1)));
                    } else {
                        this.operation = MoveControl.Operation.WAIT;
                    }
                }
            }
        }

        private boolean canReach(Vec3 pPos, int pLength) {
            AABB aabb = this.ghast.getBoundingBox();

            for (int i = 1; i < pLength; i++) {
                aabb = aabb.move(pPos);
                if (!this.ghast.level().noCollision(this.ghast, aabb)) {
                    return false;
                }
            }

            return true;
        }
    }
    static class RandomFloatAroundGoal extends Goal {
        private final Ghast ghast;

        public RandomFloatAroundGoal(Ghast pGhast) {
            this.ghast = pGhast;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            MoveControl movecontrol = this.ghast.getMoveControl();
            if (!movecontrol.hasWanted()) {
                return true;
            } else {
                double d0 = movecontrol.getWantedX() - this.ghast.getX();
                double d1 = movecontrol.getWantedY() - this.ghast.getY();
                double d2 = movecontrol.getWantedZ() - this.ghast.getZ();
                double d3 = d0 * d0 + d1 * d1 + d2 * d2;
                return d3 < 1.0 || d3 > 3600.0;
            }
        }

        @Override
        public boolean canContinueToUse() {
            return false;
        }

        @Override
        public void start() {
            RandomSource randomsource = this.ghast.getRandom();
            double d0 = this.ghast.getX() + (double)((randomsource.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double d1 = this.ghast.getY() + (double)((randomsource.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double d2 = this.ghast.getZ() + (double)((randomsource.nextFloat() * 2.0F - 1.0F) * 16.0F);
            this.ghast.getMoveControl().setWantedPosition(d0, d1, d2, 1.0);
        }
    }



    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 300.0)
                .add(Attributes.MOVEMENT_SPEED, 0.25F)
                .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE, 150.0F)
                .add(Attributes.ATTACK_DAMAGE,3)
                .add(Attributes.ATTACK_SPEED,10F)
                .add(Attributes.ATTACK_KNOCKBACK,10)
                .add(Attributes.FALL_DAMAGE_MULTIPLIER,0)
                .add(Attributes.STEP_HEIGHT, 2.0)
                .add(Attributes.FOLLOW_RANGE,1000)
                .add(Attributes.SCALE, 5F)
                .add(Attributes.KNOCKBACK_RESISTANCE, 2F);
    }

    @Override
    public SoundEvent getEatingSound(ItemStack pStack) {
        return SoundEvents.WITHER_HURT;
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.DAS_HIT_1.get();
    }

    @Override
    public SoundSource getSoundSource() {
        return SoundSource.HOSTILE;
    }




    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.DAS_HIT_1.get();
    }


    private void playAngerSound() {
        this.playSound(ModSounds.DAS_HIT_5.get(), this.getSoundVolume() * 50.0F, this.getVoicePitch());
    }


//    @Override
//    public boolean doHurtTarget(Entity pEntity) {
//        this.level().broadcastEntityEvent(this, (byte)4);
//        this.playSound(SoundEvents.WARDEN_ATTACK_IMPACT, 10.0F, this.getVoicePitch());
//        SonicBoom.setCooldown(this, 1);
//        return super.doHurtTarget(pEntity);
//    }
//
//    @Override
//    public void setAttackTarget(LivingEntity pAttackTarget) {
//        this.getBrain().eraseMemory(MemoryModuleType.ROAR_TARGET);
//        this.getBrain().setMemory(MemoryModuleType.ATTACK_TARGET, pAttackTarget);
//        this.getBrain().eraseMemory(MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE);
//        SonicBoom.setCooldown(this, 1);
//    }

    @Override
    protected void playStepSound(BlockPos pPos, BlockState pState) {
        this.playSound(ModSounds.DAS_HIT_9.get(), 0.15F, 0.05F);
    }
    private static boolean isReflectedFireball(DamageSource pDamageSource) {
        return false;
    }


    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        DamageSource damageSource = damageSources().cactus();


        if (isReflectedFireball(pSource)) {
            super.hurt(damageSource, 1000.0F);
            return true;
        } else {
            return this.isInvulnerableTo(pSource) ? false : super.hurt(damageSource, pAmount);
        }
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {

        if (!(timesHit % 3 == 0)) {
            timesHit++;
            return ModSounds.DAS_HIT_1.get();

        }
        else{
            int rand = (int) ((Math.random() * 11) + 2);
            timesHit++;

            return switch (rand) {
                case 2 -> ModSounds.DAS_HIT_2.get();
                case 3 -> ModSounds.DAS_HIT_3.get();
                case 4 -> ModSounds.DAS_HIT_4.get();
                case 5 -> ModSounds.DAS_HIT_5.get();
                case 6 -> ModSounds.DAS_HIT_6.get();
                case 7 -> ModSounds.DAS_HIT_7.get();
                case 8 -> ModSounds.DAS_HIT_8.get();
                case 9 -> ModSounds.DAS_HIT_9.get();
                case 10 -> ModSounds.DAS_HIT_10.get();
                case 11 -> ModSounds.DAS_HIT_11.get();
                default -> ModSounds.DAS_HIT_1.get();
            };
        }


    }
    static class GhastLookGoal extends Goal {
        private final Ghast ghast;

        public GhastLookGoal(Ghast pGhast) {
            this.ghast = pGhast;
            this.setFlags(EnumSet.of(Goal.Flag.LOOK));
        }

        @Override
        public boolean canUse() {
            return true;
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }

        @Override
        public void tick() {
            if (this.ghast.getTarget() == null) {
                Vec3 vec3 = this.ghast.getDeltaMovement();
                this.ghast.setYRot(-((float)Mth.atan2(vec3.x, vec3.z)) * (180.0F / (float)Math.PI));
                this.ghast.yBodyRot = this.ghast.getYRot();
            } else {
                LivingEntity livingentity = this.ghast.getTarget();
                double d0 = 64.0;
                if (livingentity.distanceToSqr(this.ghast) < 4096.0) {
                    double d1 = livingentity.getX() - this.ghast.getX();
                    double d2 = livingentity.getZ() - this.ghast.getZ();
                    this.ghast.setYRot(-((float)Mth.atan2(d1, d2)) * (180.0F / (float)Math.PI));
                    this.ghast.yBodyRot = this.ghast.getYRot();
                }
            }
        }
    }




//    class MrDasSummonEntityGoal extends SpellcasterIllager.SpellcasterUseSpellGoal {
//        private final TargetingConditions vexCountTargeting = TargetingConditions.forNonCombat().range(16.0).ignoreLineOfSight().ignoreInvisibilityTesting();
//
//        @Override
//        public boolean canUse() {
//            if (!super.canUse()) {
//                return false;
//            } else {
//                int i = MrDasEntity.this.level().getNearbyEntities(Vex.class, this.vexCountTargeting, MrDasEntity.this, MrDasEntity.this.getBoundingBox().inflate(16.0)).size();
//                return MrDasEntity.this.random.nextInt(8) + 1 > i;
//            }
//        }
//
//        @Override
//        protected int getCastingTime() {
//            return 100;
//        }
//
//        @Override
//        protected int getCastingInterval() {
//            return 340;
//        }
//
//        @Override
//        protected void performSpellCasting() {
//            ServerLevel serverlevel = (ServerLevel)MrDasEntity.this.level();
//            PlayerTeam playerteam = MrDasEntity.this.getTeam();
//
//            for (int i = 0; i < 2; i++) {
//                BlockPos blockpos = MrDasEntity.this.blockPosition().offset(-2 + MrDasEntity.this.random.nextInt(5), 1, -2 + MrDasEntity.this.random.nextInt(5));
//           WerewolfEntity Werewolf = WEREWOLF.get().create(MrDasEntity.this.level());
//
//
//                if (Werewolf != null) {
//                    Werewolf.moveTo(blockpos, 0.0F, 0.0F);
//                    Werewolf.finalizeSpawn(serverlevel, MrDasEntity.this.level().getCurrentDifficultyAt(blockpos), MobSpawnType.MOB_SUMMONED, null);
//                    if (playerteam != null) {
//                        serverlevel.getScoreboard().addPlayerToTeam(Werewolf.getScoreboardName(), playerteam);
//                    }
//
//                    serverlevel.addFreshEntityWithPassengers(Werewolf);
//                    serverlevel.gameEvent(GameEvent.ENTITY_PLACE, blockpos, GameEvent.Context.of(MrDasEntity.this));
//                }
//            }
//        }
//
//        @Override
//        protected SoundEvent getSpellPrepareSound() {
//            return SoundEvents.EVOKER_PREPARE_SUMMON;
//        }
//
//        @Override
//        protected SpellcasterIllager.IllagerSpell getSpell() {
//            return IllagerSpell.BLINDNESS;
//        }
//    }




    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 40;
            this.idleAnimationState.start(this.tickCount);
        }
        else {
            --this.idleAnimationTimeout;
        }
    }




    @Override
    public int getRemainingPersistentAngerTime() {
        return this.remainingPersistentAngerTime;
    }

    @Override
    public void setRemainingPersistentAngerTime(int pTime) {
        this.remainingPersistentAngerTime = pTime;
    }

    @Override
    public @Nullable UUID getPersistentAngerTarget() {
        return this.persistentAngerTarget;
    }

    @Override
    public void setPersistentAngerTarget(@Nullable UUID pPersistentAngerTarget) {
        this.persistentAngerTarget = pPersistentAngerTarget;
    }

    @Override
    public void startPersistentAngerTimer() {
        this.setRemainingPersistentAngerTime(PERSISTENT_ANGER_TIME.sample(this.random));
    }

    private void maybeAlertOthers() {
        if (this.ticksUntilNextAlert > 0) {
            this.ticksUntilNextAlert--;
        } else {
            if (this.getSensing().hasLineOfSight(this.getTarget())) {
                this.alertOthers();
            }

            this.ticksUntilNextAlert = ALERT_INTERVAL.sample(this.random);
        }
    }

    private void maybePlayFirstAngerSound() {
        if (this.playFirstAngerSoundIn > 0) {
            this.playFirstAngerSoundIn--;
            if (this.playFirstAngerSoundIn == 0) {
                this.playAngerSound();
            }
        }
    }

    @Override
    public void setTarget(@javax.annotation.Nullable LivingEntity pLivingEntity) {
        if (this.getTarget() == null && pLivingEntity != null) {
            this.playFirstAngerSoundIn = FIRST_ANGER_SOUND_DELAY.sample(this.random);
            this.ticksUntilNextAlert = ALERT_INTERVAL.sample(this.random);
        }

        if (pLivingEntity instanceof Player) {
            this.setLastHurtByPlayer((Player)pLivingEntity);
        }

        super.setTarget(pLivingEntity);
    }
    public void tick() {
        super.tick();

        if(this.level().isClientSide()) {
            this.setupAnimationStates();
        }
    }

    protected void customServerAiStep() {

        this.maybePlayFirstAngerSound();


        this.updatePersistentAnger((ServerLevel)this.level(), true);
        if (this.getTarget() != null) {
            this.maybeAlertOthers();
        }

        if (this.isAngry()) {
            this.lastHurtByPlayerTime = this.tickCount;
            this.attackAnimationState.startIfStopped(this.tickCount);
        }

        super.customServerAiStep();
    }

    private void alertOthers() {
        double d0 = this.getAttributeValue(Attributes.FOLLOW_RANGE);
        AABB aabb = AABB.unitCubeFromLowerCorner(this.position()).inflate(d0, 10.0, d0);
        this.level()
                .getEntitiesOfClass(MrDasEntity.class, aabb, EntitySelector.NO_SPECTATORS)
                .stream()
                .filter(p_327015_ -> p_327015_.getTarget() == null)
                .filter(p_327016_ -> !p_327016_.isAlliedTo(this.getTarget()))
                .forEach(p_327014_ -> p_327014_.setTarget(this.getTarget()));
    }



    static class GhastShootFireballGoal extends Goal {
        private final Ghast ghast;
        public int chargeTime;

        public GhastShootFireballGoal(Ghast pGhast) {
            this.ghast = pGhast;
        }

        @Override
        public boolean canUse() {
            return this.ghast.getTarget() != null;
        }

        @Override
        public void start() {
            this.chargeTime = 0;
        }

        @Override
        public void stop() {
            this.ghast.setCharging(false);
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }

        @Override
        public void tick() {
            LivingEntity livingentity = this.ghast.getTarget();
            if (livingentity != null) {
                double d0 = 64.0;
                if (livingentity.distanceToSqr(this.ghast) < 4096.0) {
                    Level level = this.ghast.level();
                    this.chargeTime++;
                    if (this.chargeTime == 10 && !this.ghast.isSilent()) {
                        level.levelEvent(null, 809, this.ghast.blockPosition(), 0);
                    }

                    if (this.chargeTime == 5) {
                            double d1 = 64.0;
                            Vec3 vec3 = this.ghast.getViewVector(1.0F);
                            double d2 = livingentity.getX() - (this.ghast.getX() + vec3.x * 4.0);
                            double d3 = livingentity.getY(0.5) - (0.5 + this.ghast.getY(0.5));
                            double d4 = livingentity.getZ() - (this.ghast.getZ() + vec3.z * 4.0);
                            Vec3 vec31 = new Vec3(d2, d3, d4);
                            if (!this.ghast.isSilent()) {
                                level.levelEvent(null, 116, this.ghast.blockPosition(), 0);
                            }

                            LargeFireball largefireball = new LargeFireball(level, this.ghast, vec31.normalize(), 3);
                            largefireball.setPos(
                                    this.ghast.getX() + vec3.x * 4.0, this.ghast.getY(0.5) + 0.5, largefireball.getZ() + vec3.z * 4.0
                            );
                            level.addFreshEntity(largefireball);
                            this.chargeTime = -5;
                    }
                } else if (this.chargeTime > 0) {
                    this.chargeTime--;
                }

                this.ghast.setCharging(this.chargeTime > 10);
            }
        }
    }



}
