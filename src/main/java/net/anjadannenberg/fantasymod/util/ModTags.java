package net.anjadannenberg.fantasymod.util;

import net.anjadannenberg.fantasymod.FantasyMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> METAL_DETECTOR_VALUABLES = tag("metal_detector_valuables");


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(FantasyMod.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> METAL_DETECTOR_VALUABLES = tag("metal_detector_valuables");


        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(FantasyMod.MOD_ID, name));
        }

    }
}
