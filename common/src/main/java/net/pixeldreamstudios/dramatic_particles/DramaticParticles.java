package net.pixeldreamstudios.dramatic_particles;

import dev.architectury.registry.ReloadListenerRegistry;
import mod.chloeprime.aaaparticles.client.loader.EffekAssetLoader;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class DramaticParticles {
    public static final String MOD_ID = "dramatic_particles";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static void init() {
        // Write common init code here.
    }

    public static void initClient() {
        ReloadListenerRegistry.register(PackType.CLIENT_RESOURCES, new EffekAssetLoader(), new ResourceLocation(MOD_ID, "effeks"));
    }
}
