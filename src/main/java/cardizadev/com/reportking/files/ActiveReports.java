package cardizadev.com.reportking.files;

import cardizadev.com.reportking.utils.ColorParser;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ActiveReports {
    private static File file;

    private static FileConfiguration customFile;

    public static void setup() {
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("ReportKing").getDataFolder(), "ActiveReports.yml");
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
            System.out.println(ColorParser.parseColor(Translation.get().getString("Files.ActiveReportsSaveFailed")));
        }
    }

    public static void reload() {
        customFile = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
    }
}