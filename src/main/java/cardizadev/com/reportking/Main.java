package cardizadev.com.reportking;

import cardizadev.com.reportking.events.PlayerListGUIEvents;
import cardizadev.com.reportking.events.ReasonsListGUIEvents;
import cardizadev.com.reportking.commands.*;
import cardizadev.com.reportking.events.ReportListGUIEvents;
import cardizadev.com.reportking.events.SolutionsListGUIEvents;
import cardizadev.com.reportking.files.*;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        addAllDefaults();
        loadCommands();
        registerAllEventListeners();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    public void registerAllEventListeners(){
        getServer().getPluginManager().registerEvents(new PlayerListGUIEvents(),(Plugin) this);
        getServer().getPluginManager().registerEvents(new ReasonsListGUIEvents(),(Plugin) this);
        getServer().getPluginManager().registerEvents(new ReportListGUIEvents(),(Plugin) this);
        getServer().getPluginManager().registerEvents(new SolutionsListGUIEvents(),(Plugin) this);
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

    public void loadCommands(){
        try {
            final Field bukkitCommandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");

            bukkitCommandMap.setAccessible(true);
            CommandMap commandMap = (CommandMap) bukkitCommandMap.get(Bukkit.getServer());

            commandMap.register(Commands.get().getString("Commands.Help"), new RkHelp(Commands.get().getString("Commands.Help")));
            commandMap.register(Commands.get().getString("Commands.ReportedPlayers"), new RkReportedPlayers(Commands.get().getString("Commands.ReportedPlayers")));
            commandMap.register(Commands.get().getString("Commands.Reload"), new RkReload(Commands.get().getString("Commands.Reload")));
            commandMap.register(Commands.get().getString("Commands.Report"), new RkReport(Commands.get().getString("Commands.Report")));
            commandMap.register(Commands.get().getString("Commands.Solve"), new RkSolve(Commands.get().getString("Commands.Solve")));
        }catch (NoSuchFieldException nsfe){
            nsfe.printStackTrace();
        }catch (IllegalAccessException iae){
            iae.printStackTrace();
        }
    }
}
