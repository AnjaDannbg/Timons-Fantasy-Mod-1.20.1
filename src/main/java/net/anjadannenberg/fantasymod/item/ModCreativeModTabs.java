package net.anjadannenberg.fantasymod.item;

import net.anjadannenberg.fantasymod.FantasyMod;
import net.anjadannenberg.fantasymod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FantasyMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> FANTASY_TAB = CREATIVE_MODE_TABS.register("fantasy_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.FIREMETAL_INGOT.get()))
                    .title(Component.translatable("creativetab.fantasy_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.FIREMETAL_INGOT.get());
                        pOutput.accept(ModItems.RAW_FIREMETAL.get());
                        pOutput.accept(ModItems.FIRE_SWORD.get());
                        pOutput.accept(ModItems.FIRE_LONGSWORD.get());

                        pOutput.accept(ModBlocks.FIREMETAL_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_FIREMETAL_BLOCK.get());
                        pOutput.accept(ModBlocks.FIREMETAL_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_FIREMETAL_ORE.get());
                        pOutput.accept(ModBlocks.NETHERRACK_FIREMETAL_ORE.get());

                        pOutput.accept(ModItems.MANA_STAG_SPAWN_EGG.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
