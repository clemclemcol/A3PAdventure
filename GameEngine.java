import java.util.HashMap;
import java.util.Set;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author COLNOT Clémence
 * @version 2021.12.15
 */
public class GameEngine {
    private Parser aParser;
    private Player aPlayer;
    private HashMap aRooms;
    private UserInterface aGui;

    /**
     * GameEngine Constructor
     */
    public GameEngine() {
        this.aParser = new Parser();
        this.createRooms();
    }

    /**
     * Set the value of the User Interface
     *
     * @param UserInterface pUserInterface
     */
    public void setGUI(final UserInterface pUserInterface) {
        this.aGui = pUserInterface;
        this.printWelcome();
    }// setGUI

    /**
     * Print Welcome message
     */
    private void printWelcome() {
        this.aGui.println("");
        this.aGui.println("Welcome to Surviving History!");
        this.aGui.println("Surviving History is a new, incredibly boring adventure game.");
        this.aGui.println("Type 'help' if you need help.");
        this.aGui.println("");
        this.printLocationInfos();
        if (this.aPlayer.getCurrentRoom().getImageName() != null)
            aGui.showImage(this.aPlayer.getCurrentRoom().getImageName());

    }// printWelcome

    /**
     * Create Rooms
     */
    private void createRooms() {

        this.aRooms = new HashMap<String, Room>();

        Room vBastille = new Room("in the court yard of the Bastille.", "Images/bastille.jpg");
        Room vCelluleBastille = new Room("locked a cell of the Bastille.", "Images/cachot.jpg");
        Room vLouvre = new Room("in front of the castle of the Louvre.", "Images/louvres.jpg");
        Room vJardinTuileries = new Room("on the walking path of the Tuileries.", "Images/jardinTuileries.jpg");
        Room vIleCite = new Room("near the Seine on the City Isle.", "Images/ileCite.jpg");
        Room vNotreDame = new Room("in Notre Dame", "Images/notreDame.jpg");
        Room vSorbonne = new Room("in front of the Sorbonne's building.", "Images/sorbonne.jpg");
        Room vLuxembourg = new Room("by the Luxembourg gardens.", "Images/jardinLuxembourg.jpg");
        Room vHotelInvalides = new Room("in the Hotel's lobby.", "Images/invalides.jpg");
        Room vSalpetriere = new Room("by the Salpetriere's front desk.", "Images/salpetriere.jpg");
        Room vObservatoire = new Room("at the top of the Observatory.", "Images/observatoire.jpeg");
        Room vCatacombes = new Room("in the Catacombes' gallery.", "Images/catacombes.jpg");
        Room vPalaisVersailles = new Room("in front of the royal castle.", "Images/palaisVersailles.jpg");
        Room vGallerieGlasses = new Room("in the glass coridor.", "Images/galerieGlaces.jpg");
        Room vCouloirChambre = new Room("in the bedrooms' coridor.", "Images/couloir.jpg");
        Room vChambreReine = new Room("in the Queen's bedroom.", "Images/chambreReine.jpg");
        Room vChambreRoi = new Room("in the King's bedroom.", "Images/chambreRoi.jpg");
        Room vSouterrainVersailles = new Room("in the Palace's undergrounds.", "Images/souterrainVersailles.jpg");
        Room vJardinVersailles = new Room("by the Appollo fountain of Versailles.", "Images/jardinVersailles.jpg");


        vCelluleBastille.setExits("up", vBastille);

        vBastille.setExits("west", vLouvre);
        vBastille.setExits("down", vCelluleBastille);

        vLouvre.setExits("south", vLuxembourg);
        vLouvre.setExits("east", vBastille);
        vLouvre.setExits("west", vJardinTuileries);
        vLouvre.setExits("south-east", vIleCite);

        vJardinTuileries.setExits("south", vHotelInvalides);
        vJardinTuileries.setExits("east", vLouvre);

        vIleCite.setExits("north-west", vLouvre);
        vIleCite.setExits("south", vSorbonne);
        vIleCite.setExits("east", vNotreDame);

        vNotreDame.setExits("west", vIleCite);

        vSorbonne.setExits("north", vIleCite);
        vSorbonne.setExits("south-east", vSalpetriere);
        vSorbonne.setExits("west", vLuxembourg);

        vLuxembourg.setExits("north", vLouvre);
        vLuxembourg.setExits("south", vObservatoire);
        vLuxembourg.setExits("east", vSorbonne);
        vLuxembourg.setExits("west", vHotelInvalides);

        vHotelInvalides.setExits("north", vJardinTuileries);
        vHotelInvalides.setExits("east", vLuxembourg);

        vSalpetriere.setExits("west", vObservatoire);
        vSalpetriere.setExits("north-west", vSorbonne);

        vObservatoire.setExits("north", vLuxembourg);
        vObservatoire.setExits("south", vCatacombes);
        vObservatoire.setExits("east", vSalpetriere);

        vCatacombes.setExits("north", vObservatoire);
        vCatacombes.setExits("west", vSouterrainVersailles);

        vSouterrainVersailles.setExits("east", vCatacombes);
        vSouterrainVersailles.setExits("up", vPalaisVersailles);

        vPalaisVersailles.setExits("west", vJardinVersailles);
        vPalaisVersailles.setExits("up", vGallerieGlasses);
        vPalaisVersailles.setExits("down", vSouterrainVersailles);

        vGallerieGlasses.setExits("up", vCouloirChambre);
        vGallerieGlasses.setExits("down", vPalaisVersailles);

        vCouloirChambre.setExits("east", vChambreRoi);
        vCouloirChambre.setExits("west", vChambreReine);
        vCouloirChambre.setExits("down", vGallerieGlasses);

        vChambreRoi.setExits("west", vCouloirChambre);
        vChambreReine.setExits("east", vCouloirChambre);


        Item vCellKey = new Item("key", "Big rusted key", 3);
        vCelluleBastille.setItemList(vCellKey);

        vBastille.setItemList(new Item("fire", "This is a fire pit", 1));

        vLouvre.setItemList(new Item("note", "Path to the Versailles' Castle: down, west, west, east, up, west, east, down, east, up.", 11));

        vNotreDame.setItemList(new Item("candle", "Long white candle stick", 1));

        vChambreRoi.setItemList(new Item("instructions", "How to make gun powder: blend salpetre, soufre and wood coal. Watch out for explosition!", 10));

        vObservatoire.setItemList(new Item("gardeningBook", "Salpetre is found in fertilizer.", 10));
        vObservatoire.setItemList(new Item("geologyBook", "Sulfur can be found in deep grounds.", 10));
        vObservatoire.setItemList(new Item("dictionnary", "Coal is made by burnt wood.", 10));

        vJardinTuileries.setItemList(new Item("salpetre", "Piece of fertilizer", 1));

        vCatacombes.setItemList(new Item("sulfur", "A piece of durt", 1));

        vHotelInvalides.setItemList(new Item("coal", "Remains of a wood fire", 1));

        vSalpetriere.setItemList(new Item("cookie", "Magic cookie", 2));


        Door vCelDoor = new Door(true, vCellKey, vBastille, vCelluleBastille);
        Door vChambreReineDoor = new Door(false, vCellKey, vCouloirChambre, vChambreReine, true, false);

        vBastille.setDoor("down", vCelDoor);
        vCelluleBastille.setDoor("up", vCelDoor);

        vChambreReine.setDoor("east", vChambreReineDoor);
        vCouloirChambre.setDoor("west", vChambreReineDoor);


        this.aPlayer = new Player(vCelluleBastille);


        this.aRooms.put("vBastille", vBastille);
        this.aRooms.put("vCelluleBastille", vCelluleBastille);
        this.aRooms.put("vLouvre", vLouvre);
        this.aRooms.put("vJardinTuileries", vJardinTuileries);
        this.aRooms.put("vIleCite", vIleCite);
        this.aRooms.put("vSorbonne", vSorbonne);
        this.aRooms.put("vLuxembourg", vLuxembourg);
        this.aRooms.put("vHotelInvalides", vHotelInvalides);
        this.aRooms.put("vSalpetriere", vSalpetriere);
        this.aRooms.put("vObservatoire", vObservatoire);
        this.aRooms.put("vCatacombes", vCatacombes);
        this.aRooms.put("vPalaisVersailles", vPalaisVersailles);
        this.aRooms.put("vGallerieGlasses", vGallerieGlasses);
        this.aRooms.put("vCouloirChambre", vCouloirChambre);
        this.aRooms.put("vChambreReine", vChambreReine);
        this.aRooms.put("vChambreRoi", vChambreRoi);
        this.aRooms.put("vSouterrainVersailles", vSouterrainVersailles);
        this.aRooms.put("vJardinVersailles", vJardinVersailles);

    }// createRooms

