package cardizadev.com.reportking.commands;

import cardizadev.com.reportking.GUI.GUIPlayerList;
import cardizadev.com.reportking.GUI.GUIReasonsList;
import cardizadev.com.reportking.files.Commands;
import cardizadev.com.reportking.files.Permissions;
import cardizadev.com.reportking.files.Translation;
import cardizadev.com.reportking.utils.ColorParser;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class RkReport extends BukkitCommand {

    public RkReport(String name) {
        super(name);
        this.description = Translation.get().getString("Description.Report");
        this.usageMessage = "/" + Commands.get().getString("Commands.Report") + " <player>";
        this.setPermission(Permissions.get().getString("Permissions.Report"));
        this.setAliases(new ArrayList<String>());
    }

    @Override
    public boolean execute(CommandSender sender, String alias, String[] args) {
        if(args.length == 0){
            if(sender instanceof Player){
                Player player = (Player) sender;
                if(player.hasPermission(Permissions.get().getString("Permissions.Report"))){
                    player.openInventory(GUIPlayerList.players(player, 1));
                }else{
                    player.sendMessage(ColorParser.parseColor(Translation.get().getString("Permissions.NonPermission")));
                }
            }else{
                System.out.println(ColorParser.parseColor(Translation.get().getString("Defaults.NoPlayer")));
            }
        }else{
            if(sender instanceof Player){
                Player player = (Player) sender;
                if(player.hasPermission(Permissions.get().getString("Permissions.Report"))){
                    List<Player> players = new ArrayList<>(Bukkit.getOnlinePlayers());
                    for(Player reportedPlayer: players){
                        if(reportedPlayer.getDisplayName().equals(args[0])) {
                            player.openInventory(GUIReasonsList.reason(player,ChatColor.stripColor(reportedPlayer.getDisplayName())));
                        }
                    }
                }else{
                    player.sendMessage(ColorParser.parseColor(Translation.get().getString("Permissions.NonPermission")));
                }
            }else{
                System.out.println(ColorParser.parseColor(Translation.get().getString("Defaults.NoPlayer")));
            }
        }
        return true;
    }
}
