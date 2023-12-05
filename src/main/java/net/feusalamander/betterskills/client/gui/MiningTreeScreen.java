package net.feusalamander.betterskills.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;

import net.feusalamander.betterskills.world.inventory.MiningTreeMenu;
import net.feusalamander.betterskills.procedures.PointsProcedure;
import net.feusalamander.betterskills.procedures.MThaste2Procedure;
import net.feusalamander.betterskills.procedures.MThaste1Procedure;
import net.feusalamander.betterskills.procedures.MTIhaste2Procedure;
import net.feusalamander.betterskills.procedures.MTIhaste1Procedure;
import net.feusalamander.betterskills.network.MiningTreeButtonMessage;
import net.feusalamander.betterskills.BetterskillsMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class MiningTreeScreen extends AbstractContainerScreen<MiningTreeMenu> {
	private final static HashMap<String, Object> guistate = MiningTreeMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_left;
	ImageButton imagebutton_right;
	ImageButton imagebutton_down;
	ImageButton imagebutton_up;
	ImageButton imagebutton_iconmining;
	ImageButton imagebutton_iconhaste1;
	ImageButton imagebutton_iconhaste2;

	public MiningTreeScreen(MiningTreeMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 252;
		this.imageHeight = 140;
	}

	private static final ResourceLocation texture = new ResourceLocation("betterskills:textures/screens/mining_tree.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		if (mouseX > leftPos + 113 && mouseX < leftPos + 137 && mouseY > topPos + 61 && mouseY < topPos + 85)
			this.renderTooltip(ms, Component.translatable("gui.betterskills.mining_tree.tooltip_the_root"), mouseX, mouseY);
		if (mouseX > leftPos + 148 && mouseX < leftPos + 172 && mouseY > topPos + 61 && mouseY < topPos + 85)
			this.renderTooltip(ms, Component.literal(MTIhaste1Procedure.execute(entity)), mouseX, mouseY);
		if (MThaste1Procedure.execute(entity))
			if (mouseX > leftPos + 148 && mouseX < leftPos + 172 && mouseY > topPos + 96 && mouseY < topPos + 120)
				this.renderTooltip(ms, Component.literal(MTIhaste2Procedure.execute(entity)), mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		RenderSystem.setShaderTexture(0, new ResourceLocation("betterskills:textures/screens/skymining.png"));
		this.blit(ms, this.leftPos + -1, this.topPos + -1, 0, 0, 254, 141, 254, 141);

		RenderSystem.setShaderTexture(0, new ResourceLocation("betterskills:textures/screens/screen2.png"));
		this.blit(ms, this.leftPos + 0, this.topPos + 0, 0, 0, -1, -1, -1, -1);

		RenderSystem.setShaderTexture(0, new ResourceLocation("betterskills:textures/screens/line.png"));
		this.blit(ms, this.leftPos + 135, this.topPos + 65, 0, 0, 16, 16, 16, 16);

		if (MThaste1Procedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("betterskills:textures/screens/linei.png"));
			this.blit(ms, this.leftPos + 135, this.topPos + 65, 0, 0, 16, 16, 16, 16);
		}
		if (MThaste1Procedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("betterskills:textures/screens/lined.png"));
			this.blit(ms, this.leftPos + 152, this.topPos + 83, 0, 0, 16, 16, 16, 16);
		}
		if (MThaste2Procedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("betterskills:textures/screens/linedi.png"));
			this.blit(ms, this.leftPos + 152, this.topPos + 83, 0, 0, 16, 16, 16, 16);
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
		this.font.draw(poseStack, Component.translatable("gui.betterskills.mining_tree.label_ability_config"), 7, 5, -10066330);
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
		imagebutton_left = new ImageButton(this.leftPos + 8, this.topPos + 62, 14, 22, 0, 0, 22, new ResourceLocation("betterskills:textures/screens/atlas/imagebutton_left.png"), 14, 44, e -> {
			if (true) {
				BetterskillsMod.PACKET_HANDLER.sendToServer(new MiningTreeButtonMessage(0, x, y, z));
				MiningTreeButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_left", imagebutton_left);
		this.addRenderableWidget(imagebutton_left);
		imagebutton_right = new ImageButton(this.leftPos + 228, this.topPos + 62, 14, 22, 0, 0, 22, new ResourceLocation("betterskills:textures/screens/atlas/imagebutton_right.png"), 14, 44, e -> {
			if (true) {
				BetterskillsMod.PACKET_HANDLER.sendToServer(new MiningTreeButtonMessage(1, x, y, z));
				MiningTreeButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_right", imagebutton_right);
		this.addRenderableWidget(imagebutton_right);
		imagebutton_down = new ImageButton(this.leftPos + 114, this.topPos + 116, 22, 14, 0, 0, 14, new ResourceLocation("betterskills:textures/screens/atlas/imagebutton_down.png"), 22, 28, e -> {
			if (true) {
				BetterskillsMod.PACKET_HANDLER.sendToServer(new MiningTreeButtonMessage(2, x, y, z));
				MiningTreeButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_down", imagebutton_down);
		this.addRenderableWidget(imagebutton_down);
		imagebutton_up = new ImageButton(this.leftPos + 114, this.topPos + 18, 22, 14, 0, 0, 14, new ResourceLocation("betterskills:textures/screens/atlas/imagebutton_up.png"), 22, 28, e -> {
			if (true) {
				BetterskillsMod.PACKET_HANDLER.sendToServer(new MiningTreeButtonMessage(3, x, y, z));
				MiningTreeButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_up", imagebutton_up);
		this.addRenderableWidget(imagebutton_up);
		imagebutton_iconmining = new ImageButton(this.leftPos + 115, this.topPos + 63, 20, 20, 0, 0, 20, new ResourceLocation("betterskills:textures/screens/atlas/imagebutton_iconmining.png"), 20, 40, e -> {
		});
		guistate.put("button:imagebutton_iconmining", imagebutton_iconmining);
		this.addRenderableWidget(imagebutton_iconmining);
		imagebutton_iconhaste1 = new ImageButton(this.leftPos + 150, this.topPos + 63, 20, 20, 0, 0, 20, new ResourceLocation("betterskills:textures/screens/atlas/imagebutton_iconhaste1.png"), 20, 40, e -> {
			if (true) {
				BetterskillsMod.PACKET_HANDLER.sendToServer(new MiningTreeButtonMessage(5, x, y, z));
				MiningTreeButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:imagebutton_iconhaste1", imagebutton_iconhaste1);
		this.addRenderableWidget(imagebutton_iconhaste1);
		imagebutton_iconhaste2 = new ImageButton(this.leftPos + 150, this.topPos + 98, 20, 20, 0, 0, 20, new ResourceLocation("betterskills:textures/screens/atlas/imagebutton_iconhaste2.png"), 20, 40, e -> {
			if (MThaste1Procedure.execute(entity)) {
				BetterskillsMod.PACKET_HANDLER.sendToServer(new MiningTreeButtonMessage(6, x, y, z));
				MiningTreeButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (MThaste1Procedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_iconhaste2", imagebutton_iconhaste2);
		this.addRenderableWidget(imagebutton_iconhaste2);
	}
}
