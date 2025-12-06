package me.hamza.library.item.context;

import lombok.Getter;
import me.hamza.library.Menu;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;

/**
 * @author Hamza
 * @since 06/12/2025
 */
@Getter
public class ClickContext {
    private final Player player;
    private final ClickType clickType;
    private final int slot;
    private final Menu menu;

    public ClickContext(Player player, ClickType clickType, int slot, Menu menu) {
        this.player = player;
        this.clickType = clickType;
        this.slot = slot;
        this.menu = menu;
    }
}