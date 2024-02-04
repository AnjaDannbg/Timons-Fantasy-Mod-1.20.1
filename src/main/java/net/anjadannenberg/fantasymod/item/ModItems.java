package net.anjadannenberg.fantasymod.item;

import net.anjadannenberg.fantasymod.FantasyMod;
import net.anjadannenberg.fantasymod.item.custom.FireSwordItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FantasyMod.MOD_ID);

    public static final RegistryObject<Item> RAW_FIREMETAL = ITEMS.register("raw_firemetal",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FIREMETAL_INGOT = ITEMS.register("firemetal_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> FIRE_SWORD = ITEMS.register("fire_sword",
            () -> new FireSwordItem());

    /*
    public static final RegistryObject<Item> FIRE_SWORD = ITEMS.register("fire_sword",
            () -> new SwordItem(Tiers.DIAMOND, 9, 3f,
                    new Item.Properties().stacksTo(1)
            ));


     */

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
