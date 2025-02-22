package com.nanakowo.withering;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WitheringHearts implements ModInitializer {
	public static final String MOD_ID = "withering_hearts";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("WitheringHearts Initialized.");
	}
}