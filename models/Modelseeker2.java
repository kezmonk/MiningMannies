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
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bone.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.leg_right.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.arm_right.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.leg_left.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.arm_left.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
	}
}