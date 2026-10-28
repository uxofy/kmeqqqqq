package com.armorcolor.mixin;

import com.armorcolor.ArmorTint;
import net.minecraft.client.render.entity.equipment.EquipmentRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EquipmentRenderer.class)
public class EquipmentRendererMixin {

    @Inject(method = "getDyeColor", at = @At("RETURN"), cancellable = true)
    private static void armorcolor$tint(CallbackInfoReturnable<Integer> cir) {
        int c = ArmorTint.colorFor(ArmorTint.current);
        if (c != 0) {
            cir.setReturnValue(c);
        }
    }
}
