package net.feusalamander.betterskills;

import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Direction;
import net.minecraft.network.PacketBuffer;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

public class BetterskillsModVariables {
	public BetterskillsModVariables(BetterskillsModElements elements) {
		elements.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new,
				PlayerVariablesSyncMessage::handler);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);
	}

	private void init(FMLCommonSetupEvent event) {
		CapabilityManager.INSTANCE.register(PlayerVariables.class, new PlayerVariablesStorage(), PlayerVariables::new);
	}

	@CapabilityInject(PlayerVariables.class)
	public static Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = null;

	@SubscribeEvent
	public void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof PlayerEntity && !(event.getObject() instanceof FakePlayer))
			event.addCapability(new ResourceLocation("betterskills", "player_variables"), new PlayerVariablesProvider());
	}

	private static class PlayerVariablesProvider implements ICapabilitySerializable<INBT> {
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(PLAYER_VARIABLES_CAPABILITY::getDefaultInstance);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public INBT serializeNBT() {
			return PLAYER_VARIABLES_CAPABILITY.getStorage().writeNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new),
					null);
		}

		@Override
		public void deserializeNBT(INBT nbt) {
			PLAYER_VARIABLES_CAPABILITY.getStorage().readNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new), null,
					nbt);
		}
	}

	private static class PlayerVariablesStorage implements Capability.IStorage<PlayerVariables> {
		@Override
		public INBT writeNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side) {
			CompoundNBT nbt = new CompoundNBT();
			nbt.putDouble("CombatXP", instance.CombatXP);
			nbt.putDouble("MiningXP", instance.MiningXP);
			nbt.putDouble("MiningLvL", instance.MiningLvL);
			nbt.putDouble("CombatLvl", instance.CombatLvl);
			nbt.putDouble("FarmingLvL", instance.FarmingLvL);
			nbt.putDouble("FarmingXP", instance.FarmingXP);
			nbt.putDouble("ForagingXP", instance.ForagingXP);
			nbt.putDouble("ForagingLvl", instance.ForagingLvl);
			nbt.putDouble("FishingXP", instance.FishingXP);
			nbt.putDouble("FishingLvL", instance.FishingLvL);
			nbt.putBoolean("book", instance.book);
			nbt.putBoolean("Instanttree", instance.Instanttree);
			nbt.putBoolean("helpsoul", instance.helpsoul);
			nbt.putBoolean("mole", instance.mole);
			nbt.putString("xptype", instance.xptype);
			nbt.putDouble("xpnumber", instance.xpnumber);
			nbt.putDouble("xptime", instance.xptime);
			return nbt;
		}

		@Override
		public void readNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side, INBT inbt) {
			CompoundNBT nbt = (CompoundNBT) inbt;
			instance.CombatXP = nbt.getDouble("CombatXP");
			instance.MiningXP = nbt.getDouble("MiningXP");
			instance.MiningLvL = nbt.getDouble("MiningLvL");
			instance.CombatLvl = nbt.getDouble("CombatLvl");
			instance.FarmingLvL = nbt.getDouble("FarmingLvL");
			instance.FarmingXP = nbt.getDouble("FarmingXP");
			instance.ForagingXP = nbt.getDouble("ForagingXP");
			instance.ForagingLvl = nbt.getDouble("ForagingLvl");
			instance.FishingXP = nbt.getDouble("FishingXP");
			instance.FishingLvL = nbt.getDouble("FishingLvL");
			instance.book = nbt.getBoolean("book");
			instance.Instanttree = nbt.getBoolean("Instanttree");
			instance.helpsoul = nbt.getBoolean("helpsoul");
			instance.mole = nbt.getBoolean("mole");
			instance.xptype = nbt.getString("xptype");
			instance.xpnumber = nbt.getDouble("xpnumber");
			instance.xptime = nbt.getDouble("xptime");
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
		public String xptype = "";
		public double xpnumber = 0;
		public double xptime = 0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayerEntity)
				BetterskillsMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) entity),
						new PlayerVariablesSyncMessage(this));
		}
	}

	@SubscribeEvent
	public void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void clonePlayer(PlayerEvent.Clone event) {
		PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new PlayerVariables()));
		PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
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
		clone.xptype = original.xptype;
		clone.xpnumber = original.xpnumber;
		clone.xptime = original.xptime;
		if (!event.isWasDeath()) {
		}
	}

	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;

		public PlayerVariablesSyncMessage(PacketBuffer buffer) {
			this.data = new PlayerVariables();
			new PlayerVariablesStorage().readNBT(null, this.data, null, buffer.readCompoundTag());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, PacketBuffer buffer) {
			buffer.writeCompoundTag((CompoundNBT) new PlayerVariablesStorage().writeNBT(null, message.data, null));
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
					variables.xptype = message.data.xptype;
					variables.xpnumber = message.data.xpnumber;
					variables.xptime = message.data.xptime;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
