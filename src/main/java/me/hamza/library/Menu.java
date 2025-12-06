package me.hamza.library;

import me.hamza.library.item.MenuItem;
import me.hamza.library.repository.MenuRepository;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.InventoryHolder;

/**
 * @author Hamza
 * @since 06/12/2025
 */
public interface Menu extends InventoryHolder {

    default MenuAPI getAPI() {
        MenuAPI menuAPI = MenuAPI.getInstance();
        if (menuAPI == null) {
            Bukkit.getConsoleSender().sendMessage("§4MenuAPI is not initialized! Make sure to initialize it in your plugin's onEnable method.");
            return null;
        }

        return menuAPI;
    }

    default void openMenu(Player player) {
        this.getMenuItems();

        MenuRepository menuRepository = getAPI().getMenuRepository();
        menuRepository.addMenu(player.getUniqueId(), this);

        player.openInventory(getInventory());
    }

    default void onOpen(Player player) {

    }

    default void onClose(Player player) {
        MenuRepository menuRepository = getAPI().getMenuRepository();
        menuRepository.removeMenu(player.getUniqueId());
    }

    void onClick(Player player, int slot, ClickType clickType);

    void setItem(int slot, MenuItem item);

    void getMenuItems();

    void refresh();
}