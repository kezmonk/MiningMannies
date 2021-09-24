package net.mcreator.miningmannies.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.miningmannies.MiningmanniesModVariables;
import net.mcreator.miningmannies.MiningmanniesModElements;

import java.util.Map;

@MiningmanniesModElements.ModElement.Tag
public class ManniChatterCommandExecutedProcedure extends MiningmanniesModElements.ModElement {
	public ManniChatterCommandExecutedProcedure(MiningmanniesModElements instance) {
		super(instance, 187);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ManniChatterCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((MiningmanniesModVariables.ManniChatter)) {
			MiningmanniesModVariables.ManniChatter = (boolean) (false);
		} else {
			MiningmanniesModVariables.ManniChatter = (boolean) (true);
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote) {
			((PlayerEntity) entity)
					.sendStatusMessage(new StringTextComponent((("Changed chatter to ") + "" + ((MiningmanniesModVariables.ManniChatter)))), (false));
		}
	}
}
