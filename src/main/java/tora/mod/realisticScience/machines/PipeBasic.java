package tora.mod.realisticScience.machines;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import tora.mod.realisticScience.RealisticScienceMachine;
import tora.mod.realisticScience.RealisticScienceTileentity;
import tora.mod.realisticScience.tileentities.TileentityPipeBasic;

public class PipeBasic extends RealisticScienceMachine {
	public PipeBasic(int id) {
		super(id, Material.rock);
		setUnlocalizedName("pipeBasic");
		setCreativeTab    (CreativeTabs.tabAllSearch);
		setHardness       (1F);
		setResistance     (1F);
		setStepSound      (Block.soundStoneFootstep);
		setTextureName    ("realisticscience:pipebasic");
		
		MinecraftForge.setBlockHarvestLevel(this, "pickaxe", 0);
		GameRegistry.registerBlock(this, "pipeBasic");
	}
	
	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		return true;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileentityPipeBasic();
	}
}
