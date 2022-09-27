
package net.feusalamander.betterskills.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.feusalamander.betterskills.world.inventory.AbilityconfigMenu;
import net.feusalamander.betterskills.procedures.TreeonProcedure;
import net.feusalamander.betterskills.procedures.TreeoffProcedure;
import net.feusalamander.betterskills.procedures.SoulsonProcedure;
import net.feusalamander.betterskills.procedures.SoulsoffProcedure;
import net.feusalamander.betterskills.procedures.MoleonProcedure;
import net.feusalamander.betterskills.procedures.MoleoffProcedure;
import net.feusalamander.betterskills.network.AbilityconfigButtonMessage;
import net.feusalamander.betterskills.BetterskillsMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class AbilityconfigScreen extends AbstractContainerScreen<AbilityconfigMenu> {
	private final static HashMap<String, Object> guistate = AbilityconfigMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public AbilityconfigScreen(AbilityconfigMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 252;
		this.imageHeight = 140;
	}

	private static final ResourceLocation texture = new ResourceLocation("betterskills:textures/screens/abilityconfig.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		RenderSystem.setShaderTexture(0, new ResourceLocation("betterskills:textures/screens/skilltree.png"));
		this.blit(ms, this.leftPos + 0, this.topPos + 0, 0, 0, 252, 140, 252, 140);

		if (TreeoffProcedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("betterskills:textures/screens/no.png"));
			this.blit(ms, this.leftPos + 77, this.topPos + 18, 0, 0, 17, 17, 17, 17);
		}
		if (SoulsoffProcedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("betterskills:textures/screens/no.png"));
			this.blit(ms, this.leftPos + 103, this.topPos + 38, 0, 0, 17, 17, 17, 17);
		}
		if (TreeonProcedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("betterskills:textures/screens/ok.png"));
			this.blit(ms, this.leftPos + 77, this.topPos + 18, 0, 0, 17, 17, 17, 17);
		}
		if (SoulsonProcedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("betterskills:textures/screens/ok.png"));
			this.blit(ms, this.leftPos + 103, this.topPos + 38, 0, 0, 17, 17, 17, 17);
		}
		if (MoleonProcedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("betterskills:textures/screens/ok.png"));
			this.blit(ms, this.leftPos + 37, this.topPos + 59, 0, 0, 17, 17, 17, 17);
		}
		if (MoleoffProcedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("betterskills:textures/screens/no.png"));
			this.blit(ms, this.leftPos + 37, this.topPos + 59, 0, 0, 17, 17, 17, 17);
		}
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "Ability Config", 7, 5, -12829636);
		this.font.draw(poseStack, "Instant Tree", 10, 22, -3355444);
		this.font.draw(poseStack, "Help of the souls", 11, 42, -3355444);
		this.font.draw(poseStack, "Mole", 11, 63, -3355444);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addRenderableWidget(new Button(this.leftPos + 202, this.topPos + 17, 40, 20, new TextComponent("Toggle"), e -> {
			if (true) {
				BetterskillsMod.PACKET_HANDLER.sendToServer(new AbilityconfigButtonMessage(0, x, y, z));
				AbilityconfigButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 202, this.topPos + 38, 40, 20, new TextComponent("Toggle"), e -> {
			if (true) {
				BetterskillsMod.PACKET_HANDLER.sendToServer(new AbilityconfigButtonMessage(1, x, y, z));
				AbilityconfigButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 202, this.topPos + 59, 40, 20, new TextComponent("Toggle"), e -> {
			if (true) {
				BetterskillsMod.PACKET_HANDLER.sendToServer(new AbilityconfigButtonMessage(2, x, y, z));
				AbilityconfigButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
	}
}
