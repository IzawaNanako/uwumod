package com.nanakowo.withering.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.core.Holder;
import net.minecraft.world.item.enchantment.Enchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Enchantment.class)
public class EnchantmentMixin {
    @ModifyReturnValue(
        method = "areCompatible",
        at = @At("RETURN")
    )
    private static boolean modifyAreCompatible(boolean original, Holder<Enchantment> holder, Holder<Enchantment> holder2) {
        return !holder.equals(holder2);
    }
}