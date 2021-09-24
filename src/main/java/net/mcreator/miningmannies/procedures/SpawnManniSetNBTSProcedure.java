package net.mcreator.miningmannies.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;

import net.mcreator.miningmannies.entity.OreSeekerLevel2Entity;
import net.mcreator.miningmannies.entity.OreSeekerLevel1Entity;
import net.mcreator.miningmannies.entity.MiningManniSlot45Entity;
import net.mcreator.miningmannies.entity.MiningManniSlot44Entity;
import net.mcreator.miningmannies.entity.MiningManniSlot43Entity;
import net.mcreator.miningmannies.entity.MiningManniSlot42Entity;
import net.mcreator.miningmannies.entity.MiningManniSlot41Entity;
import net.mcreator.miningmannies.entity.MiningManniSlot40Entity;
import net.mcreator.miningmannies.entity.MiningManniSlot35Entity;
import net.mcreator.miningmannies.entity.MiningManniSlot34Entity;
import net.mcreator.miningmannies.entity.MiningManniSlot33Entity;
import net.mcreator.miningmannies.entity.MiningManniSlot32Entity;
import net.mcreator.miningmannies.entity.MiningManniSlot31Entity;
import net.mcreator.miningmannies.entity.MiningManniSlot30Entity;
import net.mcreator.miningmannies.entity.MiningManniSlot25Entity;
import net.mcreator.miningmannies.entity.MiningManniSlot24Entity;
import net.mcreator.miningmannies.entity.MiningManniSlot23Entity;
import net.mcreator.miningmannies.entity.MiningManniSlot22Entity;
import net.mcreator.miningmannies.entity.MiningManniSlot21Entity;
import net.mcreator.miningmannies.entity.MiningManniSlot20Entity;
import net.mcreator.miningmannies.entity.MiningManniSlot15Entity;
import net.mcreator.miningmannies.entity.MiningManniSlot14Entity;
import net.mcreator.miningmannies.entity.MiningManniSlot13Entity;
import net.mcreator.miningmannies.entity.MiningManniSlot12Entity;
import net.mcreator.miningmannies.entity.MiningManniSlot11Entity;
import net.mcreator.miningmannies.entity.MiningManniSlot10Entity;
import net.mcreator.miningmannies.MiningmanniesModVariables;
import net.mcreator.miningmannies.MiningmanniesModElements;

import java.util.concurrent.atomic.AtomicReference;
import java.util.Map;

