package com.nanakowo.withering.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.world.entity.player.Abilities;
import net.minecraft.world.inventory.AnvilMenu;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(AnvilMenu.class)
public class AnvilMenuMixin {
    @ModifyExpressionValue(
        method = "createResult",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/entity/player/Player;getAbilities()Lnet/minecraft/world/entity/player/Abilities;",
            ordinal = 1
        )
    )
    private Abilities modifyInstabuild(Abilities original) {
        Abilities newAbilities = new Abilities();
        newAbilities.instabuild = true;
        return newAbilities;
    }
}