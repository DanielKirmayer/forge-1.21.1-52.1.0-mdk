package net.dannykandmichaelk.firstmod.entity.custom;

import com.mojang.brigadier.Command;
import net.dannykandmichaelk.firstmod.entity.ModEntities;
import net.dannykandmichaelk.firstmod.item.ModItems;
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
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.UUID;

import static net.dannykandmichaelk.firstmod.entity.ModEntities.*;

public class MrDasEntity extends Ghast implements  NeutralMob {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public final AnimationState attackAnimationState = new AnimationState();
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
        this.targetSelector
                .addGoal(
                        1, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, p_341441_ -> Math.abs(p_341441_.getY() - this.getY()) <= 4.0)
                );
////        this.goalSelector.addGoal(0,new FloatGoal(this));
//
//
////        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers());
////        this.goalSelector.addGoal(0, new MeleeAttackGoal(this, 3, true));
//        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, 1, false, true, this::isAngryAt));
////        this.targetSelector.addGoal(1, new SpellcasterCastingSpellGoal());
//        this.goalSelector.addGoal(7, new Ghast.GhastLookGoal(this));
//        this.goalSelector.addGoal(7, new Ghast.GhastShootFireballGoal(this));
////        this.goalSelector.addGoal(1, new MrDasSummonEntityGoal());
//
//
////        this.goalSelector.addGoal(3, new TemptGoal(this, 1.125, stack -> stack.is(ModItems.TRUMPIUM.get()), false));
//
//
//
////        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0));
//        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
//        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
        super.registerGoals();
//
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
                .add(Attributes.SCALE, 5F);
    }

    @Override
    public SoundEvent getEatingSound(ItemStack pStack) {
        return SoundEvents.WITHER_HURT;
    }

    private void playAngerSound() {
        this.playSound(SoundEvents.RAVAGER_ROAR, this.getSoundVolume() * 50.0F, this.getVoicePitch() * 0.01F);
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
        this.playSound(SoundEvents.RAVAGER_STEP, 0.15F, 0.05F);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.BONE_BLOCK_BREAK;
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
                        level.levelEvent(null, 1015, this.ghast.blockPosition(), 0);
                    }

                    if (this.chargeTime == 5) {
                            double d1 = 64.0;
                            Vec3 vec3 = this.ghast.getViewVector(1.0F);
                            double d2 = livingentity.getX() - (this.ghast.getX() + vec3.x * 4.0);
                            double d3 = livingentity.getY(0.5) - (0.5 + this.ghast.getY(0.5));
                            double d4 = livingentity.getZ() - (this.ghast.getZ() + vec3.z * 4.0);
                            Vec3 vec31 = new Vec3(d2, d3, d4);
                            if (!this.ghast.isSilent()) {
                                level.levelEvent(null, 1016, this.ghast.blockPosition(), 0);
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