    /**
     * Interpret Command
     *
     * @param String pCommandLine
     */
    public void interpretCommand(final String pCommandLine) {
        this.aGui.println("> " + pCommandLine);
        Command vCommand = this.aParser.getCommand(pCommandLine);

        switch (vCommand.getCommandWord()) {
            case "help":
                this.printHelp();
                return;

            case "go":
                if (!vCommand.hasSecondWord()) {
                    this.aGui.println("Go where?");

                } else {
                    if (this.aPlayer.getNbMoves() < this.aPlayer.getNbMovesMax()) {
                        this.aPlayer.setNbMoves();
                        this.goRoom(vCommand.getSecondWord());
                    } else
                        this.printLost();
                }
                return;

            case "back":
                if (vCommand.hasSecondWord())
                    this.aGui.println("Didn't you mean back?");
                else {
                    if (this.aPlayer.getNbMoves() < this.aPlayer.getNbMovesMax()) {
                        this.aPlayer.setNbMoves();
                        this.back(vCommand);
                    } else
                        this.printLost();
                }
                return;

            case "quit":
                if (vCommand.hasSecondWord())
                    this.aGui.println("Quit what?");
                else
                    this.endGame();
                return;

            case "look":
                if (!vCommand.hasSecondWord())
                    this.printLocationInfos();
                else
                    this.look(vCommand.getSecondWord());
                return;

            case "eat":
                if (vCommand.hasSecondWord())
                    this.eat(vCommand.getSecondWord());
                else
                    this.aGui.println("What do you want to eat?");
                return;

            case "take":
                if (vCommand.hasSecondWord())
                    this.take(vCommand.getSecondWord());
                else
                    this.aGui.println("Which item do you want to take?");
                return;

            case "drop":
                if (vCommand.hasSecondWord())
                    this.drop(vCommand.getSecondWord());
                else
                    this.aGui.println("Which item do you want to drop?");
                return;

            case "use":
                if (vCommand.hasSecondWord())
                    this.use(vCommand.getSecondWord());
                else
                    this.aGui.println("Which item do you want to use?");
                return;

            case "test":
                if (vCommand.hasSecondWord())
                    this.readTestFile("Commande/" + vCommand.getSecondWord());

                else
                    this.aGui.println("Which file?");
                return;

            case "items":
                if (!vCommand.hasSecondWord())
                    this.printInventory();

                else
                    this.aGui.println("Did you mean items?");
                return;

            case "light":
                if (!vCommand.hasSecondWord())
                    this.light();
                else
                    this.aGui.println("Did you mean light?");
                return;

            case "solve":
                if (vCommand.hasSecondWord())
                    this.solve(vCommand.getSecondWord());
                else
                    this.aGui.println("What is the correct path?");
                return;

            default:
                this.aGui.println("I don't know what you mean...");
                return;
        }

    }// processCommand

