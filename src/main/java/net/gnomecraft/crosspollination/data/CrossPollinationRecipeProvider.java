package net.gnomecraft.crosspollination.data;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.init.CinderscapesItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.DefaultResourceConditions;
import net.gnomecraft.crosspollination.CrossPollination;
import net.gnomecraft.crosspollination.fabricresourcecondition.CrossPollinationResourceConditions;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.Collections;
import java.util.function.Consumer;

public class CrossPollinationRecipeProvider extends FabricRecipeProvider {
    protected CrossPollinationRecipeProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    // Convenience additions
    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        new ShapedRecipeJsonBuilder(RecipeCategory.BUILDING_BLOCKS, Items.GILDED_BLACKSTONE, 1)
                .group("decoration")
                .pattern("ggg")
                .pattern("gbg")
                .pattern("ggg")
                .input('b', Items.BLACKSTONE)
                .input('g', Items.GOLD_NUGGET)
                .criterion("has_blackstone", InventoryChangedCriterion.Conditions.items(Items.BLACKSTONE))
                .offerTo(withConditions(exporter, CrossPollinationResourceConditions.allConfigBooleansEnabled("craftableGildedBlackstone")));

        new ShapelessRecipeJsonBuilder(RecipeCategory.BUILDING_BLOCKS, Items.GRASS_BLOCK, 1)
                .group("dirt")
                .input(Items.DIRT)
                .input(Items.WHEAT_SEEDS)
                .criterion("has_seeds", InventoryChangedCriterion.Conditions.items(Items.WHEAT_SEEDS))
                .offerTo(withConditions(exporter, CrossPollinationResourceConditions.allConfigBooleansEnabled("dirtToGrassBlock")));

        new ShapelessRecipeJsonBuilder(RecipeCategory.BUILDING_BLOCKS, Items.MOSS_BLOCK, 2)
                .group("moss")
                .input(Items.BONE_MEAL)
                .input(Items.MOSS_CARPET)
                .input(Items.MOSS_CARPET)
                .input(Items.MOSS_CARPET)
                .criterion("has_moss", InventoryChangedCriterion.Conditions.items(Items.MOSS_CARPET))
                .offerTo(withConditions(exporter, CrossPollinationResourceConditions.allConfigBooleansEnabled("mossCarpetToBlocks")));

        new ShapedRecipeJsonBuilder(RecipeCategory.TRANSPORTATION, Items.SADDLE, 1)
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
                RecipeCategory.MISC,
                Items.WATER_BUCKET,
                0.1f, 200, "smelting");


        // Missing recipe to blast/smelt Cinderscapes' Sulfur Ore into (refined) Sulfur
        offerBlasting(withConditions(exporter, DefaultResourceConditions.allModsLoaded(Cinderscapes.NAMESPACE)),
                Collections.singletonList(CinderscapesItems.SULFUR_ORE),
                RecipeCategory.MISC,
                CinderscapesItems.SULFUR,
                0.1f, 100, "blasting");

        offerSmelting(withConditions(exporter, DefaultResourceConditions.allModsLoaded(Cinderscapes.NAMESPACE)),
                Collections.singletonList(CinderscapesItems.SULFUR_ORE),
                RecipeCategory.MISC,
                CinderscapesItems.SULFUR,
                0.1f, 200, "smelting");
    }

    @Override
    public String getName() {
        return "Cross-Pollination Recipes";
    }

    @Override
    protected Identifier getRecipeIdentifier(Identifier identifier) {
        return Identifier.of(CrossPollination.MOD_ID, identifier.getPath());
    }
}
