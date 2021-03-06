package com.gggame.randomthings.init;

import com.gggame.randomthings.Main;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.util.Lazy;

import java.util.function.Supplier;

public enum BaseArmorMaterial implements ArmorMaterial {
    SILVER("silver", 15, new int[]{2, 5, 6, 2}, 6, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
        return Ingredient.of(ItemInit.SILVER_INGOT.get());
    }),
    UPGRADED_NETHERITE("upgraded_netherite", 45, new int[]{3, 6, 8, 3}, 12, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.2F, () -> {
        return Ingredient.of(ItemInit.UPGRADED_NETHERITE_INGOT.get());
    }),
    ERBIUM("erbium", 35, new int[]{4, 7, 9, 4}, 10, SoundEvents.ARMOR_EQUIP_NETHERITE, 2.0F, 0F, () -> {
        return Ingredient.of(ItemInit.ERBIUM_GEM.get());
    }),
    NETHER_ERBIUM("nether_erbium", 50, new int[]{6, 9, 11, 5}, 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.5F, 0.3F, () -> {
        return Ingredient.of(ItemInit.NETHER_ERBIUM_GEM.get());
    }),
    END_ERBIUM("end_erbium", 60, new int[]{8, 11, 13, 6}, 18, SoundEvents.ARMOR_EQUIP_NETHERITE, 5F, 0.5F, () -> {
        return Ingredient.of(ItemInit.END_ERBIUM_GEM.get());
    });



    private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] slotProtections;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final Lazy<Ingredient> repairIngredient;

    private BaseArmorMaterial(String name, int durabilityMultiplier, int[] slotProtections, int enchantmentValue,
                              SoundEvent sound, float toughness,
                              float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.slotProtections = slotProtections;
        this.enchantmentValue = enchantmentValue;
        this.sound = sound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = Lazy.of(repairIngredient);
    }

    public int getDurabilityForSlot(EquipmentSlot p_40484_) {
        return HEALTH_PER_SLOT[p_40484_.getIndex()] * this.durabilityMultiplier;
    }

    public int getDefenseForSlot(EquipmentSlot p_40487_) {
        return this.slotProtections[p_40487_.getIndex()];
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public SoundEvent getEquipSound() {
        return this.sound;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    public String getName() {
        return Main.MOD_ID + ":" + this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}