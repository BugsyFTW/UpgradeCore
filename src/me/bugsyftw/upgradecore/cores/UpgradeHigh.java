package me.bugsyftw.upgradecore.cores;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.bugsyftw.upgradecore.UpgradeCore;

public class UpgradeHigh implements Upgrade {
	
	private int chance;
	
	public UpgradeHigh(int chance) {
		this.chance = chance;
	}
	
	@Override
	public UpgradeType getType() {
		return UpgradeType.HIGH;
	}

	@Override
	public String getName() {
		return UpgradeType.HIGH.getName();
	}

	@Override
	public ItemStack getItem() {
		ItemStack i = new ItemStack(Material.INK_SACK, 1, (short) 1);
		ItemMeta id = i.getItemMeta();
		id.setDisplayName(ChatColor.RED + "Upgrade Core " + ChatColor.RED + ChatColor.BOLD + "HIGH");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY + "An item that upgrades your weapon / armor");
		lore.add(ChatColor.GRAY + "Can only be used on: " + ChatColor.BOLD + "Diamond");
		id.setLore(lore);
		i.setItemMeta(id);
		return i;
	}
	
	@Override
	public ArrayList<Material> getCategories() {
		ArrayList<Material> list = new ArrayList<>();
		list.add(Material.DIAMOND_BOOTS);
		list.add(Material.DIAMOND_LEGGINGS);
		list.add(Material.DIAMOND_CHESTPLATE);
		list.add(Material.DIAMOND_HELMET);
		list.add(Material.DIAMOND_SWORD);
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
		return UpgradeCore.getInstance().getManager().getMobHigh();
	}
}
