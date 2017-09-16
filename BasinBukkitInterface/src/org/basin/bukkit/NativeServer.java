package org.basin.bukkit;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Logger;
import org.bukkit.BanList;
import org.bukkit.BanList.Type;
import org.bukkit.GameMode;
import org.bukkit.NamespacedKey;
import org.bukkit.OfflinePlayer;
import org.bukkit.Server;
import org.bukkit.UnsafeValues;
import org.bukkit.Warning.WarningState;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.advancement.Advancement;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.generator.ChunkGenerator.ChunkData;
import org.bukkit.help.HelpMap;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFactory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.Recipe;
import org.bukkit.map.MapView;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.messaging.Messenger;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.util.CachedServerIcon;

public class NativeServer implements Server {
	
	public NativeServer(int worldCount) {
		worlds = new NativeWorld[worldCount];
		for (int i = 0; i < worldCount; i++) {
			worlds[i] = new NativeWorld();
		}
	}
	
	private NativeWorld[] worlds;
	
	private NativeBanList banList = new NativeBanList();
	
	@Override
	public native void sendPluginMessage(Plugin source, String channel, byte[] message);
	
	@Override
	public native Set<String> getListeningPluginChannels();
	
	@Override
	public String getName() {
		return "Basin";
	}
	
	@Override
	public native String getVersion();
	
	@Override
	public String getBukkitVersion() {
		return "SpigotBasinInterface"; // number left out because it'll never be updated
	}
	
	public native Player[] getNativeOnlinePlayers();
	
	@Override
	public Collection<? extends Player> getOnlinePlayers() {
		return Arrays.asList(getNativeOnlinePlayers());
	}
	
	@Override
	public native int getMaxPlayers();
	
	@Override
	public native int getPort();
	
	@Override
	public native int getViewDistance();
	
	@Override
	public native String getIp();
	
	@Override
	public native String getServerName();
	
	@Override
	public native String getServerId();
	
	@Override
	public String getWorldType() {
		return "DEFAULT"; // no notion of
	}
	
	@Override
	public native boolean getGenerateStructures();
	
	@Override
	public native boolean getAllowEnd();
	
	@Override
	public native boolean getAllowNether();
	
	@Override
	public native boolean hasWhitelist();
	
	@Override
	public native void setWhitelist(boolean value);
	
	public native Player[] getNativeWhitelistedPlayers();
	
	@Override
	public Set<OfflinePlayer> getWhitelistedPlayers() {
		return new HashSet<OfflinePlayer>(Arrays.asList(getNativeWhitelistedPlayers()));
	}
	
	@Override
	public native void reloadWhitelist();
	
	@Override
	public native int broadcastMessage(String message);
	
	@Override
	public native String getUpdateFolder();
	
	@Override
	public File getUpdateFolderFile() {
		return new File(getUpdateFolder());
	}
	
	@Override
	public native long getConnectionThrottle();
	
	@Override
	public native int getTicksPerAnimalSpawns();
	
	@Override
	public native int getTicksPerMonsterSpawns();
	
	@Override
	public native Player getPlayer(String name);
	
	@Override
	public native Player getPlayerExact(String name);
	
	public native Player[] nativeMatchPlayer(String name);
	
	@Override
	public List<Player> matchPlayer(String name) {
		return Arrays.asList(nativeMatchPlayer(name));
	}
	
	public native Player getPlayerNative(long uuid1, long uuid2);
	
	@Override
	public Player getPlayer(UUID id) {
		return getPlayerNative(id.getLeastSignificantBits(), id.getMostSignificantBits());
	}
	
	@Override
	public PluginManager getPluginManager() {
		return null; // TODO PluginManager
	}
	
	@Override
	public BukkitScheduler getScheduler() {
		return null; // TODO: BukkitScheduler
	}
	
	@Override
	public ServicesManager getServicesManager() {
		return null; // TODO: ServicesManager
	}
	
	@Override
	public List<World> getWorlds() {
		return Arrays.asList(worlds);
	}
	
	@Override
	public World createWorld(WorldCreator creator) {
		throw new BasinUnsupportedException("no notion of creating a new world");
	}
	
