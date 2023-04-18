
package net.feusalamander.betterskills.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import net.feusalamander.betterskills.procedures.XpgainedOnProcedure;
import net.feusalamander.betterskills.procedures.MiningOnProcedure;
import net.feusalamander.betterskills.procedures.ForagingOnProcedure;
import net.feusalamander.betterskills.procedures.FishingOnProcedure;
import net.feusalamander.betterskills.procedures.FarmingOnProcedure;
import net.feusalamander.betterskills.procedures.CombatOnProcedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class XpgainedOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		int posX = w / 2;
		int posY = h / 2;
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level;
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (XpgainedOnProcedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("betterskills:textures/screens/xpfont.png"));
			Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + 203, posY + -131, 0, 0, 117, 47, 117, 47);

			if (MiningOnProcedure.execute(entity)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("betterskills:textures/screens/wooden_pick.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + 281, posY + -124, 0, 0, 32, 32, 32, 32);
			}
			if (FishingOnProcedure.execute(entity)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("betterskills:textures/screens/fishing_rod.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + 281, posY + -124, 0, 0, 32, 32, 32, 32);
			}
			if (CombatOnProcedure.execute(entity)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("betterskills:textures/screens/wooden_sword.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + 281, posY + -124, 0, 0, 32, 32, 32, 32);
			}
			if (ForagingOnProcedure.execute(entity)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("betterskills:textures/screens/wood_axe.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + 281, posY + -124, 0, 0, 32, 32, 32, 32);
			}
			if (FarmingOnProcedure.execute(entity)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("betterskills:textures/screens/wood_hoe.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + 281, posY + -124, 0, 0, 32, 32, 32, 32);
			}
			Minecraft.getInstance().font.draw(event.getPoseStack(), Component.translatable("gui.betterskills.xpgained.label_varintegerxpnumber_xp"), posX + 216, posY + -101, -16777216);
			Minecraft.getInstance().font.draw(event.getPoseStack(), Component.translatable("gui.betterskills.xpgained.label_varxptype"), posX + 212, posY + -123, -16777216);
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
