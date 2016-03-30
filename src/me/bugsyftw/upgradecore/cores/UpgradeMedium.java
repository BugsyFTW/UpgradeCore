package me.bugsyftw.upgradecore.cores;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.bugsyftw.upgradecore.UpgradeCore;

public class UpgradeMedium implements Upgrade {
	
	private int chance;
	
	public UpgradeMedium(int chance) {
		this.chance = chance;
	}
	
	@Override
	public UpgradeType getType() {
		return UpgradeType.MEDIUM;
	}

	@Override
	public String getName() {
		return UpgradeType.MEDIUM.getName();
	}

	@Override
	public ItemStack getItem() {
		ItemStack i = new ItemStack(Material.INK_SACK, 1, (short) 14);
		ItemMeta id = i.getItemMeta();
		id.setDisplayName(ChatColor.GOLD + "Upgrade Core " + ChatColor.GOLD + ChatColor.BOLD + "MEDIUM");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY + "An item that upgrades your weapon / armor");
		lore.add(ChatColor.GRAY + "Can only be used on: " + ChatColor.BOLD + "Iron, Gold");
		id.setLore(lore);
		i.setItemMeta(id);
		return i;
	}
	
	@Override
	public ArrayList<Material> getCategories() {
		ArrayList<Material> list = new ArrayList<>();
		list.add(Material.IRON_BOOTS);
		list.add(Material.IRON_LEGGINGS);
		list.add(Material.IRON_CHESTPLATE);
		list.add(Material.IRON_HELMET);
		list.add(Material.IRON_SWORD);
		list.add(Material.GOLD_BOOTS);
		list.add(Material.GOLD_LEGGINGS);
		list.add(Material.GOLD_CHESTPLATE);
		list.add(Material.GOLD_HELMET);
		list.add(Material.GOLD_SWORD);
		return list;
	}
	
	@Override
	public double getChance() {
		return chance;
	}
	
	@Override
	public void setChance(int chance) {
		this.chance = chance;
	}
	
	@Override
	public List<String> getDropEntity() {
		return UpgradeCore.getInstance().getManager().getMobMedium();
	}
}
