package net.anjadannenberg.fantasymod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.anjadannenberg.fantasymod.FantasyMod;
import net.anjadannenberg.fantasymod.entity.custom.DemonBossEntity;
import net.anjadannenberg.fantasymod.entity.custom.ManaStagEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;



public class DemonBossRenderer extends MobRenderer<DemonBossEntity, DemonBossModel<DemonBossEntity>> {
    public DemonBossRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new DemonBossModel<>(pContext.bakeLayer(ModModelLayers.DEMON_BOSS_LAYER)), 0.7F);
    }

    @Override
    public ResourceLocation getTextureLocation(DemonBossEntity pEntity) {
        return new ResourceLocation(FantasyMod.MOD_ID, "textures/entity/demon_boss.png");
    }

}