    /**
     * Read a Test file
     *
     * @param String pTestFile
     */
    public void readTestFile(final String pFileName) {
        File vFile = new File(pFileName);
        try {
            Scanner vScan = new Scanner(vFile);
            while (vScan.hasNextLine()) {
                String vCommand = vScan.nextLine();
                interpretCommand(vCommand);
            }
        } catch (FileNotFoundException vException) {
            this.aGui.println("File not found.");
        }

    }// readTestFile

    /**
     * changeRoom
     *
     * @param String pDirection
     */
    public void changeRoom(final String pDirection) {
        Room vNextRoom = this.aPlayer.getCurrentRoom().getExit(pDirection);
        this.aPlayer.setPreviousRoom(this.aPlayer.getCurrentRoom(), pDirection);
        this.aPlayer.setCurrentRoom(vNextRoom);
        this.printLocationInfos();
        if (this.aPlayer.getCurrentRoom().getImageName() != null) {
            this.aGui.showImage(this.aPlayer.getCurrentRoom().getImageName());
        }
    }// changeRoom

    /**
     * goRoom change place
     *
     * @param Command pCommand
     */
    private void goRoom(final String pDirection) {
        if (this.aPlayer.getCurrentRoom().getShortDescription().equals("in the Catacombes' gallery.") && pDirection.equals("west")) {
            this.aGui.println("You have to solve the path to go throught the maze. Hope you remember the note from the Louvre.");
            return;
        }
        Room vNextRoom = this.aPlayer.getCurrentRoom().getExit(pDirection);
        Door vNextRoomDoor = this.aPlayer.getCurrentRoom().getDoor(pDirection);
        if (vNextRoom == null) {
            this.aGui.println("There is no door !");
            return;
        }
        if (vNextRoomDoor == null) {
            this.changeRoom(pDirection);
        } else {
            if (vNextRoomDoor.isLocked()) {
                this.aGui.println("This door is locked. You need a key.");
            } else {
                if (((this.aPlayer.getCurrentRoom() == vNextRoomDoor.getRoom1()) && (vNextRoomDoor.isRoom1To2()))
                        || ((this.aPlayer.getCurrentRoom() == vNextRoomDoor.getRoom2()) && (vNextRoomDoor.isRoom2To1()))) {
                    this.changeRoom(pDirection);
                } else {
                    this.aGui.println("The door is trapped.");
                    this.printLost();
                }
            }

        }

    }// goRoom

