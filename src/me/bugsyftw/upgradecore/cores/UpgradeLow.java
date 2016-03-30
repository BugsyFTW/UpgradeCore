package me.bugsyftw.upgradecore.cores;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.bugsyftw.upgradecore.UpgradeCore;

public class UpgradeLow implements Upgrade {
	
	private int chance;
	
	public UpgradeLow(int chance) {
		this.chance = chance;
	}
	
	@Override
	public UpgradeType getType() {
		return UpgradeType.LOW;
	}

	@Override
	public String getName() {
		return UpgradeType.LOW.getName();
	}

	@Override
	public ItemStack getItem() {
		ItemStack i = new ItemStack(Material.INK_SACK, 1, (short) 11);
		ItemMeta id = i.getItemMeta();
		id.setDisplayName(ChatColor.YELLOW + "Upgrade Core " + ChatColor.YELLOW + ChatColor.BOLD + "LOW");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY + "An item that upgrades your weapon / armor");
		lore.add(ChatColor.GRAY + "Can only be used on: " + ChatColor.BOLD + "Leather, Stone, Chainmal");
		id.setLore(lore);
		i.setItemMeta(id);
		return i;
	}
	
	@Override
	public ArrayList<Material> getCategories() {
		ArrayList<Material> list = new ArrayList<>();
		list.add(Material.LEATHER_BOOTS);
		list.add(Material.LEATHER_LEGGINGS);
		list.add(Material.LEATHER_CHESTPLATE);
		list.add(Material.LEATHER_HELMET);
		list.add(Material.WOOD_SWORD);
		list.add(Material.CHAINMAIL_BOOTS);
		list.add(Material.CHAINMAIL_LEGGINGS);
		list.add(Material.CHAINMAIL_CHESTPLATE);
		list.add(Material.CHAINMAIL_HELMET);
		list.add(Material.STONE_SWORD);
		return list;
	}
	
	@Override
	public List<String> getDropEntity() {
		return UpgradeCore.getInstance().getManager().getMobLow();
	}
	
	@Override
	public double getChance() {
		return chance;
	}
	
	@Override
	public void setChance(int chance) {
		this.chance = chance;
	}
}
