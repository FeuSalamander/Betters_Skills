
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.feusalamander.betterskills.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.feusalamander.betterskills.client.gui.SkillsScreen;
import net.feusalamander.betterskills.client.gui.MiningGUIScreen;
import net.feusalamander.betterskills.client.gui.ForagingGuiScreen;
import net.feusalamander.betterskills.client.gui.FishingGuiScreen;
import net.feusalamander.betterskills.client.gui.FarmingGuiScreen;
import net.feusalamander.betterskills.client.gui.CombatGuiScreen;
import net.feusalamander.betterskills.client.gui.AbilityconfigScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BetterskillsModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(BetterskillsModMenus.SKILLS.get(), SkillsScreen::new);
			MenuScreens.register(BetterskillsModMenus.ABILITYCONFIG.get(), AbilityconfigScreen::new);
			MenuScreens.register(BetterskillsModMenus.MINING_GUI.get(), MiningGUIScreen::new);
			MenuScreens.register(BetterskillsModMenus.COMBAT_GUI.get(), CombatGuiScreen::new);
			MenuScreens.register(BetterskillsModMenus.FISHING_GUI.get(), FishingGuiScreen::new);
			MenuScreens.register(BetterskillsModMenus.FARMING_GUI.get(), FarmingGuiScreen::new);
			MenuScreens.register(BetterskillsModMenus.FORAGING_GUI.get(), ForagingGuiScreen::new);
		});
	}
}
