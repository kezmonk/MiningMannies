// Made with Blockbench 3.6.5
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelPhase42MiningManni extends EntityModel<Entity> {
	private final ModelRenderer body;
	private final ModelRenderer hat;
	private final ModelRenderer rightarm;
	private final ModelRenderer leftarm;
	private final ModelRenderer rightleg;
	private final ModelRenderer leftleg;

	public ModelPhase42MiningManni() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(-1.0F, 23.6367F, -0.4233F);
		body.setTextureOffset(0, 44).addBox(-4.0F, -13.4957F, -5.1303F, 10.0F, 10.0F, 10.0F, 0.0F, false);
		body.setTextureOffset(0, 0).addBox(3.0F, -13.4957F, 4.8697F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(30, 0).addBox(1.0F, -8.4957F, 4.8697F, 4.0F, 4.0F, 2.0F, 0.0F, false);
		body.setTextureOffset(42, 0).addBox(-3.0F, -8.4957F, 4.8697F, 3.0F, 4.0F, 2.0F, 0.0F, false);

		hat = new ModelRenderer(this);
		hat.setRotationPoint(0.45F, -10.1867F, -4.1601F);
		body.addChild(hat);
		hat.setTextureOffset(0, 36).addBox(-0.95F, -6.45F, -2.2166F, 3.0F, 3.0F, 1.0F, 0.0F, false);
		hat.setTextureOffset(0, 31).addBox(-0.45F, -5.45F, -1.2166F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		hat.setTextureOffset(0, 32).addBox(-1.95F, -5.45F, -0.2289F, 5.0F, 3.0F, 9.0F, 0.0F, false);
		hat.setTextureOffset(0, 0).addBox(-0.45F, -6.45F, -0.2289F, 2.0F, 1.0F, 9.0F, 0.0F, false);

		rightarm = new ModelRenderer(this);
		rightarm.setRotationPoint(-4.8816F, -11.2976F, 0.3459F);
		body.addChild(rightarm);
		rightarm.setTextureOffset(52, 54).addBox(-2.1184F, -0.6005F, -1.9358F, 3.0F, 7.0F, 3.0F, 0.0F, false);
		rightarm.setTextureOffset(15, 17).addBox(-1.1904F, 5.0383F, -11.0869F, 1.0F, 1.0F, 13.0F, 0.0F, false);
		rightarm.setTextureOffset(0, 15).addBox(-1.1904F, 7.0383F, -9.0629F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		rightarm.setTextureOffset(0, 18).addBox(-1.1904F, 8.0383F, -8.0629F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		rightarm.setTextureOffset(5, 18).addBox(-1.1904F, 3.0383F, -9.0629F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		rightarm.setTextureOffset(5, 15).addBox(-1.1904F, 2.0383F, -8.0629F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		rightarm.setTextureOffset(14, 23).addBox(-1.1904F, 4.0383F, -11.0629F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		rightarm.setTextureOffset(14, 19).addBox(-1.1904F, 6.0383F, -11.0629F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		leftarm = new ModelRenderer(this);
		leftarm.setRotationPoint(7.588F, -11.2976F, 0.3459F);
		body.addChild(leftarm);
		leftarm.setTextureOffset(52, 44).addBox(-1.488F, -0.5919F, -1.9358F, 3.0F, 7.0F, 3.0F, 0.0F, false);
		leftarm.setTextureOffset(0, 17).addBox(-0.488F, 4.4081F, -8.9358F, 1.0F, 1.0F, 11.0F, 0.0F, false);
		leftarm.setTextureOffset(52, 0).addBox(-1.488F, 3.4081F, -11.9358F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		leftarm.setTextureOffset(56, 10).addBox(-0.488F, 2.4081F, -11.9358F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		leftarm.setTextureOffset(56, 6).addBox(1.512F, 4.4081F, -11.9358F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		leftarm.setTextureOffset(56, 18).addBox(-0.488F, 6.4081F, -11.9358F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		leftarm.setTextureOffset(56, 14).addBox(-2.488F, 4.4081F, -11.9358F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(3.0F, -4.0367F, 0.0177F);
		body.addChild(rightleg);
		rightleg.setTextureOffset(52, 37).addBox(-1.435F, 0.4363F, -1.6077F, 3.0F, 4.0F, 3.0F, 0.0F, false);
		rightleg.setTextureOffset(0, 21).addBox(-1.435F, 3.4363F, -2.6077F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(-1.0F, -4.0367F, 0.0177F);
		body.addChild(leftleg);
		leftleg.setTextureOffset(52, 30).addBox(-1.6F, 0.4363F, -1.6077F, 3.0F, 4.0F, 3.0F, 0.0F, false);
		leftleg.setTextureOffset(0, 24).addBox(-1.6F, 3.4363F, -2.6077F, 3.0F, 1.0F, 1.0F, 0.0F, false);
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