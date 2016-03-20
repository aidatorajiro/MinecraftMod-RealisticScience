package tora.mod.realisticScience.client;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import tora.mod.realisticScience.CommonProxy;
import tora.mod.realisticScience.RealisticScience;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerRenderers() {
		loadModel(RealisticScience.oreSmelting, "oreSmelting");
		loadModel(RealisticScience.pipeBasic, "pipeBasic");
	}
	
	private void loadModel(Block block, String name) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation("realisticscience:" + name, "inventory"));
	}
	
	private void loadModel(Item item, String name) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation("realisticscience:" + name, "inventory"));
	}
}