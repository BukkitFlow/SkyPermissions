package de.danielflow.project.SkyPermissions.Handlers;

import java.util.List;

import org.bukkit.entity.Player;

public interface IUser {

    Integer getKills();

    Integer getDeaths();

    Double getMoney();

    Player getPlayer();

    boolean isOnline();

    boolean hasAccount();
    
    String getName();

    void createAccount();

    boolean isNew();
}
