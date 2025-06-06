package net.dannykandmichaelk.firstmod.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UnstableItem extends Item {

    private int infectionRadius = 1;
    private Set<BlockPos> infectedBlocks = new HashSet<>();

    public UnstableItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void onInventoryTick(ItemStack stack, Level level, Player player, int slotIndex, int selectedIndex) {
        if (slotIndex >= 0 && slotIndex <= 8 && !level.isClientSide) { // Only if shard is in hotbar
            BlockPos playerPos = player.getOnPos();
            RandomSource random = level.getRandom();

            // Initialize infectedBlocks if empty (start from player block)
            if (infectedBlocks.isEmpty()) {
                infectedBlocks.add(playerPos);
            }

            // Expand radius randomly by 1 block up to max 20
            if (random.nextFloat() < 0.05f && infectionRadius < 20) {
                infectionRadius++;
            }

            // Update infectedBlocks set to include all blocks within radius above player
            infectedBlocks.clear();
            int radius = infectionRadius;
            for (int dx = -radius; dx <= radius; dx++) {
                for (int dy = 1; dy <= radius; dy++) { // always above player
                    for (int dz = -radius; dz <= radius; dz++) {
                        BlockPos pos = playerPos.offset(dx, dy, dz);
                        infectedBlocks.add(pos);
                    }
                }
            }

            List<Block> blackDarkGrayBlocks = List.of(
                    Blocks.BLACKSTONE,
                    Blocks.BLACK_WOOL,
                    Blocks.BLACK_CONCRETE,
                    Blocks.BLACK_TERRACOTTA,
                    Blocks.POLISHED_BLACKSTONE,
                    Blocks.POLISHED_BLACKSTONE_BRICKS,
                    Blocks.DEEPSLATE,
                    Blocks.POLISHED_DEEPSLATE,
                    Blocks.BLACK_STAINED_GLASS,
                    Blocks.OBSIDIAN,
                    Blocks.GILDED_BLACKSTONE,
                    Blocks.BLACK_CONCRETE_POWDER
            );

            // Pick 5 random blocks that are not air and change them, or stop if cannot finish under 200 attempts
            List<BlockPos> infectedList = new ArrayList<>(infectedBlocks);
            int changed = 0;
            int attempts = 0;
            while (changed < 5 && attempts < 200) {
                attempts++;
                BlockPos targetPos = infectedList.get(random.nextInt(infectedList.size()));
                BlockState original = level.getBlockState(targetPos);

                if (!original.isAir()) {
                    Block randomBlock = blackDarkGrayBlocks.get(random.nextInt(blackDarkGrayBlocks.size()));
                    BlockState newState = randomBlock.defaultBlockState();
                    level.setBlockAndUpdate(targetPos, newState);
                    changed++;
                }
            }

            // 5% chance to spawn 10 lightning bolts randomly in radius,
            if (random.nextFloat() < 0.05f) {
                for (int i = 0; i < 10; i++) {
                    int dx = random.nextInt(radius * 2 + 1) - radius;
                    int dy = random.nextInt(radius) + 1;
                    int dz = random.nextInt(radius * 2 + 1) - radius;

                    BlockPos boltPos = playerPos.offset(dx, dy, dz);

                    // Move boltPos downward until hitting solid block or y == 0
                    while (boltPos.getY() > 0 && level.isEmptyBlock(boltPos)) {
                        boltPos = boltPos.below();
                    }

                    // If solid block is found spawn lightning bolt above it
                    if (!level.isEmptyBlock(boltPos) && level instanceof ServerLevel serverLevel) {
                        BlockPos lightningPos = boltPos.above();
                        LightningBolt bolt = EntityType.LIGHTNING_BOLT.create(level);
                        if (bolt != null) {
                            bolt.moveTo(lightningPos.getX() + 0.5, lightningPos.getY(), lightningPos.getZ() + 0.5, 0f, 0f);
                            serverLevel.addFreshEntity(bolt);
                        }
                    }
                }
            }

            // Set time to night and start rain while shard is in hotbar
            if (level instanceof ServerLevel serverLevel) {
                long currentDayTime = serverLevel.getDayTime() % 24000;
                if (currentDayTime < 17000 || currentDayTime > 19000) {
                    long newTime = serverLevel.getDayTime() - currentDayTime + 18000;
                    serverLevel.setDayTime(newTime);
                }
                if (!serverLevel.isRaining()) {
                    serverLevel.getLevelData().setRaining(true);
                }
            }
        } else if (!level.isClientSide && level instanceof ServerLevel serverLevel) {
            // If shard is not in hotbar, clear rain and set time to day
            if (serverLevel.isRaining()) {
                serverLevel.getLevelData().setRaining(false);
            }
            long currentDayTime = serverLevel.getDayTime() % 24000;
            if (currentDayTime >= 17000 || currentDayTime < 7000) {
                long newTime = serverLevel.getDayTime() - currentDayTime + 1000;
                serverLevel.setDayTime(newTime);
            }
        }

        super.onInventoryTick(stack, level, player, slotIndex, selectedIndex);
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        super.appendHoverText(pStack, null, pTooltipComponents, pTooltipFlag);
      String text ="WARNING: THIS SHARD IS EXTREMELY UNSTABLE" +
              " AND WILL DESTROY EVERYTHING NEAR YOU IF YOU PUT IT IN YOUR HOTBAR";

        int[] rainbowColors = {
                0xFFFF00, // yellow
                0x0000FF, // blue
        };

        MutableComponent coloredText = Component.literal("");
        String[] textSplit = text.split(" ");

        for (int i = 0; i < textSplit.length; i++) {
            int color = rainbowColors[i % rainbowColors.length];
            coloredText.append(Component.literal(String.valueOf(textSplit[i]) + " ").withStyle(style -> style.withColor(color)));
        }

        pTooltipComponents.add(coloredText);
    }
}
