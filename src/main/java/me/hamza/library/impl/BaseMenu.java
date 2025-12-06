package me.hamza.library.impl;

import lombok.Getter;
import me.hamza.library.Menu;
import me.hamza.library.item.MenuItem;
import me.hamza.library.item.context.ClickContext;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hamza
 * @since 06/12/2025
 */
@Getter
public abstract class BaseMenu implements Menu {
    private final Map<Integer, MenuItem> items = new HashMap<>();
    private final Inventory inventory;

    public BaseMenu() {
        int rows = this.getRows();
        String title = ChatColor.translateAlternateColorCodes('&', this.getTitle());
        this.inventory = Bukkit.createInventory(this, rows * 9, title);
    }

    @Override
    public void onClick(Player player, int slot, ClickType clickType) {
        MenuItem item = items.get(slot);

        if (item == null) {
            return;
        }

        ClickContext context = new ClickContext(player, clickType, slot, this);
        item.onClick(context);
    }

    @Override
    public void refresh() {
        for (Map.Entry<Integer, MenuItem> entry : items.entrySet()) {
            int slot = entry.getKey();
            MenuItem item = entry.getValue();
            ItemStack itemStack = item.toItemStack();
            inventory.setItem(slot, itemStack);
        }
    }

    @Override
    public void setItem(int slot, MenuItem item) {
        items.put(slot, item);
        inventory.setItem(slot, item.toItemStack());
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }

    public abstract int getRows();

    public abstract String getTitle();

    public abstract void getMenuItems();
}