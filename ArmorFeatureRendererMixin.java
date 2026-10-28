package com.armorcolor.mixin;

import com.armorcolor.ArmorTint;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.state.BipedEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ArmorFeatureRenderer.class)
public class ArmorFeatureRendererMixin {

    @Inject(method = "renderArmor", at = @At("HEAD"))
    private void armorcolor$head(MatrixStack matrices, OrderedRenderCommandQueue queue,
                                 ItemStack stack, EquipmentSlot slot, int light,
                                 BipedEntityRenderState state, CallbackInfo ci) {
        ArmorTint.current = stack;
    }

    @Inject(method = "renderArmor", at = @At("RETURN"))
    private void armorcolor$tail(MatrixStack matrices, OrderedRenderCommandQueue queue,
                                 ItemStack stack, EquipmentSlot slot, int light,
                                 BipedEntityRenderState state, CallbackInfo ci) {
        ArmorTint.current = ItemStack.EMPTY;
    }
}
