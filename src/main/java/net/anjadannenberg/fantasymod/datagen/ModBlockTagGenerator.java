package net.anjadannenberg.fantasymod.datagen;

import net.anjadannenberg.fantasymod.FantasyMod;
import net.anjadannenberg.fantasymod.block.ModBlocks;
import net.anjadannenberg.fantasymod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, FantasyMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
                .add(ModBlocks.FIREMETAL_ORE.get()).addTag(Tags.Blocks.ORES);



        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.FIREMETAL_ORE.get(),
                        ModBlocks.RAW_FIREMETAL_BLOCK.get(),
                        ModBlocks.FIREMETAL_BLOCK.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.FIREMETAL_BLOCK.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.FIREMETAL_ORE.get(),
                        ModBlocks.RAW_FIREMETAL_BLOCK.get());

    }
}
