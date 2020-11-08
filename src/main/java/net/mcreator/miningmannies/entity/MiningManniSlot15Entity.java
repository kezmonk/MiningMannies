
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
import net.minecraft.entity.monster.MonsterEntity;
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
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.miningmannies.procedures.UpdateTickLevel15finalProcedure;
import net.mcreator.miningmannies.procedures.SpawnManniSetNBTSProcedure;
import net.mcreator.miningmannies.procedures.RightClickSet4parametersProcedure;
import net.mcreator.miningmannies.procedures.OnCollisionWithPlayerUpdateNameProcedure;
import net.mcreator.miningmannies.itemgroup.MiningManniesItemGroup;
import net.mcreator.miningmannies.gui.HarvestGUIOneSlotGui;
import net.mcreator.miningmannies.MiningmanniesModElements;

import javax.annotation.Nullable;
import javax.annotation.Nonnull;

import java.util.Map;
import java.util.HashMap;

import io.netty.buffer.Unpooled;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@MiningmanniesModElements.ModElement.Tag
public class MiningManniSlot15Entity extends MiningmanniesModElements.ModElement {
	public static EntityType entity = null;
	public MiningManniSlot15Entity(MiningmanniesModElements instance) {
		super(instance, 10);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire().size(0.6f, 1.8f))
						.build("mining_manni_slot_15").setRegistryName("mining_manni_slot_15");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -7756940, -33024, new Item.Properties().group(MiningManniesItemGroup.tab))
				.setRegistryName("mining_manni_slot_15"));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new ModelPhase15MiningManni(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("miningmannies:textures/phase15miningmanni.png");
				}
			};
		});
	}
	public static class CustomEntity extends MonsterEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 1;
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
					new TemptGoal(this, 1, Ingredient.fromItems(new ItemStack(Items.WOODEN_PICKAXE, (int) (1)).getItem()), false));
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
		private final ItemStackHandler inventory = new ItemStackHandler(2) {
			@Override
			public int getSlotLimit(int slot) {
				return 64;
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
						return new StringTextComponent("Mining Manni Phase 1.5");
					}

					@Override
					public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
						PacketBuffer packetBuffer = new PacketBuffer(Unpooled.buffer());
						packetBuffer.writeBlockPos(new BlockPos(sourceentity));
						packetBuffer.writeByte(0);
						packetBuffer.writeVarInt(CustomEntity.this.getEntityId());
						return new HarvestGUIOneSlotGui.GuiContainerMod(id, inventory, packetBuffer);
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
				UpdateTickLevel15finalProcedure.executeProcedure($_dependencies);
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
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.32);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
		}
	}

	// Made with Blockbench 3.6.5
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class ModelPhase15MiningManni extends EntityModel<Entity> {
		private final ModelRenderer body;
		private final ModelRenderer hat;
		private final ModelRenderer rightarm;
		private final ModelRenderer leftarm;
		private final ModelRenderer rightleg;
		private final ModelRenderer leftleg;
		public ModelPhase15MiningManni() {
			textureWidth = 64;
			textureHeight = 64;
			body = new ModelRenderer(this);
			body.setRotationPoint(-1.0F, 23.6367F, -0.4233F);
			body.setTextureOffset(0, 44).addBox(-4.6908F, -11.5902F, -5.3524F, 10.0F, 10.0F, 10.0F, 0.0F, false);
			hat = new ModelRenderer(this);
			hat.setRotationPoint(0.5F, -10.1367F, -3.7434F);
			body.addChild(hat);
			hat.setTextureOffset(55, 45).addBox(-2.0F, -5.7533F, -1.3333F, 3.0F, 3.0F, 1.0F, 0.0F, false);
			hat.setTextureOffset(30, 34).addBox(-3.75F, -2.5F, -0.2466F, 7.0F, 1.0F, 8.0F, 0.0F, false);
			hat.setTextureOffset(0, 32).addBox(-2.0F, -5.5F, -0.2466F, 3.0F, 3.0F, 8.0F, 0.0F, false);
			rightarm = new ModelRenderer(this);
			rightarm.setRotationPoint(-5.256F, -10.2375F, 0.3529F);
			body.addChild(rightarm);
			setRotationAngle(rightarm, 0.0F, 0.0F, 0.1745F);
			rightarm.setTextureOffset(41, 55).addBox(-2.744F, 0.6938F, -1.7983F, 3.0F, 6.0F, 3.0F, 0.0F, false);
			rightarm.setTextureOffset(41, 45).addBox(-1.7592F, -0.1498F, -1.7983F, 3.0F, 1.0F, 3.0F, 0.0F, false);
			rightarm.setTextureOffset(0, 20).addBox(-1.744F, 5.0F, -11.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
			rightarm.setTextureOffset(6, 3).addBox(-1.744F, 4.0F, -10.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			rightarm.setTextureOffset(0, 11).addBox(-1.744F, 3.0F, -9.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			rightarm.setTextureOffset(0, 0).addBox(-1.744F, 2.0F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			rightarm.setTextureOffset(6, 0).addBox(-1.744F, 6.0F, -10.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			rightarm.setTextureOffset(0, 6).addBox(-1.744F, 6.0F, -9.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			rightarm.setTextureOffset(6, 8).addBox(-1.744F, 8.0F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			leftarm = new ModelRenderer(this);
			leftarm.setRotationPoint(6.08F, -10.2375F, 0.3529F);
			body.addChild(leftarm);
			setRotationAngle(leftarm, 0.0F, 0.0F, -0.1309F);
			leftarm.setTextureOffset(52, 23).addBox(-0.4192F, 0.6938F, -1.7983F, 3.0F, 6.0F, 3.0F, 0.0F, false);
			leftarm.setTextureOffset(52, 18).addBox(-1.6792F, 0.0238F, -1.7348F, 3.0F, 1.0F, 3.0F, 0.0F, false);
			rightleg = new ModelRenderer(this);
			rightleg.setRotationPoint(2.65F, -3.6367F, 0.0546F);
			body.addChild(rightleg);
			rightleg.setTextureOffset(52, 9).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, 0.0F, false);
			leftleg = new ModelRenderer(this);
			leftleg.setRotationPoint(-2.35F, -3.6367F, 0.0546F);
			body.addChild(leftleg);
			leftleg.setTextureOffset(52, 2).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, 0.0F, false);
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
