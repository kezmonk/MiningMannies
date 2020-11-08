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