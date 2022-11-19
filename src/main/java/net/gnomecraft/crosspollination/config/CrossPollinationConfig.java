package net.gnomecraft.crosspollination.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import net.gnomecraft.crosspollination.CrossPollination;

/*
 * Cross-Pollination configuration file definition.
 *
 * WARNING:  In order to change or remove configuration variables, ALWAYS check  :WARNING
 * WARNING:  for string contents and not merely Java references.  Configuration  :WARNING
 * WARNING:  variables are referenced in resource condition strings by name!     :WARNING
 */
@SuppressWarnings("unused")
@Config(name = CrossPollination.MOD_ID)
public class CrossPollinationConfig implements ConfigData {
    @ConfigEntry.Category("composter")
    @ConfigEntry.Gui.PrefixText
    public Boolean compostBamboo = true;

    @ConfigEntry.Category("composter")
    public Boolean compostFish = true;

    @ConfigEntry.Category("composter")
    public Boolean compostLeather = true;

    @ConfigEntry.Category("composter")
    public Boolean compostPotatoes = true;


    @ConfigEntry.Gui.PrefixText
    @ConfigEntry.Category("recipes")
    public Boolean craftableGildedBlackstone = true;

    @ConfigEntry.Category("recipes")
    public Boolean craftableSaddle = true;

    @ConfigEntry.Category("recipes")
    public Boolean dirtToGrassBlock = true;

    @ConfigEntry.Category("recipes")
    public Boolean mossCarpetToBlocks = true;

    @ConfigEntry.Category("recipes")
    public Boolean snowToWater = true;
}
