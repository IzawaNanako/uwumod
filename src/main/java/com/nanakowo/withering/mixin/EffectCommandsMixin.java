package com.nanakowo.withering.mixin;

import net.minecraft.server.commands.EffectCommands;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(EffectCommands.class)
public class EffectCommandsMixin {
    @ModifyArgs(
        method = "register",
        at = @At(
            value = "INVOKE",
            target = "Lcom/mojang/brigadier/arguments/IntegerArgumentType;integer(II)Lcom/mojang/brigadier/arguments/IntegerArgumentType;",
            ordinal = 1,
            remap = false
        )
    )
    private static void modifyFirstEffectAmplifierArgs(Args args) {
        args.set(0, Integer.MIN_VALUE);
        args.set(1, Integer.MAX_VALUE);
    }

    @ModifyArgs(
        method = "register",
        at = @At(
            value = "INVOKE",
            target = "Lcom/mojang/brigadier/arguments/IntegerArgumentType;integer(II)Lcom/mojang/brigadier/arguments/IntegerArgumentType;",
            ordinal = 2,
            remap = false
        )
    )
    private static void modifySecondEffectAmplifierArgs(Args args) {
        args.set(0, Integer.MIN_VALUE);
        args.set(1, Integer.MAX_VALUE);
    }
}
