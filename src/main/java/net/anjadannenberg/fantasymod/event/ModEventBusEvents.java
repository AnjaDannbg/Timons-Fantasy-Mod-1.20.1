package net.anjadannenberg.fantasymod.event;

import net.anjadannenberg.fantasymod.FantasyMod;
import net.anjadannenberg.fantasymod.entity.ModEntities;
import net.anjadannenberg.fantasymod.entity.custom.DemonBossEntity;
import net.anjadannenberg.fantasymod.entity.custom.ManaStagEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FantasyMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.MANA_STAG.get(), ManaStagEntity.createAttributes().build());
        event.put(ModEntities.DEMON_BOSS.get(), DemonBossEntity.createAttributes().build());
    }

}
