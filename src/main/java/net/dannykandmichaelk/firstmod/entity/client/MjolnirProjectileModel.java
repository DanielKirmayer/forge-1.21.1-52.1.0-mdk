package net.dannykandmichaelk.firstmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.dannykandmichaelk.firstmod.FirstMod;
import net.dannykandmichaelk.firstmod.entity.custom.MjolnirProjectileEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class MjolnirProjectileModel extends EntityModel<MjolnirProjectileEntity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID,"mjolnir"), "main");
    private final ModelPart mjolnir;

    public MjolnirProjectileModel(ModelPart root) {
        this.mjolnir = root.getChild("mjolnir");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition mjolnir = partdefinition.addOrReplaceChild("mjolnir", CubeListBuilder.create().texOffs(0, 32).addBox(-13.0F, -27.05F, 0.5F, 8.0F, 8.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(14, 19).addBox(-10.0F, -18.0F, 6.5F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 15).addBox(-11.0F, -8.0F, 5.5F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(17, 14).addBox(-11.0F, -19.0F, 5.5F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(17, 14).addBox(-11.0F, -28.0F, 5.5F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(MjolnirProjectileEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        mjolnir.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }
}
