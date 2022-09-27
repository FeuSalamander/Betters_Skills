
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.feusalamander.betterskills.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.feusalamander.betterskills.item.WateringcanItem;
import net.feusalamander.betterskills.BetterskillsMod;

public class BetterskillsModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, BetterskillsMod.MODID);
	public static final RegistryObject<Item> WATERINGCAN = REGISTRY.register("wateringcan", () -> new WateringcanItem());
}
