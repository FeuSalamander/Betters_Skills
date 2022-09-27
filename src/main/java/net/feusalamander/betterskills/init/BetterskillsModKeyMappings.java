
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.feusalamander.betterskills.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.feusalamander.betterskills.network.SkillsMenuMessage;
import net.feusalamander.betterskills.BetterskillsMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class BetterskillsModKeyMappings {
	public static final KeyMapping SKILLS_MENU = new KeyMapping("key.betterskills.skills_menu", GLFW.GLFW_KEY_KP_5, "key.categories.gameplay");
	private static long SKILLS_MENU_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyBindings(FMLClientSetupEvent event) {
		ClientRegistry.registerKeyBinding(SKILLS_MENU);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onKeyInput(InputEvent.KeyInputEvent event) {
			if (Minecraft.getInstance().screen == null) {
				if (event.getKey() == SKILLS_MENU.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						SKILLS_MENU_LASTPRESS = System.currentTimeMillis();
					} else if (event.getAction() == GLFW.GLFW_RELEASE) {
						int dt = (int) (System.currentTimeMillis() - SKILLS_MENU_LASTPRESS);
						BetterskillsMod.PACKET_HANDLER.sendToServer(new SkillsMenuMessage(1, dt));
						SkillsMenuMessage.pressAction(Minecraft.getInstance().player, 1, dt);
					}
				}
			}
		}
	}
}