    /**
     * Print help
     */
    private void printHelp() {
        this.aGui.println("You are lost. You are alone. In the XVII century, only an explosion in the place it all begun can bring you back.");
        this.aGui.println("");
        this.aGui.println("Your command words are :");
        this.aGui.println(this.aParser.showCommands());
    }// printHelp

    /**
     * Print Location infos
     */
    private void printLocationInfos() {
        this.aGui.println(this.aPlayer.getCurrentRoom().getLongDescription());
        this.aGui.println(this.aPlayer.getCurrentRoom().getItemList().getItemsNames());
        this.aGui.println("You are now at the " + this.aPlayer.getCurrentRoom().getImageName().substring(7, this.aPlayer.getCurrentRoom().getImageName().length() - 4));
    }

    /**
     * Print Lost Message
     */
    private void printLost() {
        this.aGui.println("You don't have the strenght to carry on anymore.");
        this.aGui.println("");
        this.aGui.println("Game Over.");
        this.endGame();
    }

    /**
     * Back to the previous place
     *
     * @param Command pCommand
     */
    public void back(final Command pCommand) {
        if (this.aPlayer.getPreviousRooms().empty()) {
            this.aGui.println("There are no previous room.");
        } else {
            Door vDoor = this.aPlayer.getCurrentRoom().getDoor(this.aPlayer.getPreviousRoom().getOppositeDirection(this.aPlayer.getPreviousRoom().getDirection()));
            if (vDoor.isLocked()) {
                this.aGui.println("You are locked.");
            }
            if (!((vDoor.getRoom1() == this.aPlayer.getCurrentRoom() && vDoor.getRoom2() == this.aPlayer.getPreviousRoom().getRoom()) && vDoor.isRoom1To2())
                    || !((vDoor.getRoom2() == this.aPlayer.getCurrentRoom() && vDoor.getRoom1() == this.aPlayer.getPreviousRoom().getRoom()) && vDoor.isRoom2To1())) {
                this.aGui.println("You can't go back.");

            } else {
                this.aPlayer.setCurrentRoom(this.aPlayer.getPreviousRooms().pop().getRoom());
                this.printLocationInfos();
                if (this.aPlayer.getCurrentRoom().getImageName() != null) {
                    this.aGui.showImage(this.aPlayer.getCurrentRoom().getImageName());
                }
            }

        }
    }

    /**
     * Look
     *
     * @param Command pCommand
     */
    public void look(final String pCommand) {
        if (pCommand.equals("items")) {
            this.aGui.println(this.aPlayer.getCurrentRoom().getItemList().getItemsNames());
        } else {
            if (this.aPlayer.getCurrentRoom().getItemList().nameIsInList(pCommand)) {
                this.aGui.println(this.aPlayer.getCurrentRoom().getItemList().getItem(pCommand).getDescription());
            }

        }

    }// look

    /**
     * Eat the magis cookie
     *
     * @param String pCommand
     */
    public void eat(final String pCommand) {
        switch (pCommand) {
            case "cookie":
                if (this.aPlayer.getItemList().getList().containsKey(pCommand)) {
                    this.aGui.println("You've eaten. You've gained strength.");
                    this.aPlayer.getItemList().getList().remove(pCommand);
                    this.aPlayer.setWeightMax(2 * this.aPlayer.getWeightMax());
                } else
                    this.aGui.println("You don't have this item on you.");
                return;

            default:
                this.aGui.println("You shouldn't eat this...");
        }

    }// eat

