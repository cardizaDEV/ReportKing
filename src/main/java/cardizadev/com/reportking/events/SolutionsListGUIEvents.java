package cardizadev.com.reportking.events;

import cardizadev.com.reportking.GUI.GUISolveReport;
import cardizadev.com.reportking.files.ActiveReports;
import cardizadev.com.reportking.files.Solutions;
import cardizadev.com.reportking.files.SolvedReports;
import cardizadev.com.reportking.files.Translation;
import cardizadev.com.reportking.utils.ActualTime;
import cardizadev.com.reportking.utils.ColorParser;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;

public class SolutionsListGUIEvents implements Listener {
    @EventHandler
    public void move(InventoryClickEvent e) {
        if (e.getView().getTitle().contains(GUISolveReport.tittle)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void drag(InventoryDragEvent e) {
        if (e.getView().getTitle().contains(GUISolveReport.tittle)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getView().getTitle().contains(GUISolveReport.tittle)) {
            if (e.getClick().isLeftClick()) {
                Player player = (Player) e.getWhoClicked();
                if (!e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(" ")) {
                    String path = ChatColor.stripColor(e.getCurrentItem().getItemMeta().getLore().get(0));

                    SolvedReports.get().addDefault(path,"");
                    SolvedReports.get().addDefault(path + "." + Translation.get().getString("ActiveReportsFile.SubmittedBy"),ChatColor.stripColor(player.getDisplayName()));
                    SolvedReports.get().addDefault(path + "." + Translation.get().getString("ActiveReportsFile.Reason"), ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));
                    SolvedReports.get().addDefault(path + "." + Translation.get().getString("ActiveReportsFile.Time"), ActualTime.realTime());
                    SolvedReports.get().options().copyDefaults(true);
                    SolvedReports.save();


                    Solutions.get().set(path,null);
                    ActiveReports.get().set(path + "." + Translation.get().getString("ActiveReportsFile.SubmittedBy"),null);
                    ActiveReports.get().set(path + "." + Translation.get().getString("ActiveReportsFile.Reason"), null);
                    ActiveReports.get().set(path + "." + Translation.get().getString("ActiveReportsFile.Time"), null);
                    ActiveReports.get().options().copyDefaults(true);
                    ActiveReports.save();

                    String[] reported = e.getCurrentItem().getItemMeta().getLore().get(0).split(" -");
                    String command = Solutions.get().getString(e.getSlot() + ".Command");
                    command = command.replaceAll("\\{player}", reported[0]);
                    Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(),ChatColor.stripColor(command));
                    player.sendMessage(ColorParser.parseColor(Translation.get().getString("Defaults.ReportSolvedSuccessfully")));
                    player.closeInventory();
                }
            }
            e.setCancelled(true);
        }
    }
}
