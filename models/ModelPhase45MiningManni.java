// Made with Blockbench 3.6.5
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelPhase45MiningManni extends EntityModel<Entity> {
	private final ModelRenderer body;
	private final ModelRenderer hat;
	private final ModelRenderer rightarm;
	private final ModelRenderer leftarm;
	private final ModelRenderer rightleg;
	private final ModelRenderer leftleg;

	public ModelPhase45MiningManni() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(-1.0F, 22.6367F, -0.4233F);
		body.setTextureOffset(0, 42).addBox(-4.4F, -14.8453F, -5.6433F, 11.0F, 11.0F, 11.0F, 0.0F, false);
		body.setTextureOffset(0, 36).addBox(3.6F, -14.8453F, 5.3567F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(0, 16).addBox(1.5F, -8.9453F, 5.3567F, 4.0F, 4.0F, 2.0F, 0.0F, false);
		body.setTextureOffset(0, 23).addBox(-3.0F, -8.9453F, 5.3567F, 3.0F, 4.0F, 2.0F, 0.0F, false);

		hat = new ModelRenderer(this);
		hat.setRotationPoint(0.395F, -11.3417F, -4.6184F);
		body.addChild(hat);
		hat.setTextureOffset(56, 0).addBox(-0.895F, -6.6587F, -2.1959F, 3.0F, 3.0F, 1.0F, 0.0F, false);
		hat.setTextureOffset(0, 45).addBox(-0.395F, -5.6587F, -1.1959F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		hat.setTextureOffset(16, 16).addBox(-2.555F, -5.5587F, -0.2095F, 6.0F, 3.0F, 10.0F, 0.0F, false);
		hat.setTextureOffset(0, 4).addBox(0.945F, -6.545F, -0.2095F, 1.0F, 1.0F, 10.0F, 0.0F, false);
		hat.setTextureOffset(12, 2).addBox(-1.055F, -6.545F, -0.2095F, 1.0F, 1.0F, 10.0F, 0.0F, false);

		rightarm = new ModelRenderer(this);
		rightarm.setRotationPoint(-5.4698F, -12.3637F, 0.3382F);
		body.addChild(rightarm);
		rightarm.setTextureOffset(52, 38).addBox(-1.9302F, -0.8242F, -2.0871F, 3.0F, 10.0F, 3.0F, 0.0F, false);
		rightarm.setTextureOffset(0, 16).addBox(-1.1094F, 7.7785F, -12.1533F, 1.0F, 1.0F, 14.0F, 0.0F, false);
		rightarm.setTextureOffset(14, 0).addBox(-1.1094F, 6.7785F, -11.1533F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		rightarm.setTextureOffset(0, 10).addBox(-1.1094F, 5.7785F, -10.1533F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		rightarm.setTextureOffset(14, 4).addBox(-1.1094F, 8.7785F, -11.1533F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		rightarm.setTextureOffset(0, 6).addBox(-1.1094F, 9.7785F, -10.1533F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		rightarm.setTextureOffset(0, 0).addBox(-1.1094F, 10.7785F, -8.1533F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		rightarm.setTextureOffset(0, 3).addBox(-1.1094F, 4.7785F, -8.1533F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		leftarm = new ModelRenderer(this);
		leftarm.setRotationPoint(8.2468F, -12.3637F, 0.3382F);
		body.addChild(leftarm);
		leftarm.setTextureOffset(52, 51).addBox(-1.6468F, -0.8148F, -2.0871F, 3.0F, 10.0F, 3.0F, 0.0F, false);

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(3.5215F, -4.2104F, -1.299F);
		body.addChild(rightleg);
		rightleg.setTextureOffset(52, 20).addBox(-1.5F, -0.25F, -0.45F, 3.0F, 6.0F, 3.0F, 0.0F, false);
		rightleg.setTextureOffset(56, 17).addBox(-1.5F, 4.75F, -1.55F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(-1.06F, -4.2104F, -1.299F);
		body.addChild(leftleg);
		leftleg.setTextureOffset(52, 29).addBox(-1.5F, -0.25F, -0.45F, 3.0F, 6.0F, 3.0F, 0.0F, false);
		leftleg.setTextureOffset(56, 14).addBox(-1.5F, 4.75F, -1.55F, 3.0F, 1.0F, 1.0F, 0.0F, false);
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