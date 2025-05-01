package net.dannykandmichaelk.firstmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.dannykandmichaelk.firstmod.FirstMod;
import net.dannykandmichaelk.firstmod.entity.custom.WerewolfEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class WerewolfRenderer extends MobRenderer<WerewolfEntity, WerewolfModel<WerewolfEntity>> {
    public WerewolfRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new WerewolfModel<>(pContext.bakeLayer(WerewolfModel.LAYER_LOCATION)), 0.85f);
    }

    @Override
    public ResourceLocation getTextureLocation(WerewolfEntity pEntity) {
        return ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "textures/entity/werewolf/werewolf.png");
    }

    @Override
    public void render(WerewolfEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pPoseStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            pPoseStack.scale(1f, 1f, 1f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}