package net.gnomecraft.crosspollination.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.gnomecraft.crosspollination.CrossPollination;
import net.gnomecraft.crosspollination.fabricresourcecondition.CrossPollinationResourceConditions;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

import java.util.Collections;
import java.util.function.Consumer;

public class CrossPollinationRecipeProvider extends FabricRecipeProvider {
    public CrossPollinationRecipeProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {
        new ShapedRecipeJsonBuilder(Items.GILDED_BLACKSTONE, 1)
                .group("decoration")
                .pattern("ggg")
                .pattern("gbg")
                .pattern("ggg")
                .input('b', Items.BLACKSTONE)
                .input('g', Items.GOLD_NUGGET)
                .criterion("has_blackstone", InventoryChangedCriterion.Conditions.items(Items.BLACKSTONE))
                .offerTo(withConditions(exporter, CrossPollinationResourceConditions.allConfigBooleansEnabled("craftableGildedBlackstone")));

        new ShapelessRecipeJsonBuilder(Items.GRASS_BLOCK, 1)
                .group("dirt")
                .input(Items.DIRT)
                .input(Items.WHEAT_SEEDS)
                .criterion("has_seeds", InventoryChangedCriterion.Conditions.items(Items.WHEAT_SEEDS))
                .offerTo(withConditions(exporter, CrossPollinationResourceConditions.allConfigBooleansEnabled("dirtToGrassBlock")));

        new ShapelessRecipeJsonBuilder(Items.MOSS_BLOCK, 2)
                .group("moss")
                .input(Items.BONE_MEAL)
                .input(Items.MOSS_CARPET)
                .input(Items.MOSS_CARPET)
                .input(Items.MOSS_CARPET)
                .criterion("has_moss", InventoryChangedCriterion.Conditions.items(Items.MOSS_CARPET))
                .offerTo(withConditions(exporter, CrossPollinationResourceConditions.allConfigBooleansEnabled("mossCarpetToBlocks")));

        new ShapedRecipeJsonBuilder(Items.SADDLE, 1)
                .group("saddle")
                .pattern("lll")
                .pattern("s s")
                .pattern("i i")
                .input('l', Items.LEATHER)
                .input('s', Items.STRING)
                .input('i', Items.IRON_INGOT)
                .criterion("has_leather", InventoryChangedCriterion.Conditions.items(Items.LEATHER))
                .offerTo(withConditions(exporter, CrossPollinationResourceConditions.allConfigBooleansEnabled("craftableSaddle")));

        offerSmelting(withConditions(exporter, CrossPollinationResourceConditions.allConfigBooleansEnabled("snowToWater")),
                Collections.singletonList(Items.POWDER_SNOW_BUCKET),
                Items.WATER_BUCKET,
                0.1f, 200, "smelting");
    }

    @Override
    protected Identifier getRecipeIdentifier(Identifier identifier) {
        return new Identifier(CrossPollination.MOD_ID, identifier.getPath());
    }
}
