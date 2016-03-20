package tora.mod.realisticScience;

import tora.mod.realisticScience.ores.OreSmelting;
import tora.mod.realisticScience.machines.PipeBasic;

import tora.mod.realisticScience.tileentities.TileentityPipeBasic;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid="RealisticScience", name="RealisticScience", version="0.1.1", acceptableRemoteVersions="*")
public class RealisticScience {
	// The instance of your mod that Forge uses.
	@Instance(value = "RealisticScience")
	public static RealisticScience instance;
	
	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide="tora.mod.realisticScience.client.ClientProxy", serverSide="tora.mod.realisticScience.CommonProxy")
	public static CommonProxy proxy;
	
	// The blocks
	public static OreSmelting oreSmelting;
	public static PipeBasic pipeBasic;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		//====================================//
		//          Ores - Overworld          //
		//====================================//
		
		oreSmelting = new OreSmelting();
		
		//====================================//
		//          Machines - Pipes          //
		//====================================//
		
		//----- Pipe -----
		pipeBasic = new PipeBasic();
		
		//----- PiCharm -----
		
		//----- Pipe on Rails -----
		
		//----- NetBeams -----
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		// regist tileentities
		GameRegistry.registerTileEntity(RealisticScienceTileentity.class, "realisticScienceTileentity");
		GameRegistry.registerTileEntity(TileentityPipeBasic.class, "tileentityPipeBasic");
		
		// regist renderers(client only)
		proxy.registerRenderers();
	}
        
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
}