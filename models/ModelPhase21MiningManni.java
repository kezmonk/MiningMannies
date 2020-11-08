// Made with Blockbench 3.6.5
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelPhase21MiningManni extends EntityModel<Entity> {
	private final ModelRenderer body;
	private final ModelRenderer hat;
	private final ModelRenderer rightarm;
	private final ModelRenderer leftarm;
	private final ModelRenderer rightleg;
	private final ModelRenderer leftleg;

	public ModelPhase21MiningManni() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(-1.0F, 23.6367F, -0.4233F);
		body.setTextureOffset(0, 44).addBox(-4.0F, -13.4957F, -5.1303F, 10.0F, 10.0F, 10.0F, 0.0F, false);

		hat = new ModelRenderer(this);
		hat.setRotationPoint(0.45F, -10.1867F, -4.1601F);
		body.addChild(hat);
		hat.setTextureOffset(55, 45).addBox(-0.95F, -6.45F, -1.4166F, 3.0F, 3.0F, 1.0F, 0.0F, false);
		hat.setTextureOffset(0, 32).addBox(-1.95F, -5.45F, -0.2289F, 5.0F, 3.0F, 9.0F, 0.0F, false);
		hat.setTextureOffset(15, 0).addBox(-0.45F, -6.45F, -0.2289F, 2.0F, 1.0F, 9.0F, 0.0F, false);

		rightarm = new ModelRenderer(this);
		rightarm.setRotationPoint(-4.8816F, -11.2976F, 0.3459F);
		body.addChild(rightarm);
		setRotationAngle(rightarm, 0.0F, 0.0F, 0.1745F);
		rightarm.setTextureOffset(41, 55).addBox(-2.6184F, 0.3995F, -1.9358F, 3.0F, 7.0F, 3.0F, 0.0F, false);
		rightarm.setTextureOffset(41, 45).addBox(-1.5351F, -0.0284F, -1.9358F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		rightarm.setTextureOffset(0, 20).addBox(-1.1904F, 6.0383F, -11.0869F, 1.0F, 1.0F, 10.0F, 0.0F, false);
		rightarm.setTextureOffset(6, 3).addBox(-1.1904F, 5.0263F, -10.0749F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		rightarm.setTextureOffset(0, 11).addBox(-1.1904F, 4.0263F, -9.0629F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		rightarm.setTextureOffset(0, 0).addBox(-1.1904F, 3.0023F, -8.0509F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		rightarm.setTextureOffset(6, 0).addBox(-1.1904F, 7.0503F, -10.0749F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		rightarm.setTextureOffset(0, 6).addBox(-1.1904F, 7.0623F, -9.0629F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		rightarm.setTextureOffset(6, 8).addBox(-1.1904F, 9.0743F, -8.0509F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		leftarm = new ModelRenderer(this);
		leftarm.setRotationPoint(6.588F, -11.2976F, 0.3459F);
		body.addChild(leftarm);
		setRotationAngle(leftarm, 0.0F, 0.0F, -0.1309F);
		leftarm.setTextureOffset(52, 23).addBox(-0.0611F, 0.3995F, -1.9358F, 3.0F, 7.0F, 3.0F, 0.0F, false);
		leftarm.setTextureOffset(52, 18).addBox(-1.4471F, 0.1625F, -1.9358F, 3.0F, 1.0F, 3.0F, 0.0F, false);

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(2.815F, -4.0367F, 0.0177F);
		body.addChild(rightleg);
		rightleg.setTextureOffset(52, 9).addBox(-1.25F, 0.4363F, -1.6077F, 3.0F, 4.0F, 3.0F, 0.0F, false);

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(-2.685F, -4.0367F, 0.0177F);
		body.addChild(leftleg);
		leftleg.setTextureOffset(52, 2).addBox(0.085F, 0.4363F, -1.6077F, 3.0F, 4.0F, 3.0F, 0.0F, false);
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