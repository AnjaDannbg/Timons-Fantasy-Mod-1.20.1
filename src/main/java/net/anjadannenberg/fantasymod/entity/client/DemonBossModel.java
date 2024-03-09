package net.anjadannenberg.fantasymod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.anjadannenberg.fantasymod.entity.animations.ModAnimationDefinitions;
import net.anjadannenberg.fantasymod.entity.custom.DemonBossEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;


public class DemonBossModel<T extends Entity> extends HierarchicalModel<T> {

    private final ModelPart demon_boss;
    private final ModelPart head;

    public DemonBossModel(ModelPart root) {
        this.demon_boss = root.getChild("demon_boss");
        this.head = demon_boss.getChild("body").getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition demon_boss = partdefinition.addOrReplaceChild("demon_boss", CubeListBuilder.create(), PartPose.offset(-4.0F, 24.0F, 0.0F));

        PartDefinition body = demon_boss.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 16).addBox(0.0F, -24.0F, -3.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -32.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition arm_right = body.addOrReplaceChild("arm_right", CubeListBuilder.create().texOffs(30, 40).addBox(-3.0F, -24.0F, -3.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition arm_left = body.addOrReplaceChild("arm_left", CubeListBuilder.create().texOffs(16, 40).addBox(8.0F, -24.0F, -3.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition wing_left = body.addOrReplaceChild("wing_left", CubeListBuilder.create(), PartPose.offset(4.0F, 0.0F, 0.0F));

        PartDefinition wing_left_r1 = wing_left.addOrReplaceChild("wing_left_r1", CubeListBuilder.create().texOffs(24, 28).addBox(0.0F, -5.0F, -1.0F, 8.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -19.0F, 2.0F, 0.0F, -0.3491F, 0.0F));

        PartDefinition wing_right = body.addOrReplaceChild("wing_right", CubeListBuilder.create(), PartPose.offset(4.0F, 0.0F, 0.0F));

        PartDefinition wing_right_r1 = wing_right.addOrReplaceChild("wing_right_r1", CubeListBuilder.create().texOffs(24, 16).addBox(-7.0F, -5.0F, -1.0F, 8.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -19.0F, 2.0F, 0.0F, 0.3491F, 0.0F));

        PartDefinition leg_right = body.addOrReplaceChild("leg_right", CubeListBuilder.create().texOffs(0, 32).addBox(0.0F, -12.0F, -3.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition leg_left = body.addOrReplaceChild("leg_left", CubeListBuilder.create().texOffs(32, 0).addBox(0.0F, -12.0F, -3.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.animate(((DemonBossEntity) entity).idleAnimationState, ModAnimationDefinitions.DEMON_BOSS_IDLE, ageInTicks, 1f);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        demon_boss.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }


    @Override
    public ModelPart root() {
        return demon_boss;
    }

}
