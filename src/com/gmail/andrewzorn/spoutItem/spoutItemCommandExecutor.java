package com.gmail.andrewzorn.spoutItem;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spout.player.SpoutCraftPlayer;

import com.google.common.base.Joiner;

public class spoutItemCommandExecutor implements CommandExecutor {
	private final spoutItem plugin;
	
	public spoutItemCommandExecutor(spoutItem plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "you must be logged on to use these commands");
			return false;
		}
		else if (command.getName().equalsIgnoreCase("changeMe") && sender.hasPermission("SpoutBlockTutorial.worldBlock")) {
			Player player = (Player) sender;
			SpoutCraftPlayer sp = (SpoutCraftPlayer) player;
			sp.setSkin("http://www.cs.unca.edu/~bruce/Fall12/373/redRock.png");
			return true;
		}
		else if (command.getName().equalsIgnoreCase("changeMeBack") && sender.hasPermission("SpoutBlockTutorial.worldBlock")) {
			Player player = (Player) sender;
			SpoutCraftPlayer sp = (SpoutCraftPlayer) player;
			sp.resetSkinFor(sp);
			return true;
		}
		else if (command.getName().equalsIgnoreCase("message") && sender.hasPermission("SpoutBlockTutorial.message") && args.length > 0) {
			this.plugin.getConfig().set("sample.message", Joiner.on(' ').join(args));
			return true;
		}
		else	return false;
	}
}