package cardizadev.com.reportking.utils;

import org.bukkit.ChatColor;

public class ColorParser {
    public static String parseColor(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
