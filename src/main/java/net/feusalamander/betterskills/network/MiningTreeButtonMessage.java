
package net.feusalamander.betterskills.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.feusalamander.betterskills.world.inventory.MiningTreeMenu;
import net.feusalamander.betterskills.procedures.OpenForagingTreeProcedure;
import net.feusalamander.betterskills.procedures.OpenFishingTreeProcedure;
import net.feusalamander.betterskills.procedures.OpenFarmingTreeProcedure;
import net.feusalamander.betterskills.procedures.OpenCombatTreeProcedure;
import net.feusalamander.betterskills.procedures.BMmole4Procedure;
import net.feusalamander.betterskills.procedures.BMmole3Procedure;
import net.feusalamander.betterskills.procedures.BMmole2Procedure;
import net.feusalamander.betterskills.procedures.BMmole1Procedure;
import net.feusalamander.betterskills.procedures.BMhaste4Procedure;
import net.feusalamander.betterskills.procedures.BMhaste3Procedure;
import net.feusalamander.betterskills.procedures.BMhaste2Procedure;
import net.feusalamander.betterskills.procedures.BMhaste1Procedure;
import net.feusalamander.betterskills.BetterskillsMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MiningTreeButtonMessage {
	private final int buttonID, x, y, z;

	public MiningTreeButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public MiningTreeButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(MiningTreeButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(MiningTreeButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level;
		HashMap guistate = MiningTreeMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			OpenFarmingTreeProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			OpenFishingTreeProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			OpenForagingTreeProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			OpenCombatTreeProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			BMhaste1Procedure.execute(entity);
		}
		if (buttonID == 6) {

			BMhaste2Procedure.execute(entity);
		}
		if (buttonID == 7) {

			BMhaste3Procedure.execute(entity);
		}
		if (buttonID == 8) {

			BMhaste4Procedure.execute(entity);
		}
		if (buttonID == 9) {

			BMmole1Procedure.execute(entity);
		}
		if (buttonID == 10) {

			BMmole2Procedure.execute(entity);
		}
		if (buttonID == 11) {

			BMmole3Procedure.execute(entity);
		}
		if (buttonID == 12) {

			BMmole4Procedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		BetterskillsMod.addNetworkMessage(MiningTreeButtonMessage.class, MiningTreeButtonMessage::buffer, MiningTreeButtonMessage::new, MiningTreeButtonMessage::handler);
	}
}
