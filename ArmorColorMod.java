package com.armorcolor;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;

public class ArmorColorMod implements ClientModInitializer {

    private static KeyBinding toggleKey;

    @Override
    public void onInitializeClient() {
        KeyBinding.Category cat = KeyBinding.Category.create(Identifier.of("armorcolor", "main"));
        toggleKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.armorcolor.toggle", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_K, cat));
        ClientTickEvents.END_CLIENT_TICK.register(this::tick);
    }

    private void tick(MinecraftClient mc) {
        while (toggleKey.wasPressed()) {
            ArmorTint.enabled = !ArmorTint.enabled;
            if (mc.player != null) {
                String state = ArmorTint.enabled ? "ON" : "OFF";
                mc.player.sendMessage(Text.literal("ArmorColor: " + state), true);
            }
        }
    }
}
