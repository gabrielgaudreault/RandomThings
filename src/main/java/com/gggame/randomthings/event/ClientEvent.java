package com.gggame.randomthings.event;

import com.gggame.randomthings.init.BlockInit;
import com.gggame.randomthings.init.WoodTypeInit;
import com.gggame.randomthings.screen.MapleFurnaceScreen;
import com.gggame.randomthings.screen.MenuTypes;
import com.gggame.randomthings.screen.OreExtractorScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientEvent {
    @SubscribeEvent
    private void clientSetup(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(BlockInit.ORE_EXTRACTOR.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(BlockInit.CHERRY_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockInit.MAPLE_LEAVES.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(BlockInit.CHERRY_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockInit.MAPLE_SAPLING.get(), RenderType.cutout());

        MenuScreens.register(MenuTypes.ORE_EXTRACTOR_MENU.get(), OreExtractorScreen::new);
        MenuScreens.register(MenuTypes.MAPLE_FURNACE_MENU.get(), MapleFurnaceScreen::new);

        WoodType.register(WoodTypeInit.CHERRY);
        WoodType.register(WoodTypeInit.MAPLE);
    }
}
