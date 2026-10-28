package com.armorcolor;

import net.minecraft.item.ItemStack;

public final class ArmorTint {

    public static ItemStack current = ItemStack.EMPTY;

    public static int colorFor(ItemStack s) {
        if (s == null) return 0;
        if (s.isEmpty()) return 0;
        if (!s.isDamageable()) return 0;
        int max = s.getMaxDamage();
        if (max <= 0) return 0;

        float left = (float) (max - s.getDamage()) / (float) max;

        if (left > 0.70f) return 0xFF55FF55; // green
        if (left > 0.45f) return 0xFFFFFF55; // yellow
        if (left > 0.22f) return 0xFFFF9933; // orange
        return 0xFFFF3333;                   // red
    }
}
