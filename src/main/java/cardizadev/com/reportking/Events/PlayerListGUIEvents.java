package cardizadev.com.reportking.Events;

import cardizadev.com.reportking.GUI.GUIPlayerList;
import cardizadev.com.reportking.GUI.GUIReasonsList;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;

public class PlayerListGUIEvents implements Listener {

    @EventHandler
    public void move(InventoryClickEvent e) {
        if (e.getView().getTitle().contains(GUIPlayerList.tittle))
            e.setCancelled(true);
    }

    @EventHandler
    public void drag(InventoryDragEvent e) {
        if (e.getView().getTitle().contains(GUIPlayerList.tittle))
            e.setCancelled(true);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getView().getTitle().contains(GUIPlayerList.tittle)) {
            if (e.getClick().isLeftClick()) {
                if (e.getCurrentItem() != null) {
                    Player player = (Player) e.getWhoClicked();
                    String[] tittle = ChatColor.stripColor(e.getView().getTitle()).split("#");
                    String page = tittle[1];
                    switch (e.getSlot()) {
                        case 53:
                            player.openInventory(GUIPlayerList.players(player, Integer.parseInt(page) + 1));
                            break;
                        case 45:
                            if (Integer.parseInt(page) > 1)
                                player.openInventory(GUIPlayerList.players(player, Integer.parseInt(page) - 1));
                            break;
                        default:
                            String reportedPlayer = ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName());
                            player.openInventory(GUIReasonsList.reason(player,reportedPlayer));
                            break;
                    }
                }
            }
            e.setCancelled(true);
        }
    }
}
