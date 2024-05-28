package net.pixeldreamstudios.dramatic_particles.mixin;

import mod.chloeprime.aaaparticles.api.common.AAALevel;
import mod.chloeprime.aaaparticles.api.common.ParticleEmitterInfo;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.level.portal.PortalShape;
import net.pixeldreamstudios.dramatic_particles.DramaticParticles;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// NOTE: PortalShape regards only the Nether portal
@Mixin(PortalShape.class)
public class PortalShapeMixin {
    private static final ParticleEmitterInfo PORTAL = new ParticleEmitterInfo(new ResourceLocation(DramaticParticles.MOD_ID, "critical_hit"));

    @Shadow @Final
    private Direction.Axis axis;
    @Shadow
    private BlockPos bottomLeft;
    @Shadow
    private int height;
    @Shadow @Final
    private int width;


    @Inject(at = @At("HEAD"), method = "Lnet/minecraft/world/level/portal/PortalShape;createPortalBlocks()V")
    private void renderPortalParticles(CallbackInfo ci) {
        if (DramaticParticles.config.netherPortalEffect) {
            DramaticParticles.LOGGER.info("PORTAL");
            ClientLevel clientLevel = Minecraft.getInstance().level;
            if (clientLevel != null) {
                double centerX;
                double centerY = bottomLeft.getY() + (double) height / 2.0d;
                double centerZ;

                if (axis == Direction.Axis.X) {
                    //TODO fix X center calculation
                    centerX = bottomLeft.getX() + (double) width / 2.0d;
                    centerZ = bottomLeft.getZ();
                    AAALevel.addParticle(clientLevel, false, PORTAL.clone().scale(1.0f).position(centerX, centerY, centerZ));
                } else if (axis == Direction.Axis.Z) {
                    centerX = bottomLeft.getX();
                    centerZ = bottomLeft.getZ() + (double) width / 2.0d;
                    AAALevel.addParticle(clientLevel, false, PORTAL.clone().scale(1.0f).position(centerX, centerY, centerZ));
                }
            }
        }
    }
}

