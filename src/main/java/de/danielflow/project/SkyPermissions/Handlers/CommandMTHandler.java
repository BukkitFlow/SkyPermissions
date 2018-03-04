package de.danielflow.project.SkyPermissions.Handlers;



import java.util.HashMap;
import java.util.Locale;
import java.util.Map;



import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class CommandMTHandler implements ICommandMTHandler {

    private final transient ClassLoader classLoader;
    private final transient String commandPath;
    private final transient Map<String, ICommandMT> commands = new HashMap<String, ICommandMT>();

    public CommandMTHandler(ClassLoader classLoader, String commandPath) {
	this.classLoader = classLoader;
	this.commandPath = commandPath;

    }
    


    public boolean handleCommand(final CommandSender sender, final Command command, final String commandLabel,
	    final String[] args) {
    	
    

	// ////////////////////////
	// /////alias system///////
	// ////////////////////////

	final String commandName = command.getName().toLowerCase(Locale.ENGLISH);
	ICommandMT cmd = commands.get(commandName);
	if (cmd == null) {

	    try {
		cmd = (CommandMT) classLoader.loadClass(commandPath + commandName).newInstance();
		commands.put(commandName, cmd);
	    } catch (Exception ex) {
		sender.sendMessage("Fehler");
		ex.printStackTrace();

		return true;
	    }
	    
	

	}
	return false;
}
}


