package net.anjadannenberg.fantasymod.entity;

import net.anjadannenberg.fantasymod.FantasyMod;
import net.anjadannenberg.fantasymod.entity.custom.ManaStagEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, FantasyMod.MOD_ID);

    public static final RegistryObject<EntityType<ManaStagEntity>> MANA_STAG =
            ENTITY_TYPES.register("mana_stag", () -> EntityType.Builder.of(ManaStagEntity::new, MobCategory.CREATURE)
                    .sized(2.0f, 2.0f).build("mana_stag"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
