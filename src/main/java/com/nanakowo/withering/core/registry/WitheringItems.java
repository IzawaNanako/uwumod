package com.nanakowo.withering.core.registry;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

public class WitheringItems {
    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(entries -> {
            entries.accept(BEAT_COIN);
        });
    }

    @SuppressWarnings("unused")
    public static final Item BEAT_COIN = registerItem("beat_coin");

    public static ResourceKey<Item> witheringItemId(String id) {
        return ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("withering_hearts", id));
    }

    public static Item registerItem(String id, Item item) {
        return registerItem(witheringItemId(id), item);
    }

    public static Item registerItem(String id) {
        return registerItem(witheringItemId(id), new Item(new Item.Properties().setId(witheringItemId(id))));
    }

    public static Item registerItem(ResourceKey<Item> resourceKey, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, resourceKey, item);
    }
}