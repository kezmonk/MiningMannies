
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
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
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

import net.mcreator.miningmannies.procedures.UpdateSeekerTickLevel2AndDigProcedure;
import net.mcreator.miningmannies.procedures.SpawnManniSetNBTSProcedure;
import net.mcreator.miningmannies.procedures.RightClickSet4parametersProcedure;
import net.mcreator.miningmannies.procedures.OnCollisionWithPlayerUpdateNameProcedure;
import net.mcreator.miningmannies.itemgroup.MiningManniesItemGroup;
import net.mcreator.miningmannies.gui.SeekerGUIGui;
import net.mcreator.miningmannies.MiningmanniesModElements;

import javax.annotation.Nullable;
import javax.annotation.Nonnull;

import java.util.Map;
import java.util.HashMap;

import io.netty.buffer.Unpooled;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@MiningmanniesModElements.ModElement.Tag
public class OreSeekerLevel2Entity extends MiningmanniesModElements.ModElement {
	public static EntityType entity = null;
	public OreSeekerLevel2Entity(MiningmanniesModElements instance) {
		super(instance, 4);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.CREATURE).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire().size(0.6f, 0.6f))
						.build("ore_seeker_level_2").setRegistryName("ore_seeker_level_2");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -52, -16777012, new Item.Properties().group(MiningManniesItemGroup.tab))
				.setRegistryName("ore_seeker_level_2"));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modelseeker2(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("miningmannies:textures/seeker2.png");
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
			experienceValue = 0;
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
			this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 1));
			this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(3, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(4, new SwimGoal(this));
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
		private final ItemStackHandler inventory = new ItemStackHandler(1) {
			@Override
			public int getSlotLimit(int slot) {
				return 1;
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
						return new StringTextComponent("Ore Seeker Level 2");
					}

					@Override
					public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
						PacketBuffer packetBuffer = new PacketBuffer(Unpooled.buffer());
						packetBuffer.writeBlockPos(new BlockPos(sourceentity));
						packetBuffer.writeByte(0);
						packetBuffer.writeVarInt(CustomEntity.this.getEntityId());
						return new SeekerGUIGui.GuiContainerMod(id, inventory, packetBuffer);
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
				UpdateSeekerTickLevel2AndDigProcedure.executeProcedure($_dependencies);
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
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0.4);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5);
		}
	}

	// Made with Blockbench 3.6.5
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelseeker2 extends EntityModel<Entity> {
		private final ModelRenderer bone;
		private final ModelRenderer backpack;
		private final ModelRenderer glasses;
		private final ModelRenderer arm_right;
		private final ModelRenderer arm_left;
		private final ModelRenderer leg_left;
		private final ModelRenderer leg_right;
		private final ModelRenderer body;
		private final ModelRenderer hat;
		public Modelseeker2() {
			textureWidth = 64;
			textureHeight = 64;
			bone = new ModelRenderer(this);
			bone.setRotationPoint(0.0F, 24.0F, 0.0F);
			backpack = new ModelRenderer(this);
			backpack.setRotationPoint(1.1F, -13.1F, 8.4F);
			bone.addChild(backpack);
			backpack.setTextureOffset(40, 19).addBox(-6.1F, -0.9F, -2.4F, 10.0F, 5.0F, 2.0F, 0.0F, false);
			backpack.setTextureOffset(58, 0).addBox(1.9F, -0.9F, -0.4F, 2.0F, 4.0F, 1.0F, 0.0F, false);
			backpack.setTextureOffset(0, 20).addBox(2.9F, -12.9F, -0.4F, 1.0F, 12.0F, 1.0F, 0.0F, false);
			backpack.setTextureOffset(54, 6).addBox(-2.1F, 0.1F, -0.4F, 3.0F, 4.0F, 2.0F, 0.0F, false);
			backpack.setTextureOffset(14, 14).addBox(-6.1F, 0.1F, -0.4F, 3.0F, 4.0F, 2.0F, 0.0F, false);
			glasses = new ModelRenderer(this);
			glasses.setRotationPoint(-2.5F, -12.5F, -6.5F);
			bone.addChild(glasses);
			glasses.setTextureOffset(0, 42).addBox(-1.5F, 1.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			glasses.setTextureOffset(0, 62).addBox(-1.5F, -2.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			glasses.setTextureOffset(0, 47).addBox(-2.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			glasses.setTextureOffset(0, 53).addBox(1.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			arm_right = new ModelRenderer(this);
			arm_right.setRotationPoint(-7.0F, -13.5F, 0.0F);
			bone.addChild(arm_right);
			arm_right.setTextureOffset(16, 0).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 11.0F, 2.0F, 0.0F, false);
			arm_left = new ModelRenderer(this);
			arm_left.setRotationPoint(7.0F, -13.5F, 0.0F);
			bone.addChild(arm_left);
			arm_left.setTextureOffset(26, 0).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 11.0F, 2.0F, 0.0F, false);
			leg_left = new ModelRenderer(this);
			leg_left.setRotationPoint(3.0F, -3.5F, 0.0F);
			bone.addChild(leg_left);
			leg_left.setTextureOffset(0, 0).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
			leg_right = new ModelRenderer(this);
			leg_right.setRotationPoint(-3.0F, -3.5F, 0.0F);
			bone.addChild(leg_right);
			leg_right.setTextureOffset(8, 0).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone.addChild(body);
			body.setTextureOffset(16, 40).addBox(-6.0F, -16.0F, -6.0F, 12.0F, 12.0F, 12.0F, 0.0F, false);
			hat = new ModelRenderer(this);
			hat.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone.addChild(hat);
			hat.setTextureOffset(28, 27).addBox(-4.0F, -17.0F, -5.0F, 8.0F, 1.0F, 10.0F, 0.0F, false);
			hat.setTextureOffset(34, 0).addBox(-2.0F, -18.0F, -3.0F, 4.0F, 1.0F, 6.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			bone.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.leg_right.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.arm_right.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.leg_left.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.arm_left.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		}
	}
}
