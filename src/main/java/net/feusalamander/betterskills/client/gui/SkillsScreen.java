package net.feusalamander.betterskills.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Button;

import net.feusalamander.betterskills.world.inventory.SkillsMenu;
import net.feusalamander.betterskills.procedures.MiningTooltipProcedure;
import net.feusalamander.betterskills.procedures.MiningLvlProcedure;
import net.feusalamander.betterskills.procedures.ForagingTooltipProcedure;
import net.feusalamander.betterskills.procedures.ForagingLvlProcedure;
import net.feusalamander.betterskills.procedures.FishingTooltipProcedure;
import net.feusalamander.betterskills.procedures.FishingLvlProcedure;
import net.feusalamander.betterskills.procedures.FarmingTooltipProcedure;
import net.feusalamander.betterskills.procedures.FarmingLvlProcedure;
import net.feusalamander.betterskills.procedures.CombatTooltipProcedure;
import net.feusalamander.betterskills.procedures.CombatLvlProcedure;
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
	ImageButton imagebutton_mining;
	ImageButton imagebutton_combat;
	ImageButton imagebutton_foraging;
	ImageButton imagebutton_farming;
	ImageButton imagebutton_fishing;

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
		if (mouseX > leftPos + 33 && mouseX < leftPos + 57 && mouseY > topPos + 90 && mouseY < topPos + 114)
			this.renderTooltip(ms, Component.literal(MiningTooltipProcedure.execute(entity)), mouseX, mouseY);
		if (mouseX > leftPos + 96 && mouseX < leftPos + 120 && mouseY > topPos + 90 && mouseY < topPos + 114)
			this.renderTooltip(ms, Component.literal(CombatTooltipProcedure.execute(entity)), mouseX, mouseY);
		if (mouseX > leftPos + 163 && mouseX < leftPos + 187 && mouseY > topPos + 90 && mouseY < topPos + 114)
			this.renderTooltip(ms, Component.literal(ForagingTooltipProcedure.execute(entity)), mouseX, mouseY);
		if (mouseX > leftPos + 227 && mouseX < leftPos + 251 && mouseY > topPos + 90 && mouseY < topPos + 114)
			this.renderTooltip(ms, Component.literal(FarmingTooltipProcedure.execute(entity)), mouseX, mouseY);
		if (mouseX > leftPos + 292 && mouseX < leftPos + 316 && mouseY > topPos + 90 && mouseY < topPos + 114)
			this.renderTooltip(ms, Component.literal(FishingTooltipProcedure.execute(entity)), mouseX, mouseY);
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

				MiningLvlProcedure.execute(entity), 41, 121, -1);
		this.font.draw(poseStack,

				CombatLvlProcedure.execute(entity), 106, 121, -1);
		this.font.draw(poseStack,

				ForagingLvlProcedure.execute(entity), 171, 121, -1);
		this.font.draw(poseStack,

				FarmingLvlProcedure.execute(entity), 236, 121, -1);
		this.font.draw(poseStack,

				FishingLvlProcedure.execute(entity), 301, 121, -1);
		this.font.draw(poseStack, Component.translatable("gui.betterskills.skills.label_mining"), 31, 71, -1);
		this.font.draw(poseStack, Component.translatable("gui.betterskills.skills.label_combat"), 93, 71, -1);
		this.font.draw(poseStack, Component.translatable("gui.betterskills.skills.label_foraging"), 154, 71, -1);
		this.font.draw(poseStack, Component.translatable("gui.betterskills.skills.label_farming"), 221, 71, -1);
		this.font.draw(poseStack, Component.translatable("gui.betterskills.skills.label_fishing"), 287, 71, -1);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_ability_config = Button.builder(Component.translatable("gui.betterskills.skills.button_ability_config"), e -> {
			if (true) {
				BetterskillsMod.PACKET_HANDLER.sendToServer(new SkillsButtonMessage(0, x, y, z));
				SkillsButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 242, this.topPos + 177, 98, 20).build();
		guistate.put("button:button_ability_config", button_ability_config);
		this.addRenderableWidget(button_ability_config);
		imagebutton_mining = new ImageButton(this.leftPos + 20, this.topPos + 82, 48, 48, 0, 0, 48, new ResourceLocation("betterskills:textures/screens/atlas/imagebutton_mining.png"), 48, 96, e -> {
			if (true) {
				BetterskillsMod.PACKET_HANDLER.sendToServer(new SkillsButtonMessage(1, x, y, z));
				SkillsButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_mining", imagebutton_mining);
		this.addRenderableWidget(imagebutton_mining);
		imagebutton_combat = new ImageButton(this.leftPos + 85, this.topPos + 82, 48, 48, 0, 0, 48, new ResourceLocation("betterskills:textures/screens/atlas/imagebutton_combat.png"), 48, 96, e -> {
			if (true) {
				BetterskillsMod.PACKET_HANDLER.sendToServer(new SkillsButtonMessage(2, x, y, z));
				SkillsButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_combat", imagebutton_combat);
		this.addRenderableWidget(imagebutton_combat);
		imagebutton_foraging = new ImageButton(this.leftPos + 150, this.topPos + 82, 48, 48, 0, 0, 48, new ResourceLocation("betterskills:textures/screens/atlas/imagebutton_foraging.png"), 48, 96, e -> {
			if (true) {
				BetterskillsMod.PACKET_HANDLER.sendToServer(new SkillsButtonMessage(3, x, y, z));
				SkillsButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_foraging", imagebutton_foraging);
		this.addRenderableWidget(imagebutton_foraging);
		imagebutton_farming = new ImageButton(this.leftPos + 215, this.topPos + 82, 48, 48, 0, 0, 48, new ResourceLocation("betterskills:textures/screens/atlas/imagebutton_farming.png"), 48, 96, e -> {
			if (true) {
				BetterskillsMod.PACKET_HANDLER.sendToServer(new SkillsButtonMessage(4, x, y, z));
				SkillsButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_farming", imagebutton_farming);
		this.addRenderableWidget(imagebutton_farming);
		imagebutton_fishing = new ImageButton(this.leftPos + 280, this.topPos + 82, 48, 48, 0, 0, 48, new ResourceLocation("betterskills:textures/screens/atlas/imagebutton_fishing.png"), 48, 96, e -> {
			if (true) {
				BetterskillsMod.PACKET_HANDLER.sendToServer(new SkillsButtonMessage(5, x, y, z));
				SkillsButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:imagebutton_fishing", imagebutton_fishing);
		this.addRenderableWidget(imagebutton_fishing);
	}
}
