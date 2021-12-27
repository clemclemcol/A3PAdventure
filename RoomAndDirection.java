
/**
 * Décrivez votre classe RoomAndDirection ici.
 *
 * @author COLNOT Clémence
 * @version 2021.12.22
 */
public class RoomAndDirection {

    private Room aRoom;
    private String aDirection;

    /**
     * Constructeur d'objets de classe RoomAndDirection
     */
    public RoomAndDirection(final Room pRoom, final String pDirection) {
        this.aRoom = pRoom;
        this.aDirection = pDirection;
    }

    /**
     * Get Room
     *
     * @return Room aRoom
     */
    public Room getRoom() {
        return this.aRoom;
    }// getRoom

    /**
     * Get Direction
     *
     * @return String aDirection
     */
    public String getDirection() {
        return this.aDirection;
    }// getDirection


    /**
     * Get opposite Direction
     *
     * @return String
     */
    public String getOppositeDirection(final String pDirection) {
        switch (pDirection) {
            case "north":
                return "south";
            case "south":
                return "north";
            case "east":
                return "west";
            case "west":
                return "east";
            default:
                return "";
        }
    }// getOppositeDirection

}