    /**
     * Take an Item in the Room
     *
     * @param Command pCommand
     */
    public void take(final String pCommand) {
        if (this.aPlayer.getCurrentRoom().getItemList().nameIsInList(pCommand)) {
            Item vItem = this.aPlayer.getCurrentRoom().getItemList().getItem(pCommand);
            if ((vItem.getWeight() + this.aPlayer.getWeight()) <= this.aPlayer.getWeightMax()) {
                this.aPlayer.take(vItem, this.aPlayer.getCurrentRoom());
                this.aGui.println("You took " + vItem.getName());
            } else {
                this.aGui.println(vItem.getName() + " is too heavy for you.\nActual weight : " + this.aPlayer.getWeight() + ", Item weight : " + vItem.getWeight() + ", max portable weight : " + this.aPlayer.getWeightMax());
            }
        } else {
            this.aGui.println("This item is not in the room.");
        }
    }// take

    /**
     * Drop an Item in the Room
     *
     * @param String pCommand
     */
    public void drop(final String pCommand) {
        if (this.aPlayer.getItemList().nameIsInList(pCommand)) {
            Item vItem = this.aPlayer.getItemList().getItem(pCommand);
            this.aPlayer.drop(vItem, this.aPlayer.getCurrentRoom());
            this.aGui.print("You droped ");
            this.aGui.println(vItem.getName());
        } else {
            this.aGui.println("You don't have his item.");
        }
    }// drop

    /**
     * Use an Item in Iventory
     *
     * @param Command pCommand
     */
    public void use(final String pCommand) {
        if (!this.aPlayer.getItemList().nameIsInList(pCommand)) {
            this.aGui.println("This item is not in your inventory.");
            return;
        }
        if (pCommand.equals("key")) {
            this.aPlayer.setWeight(this.aPlayer.getWeight() - this.aPlayer.getItemList().getItem(pCommand).getWeight());
            this.aPlayer.getCurrentRoom().getDoor("up").unlock(this.aPlayer.getItemList());
            this.aPlayer.getItemList().removeItem(this.aPlayer.getItemList().getItem(pCommand));
            this.aGui.println("You used the key. The door up is opened.");
        } else {
            this.aGui.println("You cannot use " + pCommand + " here");
        }
    }// use

    /**
     * Print the inventory
     */
    public void printInventory() {
        this.aGui.println(this.aPlayer.getItemList().getItemsNames());

    }// inventory

    /**
     * Solve the maze path to go to Versailles
     *
     * @param String pCommand
     */
    public void solve(String pCommand) {
        if (this.aPlayer.getCurrentRoom().getShortDescription().equals("in the Catacombes' gallery.")) {
            if (pCommand.equals("down west west east up west east down east up")) {
                this.changeRoom("west");
                this.aGui.println("Well done ! You made it to Versailles!");
            } else {
                this.aGui.println("This is not the correct path to Versailles.");
            }
        } else {
            this.aGui.println("You don't have to solve anything right now.");
        }
    }// solve

    /**
     * Light the gun powder and if the conditions are ticked, end the game
     */
    public void light() {
        if (this.aPlayer.getCurrentRoom().getShortDescription().equals("locked a cell of the Bastille.")) {
            if (this.aPlayer.getItemList().nameIsInList("salpetre") &&
                    this.aPlayer.getItemList().nameIsInList("coal") &&
                    this.aPlayer.getItemList().nameIsInList("sulfur") &&
                    this.aPlayer.getItemList().nameIsInList("fire") &&
                    this.aPlayer.getItemList().nameIsInList("candle")) {
                this.aGui.println("You create the gun powder, and light it whith the lighted candle.");
                this.aGui.println("Well done! The explosion worked ! You are back in your time zone!");
                this.endGame();

            } else {
                this.aGui.println("You don't have what you need to make the gun powder. Look for cluses.");
            }
        } else {
            this.aGui.println("In order to work, the explosion needs to happen in the place you came from.");
        }
    }// light

    /**
     * End game message
     */
    private void endGame() {
        this.aGui.println("Thank you for playing. Good bye.");
        this.aGui.enable(false);
    }// endGame

}
