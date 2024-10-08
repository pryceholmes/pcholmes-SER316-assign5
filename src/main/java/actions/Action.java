package actions;

public class Action {
    /**
     * The message that will be displayed when the action is used.
     */
    private String message;

    /**
     * Constructor for the Action class.
     * @param message the message to be displayed
     */
    public Action(String message) {
        this.message = message;
    }

    /**
     * Get the message that will be displayed when the action is used.
     * @return the message
     */
    public String getMessage() {
        return message;
    }

}
