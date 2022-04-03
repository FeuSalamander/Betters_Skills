package net.feusalamander.betterskills;

import mezz.jei.api.*;
import mezz.jei.api.ingredients.IIngredientType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.runtime.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidStack;
import java.util.*;
import java.util.stream.Collectors;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.server.command.ModIdArgument;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.moddiscovery.ModInfo;

import net.feusalamander.betterskills.item.WateringcanItem;
import net.feusalamander.betterskills.BetterskillsMod;


@mezz.jei.api.JeiPlugin
public class Tooltips implements IModPlugin { 
	
	@Override
	public ResourceLocation getPluginUid() {
		return new ResourceLocation("betterskills", "default");
	}

	@Override
        public void registerRecipes(IRecipeRegistration registry) {
		IIngredientManager ingredientManager = registry.getIngredientManager();

		
		IIngredientType<ItemStack> itemType = ingredientManager.getIngredientType(ItemStack.class);

        registry.addIngredientInfo(new ItemStack(WateringcanItem.block), itemType, "Use it to grow up crops but use 500 durability, you can refill it by sneak + right click when you stand in water");


     }
}