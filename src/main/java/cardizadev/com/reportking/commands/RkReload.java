package cardizadev.com.reportking.commands;

import cardizadev.com.reportking.files.*;
import cardizadev.com.reportking.utils.ColorParser;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class RkReload extends BukkitCommand {

    public RkReload(String name) {
        super(name);
        this.description = Translation.get().getString("Description.Reload");
        this.usageMessage = "/" + Commands.get().getString("Commands.Reload");// " <player>";
        this.setPermission(Permissions.get().getString("Permissions.Reload"));
        this.setAliases(new ArrayList<String>());
    }

    @Override
    public boolean execute(CommandSender sender, String alias, String[] args) {
        if(args.length == 0){
            if(sender instanceof Player){
                Player player = (Player) sender;
                if(player.hasPermission(Permissions.get().getString("Permissions.Reload"))){
                    addAllDefaults();
                    player.sendMessage(ColorParser.parseColor(Translation.get().getString("Defaults.Reload")));
                }else{
                    player.sendMessage(ColorParser.parseColor(Translation.get().getString("Permissions.NonPermission")));
                }
            }else{
                addAllDefaults();
                System.out.println(ColorParser.parseColor(Translation.get().getString("Defaults.Reload")));
            }
        }
        return true;
    }

    public void addAllDefaults(){
        Translation.addDefaults();
        SolvedReports.addDefaults();
        Solutions.addDefaults();
        ReportedPlayers.addDefaults();
        Reasons.addDefaults();
        Permissions.addDefaults();
        Commands.addDefaults();
        ActiveReports.addDefaults();
    }
}
