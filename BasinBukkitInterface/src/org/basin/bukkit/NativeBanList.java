package org.basin.bukkit;

import java.util.Date;
import java.util.Set;
import org.bukkit.BanEntry;
import org.bukkit.BanList;

public class NativeBanList implements BanList {
	
	@Override
	public native BanEntry getBanEntry(String target);
	
	@Override
	public native BanEntry addBan(String target, String reason, Date expires, String source);
	
	@Override
	public native Set<BanEntry> getBanEntries();
	
	@Override
	public native boolean isBanned(String target);
	
	@Override
	public native void pardon(String target);
	
}
