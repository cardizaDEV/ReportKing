package cardizadev.com.reportking.files;

import cardizadev.com.reportking.utils.ColorParser;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Commands {
    private static File file;

    private static FileConfiguration customFile;

    public static void setup() {
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("ReportKing").getDataFolder(), "Commands.yml");
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
            System.out.println(ColorParser.parseColor(Translation.get().getString("Files.CommandsSaveFailed")));
        }
    }

    public static void reload() {
        customFile = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
    }

    public static void addDefaults() {
        setup();

        get().options().copyDefaults(true);
        save();
    }
}
