package cardizadev.com.reportking.commands;

import cardizadev.com.reportking.GUI.GUIReportList;
import cardizadev.com.reportking.files.Commands;
import cardizadev.com.reportking.files.Permissions;
import cardizadev.com.reportking.files.Translation;
import cardizadev.com.reportking.utils.ColorParser;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class RkSolve extends BukkitCommand {

    public RkSolve(String name) {
        super(name);
        this.description = Translation.get().getString("Description.Solve");
        this.usageMessage = "/" + Commands.get().getString("Commands.Solve");
        this.setPermission(Permissions.get().getString("Permissions.Solve"));
        this.setAliases(new ArrayList<String>());
    }

    @Override
    public boolean execute(CommandSender sender, String alias, String[] args) {
        if(args.length == 0){
            if(sender instanceof Player){
                Player player = (Player) sender;
                if(player.hasPermission(Permissions.get().getString("Permissions.Solve"))){
                    player.openInventory(GUIReportList.reports(player, 1));
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
