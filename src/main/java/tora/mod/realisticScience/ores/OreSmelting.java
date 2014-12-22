package tora.mod.realisticScience.ores;
import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import tora.mod.realisticScience.RealisticScienceOre;

public class OreSmelting extends RealisticScienceOre {
	
	public OreSmelting(int id) {
		super(id, Material.rock);
		setUnlocalizedName("oreSmelting");
		setCreativeTab    (CreativeTabs.tabAllSearch);
		setHardness       (1F);
		setResistance     (1F);
		setStepSound      (Block.soundStoneFootstep);
		setTextureName    ("realisticscience:oresmelting");
		
		MinecraftForge.setBlockHarvestLevel(this, "pickaxe", 0);
		GameRegistry.registerBlock(this, "oreSmelting");
	}
	
	@Override
	public void onBlockDestroyedByExplosion(World par1World, int par2, int par3, int par4, Explosion par5Explosion) {
		if (!par1World.isRemote) {
			par1World.createExplosion(null, (double)par2, (double)par3, (double)par4, 2F, true);
			par1World.setBlock(par2, par3, par4, lavaMoving.blockID);
		}
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5) {
		if (!par1World.isRemote) {
			onBlockDestroyedByExplosion(par1World, par2, par3, par4, null);
		}
	}
	
	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		return this.blockID;
	}
	
	@Override
	public int quantityDropped(int meta, int fortune, Random random) {
		return 0;
	}
}
