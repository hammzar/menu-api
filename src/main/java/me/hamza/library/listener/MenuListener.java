package me.hamza.library.listener;

import me.hamza.library.Menu;
import me.hamza.library.MenuAPI;
import me.hamza.library.repository.MenuRepository;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;

/**
 * @author Hamza
 * @since 06/12/2025
 */
public class MenuListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) {
            return;
        }

        Player player = (Player) event.getWhoClicked();

        if (event.getClickedInventory() == null) {
            return;
        }

        MenuRepository repo = MenuAPI.getInstance().getMenuRepository();
        Menu menu = repo.getOpenMenu(player.getUniqueId());

        if (menu == null) {
            return;
        }

        if (!event.getInventory().equals(menu.getInventory())) {
            return;
        }

        event.setCancelled(true);

        //possibly add a 0.5 second cooldown
        menu.onClick(player, event.getSlot(), event.getClick());
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        if (!(event.getPlayer() instanceof Player)) {
            return;
        }

        Player player = (Player) event.getPlayer();

        MenuRepository repo = MenuAPI.getInstance().getMenuRepository();
        Menu menu = repo.getOpenMenu(player.getUniqueId());

        if (menu == null) {
            return;
        }

        menu.onClose(player);
    }

    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event) {
        if (!(event.getPlayer() instanceof Player)) {
            return;
        }

        Player player = (Player) event.getPlayer();

        MenuRepository repo = MenuAPI.getInstance().getMenuRepository();
        Menu menu = repo.getOpenMenu(player.getUniqueId());

        if (menu == null) {
            return;
        }

        menu.onOpen(player);
    }
}