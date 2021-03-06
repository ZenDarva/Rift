package org.dimdev.riftloader.launch;

import org.spongepowered.asm.mixin.MixinEnvironment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RiftLoaderClientTweaker extends RiftLoaderTweaker {
    @Override
    public void acceptOptions(List<String> args, File gameDir, File assetsDir, String profile) {
        this.args = new ArrayList<>(args);

        addArg("--version", profile);
        addArg("--assetsDir", assetsDir.getPath());
    }

    @Override
    public String getLaunchTarget() {
        return "net.minecraft.client.main.Main";
    }

    @Override
    protected MixinEnvironment.Side getMixinSide() {
        return MixinEnvironment.Side.CLIENT;
    }
}
