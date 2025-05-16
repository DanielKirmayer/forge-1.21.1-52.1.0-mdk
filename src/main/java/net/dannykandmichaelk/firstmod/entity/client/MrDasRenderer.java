package net.dannykandmichaelk.firstmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.dannykandmichaelk.firstmod.FirstMod;
import net.dannykandmichaelk.firstmod.entity.custom.MrDasEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MrDasRenderer extends MobRenderer<MrDasEntity, MrDasModel<MrDasEntity>> {


    public MrDasRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new MrDasModel<>(pContext.bakeLayer(MrDasModel.LAYER_LOCATION)), 0.85f);
    }

    @Override
    public ResourceLocation getTextureLocation(MrDasEntity pEntity) {
        return ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "textures/entity/mrdas/mrdascube.png");
    }

    @Override
    public void render(MrDasEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pPoseStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            pPoseStack.scale(1f, 1f, 1f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
