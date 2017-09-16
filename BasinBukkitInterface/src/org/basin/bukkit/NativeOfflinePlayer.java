package org.basin.bukkit;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.bukkit.BanList.Type;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class NativeOfflinePlayer implements OfflinePlayer {
	private UUID uuid;
	private String username;
	private NativeServer server;
	
	public NativeOfflinePlayer(NativeServer server, UUID uuid, String username) {
		this.uuid = uuid;
		this.username = username;
		this.server = server;
	}
	
	@Override
	public boolean isOp() {
		return false; // no notion
	}
	
	@Override
	public void setOp(boolean value) {
		throw new BasinUnsupportedException("no notion of op");
	}
	
	@Override
	public Map<String, Object> serialize() {
		Map<String, Object> map = new HashMap<String, Object>();
		// TODO
		return map;
	}
	
	@Override
	public native boolean isOnline();
	
	@Override
	public String getName() {
		return username;
	}
	
	@Override
	public UUID getUniqueId() {
		return uuid;
	}
	
	@Override
	public boolean isBanned() {
		return server.getBanList(Type.NAME).isBanned(username);
	}
	
	@Override
	public native boolean isWhitelisted();
	
	@Override
	public native void setWhitelisted(boolean value);
	
	@Override
	public Player getPlayer() {
		return null;
	}
	
	@Override
	public native long getFirstPlayed();
	
	@Override
	public native long getLastPlayed();
	
	@Override
	public boolean hasPlayedBefore() {
		return getFirstPlayed() > 0;
	}
	
	@Override
	public native Location getBedSpawnLocation();
	
}
