package net.pixeldreamstudios.dramatic_particles.fabric.client;

import net.fabricmc.api.ClientModInitializer;
import net.pixeldreamstudios.dramatic_particles.DramaticParticles;

public final class DramaticParticlesFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        DramaticParticles.initClient();
    }
}
