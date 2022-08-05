package cardizadev.com.reportking.Utils;

import org.bukkit.ChatColor;

public class ColorParser {
    public static String parseColor(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
