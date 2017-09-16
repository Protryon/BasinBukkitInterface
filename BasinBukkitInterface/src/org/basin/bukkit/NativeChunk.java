package org.basin.bukkit;

import org.basin.bukkit.block.NativeBlock;
import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Entity;

public class NativeChunk implements Chunk, ChunkSnapshot {
	
	private final NativeWorld world;
	private final int x;
	private final int z;
	
	public NativeChunk(NativeWorld world, int x, int z) {
		this.world = world;
		this.x = x;
		this.z = z;
	}
	
	@Override
	public int getX() {
		return x;
	}
	
	@Override
	public int getZ() {
		return z;
	}
	
	@Override
	public World getWorld() {
		return world;
	}
	
	public native short getNativeBlock(int x, int y, int z);
	
	@Override
	public NativeBlock getBlock(int x, int y, int z) {
		return new NativeBlock(x, y, z, getNativeBlock(x, y, z));
	}
	
	// basin chunks are safe, and snapshots are safe, but some plugins might use these to save data over many ticks --- unsafe
	
	@Override
	public ChunkSnapshot getChunkSnapshot() {
		return this;
	}
	
	@Override
	public ChunkSnapshot getChunkSnapshot(boolean includeMaxblocky, boolean includeBiome, boolean includeBiomeTempRain) {
		return this;
	}
	
	@Override
	public Entity[] getEntities() {
		return world.getNearbyEntities(new Location(world, x * 16 + 8, 128, z * 16 + 8), 8, 128, 8).toArray(new Entity[0]);
	}
	
	@Override
	public native BlockState[] getTileEntities();
	
	@Override
	public native boolean isLoaded();
	
	@Override
	public native boolean load(boolean generate);
	
	@Override
	public boolean load() {
		return load(true);
	}
	
	@Override
	public native boolean unload(boolean save, boolean safe);
	
	@Override
	public boolean unload(boolean save) {
		return unload(save, true);
	}
	
	@Override
	public boolean unload() {
		return unload(true);
	}
	
	@Override
	public native boolean isSlimeChunk();
	
	@Override
	public String getWorldName() {
		return getWorld().getName();
	}
	
	@Override
	public native int getBlockTypeId(int x, int y, int z);
	
	@Override
	public int getBlockData(int x, int y, int z) {
		return getNativeBlock(x, y, z) & 0x0f;
	}
	
	@Override
	public native int getBlockSkyLight(int x, int y, int z);
	
	@Override
	public native int getBlockEmittedLight(int x, int y, int z);
	
	@Override
	public native int getHighestBlockYAt(int x, int z);
	
	public native short getNativeBiome(int x, int z);
	
	@Override
	public Biome getBiome(int x, int z) {
		return Biome.values()[getNativeBiome(x, z)];
	}
	
	@Override
	public double getRawBiomeTemperature(int x, int z) {
		throw new BasinUnsupportedException("No notion of biome temperature");
	}
	
	@Override
	public double getRawBiomeRainfall(int x, int z) {
		throw new BasinUnsupportedException("No notion of biome rainfall");
	}
	
	@Override
	public long getCaptureFullTime() {
		throw new BasinUnsupportedException("No notion of snapshot capture time -- is live");
	}
	
	@Override
	public native boolean isSectionEmpty(int sy);
	
}
