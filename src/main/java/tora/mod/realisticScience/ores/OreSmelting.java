package tora.mod.realisticScience.ores;
import java.util.Random;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import tora.mod.realisticScience.RealisticScienceOre;

public class OreSmelting extends RealisticScienceOre {
	
	public OreSmelting() {
		
		super(Material.rock);
		setUnlocalizedName("oreSmelting");
		setCreativeTab    (CreativeTabs.tabAllSearch);
		setHardness       (1F);
		setResistance     (1F);
		setStepSound      (Block.soundTypeStone);
		setHarvestLevel("pickaxe", 0);
		
		GameRegistry.registerBlock(this, "oreSmelting");
	}
	
	@Override
	public void onBlockDestroyedByExplosion(World par1World, BlockPos par2Pos, Explosion par3Explosion) {
		if (!par1World.isRemote) {
			par1World.createExplosion(null, (double)par2Pos.getX(), (double)par2Pos.getY(), (double)par2Pos.getZ(), 2F, true);
			par1World.setBlockState(par2Pos, Blocks.flowing_lava.getDefaultState());
		}
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World par1World, BlockPos par2Pos, IBlockState par3State) {
		if (!par1World.isRemote) {
			onBlockDestroyedByExplosion(par1World, par2Pos, null);
		}
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(this);
	}
	
	@Override
	public int quantityDropped(Random random) {
		return 0;
	}
}
