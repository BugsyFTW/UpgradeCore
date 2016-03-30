package me.bugsyftw.upgradecore.listeners;

import java.util.HashMap;
import java.util.Map.Entry;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.bugsyftw.upgradecore.cores.Upgrade;
import me.bugsyftw.upgradecore.cores.UpgradeType;

public class UpgradeUse implements Listener {

	private Plugin plugin;
	private HashMap<String, Upgrade> in_upgrade = new HashMap<String, Upgrade>();

	public UpgradeUse(Plugin plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if (e.getWhoClicked() instanceof Player) {
			final Player p = (Player) e.getWhoClicked();
			if (e.getClick().equals(ClickType.SHIFT_LEFT)) {
				for (Entry<ItemStack, Upgrade> items : UpgradeType.getItemMap().entrySet()) {
					if (e.getCurrentItem().equals(items.getKey())) {
						Upgrade upgrade = items.getValue();
						in_upgrade.put(p.getUniqueId().toString(), upgrade);
						p.sendMessage(ChatColor.YELLOW + "You're now using an '" + upgrade.getItem().getItemMeta().getDisplayName()+ "'");
						new BukkitRunnable() {
							@Override
							public void run() {
								if (in_upgrade.containsKey(p.getUniqueId().toString())) {
									in_upgrade.remove(p.getUniqueId().toString());
									p.sendMessage(ChatColor.RED + "Upgrade Cancelled");
									cancel();
								}
							}
						}.runTaskLater(getPlugin(), 200L);
						break;
					}
				}
				return;
			} else if (e.getClick().equals(ClickType.LEFT) || e.getClick().equals(ClickType.RIGHT)) {
				if (getInUpgrade().containsKey(p.getUniqueId().toString())) {
					Upgrade upgrade = getInUpgrade().get(p.getUniqueId().toString());
					if (upgrade.getCategories().contains(e.getCurrentItem().getType())) {
						p.getInventory().remove(upgrade.getItem());
						p.sendMessage("You just upgraded!");
						//TODO Upgrade Item
						getInUpgrade().remove(p.getUniqueId().toString());
						return;
					}
				}
			}
		}
	}

	public Plugin getPlugin() {
		return plugin;
	}

	public HashMap<String, Upgrade> getInUpgrade() {
		return in_upgrade;
	}
}
