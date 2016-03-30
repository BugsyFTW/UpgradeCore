package me.bugsyftw.upgradecore.cores;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public interface Upgrade {
	
	public UpgradeType getType();
	
	public String getName();
	
	public ItemStack getItem();
	
	public ArrayList<Material> getCategories();
	
	public List<String> getDropEntity();
	
	public double getChance();
	
	public void setChance(int chance);
}
