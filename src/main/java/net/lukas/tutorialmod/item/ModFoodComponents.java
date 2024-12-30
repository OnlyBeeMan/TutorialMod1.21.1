package net.lukas.tutorialmod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent CAULIFLOWER = new FoodComponent.Builder().nutrition(3).saturationModifier(0.4F)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,400),0.45f).build();
}