	@Override
	public boolean unloadWorld(String name, boolean save) {
		throw new BasinUnsupportedException("no notion of unloading a world");
	}
	
	@Override
	public boolean unloadWorld(World world, boolean save) {
		throw new BasinUnsupportedException("no notion of unloading a world");
	}
	
	@Override
	public World getWorld(String name) {
		for (NativeWorld world : worlds) {
			if (world.getName() == name) return world;
		}
		return null;
	}
	
	@Override
	public World getWorld(UUID uid) {
		for (NativeWorld world : worlds) {
			if (world.getUID().equals(uid)) return world;
		}
		return null;
	}
	
	@Override
	public MapView getMap(short id) {
		throw new BasinUnsupportedException("no notion of a map");
	}
	
	@Override
	public MapView createMap(World world) {
		throw new BasinUnsupportedException("no notion of a map");
	}
	
	@Override
	public void reload() {
		throw new BasinUnsupportedException("no notion of a reload");
	}
	
	@Override
	public void reloadData() {
		throw new BasinUnsupportedException("no notion of a reloadData");
	}
	
	@Override
	public Logger getLogger() {
		return Logger.global;
	}
	
	@Override
	public PluginCommand getPluginCommand(String name) {
		// TODO;
		throw new BasinUnsupportedException("unimplemented Server.getPluginCommand");
	}
	
	@Override
	public void savePlayers() {
		throw new BasinUnsupportedException("no notion of savePlayers");
	}
	
	// TODO: structure commands
	@Override
	public boolean dispatchCommand(CommandSender sender, String commandLine) throws CommandException {
		throw new BasinUnsupportedException("unimplemented Server.dispatchCommand");
	}
	
	@Override
	public native boolean addRecipe(Recipe recipe);
	
	public native Recipe[] getRecipesForNative(ItemStack result);
	
	@Override
	public List<Recipe> getRecipesFor(ItemStack result) {
		return Arrays.asList(getRecipesForNative(result));
	}
	
	@Override
	public Iterator<Recipe> recipeIterator() {
		return getRecipesFor(null).iterator();
	}
	
	@Override
	public native void clearRecipes();
	
	@Override
	public native void resetRecipes();
	
	@Override
	public Map<String, String[]> getCommandAliases() {
		return null; // no notion of
	}
	
	@Override
	public native int getSpawnRadius();
	
	@Override
	public native void setSpawnRadius(int value);
	
	@Override
	public native boolean getOnlineMode();
	
	@Override
	public native boolean getAllowFlight();
	
	@Override
	public native boolean isHardcore();
	
	@Override
	public native void shutdown();
	
	@Override
	public native int broadcast(String message, String permission);
	
	@Override
	public native OfflinePlayer getOfflinePlayer(String name);
	
	public native OfflinePlayer getOfflinePlayerNative(long uuid1, long uuid2);
	
	@Override
	public OfflinePlayer getOfflinePlayer(UUID id) {
		return getOfflinePlayerNative(id.getMostSignificantBits(), id.getLeastSignificantBits());
	}
	
	@Override
	public Set<String> getIPBans() {
		throw new BasinUnsupportedException("unimplemented Server.getIPBans");
	}
	
	@Override
	public void banIP(String address) {
		throw new BasinUnsupportedException("unimplemented Server.banIP");
	}
	
	@Override
	public void unbanIP(String address) {
		throw new BasinUnsupportedException("unimplemented Server.unbanIP");
	}
	
	@Override
	public Set<OfflinePlayer> getBannedPlayers() {
		throw new BasinUnsupportedException("unimplemented Server.getBannedPlayers");
	}
	
	@Override
	public BanList getBanList(Type type) {
		return banList;
	}
	
	@Override
	public Set<OfflinePlayer> getOperators() {
		return new HashSet<OfflinePlayer>();
	}
	
	public native int getNativeDefaultGameMode();
	
	@Override
	public GameMode getDefaultGameMode() {
		return GameMode.getByValue(getNativeDefaultGameMode());
	}
	
