package net.gnomecraft.crosspollination.tag;

import net.gnomecraft.crosspollination.CrossPollination;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class CrossPollinationItemTags {
    public static final TagKey<Item> COMMON_STONES = CrossPollinationItemTags.of(Identifier.of("c", "stones"));

    // Create mod compatibility 1.20.1 (replaced by stripped_logs and stripped_woods in 1.21)
    public static final TagKey<Item> MODDED_STRIPPED_LOGS = CrossPollinationItemTags.of(Identifier.of("create", "modded_stripped_logs"));
    public static final TagKey<Item> MODDED_STRIPPED_WOOD = CrossPollinationItemTags.of(Identifier.of("create", "modded_stripped_wood"));

    public static void init() {
    }

    private static TagKey<Item> of(String path) {
        return CrossPollinationItemTags.of(new Identifier(CrossPollination.MOD_ID, path));
    }

    private static TagKey<Item> of(Identifier id) {
        return TagKey.of(RegistryKeys.ITEM, id);
    }
}
