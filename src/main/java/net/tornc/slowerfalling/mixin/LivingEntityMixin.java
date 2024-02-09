package net.tornc.slowerfalling.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;


@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @ModifyConstant(method = "travel", constant = @Constant(doubleValue = 0.01))
    public double ImplementSlowFallingAmplifier(double descendLiteral) {
        StatusEffectInstance slowFalling = ((LivingEntity) (Object) this).getStatusEffect(StatusEffects.SLOW_FALLING);
        if (slowFalling == null)
            return descendLiteral;

        double amplifier = slowFalling.getAmplifier();
        double multiplier = 0.75;
        double result = descendLiteral * Math.pow(multiplier, amplifier);

        return result > 1e-10 ? result : 0.0;
    }

}