	public native void setNativeDefaultGameMode(int id);
	
	@Override
	public void setDefaultGameMode(GameMode mode) {
		setNativeDefaultGameMode(mode.getValue());
	}
	
	@Override
	public ConsoleCommandSender getConsoleSender() {
		throw new BasinUnsupportedException("unimplemented Server.getConsoleSender");
	}
	
	public native String getWorldContainerPath();
	
	@Override
	public File getWorldContainer() {
		return new File(getWorldContainerPath());
	}
	
	@Override
	public native OfflinePlayer[] getOfflinePlayers();
	
	@Override
	public Messenger getMessenger() {
		throw new BasinUnsupportedException("unimplemented Server.getMessenger");
	}
	
	@Override
	public HelpMap getHelpMap() {
		throw new BasinUnsupportedException("unimplemented Server.getHelpMap");
	}
	
	@Override
	public Inventory createInventory(InventoryHolder owner, InventoryType type) {
		throw new BasinUnsupportedException("unimplemented Server.createInventory");
	}
	
	@Override
	public Inventory createInventory(InventoryHolder owner, InventoryType type, String title) {
		throw new BasinUnsupportedException("unimplemented Server.createInventory");
	}
	
	@Override
	public Inventory createInventory(InventoryHolder owner, int size) throws IllegalArgumentException {
		throw new BasinUnsupportedException("unimplemented Server.createInventory");
	}
	
	@Override
	public Inventory createInventory(InventoryHolder owner, int size, String title) throws IllegalArgumentException {
		throw new BasinUnsupportedException("unimplemented Server.createInventory");
	}
	
	@Override
	public Merchant createMerchant(String title) {
		throw new BasinUnsupportedException("unimplemented Server.createMerchant");
	}
	
	@Override
	public native int getMonsterSpawnLimit();
	
	@Override
	public native int getAnimalSpawnLimit();
	
	@Override
	public native int getWaterAnimalSpawnLimit();
	
	@Override
	public native int getAmbientSpawnLimit();
	
	private final Thread initThread = Thread.currentThread();
	
	@Override
	public boolean isPrimaryThread() {
		return Thread.currentThread() == initThread;
	}
	
	@Override
	public native String getMotd();
	
	@Override
	public native String getShutdownMessage();
	
	@Override
	public WarningState getWarningState() {
		return WarningState.DEFAULT;
	}
	
	@Override
	public ItemFactory getItemFactory() {
		throw new BasinUnsupportedException("unimplemented Server.getItemFactory");
	}
	
	@Override
	public ScoreboardManager getScoreboardManager() {
		throw new BasinUnsupportedException("unimplemented Server.ScoreboardManager");
	}
	
	@Override
	public CachedServerIcon getServerIcon() {
		throw new BasinUnsupportedException("unimplemented Server.CachedServerIcon");
	}
	
	@Override
	public CachedServerIcon loadServerIcon(File file) throws IllegalArgumentException, Exception {
		throw new BasinUnsupportedException("unimplemented Server.loadServerIcon");
	}
	
	@Override
	public CachedServerIcon loadServerIcon(BufferedImage image) throws IllegalArgumentException, Exception {
		throw new BasinUnsupportedException("unimplemented Server.loadServerIcon");
	}
	
	@Override
	public native void setIdleTimeout(int threshold);
	
	@Override
	public native int getIdleTimeout();
	
	@Override
	public ChunkData createChunkData(World world) {
		throw new BasinUnsupportedException("unimplemented Server.createChunkData");
	}
	
	@Override
	public BossBar createBossBar(String title, BarColor color, BarStyle style, BarFlag... flags) {
		throw new BasinUnsupportedException("unimplemented Server.createBossBar");
	}
	
	@Override
	public native Entity getEntity(UUID uuid);
	
	@Override
	public Advancement getAdvancement(NamespacedKey key) {
		return null;
	}
	
	@Override
	public Iterator<Advancement> advancementIterator() {
		return null;
	}
	
	@Override
	public UnsafeValues getUnsafe() {
		throw new BasinUnsupportedException("unimplemented Server.createBossBar");
	}
	
}
