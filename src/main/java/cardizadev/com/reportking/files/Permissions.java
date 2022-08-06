package cardizadev.com.reportking.files;

import cardizadev.com.reportking.utils.ColorParser;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Permissions {
    private static File file;

    private static FileConfiguration customFile;

    public static void setup() {
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("ReportKing").getDataFolder(), "Permissions.yml");
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
            System.out.println(ColorParser.parseColor(Translation.get().getString("Files.PermissionsSaveFailed")));
        }
    }

    public static void reload() {
        customFile = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
    }

    public static void addDefaults() {
        setup();
        get().addDefault("Permissions", "");
        get().addDefault("Permissions.Help", "rk.help");
        get().addDefault("Permissions.ReportedPlayers", "rk.list");
        get().addDefault("Permissions.Reload", "rk.reload");
        get().addDefault("Permissions.Report", "rk.report");
        get().addDefault("Permissions.Solve", "rk.solve");
        get().options().copyDefaults(true);
        save();
    }
}
