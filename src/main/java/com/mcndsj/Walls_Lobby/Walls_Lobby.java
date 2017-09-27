package com.mcndsj.Walls_Lobby;

import com.mcndsj.Lobby_Display.Lobby_Display;
import com.mcndsj.Walls_Lobby.kitSystem.KitController;
import com.mcndsj.Walls_Lobby.listeners.PlayerListener;
import com.mcndsj.Walls_Lobby.scoreboard.WallCaller;
import com.mcndsj.Walls_Lobby.serverSelector.ServerSelectorController;
import com.mcndsj.lobby_Control.LobbyControlAPIs;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Matthew on 2016/4/16.
 */
public class Walls_Lobby extends JavaPlugin{


    private ServerSelectorController control;
    private static Walls_Lobby instance;
    private KitController kit;

    public void onEnable(){
        instance = this;
        Lobby_Display.getInstance().getApi().registerBoardCaller(new WallCaller());
        control = new ServerSelectorController();
        kit = new KitController();


        getServer().getPluginManager().registerEvents(new PlayerListener(),this);

        LobbyControlAPIs.registerRestartPort(Config.startingPort);
    }

    public static Walls_Lobby get(){
        return instance;
    }
}
