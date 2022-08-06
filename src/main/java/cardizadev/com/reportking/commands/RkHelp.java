package cardizadev.com.reportking.commands;

import cardizadev.com.reportking.files.Commands;
import cardizadev.com.reportking.files.Permissions;
import cardizadev.com.reportking.files.Translation;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;

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
        return true;
    }
}