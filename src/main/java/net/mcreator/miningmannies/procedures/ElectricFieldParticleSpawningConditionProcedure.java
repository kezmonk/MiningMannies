package net.mcreator.miningmannies.procedures;

import net.mcreator.miningmannies.MiningmanniesModElements;

import java.util.Map;

@MiningmanniesModElements.ModElement.Tag
public class ElectricFieldParticleSpawningConditionProcedure extends MiningmanniesModElements.ModElement {
	public ElectricFieldParticleSpawningConditionProcedure(MiningmanniesModElements instance) {
		super(instance, 32);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if ((Math.random() >= 0.98)) {
			return (true);
		}
		return (false);
	}
}
