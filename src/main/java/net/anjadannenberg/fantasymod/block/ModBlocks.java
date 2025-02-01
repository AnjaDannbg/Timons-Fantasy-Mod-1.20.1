package net.anjadannenberg.fantasymod.block;

import net.anjadannenberg.fantasymod.FantasyMod;
import net.anjadannenberg.fantasymod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FantasyMod.MOD_ID);

    public static final RegistryObject<Block> FIREMETAL_BLOCK = registerBlock("firemetal_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> RAW_FIREMETAL_BLOCK = registerBlock("raw_firemetal_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK)));

    public static final RegistryObject<Block> FIREMETAL_ORE = registerBlock("firemetal_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)
                    .strength(3.0F, 3.0F).requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> DEEPSLATE_FIREMETAL_ORE = registerBlock("deepslate_firemetal_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)
                    .strength(3.0F, 3.0F).requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<Block> NETHERRACK_FIREMETAL_ORE = registerBlock("netherrack_firemetal_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)
                    .strength(3.0F, 3.0F).requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<Block> INFLOWEL = registerBlock("inflowel",
            () -> new FlowerBlock(() -> MobEffects.LUCK, 5,
                    BlockBehaviour.Properties.copy(Blocks.TORCHFLOWER).noOcclusion().noCollission()
            ));
    public static final RegistryObject<Block> POTTED_INFLOWEL = BLOCKS.register("potted_inflowel",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.INFLOWEL,
                    BlockBehaviour.Properties.copy(Blocks.TORCHFLOWER).noOcclusion()
            ));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
