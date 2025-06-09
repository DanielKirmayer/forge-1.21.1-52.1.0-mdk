package net.dannykandmichaelk.firstmod.screen;

import net.dannykandmichaelk.firstmod.FirstMod;
import net.dannykandmichaelk.firstmod.block.custom.CryoniteWorkbenchBlock;
import net.dannykandmichaelk.firstmod.screen.custom.CryoniteWorkbenchMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(Registries.MENU, FirstMod.MOD_ID);


    public static final RegistryObject<MenuType<CryoniteWorkbenchMenu>> CRYONITE_WORKBENCH_MENU =
            MENUS.register("cryonite_workbench_menu", () -> IForgeMenuType.create(CryoniteWorkbenchMenu::new));


    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
