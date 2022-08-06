package cardizadev.com.reportking.commands;

import cardizadev.com.reportking.files.Commands;
import cardizadev.com.reportking.files.Permissions;
import cardizadev.com.reportking.files.Translation;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;

import java.util.ArrayList;

public class RkReportedPlayers extends BukkitCommand {

    public RkReportedPlayers(String name) {
        super(name);
        this.description = Translation.get().getString("Description.ReportedPlayers");
        this.usageMessage = "/" + Commands.get().getString("Commands.ReportedPlayers");// + " <player>";
        this.setPermission(Permissions.get().getString("Permissions.ReportedPlayers"));
        this.setAliases(new ArrayList<String>());
    }

    @Override
    public boolean execute(CommandSender sender, String alias, String[] args) {
        return true;
    }
}
