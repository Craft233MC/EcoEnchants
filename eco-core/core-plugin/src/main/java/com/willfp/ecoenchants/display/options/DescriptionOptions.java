package com.willfp.ecoenchants.display.options;

import com.willfp.eco.core.EcoPlugin;
import com.willfp.eco.core.PluginDependent;
import com.willfp.ecoenchants.EcoEnchantsPlugin;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DescriptionOptions extends PluginDependent<EcoPlugin> {
    /**
     * The threshold below which to describe enchantments.
     */
    @Getter
    private int threshold;

    /**
     * If the options are enabled.
     */
    @Getter
    private boolean enabled;

    /**
     * The description lines color.
     */
    @Getter
    private String color;

    /**
     * If enchantment descriptions should be at the bottom of the enchantment lore rather than under each enchantment.
     */
    @Getter
    private boolean showingAtBottom;

    /**
     * Create new description options.
     *
     * @param plugin EcoEnchants.
     */
    public DescriptionOptions(@NotNull final EcoPlugin plugin) {
        super(plugin);
    }

    /**
     * Update the options.
     */
    public void update() {
        threshold = this.getPlugin().getConfigYml().getInt("lore.describe.before-lines");
        enabled = this.getPlugin().getConfigYml().getBool("lore.describe.enabled");
        color = this.getPlugin().getLangYml().getString("description-color");
        showingAtBottom = this.getPlugin().getConfigYml().getBool("lore.describe.at-bottom");
    }

    /**
     * Get description state for a player
     *
     * @param player - a player to get the state for.
     */
    public boolean playerEnabled(@Nullable final Player player) {
        if (player == null) return true;
        return ((EcoEnchantsPlugin) this.getPlugin()).getDataYml().isDescriptionEnabled(player);
    }

}
