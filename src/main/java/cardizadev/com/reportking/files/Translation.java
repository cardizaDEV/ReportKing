package cardizadev.com.reportking.files;

import cardizadev.com.reportking.utils.ColorParser;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Translation {
    private static File file;

    private static FileConfiguration customFile;

    public static void setup() {
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("ReportKing").getDataFolder(), "Translation.yml");
        if (!file.exists())
            try {
                file.createNewFile();
            } catch (IOException iOException) {}
        customFile = (FileConfiguration) YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get() {
        return customFile;
    }

    public static void save() {
        try {
            customFile.save(file);
        } catch (IOException e) {
            System.out.println(ColorParser.parseColor(get().getString("Files.TranslationSaveFailed")));
        }
    }

    public static void reload() {
        customFile = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
    }

    public static void addDefaults() {
        setup();
        get().addDefault("Files", "");
        get().addDefault("Files.ActiveReportsSaveFailed", "&cCouldn't save Translation.yml");
        get().addDefault("Files.CommandsSaveFailed", "&cCouldn't save Reports.yml");
        get().addDefault("Files.PermissionsSaveFailed", "&cCouldn't save Reasons.yml");
        get().addDefault("Files.ReportedPlayersSaveFailed", "&cCouldn't save Reasons.yml");
        get().addDefault("Files.SolutionsSaveFailed", "&cCouldn't save Reasons.yml");
        get().addDefault("Files.SolvedReportsSaveFailed", "&cCouldn't save Reasons.yml");

        get().addDefault("Description", "");
        get().addDefault("Description.Help", "Show ReportKing command list");
        get().addDefault("Description.ReportedPlayers", "Opens the reported players GUI");
        get().addDefault("Description.Reload", "Reload ReportKing config");
        get().addDefault("Description.Report", "Opens the report GUI");
        get().addDefault("Description.Solve", "Opens the existing reports GUI");

        get().addDefault("Permissions","");
        get().addDefault("Permissions.NonPermission","&cYou do not have enough permissions");

        get().addDefault("Defaults","");
        get().addDefault("Defaults.Header","&d&l---------&b&lReportKing&d&l---------");
        get().addDefault("Defaults.Footer","&d&l---------&b&lReportKing&d&l---------");
        get().addDefault("Defaults.Reload","&d&lReloaded successfully");
        get().addDefault("Defaults.NoPlayer","You need to be a player!");
        get().addDefault("Defaults.Back","Back");
        get().addDefault("Defaults.Forward","Forward");
        get().addDefault("Defaults.PlayerReportedSuccessfully","&aThe player has been reported successfully");

        get().addDefault("GUI","");
        get().addDefault("GUI.PlayerList","&bPlayers:");
        get().addDefault("GUI.Reasons","&bReasons:");
        get().addDefault("GUI.ReportsList","&bReports:");
        get().addDefault("GUI.Solutions","&bSolutions:");
        get().addDefault("GUI.Reason","&7Reason: ");
        get().addDefault("GUI.SubmittedBy","&7Who submmited: ");
        get().addDefault("GUI.Time","&7Time: ");


        get().addDefault("ActiveReportsFile","");
        get().addDefault("ActiveReportsFile.Reason","Reason: ");
        get().addDefault("ActiveReportsFile.SubmittedBy","Who submmited: ");
        get().addDefault("ActiveReportsFile.Time","Time: ");
        get().addDefault("ActiveReportsFile.Reported","Reported: ");

        get().addDefault("ReportedPlayersFile","");
        get().addDefault("ReportedPlayersFile.Reports","Reports:");
        get().options().copyDefaults(true);
        save();
    }
}