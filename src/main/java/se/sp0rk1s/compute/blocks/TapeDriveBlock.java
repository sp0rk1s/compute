package se.sp0rk1s.compute.blocks;

// Minecraft
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

// Compute
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import se.sp0rk1s.compute.blockentities.TapeDriveBlockEntity;
import se.sp0rk1s.compute.registration.ModBlockEntities;

// Java
import javax.annotation.Nullable;

public class TapeDriveBlock extends BaseEntityBlock {
	public static final String ID = "tape_drive";
	public static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 16, 16);
	public static final MapCodec<TapeDriveBlock> CODEC = simpleCodec(TapeDriveBlock::new);

	public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	public static final BooleanProperty LOADED = BooleanProperty.create("loaded");
	public static final BooleanProperty ON = BooleanProperty.create("on");

	public TapeDriveBlock(BlockBehaviour.Properties properties) {
		super(properties
		  .destroyTime(4.0f)
		  .explosionResistance(3.0f)
		  .sound(SoundType.COPPER)
		);

		registerDefaultState(stateDefinition.any()
		  .setValue(HALF, DoubleBlockHalf.LOWER)
		  .setValue(FACING, Direction.NORTH)
		  .setValue(LOADED, false)
		  .setValue(ON, false)
		);
	}

	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
		return level.isClientSide
		  ? createTickerHelper(type, ModBlockEntities.TAPE_DRIVE.get(), TapeDriveBlockEntity::clientTick)
		  : null;
	}

	@Override
	protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(HALF, FACING, LOADED, ON);
	}

	@Override
	public BlockState playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
		if (!level.isClientSide) {
			BlockPos other = state.getValue(HALF) == DoubleBlockHalf.LOWER ? pos.above() : pos.below();
			BlockState otherState = level.getBlockState(other);
			if (otherState.is(this)) {
				level.setBlock(other, Blocks.AIR.defaultBlockState(), 35);
			}
		}
		return super.playerWillDestroy(level, pos, state, player);
	}

	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext ctx) {
		BlockPos pos = ctx.getClickedPos();
		Level level = ctx.getLevel();
		if (pos.getY() >= level.getMaxBuildHeight() -1) { return null; }
		if (!level.getBlockState(pos.above()).canBeReplaced(ctx)) { return null; }
		return defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite());
	}

	@Override
	public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
		level.setBlock(pos.above(), state.setValue(HALF, DoubleBlockHalf.UPPER), 3);
	}

	@Override
	protected MapCodec<? extends BaseEntityBlock> codec() {
		return CODEC;
	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return state.getValue(HALF) == DoubleBlockHalf.LOWER
		  ? new TapeDriveBlockEntity(pos, state)
		  : null;
	}

	@Override
	protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
		super.onRemove(state, level, pos, newState, movedByPiston);
	}

	@Override
	protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
		return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
	}

	@Override
	protected RenderShape getRenderShape(BlockState state) {
		return RenderShape.MODEL;
	}
}