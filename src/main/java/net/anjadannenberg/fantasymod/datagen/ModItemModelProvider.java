package net.anjadannenberg.fantasymod.datagen;

import net.anjadannenberg.fantasymod.FantasyMod;
import net.anjadannenberg.fantasymod.block.ModBlocks;
import net.anjadannenberg.fantasymod.item.ModItems;
import net.minecraft.client.renderer.block.model.ItemTransform;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.block.model.ItemTransforms;

public class ModItemModelProvider extends ItemModelProvider {



    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, FantasyMod.MOD_ID, existingFileHelper);
    }
    @Override
    protected void registerModels() {
        simpleItem(ModItems.FIREMETAL_INGOT);
        simpleItem(ModItems.RAW_FIREMETAL);


        handheldItem(ModItems.FIRE_SWORD);
        //handheldItem(ModItems.FIRE_CLAYMORE);
        handheldItem(ModItems.FIRE_LONGSWORD);
        handheldItem(ModItems.FIRE_CLAYMORE);

        withExistingParent(ModItems.MANA_STAG_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.DEMON_BOSS_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));

        // simpleBlockItemBlockTexture(ModBlocks.INFLOWEL);

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(FantasyMod.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(FantasyMod.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder bigHandheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld"))
                .texture("layer0", new ResourceLocation(FantasyMod.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItemBlockTexture(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(FantasyMod.MOD_ID,"block/" + item.getId().getPath()));
    }
}
