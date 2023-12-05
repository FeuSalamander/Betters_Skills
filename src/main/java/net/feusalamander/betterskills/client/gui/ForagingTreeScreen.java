package net.feusalamander.betterskills.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;

import net.feusalamander.betterskills.world.inventory.ForagingTreeMenu;
import net.feusalamander.betterskills.procedures.PointsProcedure;
import net.feusalamander.betterskills.network.ForagingTreeButtonMessage;
import net.feusalamander.betterskills.BetterskillsMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class ForagingTreeScreen extends AbstractContainerScreen<ForagingTreeMenu> {
	private final static HashMap<String, Object> guistate = ForagingTreeMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_up;

	public ForagingTreeScreen(ForagingTreeMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 252;
		this.imageHeight = 140;
	}

	private static final ResourceLocation texture = new ResourceLocation("betterskills:textures/screens/foraging_tree.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("betterskills:textures/screens/skyforaging.png"));
		this.blit(ms, this.leftPos + -1, this.topPos + -1, 0, 0, 254, 141, 254, 141);

		RenderSystem.setShaderTexture(0, new ResourceLocation("betterskills:textures/screens/screen2.png"));
		this.blit(ms, this.leftPos + 0, this.topPos + 0, 0, 0, -1, -1, -1, -1);

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
		this.font.draw(poseStack, Component.translatable("gui.betterskills.foraging_tree.label_ability_config"), 7, 5, -16732414);
		this.font.draw(poseStack,

				PointsProcedure.execute(entity), 207, 6, -16724788);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		imagebutton_up = new ImageButton(this.leftPos + 114, this.topPos + 18, 22, 14, 0, 0, 14, new ResourceLocation("betterskills:textures/screens/atlas/imagebutton_up.png"), 22, 28, e -> {
			if (true) {
				BetterskillsMod.PACKET_HANDLER.sendToServer(new ForagingTreeButtonMessage(0, x, y, z));
				ForagingTreeButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_up", imagebutton_up);
		this.addRenderableWidget(imagebutton_up);
	}
}
