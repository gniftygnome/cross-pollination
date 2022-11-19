package net.gnomecraft.crosspollination;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.gnomecraft.crosspollination.composter.CrossPollinationCompostMoreItems;
import net.gnomecraft.crosspollination.config.CrossPollinationConfig;
import net.gnomecraft.crosspollination.fabricresourcecondition.CrossPollinationResourceConditions;
import net.gnomecraft.crosspollination.tag.CrossPollinationBlockTags;
import net.gnomecraft.crosspollination.tag.CrossPollinationItemTags;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CrossPollination implements ModInitializer {
    public static final String MOD_ID = "cross-pollination";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        // Register the mod's config
        AutoConfig.register(CrossPollinationConfig.class, Toml4jConfigSerializer::new);

        CrossPollinationResourceConditions.init();
        CrossPollinationCompostMoreItems.init();
        CrossPollinationBlockTags.init();
        CrossPollinationItemTags.init();

        LOGGER.info("Cross-Pollination is active.");
    }

    public static CrossPollinationConfig getConfig() {
        return AutoConfig.getConfigHolder(CrossPollinationConfig.class).getConfig();
    }
}
