package cardizadev.com.reportking.GUI;

import cardizadev.com.reportking.files.ActiveReports;
import cardizadev.com.reportking.files.Translation;
import cardizadev.com.reportking.utils.ColorParser;
import cardizadev.com.reportking.utils.ItemGUI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GUIReportList {

    public static String tittle = ColorParser.parseColor(Translation.get().getString("GUI.ReportsList") + " #");

    public static Inventory reports(Player player, int page) {
        int i = 1;
        Inventory reports = Bukkit.createInventory(null, 54, tittle + page);
        int first = 45 * (page - 1) + 1;
        int last = 45 * page;

        for (String key : ActiveReports.get().getKeys(false)) {
            if (i >= first && i <= last) {
                String name = key;
                String reason = ActiveReports.get().getString(key + "." + Translation.get().getString("ActiveReportsFile.Reason"));
                String whosubmmited = ActiveReports.get().getString(key + "." + Translation.get().getString("ActiveReportsFile.SubmittedBy"));
                String time = ActiveReports.get().getString(key + "." + Translation.get().getString("ActiveReportsFile.Time"));
                reports.addItem(new ItemStack[] { ItemGUI.report(name, reason, whosubmmited, time) });
            }
        }
        reports.setItem(53, ItemGUI.forward(player));
        reports.setItem(45, ItemGUI.back(player));
        return reports;
    }
}
