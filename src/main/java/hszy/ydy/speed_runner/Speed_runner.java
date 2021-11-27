package hszy.ydy.speed_runner;

import org.bukkit.plugin.java.JavaPlugin;

public final  class Speed_runner extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Speedrunner Prepared");
        getServer().getPluginManager().registerEvents(new MyListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("finished");
    }
}
