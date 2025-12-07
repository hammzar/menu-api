package me.hamza.library.menu.item;

import lombok.Getter;
import lombok.Setter;
import me.hamza.library.menu.item.context.ClickContext;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Hamza
 * @since 06/12/2025
 */
@Getter
@Setter
public abstract class MenuItem {
    private final String title;
    private final Material material;
    private final int durability;
    private final int amount;
    private final List<String> lore;
    private final boolean hideMeta;

    public MenuItem(String title, Material material, int durability, int amount, List<String> lore, boolean hideMeta) {
        this.title = title;
        this.material = material;
        this.durability = durability;
        this.amount = amount;
        this.lore = lore;
        this.hideMeta = hideMeta;
    }

    public abstract void onClick(ClickContext context);

    public ItemStack toItemStack() {
        ItemStack stack = new ItemStack(material, amount);
        stack.setDurability((short) durability);
        ItemMeta meta = stack.getItemMeta();

        if (meta != null) {
            meta.setDisplayName(title);

            List<String> coloredLore = lore.stream()
                    .map(line -> line.replace("&", "§"))
                    .collect(Collectors.toList());

            meta.setLore(coloredLore);

            if (hideMeta) {
                meta.addItemFlags(ItemFlag.values());
            }

            stack.setItemMeta(meta);
        }

        return stack;
    }
}
