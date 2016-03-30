package me.bugsyftw.upgradecore.listeners;

import java.util.Random;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import me.bugsyftw.upgradecore.UpgradeCore;
import me.bugsyftw.upgradecore.cores.Upgrade;

public class EntityDeath implements Listener {

	private UpgradeCore core;

	public EntityDeath(UpgradeCore core) {
		this.core = core;
	}

	@EventHandler
	public void onEntityDeath(EntityDeathEvent e) {
		EntityType type = e.getEntity().getType();
		if (e.getEntity().getKiller() instanceof Player) {
			Upgrade core = getCore().getManager().getUpgrade(type);
			String[] chance = new String[100];
			for (int i = 0; i < core.getChance(); i++) {
				chance[getRandom()] = core.getName();
			}
			if (chance[getRandom()] == core.getName()) {
				e.getDrops().add(core.getItem());
			}
		}
	}

	public int getRandom() {
		int r = new Random().nextInt(100);
		return r;
	}

	public UpgradeCore getCore() {
		return core;
	}

	public UpgradeCore getPlugin() {
		return core;
	}
}
