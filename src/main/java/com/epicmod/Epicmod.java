package com.epicmod;

import com.epicmod.block.ModBlocks;
import com.epicmod.creativemodetab.ModCreativeModeTabs;
import com.epicmod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Epicmod implements ModInitializer {
	public static final String MOD_ID = "epicmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModCreativeModeTabs.registerModCreativeModeTabs();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}