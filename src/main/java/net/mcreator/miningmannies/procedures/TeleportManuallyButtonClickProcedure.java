package net.mcreator.miningmannies.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.block.Blocks;

import net.mcreator.miningmannies.MiningmanniesModElements;

import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

@MiningmanniesModElements.ModElement.Tag
public class TeleportManuallyButtonClickProcedure extends MiningmanniesModElements.ModElement {
	public TeleportManuallyButtonClickProcedure(MiningmanniesModElements instance) {
		super(instance, 55);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure TeleportManuallyButtonClick!");
			return;
		}
		if (dependencies.get("guistate") == null) {
			System.err.println("Failed to load dependency guistate for procedure TeleportManuallyButtonClick!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure TeleportManuallyButtonClick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap guistate = (HashMap) dependencies.get("guistate");
		IWorld world = (IWorld) dependencies.get("world");
		double XposManual = 0;
		double YposManual = 0;
		double ZposManual = 0;
		if (((!(((new Object() {
			public String getText() {
				TextFieldWidget textField = (TextFieldWidget) guistate.get("text:x_pos");
				if (textField != null) {
					return textField.getText();
				}
				return "";
			}
		}.getText())).equals(""))) && ((!(((new Object() {
			public String getText() {
				TextFieldWidget textField = (TextFieldWidget) guistate.get("text:y_pos");
				if (textField != null) {
					return textField.getText();
				}
				return "";
			}
		}.getText())).equals(""))) && (!(((new Object() {
			public String getText() {
				TextFieldWidget textField = (TextFieldWidget) guistate.get("text:z_pos");
				if (textField != null) {
					return textField.getText();
				}
				return "";
			}
		}.getText())).equals("")))))) {
			XposManual = (double) new Object() {
				int convert(String s) {
					try {
						return Integer.parseInt(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((new Object() {
				public String getText() {
					TextFieldWidget textField = (TextFieldWidget) guistate.get("text:x_pos");
					if (textField != null) {
						return textField.getText();
					}
					return "";
				}
			}.getText()));
			YposManual = (double) new Object() {
				int convert(String s) {
					try {
						return Integer.parseInt(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((new Object() {
				public String getText() {
					TextFieldWidget textField = (TextFieldWidget) guistate.get("text:y_pos");
					if (textField != null) {
						return textField.getText();
					}
					return "";
				}
			}.getText()));
			ZposManual = (double) new Object() {
				int convert(String s) {
					try {
						return Integer.parseInt(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((new Object() {
				public String getText() {
					TextFieldWidget textField = (TextFieldWidget) guistate.get("text:z_pos");
					if (textField != null) {
						return textField.getText();
					}
					return "";
				}
			}.getText()));
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
						(("Attempting teleporting to: ") + "" + (" X ") + "" + ((new java.text.DecimalFormat("###").format(Math.round((XposManual)))))
								+ "" + (" Y ") + "" + ((new java.text.DecimalFormat("###").format(Math.round((YposManual))))) + "" + (" Z ") + ""
								+ ((new java.text.DecimalFormat("###").format(Math.round((ZposManual))))))),
						(false));
			}
			if ((((world.getBlockState(
					new BlockPos((int) (Math.round((XposManual)) + 0.5), (int) Math.round((YposManual)), (int) (Math.round((ZposManual)) + 0.5))))
							.getBlock() == Blocks.AIR.getDefaultState().getBlock())
					&& ((world.getBlockState(new BlockPos((int) (Math.round((XposManual)) + 0.5), (int) (Math.round((ZposManual)) + 1),
							(int) (Math.round((ZposManual)) + 0.5)))).getBlock() == Blocks.AIR.getDefaultState().getBlock()))) {
				{
					Entity _ent = entity;
					_ent.setPositionAndUpdate((Math.round((XposManual)) + 0.5), Math.round((YposManual)), (Math.round((ZposManual)) + 0.5));
					if (_ent instanceof ServerPlayerEntity) {
						((ServerPlayerEntity) _ent).connection.setPlayerLocation((Math.round((XposManual)) + 0.5), Math.round((YposManual)),
								(Math.round((ZposManual)) + 0.5), _ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
					}
				}
				entity.rotationYaw = (float) ((entity.rotationYaw));
				entity.rotationPitch = (float) ((entity.rotationPitch));
			} else {
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Teleportation failed, not enough air space"), (false));
				}
			}
		}
	}
}
