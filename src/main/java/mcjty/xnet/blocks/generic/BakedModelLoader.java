package mcjty.xnet.blocks.generic;

import mcjty.xnet.XNet;
import mcjty.xnet.blocks.cables.ConnectorBlock;
import mcjty.xnet.blocks.cables.NetCableBlock;
import mcjty.xnet.blocks.facade.FacadeModel;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.IModel;

public class BakedModelLoader implements ICustomModelLoader {

    public static final GenericCableModel GENERIC_MODEL = new GenericCableModel();
    public static final FacadeModel FACADE_MODEL = new FacadeModel();


    @Override
    public boolean accepts(ResourceLocation modelLocation) {
        if (!modelLocation.getResourceDomain().equals(XNet.MODID)) {
            return false;
        }
        return ConnectorBlock.CONNECTOR.equals(modelLocation.getResourcePath()) ||
                NetCableBlock.NETCABLE.equals(modelLocation.getResourcePath()) ||
                "facade".equals(modelLocation.getResourcePath());
    }

    @Override
    public IModel loadModel(ResourceLocation modelLocation) throws Exception {
        if ("facade".equals(modelLocation.getResourcePath())) {
            return FACADE_MODEL;
        } else {
            return GENERIC_MODEL;
        }
    }

    @Override
    public void onResourceManagerReload(IResourceManager resourceManager) {

    }
}
