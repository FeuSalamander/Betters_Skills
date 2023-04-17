
package net.feusalamander.betterskills.gui.overlay;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

import net.feusalamander.betterskills.procedures.XpgainedOnProcedure;
import net.feusalamander.betterskills.procedures.MiningOnProcedure;
import net.feusalamander.betterskills.procedures.ForagingOnProcedure;
import net.feusalamander.betterskills.procedures.FishingOnProcedure;
import net.feusalamander.betterskills.procedures.FarmingOnProcedure;
import net.feusalamander.betterskills.procedures.CombatOnProcedure;
import net.feusalamander.betterskills.BetterskillsModVariables;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber
public class XpgainedOverlay {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGameOverlayEvent.Post event) {
		if (event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
			int w = event.getWindow().getScaledWidth();
			int h = event.getWindow().getScaledHeight();
			int posX = w / 2;
			int posY = h / 2;
			World _world = null;
			double _x = 0;
			double _y = 0;
			double _z = 0;
			PlayerEntity entity = Minecraft.getInstance().player;
			if (entity != null) {
				_world = entity.world;
				_x = entity.getPosX();
				_y = entity.getPosY();
				_z = entity.getPosZ();
			}
			World world = _world;
			double x = _x;
			double y = _y;
			double z = _z;
			RenderSystem.disableDepthTest();
			RenderSystem.depthMask(false);
			RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
			RenderSystem.disableAlphaTest();
			if (XpgainedOnProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("betterskills:textures/screens/xpfont.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 203, posY + -131, 0, 0, 117, 47, 117, 47);

				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(),
						"+" + (int) ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).xpnumber) + " XP", posX + 216, posY + -101, -16777216);
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(), "" + ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).xptype) + "",
						posX + 212, posY + -123, -16777216);
				if (MiningOnProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("betterskills:textures/screens/wooden_pick.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 281, posY + -124, 0, 0, 32, 32, 32, 32);
				}
				if (FishingOnProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("betterskills:textures/screens/fishing_rod.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 281, posY + -124, 0, 0, 32, 32, 32, 32);
				}
				if (CombatOnProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("betterskills:textures/screens/wooden_sword.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 281, posY + -124, 0, 0, 32, 32, 32, 32);
				}
				if (ForagingOnProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("betterskills:textures/screens/wood_axe.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 281, posY + -124, 0, 0, 32, 32, 32, 32);
				}
				if (FarmingOnProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("betterskills:textures/screens/wood_hoe.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 281, posY + -124, 0, 0, 32, 32, 32, 32);
				}
			}
			RenderSystem.depthMask(true);
			RenderSystem.enableDepthTest();
			RenderSystem.enableAlphaTest();
			RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		}
	}
}
