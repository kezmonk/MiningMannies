
package net.mcreator.miningmannies.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.IWorldReader;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.PushReaction;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.miningmannies.MiningmanniesModElements;

import java.util.List;
import java.util.Collections;

@MiningmanniesModElements.ModElement.Tag
public class SteelBlockBlock extends MiningmanniesModElements.ModElement {
	@ObjectHolder("miningmannies:steel_block")
	public static final Block block = null;
	public SteelBlockBlock(MiningmanniesModElements instance) {
		super(instance, 29);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(200f, 1000f).lightValue(0).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE));
			setRegistryName("steel_block");
		}

		@Override
		public int tickRate(IWorldReader world) {
			return 20;
		}

		@Override
		public PushReaction getPushReaction(BlockState state) {
			return PushReaction.PUSH_ONLY;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(Items.IRON_INGOT, (int) (1)));
		}
	}
}
