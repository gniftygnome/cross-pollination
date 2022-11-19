package net.gnomecraft.crosspollination.tag;

import net.gnomecraft.crosspollination.CrossPollination;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CrossPollinationItemTags {
    public static final TagKey<Item> COMMON_STONES = CrossPollinationItemTags.of(Identifier.of("c", "stones"));

    public static void init() {
    }

    private static TagKey<Item> of(String path) {
        return CrossPollinationItemTags.of(new Identifier(CrossPollination.MOD_ID, path));
    }

    private static TagKey<Item> of(Identifier id) {
        return TagKey.of(Registry.ITEM_KEY, id);
    }
}
