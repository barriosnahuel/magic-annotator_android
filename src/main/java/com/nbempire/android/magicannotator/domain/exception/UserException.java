/**
 * UserException.java Created by: Nahuel Barrios: 16/03/2012, 05:28:01.
 */
package com.nbempire.android.magicannotator.domain.exception;

/**
 * TODO : JavaDoc : for UserException.
 * 
 * @author Nahuel Barrios.
 * @version 1.0.
 * @since 16/03/2012, 05:28:01.
 */
public class UserException extends Exception {

    /**
     * @author Nahuel Barrios.
     */
    private static final long serialVersionUID = -5860783186065421947L;

    /**
     * {@link String} con el mensaje que se mostrará al usuario.
     */
    protected String guiMessage;

    /**
     * A constructor method for the {@link UserException} type.
     * 
     * @author Nahuel Barrios.
     * @since 16/03/2012.
     * @param detailMessage
     * @param throwable
     */
    public UserException(String detailMessage, Throwable throwable, String guiMessage) {
        super(detailMessage, throwable);
        this.guiMessage = guiMessage;
    }

    /**
     * A constructor method for the {@link UserException} type.
     * 
     * @author Nahuel Barrios.
     * @since 16/03/2012.
     * @param detailMessage
     */
    public UserException(String detailMessage, String guiMessage) {
        super(detailMessage);
        this.guiMessage = guiMessage;
    }

    /**
     * A constructor method for the {@link UserException} type.
     * 
     * @author Nahuel Barrios.
     * @since 16/03/2012.
     * @param throwable
     */
    public UserException(Throwable throwable, String guiMessage) {
        super(throwable);
        this.guiMessage = guiMessage;
    }

    /**
     * A constructor method for the {@link UserException} type.
     * 
     * @author Nahuel Barrios.
     * @since 16/03/2012.
     * @param guiMessage
     */
    public UserException(String guiMessage) {
        super();
        this.guiMessage = guiMessage;
    }

    /**
     * Accessor for the attribute of the entity.
     * 
     * @author Nahuel Barrios.
     * @since 16/03/2012.
     * @return the guiMessage.
     */
    public String getGuiMessage() {
        return guiMessage;
    }

    /**
     * @author Nahuel Barrios.
     * @since 16/03/2012.
     * @param guiMessage
     *            the guiMessage to set.
     */
    public void setGuiMessage(String guiMessage) {
        this.guiMessage = guiMessage;
    }

}
