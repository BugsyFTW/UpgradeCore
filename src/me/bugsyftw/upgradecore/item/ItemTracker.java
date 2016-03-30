package me.bugsyftw.upgradecore.item;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import me.bugsyftw.upgradecore.UpgradeCore;

public class ItemTracker {

	private FileConfiguration config;
	private File configFile;
	private Plugin plugin;
	
	public ItemTracker(Plugin plugin, File file) {
		this.plugin = plugin;
		this.configFile = file;
		if (!file.exists()) {
			try {
				file.createNewFile();
				UpgradeCore.logMessage("Creating new Item Tracker file!");
				config = YamlConfiguration.loadConfiguration(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			config = YamlConfiguration.loadConfiguration(file);
			UpgradeCore.logMessage("Loaded ItemTracker File");
		}
	}

	public void add(ItemStack item, Player p, int slot) {
		UpgradedItem ui = new UpgradedItem(item, p.getUniqueId(), 0, slot);
		getConfig().set(ui.getOwner() + ".item", item);
		getConfig().set(ui.getOwner() + ".slot", slot);
	}

	public FileConfiguration getConfig() {
		return config;
	}

	public File getConfigFile() {
		return configFile;
	}

	public Plugin getPlugin() {
		return plugin;
	}
}
