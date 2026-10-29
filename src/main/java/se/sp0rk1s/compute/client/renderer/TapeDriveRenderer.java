package se.sp0rk1s.compute.client.renderer;


// Minecraft
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;


// Compute
import se.sp0rk1s.compute.blockentities.TapeDriveBlockEntity;
import se.sp0rk1s.compute.blocks.TapeDriveBlock;

public class TapeDriveRenderer implements BlockEntityRenderer<TapeDriveBlockEntity> {
	public static final ModelResourceLocation REEL_MODEL = ModelResourceLocation.standalone(
	  ResourceLocation.fromNamespaceAndPath("compute", "block/tape_drive_reel"));

	public TapeDriveRenderer(BlockEntityRendererProvider.Context context) {
		// grab things you need here, e.g. context.getBlockRenderDispatcher()
	}

	private void renderReel(
	  PoseStack poseStack,
	  VertexConsumer vc,
	  BakedModel model,
	  double cx,
	  double cy,
	  float angle,
	  int light,
	  int overlay
	) {
		poseStack.pushPose();
		poseStack.translate(cx, cy, 0);
		poseStack.mulPose(Axis.ZP.rotationDegrees(angle));
		Minecraft.getInstance().getBlockRenderer().getModelRenderer()
		  .renderModel(poseStack.last(), vc, null, model, 1f, 1f, 1f, light, overlay);
		poseStack.popPose();
	}

	@Override
	public void render(
	  TapeDriveBlockEntity blockEntity,
	  float partialTick,
	  PoseStack poseStack,
	  MultiBufferSource buffer,
	  int packedLight,
	  int packedOverlay
	) {
		BakedModel reel = Minecraft.getInstance().getModelManager().getModel(REEL_MODEL);
		VertexConsumer vc = buffer.getBuffer(RenderType.cutout());
		float angle = Mth.lerp(partialTick, blockEntity.prevAngle, blockEntity.angle);

		// Rotate to match facing
		poseStack.pushPose();
		poseStack.translate(0.5, 0.0, 0.5);
		Direction direction = blockEntity.getBlockState().getValue(TapeDriveBlock.FACING);
		poseStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot() + 180.0f));
		poseStack.translate(-0.5, 0.0, -0.5);

		renderReel(poseStack, vc, reel, 0.3, 1.5, angle, packedLight, packedOverlay);
		renderReel(poseStack, vc, reel, 0.7, 1.5, angle, packedLight, packedOverlay);
		poseStack.popPose();
	}
}