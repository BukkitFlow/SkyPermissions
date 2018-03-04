package de.danielflow.project.SkyPermissions.Handlers;



import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.danielflow.project.SkyPermissions.Exception.OnlyPlayerException;

public class CommandMT implements ICommandMT {

    public final void run(final IUser user, final Command cmd, final String commandLabel, final String[] args)
	    throws Exception {
	run(user, commandLabel, args);

    }

    protected void run(final IUser user, final String commandLabel, final String[] args) throws Exception {
	Player userPlayer = user.getPlayer();
	run((CommandSender) userPlayer, commandLabel, args);
    }

    public final void run(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args)
	    throws Exception {
	run(sender, commandLabel, args);
    }

    protected void run(final CommandSender sender, final String commandLabel, final String[] args) throws Exception {
	throw new OnlyPlayerException();
    }

}
