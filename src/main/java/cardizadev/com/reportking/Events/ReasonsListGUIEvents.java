package cardizadev.com.reportking.Events;

import cardizadev.com.reportking.GUI.GUIReasonsList;
import cardizadev.com.reportking.files.ActiveReports;
import cardizadev.com.reportking.files.ReportedPlayers;
import cardizadev.com.reportking.files.Translation;
import cardizadev.com.reportking.utils.ActualTime;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;

public class ReasonsListGUIEvents implements Listener {

    @EventHandler
    public void move(InventoryClickEvent e) {
        if (e.getView().getTitle().contains(GUIReasonsList.tittle))
            e.setCancelled(true);
    }

    @EventHandler
    public void drag(InventoryDragEvent e) {
        if (e.getView().getTitle().contains(GUIReasonsList.tittle))
            e.setCancelled(true);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getView().getTitle().contains(GUIReasonsList.tittle)) {
            if (e.getClick().isLeftClick()) {
                Player player = (Player) e.getWhoClicked();
                if (!e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(" ")) {

                    int reports = 0;
                    if(ReportedPlayers.get().getString(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getLore().get(0))) == null){
                        reports = 1;
                    }else{
                        reports = Integer.parseInt(ReportedPlayers.get().getString(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getLore().get(0)))) + 1;
                    }
                    ReportedPlayers.get().addDefault(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getLore().get(0)),reports);
                    ReportedPlayers.get().options().copyDefaults(true);
                    ReportedPlayers.save();


                    String path = ChatColor.stripColor(e.getCurrentItem().getItemMeta().getLore().get(0)) + " - " + reports;
                    ActiveReports.get().addDefault(path,"");
                    ActiveReports.get().addDefault(path + "." + Translation.get().getString("ActiveReportsFile.SubmittedBy"),ChatColor.stripColor(player.getDisplayName()));
                    ActiveReports.get().addDefault(path + "." + Translation.get().getString("ActiveReportsFile.Reason"), ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));
                    ActiveReports.get().addDefault(path + "." + Translation.get().getString("ActiveReportsFile.Time"), ActualTime.realTime());
                    ActiveReports.get().options().copyDefaults(true);
                    ActiveReports.save();
                    player.closeInventory();
                }
            }
        }
        e.setCancelled(true);
    }
}
