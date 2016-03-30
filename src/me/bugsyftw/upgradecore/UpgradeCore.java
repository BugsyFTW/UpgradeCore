package me.bugsyftw.upgradecore;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.bugsyftw.upgradecore.item.ItemTracker;
import me.bugsyftw.upgradecore.listeners.EntityDeath;
import me.bugsyftw.upgradecore.listeners.UpgradeUse;

public class UpgradeCore extends JavaPlugin {

	public static void logMessage(String msg) { Logger.getLogger("Minecraft").info(msg); }

	private static UpgradeCore instance;
	private ItemTracker tracker;
	private UpgradeManager manager;

	@Override
	public void onLoad() {
		manager = new UpgradeManager(this);
		getConfig().options().header("##########|- UpgradeCore Configuration File - Any Questions on this File go READ Description page! -|##########");
		manager.addDefaults();
		getConfig().options().copyDefaults(true);
		saveConfig();
	}

	@Override
	public void onEnable() {
		instance = this;
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(new EntityDeath(this), this);
		pm.registerEvents(new UpgradeUse(this), this);
		tracker = new ItemTracker(this, new File(getDataFolder(), "itemtracker.yml"));
		manager.loadMobs();
	}

	public UpgradeManager getManager() {
		return manager;
	}

	public ItemTracker getTracker() {
		return tracker;
	}

	public static UpgradeCore getInstance() {
		return instance;
	}
}
