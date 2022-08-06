package cardizadev.com.reportking.GUI;

import cardizadev.com.reportking.files.Reasons;
import cardizadev.com.reportking.files.Solutions;
import cardizadev.com.reportking.files.Translation;
import cardizadev.com.reportking.utils.ColorParser;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GUISolveReport {

    public static String tittle = ColorParser.parseColor(Translation.get().getString("GUI.Solutions") + " #");


    public static Inventory solutions(String report) {

        Inventory solutions = Bukkit.createInventory(null, 54, tittle);

        ItemStack glass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta meta4 = glass.getItemMeta();
        meta4.setDisplayName(" ");
        meta4.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES});
        List<String> lore = new ArrayList<>();
        meta4.setLore(lore);
        glass.setItemMeta(meta4);

        for (int slot = 0; slot < solutions.getSize(); slot++) {
            if (Solutions.get().getString(String.valueOf(slot) + ".Name").equalsIgnoreCase("NULL") ||
                    Solutions.get().getString(String.valueOf(slot) + ".Item").equalsIgnoreCase("NULL") ||
                    Solutions.get().getString(String.valueOf(slot) + ".Command").equalsIgnoreCase("NULL")){
                solutions.setItem(slot, glass);
            } else {
                ItemStack reason = new ItemStack(Material.getMaterial(Solutions.get().getString(String.valueOf(slot) + ".Item")));
                ItemMeta meta = reason.getItemMeta();
                meta.setDisplayName(ColorParser.parseColor(Solutions.get().getString(String.valueOf(slot) + ".Name")));
                meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES});
                List<String> description = new ArrayList<>();
                description.add(ColorParser.parseColor("&7") + report);
                description.add(ColorParser.parseColor(Solutions.get().getString(String.valueOf(slot) + ".Description")));
                meta.setLore(description);
                reason.setItemMeta(meta);
                solutions.setItem(slot, reason);
            }
        }
        return solutions;
    }
}
