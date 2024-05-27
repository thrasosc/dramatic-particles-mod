package net.pixeldreamstudios.dramatic_particles.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import net.pixeldreamstudios.dramatic_particles.DramaticParticles;

@Mod(DramaticParticles.MOD_ID)
public final class DramaticParticlesForge {
    public DramaticParticlesForge() {
        // Submit our event bus to let Architectury API register our content on the right time.
        EventBuses.registerModEventBus(DramaticParticles.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());

        // Run our common setup.
        DramaticParticles.init();
    }

    @Mod.EventBusSubscriber(modid = DramaticParticles.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            DramaticParticles.initClient();
        }
    }
}
