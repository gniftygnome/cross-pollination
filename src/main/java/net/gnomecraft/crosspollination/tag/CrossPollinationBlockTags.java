package net.gnomecraft.crosspollination.tag;

import net.gnomecraft.crosspollination.CrossPollination;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public final class CrossPollinationBlockTags {
	public static final TagKey<Block> BASALTS = CrossPollinationBlockTags.of(Identifier.of("c", "basalts"));

	public static void init() {
	}

	private static TagKey<Block> of(String path) {
		return CrossPollinationBlockTags.of(new Identifier(CrossPollination.MOD_ID, path));
	}

	private static TagKey<Block> of(Identifier id) {
		return TagKey.of(RegistryKeys.BLOCK, id);
	}
}
