/**
 * @author COLNOT Clemence
 * @version 2021.12.15
 */

public class Game {
    private UserInterface aGui;
    private GameEngine aEngine;

    /**
     * Game Constructor
     */
    public Game() {
        this.aEngine = new GameEngine();
        this.aGui = new UserInterface(this.aEngine);
        this.aEngine.setGUI(this.aGui);
    }// Game

    /**
     * Quit
     *
     * @param Command pCommand
     * @return boolean
     */
    private boolean quit(final Command pCommand) {
        if (pCommand.hasSecondWord()) {
            System.out.println("Quit what??");
            return false;
        } else return true;

    }// quit

} // Game
