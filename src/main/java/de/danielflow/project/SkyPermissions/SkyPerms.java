package de.danielflow.project.SkyPermissions;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;


import de.danielflow.project.SkyPermissions.Handlers.CommandMTHandler;
import de.danielflow.project.SkyPermissions.Handlers.ICommandMTHandler;
import de.danielflow.project.SkyPermissions.MySQL.MySQL;



public class SkyPerms extends JavaPlugin{
	
	 private transient ICommandMTHandler commandHandler;
	 private static SkyPerms instance;
	 Logger logger = Logger.getLogger("Minecraft");
	
	@Override
	public void onDisable() {
	}

	@Override
	public void onEnable() {
		iWantACleanerClass();
	}
	
	

	
	private void iWantACleanerClass() {
		// Connect to MySQL Database!
/*
 * 		try {
			new MySQL("sql11.freemysqlhosting.net", "sql11223134", "sql11223134", "4g)$g)F8lbHF7o7r");
			MySQL.update("CREATE TABLE IF NOT EXISTS SkyPerms(UUID varchar(64), GROUP varchar(64), PERMISSIONS varchar(64), PREFIX varchar(64));");
		} catch (Exception e) {
			e.printStackTrace();
		}
 */
		
		/* CommandHandler initialisieren */
		commandHandler = new CommandMTHandler(this.getClassLoader(), "de.danielflow.project.SkyPermissions.Commands.Command");
		// Sending an Message Overlay to the Console!
		Bukkit.getConsoleSender().sendMessage("§8§m----- ]-§b Sky§9Permissions §8§m-]-----");
		Bukkit.getConsoleSender().sendMessage("§f SkyCraft Permissions Manager");
		Bukkit.getConsoleSender().sendMessage("§f Version: " + this.getDescription().getVersion());
		Bukkit.getConsoleSender().sendMessage("§f Author: "+ this.getDescription().getAuthors().toString());
		Bukkit.getConsoleSender().sendMessage("§f MySQL Status: ");
		Bukkit.getConsoleSender().sendMessage("§8§m----- ]-§b Sky§9Permissions §8§m-]-----");
		
	}
	
	 public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		 return commandHandler.handleCommand(sender, cmd, label, args);

		    }
	 
	 public SkyPerms() {
		 instance = this;	
	 }
		 
		 
	 public static SkyPerms getInstance() {
		 return instance;	
	       
	 }
	 
	 public static String getUUID(String name) {

		 return Bukkit.getOfflinePlayer(name).getUniqueId().toString().replace("-", "");
		}

}
