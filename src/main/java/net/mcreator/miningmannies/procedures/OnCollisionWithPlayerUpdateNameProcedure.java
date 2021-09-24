package net.mcreator.miningmannies.procedures;

import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;

import net.mcreator.miningmannies.MiningmanniesModElements;

import java.util.concurrent.atomic.AtomicReference;
import java.util.Map;

@MiningmanniesModElements.ModElement.Tag
public class OnCollisionWithPlayerUpdateNameProcedure extends MiningmanniesModElements.ModElement {
	public OnCollisionWithPlayerUpdateNameProcedure(MiningmanniesModElements instance) {
		super(instance, 74);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure OnCollisionWithPlayerUpdateName!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setCustomName(new StringTextComponent(((new Object() {
			public ItemStack getItemStack(int sltid, Entity entity) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					_retval.set(capability.getStackInSlot(sltid).copy());
				});
				return _retval.get();
			}
		}.getItemStack((int) (0), entity)).getDisplayName().getString())));
	}
}
