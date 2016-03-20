package tora.mod.realisticScience.ores;
import java.util.Random;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import tora.mod.realisticScience.RealisticScienceOre;

public class OreSmelting extends RealisticScienceOre {
	
	public OreSmelting() {
		
		super(Material.rock);
		setUnlocalizedName("oreSmelting");
		setCreativeTab    (CreativeTabs.tabAllSearch);
		setHardness       (1F);
		setResistance     (1F);
		setStepSound      (Block.soundTypeStone);
		setHarvestLevel   ("pickaxe", 0);
		setLightLevel     (20.0F);
		
		GameRegistry.registerBlock(this, "oreSmelting");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	/* spawn flame and smoke particles
	 * offset table
	 * [X] [Y] [Z]
	 * 0   0~1 0~1  if r1 = 0
	 * 0~1 0   0~1     r1 = 1
	 * 0~1 0~1 0       r1 = 2
	 * 1   0~1 0~1     r1 = 3
	 * 0~1 1   0~1     r1 = 4
	 * 0~1 0~1 1       r1 = 5
	 */
	public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		int r1 = rand.nextInt(6); //  Integer between 0 and 5
		double r2 = rand.nextDouble(); // Double between 0 and 1
		double r3 = rand.nextDouble(); // Double between 0 and 1
		
		double offx = 0;
		double offy = 0;
		double offz = 0;
		
		if (r1 == 0) {
			offx = 0;
			offy = r2;
			offz = r3;
		} else if (r1 == 1) {
			offx = r2;
			offy = 0;
			offz = r3;
		} else if (r1 == 2) {
			offx = r2;
			offy = r3;
			offz = 0;
		} else if (r1 == 3) {
			offx = 1;
			offy = r2;
			offz = r3;
		} else if (r1 == 4) {
			offx = r2;
			offy = 1;
			offz = r3;
		} else if (r1 == 5) {
			offx = r2;
			offy = r3;
			offz = 1;
		}
		
		worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, (double)pos.getX()+offx, (double)pos.getY()+offy, (double)pos.getZ()+offz, 0D, 0D, 0D);
        worldIn.spawnParticle(EnumParticleTypes.FLAME       , (double)pos.getX()+offx, (double)pos.getY()+offy, (double)pos.getZ()+offz, 0D, 0D, 0D);
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
