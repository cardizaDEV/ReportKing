package cardizadev.com.reportking.Files;

import cardizadev.com.reportking.Utils.ColorParser;
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

    public void addDefaults() {
        this.setup();
        this.get().addDefault("Files", "");
        this.get().addDefault("Files.ActiveReportsSaveFailed", "&cCouldn't save Translation.yml");
        this.get().addDefault("Files.CommandsSaveFailed", "&cCouldn't save Reports.yml");
        this.get().addDefault("Files.PermissionsSaveFailed", "&cCouldn't save Reasons.yml");
        this.get().addDefault("Files.ReportedPlayersSaveFailed", "&cCouldn't save Reasons.yml");
        this.get().addDefault("Files.SolutionsSaveFailed", "&cCouldn't save Reasons.yml");
        this.get().addDefault("Files.SolvedReportsSaveFailed", "&cCouldn't save Reasons.yml");
        this.get().options().copyDefaults(true);
        this.save();
    }
}