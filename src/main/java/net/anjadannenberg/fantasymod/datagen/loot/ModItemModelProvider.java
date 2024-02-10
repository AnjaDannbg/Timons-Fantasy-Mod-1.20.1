package net.anjadannenberg.fantasymod.datagen.loot;

import net.anjadannenberg.fantasymod.FantasyMod;
import net.anjadannenberg.fantasymod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {



    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, FantasyMod.MOD_ID, existingFileHelper);
    }
    @Override
    protected void registerModels() {

        withExistingParent(ModItems.MANA_STAG_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));

    }
}
