package me.bugsyftw.upgradecore.item;

import java.util.UUID;

import org.bukkit.inventory.ItemStack;

public class UpgradedItem{
	
	private ItemStack item;
	private String owner;
	private int level;
	private int item_slot;
	
	public UpgradedItem(ItemStack item, UUID owner, int level, int slot) {
		this.item = item;
		this.owner = owner.toString();
		this.level = level;
		this.item_slot = slot;
	}
	
	public ItemStack getItem() {
		return item;
	}
	public void setItem(ItemStack item) {
		this.item = item;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public String getOwner() {
		return owner;
	}
	
	public int getPosition() {
		return item_slot;
	}
	
	public void setPosition(int slot) {
		this.item_slot = slot;
	}
}
