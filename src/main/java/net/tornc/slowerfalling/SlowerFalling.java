package net.tornc.slowerfalling;

import net.fabricmc.api.ModInitializer;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SlowerFalling implements ModInitializer {
    public static final String MOD_ID = "slower-falling";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        SlowerFalling.LOGGER.info("Registering STRONG_SLOW_FALLING potion...");

        Potion STRONG_SLOW_FALLING = Registry.register(
                Registries.POTION,
                new Identifier(SlowerFalling.MOD_ID, "strong_slow_falling"),
                new Potion(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 900, 3)));

        BrewingRecipeRegistry.registerPotionRecipe(Potions.SLOW_FALLING, Items.GLOWSTONE_DUST, STRONG_SLOW_FALLING);
    }
}