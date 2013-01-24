/*
 * Magic Annotator - The only thing you need to write down whatever you want.
 * Copyright (C) 2013 Nahuel Barrios <barrios.nahuel@gmail.com>.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * PlayerServiceImpl.java Created by: Nahuel Barrios: 23/03/2012, 05:42:19.
 */
package com.nbempire.android.magicannotator.service.impl;

import android.database.sqlite.SQLiteDatabase;
import com.nbempire.android.magicannotator.dao.PlayerDao;
import com.nbempire.android.magicannotator.dao.impl.PlayerDaoImpl;
import com.nbempire.android.magicannotator.domain.Player;
import com.nbempire.android.magicannotator.service.PlayerService;

import java.util.ArrayList;
import java.util.List;

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
