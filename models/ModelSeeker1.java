// Made with Blockbench 3.6.5
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelSeeker1 extends EntityModel<Entity> {
	private final ModelRenderer Body;
	private final ModelRenderer left_Arm;
	private final ModelRenderer right_Arm;
	private final ModelRenderer left_Leg;
	private final ModelRenderer right_Leg;

	public ModelSeeker1() {
		textureWidth = 32;
		textureHeight = 32;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 19.0F, 0.0F);
		Body.setTextureOffset(0, 16).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		Body.setTextureOffset(16, 0).addBox(-3.0F, -3.0F, -5.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(24, 0).addBox(1.0F, -3.0F, -5.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		left_Arm = new ModelRenderer(this);
		left_Arm.setRotationPoint(-5.0F, 18.0F, 0.0F);
		left_Arm.setTextureOffset(0, 6).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		right_Arm = new ModelRenderer(this);
		right_Arm.setRotationPoint(4.0F, 18.0F, 0.0F);
		right_Arm.setTextureOffset(0, 0).addBox(0.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		left_Leg = new ModelRenderer(this);
		left_Leg.setRotationPoint(-2.0F, 23.0F, 0.0F);
		left_Leg.setTextureOffset(16, 4).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		right_Leg = new ModelRenderer(this);
		right_Leg.setRotationPoint(2.0F, 23.0F, 0.0F);
		right_Leg.setTextureOffset(24, 4).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		left_Arm.render(matrixStack, buffer, packedLight, packedOverlay);
		right_Arm.render(matrixStack, buffer, packedLight, packedOverlay);
		left_Leg.render(matrixStack, buffer, packedLight, packedOverlay);
		right_Leg.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.right_Arm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.left_Arm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.right_Leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.left_Leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}