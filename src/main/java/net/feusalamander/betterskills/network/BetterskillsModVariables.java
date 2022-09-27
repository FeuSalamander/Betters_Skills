package net.feusalamander.betterskills.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.feusalamander.betterskills.BetterskillsMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BetterskillsModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		BetterskillsMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new,
				PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getPlayer().level.isClientSide())
				((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
						.syncPlayerVariables(event.getPlayer());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getPlayer().level.isClientSide())
				((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
						.syncPlayerVariables(event.getPlayer());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getPlayer().level.isClientSide())
				((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
						.syncPlayerVariables(event.getPlayer());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new PlayerVariables()));
			clone.CombatXP = original.CombatXP;
			clone.MiningXP = original.MiningXP;
			clone.MiningLvL = original.MiningLvL;
			clone.CombatLvl = original.CombatLvl;
			clone.FarmingLvL = original.FarmingLvL;
			clone.FarmingXP = original.FarmingXP;
			clone.ForagingXP = original.ForagingXP;
			clone.ForagingLvl = original.ForagingLvl;
			clone.FishingXP = original.FishingXP;
			clone.FishingLvL = original.FishingLvL;
			clone.book = original.book;
			clone.Instanttree = original.Instanttree;
			clone.helpsoul = original.helpsoul;
			clone.mole = original.mole;
			if (!event.isWasDeath()) {
			}
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("betterskills", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public double CombatXP = 0.0;
		public double MiningXP = 0.0;
		public double MiningLvL = 0.0;
		public double CombatLvl = 0.0;
		public double FarmingLvL = 0.0;
		public double FarmingXP = 0.0;
		public double ForagingXP = 0.0;
		public double ForagingLvl = 0.0;
		public double FishingXP = 0.0;
		public double FishingLvL = 0.0;
		public boolean book = false;
		public boolean Instanttree = true;
		public boolean helpsoul = true;
		public boolean mole = true;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				BetterskillsMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("CombatXP", CombatXP);
			nbt.putDouble("MiningXP", MiningXP);
			nbt.putDouble("MiningLvL", MiningLvL);
			nbt.putDouble("CombatLvl", CombatLvl);
			nbt.putDouble("FarmingLvL", FarmingLvL);
			nbt.putDouble("FarmingXP", FarmingXP);
			nbt.putDouble("ForagingXP", ForagingXP);
			nbt.putDouble("ForagingLvl", ForagingLvl);
			nbt.putDouble("FishingXP", FishingXP);
			nbt.putDouble("FishingLvL", FishingLvL);
			nbt.putBoolean("book", book);
			nbt.putBoolean("Instanttree", Instanttree);
			nbt.putBoolean("helpsoul", helpsoul);
			nbt.putBoolean("mole", mole);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			CombatXP = nbt.getDouble("CombatXP");
			MiningXP = nbt.getDouble("MiningXP");
			MiningLvL = nbt.getDouble("MiningLvL");
			CombatLvl = nbt.getDouble("CombatLvl");
			FarmingLvL = nbt.getDouble("FarmingLvL");
			FarmingXP = nbt.getDouble("FarmingXP");
			ForagingXP = nbt.getDouble("ForagingXP");
			ForagingLvl = nbt.getDouble("ForagingLvl");
			FishingXP = nbt.getDouble("FishingXP");
			FishingLvL = nbt.getDouble("FishingLvL");
			book = nbt.getBoolean("book");
			Instanttree = nbt.getBoolean("Instanttree");
			helpsoul = nbt.getBoolean("helpsoul");
			mole = nbt.getBoolean("mole");
		}
	}

	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new PlayerVariables()));
					variables.CombatXP = message.data.CombatXP;
					variables.MiningXP = message.data.MiningXP;
					variables.MiningLvL = message.data.MiningLvL;
					variables.CombatLvl = message.data.CombatLvl;
					variables.FarmingLvL = message.data.FarmingLvL;
					variables.FarmingXP = message.data.FarmingXP;
					variables.ForagingXP = message.data.ForagingXP;
					variables.ForagingLvl = message.data.ForagingLvl;
					variables.FishingXP = message.data.FishingXP;
					variables.FishingLvL = message.data.FishingLvL;
					variables.book = message.data.book;
					variables.Instanttree = message.data.Instanttree;
					variables.helpsoul = message.data.helpsoul;
					variables.mole = message.data.mole;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
