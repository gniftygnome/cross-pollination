package net.gnomecraft.crosspollination.tag;

import net.gnomecraft.crosspollination.CrossPollination;
import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public final class CrossPollinationBlockTags {
	public static final TagKey<Block> BASALT = CrossPollinationBlockTags.of(Identifier.of("c", "basalt"));

	public static void init() {
	}

	private static TagKey<Block> of(String path) {
		return CrossPollinationBlockTags.of(new Identifier(CrossPollination.MOD_ID, path));
	}

	private static TagKey<Block> of(Identifier id) {
		return TagKey.of(Registry.BLOCK_KEY, id);
	}
}
