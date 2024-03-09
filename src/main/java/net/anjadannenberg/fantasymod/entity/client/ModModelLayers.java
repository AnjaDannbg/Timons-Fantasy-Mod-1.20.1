package net.anjadannenberg.fantasymod.entity.client;

import net.anjadannenberg.fantasymod.FantasyMod;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    public static final ModelLayerLocation MANA_STAG_LAYER = new ModelLayerLocation(
            new ResourceLocation(FantasyMod.MOD_ID, "mana_stag_layer"), "main");

    public static final ModelLayerLocation DEMON_BOSS_LAYER = new ModelLayerLocation(
            new ResourceLocation(FantasyMod.MOD_ID, "demon_boss_layer"), "main");
}
