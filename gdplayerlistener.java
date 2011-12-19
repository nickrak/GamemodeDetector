package me.tezlastorme.GamemodeDetector;

import org.bukkit.GameMode;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;

public class gdplayerlistener extends PlayerListener{
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		Server server = player.getServer();
		GameMode gamemode = player.getGameMode();
		server.broadcastMessage("GameMode: " + gamemode);
	}
}
