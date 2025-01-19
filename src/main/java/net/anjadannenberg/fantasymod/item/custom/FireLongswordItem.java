package net.anjadannenberg.fantasymod.item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class FireLongswordItem extends SwordItem {
    public FireLongswordItem() {
        super(new Tier() {
            @Override
            public int getUses() {
                return 0;
            }

            @Override
            public float getSpeed() {
                return 0;
            }

            @Override
            public float getAttackDamageBonus() {
                return 0;
            }

            @Override
            public int getLevel() {
                return 0;
            }

            @Override
            public int getEnchantmentValue() {
                return 0;
            }

            @Override
            public Ingredient getRepairIngredient() {
                return null;
            }
        }, 12, 0.1f, new Item.Properties().stacksTo(1));
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // Call the super method to apply damage to the enemy
        boolean result = super.hurtEnemy(stack, target, attacker);

        // Set the enemy on fire for 5 seconds
        target.setSecondsOnFire(5);

        return result;
    }
}
