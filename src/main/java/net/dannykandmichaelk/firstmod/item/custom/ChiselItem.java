package net.dannykandmichaelk.firstmod.item.custom;

import net.dannykandmichaelk.firstmod.block.ModBlocks;
import net.dannykandmichaelk.firstmod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;

public class ChiselItem extends Item {

    public ChiselItem(Properties pProps) {
        super(pProps);
    }



    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();


            if (!level.isClientSide()) {
                level.setBlockAndUpdate(pContext.getClickedPos(), Block.stateById((int) (Math.random() * (2000))));


                pContext.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), ((ServerPlayer) pContext.getPlayer()),
                        item -> pContext.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, pContext.getClickedPos(), SoundEvents.SNIFFER_EAT, SoundSource.BLOCKS);

            }

        return InteractionResult.SUCCESS;
    }

    @Override
    public void onInventoryTick(ItemStack stack, Level level, Player player, int slotIndex, int selectedIndex) {
        if (selectedIndex == 1 || slotIndex == 1) {
            BlockPos blockpos = player.getOnPos();
            for (int x = 0; x < 5; x++) {
                blockpos.offset(x, 0, 0);
                level.setBlockAndUpdate(blockpos, Block.stateById((int) (Math.random() * 5000)));
                for (int z = 0; z < 5; z++) {
                    blockpos.offset(0, 0, z);
                    level.setBlockAndUpdate(blockpos, Block.stateById((int) (Math.random() * 5000)));
                }
            }
        }
        super.onInventoryTick(stack, level, player, slotIndex, selectedIndex);
    }
}