package net.anjadannenberg.fantasymod.event;

import net.anjadannenberg.fantasymod.FantasyMod;
import net.anjadannenberg.fantasymod.entity.client.DemonBossModel;
import net.anjadannenberg.fantasymod.entity.client.ManaStagModel;
import net.anjadannenberg.fantasymod.entity.client.ModModelLayers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FantasyMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value =Dist.CLIENT)
public class ModEventBusClientEvents {

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.MANA_STAG_LAYER, ManaStagModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.DEMON_BOSS_LAYER, DemonBossModel::createBodyLayer);
    }

}
