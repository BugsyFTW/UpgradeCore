package me.bugsyftw.upgradecore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.bukkit.entity.EntityType;

import me.bugsyftw.upgradecore.cores.Upgrade;
import me.bugsyftw.upgradecore.cores.UpgradeHigh;
import me.bugsyftw.upgradecore.cores.UpgradeLow;
import me.bugsyftw.upgradecore.cores.UpgradeMedium;
import me.bugsyftw.upgradecore.cores.UpgradeType;

public class UpgradeManager {

	private UpgradeCore core;
	public List<String> mobs_low = new ArrayList<String>();
	public List<String> mobs_medium = new ArrayList<String>();
	public List<String> mobs_high = new ArrayList<String>();

	public UpgradeManager(UpgradeCore plugin) {
		this.core = plugin;
	}

	public void loadMobs() {
		mobs_low.addAll(getCore().getConfig().getStringList("Entity.Low"));
		mobs_medium.addAll(getCore().getConfig().getStringList("Entity.Medium"));
		mobs_high.addAll(getCore().getConfig().getStringList("Entity.High"));
	}

	public void addDefaults() {
		List<String> low = new ArrayList<String>();
		List<String> med = new ArrayList<String>();
		List<String> hig = new ArrayList<String>();
		low.add(EntityType.ZOMBIE.toString());
		low.add(EntityType.SPIDER.toString());
		low.add(EntityType.CREEPER.toString());
		hig.add(EntityType.MAGMA_CUBE.toString());
		hig.add(EntityType.GHAST.toString());
		hig.add(EntityType.BLAZE.toString());
		med.add(EntityType.WITHER.toString());
		med.add(EntityType.WITCH.toString());
		med.add(EntityType.ENDER_DRAGON.toString());
		getCore().getConfig().addDefault("Entity.Low", low);
		getCore().getConfig().addDefault("Entity.Medium", med);
		getCore().getConfig().addDefault("Entity.High", hig);
		getCore().getConfig().addDefault("EntityLow.Chance", 50);
		getCore().getConfig().addDefault("EntityMedium.Chance", 30);
		getCore().getConfig().addDefault("EntityHigh.Chance", 8);
	}

	public Upgrade getUpgrade(EntityType type) {
		Map<String, Upgrade> up = new HashMap<String, Upgrade>();
		for (String l : getMobLow()) {
			Upgrade upgrade = new UpgradeLow(getChance(UpgradeType.LOW));
			up.put(l, upgrade);
		}
		for (String m : getMobMedium()) {
			Upgrade upgrade = new UpgradeMedium(getChance(UpgradeType.MEDIUM));
			up.put(m, upgrade);
		}
		for (String h : getMobHigh()) {
			Upgrade upgrade = new UpgradeHigh(getChance(UpgradeType.HIGH));
			up.put(h, upgrade);
		}
		for (Entry<String, Upgrade> all : up.entrySet()) {
			if (type.toString().equals(all.getKey())) {
				return all.getValue();
			}
		}
		return null;
	}
	
	public static int getChance(UpgradeType type) {
		switch (type) {
		case LOW:
			return UpgradeCore.getInstance().getConfig().getInt("EntityLow.Chance");
		case MEDIUM:
			return UpgradeCore.getInstance().getConfig().getInt("EntityMedium.Chance");
		case HIGH:
			return UpgradeCore.getInstance().getConfig().getInt("EntityHigh.Chance");
		default:
			return 0;
		}
	}
	
	public List<String> getMobHigh() {
		return mobs_high;
	}

	public List<String> getMobMedium() {
		return mobs_medium;
	}

	public List<String> getMobLow() {
		return mobs_low;
	}

	public UpgradeCore getCore() {
		return core;
	}
}
