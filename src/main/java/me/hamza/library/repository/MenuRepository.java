package me.hamza.library.repository;

import lombok.Getter;
import me.hamza.library.Menu;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Hamza
 * @since 06/12/2025
 */
@Getter
public class MenuRepository {
    private final Map<UUID, Menu> openMenus = new ConcurrentHashMap<>();

    public void addMenu(UUID playerUUID, Menu menu) {
        openMenus.putIfAbsent(playerUUID, menu);
    }

    public void removeMenu(UUID playerUUID) {
        openMenus.remove(playerUUID);
    }

    public Menu getOpenMenu(UUID playerUUID) {
        return openMenus.get(playerUUID);
    }
}