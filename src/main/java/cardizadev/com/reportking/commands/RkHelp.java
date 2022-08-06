package cardizadev.com.reportking.commands;

import cardizadev.com.reportking.files.Commands;
import cardizadev.com.reportking.files.Permissions;
import cardizadev.com.reportking.files.Translation;
import cardizadev.com.reportking.utils.ColorParser;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class RkHelp extends BukkitCommand {

    public RkHelp(String name) {
        super(name);
        this.description = Translation.get().getString("Description.Help");
        this.usageMessage = "/" + Commands.get().getString("Commands.Help");// + " <player>";
        this.setPermission(Permissions.get().getString("Permissions.Help"));
        this.setAliases(new ArrayList<String>());
    }

    @Override
    public boolean execute(CommandSender sender, String alias, String[] args) {
        if(args.length==0){
            if(sender instanceof Player){
                Player player = (Player) sender;
                if(player.hasPermission(Permissions.get().getString("Permissions.Help"))){
                    player.sendMessage(ColorParser.parseColor(Translation.get().getString("Defaults.Header")));
                    player.sendMessage("/" + Commands.get().getString("Commands.Help") + ": " + Translation.get().getString("Description.Help"));
                    player.sendMessage("/" + Commands.get().getString("Commands.Reload") + ": " + Translation.get().getString("Description.Reload"));
                    player.sendMessage("/" + Commands.get().getString("Commands.Report") + " <player>" + ": " + Translation.get().getString("Description.Report"));
                    player.sendMessage("/" + Commands.get().getString("Commands.ReportedPlayers") + ": " + Translation.get().getString("Description.ReportedPlayers"));
                    player.sendMessage("/" + Commands.get().getString("Commands.Solve") + " <player>" + ": " + Translation.get().getString("Description.Solve"));
                    player.sendMessage(ColorParser.parseColor(Translation.get().getString("Defaults.Footer")));
                }else{
                    player.sendMessage(ColorParser.parseColor(Translation.get().getString("Permissions.NonPermission")));
                }
            }else{
                System.out.println(ColorParser.parseColor(Translation.get().getString("Defaults.Header")));
                System.out.println("/" + Commands.get().getString("Commands.Help") + ": " + Translation.get().getString("Description.Help"));
                System.out.println("/" + Commands.get().getString("Commands.Reload") + ": " + Translation.get().getString("Description.Reload"));
                System.out.println("/" + Commands.get().getString("Commands.Report") + " <player>" + ": " + Translation.get().getString("Description.Report"));
                System.out.println("/" + Commands.get().getString("Commands.ReportedPlayers") + ": " + Translation.get().getString("Description.ReportedPlayers"));
                System.out.println("/" + Commands.get().getString("Commands.Solve") + " <player>" + ": " + Translation.get().getString("Description.Solve"));
                System.out.println(ColorParser.parseColor(Translation.get().getString("Defaults.Footer")));
            }
        }
        return true;
    }
}