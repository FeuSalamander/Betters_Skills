
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

import net.feusalamander.betterskills.procedures.TreeonProcedure;
import net.feusalamander.betterskills.procedures.TreeoffProcedure;
import net.feusalamander.betterskills.procedures.SoulsonProcedure;
import net.feusalamander.betterskills.procedures.SoulsoffProcedure;
import net.feusalamander.betterskills.procedures.MoleonProcedure;
import net.feusalamander.betterskills.procedures.MoleoffProcedure;
import net.feusalamander.betterskills.BetterskillsMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class AbilityconfigGuiWindow extends ContainerScreen<AbilityconfigGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = AbilityconfigGui.guistate;

	public AbilityconfigGuiWindow(AbilityconfigGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 252;
		this.ySize = 140;
	}

	private static final ResourceLocation texture = new ResourceLocation("betterskills:textures/screens/abilityconfig.png");

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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("betterskills:textures/screens/skilltree.png"));
		this.blit(ms, this.guiLeft + 0, this.guiTop + 0, 0, 0, 252, 140, 252, 140);

		if (TreeoffProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("betterskills:textures/screens/no.png"));
			this.blit(ms, this.guiLeft + 77, this.guiTop + 18, 0, 0, 17, 17, 17, 17);
		}
		if (SoulsoffProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("betterskills:textures/screens/no.png"));
			this.blit(ms, this.guiLeft + 103, this.guiTop + 38, 0, 0, 17, 17, 17, 17);
		}
		if (TreeonProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("betterskills:textures/screens/ok.png"));
			this.blit(ms, this.guiLeft + 77, this.guiTop + 18, 0, 0, 17, 17, 17, 17);
		}
		if (SoulsonProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("betterskills:textures/screens/ok.png"));
			this.blit(ms, this.guiLeft + 103, this.guiTop + 38, 0, 0, 17, 17, 17, 17);
		}
		if (MoleonProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("betterskills:textures/screens/ok.png"));
			this.blit(ms, this.guiLeft + 37, this.guiTop + 59, 0, 0, 17, 17, 17, 17);
		}
		if (MoleoffProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("betterskills:textures/screens/no.png"));
			this.blit(ms, this.guiLeft + 37, this.guiTop + 59, 0, 0, 17, 17, 17, 17);
		}
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
		this.font.drawString(ms, "Ability Config", 7, 5, -12829636);
		this.font.drawString(ms, "Instant Tree", 10, 22, -3355444);
		this.font.drawString(ms, "Help of the souls", 11, 42, -3355444);
		this.font.drawString(ms, "Mole", 11, 63, -3355444);
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
		this.addButton(new Button(this.guiLeft + 202, this.guiTop + 17, 40, 20, new StringTextComponent("Toggle"), e -> {
			if (true) {
				BetterskillsMod.PACKET_HANDLER.sendToServer(new AbilityconfigGui.ButtonPressedMessage(0, x, y, z));
				AbilityconfigGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 202, this.guiTop + 38, 40, 20, new StringTextComponent("Toggle"), e -> {
			if (true) {
				BetterskillsMod.PACKET_HANDLER.sendToServer(new AbilityconfigGui.ButtonPressedMessage(1, x, y, z));
				AbilityconfigGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 202, this.guiTop + 59, 40, 20, new StringTextComponent("Toggle"), e -> {
			if (true) {
				BetterskillsMod.PACKET_HANDLER.sendToServer(new AbilityconfigGui.ButtonPressedMessage(2, x, y, z));
				AbilityconfigGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
	}
}
