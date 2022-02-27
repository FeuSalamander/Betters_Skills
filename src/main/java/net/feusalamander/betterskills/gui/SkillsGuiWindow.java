
package net.feusalamander.betterskills.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.feusalamander.betterskills.BetterSkillsModVariables;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class SkillsGuiWindow extends ContainerScreen<SkillsGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = SkillsGui.guistate;

	public SkillsGuiWindow(SkillsGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("better_skills:textures/skills.png");

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.blit(ms, k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("better_skills:textures/wooden_pick.png"));
		this.blit(ms, this.guiLeft + 6, this.guiTop + 16, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("better_skills:textures/wooden_sword.png"));
		this.blit(ms, this.guiLeft + 121, this.guiTop + 15, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("better_skills:textures/wood_hoe.png"));
		this.blit(ms, this.guiLeft + 9, this.guiTop + 95, 0, 0, 32, 32, 32, 32);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "Mining " + ((entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterSkillsModVariables.PlayerVariables())).MiningLvL) + "", 6, 7, -12829636);
		this.font.drawString(ms, "" + ((entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterSkillsModVariables.PlayerVariables())).MiningXP) + "", 6, 59, -12829636);
		this.font.drawString(ms, "Total xp:", 6, 48, -12829636);
		this.font.drawString(ms, "Combat " + ((entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterSkillsModVariables.PlayerVariables())).CombatLvl) + "", 114, 7, -12829636);
		this.font.drawString(ms, "Total xp:", 114, 48, -12829636);
		this.font.drawString(ms, "" + ((entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterSkillsModVariables.PlayerVariables())).CombatXP) + "", 114, 60, -12829636);
		this.font.drawString(ms, "Farming " + ((entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterSkillsModVariables.PlayerVariables())).FarmingLvL) + "", 6, 82, -12829636);
		this.font.drawString(ms, "Total xp:", 6, 129, -12829636);
		this.font.drawString(ms, "" + ((entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterSkillsModVariables.PlayerVariables())).FarmingXP) + "", 6, 141, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
	}
}
