/**
 * GameService.java Created by: Nahuel Barrios: 16/03/2012, 05:17:29.
 */
package com.nbempire.android.magicannotator.service;

import java.util.List;

import com.nbempire.android.magicannotator.domain.Player;
import com.nbempire.android.magicannotator.domain.Team;
import com.nbempire.android.magicannotator.domain.exception.UserException;
import com.nbempire.android.magicannotator.util.ExpandableList;

/**
 * TODO : JavaDoc : for GameService.
 * 
 * @author Nahuel Barrios.
 * @version 1.0.
 * @since 16/03/2012, 05:17:29.
 */
public interface GameService {

    /**
     * TODO : JavaDoc : for GameService.makeTeams()
     * 
     * @author Nahuel Barrios.
     * @since 20/03/2012.
     * @param players
     * @return
     * @throws UserException
     */
    public abstract List<Team> makeTeams(List<Player> players) throws UserException;

    /**
     * TODO : JavaDoc : for GameService.getExpandableTeams()
     * 
     * @author Nahuel Barrios.
     * @since 24/03/2012.
     * @param teams
     * @return
     */
    public abstract ExpandableList getExpandableTeams(List<Team> teams);

}
