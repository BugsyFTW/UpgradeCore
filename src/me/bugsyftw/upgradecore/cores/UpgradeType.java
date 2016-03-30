package me.bugsyftw.upgradecore.cores;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.inventory.ItemStack;

import me.bugsyftw.upgradecore.UpgradeManager;

public enum UpgradeType {

	LOW("Low"), MEDIUM("Medium"), HIGH("High");

	private String name;

	private UpgradeType(String name) {
		this.name = name;
	}

	public Upgrade getUpgrade() {
		switch (this) {
		case LOW:
			return new UpgradeLow(UpgradeManager.getChance(this));
		case MEDIUM:
			return new UpgradeMedium(UpgradeManager.getChance(this));
		case HIGH:
			return new UpgradeHigh(UpgradeManager.getChance(this));
		default:
			return null;
		}
	}

	public static Upgrade getUpgrade(String name) {
		switch (name) {
		case "Low":
			return new UpgradeLow(UpgradeManager.getChance(UpgradeType.LOW));
		case "Medium":
			return new UpgradeMedium(UpgradeManager.getChance(UpgradeType.MEDIUM));
		case "High":
			return new UpgradeHigh(UpgradeManager.getChance(UpgradeType.HIGH));
		default:
			return null;
		}
	}

	public static ArrayList<ItemStack> getItemList() {
		ArrayList<ItemStack> items = new ArrayList<ItemStack>();
		for (UpgradeType u : values()) {
			items.add(u.getUpgrade().getItem());
		}
		return items;
	}

	public static HashMap<ItemStack, Upgrade> getItemMap() {
		HashMap<ItemStack, Upgrade> map = new HashMap<ItemStack, Upgrade>();
		for (UpgradeType u : values()) {
			map.put(u.getUpgrade().getItem(), u.getUpgrade());
		}
		return map;
	}

	public String getName() {
		return name;
	}
}
