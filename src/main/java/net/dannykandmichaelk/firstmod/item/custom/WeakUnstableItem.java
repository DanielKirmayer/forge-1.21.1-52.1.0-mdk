package net.dannykandmichaelk.firstmod.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.*;

public class WeakUnstableItem extends Item {

    private final Map<Player, Map<BlockPos, BlockState>> lastChangedBlocks = new WeakHashMap<>();



    public WeakUnstableItem(Properties pProps) {
        super(pProps);
    }


    @Override
    public void onInventoryTick(ItemStack stack, Level level, Player player, int slotIndex, int selectedIndex) {
        if (slotIndex >= 0 && slotIndex <= 8 && !level.isClientSide) {
            BlockPos playerPos = player.getOnPos();
            RandomSource random = level.getRandom();

            // Gray/black/white blocks to choose from
            List<Block> grayBlocks = List.of(
                    Blocks.STONE,
                    Blocks.ANDESITE,
                    Blocks.POLISHED_ANDESITE,
                    Blocks.COBBLESTONE,
                    Blocks.BLACKSTONE,
                    Blocks.DEEPSLATE,
                    Blocks.POLISHED_DEEPSLATE,
                    Blocks.WHITE_WOOL,
                    Blocks.BLACK_WOOL,
                    Blocks.LIGHT_GRAY_WOOL,
                    Blocks.WHITE_CONCRETE,
                    Blocks.BLACK_CONCRETE,
                    Blocks.LIGHT_GRAY_CONCRETE,
                    Blocks.WHITE_TERRACOTTA,
                    Blocks.BLACK_TERRACOTTA,
                    Blocks.LIGHT_GRAY_TERRACOTTA,
                    Blocks.QUARTZ_BLOCK
            );

            // Restore previously changed blocks
            Map<BlockPos, BlockState> previous = lastChangedBlocks.getOrDefault(player, Map.of());
            for (Map.Entry<BlockPos, BlockState> entry : previous.entrySet()) {
                level.setBlockAndUpdate(entry.getKey(), entry.getValue());
            }

            // Select and apply 20 new random block changes
            Map<BlockPos, BlockState> newChanges = new HashMap<>();
            int attempts = 0;

            while (newChanges.size() < 25 && attempts < 125) {
                attempts++;
                int dx = random.nextInt(20) - 10;
                int dy = random.nextInt(20) - 1; // always above player
                int dz = random.nextInt(20) - 10;

                BlockPos targetPos = playerPos.offset(dx, dy, dz);
                BlockState original = level.getBlockState(targetPos);

                // Skip if block is air or already changed this tick
                if (original.isAir() || newChanges.containsKey(targetPos)) {
                    continue;
                }

                // Pick a random gray/black/white block to place
                Block randomGrayBlock = grayBlocks.get(random.nextInt(grayBlocks.size()));
                BlockState newState = randomGrayBlock.defaultBlockState();

                level.setBlockAndUpdate(targetPos, newState);
                newChanges.put(targetPos, original);
            }

            // Save current changes to restore next tick
            lastChangedBlocks.put(player, newChanges);
        }

        super.onInventoryTick(stack, level, player, slotIndex, selectedIndex);
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack stack) {
        ItemStack newStack = stack.copy();
        newStack.setDamageValue(stack.getDamageValue() + 1); // decrease durability by 1

        // If durability is exceeded, return empty stack (item breaks)
        if (newStack.getDamageValue() >= newStack.getMaxDamage()) {
            return ItemStack.EMPTY;
        }

        return newStack;
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        super.appendHoverText(pStack, null, pTooltipComponents, pTooltipFlag);

        pTooltipComponents.add(Component.literal("WARNING: THIS SHARD IS SOMEWHAT UNSTABLE" +
                        " AND MAY RESULT IN SOME DESTRUCTION\"").withStyle(ChatFormatting.RED));
    }
}