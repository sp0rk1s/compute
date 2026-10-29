package se.sp0rk1s.compute.blockentities;

// Minecraft
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

// Compute
import net.neoforged.neoforge.items.ItemStackHandler;
import se.sp0rk1s.compute.registration.ModBlockEntities;
import se.sp0rk1s.compute.registration.ModItems;

public class TapeDriveBlockEntity extends BlockEntity {
	public static final String ID = "tape_drive";

	public float angle, prevAngle;

	public TapeDriveBlockEntity(BlockPos pos, BlockState state) {
		super(ModBlockEntities.TAPE_DRIVE.get(), pos, state);
	}

	public static void clientTick(Level level, BlockPos pos, BlockState state, TapeDriveBlockEntity blockEntity) {
		blockEntity.prevAngle = blockEntity.angle;
		if (true){//state.getValue(TapeDriveBlock.ON)) {
			blockEntity.angle += 8f;   // degrees per tick, change for speed
		}
	}

	private final ItemStackHandler memoryModules = new ItemStackHandler(1) {
		@Override
		protected int getStackLimit(int slot, ItemStack stack) {
			return 1;
		}

		@Override
		protected void onContentsChanged(int slot) {
			super.onContentsChanged(slot);
		}

		@Override
		public boolean isItemValid(int slot, ItemStack stack) {
			return stack.is(ModItems.TAPE);
		}
	};
}
