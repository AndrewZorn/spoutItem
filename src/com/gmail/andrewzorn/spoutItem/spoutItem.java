package com.gmail.andrewzorn.spoutItem;

import java.util.logging.Level;

import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.inventory.SpoutShapedRecipe;
import org.getspout.spoutapi.material.MaterialData;

public class spoutItem extends JavaPlugin {
	public testitem item;
	public spoutItemCommandExecutor executor;
	
	@Override
	public void onEnable() {
		SpoutManager.getFileManager().addToPreLoginCache(this, "http://dl.dropbox.com/u/19774625/item.png");
		item = new testitem(this, "item", "http://dl.dropbox.com/u/19774625/item.png");
		additemRecipe();

		getLogger().log(Level.INFO, "[Spout Item Test Plugin] Enabled!");
		
		saveDefaultConfig();
		
		new spoutItemListener(this);
		
		executor = new spoutItemCommandExecutor(this);
		this.getCommand("message").setExecutor(executor);
		this.getCommand("changeMe").setExecutor(executor);
		this.getCommand("changeMeBack").setExecutor(executor);
	}
	
	@Override
	public void onDisable() {
		getLogger().log(Level.INFO, "[Spout Item Test Plugin] Disabled");
	}

	public void additemRecipe() {
		SpoutItemStack itemx = new SpoutItemStack(item, 1);
		SpoutShapedRecipe recipe = new SpoutShapedRecipe(itemx);
		recipe.shape("XXX", "XYX", "XXX");
		recipe.setIngredient('X', MaterialData.obsidian);
		recipe.setIngredient('Y', MaterialData.goldIngot);
		SpoutManager.getMaterialManager().registerSpoutRecipe(recipe);
	}
}