package net.anjadannenberg.fantasymod.datagen.loot;

import net.anjadannenberg.fantasymod.block.ModBlocks;
import net.anjadannenberg.fantasymod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.FIREMETAL_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_FIREMETAL_BLOCK.get());

        this.add(ModBlocks.FIREMETAL_ORE.get(),
                block -> createOreDrop(ModBlocks.FIREMETAL_ORE.get(), ModItems.RAW_FIREMETAL.get()));
        this.add(ModBlocks.DEEPSLATE_FIREMETAL_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_FIREMETAL_ORE.get(), ModItems.RAW_FIREMETAL.get()));
        this.add(ModBlocks.NETHERRACK_FIREMETAL_ORE.get(),
                block -> createOreDrop(ModBlocks.NETHERRACK_FIREMETAL_ORE.get(), ModItems.RAW_FIREMETAL.get()));

        this.dropSelf(ModBlocks.INFLOWEL.get());
        this.add(ModBlocks.POTTED_INFLOWEL.get(), createPotFlowerItemTable(ModBlocks.INFLOWEL.get()));

    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    protected LootTable.Builder createOreDrop(Block pBlock, Item pItem) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(pItem)
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
