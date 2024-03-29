
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
		this.xSize = 349;
		this.ySize = 208;
	}

	private static final ResourceLocation texture = new ResourceLocation("betterskills:textures/screens/skills.png");

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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("betterskills:textures/screens/skillsfont.png"));
		this.blit(ms, this.guiLeft + -2, this.guiTop + 0, 0, 0, 352, 208, 352, 208);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("betterskills:textures/screens/skillstextlow.png"));
		this.blit(ms, this.guiLeft + 4, this.guiTop + 6, 0, 0, 100, 27, 100, 27);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("betterskills:textures/screens/fishing_rod.png"));
		this.blit(ms, this.guiLeft + 288, this.guiTop + 82, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("betterskills:textures/screens/wooden_pick.png"));
		this.blit(ms, this.guiLeft + 29, this.guiTop + 81, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("betterskills:textures/screens/wooden_sword.png"));
		this.blit(ms, this.guiLeft + 96, this.guiTop + 82, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("betterskills:textures/screens/wood_axe.png"));
		this.blit(ms, this.guiLeft + 159, this.guiTop + 83, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("betterskills:textures/screens/wood_hoe.png"));
		this.blit(ms, this.guiLeft + 221, this.guiTop + 83, 0, 0, 32, 32, 32, 32);

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
		this.font.drawString(ms, "Mining " + ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).MiningLvL) + "", 27, 71, -12829636);
		this.font.drawString(ms, "Combat " + ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).CombatLvl) + "", 89, 71, -12829636);
		this.font.drawString(ms, "Farming " + ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).FarmingLvL) + "", 219, 71, -12829636);
		this.font.drawString(ms, "Fishing " + ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).FishingLvL) + "", 287, 70, -12829636);
		this.font.drawString(ms, "Foraging " + ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).ForagingLvl) + "", 157, 71, -12829636);
		this.font.drawString(ms, "" + ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).ForagingXP) + "", 157, 118, -12829636);
		this.font.drawString(ms, "" + ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).CombatXP) + "", 89, 118, -12829636);
		this.font.drawString(ms, "" + ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).MiningXP) + "", 27, 118, -12829636);
		this.font.drawString(ms, "" + ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).FarmingXP) + "", 219, 118, -12829636);
		this.font.drawString(ms, "" + ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).FishingXP) + "", 287, 118, -12829636);
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
		this.addButton(new Button(this.guiLeft + 242, this.guiTop + 177, 98, 20, new StringTextComponent("Ability config"), e -> {
			if (true) {
				BetterskillsMod.PACKET_HANDLER.sendToServer(new SkillsGui.ButtonPressedMessage(0, x, y, z));
				SkillsGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}
