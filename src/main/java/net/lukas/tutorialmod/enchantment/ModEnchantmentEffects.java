package net.lukas.tutorialmod.enchantment;

import com.mojang.serialization.MapCodec;
import net.lukas.tutorialmod.TutorialMod;
import net.lukas.tutorialmod.enchantment.custom.LightningStrikerEnchantmentEffect;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantmentEffects {

    public static final MapCodec<? extends EnchantmentEntityEffect> LIGHTNING_STRIKER =
            registerEntityEffects("lightning_striker", LightningStrikerEnchantmentEffect.CODEC);


    private static MapCodec<? extends EnchantmentEntityEffect> registerEntityEffects(String name,
                                                                                     MapCodec<? extends EnchantmentEntityEffect> codec){
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(TutorialMod.MOD_ID,name), codec);
    }


    public static void registerEnchantmentEffects(){
        TutorialMod.LOGGER.info("Registering Mod Enchantment Effects for" + TutorialMod.MOD_ID);
    }
}
