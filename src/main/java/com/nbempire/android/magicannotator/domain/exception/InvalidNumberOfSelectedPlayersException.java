/**
 * InvalidNumberOfTeamsException.java Created by: Nahuel Barrios: 17/03/2012, 10:00:25.
 */
package com.nbempire.android.magicannotator.domain.exception;

/**
 * TODO : JavaDoc : for InvalidNumberOfSelectedPlayersException.
 *
 * @author Nahuel Barrios.
 * @since 1.0
 */
public class InvalidNumberOfSelectedPlayersException extends UserException {

    /**
     * The serialVersionUID of this class.
     */
    private static final long serialVersionUID = -5977853697613041011L;

    /**
     * A constructor method for the {@link InvalidNumberOfSelectedPlayersException} type.
     *
     * @param guiMessage
     *         {@link String} with message for user.
     *
     * @since 1.0
     */
    public InvalidNumberOfSelectedPlayersException(String guiMessage) {
        super(guiMessage);
    }

}
