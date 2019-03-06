package com.respawnableores;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.respawnableores.listeners.OreListener;
import com.respawnableores.utils.Utils;

public class RespawnableOres extends JavaPlugin {
	public static RespawnableOres plugin;
	
	private File oresConfigFile = new File(getDataFolder(), "ores.yml");
	private FileConfiguration oresConfig = YamlConfiguration.loadConfiguration(oresConfigFile);
	
	@Override
	public void onEnable() {
		plugin = this;
		registerListeners();
		registerOresConfig();
	}
	
	@Override
	public void onDisable() {
		saveOresConfig();
	}
	
	private void registerOresConfig() {
		Utils.setConfigValue(oresConfig, "ores.regions.r1.x", 0);
		Utils.setConfigValue(oresConfig, "ores.regions.r1.y", 0);
		Utils.setConfigValue(oresConfig, "ores.regions.r1.z", 0);
		
		Utils.setConfigValue(oresConfig, "ores.regions.r2.x", 10000);
		Utils.setConfigValue(oresConfig, "ores.regions.r2.y", 256);
		Utils.setConfigValue(oresConfig, "ores.regions.r2.z", 10000);
		
		List<String> types = new ArrayList<String>();
		types.add("COAL_ORE");
		types.add("IRON_ORE");
		types.add("GOLD_ORE");
		types.add("REDSTONE_ORE");
		types.add("EMERALD_ORE");
		types.add("DIAMOND_ORE");
		types.add("LAPIS_ORE");
		types.add("QUARTZ_ORE");
		
		Utils.setConfigValue(oresConfig, "ores.types", types);
		
		for (String type : types) {
			Utils.setConfigValue(oresConfig, "ores." + type.toLowerCase() + ".respawntime", 10);
			Utils.setConfigValue(oresConfig, "ores." + type.toLowerCase() + ".respawnblock", "STONE");
		}
		
		saveOresConfig();
	}
	
	private void registerListeners() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new OreListener(), this);
	}
	
	public void saveOresConfig() {
		try {
			oresConfig.save(oresConfigFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public FileConfiguration getOresConfig() {
		return oresConfig;
	}
}
