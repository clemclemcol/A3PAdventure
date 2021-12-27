import java.util.HashMap;
import java.util.Set;

/**
 * @author COLNOT Clemence
 * @version 2021.12.15
 */

public class Room {
    private String aDescription;
    private HashMap<String, Room> aExits;
    private HashMap<String, Door> aDoors;
    private String aImageName;
    private ItemList aItems;

    /**
     * Room Constructor
     *
     * @param String pDescription, String pImage
     */
    public Room(final String pDescription, final String pImage) {
        this.aDescription = pDescription;
        this.aExits = new HashMap<String, Room>();
        this.aItems = new ItemList();
        this.aImageName = pImage;
        this.aDoors = new HashMap<String, Door>();

    }// Room

    /**
     * Search in the HashMap if this Item have been taken
     *
     * @return HashMap<String, Item> aItems
     */
    public ItemList getItemList() {
        return this.aItems;
    }// getItems

    /**
     * Search in the HashMap if this Item have been taken
     *
     * @param Item pItem
     */
    public void setItemList(final Item pItem) {
        this.aItems.addItem(pItem);
    }// getItems

    /**
     * Return the Name of the associated image
     *
     * @return String aImageName
     */
    public String getImageName() {
        return this.aImageName;
    }// getNameImage

    /**
     * Setter Room Exits
     *
     * @param String pName, Room pNextRoom
     */
    public void setExits(final String pName, final Room pNextRoom) {
        this.aExits.put(pName, pNextRoom);
    }// setExits

    /**
     * Getter Room Exit
     *
     * @param String pDirection
     * @return Room aExits
     */
    public Room getExit(final String pDirection) {
        return this.aExits.get(pDirection);
    }// getExits

    /**
     * Setter Door
     *
     * @param String pName, Door pDoor
     */
    public void setDoor(final String pName, final Door pDoor) {
        this.aDoors.put(pName, pDoor);
    }// setDoors

    /**
     * Getter Door Door
     *
     * @param String pDirection
     * @return Door aDoors
     */
    public Door getDoor(final String pDirection) {
        return this.aDoors.get(pDirection);
    }// geDoor

    /**
     * Getter Doors
     *
     * @return Door aDoors
     */
    public HashMap<String, Door> getDoors() {
        return this.aDoors;
    }// geDoors

    /**
     * Getter Room description
     *
     * @return aDescription
     */
    public String getShortDescription() {
        return this.aDescription;
    }// getDescription

    /**
     * Return the description and the exits
     *
     * @return String description + exits
     */
    public String getLongDescription() {
        return "You are " + this.aDescription + " " + this.getExitsString();
    }// getLongDescription

    /**
     * Get Exits String
     *
     * @return String Exits
     */
    public String getExitsString() {
        StringBuilder vExits = new StringBuilder("\n   Exits:");
        Set<String> keys = this.aExits.keySet();
        for (String vExit : keys) {
            vExits.append("     " + vExit);
        }
        return vExits.toString();
    }// getExitsString

    /**
     * Print exits
     */
    public void printExits() {
        System.out.println(this.getExitsString());

    }// printExits


} // Room
