package net.gnomecraft.crosspollination.data;

import com.terraformersmc.cinderscapes.init.CinderscapesItems;
import com.terraformersmc.terrestria.init.TerrestriaItems;
import com.terraformersmc.traverse.item.TraverseItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.gnomecraft.crosspollination.tag.CrossPollinationItemTags;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class CrossPollinationItemTagProvider extends FabricTagProvider.ItemTagProvider {
    protected CrossPollinationItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void configure(RegistryWrapper.WrapperLookup registries) {
        getOrCreateTagBuilder(CrossPollinationItemTags.MODDED_STRIPPED_LOGS)
                .add(CinderscapesItems.STRIPPED_SCORCHED_STEM)
                .add(CinderscapesItems.STRIPPED_UMBRAL_STEM)
                .add(TerrestriaItems.CYPRESS.strippedLog)
                .add(TerrestriaItems.CYPRESS.strippedQuarterLog)
                .add(TerrestriaItems.HEMLOCK.strippedLog)
                .add(TerrestriaItems.HEMLOCK.strippedQuarterLog)
                .add(TerrestriaItems.JAPANESE_MAPLE.strippedLog)
                .add(TerrestriaItems.RAINBOW_EUCALYPTUS.strippedLog)
                .add(TerrestriaItems.RAINBOW_EUCALYPTUS.strippedQuarterLog)
                .add(TerrestriaItems.REDWOOD.strippedLog)
                .add(TerrestriaItems.REDWOOD.strippedQuarterLog)
                .add(TerrestriaItems.RUBBER.strippedLog)
                .add(TerrestriaItems.SAKURA.strippedLog)
                .add(TerrestriaItems.STRIPPED_SMALL_OAK_LOG)
                .add(TerrestriaItems.WILLOW.strippedLog)
                .add(TerrestriaItems.YUCCA_PALM.strippedLog)
                .add(TraverseItems.STRIPPED_FIR_LOG);

        getOrCreateTagBuilder(CrossPollinationItemTags.MODDED_STRIPPED_WOOD)
                .add(CinderscapesItems.STRIPPED_SCORCHED_HYPHAE)
                .add(CinderscapesItems.STRIPPED_UMBRAL_HYPHAE)
                .add(TerrestriaItems.CYPRESS.strippedWood)
                .add(TerrestriaItems.HEMLOCK.strippedWood)
                .add(TerrestriaItems.JAPANESE_MAPLE.strippedWood)
                .add(TerrestriaItems.RAINBOW_EUCALYPTUS.strippedWood)
                .add(TerrestriaItems.REDWOOD.strippedWood)
                .add(TerrestriaItems.RUBBER.strippedWood)
                .add(TerrestriaItems.WILLOW.strippedWood)
                .add(TraverseItems.STRIPPED_FIR_WOOD);
    }
}
