
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.feusalamander.betterskills.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.feusalamander.betterskills.network.SkillsMenuMessage;
import net.feusalamander.betterskills.BetterskillsMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class BetterskillsModKeyMappings {
	public static final KeyMapping SKILLS_MENU = new KeyMapping("key.betterskills.skills_menu", GLFW.GLFW_KEY_KP_5, "key.categories.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				SKILLS_MENU_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - SKILLS_MENU_LASTPRESS);
				BetterskillsMod.PACKET_HANDLER.sendToServer(new SkillsMenuMessage(1, dt));
				SkillsMenuMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	private static long SKILLS_MENU_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(SKILLS_MENU);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				SKILLS_MENU.consumeClick();
			}
		}
	}
}
