// Made with Blockbench 3.6.5
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelPhase14MiningManni extends EntityModel<Entity> {
	private final ModelRenderer body;
	private final ModelRenderer hat;
	private final ModelRenderer leftarm;
	private final ModelRenderer rightarm;
	private final ModelRenderer rightleg;
	private final ModelRenderer leftleg;

	public ModelPhase14MiningManni() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(-1.0F, 23.6367F, -0.4233F);
		body.setTextureOffset(0, 16).addBox(-3.58F, -9.1871F, -5.7479F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		hat = new ModelRenderer(this);
		hat.setRotationPoint(0.5F, -10.1367F, -3.7434F);
		body.addChild(hat);
		hat.setTextureOffset(0, 0).addBox(-1.0F, -1.5F, -2.8333F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		hat.setTextureOffset(0, 40).addBox(-3.5F, 0.5F, -1.8333F, 7.0F, 1.0F, 6.0F, 0.0F, false);
		hat.setTextureOffset(0, 32).addBox(-2.0F, -1.5F, -1.8333F, 4.0F, 2.0F, 6.0F, 0.0F, false);

		leftarm = new ModelRenderer(this);
		leftarm.setRotationPoint(-5.256F, -7.2375F, -1.6471F);
		body.addChild(leftarm);
		leftarm.setTextureOffset(14, 0).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		leftarm.setTextureOffset(0, 13).addBox(0.0F, -1.0F, -0.9496F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		rightarm = new ModelRenderer(this);
		rightarm.setRotationPoint(6.08F, -7.2375F, -1.6471F);
		body.addChild(rightarm);
		rightarm.setTextureOffset(6, 0).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		rightarm.setTextureOffset(8, 13).addBox(-2.0F, -1.0F, -0.9496F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(1.875F, -1.6367F, -0.5967F);
		body.addChild(rightleg);
		rightleg.setTextureOffset(8, 8).addBox(-0.375F, -1.0F, -2.0504F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(-0.375F, -1.6367F, -0.5967F);
		body.addChild(leftleg);
		leftleg.setTextureOffset(0, 8).addBox(-2.125F, -1.0F, -2.0504F, 2.0F, 3.0F, 2.0F, 0.0F, false);
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