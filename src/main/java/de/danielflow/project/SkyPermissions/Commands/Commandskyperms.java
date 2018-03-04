package de.danielflow.project.SkyPermissions.Commands;

import org.bukkit.entity.Player;

import de.danielflow.project.SkyPermissions.Handlers.CommandMT;
import de.danielflow.project.SkyPermissions.Handlers.IUser;

public class Commandskyperms extends CommandMT{
	
	@Override
	public void run(IUser user, String commandLabel, String[] args) throws Exception {
		Player p = user.getPlayer();
		if(commandLabel.equalsIgnoreCase("skyperms")) {
			p.sendMessage("geht");
		}
		
		
	}

}
