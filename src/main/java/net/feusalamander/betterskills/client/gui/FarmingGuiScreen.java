package net.feusalamander.betterskills.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;

import net.feusalamander.betterskills.world.inventory.FarmingGuiMenu;
import net.feusalamander.betterskills.procedures.FarmingTooltipProcedure;
import net.feusalamander.betterskills.procedures.FarmingBar8Procedure;
import net.feusalamander.betterskills.procedures.FarmingBar2Procedure;
import net.feusalamander.betterskills.procedures.FarmingBar0Procedure;
import net.feusalamander.betterskills.procedures.FarmingBAr6Procedure;
import net.feusalamander.betterskills.procedures.FarmingBAr4Procedure;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class FarmingGuiScreen extends AbstractContainerScreen<FarmingGuiMenu> {
	private final static HashMap<String, Object> guistate = FarmingGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public FarmingGuiScreen(FarmingGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 349;
		this.imageHeight = 208;
	}

	private static final ResourceLocation texture = new ResourceLocation("betterskills:textures/screens/farming_gui.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("betterskills:textures/screens/skillsfont.png"));
		this.blit(ms, this.leftPos + -2, this.topPos + 0, 0, 0, 352, 208, 352, 208);

		RenderSystem.setShaderTexture(0, new ResourceLocation("betterskills:textures/screens/farmingbig.png"));
		this.blit(ms, this.leftPos + 87, this.topPos + 31, 0, 0, 175, 147, 175, 147);

		if (FarmingBar0Procedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("betterskills:textures/screens/mbar0.png"));
			this.blit(ms, this.leftPos + 26, this.topPos + 39, 0, 0, 25, 130, 25, 130);
		}
		if (FarmingBar2Procedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("betterskills:textures/screens/fabar2.png"));
			this.blit(ms, this.leftPos + 26, this.topPos + 39, 0, 0, 25, 130, 25, 130);
		}
		if (FarmingBAr4Procedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("betterskills:textures/screens/fabar4.png"));
			this.blit(ms, this.leftPos + 26, this.topPos + 39, 0, 0, 25, 130, 25, 130);
		}
		if (FarmingBAr6Procedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("betterskills:textures/screens/fabar6.png"));
			this.blit(ms, this.leftPos + 26, this.topPos + 39, 0, 0, 25, 130, 25, 130);
		}
		if (FarmingBar8Procedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("betterskills:textures/screens/fabar8.png"));
			this.blit(ms, this.leftPos + 26, this.topPos + 39, 0, 0, 25, 130, 25, 130);
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
		this.font.draw(poseStack,

				FarmingTooltipProcedure.execute(entity), 27, 172, -393472);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
	}
}
