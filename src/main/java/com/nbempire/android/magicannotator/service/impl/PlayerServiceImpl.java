/*
 * Copyright (c) 2012-2013 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * PlayerServiceImpl.java Created by: Nahuel Barrios: 23/03/2012, 05:42:19.
 */
package com.nbempire.android.magicannotator.service.impl;

import java.util.ArrayList;
import java.util.List;

import android.database.sqlite.SQLiteDatabase;
import com.nbempire.android.magicannotator.dao.PlayerDao;
import com.nbempire.android.magicannotator.dao.impl.PlayerDaoImpl;
import com.nbempire.android.magicannotator.domain.Player;
import com.nbempire.android.magicannotator.service.PlayerService;

/**
 * Implementation of the PlayerService interface.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public class PlayerServiceImpl implements PlayerService {

    /**
     * DAO for the Player entity.
     */
    private PlayerDao playerDao;

    /**
     * Constructor method for this PlayerImpl type.
     *
     * @param database
     *         The {@link android.database.sqlite.SQLiteDatabase} to access.
     *
     * @since 13
     */
    public PlayerServiceImpl(SQLiteDatabase database) {
        this.playerDao = new PlayerDaoImpl(database);
    }

    /**
     * Default constructor method for this PlayerImpl type.
     *
     * @since 13
     */
    public PlayerServiceImpl() {
        //  Do nothing.
    }

    public List<Player> createPlayers(List<String> playersToParse) {
        List<Player> players = new ArrayList<Player>(playersToParse.size());
        for (String eachPlayerNickName : playersToParse) {
            players.add(new Player(eachPlayerNickName));
        }
        return players;
    }

    public List<String> getExpandablePlayers(List<Player> players) {
        List<String> result = new ArrayList<String>();
        for (Player eachPlayer : players) {
            result.add(eachPlayer.getNickName());
        }
        return result;
    }

    @Override
    public List<Player> findAll() {
        return playerDao.findAll();
    }

    @Override
    public void save(Player player) {
        playerDao.save(player);
    }

    @Override
    public void deleteAll() {
        playerDao.deleteAll();
    }


}
