package cardizadev.com.reportking;

import cardizadev.com.reportking.files.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        addAllDefaults();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void addAllDefaults(){
        Translation.addDefaults();
        SolvedReports.addDefaults();
        Solutions.addDefaults();
        ReportedPlayers.addDefaults();
        Reasons.addDefaults();
        Permissions.addDefaults();
        Commands.addDefaults();
        ActiveReports.addDefaults();
    }

}
