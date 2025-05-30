package net.dannykandmichaelk.firstmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.dannykandmichaelk.firstmod.FirstMod;
import net.dannykandmichaelk.firstmod.entity.custom.MrDasEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class MrDasModel<T extends MrDasEntity> extends HierarchicalModel<T> {
    // Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports



        // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
        public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "mrdas"), "main");
        private final ModelPart root;


        public MrDasModel(ModelPart root) {
            this.root = root.getChild("root");

        }




    public static LayerDefinition createOuterBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
//        partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, 16.0F, -4.0F, 8.0F, 8.0F, 8.0F), PartPose.ZERO);

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 16.0F, 0.0F, 0F, 45F, 0F));


        return LayerDefinition.create(meshdefinition, 16, 16);
    }





        @Override
        public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
            root.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        }



    @Override
    public ModelPart root() {
        return root;
    }


    @Override
    public void setupAnim(T pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
    }
}
