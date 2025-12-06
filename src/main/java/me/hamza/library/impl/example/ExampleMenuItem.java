package me.hamza.library.impl.example;

import me.hamza.library.item.MenuItem;
import me.hamza.library.item.context.ClickContext;
import org.bukkit.Material;

import java.util.Collections;

/**
 * @author Hamza
 * @since 06/12/2025
 */
public class ExampleMenuItem extends MenuItem {

    public ExampleMenuItem() {
        super(
                "Example Item",
                Material.PAPER,
                0,
                1,
                Collections.singletonList("This is an example item."),
                false
        );
    }

    @Override
    public void onClick(ClickContext context) {
        switch (context.getClickType()) {
            case LEFT:
                context.getPlayer().sendMessage("Left click!");
                break;

            case RIGHT:
                context.getPlayer().sendMessage("Right click!");
                break;

            default:
                context.getPlayer().sendMessage("Click: " + context.getClickType());
        }
    }
}
