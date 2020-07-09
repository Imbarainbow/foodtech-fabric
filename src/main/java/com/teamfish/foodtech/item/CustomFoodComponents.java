package com.teamfish.foodtech.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponent.Builder;

public class CustomFoodComponents {
    public static final FoodComponent test_crop;
    public static final FoodComponent compressed_vege;
    public static final FoodComponent compressed_meat;
    public static final FoodComponent compressed_basiccrop;

    private static FoodComponent create(int hunger) {
        return (new Builder()).hunger(hunger).saturationModifier(0.6F).build();
    }
    static {
        test_crop = (new Builder()).hunger(4).saturationModifier(0.6F).build();
        compressed_meat = (new Builder()).hunger(16).saturationModifier(1.6F).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION,20 * 5,1), 1).build();
        compressed_vege = (new Builder()).hunger(16).saturationModifier(1.6F).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION,20 * 5,1), 1).build();
        compressed_basiccrop = (new Builder()).hunger(16).saturationModifier(1.6F).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION,20 * 5,1), 1).build();
    }
}
