package com.gggame.randomthings.event.loot;

import com.google.gson.JsonObject;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import java.util.Random;

public class ErbiumGemInAbandonedMineshaftAdditionModifier extends LootModifier {
    private final Item addition;

    protected ErbiumGemInAbandonedMineshaftAdditionModifier(LootItemCondition[] conditionsIn, Item addition) {
        super(conditionsIn);
        this.addition = addition;
    }

    @Nonnull
    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if(context.getRandom().nextFloat() < 0.05f) {
            generatedLoot.add(new ItemStack(addition, new Random().nextInt(2) + 1));
        }


        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<ErbiumGemInAbandonedMineshaftAdditionModifier> {

        @Override
        public ErbiumGemInAbandonedMineshaftAdditionModifier read(ResourceLocation name, JsonObject object,
                                                      LootItemCondition[] conditionsIn) {
            Item addition = ForgeRegistries.ITEMS.getValue(
                    new ResourceLocation(GsonHelper.getAsString(object, "addition")));
            return new ErbiumGemInAbandonedMineshaftAdditionModifier(conditionsIn, addition);
        }

        @Override
        public JsonObject write(ErbiumGemInAbandonedMineshaftAdditionModifier instance) {
            JsonObject json = makeConditions(instance.conditions);
            json.addProperty("addition", ForgeRegistries.ITEMS.getKey(instance.addition).toString());
            return json;
        }
    }
}
