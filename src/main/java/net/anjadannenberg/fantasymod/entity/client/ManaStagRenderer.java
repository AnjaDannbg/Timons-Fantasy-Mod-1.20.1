package net.anjadannenberg.fantasymod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.anjadannenberg.fantasymod.FantasyMod;
import net.anjadannenberg.fantasymod.entity.custom.ManaStagEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ManaStagRenderer extends MobRenderer<ManaStagEntity, ManaStagModel<ManaStagEntity>> {
    public ManaStagRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ManaStagModel<>(pContext.bakeLayer(ModModelLayers.MANA_STAG_LAYER)), 2f);
    }

    @Override
    public ResourceLocation getTextureLocation(ManaStagEntity pEntity) {
        return new ResourceLocation(FantasyMod.MOD_ID, "textures/entity/mana_stag.png");
    }

    @Override
    public void render(ManaStagEntity pEntity, float pEntityYaw, float pPartialTricks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {

        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTricks, pMatrixStack, pBuffer, pPackedLight);
    }
}
