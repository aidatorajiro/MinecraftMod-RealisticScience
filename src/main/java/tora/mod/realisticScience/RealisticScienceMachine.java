package tora.mod.realisticScience;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;

public abstract class RealisticScienceMachine extends BlockContainer {
	//Define the constructor.
	public RealisticScienceMachine (int id, Material material) {
		super(id, material);
	}
}