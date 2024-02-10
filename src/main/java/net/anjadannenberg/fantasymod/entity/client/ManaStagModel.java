package net.anjadannenberg.fantasymod.entity.client;// Made with Blockbench 4.9.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.anjadannenberg.fantasymod.entity.animations.ModAnimationDefinitions;
import net.anjadannenberg.fantasymod.entity.custom.ManaStagEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class ManaStagModel<T extends Entity> extends HierarchicalModel<T> {

	private final ModelPart mana_stag;
	private final ModelPart head;

	public ManaStagModel(ModelPart root) {
		this.mana_stag = root.getChild("mana_stag");
		this.head = mana_stag.getChild("body").getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition mana_stag = partdefinition.addOrReplaceChild("mana_stag", CubeListBuilder.create(), PartPose.offset(3.0F, 14.5F, -5.0F));

		PartDefinition body = mana_stag.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-13.0F, -15.0F, -11.0F, 10.0F, 6.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 9.5F, 8.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -0.5F, -5.5F, 4.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, -15.5F, -10.5F));

		PartDefinition bone = head.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(28, 29).addBox(-3.5F, -4.0833F, -0.3333F, 1.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 27).addBox(-2.5F, 0.9167F, -0.3333F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(39, 0).addBox(0.5F, -2.0833F, -1.3333F, 1.0F, 3.5F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.5F, -1.4167F, -4.1667F, 0.0F, -0.4363F, 0.0F));

		PartDefinition bone4 = head.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(22, 29).addBox(-3.5F, -4.0833F, -0.3333F, 1.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(20, 25).addBox(-2.5F, 0.9167F, -0.3333F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(0.5F, -2.0833F, -1.3333F, 1.0F, 3.5F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.5F, -1.4167F, 0.8333F, 0.0F, 0.4363F, 0.0F));

		PartDefinition bone2 = head.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(20, 27).addBox(-6.5F, 0.9167F, -0.3333F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(39, 5).addBox(-1.5F, -2.0833F, -1.3333F, 1.0F, 3.5F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(34, 29).addBox(2.5F, -4.0833F, -0.3333F, 1.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.5F, -1.4167F, -4.1667F, -0.0436F, 0.3927F, 0.0F));

		PartDefinition bone3 = head.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(0, 25).addBox(-6.5F, 0.9167F, -0.3333F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(13, 0).addBox(-1.5F, -2.0833F, -1.3333F, 1.0F, 3.5F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(16, 29).addBox(2.5F, -4.0833F, -0.3333F, 1.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.5F, -1.1667F, 1.0833F, -0.0454F, -0.4792F, 0.0377F));

		PartDefinition mana_orb_1 = head.addOrReplaceChild("mana_orb_1", CubeListBuilder.create().texOffs(38, 27).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, -7.5F, 1.5F));

		PartDefinition mana_orb_2 = head.addOrReplaceChild("mana_orb_2", CubeListBuilder.create().texOffs(32, 37).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, -7.5F, -4.5F));

		PartDefinition mana_orb_3 = head.addOrReplaceChild("mana_orb_3", CubeListBuilder.create().texOffs(24, 37).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, -7.5F, -4.5F));

		PartDefinition mana_orb_4 = head.addOrReplaceChild("mana_orb_4", CubeListBuilder.create().texOffs(16, 37).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, -7.5F, 1.5F));

		PartDefinition front_leg_left = body.addOrReplaceChild("front_leg_left", CubeListBuilder.create().texOffs(8, 29).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, -9.5F, -8.0F));

		PartDefinition front_leg_right = body.addOrReplaceChild("front_leg_right", CubeListBuilder.create().texOffs(0, 29).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-11.0F, -9.5F, -8.0F));

		PartDefinition back_leg_right = body.addOrReplaceChild("back_leg_right", CubeListBuilder.create().texOffs(54, 25).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-11.0F, -9.5F, 5.0F));

		PartDefinition back_leg_left = body.addOrReplaceChild("back_leg_left", CubeListBuilder.create().texOffs(46, 25).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, -9.5F, 5.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		this.animateWalk(ModAnimationDefinitions.MANA_STAG_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(((ManaStagEntity) entity).idleAnimationState, ModAnimationDefinitions.MAMA_STAG_IDLE, ageInTicks, 1f);
	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float) Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float) Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		mana_stag.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return mana_stag;
	}
}