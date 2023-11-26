
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.feusalamander.betterskills.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.feusalamander.betterskills.world.inventory.SkillsMenu;
import net.feusalamander.betterskills.world.inventory.SkillTreeMenu;
import net.feusalamander.betterskills.world.inventory.MiningGUIMenu;
import net.feusalamander.betterskills.world.inventory.ForagingGuiMenu;
import net.feusalamander.betterskills.world.inventory.FishingGuiMenu;
import net.feusalamander.betterskills.world.inventory.FarmingGuiMenu;
import net.feusalamander.betterskills.world.inventory.CombatGuiMenu;
import net.feusalamander.betterskills.world.inventory.AbilityconfigMenu;
import net.feusalamander.betterskills.BetterskillsMod;

public class BetterskillsModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, BetterskillsMod.MODID);
	public static final RegistryObject<MenuType<SkillsMenu>> SKILLS = REGISTRY.register("skills", () -> IForgeMenuType.create(SkillsMenu::new));
	public static final RegistryObject<MenuType<AbilityconfigMenu>> ABILITYCONFIG = REGISTRY.register("abilityconfig", () -> IForgeMenuType.create(AbilityconfigMenu::new));
	public static final RegistryObject<MenuType<MiningGUIMenu>> MINING_GUI = REGISTRY.register("mining_gui", () -> IForgeMenuType.create(MiningGUIMenu::new));
	public static final RegistryObject<MenuType<CombatGuiMenu>> COMBAT_GUI = REGISTRY.register("combat_gui", () -> IForgeMenuType.create(CombatGuiMenu::new));
	public static final RegistryObject<MenuType<FishingGuiMenu>> FISHING_GUI = REGISTRY.register("fishing_gui", () -> IForgeMenuType.create(FishingGuiMenu::new));
	public static final RegistryObject<MenuType<FarmingGuiMenu>> FARMING_GUI = REGISTRY.register("farming_gui", () -> IForgeMenuType.create(FarmingGuiMenu::new));
	public static final RegistryObject<MenuType<ForagingGuiMenu>> FORAGING_GUI = REGISTRY.register("foraging_gui", () -> IForgeMenuType.create(ForagingGuiMenu::new));
	public static final RegistryObject<MenuType<SkillTreeMenu>> SKILL_TREE = REGISTRY.register("skill_tree", () -> IForgeMenuType.create(SkillTreeMenu::new));
}
