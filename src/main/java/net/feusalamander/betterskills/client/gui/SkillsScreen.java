package net.feusalamander.betterskills.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.feusalamander.betterskills.world.inventory.SkillsMenu;
import net.feusalamander.betterskills.network.SkillsButtonMessage;
import net.feusalamander.betterskills.BetterskillsMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class SkillsScreen extends AbstractContainerScreen<SkillsMenu> {
	private final static HashMap<String, Object> guistate = SkillsMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_ability_config;

	public SkillsScreen(SkillsMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 349;
		this.imageHeight = 208;
	}

	private static final ResourceLocation texture = new ResourceLocation("betterskills:textures/screens/skills.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("betterskills:textures/screens/skillstextlow.png"));
		this.blit(ms, this.leftPos + 4, this.topPos + 6, 0, 0, 100, 27, 100, 27);

		RenderSystem.setShaderTexture(0, new ResourceLocation("betterskills:textures/screens/fishing_rod.png"));
		this.blit(ms, this.leftPos + 288, this.topPos + 82, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("betterskills:textures/screens/wooden_pick.png"));
		this.blit(ms, this.leftPos + 29, this.topPos + 81, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("betterskills:textures/screens/wooden_sword.png"));
		this.blit(ms, this.leftPos + 96, this.topPos + 82, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("betterskills:textures/screens/wood_axe.png"));
		this.blit(ms, this.leftPos + 159, this.topPos + 83, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("betterskills:textures/screens/wood_hoe.png"));
		this.blit(ms, this.leftPos + 221, this.topPos + 83, 0, 0, 32, 32, 32, 32);

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
		this.font.draw(poseStack, Component.translatable("gui.betterskills.skills.label_mining_varmininglvl"), 27, 71, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.betterskills.skills.label_combat_varcombatlvl"), 89, 71, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.betterskills.skills.label_farming_varfarminglvl"), 219, 71, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.betterskills.skills.label_fishing_varfishinglvl"), 287, 70, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.betterskills.skills.label_foraging_varforaginglvl"), 157, 71, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.betterskills.skills.label_varforagingxp"), 157, 118, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.betterskills.skills.label_varcombatxp"), 89, 118, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.betterskills.skills.label_varminingxp"), 27, 118, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.betterskills.skills.label_varfarmingxp"), 219, 118, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.betterskills.skills.label_varfishingxp"), 287, 118, -12829636);
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
		button_ability_config = new Button(this.leftPos + 242, this.topPos + 177, 98, 20, Component.translatable("gui.betterskills.skills.button_ability_config"), e -> {
			if (true) {
				BetterskillsMod.PACKET_HANDLER.sendToServer(new SkillsButtonMessage(0, x, y, z));
				SkillsButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_ability_config", button_ability_config);
		this.addRenderableWidget(button_ability_config);
	}
}
