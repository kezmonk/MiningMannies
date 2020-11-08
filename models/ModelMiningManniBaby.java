// Made with Blockbench 3.6.5
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelMiningManniBaby extends EntityModel<Entity> {
	private final ModelRenderer body;
	private final ModelRenderer hat;
	private final ModelRenderer leftarm;
	private final ModelRenderer rightarm;
	private final ModelRenderer rightleg;
	private final ModelRenderer leftleg;

	public ModelMiningManniBaby() {
		textureWidth = 16;
		textureHeight = 16;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 23.6367F, -0.4233F);
		body.setTextureOffset(0, 10).addBox(-1.5F, -3.3167F, -3.6167F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		hat = new ModelRenderer(this);
		hat.setRotationPoint(0.0F, 0.3633F, -1.5767F);
		body.addChild(hat);
		hat.setTextureOffset(0, 6).addBox(-0.5F, -4.66F, -2.2F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		leftarm = new ModelRenderer(this);
		leftarm.setRotationPoint(-2.0F, -2.9967F, -1.7567F);
		body.addChild(leftarm);
		leftarm.setTextureOffset(0, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		rightarm = new ModelRenderer(this);
		rightarm.setRotationPoint(2.0F, -2.9967F, -1.7567F);
		body.addChild(rightarm);
		rightarm.setTextureOffset(0, 3).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(0.75F, -0.6367F, -1.7567F);
		body.addChild(rightleg);
		rightleg.setTextureOffset(8, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(-0.75F, -0.6367F, -1.7567F);
		body.addChild(leftleg);
		leftleg.setTextureOffset(12, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.rightleg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.leftleg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
	}
}