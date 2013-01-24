/*
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
 * DummyPlayers.java Created by: Nahuel Barrios: 16/03/2012, 04:51:22.
 */
package com.nbempire.android.magicannotator;

import com.nbempire.android.magicannotator.domain.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract type to generate lists of players for different tests.
 * <p/>
 * <b>Important: It's only for test.</b>
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public abstract class DummyPlayers {

    public static List<Player> forTruco4() {
        List<Player> players = new ArrayList<Player>();
        players.add(new Player("Nahuel"));
        players.add(new Player("Fer"));
        players.add(new Player("Mati"));
        players.add(new Player("Emi"));
        return players;
    }

    public static List<Player> forTruco6() {
        List<Player> players = new ArrayList<Player>();
        players.add(new Player("Nahuel"));
        players.add(new Player("Fer"));
        players.add(new Player("Clausi"));
        players.add(new Player("Mati"));
        players.add(new Player("Emi"));
        players.add(new Player("Franco"));
        return players;
    }

    public static List<Player> forTute3() {
        List<Player> players = new ArrayList<Player>();
        players.add(new Player("Nahuel"));
        players.add(new Player("Fer"));
        players.add(new Player("Mati"));
        return players;
    }

    public static List<Player> forTute6() {
        List<Player> players = new ArrayList<Player>();
        players.add(new Player("Nahuel"));
        players.add(new Player("Fer"));
        players.add(new Player("Mati"));
        players.add(new Player("Emi"));
        players.add(new Player("Franco"));
        players.add(new Player("Andres"));
        return players;
    }

    public static List<Player> forTute7() {
        List<Player> players = new ArrayList<Player>();
        players.add(new Player("Nahuel"));
        players.add(new Player("Fer"));
        players.add(new Player("Mati"));
        players.add(new Player("Emi"));
        players.add(new Player("Franco"));
        players.add(new Player("Andres"));
        players.add(new Player("Clausi"));
        return players;
    }

    public static List<Player> forTute8() {
        List<Player> players = new ArrayList<Player>();
        players.add(new Player("Nahuel"));
        players.add(new Player("Fer"));
        players.add(new Player("Mati"));
        players.add(new Player("Emi"));
        players.add(new Player("Franco"));
        players.add(new Player("Andres"));
        players.add(new Player("Clausi"));
        players.add(new Player("Gerard"));
        return players;
    }

}
