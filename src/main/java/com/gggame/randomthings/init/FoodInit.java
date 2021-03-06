package com.gggame.randomthings.init;

import net.minecraft.world.food.FoodProperties;

public class FoodInit {
    public static final FoodProperties MAPLE_SYRUP = new FoodProperties.Builder().nutrition(3).saturationMod(0.4f).build();
    public static final FoodProperties MAPLE_WATER = new FoodProperties.Builder().nutrition(2).saturationMod(0.1f).build();
    public static final FoodProperties MAPLE_TAFFY = new FoodProperties.Builder().nutrition(4).saturationMod(0.6f).build();
    public static final FoodProperties MAPLE_SUGAR = new FoodProperties.Builder().nutrition(3).saturationMod(1f).build();
    public static final FoodProperties MAPLE_BUTTER = new FoodProperties.Builder().nutrition(4).saturationMod(0.8f).build();
    public static final FoodProperties CHORUS_FRUIT = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).alwaysEat().build();
}
