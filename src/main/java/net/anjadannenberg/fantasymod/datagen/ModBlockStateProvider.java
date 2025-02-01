package net.anjadannenberg.fantasymod.datagen;

import net.anjadannenberg.fantasymod.FantasyMod;
import net.anjadannenberg.fantasymod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, FantasyMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.FIREMETAL_BLOCK);
        blockWithItem(ModBlocks.RAW_FIREMETAL_BLOCK);

        blockWithItem(ModBlocks.FIREMETAL_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_FIREMETAL_ORE);
        blockWithItem(ModBlocks.NETHERRACK_FIREMETAL_ORE);

        simpleBlockWithItem(ModBlocks.INFLOWEL.get(), models().cross(blockTexture(ModBlocks.INFLOWEL.get()).getPath(),
                blockTexture(ModBlocks.INFLOWEL.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.POTTED_INFLOWEL.get(), models().singleTexture("potted_inflowel", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.INFLOWEL.get())).renderType("cutout"));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
