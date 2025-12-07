package me.hamza.library.menu.impl.example;

import me.hamza.library.menu.impl.BaseMenu;

/**
 * @author Hamza
 * @since 06/12/2025
 */
public class ExampleMenu extends BaseMenu {
    @Override
    public int getRows() {
        return 3;
    }

    @Override
    public String getTitle() {
        return "&cExample Menu";
    }

    @Override
    public void getMenuItems() {
        this.setItem(0, new ExampleMenuItem());
    }
}