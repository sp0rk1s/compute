package se.sp0rk1s.compute.BlockEntityWithoutLevelRenderer;

// Minecraft
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;

// Compute
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.neoforged.neoforge.client.model.data.ModelData;
import se.sp0rk1s.compute.blockentities.TapeDriveBlockEntity;
import se.sp0rk1s.compute.registration.ModBlocks;

public class TapeDriveBlockEntityWithoutLevelRenderer extends BlockEntityWithoutLevelRenderer {
	private final BlockEntityRenderDispatcher dispatcher;
	private final BlockRenderDispatcher blockRenderer;
	private TapeDriveBlockEntity dummyBlockEntity;

	public TapeDriveBlockEntityWithoutLevelRenderer(BlockEntityRenderDispatcher dispatcher, EntityModelSet modelSet) {
		super(dispatcher, modelSet);
		this.dispatcher = dispatcher;
		this.blockRenderer = Minecraft.getInstance().getBlockRenderer();
	}

	@Override
	public void renderByItem(
	  ItemStack stack,
	  ItemDisplayContext displayContext,
	  PoseStack poseStack,
	  MultiBufferSource buffer,
	  int packedLight,
	  int packedOverlay
	) {
		poseStack.pushPose();
		poseStack.translate(0.5F, 0.0F, 0.5F);

		// Lower half
		BlockState lowerState = ModBlocks.TAPE_DRIVE.get().defaultBlockState()
		  .setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER); // (Use your actual property name if custom)

		poseStack.pushPose();
		poseStack.translate(-0.5F, 0.0F, -0.5F);
		this.blockRenderer.renderSingleBlock(lowerState, poseStack, buffer, packedLight, packedOverlay, ModelData.EMPTY, null);
		poseStack.popPose();

		// Upper half
		BlockState upperState = ModBlocks.TAPE_DRIVE.get().defaultBlockState()
		  .setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER);

		poseStack.pushPose();
		poseStack.translate(-0.5F, 1.0F, -0.5F);
		this.blockRenderer.renderSingleBlock(upperState, poseStack, buffer, packedLight, packedOverlay, ModelData.EMPTY, null);
		poseStack.popPose();
		poseStack.popPose();
	}
}
