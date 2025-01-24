package net.lukas.tutorialmod.util;

import net.lukas.tutorialmod.TutorialMod;
import net.lukas.tutorialmod.component.ModDataComponentTypes;
import net.lukas.tutorialmod.item.ModItems;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

public class ModModelPredicates {
    public static void registerModelPredicates(){
        ModelPredicateProviderRegistry.register(ModItems.CHISEL, Identifier.of(TutorialMod.MOD_ID,"used"),
                (stack, world, entity, seed) -> stack.get(ModDataComponentTypes.COORDINATES) != null ? 1.0f: 0f);
    }
}