@MiningmanniesModElements.ModElement.Tag
public class SpawnManniSetNBTSProcedure extends MiningmanniesModElements.ModElement {
	public SpawnManniSetNBTSProcedure(MiningmanniesModElements instance) {
		super(instance, 70);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure SpawnManniSetNBTS!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity instanceof MiningManniSlot10Entity.CustomEntity)) {
			{
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new StringTextComponent("Mining Manni Phase 1.0"));
			}
			entity.getPersistentData().putDouble("timer", 0);
			entity.getPersistentData().putDouble("timerSpeed", 1);
			entity.getPersistentData().putBoolean("hasOwner", (false));
			entity.getPersistentData().putString("ownerName", "");
			entity.getPersistentData().putDouble("maxItemsInSlot1", 4);
			entity.getPersistentData().putDouble("digDownChance", 0.5);
		}
		if ((entity instanceof MiningManniSlot11Entity.CustomEntity)) {
			{
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new StringTextComponent("Mining Manni Phase 1.1"));
			}
			entity.getPersistentData().putDouble("maxItemsInSlot1", 8);
			entity.getPersistentData().putDouble("timer", 0);
			entity.getPersistentData().putDouble("timerSpeed", (MiningmanniesModVariables.MiningBlockTimerSpeed));
			entity.getPersistentData().putDouble("digDownChance", (MiningmanniesModVariables.ManniBlockDigChance));
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (0);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (1);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot1));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			entity.setCustomName(new StringTextComponent(((new Object() {
				public ItemStack getItemStack(int sltid, Entity entity) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).copy());
					});
					return _retval.get();
				}
			}.getItemStack((int) (0), entity)).getDisplayName().getString())));
			if ((!(((MiningmanniesModVariables.MiningBlockOwner)).equals("")))) {
				entity.getPersistentData().putString("ownerName", (MiningmanniesModVariables.MiningBlockOwner));
				entity.getPersistentData().putBoolean("hasOwner", (true));
			} else {
				entity.getPersistentData().putBoolean("hasOwner", (false));
				entity.getPersistentData().putString("ownerName", "");
			}
			MiningmanniesModVariables.MiningBlockItemNameSlot0 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot1 = (double) 0;
			MiningmanniesModVariables.MiningBlockOwner = (String) "";
			MiningmanniesModVariables.MiningBlockTimerSpeed = (double) 1;
			MiningmanniesModVariables.ManniBlockDigChance = (double) 0.5;
		}
		if ((entity instanceof MiningManniSlot12Entity.CustomEntity)) {
			{
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new StringTextComponent("Mining Manni Phase 1.2"));
			}
			entity.getPersistentData().putDouble("maxItemsInSlot1", 12);
			entity.getPersistentData().putDouble("timer", 0);
			entity.getPersistentData().putDouble("timerSpeed", (MiningmanniesModVariables.MiningBlockTimerSpeed));
			entity.getPersistentData().putDouble("digDownChance", (MiningmanniesModVariables.ManniBlockDigChance));
			entity.getPersistentData().putBoolean("madeOffspring", (false));
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (0);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (1);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot1));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			entity.setCustomName(new StringTextComponent(((new Object() {
				public ItemStack getItemStack(int sltid, Entity entity) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).copy());
					});
					return _retval.get();
				}
			}.getItemStack((int) (0), entity)).getDisplayName().getString())));
			if ((!(((MiningmanniesModVariables.MiningBlockOwner)).equals("")))) {
				entity.getPersistentData().putString("ownerName", (MiningmanniesModVariables.MiningBlockOwner));
				entity.getPersistentData().putBoolean("hasOwner", (true));
			} else {
				entity.getPersistentData().putBoolean("hasOwner", (false));
				entity.getPersistentData().putString("ownerName", "");
			}
			MiningmanniesModVariables.MiningBlockItemNameSlot0 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot1 = (double) 0;
			MiningmanniesModVariables.MiningBlockOwner = (String) "";
			MiningmanniesModVariables.MiningBlockTimerSpeed = (double) 1;
			MiningmanniesModVariables.ManniBlockDigChance = (double) 0.5;
		}
		if ((entity instanceof MiningManniSlot13Entity.CustomEntity)) {
			{
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new StringTextComponent("Mining Manni Phase 1.3"));
			}
			entity.getPersistentData().putDouble("maxItemsInSlot1", 26);
			entity.getPersistentData().putDouble("timer", 0);
			entity.getPersistentData().putDouble("timerSpeed", (MiningmanniesModVariables.MiningBlockTimerSpeed));
			entity.getPersistentData().putDouble("digDownChance", (MiningmanniesModVariables.ManniBlockDigChance));
			entity.getPersistentData().putBoolean("madeOffspring", (false));
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (0);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (1);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot1));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			entity.setCustomName(new StringTextComponent(((new Object() {
				public ItemStack getItemStack(int sltid, Entity entity) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).copy());
					});
					return _retval.get();
				}
			}.getItemStack((int) (0), entity)).getDisplayName().getString())));
			if ((!(((MiningmanniesModVariables.MiningBlockOwner)).equals("")))) {
				entity.getPersistentData().putString("ownerName", (MiningmanniesModVariables.MiningBlockOwner));
				entity.getPersistentData().putBoolean("hasOwner", (true));
			} else {
				entity.getPersistentData().putBoolean("hasOwner", (false));
				entity.getPersistentData().putString("ownerName", "");
			}
			MiningmanniesModVariables.MiningBlockItemNameSlot0 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot1 = (double) 0;
			MiningmanniesModVariables.MiningBlockOwner = (String) "";
			MiningmanniesModVariables.MiningBlockTimerSpeed = (double) 1;
			MiningmanniesModVariables.ManniBlockDigChance = (double) 0.5;
		}
		if ((entity instanceof MiningManniSlot14Entity.CustomEntity)) {
			{
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new StringTextComponent("Mining Manni Phase 1.4"));
			}
			entity.getPersistentData().putDouble("maxItemsInSlot1", 32);
			entity.getPersistentData().putDouble("timer", 0);
			entity.getPersistentData().putDouble("timerSpeed", (MiningmanniesModVariables.MiningBlockTimerSpeed));
			entity.getPersistentData().putDouble("digDownChance", (MiningmanniesModVariables.ManniBlockDigChance));
			entity.getPersistentData().putBoolean("madeOffspring", (false));
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (0);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (1);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot1));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			entity.setCustomName(new StringTextComponent(((new Object() {
				public ItemStack getItemStack(int sltid, Entity entity) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).copy());
					});
					return _retval.get();
				}
			}.getItemStack((int) (0), entity)).getDisplayName().getString())));
			if ((!(((MiningmanniesModVariables.MiningBlockOwner)).equals("")))) {
				entity.getPersistentData().putString("ownerName", (MiningmanniesModVariables.MiningBlockOwner));
				entity.getPersistentData().putBoolean("hasOwner", (true));
			} else {
				entity.getPersistentData().putBoolean("hasOwner", (false));
				entity.getPersistentData().putString("ownerName", "");
			}
			MiningmanniesModVariables.MiningBlockItemNameSlot0 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot1 = (double) 0;
			MiningmanniesModVariables.MiningBlockOwner = (String) "";
			MiningmanniesModVariables.MiningBlockTimerSpeed = (double) 1;
			MiningmanniesModVariables.ManniBlockDigChance = (double) 0.5;
		}
		if ((entity instanceof MiningManniSlot15Entity.CustomEntity)) {
			{
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new StringTextComponent("Mining Manni Phase 1.5"));
			}
			entity.getPersistentData().putDouble("maxItemsInSlot1", 64);
			entity.getPersistentData().putDouble("timer", 0);
			entity.getPersistentData().putDouble("timerSpeed", (MiningmanniesModVariables.MiningBlockTimerSpeed));
			entity.getPersistentData().putDouble("digDownChance", (MiningmanniesModVariables.ManniBlockDigChance));
			entity.getPersistentData().putBoolean("madeOffspring", (false));
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (0);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (1);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot1));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			entity.setCustomName(new StringTextComponent(((new Object() {
				public ItemStack getItemStack(int sltid, Entity entity) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).copy());
					});
					return _retval.get();
				}
			}.getItemStack((int) (0), entity)).getDisplayName().getString())));
			if ((!(((MiningmanniesModVariables.MiningBlockOwner)).equals("")))) {
				entity.getPersistentData().putString("ownerName", (MiningmanniesModVariables.MiningBlockOwner));
				entity.getPersistentData().putBoolean("hasOwner", (true));
			} else {
				entity.getPersistentData().putBoolean("hasOwner", (false));
				entity.getPersistentData().putString("ownerName", "");
			}
			MiningmanniesModVariables.MiningBlockItemNameSlot0 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot1 = (double) 0;
			MiningmanniesModVariables.MiningBlockOwner = (String) "";
			MiningmanniesModVariables.MiningBlockTimerSpeed = (double) 1;
			MiningmanniesModVariables.ManniBlockDigChance = (double) 0.5;
		}
		if ((entity instanceof OreSeekerLevel1Entity.CustomEntity)) {
			{
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new StringTextComponent("Seeker Level 1"));
			}
			entity.getPersistentData().putDouble("maxItemsInSlot1", 1);
			entity.getPersistentData().putDouble("timer", 0);
			entity.getPersistentData().putDouble("timerSpeed", 1);
			entity.getPersistentData().putDouble("digDownChance", 0.5);
		}
		if ((entity instanceof OreSeekerLevel2Entity.CustomEntity)) {
			{
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new StringTextComponent("Seeker Level 2"));
			}
			entity.getPersistentData().putDouble("maxItemsInSlot1", 1);
			entity.getPersistentData().putDouble("timer", 0);
			entity.getPersistentData().putDouble("timerSpeed", (MiningmanniesModVariables.MiningBlockTimerSpeed));
			entity.getPersistentData().putDouble("digDownChance", (MiningmanniesModVariables.ManniBlockDigChance));
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (0);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			entity.setCustomName(new StringTextComponent(((new Object() {
				public ItemStack getItemStack(int sltid, Entity entity) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).copy());
					});
					return _retval.get();
				}
			}.getItemStack((int) (0), entity)).getDisplayName().getString())));
			if ((!(((MiningmanniesModVariables.MiningBlockOwner)).equals("")))) {
				entity.getPersistentData().putString("ownerName", (MiningmanniesModVariables.MiningBlockOwner));
				entity.getPersistentData().putBoolean("hasOwner", (true));
			} else {
				entity.getPersistentData().putBoolean("hasOwner", (false));
				entity.getPersistentData().putString("ownerName", "");
			}
			MiningmanniesModVariables.MiningBlockItemNameSlot0 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockOwner = (String) "";
			MiningmanniesModVariables.MiningBlockTimerSpeed = (double) 1;
			MiningmanniesModVariables.ManniBlockDigChance = (double) 0.5;
		}
		if ((entity instanceof OreSeekerLevel3Entity.CustomEntity)) {
			{
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new StringTextComponent("Seeker Level 3 "));
			}
			entity.getPersistentData().putDouble("maxItemsInSlot1", 1);
			entity.getPersistentData().putDouble("timer", 0);
			entity.getPersistentData().putDouble("timerSpeed", (MiningmanniesModVariables.MiningBlockTimerSpeed));
			entity.getPersistentData().putDouble("digDownChance", (MiningmanniesModVariables.ManniBlockDigChance));
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (0);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			entity.setCustomName(new StringTextComponent(((new Object() {
				public ItemStack getItemStack(int sltid, Entity entity) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).copy());
					});
					return _retval.get();
				}
			}.getItemStack((int) (0), entity)).getDisplayName().getString())));
			if ((!(((MiningmanniesModVariables.MiningBlockOwner)).equals("")))) {
				entity.getPersistentData().putString("ownerName", (MiningmanniesModVariables.MiningBlockOwner));
				entity.getPersistentData().putBoolean("hasOwner", (true));
			} else {
				entity.getPersistentData().putBoolean("hasOwner", (false));
				entity.getPersistentData().putString("ownerName", "");
			}
			MiningmanniesModVariables.MiningBlockItemNameSlot0 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockOwner = (String) "";
			MiningmanniesModVariables.MiningBlockTimerSpeed = (double) 1;
			MiningmanniesModVariables.ManniBlockDigChance = (double) 0.5;
		}
		if ((entity instanceof MiningManniSlot20Entity.CustomEntity)) {
			{
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new StringTextComponent("Mining Manni Phase 2.0"));
			}
			entity.getPersistentData().putDouble("maxItemsInSlot1", 4);
			entity.getPersistentData().putDouble("timer", 0);
			entity.getPersistentData().putDouble("timerSpeed", (MiningmanniesModVariables.MiningBlockTimerSpeed));
			entity.getPersistentData().putDouble("digDownChance", (MiningmanniesModVariables.ManniBlockDigChance));
			entity.getPersistentData().putBoolean("madeOffspring", (false));
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (0);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (1);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot1));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			entity.setCustomName(new StringTextComponent(((new Object() {
				public ItemStack getItemStack(int sltid, Entity entity) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).copy());
					});
					return _retval.get();
				}
			}.getItemStack((int) (0), entity)).getDisplayName().getString())));
			if ((!(((MiningmanniesModVariables.MiningBlockOwner)).equals("")))) {
				entity.getPersistentData().putString("ownerName", (MiningmanniesModVariables.MiningBlockOwner));
				entity.getPersistentData().putBoolean("hasOwner", (true));
			} else {
				entity.getPersistentData().putBoolean("hasOwner", (false));
				entity.getPersistentData().putString("ownerName", "");
			}
			MiningmanniesModVariables.MiningBlockItemNameSlot0 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot1 = (double) 0;
			MiningmanniesModVariables.MiningBlockItemNameSlot2 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot3 = (double) 0;
			MiningmanniesModVariables.MiningBlockOwner = (String) "";
			MiningmanniesModVariables.MiningBlockTimerSpeed = (double) 1;
			MiningmanniesModVariables.ManniBlockDigChance = (double) 0.5;
		}
		if ((entity instanceof MiningManniSlot21Entity.CustomEntity)) {
			{
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new StringTextComponent("Mining Manni Phase 2.1"));
			}
			entity.getPersistentData().putDouble("maxItemsInSlot1", 8);
			entity.getPersistentData().putDouble("timer", 0);
			entity.getPersistentData().putDouble("timerSpeed", (MiningmanniesModVariables.MiningBlockTimerSpeed));
			entity.getPersistentData().putDouble("digDownChance", (MiningmanniesModVariables.ManniBlockDigChance));
			entity.getPersistentData().putBoolean("madeOffspring", (false));
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (0);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (1);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot1));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot2)))), (int) (1));
				final int _sltid = (int) (2);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot2)))), (int) (1));
				final int _sltid = (int) (3);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot3));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			entity.setCustomName(new StringTextComponent(((new Object() {
				public ItemStack getItemStack(int sltid, Entity entity) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).copy());
					});
					return _retval.get();
				}
			}.getItemStack((int) (0), entity)).getDisplayName().getString())));
			if ((!(((MiningmanniesModVariables.MiningBlockOwner)).equals("")))) {
				entity.getPersistentData().putString("ownerName", (MiningmanniesModVariables.MiningBlockOwner));
				entity.getPersistentData().putBoolean("hasOwner", (true));
			} else {
				entity.getPersistentData().putBoolean("hasOwner", (false));
				entity.getPersistentData().putString("ownerName", "");
			}
			MiningmanniesModVariables.MiningBlockItemNameSlot0 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot1 = (double) 0;
			MiningmanniesModVariables.MiningBlockItemNameSlot2 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot3 = (double) 0;
			MiningmanniesModVariables.MiningBlockOwner = (String) "";
			MiningmanniesModVariables.MiningBlockTimerSpeed = (double) 1;
			MiningmanniesModVariables.ManniBlockDigChance = (double) 0.5;
		}
		if ((entity instanceof MiningManniSlot22Entity.CustomEntity)) {
			{
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new StringTextComponent("Mining Manni Phase 2.2"));
			}
			entity.getPersistentData().putDouble("maxItemsInSlot1", 12);
			entity.getPersistentData().putDouble("timer", 0);
			entity.getPersistentData().putDouble("timerSpeed", (MiningmanniesModVariables.MiningBlockTimerSpeed));
			entity.getPersistentData().putDouble("digDownChance", (MiningmanniesModVariables.ManniBlockDigChance));
			entity.getPersistentData().putBoolean("madeOffspring", (false));
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (0);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (1);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot1));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot2)))), (int) (1));
				final int _sltid = (int) (2);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot2)))), (int) (1));
				final int _sltid = (int) (3);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot3));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			entity.setCustomName(new StringTextComponent(((new Object() {
				public ItemStack getItemStack(int sltid, Entity entity) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).copy());
					});
					return _retval.get();
				}
			}.getItemStack((int) (0), entity)).getDisplayName().getString())));
			if ((!(((MiningmanniesModVariables.MiningBlockOwner)).equals("")))) {
				entity.getPersistentData().putString("ownerName", (MiningmanniesModVariables.MiningBlockOwner));
				entity.getPersistentData().putBoolean("hasOwner", (true));
			} else {
				entity.getPersistentData().putBoolean("hasOwner", (false));
				entity.getPersistentData().putString("ownerName", "");
			}
			MiningmanniesModVariables.MiningBlockItemNameSlot0 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot1 = (double) 0;
			MiningmanniesModVariables.MiningBlockItemNameSlot2 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot3 = (double) 0;
			MiningmanniesModVariables.MiningBlockOwner = (String) "";
			MiningmanniesModVariables.MiningBlockTimerSpeed = (double) 1;
			MiningmanniesModVariables.ManniBlockDigChance = (double) 0.5;
		}
		if ((entity instanceof MiningManniSlot23Entity.CustomEntity)) {
			{
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new StringTextComponent("Mining Manni Phase 2.3"));
			}
			entity.getPersistentData().putDouble("maxItemsInSlot1", 26);
			entity.getPersistentData().putDouble("timer", 0);
			entity.getPersistentData().putDouble("timerSpeed", (MiningmanniesModVariables.MiningBlockTimerSpeed));
			entity.getPersistentData().putDouble("digDownChance", (MiningmanniesModVariables.ManniBlockDigChance));
			entity.getPersistentData().putBoolean("madeOffspring", (false));
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (0);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (1);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot1));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot2)))), (int) (1));
				final int _sltid = (int) (2);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot2)))), (int) (1));
				final int _sltid = (int) (3);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot3));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			entity.setCustomName(new StringTextComponent(((new Object() {
				public ItemStack getItemStack(int sltid, Entity entity) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).copy());
					});
					return _retval.get();
				}
			}.getItemStack((int) (0), entity)).getDisplayName().getString())));
			if ((!(((MiningmanniesModVariables.MiningBlockOwner)).equals("")))) {
				entity.getPersistentData().putString("ownerName", (MiningmanniesModVariables.MiningBlockOwner));
				entity.getPersistentData().putBoolean("hasOwner", (true));
			} else {
				entity.getPersistentData().putBoolean("hasOwner", (false));
				entity.getPersistentData().putString("ownerName", "");
			}
			MiningmanniesModVariables.MiningBlockItemNameSlot0 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot1 = (double) 0;
			MiningmanniesModVariables.MiningBlockItemNameSlot2 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot3 = (double) 0;
			MiningmanniesModVariables.MiningBlockOwner = (String) "";
			MiningmanniesModVariables.MiningBlockTimerSpeed = (double) 1;
			MiningmanniesModVariables.ManniBlockDigChance = (double) 0.5;
		}
		if ((entity instanceof MiningManniSlot24Entity.CustomEntity)) {
			{
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new StringTextComponent("Mining Manni Phase 2.4"));
			}
			entity.getPersistentData().putDouble("maxItemsInSlot1", 32);
			entity.getPersistentData().putDouble("timer", 0);
			entity.getPersistentData().putDouble("timerSpeed", (MiningmanniesModVariables.MiningBlockTimerSpeed));
			entity.getPersistentData().putDouble("digDownChance", (MiningmanniesModVariables.ManniBlockDigChance));
			entity.getPersistentData().putBoolean("madeOffspring", (false));
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (0);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (1);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot1));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot2)))), (int) (1));
				final int _sltid = (int) (2);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot2)))), (int) (1));
				final int _sltid = (int) (3);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot3));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			entity.setCustomName(new StringTextComponent(((new Object() {
				public ItemStack getItemStack(int sltid, Entity entity) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).copy());
					});
					return _retval.get();
				}
			}.getItemStack((int) (0), entity)).getDisplayName().getString())));
			if ((!(((MiningmanniesModVariables.MiningBlockOwner)).equals("")))) {
				entity.getPersistentData().putString("ownerName", (MiningmanniesModVariables.MiningBlockOwner));
				entity.getPersistentData().putBoolean("hasOwner", (true));
			} else {
				entity.getPersistentData().putBoolean("hasOwner", (false));
				entity.getPersistentData().putString("ownerName", "");
			}
			MiningmanniesModVariables.MiningBlockItemNameSlot0 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot1 = (double) 0;
			MiningmanniesModVariables.MiningBlockItemNameSlot2 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot3 = (double) 0;
			MiningmanniesModVariables.MiningBlockOwner = (String) "";
			MiningmanniesModVariables.MiningBlockTimerSpeed = (double) 1;
			MiningmanniesModVariables.ManniBlockDigChance = (double) 0.5;
		}
		if ((entity instanceof MiningManniSlot25Entity.CustomEntity)) {
			{
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new StringTextComponent("Mining Manni Phase 2.5"));
			}
			entity.getPersistentData().putDouble("maxItemsInSlot1", 64);
			entity.getPersistentData().putDouble("timer", 0);
			entity.getPersistentData().putDouble("timerSpeed", (MiningmanniesModVariables.MiningBlockTimerSpeed));
			entity.getPersistentData().putDouble("digDownChance", (MiningmanniesModVariables.ManniBlockDigChance));
			entity.getPersistentData().putBoolean("madeOffspring", (false));
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (0);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (1);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot1));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot2)))), (int) (1));
				final int _sltid = (int) (2);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot2)))), (int) (1));
				final int _sltid = (int) (3);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot3));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			entity.setCustomName(new StringTextComponent(((new Object() {
				public ItemStack getItemStack(int sltid, Entity entity) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).copy());
					});
					return _retval.get();
				}
			}.getItemStack((int) (0), entity)).getDisplayName().getString())));
			if ((!(((MiningmanniesModVariables.MiningBlockOwner)).equals("")))) {
				entity.getPersistentData().putString("ownerName", (MiningmanniesModVariables.MiningBlockOwner));
				entity.getPersistentData().putBoolean("hasOwner", (true));
			} else {
				entity.getPersistentData().putBoolean("hasOwner", (false));
				entity.getPersistentData().putString("ownerName", "");
			}
			MiningmanniesModVariables.MiningBlockItemNameSlot0 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot1 = (double) 0;
			MiningmanniesModVariables.MiningBlockItemNameSlot2 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot3 = (double) 0;
			MiningmanniesModVariables.MiningBlockOwner = (String) "";
			MiningmanniesModVariables.MiningBlockTimerSpeed = (double) 1;
			MiningmanniesModVariables.ManniBlockDigChance = (double) 0.5;
		}
		if ((entity instanceof MiningManniSlot30Entity.CustomEntity)) {
			{
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new StringTextComponent("Mining Manni Phase 3.0"));
			}
			entity.getPersistentData().putDouble("maxItemsInSlot1", 4);
			entity.getPersistentData().putDouble("timer", 0);
			entity.getPersistentData().putDouble("timerSpeed", (MiningmanniesModVariables.MiningBlockTimerSpeed));
			entity.getPersistentData().putDouble("digDownChance", (MiningmanniesModVariables.ManniBlockDigChance));
			entity.getPersistentData().putBoolean("madeOffspring", (false));
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (0);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (1);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot1));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot2)))), (int) (1));
				final int _sltid = (int) (2);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot2)))), (int) (1));
				final int _sltid = (int) (3);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot3));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			entity.setCustomName(new StringTextComponent(((new Object() {
				public ItemStack getItemStack(int sltid, Entity entity) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).copy());
					});
					return _retval.get();
				}
			}.getItemStack((int) (0), entity)).getDisplayName().getString())));
			if ((!(((MiningmanniesModVariables.MiningBlockOwner)).equals("")))) {
				entity.getPersistentData().putString("ownerName", (MiningmanniesModVariables.MiningBlockOwner));
				entity.getPersistentData().putBoolean("hasOwner", (true));
			} else {
				entity.getPersistentData().putBoolean("hasOwner", (false));
				entity.getPersistentData().putString("ownerName", "");
			}
			MiningmanniesModVariables.MiningBlockItemNameSlot0 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot1 = (double) 0;
			MiningmanniesModVariables.MiningBlockItemNameSlot2 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot3 = (double) 0;
			MiningmanniesModVariables.MiningBlockItemNameSlot4 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot5 = (double) 0;
			MiningmanniesModVariables.MiningBlockOwner = (String) "";
			MiningmanniesModVariables.MiningBlockTimerSpeed = (double) 1;
			MiningmanniesModVariables.ManniBlockDigChance = (double) 0.5;
		}
		if ((entity instanceof MiningManniSlot31Entity.CustomEntity)) {
			{
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new StringTextComponent("Mining Manni Phase 3.1"));
			}
			entity.getPersistentData().putDouble("maxItemsInSlot1", 8);
			entity.getPersistentData().putDouble("timer", 0);
			entity.getPersistentData().putDouble("timerSpeed", (MiningmanniesModVariables.MiningBlockTimerSpeed));
			entity.getPersistentData().putDouble("digDownChance", (MiningmanniesModVariables.ManniBlockDigChance));
			entity.getPersistentData().putBoolean("madeOffspring", (false));
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (0);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (1);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot1));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot2)))), (int) (1));
				final int _sltid = (int) (2);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot2)))), (int) (1));
				final int _sltid = (int) (3);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot3));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot4)))), (int) (1));
				final int _sltid = (int) (4);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot4)))), (int) (1));
				final int _sltid = (int) (5);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot5));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			entity.setCustomName(new StringTextComponent(((new Object() {
				public ItemStack getItemStack(int sltid, Entity entity) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).copy());
					});
					return _retval.get();
				}
			}.getItemStack((int) (0), entity)).getDisplayName().getString())));
			if ((!(((MiningmanniesModVariables.MiningBlockOwner)).equals("")))) {
				entity.getPersistentData().putString("ownerName", (MiningmanniesModVariables.MiningBlockOwner));
				entity.getPersistentData().putBoolean("hasOwner", (true));
			} else {
				entity.getPersistentData().putBoolean("hasOwner", (false));
				entity.getPersistentData().putString("ownerName", "");
			}
			MiningmanniesModVariables.MiningBlockItemNameSlot0 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot1 = (double) 0;
			MiningmanniesModVariables.MiningBlockItemNameSlot2 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot3 = (double) 0;
			MiningmanniesModVariables.MiningBlockItemNameSlot4 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot5 = (double) 0;
			MiningmanniesModVariables.MiningBlockOwner = (String) "";
			MiningmanniesModVariables.MiningBlockTimerSpeed = (double) 1;
			MiningmanniesModVariables.ManniBlockDigChance = (double) 0.5;
		}
		if ((entity instanceof MiningManniSlot32Entity.CustomEntity)) {
			{
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new StringTextComponent("Mining Manni Phase 3.2"));
			}
			entity.getPersistentData().putDouble("maxItemsInSlot1", 12);
			entity.getPersistentData().putDouble("timer", 0);
			entity.getPersistentData().putDouble("timerSpeed", (MiningmanniesModVariables.MiningBlockTimerSpeed));
			entity.getPersistentData().putDouble("digDownChance", (MiningmanniesModVariables.ManniBlockDigChance));
			entity.getPersistentData().putBoolean("madeOffspring", (false));
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (0);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (1);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot1));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot2)))), (int) (1));
				final int _sltid = (int) (2);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot2)))), (int) (1));
				final int _sltid = (int) (3);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot3));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot4)))), (int) (1));
				final int _sltid = (int) (4);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot4)))), (int) (1));
				final int _sltid = (int) (5);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot5));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			entity.setCustomName(new StringTextComponent(((new Object() {
				public ItemStack getItemStack(int sltid, Entity entity) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).copy());
					});
					return _retval.get();
				}
			}.getItemStack((int) (0), entity)).getDisplayName().getString())));
			if ((!(((MiningmanniesModVariables.MiningBlockOwner)).equals("")))) {
				entity.getPersistentData().putString("ownerName", (MiningmanniesModVariables.MiningBlockOwner));
				entity.getPersistentData().putBoolean("hasOwner", (true));
			} else {
				entity.getPersistentData().putBoolean("hasOwner", (false));
				entity.getPersistentData().putString("ownerName", "");
			}
			MiningmanniesModVariables.MiningBlockItemNameSlot0 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot1 = (double) 0;
			MiningmanniesModVariables.MiningBlockItemNameSlot2 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot3 = (double) 0;
			MiningmanniesModVariables.MiningBlockItemNameSlot4 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot5 = (double) 0;
			MiningmanniesModVariables.MiningBlockOwner = (String) "";
			MiningmanniesModVariables.MiningBlockTimerSpeed = (double) 1;
			MiningmanniesModVariables.ManniBlockDigChance = (double) 0.5;
		}
		if ((entity instanceof MiningManniSlot33Entity.CustomEntity)) {
			{
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new StringTextComponent("Mining Manni Phase 3.3"));
			}
			entity.getPersistentData().putDouble("maxItemsInSlot1", 26);
			entity.getPersistentData().putDouble("timer", 0);
			entity.getPersistentData().putDouble("timerSpeed", (MiningmanniesModVariables.MiningBlockTimerSpeed));
			entity.getPersistentData().putDouble("digDownChance", (MiningmanniesModVariables.ManniBlockDigChance));
			entity.getPersistentData().putBoolean("madeOffspring", (false));
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (0);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (1);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot1));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot2)))), (int) (1));
				final int _sltid = (int) (2);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot2)))), (int) (1));
				final int _sltid = (int) (3);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot3));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot4)))), (int) (1));
				final int _sltid = (int) (4);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot4)))), (int) (1));
				final int _sltid = (int) (5);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot5));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			entity.setCustomName(new StringTextComponent(((new Object() {
				public ItemStack getItemStack(int sltid, Entity entity) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).copy());
					});
					return _retval.get();
				}
			}.getItemStack((int) (0), entity)).getDisplayName().getString())));
			if ((!(((MiningmanniesModVariables.MiningBlockOwner)).equals("")))) {
				entity.getPersistentData().putString("ownerName", (MiningmanniesModVariables.MiningBlockOwner));
				entity.getPersistentData().putBoolean("hasOwner", (true));
			} else {
				entity.getPersistentData().putBoolean("hasOwner", (false));
				entity.getPersistentData().putString("ownerName", "");
			}
			MiningmanniesModVariables.MiningBlockItemNameSlot0 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot1 = (double) 0;
			MiningmanniesModVariables.MiningBlockItemNameSlot2 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot3 = (double) 0;
			MiningmanniesModVariables.MiningBlockItemNameSlot4 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot5 = (double) 0;
			MiningmanniesModVariables.MiningBlockOwner = (String) "";
			MiningmanniesModVariables.MiningBlockTimerSpeed = (double) 1;
			MiningmanniesModVariables.ManniBlockDigChance = (double) 0.5;
		}
		if ((entity instanceof MiningManniSlot34Entity.CustomEntity)) {
			{
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new StringTextComponent("Mining Manni Phase 3.4"));
			}
			entity.getPersistentData().putDouble("maxItemsInSlot1", 32);
			entity.getPersistentData().putDouble("timer", 0);
			entity.getPersistentData().putDouble("timerSpeed", (MiningmanniesModVariables.MiningBlockTimerSpeed));
			entity.getPersistentData().putDouble("digDownChance", (MiningmanniesModVariables.ManniBlockDigChance));
			entity.getPersistentData().putBoolean("madeOffspring", (false));
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (0);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (1);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot1));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot2)))), (int) (1));
				final int _sltid = (int) (2);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot2)))), (int) (1));
				final int _sltid = (int) (3);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot3));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot4)))), (int) (1));
				final int _sltid = (int) (4);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot4)))), (int) (1));
				final int _sltid = (int) (5);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot5));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			entity.setCustomName(new StringTextComponent(((new Object() {
				public ItemStack getItemStack(int sltid, Entity entity) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).copy());
					});
					return _retval.get();
				}
			}.getItemStack((int) (0), entity)).getDisplayName().getString())));
			if ((!(((MiningmanniesModVariables.MiningBlockOwner)).equals("")))) {
				entity.getPersistentData().putString("ownerName", (MiningmanniesModVariables.MiningBlockOwner));
				entity.getPersistentData().putBoolean("hasOwner", (true));
			} else {
				entity.getPersistentData().putBoolean("hasOwner", (false));
				entity.getPersistentData().putString("ownerName", "");
			}
			MiningmanniesModVariables.MiningBlockItemNameSlot0 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot1 = (double) 0;
			MiningmanniesModVariables.MiningBlockItemNameSlot2 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot3 = (double) 0;
			MiningmanniesModVariables.MiningBlockItemNameSlot4 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot5 = (double) 0;
			MiningmanniesModVariables.MiningBlockOwner = (String) "";
			MiningmanniesModVariables.MiningBlockTimerSpeed = (double) 1;
			MiningmanniesModVariables.ManniBlockDigChance = (double) 0.5;
		}
		if ((entity instanceof MiningManniSlot35Entity.CustomEntity)) {
			{
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new StringTextComponent("Mining Manni Phase 3.5"));
			}
			entity.getPersistentData().putDouble("maxItemsInSlot1", 64);
			entity.getPersistentData().putDouble("timer", 0);
			entity.getPersistentData().putDouble("timerSpeed", (MiningmanniesModVariables.MiningBlockTimerSpeed));
			entity.getPersistentData().putDouble("digDownChance", (MiningmanniesModVariables.ManniBlockDigChance));
			entity.getPersistentData().putBoolean("madeOffspring", (false));
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (0);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (1);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot1));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot2)))), (int) (1));
				final int _sltid = (int) (2);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot2)))), (int) (1));
				final int _sltid = (int) (3);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot3));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot4)))), (int) (1));
				final int _sltid = (int) (4);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot4)))), (int) (1));
				final int _sltid = (int) (5);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot5));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			entity.setCustomName(new StringTextComponent(((new Object() {
				public ItemStack getItemStack(int sltid, Entity entity) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).copy());
					});
					return _retval.get();
				}
			}.getItemStack((int) (0), entity)).getDisplayName().getString())));
			if ((!(((MiningmanniesModVariables.MiningBlockOwner)).equals("")))) {
				entity.getPersistentData().putString("ownerName", (MiningmanniesModVariables.MiningBlockOwner));
				entity.getPersistentData().putBoolean("hasOwner", (true));
			} else {
				entity.getPersistentData().putBoolean("hasOwner", (false));
				entity.getPersistentData().putString("ownerName", "");
			}
			MiningmanniesModVariables.MiningBlockItemNameSlot0 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot1 = (double) 0;
			MiningmanniesModVariables.MiningBlockItemNameSlot2 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot3 = (double) 0;
			MiningmanniesModVariables.MiningBlockItemNameSlot4 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot5 = (double) 0;
			MiningmanniesModVariables.MiningBlockOwner = (String) "";
			MiningmanniesModVariables.MiningBlockTimerSpeed = (double) 1;
			MiningmanniesModVariables.ManniBlockDigChance = (double) 0.5;
		}
		if ((entity instanceof MiningManniSlot40Entity.CustomEntity)) {
			{
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new StringTextComponent("Mining Manni Phase 4.0"));
			}
			entity.getPersistentData().putDouble("maxItemsInSlot1", 4);
			entity.getPersistentData().putDouble("timer", 0);
			entity.getPersistentData().putDouble("timerSpeed", (MiningmanniesModVariables.MiningBlockTimerSpeed));
			entity.getPersistentData().putDouble("digDownChance", (MiningmanniesModVariables.ManniBlockDigChance));
			entity.getPersistentData().putBoolean("madeOffspring", (false));
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (0);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (1);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot1));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot2)))), (int) (1));
				final int _sltid = (int) (2);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot2)))), (int) (1));
				final int _sltid = (int) (3);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot3));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot4)))), (int) (1));
				final int _sltid = (int) (4);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot4)))), (int) (1));
				final int _sltid = (int) (5);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot5));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			entity.setCustomName(new StringTextComponent(((new Object() {
				public ItemStack getItemStack(int sltid, Entity entity) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).copy());
					});
					return _retval.get();
				}
			}.getItemStack((int) (0), entity)).getDisplayName().getString())));
			if ((!(((MiningmanniesModVariables.MiningBlockOwner)).equals("")))) {
				entity.getPersistentData().putString("ownerName", (MiningmanniesModVariables.MiningBlockOwner));
				entity.getPersistentData().putBoolean("hasOwner", (true));
			} else {
				entity.getPersistentData().putBoolean("hasOwner", (false));
				entity.getPersistentData().putString("ownerName", "");
			}
			MiningmanniesModVariables.MiningBlockItemNameSlot0 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot1 = (double) 0;
			MiningmanniesModVariables.MiningBlockItemNameSlot2 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot3 = (double) 0;
			MiningmanniesModVariables.MiningBlockItemNameSlot4 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot5 = (double) 0;
			MiningmanniesModVariables.MiningBlockItemNameSlot6 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot7 = (double) 0;
			MiningmanniesModVariables.MiningBlockOwner = (String) "";
			MiningmanniesModVariables.MiningBlockTimerSpeed = (double) 1;
			MiningmanniesModVariables.ManniBlockDigChance = (double) 0.5;
		}
		if ((entity instanceof MiningManniSlot41Entity.CustomEntity)) {
			{
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new StringTextComponent("Mining Manni Phase 4.1"));
			}
			entity.getPersistentData().putDouble("maxItemsInSlot1", 8);
			entity.getPersistentData().putDouble("timer", 0);
			entity.getPersistentData().putDouble("timerSpeed", (MiningmanniesModVariables.MiningBlockTimerSpeed));
			entity.getPersistentData().putDouble("digDownChance", (MiningmanniesModVariables.ManniBlockDigChance));
			entity.getPersistentData().putBoolean("madeOffspring", (false));
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (0);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (1);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot1));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot2)))), (int) (1));
				final int _sltid = (int) (2);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot2)))), (int) (1));
				final int _sltid = (int) (3);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot3));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot4)))), (int) (1));
				final int _sltid = (int) (4);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot4)))), (int) (1));
				final int _sltid = (int) (5);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot5));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot6)))), (int) (1));
				final int _sltid = (int) (6);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot6)))), (int) (1));
				final int _sltid = (int) (7);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot7));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			entity.setCustomName(new StringTextComponent(((new Object() {
				public ItemStack getItemStack(int sltid, Entity entity) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).copy());
					});
					return _retval.get();
				}
			}.getItemStack((int) (0), entity)).getDisplayName().getString())));
			if ((!(((MiningmanniesModVariables.MiningBlockOwner)).equals("")))) {
				entity.getPersistentData().putString("ownerName", (MiningmanniesModVariables.MiningBlockOwner));
				entity.getPersistentData().putBoolean("hasOwner", (true));
			} else {
				entity.getPersistentData().putBoolean("hasOwner", (false));
				entity.getPersistentData().putString("ownerName", "");
			}
			MiningmanniesModVariables.MiningBlockItemNameSlot0 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot1 = (double) 0;
			MiningmanniesModVariables.MiningBlockItemNameSlot2 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot3 = (double) 0;
			MiningmanniesModVariables.MiningBlockItemNameSlot4 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot5 = (double) 0;
			MiningmanniesModVariables.MiningBlockItemNameSlot6 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot7 = (double) 0;
			MiningmanniesModVariables.MiningBlockOwner = (String) "";
			MiningmanniesModVariables.MiningBlockTimerSpeed = (double) 1;
			MiningmanniesModVariables.ManniBlockDigChance = (double) 0.5;
		}
		if ((entity instanceof MiningManniSlot42Entity.CustomEntity)) {
			{
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new StringTextComponent("Mining Manni Phase 4.2"));
			}
			entity.getPersistentData().putDouble("maxItemsInSlot1", 12);
			entity.getPersistentData().putDouble("timer", 0);
			entity.getPersistentData().putDouble("timerSpeed", (MiningmanniesModVariables.MiningBlockTimerSpeed));
			entity.getPersistentData().putDouble("digDownChance", (MiningmanniesModVariables.ManniBlockDigChance));
			entity.getPersistentData().putBoolean("madeOffspring", (false));
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (0);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (1);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot1));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot2)))), (int) (1));
				final int _sltid = (int) (2);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot2)))), (int) (1));
				final int _sltid = (int) (3);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot3));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot4)))), (int) (1));
				final int _sltid = (int) (4);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot4)))), (int) (1));
				final int _sltid = (int) (5);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot5));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot6)))), (int) (1));
				final int _sltid = (int) (6);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot6)))), (int) (1));
				final int _sltid = (int) (7);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot7));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			entity.setCustomName(new StringTextComponent(((new Object() {
				public ItemStack getItemStack(int sltid, Entity entity) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).copy());
					});
					return _retval.get();
				}
			}.getItemStack((int) (0), entity)).getDisplayName().getString())));
			if ((!(((MiningmanniesModVariables.MiningBlockOwner)).equals("")))) {
				entity.getPersistentData().putString("ownerName", (MiningmanniesModVariables.MiningBlockOwner));
				entity.getPersistentData().putBoolean("hasOwner", (true));
			} else {
				entity.getPersistentData().putBoolean("hasOwner", (false));
				entity.getPersistentData().putString("ownerName", "");
			}
			MiningmanniesModVariables.MiningBlockItemNameSlot0 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot1 = (double) 0;
			MiningmanniesModVariables.MiningBlockItemNameSlot2 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot3 = (double) 0;
			MiningmanniesModVariables.MiningBlockItemNameSlot4 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot5 = (double) 0;
			MiningmanniesModVariables.MiningBlockItemNameSlot6 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot7 = (double) 0;
			MiningmanniesModVariables.MiningBlockOwner = (String) "";
			MiningmanniesModVariables.MiningBlockTimerSpeed = (double) 1;
			MiningmanniesModVariables.ManniBlockDigChance = (double) 0.5;
		}
		if ((entity instanceof MiningManniSlot43Entity.CustomEntity)) {
			{
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new StringTextComponent("Mining Manni Phase 4.3"));
			}
			entity.getPersistentData().putDouble("maxItemsInSlot1", 26);
			entity.getPersistentData().putDouble("timer", 0);
			entity.getPersistentData().putDouble("timerSpeed", (MiningmanniesModVariables.MiningBlockTimerSpeed));
			entity.getPersistentData().putDouble("digDownChance", (MiningmanniesModVariables.ManniBlockDigChance));
			entity.getPersistentData().putBoolean("madeOffspring", (false));
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (0);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (1);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot1));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot2)))), (int) (1));
				final int _sltid = (int) (2);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot2)))), (int) (1));
				final int _sltid = (int) (3);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot3));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot4)))), (int) (1));
				final int _sltid = (int) (4);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot4)))), (int) (1));
				final int _sltid = (int) (5);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot5));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot6)))), (int) (1));
				final int _sltid = (int) (6);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot6)))), (int) (1));
				final int _sltid = (int) (7);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot7));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			entity.setCustomName(new StringTextComponent(((new Object() {
				public ItemStack getItemStack(int sltid, Entity entity) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).copy());
					});
					return _retval.get();
				}
			}.getItemStack((int) (0), entity)).getDisplayName().getString())));
			if ((!(((MiningmanniesModVariables.MiningBlockOwner)).equals("")))) {
				entity.getPersistentData().putString("ownerName", (MiningmanniesModVariables.MiningBlockOwner));
				entity.getPersistentData().putBoolean("hasOwner", (true));
			} else {
				entity.getPersistentData().putBoolean("hasOwner", (false));
				entity.getPersistentData().putString("ownerName", "");
			}
			MiningmanniesModVariables.MiningBlockItemNameSlot0 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot1 = (double) 0;
			MiningmanniesModVariables.MiningBlockItemNameSlot2 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot3 = (double) 0;
			MiningmanniesModVariables.MiningBlockItemNameSlot4 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot5 = (double) 0;
			MiningmanniesModVariables.MiningBlockItemNameSlot6 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot7 = (double) 0;
			MiningmanniesModVariables.MiningBlockOwner = (String) "";
			MiningmanniesModVariables.MiningBlockTimerSpeed = (double) 1;
			MiningmanniesModVariables.ManniBlockDigChance = (double) 0.5;
		}
		if ((entity instanceof MiningManniSlot44Entity.CustomEntity)) {
			{
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new StringTextComponent("Mining Manni Phase 4.4"));
			}
			entity.getPersistentData().putDouble("maxItemsInSlot1", 32);
			entity.getPersistentData().putDouble("timer", 0);
			entity.getPersistentData().putDouble("timerSpeed", (MiningmanniesModVariables.MiningBlockTimerSpeed));
			entity.getPersistentData().putDouble("digDownChance", (MiningmanniesModVariables.ManniBlockDigChance));
			entity.getPersistentData().putBoolean("madeOffspring", (false));
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (0);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (1);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot1));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot2)))), (int) (1));
				final int _sltid = (int) (2);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot2)))), (int) (1));
				final int _sltid = (int) (3);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot3));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot4)))), (int) (1));
				final int _sltid = (int) (4);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot4)))), (int) (1));
				final int _sltid = (int) (5);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot5));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot6)))), (int) (1));
				final int _sltid = (int) (6);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot6)))), (int) (1));
				final int _sltid = (int) (7);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot7));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			entity.setCustomName(new StringTextComponent(((new Object() {
				public ItemStack getItemStack(int sltid, Entity entity) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).copy());
					});
					return _retval.get();
				}
			}.getItemStack((int) (0), entity)).getDisplayName().getString())));
			if ((!(((MiningmanniesModVariables.MiningBlockOwner)).equals("")))) {
				entity.getPersistentData().putString("ownerName", (MiningmanniesModVariables.MiningBlockOwner));
				entity.getPersistentData().putBoolean("hasOwner", (true));
			} else {
				entity.getPersistentData().putBoolean("hasOwner", (false));
				entity.getPersistentData().putString("ownerName", "");
			}
			MiningmanniesModVariables.MiningBlockItemNameSlot0 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot1 = (double) 0;
			MiningmanniesModVariables.MiningBlockItemNameSlot2 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot3 = (double) 0;
			MiningmanniesModVariables.MiningBlockItemNameSlot4 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot5 = (double) 0;
			MiningmanniesModVariables.MiningBlockItemNameSlot6 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot7 = (double) 0;
			MiningmanniesModVariables.MiningBlockOwner = (String) "";
			MiningmanniesModVariables.MiningBlockTimerSpeed = (double) 1;
			MiningmanniesModVariables.ManniBlockDigChance = (double) 0.5;
		}
		if ((entity instanceof MiningManniSlot45Entity.CustomEntity)) {
			{
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new StringTextComponent("Mining Manni Phase 4.5"));
			}
			entity.getPersistentData().putDouble("maxItemsInSlot1", 64);
			entity.getPersistentData().putDouble("timer", 0);
			entity.getPersistentData().putDouble("timerSpeed", (MiningmanniesModVariables.MiningBlockTimerSpeed));
			entity.getPersistentData().putDouble("digDownChance", (MiningmanniesModVariables.ManniBlockDigChance));
			entity.getPersistentData().putBoolean("madeOffspring", (false));
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (0);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot0)))), (int) (1));
				final int _sltid = (int) (1);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot1));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot2)))), (int) (1));
				final int _sltid = (int) (2);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot2)))), (int) (1));
				final int _sltid = (int) (3);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot3));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot4)))), (int) (1));
				final int _sltid = (int) (4);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot4)))), (int) (1));
				final int _sltid = (int) (5);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot5));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot6)))), (int) (1));
				final int _sltid = (int) (6);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			{
				final ItemStack _setstack = new ItemStack(
						(ForgeRegistries.ITEMS.getValue(new ResourceLocation((MiningmanniesModVariables.MiningBlockItemNameSlot6)))), (int) (1));
				final int _sltid = (int) (7);
				_setstack.setCount((int) (MiningmanniesModVariables.MiningBlockItemNumberSlot7));
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			entity.setCustomName(new StringTextComponent(((new Object() {
				public ItemStack getItemStack(int sltid, Entity entity) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).copy());
					});
					return _retval.get();
				}
			}.getItemStack((int) (0), entity)).getDisplayName().getString())));
			if ((!(((MiningmanniesModVariables.MiningBlockOwner)).equals("")))) {
				entity.getPersistentData().putString("ownerName", (MiningmanniesModVariables.MiningBlockOwner));
				entity.getPersistentData().putBoolean("hasOwner", (true));
			} else {
				entity.getPersistentData().putBoolean("hasOwner", (false));
				entity.getPersistentData().putString("ownerName", "");
			}
			MiningmanniesModVariables.MiningBlockItemNameSlot0 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot1 = (double) 0;
			MiningmanniesModVariables.MiningBlockItemNameSlot2 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot3 = (double) 0;
			MiningmanniesModVariables.MiningBlockItemNameSlot4 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot5 = (double) 0;
			MiningmanniesModVariables.MiningBlockItemNameSlot6 = (String) "minecraft:air";
			MiningmanniesModVariables.MiningBlockItemNumberSlot7 = (double) 0;
			MiningmanniesModVariables.MiningBlockOwner = (String) "";
			MiningmanniesModVariables.MiningBlockTimerSpeed = (double) 1;
			MiningmanniesModVariables.ManniBlockDigChance = (double) 0.5;
		}
	}
}
