package cardizadev.com.reportking.files;

import cardizadev.com.reportking.utils.ColorParser;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Reasons {
    private static File file;

    private static FileConfiguration customFile;

    public static void setup() {
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("ReportKing").getDataFolder(), "Reasons.yml");
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
            System.out.println(ColorParser.parseColor(Translation.get().getString("Files.ReasonsSaveFailed")));
        }
    }

    public static void reload() {
        customFile = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
    }

    public static void addDefaults() {
        setup();
        Reasons.get().addDefault(String.valueOf(0), "");
        Reasons.get().addDefault(String.valueOf(0)+ ".Name", "&4ExampleName");
        Reasons.get().addDefault(String.valueOf(0)+ ".Item", "IRON_SWORD");
        Reasons.get().addDefault(String.valueOf(0)+ ".Description", "ExampleDescription");
        for (int slot = 1; slot < 54; slot++) {
            Reasons.get().addDefault(String.valueOf(slot), "");
            Reasons.get().addDefault(String.valueOf(slot)+ ".Name", "NULL");
            Reasons.get().addDefault(String.valueOf(slot)+ ".Item", "NULL");
            Reasons.get().addDefault(String.valueOf(slot)+ ".Description", "NULL");
        }
        get().options().copyDefaults(true);
        save();
    }
}