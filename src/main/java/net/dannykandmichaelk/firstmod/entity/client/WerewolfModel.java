package net.dannykandmichaelk.firstmod.entity.client;

// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import net.dannykandmichaelk.firstmod.entity.custom.WerewolfEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.util.Mth;

public class WerewolfModel<T extends WerewolfEntity> extends HierarchicalModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("modid", "werewolf"), "main");
    private final ModelPart body;
    private final ModelPart head;






    public WerewolfModel(ModelPart root) {
        this.body = root.getChild("body");
        this.head = body.getChild("lowerBody").getChild("middleBody").getChild("upperBody").getChild("lowerNeck").getChild("upperNeck").getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, -20F, 0.0F));

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(72, 36).addBox(-3.0F, -8.0F, -4.0F, 7.0F, 5.0F, 8.0F, new CubeDeformation(-0.01F))
                .texOffs(47, 82).addBox(-1.9675F, -3.142F, -4.02F, 6.0F, 3.5F, 8.0F, new CubeDeformation(-0.02F))
                .texOffs(130, 54).addBox(-0.25F, -4.25F, -2.5F, 4.5F, 6.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(130, 33).addBox(-0.25F, -4.25F, 0.5F, 4.5F, 6.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(135, 95).addBox(-0.25F, -3.25F, -0.5F, 4.5F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 93).addBox(-0.5F, -1.0F, -1.5F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -5.75F, 1.75F, 0.0F, -0.1309F, 0.0873F));

        PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(16, 111).addBox(-0.5F, -1.0F, -1.5F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0621F, -5.75F, -1.5959F, 0.0F, 0.1309F, 0.0873F));

        PartDefinition cube_r3 = body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(88, 63).addBox(0.0F, 0.0F, -4.0F, 4.0F, 3.5F, 8.0F, new CubeDeformation(-0.03F)), PartPose.offsetAndRotation(-3.0F, -3.0F, 0.0F, 0.0F, 0.0F, -0.3054F));

        PartDefinition underwear = body.addOrReplaceChild("underwear", CubeListBuilder.create().texOffs(21, 72).addBox(-0.25F, -0.5F, -4.5F, 8.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(88, 63).addBox(7.25F, -0.5F, -1.5F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offset(-3.0F, -3.0F, 0.0F));

        PartDefinition cube_r4 = underwear.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(93, 9).addBox(-0.2F, 0.2F, -4.46F, 2.0F, 4.0F, 9.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-0.0198F, 1.1223F, -0.04F, 0.0F, 0.0F, -0.3054F));

        PartDefinition cube_r5 = underwear.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(78, 74).addBox(0.0F, -5.0F, -4.475F, 4.0F, 5.0F, 9.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(1.0325F, 5.208F, -0.02F, 0.0F, 0.0F, 0.1309F));

        PartDefinition frontUnderwear = underwear.addOrReplaceChild("frontUnderwear", CubeListBuilder.create().texOffs(129, 83).addBox(-4.0F, 0.25F, 1.25F, 4.0F, 3.5F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(49, 83).addBox(-0.5F, 1.25F, 1.75F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(64, 99).addBox(-0.25F, 1.75F, 2.25F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(7.8828F, 1.0614F, -2.76F, 0.0F, 0.0F, -0.2618F));

        PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(58, 118).addBox(-6.0F, 0.0F, -2.0F, 6.0F, 3.5F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -6.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

        PartDefinition tail_1 = tail.addOrReplaceChild("tail_1", CubeListBuilder.create().texOffs(97, 44).addBox(-7.1309F, -2.1694F, -2.5F, 7.0F, 4.5F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.75F, 1.75F, 0.0F, 0.0F, 0.0F, 0.6981F));

        PartDefinition tail_2 = tail_1.addOrReplaceChild("tail_2", CubeListBuilder.create().texOffs(95, 74).addBox(-6.7121F, -2.3856F, -2.5F, 7.0F, 4.5F, 5.0F, new CubeDeformation(0.11F)), PartPose.offsetAndRotation(-5.9302F, 0.2626F, 0.0F, 0.0F, 0.0F, 0.7418F));

        PartDefinition tail_3 = tail_2.addOrReplaceChild("tail_3", CubeListBuilder.create().texOffs(62, 36).addBox(-4.9835F, -1.4581F, -1.5F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.11F)), PartPose.offsetAndRotation(-6.9621F, -0.1356F, 0.0F, 0.0F, 0.0F, -0.5672F));

        PartDefinition tail_4 = tail_3.addOrReplaceChild("tail_4", CubeListBuilder.create().texOffs(11, 107).addBox(-3.1435F, -0.9816F, -0.54F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.15F)), PartPose.offsetAndRotation(-5.0354F, 0.0408F, -0.5F, 0.0F, 0.0F, -0.6109F));

        PartDefinition tighLeft = body.addOrReplaceChild("tighLeft", CubeListBuilder.create().texOffs(64, 102).addBox(-2.5F, 0.0F, -3.0F, 5.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -2.0F, -1.25F, -0.48F, 0.0F, -0.5236F));

        PartDefinition cube_r6 = tighLeft.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(98, 133).addBox(-1.25F, -5.0F, -2.0F, 3.25F, 5.0F, 2.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(-0.015F, 8.0645F, 1.8829F, 0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r7 = tighLeft.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 135).addBox(-0.75F, -4.0F, -2.25F, 3.25F, 4.0F, 2.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-0.5F, 12.0F, 1.25F, -0.2182F, 0.0F, 0.0F));

        PartDefinition cube_r8 = tighLeft.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(46, 132).addBox(-0.75F, -6.0F, 0.0F, 3.25F, 6.0F, 2.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-0.5F, 12.0F, -3.0F, 0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r9 = tighLeft.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(135, 62).addBox(-0.75F, -4.0F, 0.0F, 3.25F, 4.0F, 2.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(-0.5F, 6.1108F, -4.0384F, -0.3054F, 0.0F, 0.0F));

        PartDefinition cube_r10 = tighLeft.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(74, 123).addBox(-3.0F, -2.75F, -1.75F, 4.0F, 5.0F, 4.5F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(-0.4675F, 1.108F, -1.23F, 0.2618F, 0.0F, 0.1745F));

        PartDefinition tighFurLeft = tighLeft.addOrReplaceChild("tighFurLeft", CubeListBuilder.create().texOffs(76, 17).addBox(0.05F, 0.0F, -2.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 11.0F, -1.0F));

        PartDefinition legLeft = tighLeft.addOrReplaceChild("legLeft", CubeListBuilder.create().texOffs(42, 110).addBox(-2.5F, 0.0F, -2.5F, 3.0F, 10.0F, 5.0F, new CubeDeformation(0.01F))
                .texOffs(82, 102).addBox(-2.0F, 0.0F, -2.0F, 4.5F, 12.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 10.0F, -1.0F, 0.3054F, -0.3054F, 0.9599F));

        PartDefinition cube_r11 = legLeft.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(123, 125).addBox(0.0F, -3.0F, -2.5F, 2.0F, 3.0F, 5.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-2.5F, 9.0F, 0.0F, 0.0F, 0.0F, -0.5672F));

        PartDefinition cube_r12 = legLeft.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(121, 57).addBox(0.0F, -6.0F, -2.5F, 2.0F, 6.0F, 5.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(-4.1012F, 6.4867F, 0.0F, 0.0F, 0.0F, 0.2574F));

        PartDefinition legArmorLeft = legLeft.addOrReplaceChild("legArmorLeft", CubeListBuilder.create().texOffs(114, 30).addBox(-6.0F, 4.5F, -3.0F, 4.5F, 9.0F, 4.0F, new CubeDeformation(0.25F))
                .texOffs(16, 98).addBox(-1.75F, 6.375F, -1.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 98).addBox(-1.75F, 7.925F, -1.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 98).addBox(-1.75F, 9.55F, -1.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 98).addBox(-1.75F, 11.175F, -1.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 98).addBox(-1.75F, 12.775F, -1.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -3.0F, 1.0F));

        PartDefinition cube_r13 = legArmorLeft.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(52, 56).addBox(-4.5F, -0.5F, -2.5F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-2.25F, 5.5F, -1.0F, 0.0F, 0.0F, 0.3054F));

        PartDefinition cube_r14 = legArmorLeft.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(52, 56).addBox(-4.5F, -0.5F, -2.5F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-2.75F, 9.5F, -1.0F, 0.0F, 0.0F, -0.4363F));

        PartDefinition legFurLeft = legLeft.addOrReplaceChild("legFurLeft", CubeListBuilder.create().texOffs(76, 13).addBox(-0.05F, 0.0F, -2.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offset(-2.0F, 11.0F, 0.0F));

        PartDefinition shankLeft = legLeft.addOrReplaceChild("shankLeft", CubeListBuilder.create().texOffs(0, 122).addBox(0.0F, 0.0F, -1.5F, 3.0F, 10.0F, 3.0F, new CubeDeformation(-0.02F))
                .texOffs(16, 98).addBox(2.5F, 5.525F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 98).addBox(-0.5F, 5.525F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 98).addBox(1.0F, 5.525F, -2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 11.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition footToe9 = shankLeft.addOrReplaceChild("footToe9", CubeListBuilder.create().texOffs(19, 79).addBox(0.0F, -0.625F, -0.625F, 2.5F, 1.25F, 1.25F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 3.375F, 0.75F, 0.0F, -0.48F, 1.7453F));

        PartDefinition toeNail9 = footToe9.addOrReplaceChild("toeNail9", CubeListBuilder.create(), PartPose.offset(2.3195F, -0.4427F, -0.0222F));

        PartDefinition cube_r15 = toeNail9.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(98, 15).addBox(4.5F, 0.75F, -2.5F, 1.25F, 1.0F, 1.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(-4.0695F, -2.4323F, 1.9972F, 0.0F, 0.0F, 0.3491F));

        PartDefinition toeNail4_3 = toeNail9.addOrReplaceChild("toeNail4_3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.9317F, 0.296F, -0.0052F, 0.0F, 0.0F, 0.2618F));

        PartDefinition cube_r16 = toeNail4_3.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(98, 13).addBox(5.25F, 0.75F, -2.5F, 1.5F, 1.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-4.7927F, -2.7678F, 2.0024F, 0.0F, 0.0F, 0.3491F));

        PartDefinition toeNail4_4 = toeNail4_3.addOrReplaceChild("toeNail4_4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.533F, 0.3234F, 0.0024F, 0.0F, 0.0F, 0.3491F));

        PartDefinition footLeft = shankLeft.addOrReplaceChild("footLeft", CubeListBuilder.create(), PartPose.offsetAndRotation(1.75F, 8.5F, 0.0F, 0.0F, 0.0F, 0.3491F));

        PartDefinition cube_r17 = footLeft.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(128, 12).addBox(-1.0881F, -0.0449F, -2.0F, 4.5F, 1.5F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-0.75F, -0.75F, 0.0F, 0.0F, 0.0F, 0.48F));

        PartDefinition soleLeft = footLeft.addOrReplaceChild("soleLeft", CubeListBuilder.create().texOffs(126, 114).addBox(0.0F, -0.75F, -2.25F, 4.0F, 1.5F, 4.5F, new CubeDeformation(0.01F)), PartPose.offset(0.5F, 1.25F, 0.0F));

        PartDefinition footToe1 = soleLeft.addOrReplaceChild("footToe1", CubeListBuilder.create().texOffs(19, 79).addBox(0.0F, -0.625F, -0.625F, 2.5F, 1.25F, 1.25F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.75F, 0.125F, -1.75F, 0.0F, 0.1309F, 0.0F));

        PartDefinition toeNail1 = footToe1.addOrReplaceChild("toeNail1", CubeListBuilder.create(), PartPose.offset(2.3195F, -0.4427F, -0.0222F));

        PartDefinition cube_r18 = toeNail1.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(98, 15).addBox(4.5F, 0.75F, -2.5F, 1.25F, 1.0F, 1.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(-4.0695F, -2.4323F, 1.9972F, 0.0F, 0.0F, 0.3491F));

        PartDefinition toeNail1_1 = toeNail1.addOrReplaceChild("toeNail1_1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.9317F, 0.296F, -0.0052F, 0.0F, 0.0F, 0.2618F));

        PartDefinition cube_r19 = toeNail1_1.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(98, 13).addBox(5.25F, 0.75F, -2.5F, 1.5F, 1.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-4.7927F, -2.7678F, 2.0024F, 0.0F, 0.0F, 0.3491F));

        PartDefinition toeNail1_2 = toeNail1_1.addOrReplaceChild("toeNail1_2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.533F, 0.3234F, 0.0024F, 0.0F, 0.0F, 0.3491F));

        PartDefinition footToe2 = soleLeft.addOrReplaceChild("footToe2", CubeListBuilder.create().texOffs(19, 79).addBox(0.0F, -0.625F, -0.625F, 2.5F, 1.25F, 1.25F, new CubeDeformation(0.0F)), PartPose.offset(3.55F, 0.125F, -0.625F));

        PartDefinition toeNail2 = footToe2.addOrReplaceChild("toeNail2", CubeListBuilder.create(), PartPose.offset(2.3195F, -0.4427F, -0.0222F));

        PartDefinition cube_r20 = toeNail2.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(98, 15).addBox(4.5F, 0.75F, -2.5F, 1.25F, 1.0F, 1.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(-4.0695F, -2.4323F, 1.9972F, 0.0F, 0.0F, 0.3491F));

        PartDefinition toeNail2_1 = toeNail2.addOrReplaceChild("toeNail2_1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.9317F, 0.296F, -0.0052F, 0.0F, 0.0F, 0.2618F));

        PartDefinition cube_r21 = toeNail2_1.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(98, 13).addBox(5.25F, 0.75F, -2.5F, 1.5F, 1.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-4.7927F, -2.7678F, 2.0024F, 0.0F, 0.0F, 0.3491F));

        PartDefinition toeNail2_2 = toeNail2_1.addOrReplaceChild("toeNail2_2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.533F, 0.3234F, 0.0024F, 0.0F, 0.0F, 0.3491F));

        PartDefinition footToe3 = soleLeft.addOrReplaceChild("footToe3", CubeListBuilder.create().texOffs(19, 79).addBox(0.0F, -0.625F, -0.625F, 2.5F, 1.25F, 1.25F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.25F, 0.125F, 0.6F, 0.0F, -0.0873F, 0.0F));

        PartDefinition toeNail3 = footToe3.addOrReplaceChild("toeNail3", CubeListBuilder.create(), PartPose.offset(2.3195F, -0.4427F, -0.0222F));

        PartDefinition cube_r22 = toeNail3.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(98, 15).addBox(4.5F, 0.75F, -2.5F, 1.25F, 1.0F, 1.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(-4.0695F, -2.4323F, 1.9972F, 0.0F, 0.0F, 0.3491F));

        PartDefinition toeNail3_1 = toeNail3.addOrReplaceChild("toeNail3_1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.9317F, 0.296F, -0.0052F, 0.0F, 0.0F, 0.2618F));

        PartDefinition cube_r23 = toeNail3_1.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(98, 13).addBox(5.25F, 0.75F, -2.5F, 1.5F, 1.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-4.7927F, -2.7678F, 2.0024F, 0.0F, 0.0F, 0.3491F));

        PartDefinition toeNail3_2 = toeNail3_1.addOrReplaceChild("toeNail3_2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.533F, 0.3234F, 0.0024F, 0.0F, 0.0F, 0.3491F));

        PartDefinition footToe4 = soleLeft.addOrReplaceChild("footToe4", CubeListBuilder.create().texOffs(19, 79).addBox(0.0F, -0.625F, -0.625F, 2.5F, 1.25F, 1.25F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.75F, 0.125F, 1.75F, 0.0F, -0.1745F, 0.0F));

        PartDefinition toeNail4 = footToe4.addOrReplaceChild("toeNail4", CubeListBuilder.create(), PartPose.offset(2.3195F, -0.4427F, -0.0222F));

        PartDefinition cube_r24 = toeNail4.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(98, 15).addBox(4.5F, 0.75F, -2.5F, 1.25F, 1.0F, 1.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(-4.0695F, -2.4323F, 1.9972F, 0.0F, 0.0F, 0.3491F));

        PartDefinition toeNail4_1 = toeNail4.addOrReplaceChild("toeNail4_1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.9317F, 0.296F, -0.0052F, 0.0F, 0.0F, 0.2618F));

        PartDefinition cube_r25 = toeNail4_1.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(98, 13).addBox(5.25F, 0.75F, -2.5F, 1.5F, 1.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-4.7927F, -2.7678F, 2.0024F, 0.0F, 0.0F, 0.3491F));

        PartDefinition toeNail4_2 = toeNail4_1.addOrReplaceChild("toeNail4_2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.533F, 0.3234F, 0.0024F, 0.0F, 0.0F, 0.3491F));

        PartDefinition tighRight = body.addOrReplaceChild("tighRight", CubeListBuilder.create().texOffs(24, 101).addBox(-2.5F, 0.0F, -1.0F, 5.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -2.0F, 1.25F, 0.48F, 0.0F, -0.5236F));

        PartDefinition cube_r26 = tighRight.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(69, 132).addBox(-1.25F, -5.0F, 0.0F, 3.25F, 5.0F, 2.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(-0.015F, 8.0645F, -1.8829F, -0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r27 = tighRight.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(134, 72).addBox(-0.75F, -4.0F, 0.25F, 3.25F, 4.0F, 2.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-0.5F, 12.0F, -1.25F, 0.2182F, 0.0F, 0.0F));

        PartDefinition cube_r28 = tighRight.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(114, 131).addBox(-0.75F, -6.0F, -2.0F, 3.25F, 6.0F, 2.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-0.5F, 12.0F, 3.0F, -0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r29 = tighRight.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(134, 133).addBox(-0.75F, -4.0F, -2.0F, 3.25F, 4.0F, 2.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(-0.5F, 6.1108F, 4.0384F, 0.3054F, 0.0F, 0.0F));

        PartDefinition cube_r30 = tighRight.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(46, 72).addBox(-3.0F, -2.75F, -2.75F, 4.0F, 5.0F, 4.5F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(-0.4675F, 1.108F, 1.23F, -0.2618F, 0.0F, 0.1745F));

        PartDefinition tighFurRight = tighRight.addOrReplaceChild("tighFurRight", CubeListBuilder.create().texOffs(62, 38).addBox(0.05F, 0.0F, -2.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 11.0F, 1.0F));

        PartDefinition legRight = tighRight.addOrReplaceChild("legRight", CubeListBuilder.create().texOffs(0, 107).addBox(-2.5F, 0.0F, -2.5F, 3.0F, 10.0F, 5.0F, new CubeDeformation(0.01F))
                .texOffs(0, 0).addBox(-2.0F, 0.0F, -2.0F, 4.5F, 12.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 10.0F, 1.0F, -0.3054F, 0.3054F, 0.9599F));

        PartDefinition cube_r31 = legRight.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(55, 0).addBox(0.0F, -3.0F, -2.5F, 2.0F, 3.0F, 5.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-2.5F, 9.0F, 0.0F, 0.0F, 0.0F, -0.5672F));

        PartDefinition cube_r32 = legRight.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(31, 120).addBox(0.0F, -6.0F, -2.5F, 2.0F, 6.0F, 5.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(-4.1012F, 6.4867F, 0.0F, 0.0F, 0.0F, 0.2574F));

        PartDefinition legArmorRight = legRight.addOrReplaceChild("legArmorRight", CubeListBuilder.create().texOffs(114, 30).addBox(-6.0F, 4.5F, 1.5F, 4.5F, 9.0F, 4.0F, new CubeDeformation(0.25F))
                .texOffs(16, 98).addBox(-1.75F, 6.375F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 98).addBox(-1.75F, 7.925F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 98).addBox(-1.75F, 9.55F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 98).addBox(-1.75F, 11.175F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 98).addBox(-1.75F, 12.775F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -3.0F, -3.5F));

        PartDefinition cube_r33 = legArmorRight.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(52, 56).addBox(-4.5F, -0.5F, -2.5F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-2.25F, 5.5F, 3.5F, 0.0F, 0.0F, 0.3054F));

        PartDefinition cube_r34 = legArmorRight.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(52, 56).addBox(-4.5F, -0.5F, -2.5F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-2.75F, 9.5F, 3.5F, 0.0F, 0.0F, -0.4363F));

        PartDefinition legFurRIght = legRight.addOrReplaceChild("legFurRIght", CubeListBuilder.create().texOffs(60, 58).addBox(0.0F, 0.0F, -2.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offset(-2.05F, 11.0F, 0.0F));

        PartDefinition shankRight = legRight.addOrReplaceChild("shankRight", CubeListBuilder.create().texOffs(0, 24).addBox(0.0F, 0.0F, -1.5F, 3.0F, 10.0F, 3.0F, new CubeDeformation(-0.02F))
                .texOffs(16, 98).addBox(2.5F, 5.525F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 98).addBox(-0.5F, 5.525F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 98).addBox(1.0F, 5.525F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 11.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition footToe10 = shankRight.addOrReplaceChild("footToe10", CubeListBuilder.create().texOffs(19, 79).addBox(-0.154F, 0.2485F, -0.1633F, 2.5F, 1.25F, 1.25F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.154F, 3.5015F, -1.2117F, 0.0F, 0.48F, 1.7453F));

        PartDefinition toeNail10 = footToe10.addOrReplaceChild("toeNail10", CubeListBuilder.create(), PartPose.offset(2.3195F, -0.4427F, -0.0222F));

        PartDefinition cube_r35 = toeNail10.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(98, 15).addBox(4.5F, 0.75F, -2.5F, 1.25F, 1.0F, 1.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(-4.2236F, -1.5587F, 2.459F, 0.0F, 0.0F, 0.3491F));

        PartDefinition toeNail4_5 = toeNail10.addOrReplaceChild("toeNail4_5", CubeListBuilder.create(), PartPose.offsetAndRotation(0.9317F, 0.296F, -0.0052F, 0.0F, 0.0F, 0.2618F));

        PartDefinition cube_r36 = toeNail4_5.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(98, 13).addBox(5.25F, 0.75F, -2.5F, 1.5F, 1.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-4.9467F, -1.8943F, 2.4641F, 0.0F, 0.0F, 0.3491F));

        PartDefinition toeNail4_6 = toeNail4_5.addOrReplaceChild("toeNail4_6", CubeListBuilder.create(), PartPose.offsetAndRotation(0.533F, 0.3234F, 0.0024F, 0.0F, 0.0F, 0.3491F));

        PartDefinition footRight = shankRight.addOrReplaceChild("footRight", CubeListBuilder.create(), PartPose.offsetAndRotation(1.75F, 8.5F, 0.0F, 0.0F, 0.0F, 0.3491F));

        PartDefinition cube_r37 = footRight.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(126, 106).addBox(-1.0881F, -0.0449F, -2.0F, 4.5F, 1.5F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-0.75F, -0.75F, 0.0F, 0.0F, 0.0F, 0.48F));

        PartDefinition soleRight = footRight.addOrReplaceChild("soleRight", CubeListBuilder.create().texOffs(126, 101).addBox(0.0F, -0.75F, -2.25F, 4.0F, 1.5F, 4.5F, new CubeDeformation(0.01F)), PartPose.offset(0.5F, 1.25F, 0.0F));

        PartDefinition footToe5 = soleRight.addOrReplaceChild("footToe5", CubeListBuilder.create().texOffs(70, 17).addBox(0.0F, -0.625F, -0.625F, 2.5F, 1.25F, 1.25F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.75F, 0.125F, -1.75F, 0.0F, 0.1745F, 0.0F));

        PartDefinition toeNail5 = footToe5.addOrReplaceChild("toeNail5", CubeListBuilder.create(), PartPose.offset(2.3195F, -0.4427F, 0.0222F));

        PartDefinition cube_r38 = toeNail5.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(98, 15).addBox(4.5F, 0.75F, 1.5F, 1.25F, 1.0F, 1.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(-4.0695F, -2.4323F, -1.9972F, 0.0F, 0.0F, 0.3491F));

        PartDefinition toeNail5_1 = toeNail5.addOrReplaceChild("toeNail5_1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.9317F, 0.296F, 0.0052F, 0.0F, 0.0F, 0.2618F));

        PartDefinition cube_r39 = toeNail5_1.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(98, 13).addBox(5.25F, 0.75F, 1.5F, 1.5F, 1.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-4.7927F, -2.7678F, -2.0024F, 0.0F, 0.0F, 0.3491F));

        PartDefinition toeNail5_2 = toeNail5_1.addOrReplaceChild("toeNail5_2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.533F, 0.3234F, -0.0024F, 0.0F, 0.0F, 0.3491F));

        PartDefinition footToe6 = soleRight.addOrReplaceChild("footToe6", CubeListBuilder.create().texOffs(70, 17).addBox(0.0F, -0.625F, -0.625F, 2.5F, 1.25F, 1.25F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.25F, 0.125F, -0.625F, 0.0F, 0.0873F, 0.0F));

        PartDefinition toeNail6 = footToe6.addOrReplaceChild("toeNail6", CubeListBuilder.create(), PartPose.offset(2.3195F, -0.4427F, 0.0222F));

        PartDefinition cube_r40 = toeNail6.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(98, 15).addBox(4.5F, 0.75F, 1.5F, 1.25F, 1.0F, 1.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(-4.0695F, -2.4323F, -1.9972F, 0.0F, 0.0F, 0.3491F));

        PartDefinition toeNail6_1 = toeNail6.addOrReplaceChild("toeNail6_1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.9317F, 0.296F, 0.0052F, 0.0F, 0.0F, 0.2618F));

        PartDefinition cube_r41 = toeNail6_1.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(98, 13).addBox(5.25F, 0.75F, 1.5F, 1.5F, 1.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-4.7927F, -2.7678F, -2.0024F, 0.0F, 0.0F, 0.3491F));

        PartDefinition toeNail6_2 = toeNail6_1.addOrReplaceChild("toeNail6_2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.533F, 0.3234F, -0.0024F, 0.0F, 0.0F, 0.3491F));

        PartDefinition footToe7 = soleRight.addOrReplaceChild("footToe7", CubeListBuilder.create().texOffs(70, 17).addBox(0.0F, -0.625F, -0.625F, 2.5F, 1.25F, 1.25F, new CubeDeformation(0.0F)), PartPose.offset(3.55F, 0.125F, 0.6F));

        PartDefinition toeNail7 = footToe7.addOrReplaceChild("toeNail7", CubeListBuilder.create(), PartPose.offset(2.3195F, -0.4427F, 0.0222F));

        PartDefinition cube_r42 = toeNail7.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(98, 15).addBox(4.5F, 0.75F, 1.5F, 1.25F, 1.0F, 1.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(-4.0695F, -2.4323F, -1.9972F, 0.0F, 0.0F, 0.3491F));

        PartDefinition toeNail7_1 = toeNail7.addOrReplaceChild("toeNail7_1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.9317F, 0.296F, 0.0052F, 0.0F, 0.0F, 0.2618F));

        PartDefinition cube_r43 = toeNail7_1.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(98, 13).addBox(5.25F, 0.75F, 1.5F, 1.5F, 1.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-4.7927F, -2.7678F, -2.0024F, 0.0F, 0.0F, 0.3491F));

        PartDefinition toeNail7_2 = toeNail7_1.addOrReplaceChild("toeNail7_2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.533F, 0.3234F, -0.0024F, 0.0F, 0.0F, 0.3491F));

        PartDefinition footToe8 = soleRight.addOrReplaceChild("footToe8", CubeListBuilder.create().texOffs(70, 17).addBox(0.0F, -0.625F, -0.625F, 2.5F, 1.25F, 1.25F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.75F, 0.125F, 1.75F, 0.0F, -0.1309F, 0.0F));

        PartDefinition toeNail8 = footToe8.addOrReplaceChild("toeNail8", CubeListBuilder.create(), PartPose.offset(2.3195F, -0.4427F, 0.0222F));

        PartDefinition cube_r44 = toeNail8.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(98, 15).addBox(4.5F, 0.75F, 1.5F, 1.25F, 1.0F, 1.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(-4.0695F, -2.4323F, -1.9972F, 0.0F, 0.0F, 0.3491F));

        PartDefinition toeNail8_1 = toeNail8.addOrReplaceChild("toeNail8_1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.9317F, 0.296F, 0.0052F, 0.0F, 0.0F, 0.2618F));

        PartDefinition cube_r45 = toeNail8_1.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(98, 13).addBox(5.25F, 0.75F, 1.5F, 1.5F, 1.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-4.7927F, -2.7678F, -2.0024F, 0.0F, 0.0F, 0.3491F));

        PartDefinition toeNail8_2 = toeNail8_1.addOrReplaceChild("toeNail8_2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.533F, 0.3234F, -0.0024F, 0.0F, 0.0F, 0.3491F));

        PartDefinition lowerBody = body.addOrReplaceChild("lowerBody", CubeListBuilder.create().texOffs(0, 64).addBox(-5.0F, -5.0F, -4.0F, 7.0F, 7.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 93).addBox(-5.0F, 0.0F, -4.0F, 4.0F, 6.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(2.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

        PartDefinition cube_r46 = lowerBody.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(76, 136).addBox(-1.0F, -1.0F, -1.75F, 2.0F, 2.0F, 3.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.75F, -0.5F, 2.0F, 0.0436F, -0.1309F, 0.0873F));

        PartDefinition cube_r47 = lowerBody.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(76, 17).addBox(-3.75F, -0.75F, -4.5F, 4.0F, 4.0F, 9.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-1.1477F, -1.5802F, 0.0F, 0.0F, 0.0F, 0.1309F));

        PartDefinition cube_r48 = lowerBody.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(19, 137).addBox(-1.0F, -1.0F, -1.75F, 2.0F, 2.0F, 3.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.75F, -0.5F, -2.0F, -0.0436F, 0.1309F, 0.0873F));

        PartDefinition cube_r49 = lowerBody.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(90, 124).addBox(-5.0F, -6.0F, 0.0F, 7.0F, 6.0F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 2.0F, -4.0F, 0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r50 = lowerBody.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(45, 125).addBox(-5.0F, -6.0F, -1.0F, 7.0F, 6.0F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 2.0F, 4.0F, -0.1745F, 0.0F, 0.0F));

        PartDefinition middleBody = lowerBody.addOrReplaceChild("middleBody", CubeListBuilder.create().texOffs(60, 0).addBox(-2.8977F, -4.8302F, -5.0F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.01F))
                .texOffs(60, 56).addBox(-3.3977F, -4.8302F, -5.0F, 4.0F, 8.0F, 10.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-2.5F, -4.5F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r51 = middleBody.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(98, 102).addBox(-5.0F, -6.0F, 0.0F, 8.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1023F, 2.1698F, -5.0F, 0.4363F, 0.0F, 0.0F));

        PartDefinition cube_r52 = middleBody.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(104, 53).addBox(-5.0F, -6.0F, -3.0F, 8.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1023F, 2.1698F, 5.0F, -0.4363F, 0.0F, 0.0F));

        PartDefinition cube_r53 = middleBody.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(20, 57).addBox(-0.5F, -1.25F, -2.0F, 1.0F, 2.5F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.3523F, 0.4198F, -2.25F, -0.0873F, 0.1309F, 0.0873F));

        PartDefinition cube_r54 = middleBody.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(56, 134).addBox(-0.5F, -1.25F, -2.0F, 1.0F, 2.5F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.3523F, 0.4198F, 2.25F, 0.0873F, -0.1309F, 0.0873F));

        PartDefinition upperBody = middleBody.addOrReplaceChild("upperBody", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -6.75F, -8.5F, 8.0F, 7.0F, 17.0F, new CubeDeformation(0.0F))
                .texOffs(49, 19).addBox(-3.0F, -4.25F, -5.5F, 8.0F, 6.0F, 11.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-0.8977F, -3.0802F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition necklace = upperBody.addOrReplaceChild("necklace", CubeListBuilder.create().texOffs(18, 0).addBox(-5.5F, -13.75F, -7.5F, 11.5F, 0.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 6.75F, 0.0F));

        PartDefinition necklace_1 = necklace.addOrReplaceChild("necklace_1", CubeListBuilder.create().texOffs(35, 15).addBox(-5.5F, 0.0F, -7.5F, 5.5F, 0.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5F, -13.75F, 0.0F, 0.0F, 0.0F, -1.4399F));

        PartDefinition necklace_2 = necklace.addOrReplaceChild("necklace_2", CubeListBuilder.create().texOffs(0, 31).addBox(0.1255F, -0.2174F, -7.5F, 0.0F, 11.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -13.5F, 0.0F, 0.0F, 0.0F, -0.5236F));

        PartDefinition chestRight = upperBody.addOrReplaceChild("chestRight", CubeListBuilder.create().texOffs(0, 79).addBox(-3.0F, -4.0F, -3.0F, 6.0F, 7.0F, 7.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(5.0F, -2.25F, 3.25F, 0.0873F, 0.0F, 0.0F));

        PartDefinition nippleRight = chestRight.addOrReplaceChild("nippleRight", CubeListBuilder.create().texOffs(64, 97).addBox(-0.775F, -0.5209F, -0.4342F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.775F, 1.3959F, 1.6592F));

        PartDefinition nippleRingRight = nippleRight.addOrReplaceChild("nippleRingRight", CubeListBuilder.create().texOffs(43, 32).addBox(0.0F, 0.0076F, -0.9243F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

        PartDefinition leftChest = upperBody.addOrReplaceChild("leftChest", CubeListBuilder.create().texOffs(78, 49).addBox(-3.0F, -4.0F, -4.0F, 6.0F, 7.0F, 7.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(5.0F, -2.25F, -3.5F, -0.0873F, 0.0F, 0.0F));

        PartDefinition nippleLeft = leftChest.addOrReplaceChild("nippleLeft", CubeListBuilder.create().texOffs(16, 96).addBox(-0.775F, -0.5209F, -0.4342F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.775F, 1.3959F, -1.8408F));

        PartDefinition nippleRingLeft = nippleLeft.addOrReplaceChild("nippleRingLeft", CubeListBuilder.create().texOffs(9, 22).addBox(0.0F, 0.0076F, -0.9243F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

        PartDefinition armLeft = upperBody.addOrReplaceChild("armLeft", CubeListBuilder.create().texOffs(69, 88).addBox(-3.0F, 0.2321F, -5.7141F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -5.75F, -6.5F, -0.5672F, 0.0F, -0.2182F));

        PartDefinition pauldronLeft = armLeft.addOrReplaceChild("pauldronLeft", CubeListBuilder.create().texOffs(86, 0).addBox(-4.0F, -4.5F, -5.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.1F))
                .texOffs(119, 78).addBox(-4.0F, 0.5F, -2.0F, 7.0F, 2.0F, 3.5F, new CubeDeformation(0.0F))
                .texOffs(102, 22).addBox(-4.5F, -1.75F, -5.5F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(55, 74).addBox(-5.0F, -5.5F, -6.25F, 9.0F, 1.5F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(16, 117).addBox(-4.75F, -4.5F, -2.25F, 8.5F, 5.5F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(113, 96).addBox(-4.75F, -1.0F, -5.75F, 8.5F, 2.0F, 3.5F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 5.2321F, -0.7141F));

        PartDefinition pauldronLeftComponent = pauldronLeft.addOrReplaceChild("pauldronLeftComponent", CubeListBuilder.create().texOffs(31, 24).addBox(-3.0F, -3.75F, -1.5F, 6.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 0.75F, -4.5F));

        PartDefinition pauldronLeftHead = pauldronLeftComponent.addOrReplaceChild("pauldronLeftHead", CubeListBuilder.create().texOffs(57, 128).addBox(-1.5F, 1.5F, -7.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(138, 22).addBox(-1.5F, 3.5F, -7.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(-0.01F))
                .texOffs(96, 11).addBox(-0.75F, 1.25F, -7.25F, 1.5F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(12, 124).addBox(-2.5F, 0.0F, -3.0F, 5.0F, 4.0F, 3.0F, new CubeDeformation(0.01F))
                .texOffs(128, 68).addBox(-2.5F, 3.5F, -3.0F, 5.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.5F, -0.5F, 0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r55 = pauldronLeftHead.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(12, 14).addBox(0.0F, 0.0F, -2.5F, 0.0F, 1.0F, 2.5F, new CubeDeformation(-0.01F))
                .texOffs(80, 74).addBox(0.0F, -2.0F, -2.5F, 1.0F, 2.0F, 2.5F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-2.5F, 3.5F, -3.0F, 0.0F, -0.4145F, 0.0F));

        PartDefinition cube_r56 = pauldronLeftHead.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(9, 24).addBox(0.0F, 0.0F, -2.5F, 0.0F, 1.0F, 2.5F, new CubeDeformation(-0.01F))
                .texOffs(0, 79).addBox(-1.0F, -2.0F, -2.5F, 1.0F, 2.0F, 2.5F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(2.4953F, 3.5F, -3.0F, 0.0F, 0.4145F, 0.0F));

        PartDefinition cube_r57 = pauldronLeftHead.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(29, 137).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 2.0F, 2.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 0.9143F, -5.2362F, 0.9163F, 0.0F, 0.0F));

        PartDefinition cube_r58 = pauldronLeftHead.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(135, 17).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.0F, 0.2618F, 0.0F, 0.0F));

        PartDefinition pauldronLeftJaw = pauldronLeftHead.addOrReplaceChild("pauldronLeftJaw", CubeListBuilder.create().texOffs(126, 0).addBox(-2.5F, -1.0F, -3.0F, 5.0F, 1.0F, 3.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, 4.5F, 0.0F, 0.3054F, 0.0F, 0.0F));

        PartDefinition cube_r59 = pauldronLeftJaw.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(70, 42).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.0F, -0.8727F, 0.0F, 0.0F));

        PartDefinition pauldronLeftJawFront = pauldronLeftJaw.addOrReplaceChild("pauldronLeftJawFront", CubeListBuilder.create().texOffs(128, 119).addBox(-1.5F, -1.0F, -4.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(104, 83).addBox(-1.5F, -2.0F, -4.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.0F, -0.0436F, 0.0F, 0.0F));

        PartDefinition cube_r60 = pauldronLeftJawFront.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(0, 13).addBox(0.0F, -1.0F, -3.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4865F, -0.99F, -0.0062F, 0.0F, -0.3054F, 0.0F));

        PartDefinition cube_r61 = pauldronLeftJawFront.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(93, 14).addBox(0.0F, 0.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-2.5F, -1.0F, 0.0F, 0.0F, -0.3054F, 0.0F));

        PartDefinition cube_r62 = pauldronLeftJawFront.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(6, 13).addBox(0.0F, 0.0F, -3.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.4828F, -1.99F, -0.0065F, 0.0F, 0.3054F, 0.0F));

        PartDefinition cube_r63 = pauldronLeftJawFront.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(108, 136).addBox(-1.0F, 0.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(2.4953F, -1.0F, 0.0F, 0.0F, 0.3054F, 0.0F));

        PartDefinition upperArmLeft = armLeft.addOrReplaceChild("upperArmLeft", CubeListBuilder.create().texOffs(94, 30).addBox(-3.0F, 0.0F, -1.0F, 5.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 6.7321F, -3.9641F, 0.2182F, 0.0F, -0.1745F));

        PartDefinition pauldronLeft_1 = upperArmLeft.addOrReplaceChild("pauldronLeft_1", CubeListBuilder.create().texOffs(106, 9).addBox(-3.5F, -0.75F, -6.0F, 7.0F, 4.0F, 4.0F, new CubeDeformation(0.1F))
                .texOffs(106, 0).addBox(-4.0F, 2.75F, -6.5F, 8.0F, 1.0F, 4.5F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 0.25F, 3.75F));

        PartDefinition pauldronLeft_1_1 = pauldronLeft_1.addOrReplaceChild("pauldronLeft_1_1", CubeListBuilder.create().texOffs(26, 83).addBox(-3.25F, 0.0F, -2.0F, 6.5F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.75F, -3.5F, -0.0873F, 0.0F, 0.0F));

        PartDefinition pauldronLeft_1_2 = pauldronLeft_1_1.addOrReplaceChild("pauldronLeft_1_2", CubeListBuilder.create().texOffs(78, 63).addBox(-2.75F, 0.0F, -1.5F, 5.5F, 2.0F, 1.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, -0.25F, -0.1745F, 0.0F, -0.0873F));

        PartDefinition pauldronLeft_1_3 = pauldronLeft_1_2.addOrReplaceChild("pauldronLeft_1_3", CubeListBuilder.create().texOffs(97, 53).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, -0.25F, -0.2182F, 0.0F, -0.0873F));

        PartDefinition lowerArmLeft = upperArmLeft.addOrReplaceChild("lowerArmLeft", CubeListBuilder.create().texOffs(113, 83).addBox(-2.5F, 0.0F, -2.0F, 5.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 8.0F, 1.5F, 0.3447F, 0.0524F, -0.5236F));

        PartDefinition cube_r64 = lowerArmLeft.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(34, 131).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 4.0712F, 2.7805F, 0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r65 = lowerArmLeft.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(124, 133).addBox(-1.5F, -3.0F, -2.0F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.8441F, 1.4947F, -0.3927F, 0.0F, 0.0F));

        PartDefinition cube_r66 = lowerArmLeft.addOrReplaceChild("cube_r66", CubeListBuilder.create().texOffs(53, 110).addBox(-1.5F, -3.0F, -2.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 9.7788F, 0.9773F, -0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r67 = lowerArmLeft.addOrReplaceChild("cube_r67", CubeListBuilder.create().texOffs(88, 131).addBox(-1.5F, -6.0F, 0.0F, 3.0F, 6.0F, 2.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 10.0F, -2.0F, 0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r68 = lowerArmLeft.addOrReplaceChild("cube_r68", CubeListBuilder.create().texOffs(132, 41).addBox(-1.9995F, 0.0F, 0.0F, 4.0F, 4.5F, 2.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(0.01F, -0.2789F, -2.0802F, -0.2182F, 0.0F, 0.0F));

        PartDefinition bracerArmorLeft = lowerArmLeft.addOrReplaceChild("bracerArmorLeft", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.0552F, 5.9513F, 0.5503F, 0.0F, 3.1416F, 0.0F));

        PartDefinition cube_r69 = bracerArmorLeft.addOrReplaceChild("cube_r69", CubeListBuilder.create().texOffs(116, 43).addBox(-8.5552F, 2.1931F, -29.3556F, 6.0F, 2.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(5.5552F, -0.8763F, 27.0161F, -0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r70 = bracerArmorLeft.addOrReplaceChild("cube_r70", CubeListBuilder.create().texOffs(123, 49).addBox(-8.5552F, -8.1344F, -28.499F, 6.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(5.5552F, 6.0312F, 28.1776F, 0.1309F, 0.0F, 0.0F));

        PartDefinition bracerArmorComponentLeft = bracerArmorLeft.addOrReplaceChild("bracerArmorComponentLeft", CubeListBuilder.create().texOffs(137, 130).addBox(-7.0552F, 4.6931F, -25.3556F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(44, 93).addBox(-8.5552F, -3.3069F, -28.8556F, 6.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5552F, 2.2552F, 28.6298F, -0.1745F, 0.0F, 0.0F));

        PartDefinition LowerArmFurLeft = lowerArmLeft.addOrReplaceChild("LowerArmFurLeft", CubeListBuilder.create().texOffs(0, 62).addBox(-0.0583F, -5.0488F, -2.0F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4341F, 2.038F, -0.0718F, 0.0F, 0.0F, -0.1745F));

        PartDefinition handLeft = lowerArmLeft.addOrReplaceChild("handLeft", CubeListBuilder.create().texOffs(124, 5).addBox(-2.5F, -1.0F, -1.5F, 6.0F, 5.0F, 2.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 10.0F, -0.5F, 0.5672F, 0.0F, -0.1309F));

        PartDefinition cube_r71 = handLeft.addOrReplaceChild("cube_r71", CubeListBuilder.create().texOffs(138, 47).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 1.8978F, -2.2765F, 0.3927F, 0.0F, 0.0F));

        PartDefinition cube_r72 = handLeft.addOrReplaceChild("cube_r72", CubeListBuilder.create().texOffs(117, 101).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -1.0F, -1.5F, -0.2618F, 0.0F, 0.0F));

        PartDefinition fingerLeft_2 = handLeft.addOrReplaceChild("fingerLeft_2", CubeListBuilder.create().texOffs(46, 72).addBox(-0.75F, 0.0F, 0.0F, 1.5F, 3.0F, 1.5F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-1.25F, 2.5F, -1.5F, -0.4363F, 0.0F, 0.0F));

        PartDefinition nailRing7 = fingerLeft_2.addOrReplaceChild("nailRing7", CubeListBuilder.create().texOffs(138, 4).addBox(-1.0F, -0.5F, -21.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.5F, 21.1782F));

        PartDefinition upperFingerLeft_2 = fingerLeft_2.addOrReplaceChild("upperFingerLeft_2", CubeListBuilder.create().texOffs(44, 93).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.25F, 0.4363F, 0.0F, 0.0F));

        PartDefinition lowerFingerLeft_2 = upperFingerLeft_2.addOrReplaceChild("lowerFingerLeft_2", CubeListBuilder.create().texOffs(96, 9).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.5F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.5236F, 0.0F, 0.0F));

        PartDefinition fingerNailLeft_2 = lowerFingerLeft_2.addOrReplaceChild("fingerNailLeft_2", CubeListBuilder.create().texOffs(0, 24).addBox(-0.5F, -0.025F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 1.5F, 0.0F, 0.3491F, 0.0F, 0.0F));

        PartDefinition fingerLeft_5 = handLeft.addOrReplaceChild("fingerLeft_5", CubeListBuilder.create().texOffs(65, 56).addBox(-0.75F, 0.0F, 0.0F, 1.5F, 3.0F, 1.5F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-2.5F, 1.5F, -1.0F, -0.4363F, 0.7854F, 0.0F));

        PartDefinition nailRing6 = fingerLeft_5.addOrReplaceChild("nailRing6", CubeListBuilder.create().texOffs(138, 4).addBox(-1.0F, -0.5F, -20.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, 1.5F, 20.1782F));

        PartDefinition upperFingerLeft_5 = fingerLeft_5.addOrReplaceChild("upperFingerLeft_5", CubeListBuilder.create().texOffs(95, 76).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.5F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.25F, 0.4363F, 0.0F, 0.0F));

        PartDefinition lowerFingerLeft_5 = upperFingerLeft_5.addOrReplaceChild("lowerFingerLeft_5", CubeListBuilder.create().texOffs(95, 74).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.5F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 1.5F, 0.0F, 0.5236F, 0.0F, 0.0F));

        PartDefinition fingerNailLeft_5 = lowerFingerLeft_5.addOrReplaceChild("fingerNailLeft_5", CubeListBuilder.create().texOffs(0, 24).addBox(-0.5F, -0.025F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 1.5F, 0.0F, 0.3491F, 0.0F, 0.0F));

        PartDefinition fingerLeft_3 = handLeft.addOrReplaceChild("fingerLeft_3", CubeListBuilder.create().texOffs(26, 57).addBox(-0.75F, 0.0F, 0.0F, 1.5F, 3.5F, 1.5F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.5F, 2.5F, -1.5F, -0.4363F, 0.0F, 0.0F));

        PartDefinition nailRing8 = fingerLeft_3.addOrReplaceChild("nailRing8", CubeListBuilder.create().texOffs(138, 4).addBox(-1.0F, -0.5F, -21.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, 1.75F, 21.1782F));

        PartDefinition upperFingerLeft_3 = fingerLeft_3.addOrReplaceChild("upperFingerLeft_3", CubeListBuilder.create().texOffs(16, 93).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 3.5F, 0.25F, 0.4363F, 0.0F, 0.0F));

        PartDefinition lowerFingerLeft_3 = upperFingerLeft_3.addOrReplaceChild("lowerFingerLeft_3", CubeListBuilder.create().texOffs(71, 88).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.5F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.5236F, 0.0F, 0.0F));

        PartDefinition fingerNailLeft_3 = lowerFingerLeft_3.addOrReplaceChild("fingerNailLeft_3", CubeListBuilder.create().texOffs(0, 24).addBox(-0.5F, -0.025F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 1.5F, 0.0F, 0.3491F, 0.0F, 0.0F));

        PartDefinition fingerLeft_4 = handLeft.addOrReplaceChild("fingerLeft_4", CubeListBuilder.create().texOffs(0, 57).addBox(-0.75F, 0.0F, 0.0F, 1.5F, 3.0F, 1.5F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(2.25F, 2.5F, -1.5F, -0.4363F, 0.0F, 0.0F));

        PartDefinition nailRing9 = fingerLeft_4.addOrReplaceChild("nailRing9", CubeListBuilder.create().texOffs(138, 4).addBox(-1.0F, -0.5F, -21.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.5F, 21.1782F));

        PartDefinition upperFingerLeft_4 = fingerLeft_4.addOrReplaceChild("upperFingerLeft_4", CubeListBuilder.create().texOffs(86, 3).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.25F, 0.4363F, 0.0F, 0.0F));

        PartDefinition lowerFingerLeft_4 = upperFingerLeft_4.addOrReplaceChild("lowerFingerLeft_4", CubeListBuilder.create().texOffs(67, 88).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.5F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.5236F, 0.0F, 0.0F));

        PartDefinition fingerNailLeft_4 = lowerFingerLeft_4.addOrReplaceChild("fingerNailLeft_4", CubeListBuilder.create().texOffs(0, 24).addBox(-0.5F, -0.025F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 1.5F, 0.0F, 0.3491F, 0.0F, 0.0F));

        PartDefinition finger_6 = handLeft.addOrReplaceChild("finger_6", CubeListBuilder.create().texOffs(52, 56).addBox(-0.75F, 0.0F, 0.0F, 1.5F, 3.0F, 1.5F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(3.5F, 1.5F, -1.0F, -0.4363F, -0.7854F, 0.0F));

        PartDefinition nailRing10 = finger_6.addOrReplaceChild("nailRing10", CubeListBuilder.create().texOffs(138, 4).addBox(-1.0F, -0.5F, -20.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, 1.75F, 20.1782F));

        PartDefinition upperFinger_6 = finger_6.addOrReplaceChild("upperFinger_6", CubeListBuilder.create().texOffs(86, 0).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.25F, 0.4363F, 0.0F, 0.0F));

        PartDefinition fingerNail_6 = upperFinger_6.addOrReplaceChild("fingerNail_6", CubeListBuilder.create().texOffs(0, 24).addBox(-0.485F, -1.3598F, 0.3949F, 1.0F, 2.0F, 0.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 3.5F, 0.0F, 0.3491F, 0.0F, 0.0F));

        PartDefinition armRight = upperBody.addOrReplaceChild("armRight", CubeListBuilder.create().texOffs(20, 87).addBox(-3.0F, 0.2321F, -0.2859F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -5.75F, 6.5F, 0.5672F, 0.0F, -0.2182F));

        PartDefinition upperArmRight = armRight.addOrReplaceChild("upperArmRight", CubeListBuilder.create().texOffs(93, 88).addBox(-3.0F, 0.0F, -4.0F, 5.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 6.7321F, 3.9641F, -0.2182F, 0.0F, -0.1745F));

        PartDefinition lowerArmRight = upperArmRight.addOrReplaceChild("lowerArmRight", CubeListBuilder.create().texOffs(98, 111).addBox(-2.5F, 0.0F, -1.0F, 5.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 8.0F, -1.5F, -0.3447F, -0.0349F, -0.5236F));

        PartDefinition cube_r73 = lowerArmRight.addOrReplaceChild("cube_r73", CubeListBuilder.create().texOffs(129, 89).addBox(-2.0F, -4.0F, 0.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 4.0712F, -2.7805F, -0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r74 = lowerArmRight.addOrReplaceChild("cube_r74", CubeListBuilder.create().texOffs(132, 124).addBox(-1.5F, -3.0F, 0.0F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.8441F, -1.4947F, 0.3927F, 0.0F, 0.0F));

        PartDefinition cube_r75 = lowerArmRight.addOrReplaceChild("cube_r75", CubeListBuilder.create().texOffs(87, 88).addBox(-1.5F, -3.0F, 0.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 9.7788F, -0.9773F, 0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r76 = lowerArmRight.addOrReplaceChild("cube_r76", CubeListBuilder.create().texOffs(12, 131).addBox(-1.5F, -6.0F, -2.0F, 3.0F, 6.0F, 2.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 10.0F, 2.0F, -0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r77 = lowerArmRight.addOrReplaceChild("cube_r77", CubeListBuilder.create().texOffs(22, 131).addBox(-1.9995F, 0.0F, -2.0F, 4.0F, 4.5F, 2.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(0.01F, -0.2789F, 2.0802F, 0.2182F, 0.0F, 0.0F));

        PartDefinition lowerArmFurRight = lowerArmRight.addOrReplaceChild("lowerArmFurRight", CubeListBuilder.create().texOffs(0, 57).addBox(0.0F, -5.0F, -2.0F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 2.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition handRight = lowerArmRight.addOrReplaceChild("handRight", CubeListBuilder.create().texOffs(112, 123).addBox(-2.5F, -1.0F, -1.0F, 6.0F, 5.0F, 2.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 10.0F, 0.5F, -0.5672F, 0.0F, -0.1309F));

        PartDefinition cube_r78 = handRight.addOrReplaceChild("cube_r78", CubeListBuilder.create().texOffs(138, 28).addBox(-1.5F, 0.0F, -1.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 1.8978F, 2.2765F, -0.3927F, 0.0F, 0.0F));

        PartDefinition cube_r79 = handRight.addOrReplaceChild("cube_r79", CubeListBuilder.create().texOffs(112, 5).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -1.0F, 1.5F, 0.2618F, 0.0F, 0.0F));

        PartDefinition fingerRight_7 = handRight.addOrReplaceChild("fingerRight_7", CubeListBuilder.create().texOffs(55, 10).addBox(-0.75F, 0.0F, -1.5F, 1.5F, 3.0F, 1.5F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-1.25F, 2.5F, 1.5F, 0.4363F, 0.0F, 0.0F));

        PartDefinition nailRing4 = fingerRight_7.addOrReplaceChild("nailRing4", CubeListBuilder.create().texOffs(138, 4).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.5F, -0.75F));

        PartDefinition upperFinger_7 = fingerRight_7.addOrReplaceChild("upperFinger_7", CubeListBuilder.create().texOffs(19, 83).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 3.0F, -0.25F, -0.4363F, 0.0F, 0.0F));

        PartDefinition lowerFinger_6 = upperFinger_7.addOrReplaceChild("lowerFinger_6", CubeListBuilder.create().texOffs(87, 34).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 1.5F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.5236F, 0.0F, 0.0F));

        PartDefinition fingerNail_7 = lowerFinger_6.addOrReplaceChild("fingerNail_7", CubeListBuilder.create().texOffs(0, 24).addBox(-0.5F, -0.025F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 1.5F, 0.0F, -0.3491F, 0.0F, 0.0F));

        PartDefinition fingerRight_8 = handRight.addOrReplaceChild("fingerRight_8", CubeListBuilder.create().texOffs(55, 0).addBox(-0.75F, 0.0F, -1.5F, 1.5F, 3.0F, 1.5F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-2.5F, 1.5F, 1.0F, 0.4363F, -0.7854F, 0.0F));

        PartDefinition nailRing5 = fingerRight_8.addOrReplaceChild("nailRing5", CubeListBuilder.create().texOffs(138, 4).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, 1.5F, -0.75F));

        PartDefinition upperFinger_8 = fingerRight_8.addOrReplaceChild("upperFinger_8", CubeListBuilder.create().texOffs(23, 83).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 1.5F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 3.0F, -0.25F, -0.4363F, 0.0F, 0.0F));

        PartDefinition lowerFinger_7 = upperFinger_8.addOrReplaceChild("lowerFinger_7", CubeListBuilder.create().texOffs(25, 79).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 1.5F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 1.5F, 0.0F, -0.5236F, 0.0F, 0.0F));

        PartDefinition fingerNail_8 = lowerFinger_7.addOrReplaceChild("fingerNail_8", CubeListBuilder.create().texOffs(0, 24).addBox(-0.5F, -0.025F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 1.5F, 0.0F, -0.3491F, 0.0F, 0.0F));

        PartDefinition fingerRight_9 = handRight.addOrReplaceChild("fingerRight_9", CubeListBuilder.create().texOffs(30, 51).addBox(-0.75F, 0.0F, -1.5F, 1.5F, 3.5F, 1.5F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.5F, 2.5F, 1.5F, 0.4363F, 0.0F, 0.0F));

        PartDefinition nailRing3 = fingerRight_9.addOrReplaceChild("nailRing3", CubeListBuilder.create().texOffs(138, 4).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, 1.75F, -0.75F));

        PartDefinition upperFinger_9 = fingerRight_9.addOrReplaceChild("upperFinger_9", CubeListBuilder.create().texOffs(80, 49).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 3.5F, -0.25F, -0.4363F, 0.0F, 0.0F));

        PartDefinition lowerFinger_8 = upperFinger_9.addOrReplaceChild("lowerFinger_8", CubeListBuilder.create().texOffs(58, 74).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 1.5F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.5236F, 0.0F, 0.0F));

        PartDefinition fingerNail_9 = lowerFinger_8.addOrReplaceChild("fingerNail_9", CubeListBuilder.create().texOffs(0, 24).addBox(-0.5F, -0.025F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 1.5F, 0.0F, -0.3491F, 0.0F, 0.0F));

        PartDefinition fingerRight_10 = handRight.addOrReplaceChild("fingerRight_10", CubeListBuilder.create().texOffs(12, 0).addBox(-0.75F, 0.0F, -1.5F, 1.5F, 3.0F, 1.5F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(2.25F, 2.5F, 1.5F, 0.4363F, 0.0F, 0.0F));

        PartDefinition nailRing2 = fingerRight_10.addOrReplaceChild("nailRing2", CubeListBuilder.create().texOffs(138, 4).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.5F, -0.75F));

        PartDefinition upperFinger_10 = fingerRight_10.addOrReplaceChild("upperFinger_10", CubeListBuilder.create().texOffs(72, 49).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 3.0F, -0.25F, -0.4363F, 0.0F, 0.0F));

        PartDefinition lowerFinger_9 = upperFinger_10.addOrReplaceChild("lowerFinger_9", CubeListBuilder.create().texOffs(65, 8).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 1.5F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.5236F, 0.0F, 0.0F));

        PartDefinition fingerNail_10 = lowerFinger_9.addOrReplaceChild("fingerNail_10", CubeListBuilder.create().texOffs(0, 24).addBox(-0.5F, -0.025F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 1.5F, 0.0F, -0.3491F, 0.0F, 0.0F));

        PartDefinition fingerRight_11 = handRight.addOrReplaceChild("fingerRight_11", CubeListBuilder.create().texOffs(0, 0).addBox(-0.75F, 0.0F, -1.5F, 1.5F, 3.0F, 1.5F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(3.5F, 1.5F, 1.0F, 0.4363F, 0.7854F, 0.0F));

        PartDefinition nailRing1 = fingerRight_11.addOrReplaceChild("nailRing1", CubeListBuilder.create().texOffs(138, 4).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, 1.75F, -0.75F));

        PartDefinition upperFinger_11 = fingerRight_11.addOrReplaceChild("upperFinger_11", CubeListBuilder.create().texOffs(46, 24).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 3.0F, -0.25F, -0.4363F, 0.0F, 0.0F));

        PartDefinition fingerNail_11 = upperFinger_11.addOrReplaceChild("fingerNail_11", CubeListBuilder.create().texOffs(0, 24).addBox(-0.485F, -1.3598F, -0.3949F, 1.0F, 2.0F, 0.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 3.5F, 0.0F, -0.3491F, 0.0F, 0.0F));

        PartDefinition bracerArmorRight = lowerArmRight.addOrReplaceChild("bracerArmorRight", CubeListBuilder.create(), PartPose.offset(0.0F, 4.9564F, 0.5019F));

        PartDefinition cube_r80 = bracerArmorRight.addOrReplaceChild("cube_r80", CubeListBuilder.create().texOffs(116, 43).addBox(-3.0F, 0.0F, -2.0F, 6.0F, 2.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, -2.8814F, -1.3637F, -0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r81 = bracerArmorRight.addOrReplaceChild("cube_r81", CubeListBuilder.create().texOffs(123, 49).addBox(-3.0F, -2.0F, -1.75F, 6.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 4.0261F, -0.2022F, 0.1309F, 0.0F, 0.0F));

        PartDefinition bracerArmorComponentRight = bracerArmorRight.addOrReplaceChild("bracerArmorComponentRight", CubeListBuilder.create().texOffs(137, 130).addBox(-1.5F, 2.5F, 2.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(44, 93).addBox(-3.0F, -5.5F, -1.5F, 6.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.25F, 0.25F, -0.1745F, 0.0F, 0.0F));

        PartDefinition bondFabric = armRight.addOrReplaceChild("bondFabric", CubeListBuilder.create().texOffs(0, 83).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.5F, 5.75F));

        PartDefinition bondFabricPhysics = bondFabric.addOrReplaceChild("bondFabricPhysics", CubeListBuilder.create().texOffs(30, 46).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

        PartDefinition lowerNeck = upperBody.addOrReplaceChild("lowerNeck", CubeListBuilder.create().texOffs(0, 24).addBox(0.0F, -6.0F, -6.5F, 9.0F, 9.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -5.25F, 0.0F, 0.0F, 0.0F, 0.3491F));

        PartDefinition upperNeck = lowerNeck.addOrReplaceChild("upperNeck", CubeListBuilder.create().texOffs(34, 36).addBox(0.0F, -5.0F, -5.0F, 9.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.0F, 0.0F, 0.3054F));

        PartDefinition head = upperNeck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(22, 56).addBox(-5.0F, 0.0F, -4.0F, 11.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -5.0F, 0.0F, 0.0F, 0.0F, -1.1345F));

        PartDefinition cube_r82 = head.addOrReplaceChild("cube_r82", CubeListBuilder.create().texOffs(67, 82).addBox(-3.0F, -2.0F, -2.0F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 4.0F, 4.0F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r83 = head.addOrReplaceChild("cube_r83", CubeListBuilder.create().texOffs(67, 82).addBox(-3.0F, -2.0F, 0.0F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 4.0F, -4.0F, 0.0F, -0.3927F, 0.0F));

        PartDefinition cube_r84 = head.addOrReplaceChild("cube_r84", CubeListBuilder.create().texOffs(114, 105).addBox(-3.0F, 0.0F, -3.25F, 3.0F, 3.0F, 6.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1809F, -1.0261F, 0.0F, 0.0F, 0.0F, -0.3491F));

        PartDefinition cube_r85 = head.addOrReplaceChild("cube_r85", CubeListBuilder.create().texOffs(114, 114).addBox(-3.0F, 0.0F, -3.25F, 3.0F, 3.0F, 6.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

        PartDefinition headFurLeft = head.addOrReplaceChild("headFurLeft", CubeListBuilder.create(), PartPose.offset(3.2284F, 4.0F, -5.1481F));

        PartDefinition cube_r86 = headFurLeft.addOrReplaceChild("cube_r86", CubeListBuilder.create().texOffs(64, 0).addBox(-3.0F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.3927F, 0.0F));

        PartDefinition headFurRight = head.addOrReplaceChild("headFurRight", CubeListBuilder.create(), PartPose.offset(3.2284F, 4.0F, 5.1481F));

        PartDefinition cube_r87 = headFurRight.addOrReplaceChild("cube_r87", CubeListBuilder.create().texOffs(64, 0).addBox(-3.0F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.3927F, 0.0F));

        PartDefinition headFurTop = head.addOrReplaceChild("headFurTop", CubeListBuilder.create(), PartPose.offset(3.1809F, -1.0261F, 0.0F));

        PartDefinition cube_r88 = headFurTop.addOrReplaceChild("cube_r88", CubeListBuilder.create().texOffs(104, 62).addBox(-5.0F, 0.0F, -3.25F, 5.0F, 2.0F, 6.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

        PartDefinition earLeft = head.addOrReplaceChild("earLeft", CubeListBuilder.create(), PartPose.offset(3.0F, 1.5F, -3.0F));

        PartDefinition cube_r89 = earLeft.addOrReplaceChild("cube_r89", CubeListBuilder.create().texOffs(136, 78).addBox(-3.764F, -2.6165F, -1.1844F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.944F, -0.6614F, -2.0036F, -0.5724F, -0.4299F, 0.7256F));

        PartDefinition cube_r90 = earLeft.addOrReplaceChild("cube_r90", CubeListBuilder.create().texOffs(93, 22).addBox(-4.0F, -1.5F, -1.0F, 5.0F, 3.0F, 1.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5724F, -0.4299F, 0.7256F));

        PartDefinition earRight = head.addOrReplaceChild("earRight", CubeListBuilder.create(), PartPose.offset(3.0F, 1.5F, 3.0F));

        PartDefinition cube_r91 = earRight.addOrReplaceChild("cube_r91", CubeListBuilder.create().texOffs(132, 111).addBox(-3.764F, -2.6165F, 0.1844F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.944F, -0.6614F, 2.0036F, 0.5724F, 0.4299F, 0.7256F));

        PartDefinition cube_r92 = earRight.addOrReplaceChild("cube_r92", CubeListBuilder.create().texOffs(87, 30).addBox(-4.0F, -1.5F, -0.5F, 5.0F, 3.0F, 1.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5724F, 0.4299F, 0.7256F));

        PartDefinition upperHead = head.addOrReplaceChild("upperHead", CubeListBuilder.create().texOffs(126, 22).addBox(3.0F, 2.0F, -2.0F, 4.0F, 2.5F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(80, 78).addBox(6.25F, 1.25F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(38, 83).addBox(0.0F, 2.0F, -2.5F, 3.0F, 2.5F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(41, 11).addBox(7.0F, 4.5F, -2.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 1.0F, 0.0F));

        PartDefinition cube_r93 = upperHead.addOrReplaceChild("cube_r93", CubeListBuilder.create().texOffs(72, 49).addBox(-1.9947F, 0.0018F, 0.0F, 2.0F, 3.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(1.9301F, -0.477F, -2.0F, 0.0F, 0.0F, -0.3927F));

        PartDefinition cube_r94 = upperHead.addOrReplaceChild("cube_r94", CubeListBuilder.create().texOffs(102, 127).addBox(-3.0F, 0.0F, -2.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, 0.0F, -1.309F));

        PartDefinition cube_r95 = upperHead.addOrReplaceChild("cube_r95", CubeListBuilder.create().texOffs(65, 60).addBox(-1.9842F, -2.49F, -0.0216F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3635F, 6.99F, 3.6964F, 0.0F, 0.1745F, 0.0F));

        PartDefinition cube_r96 = upperHead.addOrReplaceChild("cube_r96", CubeListBuilder.create().texOffs(0, 71).addBox(-2.0F, -2.5F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9994F, 7.0F, 2.4992F, 0.0F, 0.6109F, 0.0F));

        PartDefinition cube_r97 = upperHead.addOrReplaceChild("cube_r97", CubeListBuilder.create().texOffs(52, 62).addBox(-4.0F, -3.0F, 0.0F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.9887F, 7.49F, 1.9903F, 0.0F, 0.1222F, 0.0F));

        PartDefinition cube_r98 = upperHead.addOrReplaceChild("cube_r98", CubeListBuilder.create().texOffs(4, 71).addBox(-1.9642F, -2.49F, -0.1168F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3151F, 6.97F, -3.5102F, 0.0F, -0.1745F, 0.0F));

        PartDefinition cube_r99 = upperHead.addOrReplaceChild("cube_r99", CubeListBuilder.create().texOffs(72, 52).addBox(-2.0F, -2.5F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 7.0F, -2.5F, 0.0F, -0.6109F, 0.0F));

        PartDefinition cube_r100 = upperHead.addOrReplaceChild("cube_r100", CubeListBuilder.create().texOffs(20, 63).addBox(-4.0F, -3.0F, 0.0F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.9889F, 7.49F, -1.9913F, 0.0F, -0.1222F, 0.0F));

        PartDefinition cube_r101 = upperHead.addOrReplaceChild("cube_r101", CubeListBuilder.create().texOffs(60, 93).addBox(-2.0F, -2.5F, -2.0F, 2.0F, 2.5F, 2.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(3.0F, 4.5F, 2.5F, 0.0F, 0.6109F, 0.0F));

        PartDefinition cube_r102 = upperHead.addOrReplaceChild("cube_r102", CubeListBuilder.create().texOffs(78, 102).addBox(-1.9842F, -2.49F, -2.0216F, 2.0F, 2.5F, 2.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(1.3755F, 4.5F, 3.6734F, 0.0F, 0.1745F, 0.0F));

        PartDefinition cube_r103 = upperHead.addOrReplaceChild("cube_r103", CubeListBuilder.create().texOffs(109, 30).addBox(-1.9642F, -2.49F, -0.1168F, 2.0F, 2.5F, 2.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(1.3383F, 4.49F, -3.5265F, 0.0F, -0.1745F, 0.0F));

        PartDefinition cube_r104 = upperHead.addOrReplaceChild("cube_r104", CubeListBuilder.create().texOffs(112, 70).addBox(-2.0F, -2.5F, 0.0F, 2.0F, 2.5F, 2.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(3.0F, 4.5F, -2.5F, 0.0F, -0.6109F, 0.0F));

        PartDefinition cube_r105 = upperHead.addOrReplaceChild("cube_r105", CubeListBuilder.create().texOffs(78, 118).addBox(0.0F, 0.0F, -1.5F, 7.0F, 2.0F, 3.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.1309F));

        PartDefinition cube_r106 = upperHead.addOrReplaceChild("cube_r106", CubeListBuilder.create().texOffs(31, 34).addBox(-5.0F, -3.0F, -1.0F, 5.0F, 2.5F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(7.0F, 5.0F, 2.0F, 0.0F, 0.1222F, 0.0F));

        PartDefinition cube_r107 = upperHead.addOrReplaceChild("cube_r107", CubeListBuilder.create().texOffs(8, 61).addBox(-5.0F, -3.0F, 0.0F, 5.0F, 2.5F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(7.0F, 5.0F, -2.0F, 0.0F, -0.1222F, 0.0F));

        PartDefinition cube_r108 = upperHead.addOrReplaceChild("cube_r108", CubeListBuilder.create().texOffs(122, 22).addBox(0.0F, -2.5F, -2.0F, 2.5F, 2.5F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, 2.025F, 3.925F, 0.0F, 0.8727F, 0.0F));

        PartDefinition cube_r109 = upperHead.addOrReplaceChild("cube_r109", CubeListBuilder.create().texOffs(79, 132).addBox(0.0F, -2.5F, 0.0F, 2.5F, 2.5F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, 2.025F, -3.925F, 0.0F, -0.8727F, 0.0F));

        PartDefinition eyebrowLeft = upperHead.addOrReplaceChild("eyebrowLeft", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -3.0F));

        PartDefinition cube_r110 = eyebrowLeft.addOrReplaceChild("cube_r110", CubeListBuilder.create().texOffs(104, 86).addBox(-1.75F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.8651F, 0.0F, 0.2531F, -0.5271F, -0.8764F, 0.352F));

        PartDefinition eyebrowRight = upperHead.addOrReplaceChild("eyebrowRight", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 3.0F));

        PartDefinition cube_r111 = eyebrowRight.addOrReplaceChild("cube_r111", CubeListBuilder.create().texOffs(104, 86).addBox(-1.75F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.8651F, 0.0F, -0.2531F, 0.5271F, 0.8764F, 0.352F));

        PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(114, 70).addBox(-1.9526F, -2.0671F, -3.0F, 4.0F, 2.5F, 6.0F, new CubeDeformation(-0.01F))
                .texOffs(115, 17).addBox(2.0474F, -2.0671F, -2.0F, 6.0F, 1.5F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(34, 113).addBox(8.0474F, -0.5671F, -2.125F, 0.0F, 2.0F, 4.25F, new CubeDeformation(0.0F))
                .texOffs(33, 11).addBox(8.0474F, -4.0671F, -2.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r112 = jaw.addOrReplaceChild("cube_r112", CubeListBuilder.create().texOffs(52, 63).addBox(-4.0F, -1.5F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.025F, -1.5471F, 1.9816F, 0.0F, 0.1222F, 0.0F));

        PartDefinition cube_r113 = jaw.addOrReplaceChild("cube_r113", CubeListBuilder.create().texOffs(94, 102).addBox(-4.0F, -2.0F, 0.0F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.025F, 1.4129F, 1.9816F, 0.0F, 0.1222F, 0.0F));

        PartDefinition cube_r114 = jaw.addOrReplaceChild("cube_r114", CubeListBuilder.create().texOffs(38, 101).addBox(-4.0F, -2.0F, 0.0F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(64, 4).addBox(-4.0F, -4.46F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0251F, 1.4129F, -1.9826F, 0.0F, -0.1222F, 0.0F));

        PartDefinition cube_r115 = jaw.addOrReplaceChild("cube_r115", CubeListBuilder.create().texOffs(55, 8).addBox(-5.0F, -2.0F, -1.0F, 4.0F, 1.5F, 1.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(9.0474F, -0.0671F, 2.0F, 0.0F, 0.1222F, 0.0F));

        PartDefinition cube_r116 = jaw.addOrReplaceChild("cube_r116", CubeListBuilder.create().texOffs(60, 17).addBox(-5.0F, -2.0F, 0.0F, 4.0F, 1.5F, 1.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(9.0474F, -0.0671F, -2.0F, 0.0F, -0.1222F, 0.0F));

        PartDefinition cube_r117 = jaw.addOrReplaceChild("cube_r117", CubeListBuilder.create().texOffs(55, 4).addBox(-1.9642F, -0.99F, 0.1168F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.3624F, -2.0571F, 3.5092F, 0.0F, 0.1745F, 0.0F));

        PartDefinition cube_r118 = jaw.addOrReplaceChild("cube_r118", CubeListBuilder.create().texOffs(55, 14).addBox(-2.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0329F, -2.0571F, 2.4967F, 0.0F, 0.6109F, 0.0F));

        PartDefinition cube_r119 = jaw.addOrReplaceChild("cube_r119", CubeListBuilder.create().texOffs(24, 101).addBox(-2.0F, -1.5F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0549F, 0.9129F, -2.4701F, 0.0F, -0.6109F, 0.0F));

        PartDefinition cube_r120 = jaw.addOrReplaceChild("cube_r120", CubeListBuilder.create().texOffs(64, 101).addBox(-1.9642F, -1.49F, -0.1168F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.361F, 0.9029F, -3.5084F, 0.0F, -0.1745F, 0.0F));

        PartDefinition cube_r121 = jaw.addOrReplaceChild("cube_r121", CubeListBuilder.create().texOffs(38, 103).addBox(-1.9642F, -1.49F, 0.1168F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.3609F, 0.9029F, 3.5075F, 0.0F, 0.1745F, 0.0F));

        PartDefinition cube_r122 = jaw.addOrReplaceChild("cube_r122", CubeListBuilder.create().texOffs(24, 103).addBox(-2.0F, -1.5F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0544F, 0.9129F, 2.4692F, 0.0F, 0.6109F, 0.0F));

        PartDefinition cube_r123 = jaw.addOrReplaceChild("cube_r123", CubeListBuilder.create().texOffs(88, 68).addBox(-1.9642F, -1.49F, -1.8832F, 2.0F, 1.5F, 2.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(3.3857F, -0.5771F, 3.5265F, 0.0F, 0.1745F, 0.0F));

        PartDefinition cube_r124 = jaw.addOrReplaceChild("cube_r124", CubeListBuilder.create().texOffs(38, 90).addBox(-2.0F, -1.5F, -2.0F, 2.0F, 1.5F, 2.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(5.0474F, -0.5671F, 2.5F, 0.0F, 0.6109F, 0.0F));

        PartDefinition cube_r125 = jaw.addOrReplaceChild("cube_r125", CubeListBuilder.create().texOffs(30, 55).addBox(-1.99F, -1.01F, -0.01F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0335F, -2.0571F, -2.4975F, 0.0F, -0.6109F, 0.0F));

        PartDefinition cube_r126 = jaw.addOrReplaceChild("cube_r126", CubeListBuilder.create().texOffs(0, 98).addBox(-2.0F, -1.5F, 0.0F, 2.0F, 1.5F, 2.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(5.0474F, -0.5671F, -2.5F, 0.0F, -0.6109F, 0.0F));

        PartDefinition cube_r127 = jaw.addOrReplaceChild("cube_r127", CubeListBuilder.create().texOffs(52, 60).addBox(-1.9642F, -0.99F, -0.1168F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.3625F, -2.0571F, -3.5102F, 0.0F, -0.1745F, 0.0F));

        PartDefinition cube_r128 = jaw.addOrReplaceChild("cube_r128", CubeListBuilder.create().texOffs(61, 125).addBox(-1.9642F, -1.49F, -0.1168F, 2.0F, 1.5F, 2.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(3.3857F, -0.5771F, -3.5265F, 0.0F, -0.1745F, 0.0F));

        PartDefinition cube_r129 = jaw.addOrReplaceChild("cube_r129", CubeListBuilder.create().texOffs(126, 28).addBox(0.0F, -1.5F, -2.0F, 4.0F, 1.5F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(2.0474F, 0.4329F, 0.0F, 0.0F, 0.0F, -0.2443F));

        PartDefinition tongue = jaw.addOrReplaceChild("tongue", CubeListBuilder.create().texOffs(0, 57).addBox(-3.25F, 0.0F, -2.0F, 10.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7974F, -2.0671F, 0.0F, 0.0F, 0.0F, -0.0436F));

        return LayerDefinition.create(meshdefinition, 256, 256);
    }



    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
       body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return body;
    }


    @Override
    public void setupAnim(WerewolfEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animateWalk(WerewolfAnimations.walk, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.animate(entity.idleAnimationState, WerewolfAnimations.idle, ageInTicks, 1f);
        this.animate(entity.sitAnimationState, WerewolfAnimations.idle_to_wolf, ageInTicks, 1f);
        this.animate(entity.sitPoseAnimationState, WerewolfAnimations.idle_wolf, ageInTicks, 1f);
//        this.animate(entity.sitAnimationState, WerewolfAnimations.idle_wolf, ageInTicks, 1f);
    }

    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

        this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
    }
}
