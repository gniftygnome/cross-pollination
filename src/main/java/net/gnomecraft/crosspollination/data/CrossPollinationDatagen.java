package net.gnomecraft.crosspollination.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class CrossPollinationDatagen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {
        //dataGenerator.addProvider(CrossPollinationBiomeTagProvider::new);
        //dataGenerator.addProvider(CrossPollinationBlockLootTableProvider::new);
        //dataGenerator.addProvider(CrossPollinationBlockTagProvider::new);
        //dataGenerator.addProvider(CrossPollinationItemTagProvider::new);
        dataGenerator.addProvider(CrossPollinationRecipeProvider::new);
    }
}
