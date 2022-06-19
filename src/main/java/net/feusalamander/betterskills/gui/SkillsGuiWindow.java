
package net.feusalamander.betterskills.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.feusalamander.betterskills.BetterskillsModVariables;
import net.feusalamander.betterskills.BetterskillsMod;

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
		this.xSize = 278;
		this.ySize = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("betterskills:textures/skills.png");

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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("betterskills:textures/wooden_pick.png"));
		this.blit(ms, this.guiLeft + 3, this.guiTop + 15, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("betterskills:textures/wooden_sword.png"));
		this.blit(ms, this.guiLeft + 101, this.guiTop + 65, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("betterskills:textures/wood_hoe.png"));
		this.blit(ms, this.guiLeft + 6, this.guiTop + 92, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("betterskills:textures/wood_axe.png"));
		this.blit(ms, this.guiLeft + 172, this.guiTop + 92, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("betterskills:textures/fishing_rod.png"));
		this.blit(ms, this.guiLeft + 175, this.guiTop + 15, 0, 0, 32, 32, 32, 32);

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
		this.font.drawString(ms, "Mining " + ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterskillsModVariables.PlayerVariables())).MiningLvL) + "", 3, 6, -12829636);
		this.font.drawString(ms, "" + ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterskillsModVariables.PlayerVariables())).MiningXP) + "", 3, 55, -12829636);
		this.font.drawString(ms, "Total xp:", 3, 46, -12829636);
		this.font.drawString(ms, "Combat " + ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterskillsModVariables.PlayerVariables())).CombatLvl) + "", 98, 54, -12829636);
		this.font.drawString(ms, "Total xp:", 98, 97, -12829636);
		this.font.drawString(ms, "" + ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterskillsModVariables.PlayerVariables())).CombatXP) + "", 98, 109, -12829636);
		this.font.drawString(ms, "Farming " + ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterskillsModVariables.PlayerVariables())).FarmingLvL) + "", 3, 80, -12829636);
		this.font.drawString(ms, "Total xp:", 3, 124, -12829636);
		this.font.drawString(ms, "" + ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterskillsModVariables.PlayerVariables())).FarmingXP) + "", 3, 135, -12829636);
		this.font.drawString(ms, "Foraging " + ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterskillsModVariables.PlayerVariables())).ForagingLvl) + "", 173, 80, -12829636);
		this.font.drawString(ms, "Total xp :", 173, 123, -12829636);
		this.font.drawString(ms, "" + ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterskillsModVariables.PlayerVariables())).ForagingXP) + "", 174, 135, -12829636);
		this.font.drawString(ms, "Fishing " + ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterskillsModVariables.PlayerVariables())).FishingLvL) + "", 174, 6, -12829636);
		this.font.drawString(ms, "Total xp:", 174, 45, -12829636);
		this.font.drawString(ms, "" + ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterskillsModVariables.PlayerVariables())).FishingXP) + "", 174, 55, -12829636);
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
		this.addButton(new Button(this.guiLeft + 176, this.guiTop + 144, 98, 20, new StringTextComponent("Ability config"), e -> {
			if (true) {
				BetterskillsMod.PACKET_HANDLER.sendToServer(new SkillsGui.ButtonPressedMessage(0, x, y, z));
				SkillsGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}
