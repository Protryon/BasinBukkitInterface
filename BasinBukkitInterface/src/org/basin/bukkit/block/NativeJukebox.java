package org.basin.bukkit.block;

import org.bukkit.Material;
import org.bukkit.block.Jukebox;

public class NativeJukebox extends NativeBlockState implements Jukebox {
	
	@Override
	public Material getPlaying() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void setPlaying(Material record) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean isPlaying() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean eject() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
