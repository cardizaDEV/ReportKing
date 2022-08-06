package cardizadev.com.reportking.files;

import cardizadev.com.reportking.utils.ColorParser;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Solutions {
    private static File file;

    private static FileConfiguration customFile;

    public static void setup() {
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("ReportKing").getDataFolder(), "Solutions.yml");
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
            System.out.println(ColorParser.parseColor(Translation.get().getString("Files.SolutionsSaveFailed")));
        }
    }

    public static void reload() {
        customFile = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
    }

    public static void addDefaults() {
        setup();
        Solutions.get().addDefault(String.valueOf(0), "");
        Solutions.get().addDefault(String.valueOf(0)+ ".Name", "&4ExampleName");
        Solutions.get().addDefault(String.valueOf(0)+ ".Item", "CARROT");
        Solutions.get().addDefault(String.valueOf(0)+ ".Description", "ExampleDescription");
        Solutions.get().addDefault(String.valueOf(0)+ ".Command", "ban {player}");
        for (int slot = 1; slot < 54; slot++) {
            Solutions.get().addDefault(String.valueOf(slot), "");
            Solutions.get().addDefault(String.valueOf(slot)+ ".Name", "NULL");
            Solutions.get().addDefault(String.valueOf(slot)+ ".Item", "NULL");
            Solutions.get().addDefault(String.valueOf(slot)+ ".Description", "NULL");
            Solutions.get().addDefault(String.valueOf(slot)+ ".Command", "NULL");
        }
        get().options().copyDefaults(true);
        save();
    }
}