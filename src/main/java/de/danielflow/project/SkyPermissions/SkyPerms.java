package de.danielflow.project.SkyPermissions;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import de.danielflow.project.SkyPermissions.MySQL.MySQL;

public class SkyPerms extends JavaPlugin{
	@Override
	public void onDisable() {
	}

	@Override
	public void onEnable() {
		iWantACleanerClass();
	}
	
	


	private void onLoadCommand() {
		
	}
	
	private void onLoadListener() {
		
	}
	
	private void iWantACleanerClass() {
		// Connect to MySQL Database!
		try {
			new MySQL("sql11.freemysqlhosting.net", "sql11223134", "sql11223134", "IL48SiLMCZ");
			MySQL.update("CREATE TABLE IF NOT EXISTS SkyPerms(UUID varchar(64), Group varchar(64), Permissions varchar(64), Prefix varchar(64));");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// register Commands & Listeners into PluginManager
		onLoadListener();
		onLoadCommand();
		// Sending an Message Overlay to the Console!
		Bukkit.getConsoleSender().sendMessage("§8§m----- ]-§b Sky§9Permissions §8§m-]-----");
		Bukkit.getConsoleSender().sendMessage("§f SkyCraft Permissions Manager");
		Bukkit.getConsoleSender().sendMessage("§f Version: " + this.getDescription().getVersion());
		Bukkit.getConsoleSender().sendMessage("§f Author: "+ this.getDescription().getAuthors().toString());
		Bukkit.getConsoleSender().sendMessage("§f MySQL Status: ");
		Bukkit.getConsoleSender().sendMessage("§8§m----- ]-§b Sky§9Permissions §8§m-]-----");
		
	}

}
