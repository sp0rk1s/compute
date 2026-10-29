package se.sp0rk1s.compute.client;

// Minecraft
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;

// Neoforge
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.ModelEvent;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;

// Compute
import se.sp0rk1s.compute.BlockEntityWithoutLevelRenderer.TapeDriveBlockEntityWithoutLevelRenderer;
import se.sp0rk1s.compute.client.renderer.TapeDriveRenderer;
import se.sp0rk1s.compute.registration.ModBlockEntities;
import se.sp0rk1s.compute.registration.ModItems;

@EventBusSubscriber(modid = "compute", value = Dist.CLIENT)
public class ClientEvents {
	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(ModBlockEntities.TAPE_DRIVE.get(), TapeDriveRenderer::new);
	}
	@SubscribeEvent
	public static void registerModels(ModelEvent.RegisterAdditional event) {
		event.register(TapeDriveRenderer.REEL_MODEL);
	}
	@SubscribeEvent
	public static void registerClientExtensions(RegisterClientExtensionsEvent event) {
		event.registerItem(new IClientItemExtensions() {
			private TapeDriveBlockEntityWithoutLevelRenderer renderer;

			@Override
			public BlockEntityWithoutLevelRenderer getCustomRenderer() {
				if (renderer == null) {
					Minecraft minecraft = Minecraft.getInstance();
					renderer = new TapeDriveBlockEntityWithoutLevelRenderer(minecraft.getBlockEntityRenderDispatcher(), minecraft.getEntityModels());
				}
				return renderer;
			}
		}, ModItems.TAPE_DRIVE_ITEM.get());
	}
}