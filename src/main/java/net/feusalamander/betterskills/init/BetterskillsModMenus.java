
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
import net.feusalamander.betterskills.world.inventory.AbilityconfigMenu;
import net.feusalamander.betterskills.BetterskillsMod;

public class BetterskillsModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, BetterskillsMod.MODID);
	public static final RegistryObject<MenuType<SkillsMenu>> SKILLS = REGISTRY.register("skills", () -> IForgeMenuType.create(SkillsMenu::new));
	public static final RegistryObject<MenuType<AbilityconfigMenu>> ABILITYCONFIG = REGISTRY.register("abilityconfig", () -> IForgeMenuType.create(AbilityconfigMenu::new));
}
