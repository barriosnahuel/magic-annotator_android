/**
 * InvalidNumberOfTeamsException.java Created by: Nahuel Barrios: 17/03/2012, 10:00:25.
 */
package com.nbempire.android.magicannotator.domain.exception;

/**
 * TODO : JavaDoc : for InvalidNumberOfSelectedPlayersException.
 * 
 * @author Nahuel Barrios.
 * @version 1.0.
 * @since 17/03/2012, 10:00:25.
 */
public class InvalidNumberOfSelectedPlayersException extends UserException {

    /**
     * @author Nahuel Barrios.
     */
    private static final long serialVersionUID = -5977853697613041011L;

    /**
     * A constructor method for the {@link InvalidNumberOfSelectedPlayersException} type.
     * 
     * @author Nahuel Barrios.
     * @since 17/03/2012.
     * @param guiMessage
     */
    public InvalidNumberOfSelectedPlayersException(String guiMessage) {
        super(guiMessage);
    }

}
