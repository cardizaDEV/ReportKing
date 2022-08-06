package cardizadev.com.reportking.commands;

import cardizadev.com.reportking.files.Commands;
import cardizadev.com.reportking.files.Permissions;
import cardizadev.com.reportking.files.Translation;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;

import java.util.ArrayList;

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
        return true;
    }
}
