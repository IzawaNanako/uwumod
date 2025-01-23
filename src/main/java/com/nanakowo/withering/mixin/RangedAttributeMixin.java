package com.nanakowo.withering.mixin;

import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(RangedAttribute.class)
public class RangedAttributeMixin {
	@ModifyArgs(
		method = "sanitizeValue",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/util/Mth;clamp(DDD)D"
		)
	)
	private void modifyClampArgs(Args args) {
		args.set(1, Double.MIN_VALUE);
		args.set(2, Double.MAX_VALUE);
	}
}