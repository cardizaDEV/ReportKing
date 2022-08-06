package cardizadev.com.reportking.GUI;

import cardizadev.com.reportking.files.Translation;
import cardizadev.com.reportking.utils.ColorParser;
import cardizadev.com.reportking.utils.ItemGUI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class GUIPlayerList {
    public static String tittle = ColorParser.parseColor(Translation.get().getString("GUI.PlayerList") + " #");

    public static Inventory players(Player player, int page) {
        int i = 1;
        List<Player> playlist = new ArrayList<>(Bukkit.getOnlinePlayers());
        Inventory online = Bukkit.createInventory(null, 54, tittle + page);
        int first = 45 * (page - 1) + 1;
        int last = 45 * page;
        for (Player target : Bukkit.getOnlinePlayers()) {
            if (i >= first && i <= last) {
                online.addItem(new ItemStack[] { ItemGUI.head(target) });
                i++;
            }
        }
        online.setItem(53, ItemGUI.forward(player));
        online.setItem(45, ItemGUI.back(player));
        return online;
    }
}
