
package net.mcreator.miningmannies.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.wrapper.EntityHandsInvWrapper;
import net.minecraftforge.items.wrapper.EntityArmorInvWrapper;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.util.Direction;
import net.minecraft.util.DamageSource;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.IPacket;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.FollowMobGoal;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.miningmannies.procedures.UpdateTickLevel42Procedure;
import net.mcreator.miningmannies.procedures.SpawnManniSetNBTSProcedure;
import net.mcreator.miningmannies.procedures.RightClickSet4parametersProcedure;
import net.mcreator.miningmannies.procedures.OnCollisionWithPlayerUpdateNameProcedure;
import net.mcreator.miningmannies.itemgroup.MiningManniesItemGroup;
import net.mcreator.miningmannies.gui.HarvestGUIFourSlotsGui;
import net.mcreator.miningmannies.MiningmanniesModElements;

import javax.annotation.Nullable;
import javax.annotation.Nonnull;

import java.util.Map;
import java.util.HashMap;

import io.netty.buffer.Unpooled;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@MiningmanniesModElements.ModElement.Tag
public class MiningManniSlot42Entity extends MiningmanniesModElements.ModElement {
	public static EntityType entity = null;
	public MiningManniSlot42Entity(MiningmanniesModElements instance) {
		super(instance, 26);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.CREATURE).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("mining_manni_slot_42")
						.setRegistryName("mining_manni_slot_42");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -13421773, -6710887, new Item.Properties().group(MiningManniesItemGroup.tab))
				.setRegistryName("mining_manni_slot_42"));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new ModelPhase42MiningManni(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("miningmannies:textures/phase42miningmanni.png");
				}
			};
		});
	}
	public static class CustomEntity extends CreatureEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 4;
			setNoAI(false);
			enablePersistence();
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1,
					new TemptGoal(this, 1, Ingredient.fromItems(new ItemStack(Items.DIAMOND_PICKAXE, (int) (1)).getItem()), false));
			this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 1));
			this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(5, new SwimGoal(this));
			this.goalSelector.addGoal(6, new FollowMobGoal(this, (float) 1, 10, 5));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public boolean canDespawn(double distanceToClosestPlayer) {
			return false;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.rabbit.ambient"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source == DamageSource.FALL)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		public ILivingEntityData onInitialSpawn(IWorld world, DifficultyInstance difficulty, SpawnReason reason, ILivingEntityData livingdata,
				CompoundNBT tag) {
			ILivingEntityData retval = super.onInitialSpawn(world, difficulty, reason, livingdata, tag);
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				SpawnManniSetNBTSProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
		private final ItemStackHandler inventory = new ItemStackHandler(8) {
			@Override
			public int getSlotLimit(int slot) {
				return 12;
			}
		};
		private final CombinedInvWrapper combined = new CombinedInvWrapper(inventory, new EntityHandsInvWrapper(this),
				new EntityArmorInvWrapper(this));
		@Override
		public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> capability, @Nullable Direction side) {
			if (this.isAlive() && capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY && side == null)
				return LazyOptional.of(() -> combined).cast();
			return super.getCapability(capability, side);
		}

		@Override
		protected void dropInventory() {
			super.dropInventory();
			for (int i = 0; i < inventory.getSlots(); ++i) {
				ItemStack itemstack = inventory.getStackInSlot(i);
				if (!itemstack.isEmpty() && !EnchantmentHelper.hasVanishingCurse(itemstack)) {
					this.entityDropItem(itemstack);
				}
			}
		}

		@Override
		public void writeAdditional(CompoundNBT compound) {
			super.writeAdditional(compound);
			compound.put("InventoryCustom", inventory.serializeNBT());
		}

		@Override
		public void readAdditional(CompoundNBT compound) {
			super.readAdditional(compound);
			INBT inventoryCustom = compound.get("InventoryCustom");
			if (inventoryCustom instanceof CompoundNBT)
				inventory.deserializeNBT((CompoundNBT) inventoryCustom);
		}

		@Override
		public boolean processInteract(PlayerEntity sourceentity, Hand hand) {
			ItemStack itemstack = sourceentity.getHeldItem(hand);
			boolean retval = true;
			if (sourceentity instanceof ServerPlayerEntity) {
				NetworkHooks.openGui((ServerPlayerEntity) sourceentity, new INamedContainerProvider() {
					@Override
					public ITextComponent getDisplayName() {
						return new StringTextComponent("Mining Manni Phase 4.2");
					}

					@Override
					public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
						PacketBuffer packetBuffer = new PacketBuffer(Unpooled.buffer());
						packetBuffer.writeBlockPos(new BlockPos(sourceentity));
						packetBuffer.writeByte(0);
						packetBuffer.writeVarInt(CustomEntity.this.getEntityId());
						return new HarvestGUIFourSlotsGui.GuiContainerMod(id, inventory, packetBuffer);
					}
				}, buf -> {
					buf.writeBlockPos(new BlockPos(sourceentity));
					buf.writeByte(0);
					buf.writeVarInt(this.getEntityId());
				});
			}
			super.processInteract(sourceentity, hand);
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("sourceentity", sourceentity);
				RightClickSet4parametersProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}

		@Override
		public void baseTick() {
			super.baseTick();
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				UpdateTickLevel42Procedure.executeProcedure($_dependencies);
			}
		}

		@Override
		public void onCollideWithPlayer(PlayerEntity sourceentity) {
			super.onCollideWithPlayer(sourceentity);
			Entity entity = this;
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				OnCollisionWithPlayerUpdateNameProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.24);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(66);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(6);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6);
		}
	}

	// Made with Blockbench 3.6.5
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class ModelPhase42MiningManni extends EntityModel<Entity> {
		private final ModelRenderer body;
		private final ModelRenderer hat;
		private final ModelRenderer rightarm;
		private final ModelRenderer leftarm;
		private final ModelRenderer rightleg;
		private final ModelRenderer leftleg;
		public ModelPhase42MiningManni() {
			textureWidth = 64;
			textureHeight = 64;
			body = new ModelRenderer(this);
			body.setRotationPoint(-1.0F, 23.6367F, -0.4233F);
			body.setTextureOffset(0, 44).addBox(-4.0F, -13.4957F, -5.1303F, 10.0F, 10.0F, 10.0F, 0.0F, false);
			body.setTextureOffset(0, 0).addBox(3.0F, -13.4957F, 4.8697F, 2.0F, 2.0F, 1.0F, 0.0F, false);
			body.setTextureOffset(30, 0).addBox(1.0F, -8.4957F, 4.8697F, 4.0F, 4.0F, 2.0F, 0.0F, false);
			body.setTextureOffset(42, 0).addBox(-3.0F, -8.4957F, 4.8697F, 3.0F, 4.0F, 2.0F, 0.0F, false);
			hat = new ModelRenderer(this);
			hat.setRotationPoint(0.45F, -10.1867F, -4.1601F);
			body.addChild(hat);
			hat.setTextureOffset(0, 36).addBox(-0.95F, -6.45F, -2.2166F, 3.0F, 3.0F, 1.0F, 0.0F, false);
			hat.setTextureOffset(0, 31).addBox(-0.45F, -5.45F, -1.2166F, 2.0F, 2.0F, 1.0F, 0.0F, false);
			hat.setTextureOffset(0, 32).addBox(-1.95F, -5.45F, -0.2289F, 5.0F, 3.0F, 9.0F, 0.0F, false);
			hat.setTextureOffset(0, 0).addBox(-0.45F, -6.45F, -0.2289F, 2.0F, 1.0F, 9.0F, 0.0F, false);
			rightarm = new ModelRenderer(this);
			rightarm.setRotationPoint(-4.8816F, -11.2976F, 0.3459F);
			body.addChild(rightarm);
			rightarm.setTextureOffset(52, 54).addBox(-2.1184F, -0.6005F, -1.9358F, 3.0F, 7.0F, 3.0F, 0.0F, false);
			rightarm.setTextureOffset(15, 17).addBox(-1.1904F, 5.0383F, -11.0869F, 1.0F, 1.0F, 13.0F, 0.0F, false);
			rightarm.setTextureOffset(0, 15).addBox(-1.1904F, 7.0383F, -9.0629F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			rightarm.setTextureOffset(0, 18).addBox(-1.1904F, 8.0383F, -8.0629F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			rightarm.setTextureOffset(5, 18).addBox(-1.1904F, 3.0383F, -9.0629F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			rightarm.setTextureOffset(5, 15).addBox(-1.1904F, 2.0383F, -8.0629F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			rightarm.setTextureOffset(14, 23).addBox(-1.1904F, 4.0383F, -11.0629F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			rightarm.setTextureOffset(14, 19).addBox(-1.1904F, 6.0383F, -11.0629F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			leftarm = new ModelRenderer(this);
			leftarm.setRotationPoint(7.588F, -11.2976F, 0.3459F);
			body.addChild(leftarm);
			leftarm.setTextureOffset(52, 44).addBox(-1.488F, -0.5919F, -1.9358F, 3.0F, 7.0F, 3.0F, 0.0F, false);
			leftarm.setTextureOffset(0, 17).addBox(-0.488F, 4.4081F, -8.9358F, 1.0F, 1.0F, 11.0F, 0.0F, false);
			leftarm.setTextureOffset(52, 0).addBox(-1.488F, 3.4081F, -11.9358F, 3.0F, 3.0F, 3.0F, 0.0F, false);
			leftarm.setTextureOffset(56, 10).addBox(-0.488F, 2.4081F, -11.9358F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			leftarm.setTextureOffset(56, 6).addBox(1.512F, 4.4081F, -11.9358F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			leftarm.setTextureOffset(56, 18).addBox(-0.488F, 6.4081F, -11.9358F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			leftarm.setTextureOffset(56, 14).addBox(-2.488F, 4.4081F, -11.9358F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			rightleg = new ModelRenderer(this);
			rightleg.setRotationPoint(3.0F, -4.0367F, 0.0177F);
			body.addChild(rightleg);
			rightleg.setTextureOffset(52, 37).addBox(-1.435F, 0.4363F, -1.6077F, 3.0F, 4.0F, 3.0F, 0.0F, false);
			rightleg.setTextureOffset(0, 21).addBox(-1.435F, 3.4363F, -2.6077F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			leftleg = new ModelRenderer(this);
			leftleg.setRotationPoint(-1.0F, -4.0367F, 0.0177F);
			body.addChild(leftleg);
			leftleg.setTextureOffset(52, 30).addBox(-1.6F, 0.4363F, -1.6077F, 3.0F, 4.0F, 3.0F, 0.0F, false);
			leftleg.setTextureOffset(0, 24).addBox(-1.6F, 3.4363F, -2.6077F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			body.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.rightleg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.leftleg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		}
	}
}
