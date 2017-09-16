package org.basin.bukkit;

import java.util.Date;
import org.bukkit.BanEntry;

public final class NativeBanEntry implements BanEntry {
	
	private final String target;
	private final long created;
	private final String source;
	private final long expires;
	private final String reason;
	
	public NativeBanEntry(String target, long created, String source, long expires, String reason) {
		this.target = target;
		this.created = created;
		this.source = source;
		this.expires = expires;
		this.reason = reason;
	}
	
	@Override
	public String getTarget() {
		return target;
	}
	
	@Override
	public Date getCreated() {
		return new Date(created);
	}
	
	@Override
	public void setCreated(Date created) {
		throw new BasinUnsupportedException("NativeBanEntry.setCreated -- created is final");
	}
	
	@Override
	public String getSource() {
		return source;
	}
	
	@Override
	public void setSource(String source) {
		throw new BasinUnsupportedException("NativeBanEntry.setCreated -- source is final");
	}
	
	@Override
	public Date getExpiration() {
		return new Date(expires);
	}
	
	@Override
	public void setExpiration(Date expiration) {
		throw new BasinUnsupportedException("NativeBanEntry.setCreated -- expires is final");
	}
	
	@Override
	public String getReason() {
		return reason;
	}
	
	@Override
	public void setReason(String reason) {
		throw new BasinUnsupportedException("NativeBanEntry.setCreated -- reason is final");
	}
	
	@Override
	public void save() {
		throw new BasinUnsupportedException("NativeBanEntry.setCreated -- NativeBanEntry is final");
	}
	
}
