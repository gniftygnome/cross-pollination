package net.gnomecraft.crosspollination.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;

public class CrossPollinationDatagen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {
        FabricDataGenerator.Pack pack = dataGenerator.createPack();

        //pack.addProvider(CrossPollinationDynamicRegistryProvider::new);
        //pack.addProvider(CrossPollinationBiomeTagProvider::new);
        //pack.addProvider(CrossPollinationBlockLootTableProvider::new);
        //CrossPollinationBlockTagProvider blockTagProvider = pack.addProvider(CrossPollinationBlockTagProvider::new);
        //pack.addProvider((output, registries) -> new CrossPollinationItemTagProvider(output, registries, blockTagProvider));
        pack.addProvider(CrossPollinationItemTagProvider::new);
        pack.addProvider(CrossPollinationRecipeProvider::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        //CrossPollinationDynamicRegistryProvider.buildRegistry(registryBuilder);
    }
}
