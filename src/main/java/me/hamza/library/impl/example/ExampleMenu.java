package me.hamza.library.impl.example;

import me.hamza.library.impl.BaseMenu;

/**
 * @author Hamza
 * @since 06/12/2025
 */
public class ExampleMenu extends BaseMenu {
    @Override
    public int getRows() {
        return 0;
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