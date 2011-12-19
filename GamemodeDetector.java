package me.tezlastorme.GamemodeDetector;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class GamemodeDetector extends JavaPlugin{
	private final gdplayerlistener pListener = new gdplayerlistener();
	Logger log = Logger.getLogger("Minecraft");
	
	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvent(Event.Type.PLAYER_JOIN, pListener, Event.Priority.Normal, this);
		log.info("[GamemodeDetector] GamemodeDetector v1.1 has been enabled!");
		
	}
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
		if( cmd.getName().equalsIgnoreCase("gd") )
		{
		    if( args.length == 1 )
		    {
		        String playername = args[0];
		        Player targetplayer = Bukkit.getPlayer( playername );
		        Player player = (Player)sender;

		        if( targetplayer != null && targetplayer.isOnline() )
		        {
		                    GameMode gamemode = targetplayer.getGameMode();
		                    player.sendMessage("Gamemode: " + gamemode);
		                    return true;
		        }
		    }
		}
		return false;
    }
	public void onDisable() {
		log.info("[GamemodeDetector] GamemodeDetector v1.1 has been disabled!");
		
	}

	
	
}
