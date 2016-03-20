package tora.mod.realisticScience;

import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class RealisticScienceTileentity extends TileEntity{
	
	private NBTTagCompound compound = new NBTTagCompound();
	
	@Override
	public Packet getDescriptionPacket() {
        NBTTagCompound nbtTagCompound = new NBTTagCompound();
        this.writeToNBT(nbtTagCompound);
        return new S35PacketUpdateTileEntity(this.getPos(), 1, nbtTagCompound);
	}
	
	@Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        this.readFromNBT(pkt.getNbtCompound());
    }
	
	@Override
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);      
        this.compound = par1NBTTagCompound.getCompoundTag("compound");
    }
    
    @Override
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setTag("compound", this.compound);
    }
    
    public String getString(String key)
    {
       return this.compound.getString(key);
    }
    
    public void setString(String key, String value)
    {
       this.compound.setString(key, value);
    }
}