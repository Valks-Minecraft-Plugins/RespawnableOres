package com.respawnableores.listeners;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.respawnableores.RespawnableOres;

public class OreListener implements Listener {
	@EventHandler
	private void blockBreak(BlockBreakEvent e) {
		Block b = e.getBlock();
		Material type = b.getType();
		Location loc = b.getLocation();
		
		FileConfiguration config = RespawnableOres.plugin.getOresConfig();
		
		double x1 = config.getDouble("ores.regions.r1.x");
		double y1 = config.getDouble("ores.regions.r1.y");
		double z1 = config.getDouble("ores.regions.r1.z");
		
		double x2 = config.getDouble("ores.regions.r2.x");
		double y2 = config.getDouble("ores.regions.r2.y");
		double z2 = config.getDouble("ores.regions.r2.z");
		
		
		if (e.getPlayer().getGameMode() == GameMode.SURVIVAL) {
			if (inRegion(loc, x1, y1, z1, x2, y2, z2)) {
				for (String oreName : config.getStringList("ores.types")) {
					Material oreMaterial = Material.valueOf(oreName.toUpperCase());
					
					if (type == oreMaterial) {
						new BukkitRunnable() {
							@Override
							public void run() {
								b.setType(Material.valueOf(config.getString("ores." + oreName.toLowerCase() + ".respawnblock")));
							}
						}.runTaskLater(RespawnableOres.plugin, 5);
						
						new BukkitRunnable() {
							@Override
							public void run() {
								b.setType(type);
							}
						}.runTaskLater(RespawnableOres.plugin, 20 * config.getInt("ores." + oreName.toLowerCase() + ".respawntime"));
						break;
					}
				}
			}
		}
	}
	
	private boolean inRegion(Location loc, double x1, double y1, double z1, double x2, double y2, double z2) {
		return loc.getX() >= x1 && loc.getX() <= x2 && loc.getY() >= y1 && loc.getY() <= y2 && loc.getZ() >= z1 && loc.getZ() <= z2;
	}
}
