package net.lukas.tutorialmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.lukas.tutorialmod.block.ModBlocks;
import net.lukas.tutorialmod.component.ModDataComponentTypes;
import net.lukas.tutorialmod.effect.ModEffects;
import net.lukas.tutorialmod.item.ModItemGroups;
import net.lukas.tutorialmod.item.ModItems;
import net.lukas.tutorialmod.sound.ModSounds;
import net.lukas.tutorialmod.util.HammerUsageEvent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";


	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModSounds.registerSounds();

		ModEffects.registerEffects();

		ModDataComponentTypes.registerDataComponentTypes();

		FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_ASHES, 3200);

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
		AttackEntityCallback.EVENT.register((playerEntity, world, hand, entity, entityHitResult) -> {
			if(entity instanceof SheepEntity sheepEntity){
				if(playerEntity.getMainHandStack().getItem()== Items.END_ROD){
					playerEntity.sendMessage(Text.literal("The Player just it a sheep with an END ROD!! YOU SICK BASTARD!!"));
					playerEntity.getMainHandStack().decrement(1);
					sheepEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON,400,6));
				}
				return ActionResult.PASS;
			}
			return ActionResult.PASS;
		});

	}
}