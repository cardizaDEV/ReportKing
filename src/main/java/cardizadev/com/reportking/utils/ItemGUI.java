package cardizadev.com.reportking.utils;

import cardizadev.com.reportking.files.Translation;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemGUI {
    public static ItemStack report(String name, String reason, String whosubmmited, String time) {
        ItemStack report = new ItemStack(Material.PAPER);
        ItemMeta meta1 = report.getItemMeta();
        meta1.setDisplayName(name);
        List<String> lore = new ArrayList<>();
        lore.add(ColorParser.parseColor(Translation.get().getString("GUI.Reason") + " " + reason));
        lore.add(ColorParser.parseColor(Translation.get().getString("GUI.SubmittedBy") + " " + whosubmmited));
        lore.add(ColorParser.parseColor(Translation.get().getString("GUI.Time") + " " + time));
        meta1.setLore(lore);
        report.setItemMeta(meta1);
        return report;
    }

    public static ItemStack head(Player p) {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta skullmeta = (SkullMeta)head.getItemMeta();
        skullmeta.setOwningPlayer((OfflinePlayer)p.getPlayer());
        skullmeta.setDisplayName(ColorParser.parseColor("&f" + p.getName()));
        head.setItemMeta((ItemMeta)skullmeta);
        return head;
    }

    public static ItemStack back(Player p) {
        ItemStack back = new ItemStack(Material.ARROW);
        ItemMeta meta1 = back.getItemMeta();
        meta1.setDisplayName(Translation.get().getString("Defaults.Back"));
        back.setItemMeta(meta1);
        return back;
    }

    public static ItemStack forward(Player p) {
        ItemStack forward = new ItemStack(Material.ARROW);
        ItemMeta meta = forward.getItemMeta();
        meta.setDisplayName(Translation.get().getString("Defaults.Forward"));
        forward.setItemMeta(meta);
        return forward;
    }
}
