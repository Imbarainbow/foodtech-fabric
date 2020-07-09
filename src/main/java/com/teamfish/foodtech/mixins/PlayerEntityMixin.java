package com.teamfish.foodtech.mixins;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.teamfish.foodtech.armor.AllTheArmors.*;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {

	@Shadow public abstract void addExperience(int experience);

	protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
		super(entityType, world);
	}

	@Inject(
			method = "tick",
			at = @At("HEAD")
	)
	private void tick(CallbackInfo ci) {
		Item helmet = this.getEquippedStack(EquipmentSlot.HEAD).getItem();
		Item chestplate = this.getEquippedStack(EquipmentSlot.CHEST).getItem();
		Item leggings = this.getEquippedStack(EquipmentSlot.LEGS).getItem();
		Item boots = this.getEquippedStack(EquipmentSlot.FEET).getItem();

		// player is wearing all desolation items
		if (helmet.equals(VEGE_HELMET) && chestplate.equals(VEGE_CHESTPLATE) && leggings.equals(VEGE_LEGGINGS) && boots.equals(VEGE_BOOTS)) {
			// give player status effect here
			this.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 20 * 3, 2));
			this.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 20 * 3, 1));
			this.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,20 * 3, 2));
		}

		if (helmet.equals(MEAT_HELMET) && chestplate.equals(MEAT_CHESTPLATE) && leggings.equals(MEAT_LEGGINGS) && boots.equals(MEAT_BOOTS)) {
			// give player status effect here
			this.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 20 * 3, 2));
			this.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 20 * 3, 1));
			this.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,20 * 3, 2));
		}

		if (helmet.equals(SUPREME_HELMET) && chestplate.equals(SUPREME_CHESTPLATE) && leggings.equals(SUPREME_LEGGINGS) && boots.equals(SUPREME_BOOTS)) {
			// give player status effect here
			this.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 20 * 3, 2));
			this.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 20 * 3, 2));
			this.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 20 * 3, 1));
			this.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20 * 3, 1));
			this.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,20 * 3, 2));
		}
	}
}
