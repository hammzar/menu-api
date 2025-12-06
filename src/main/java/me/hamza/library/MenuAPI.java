package me.hamza.library;

import lombok.Getter;
import me.hamza.library.listener.MenuListener;
import me.hamza.library.repository.MenuRepository;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Hamza
 * @since 06/12/2025
 */
@Getter
public class MenuAPI {

    @Getter
    private static MenuAPI instance;

    private final MenuRepository menuRepository = new MenuRepository();

    public MenuAPI(JavaPlugin plugin) {
        instance = this;
        plugin.getServer().getPluginManager().registerEvents(new MenuListener(), plugin);
    }
}