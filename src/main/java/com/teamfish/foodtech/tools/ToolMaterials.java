package com.teamfish.foodtech.tools;

import java.util.function.Supplier;

import com.teamfish.foodtech.item.AllTheItems;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

public enum ToolMaterials implements ToolMaterial {

    meat(4, 3000, 9.0F, 4.0F, 22, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{AllTheItems.meat_ingot});
    }),
    vege(4, 3000, 9.0F, 4.0F, 22, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{AllTheItems.vege_ingot});
    }),
    supreme(4, 6000, 12.0F, 5.0F, 30, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{AllTheItems.supreme_ingot});
    });

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    private ToolMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantibility, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantibility;
        this.repairIngredient = new Lazy(repairIngredient);
    }

    public int getDurability() {
        return this.itemDurability;
    }

    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public int getMiningLevel() {
        return this.miningLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredient.get();
    }
}
