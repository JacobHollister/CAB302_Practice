import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Block {

    protected MazeWall wallNorth;
    protected MazeWall wallSouth;
    protected MazeWall wallEast;
    protected MazeWall wallWest;
    protected final int[] location;
    protected final int blockIndex;
    public JLabel label;
    /**
     * Constructs and initialises new Block
     * @param location int[x,y] x,y location of block on maze
     */
    public Block(int[] location, int blockIndex)
    {
        this.location = location;
        this.blockIndex = blockIndex;
        wallEast = new MazeWall();
        wallSouth = new MazeWall();
        this.label = getLabel();
    }

    /**
     * Returns location of block in maze
     * @return blocks location int[x,y]
     */
    public int[] getLocation(){
        return location;
    }

    /**
     * Returns Wall object of north facing wall
     * @return north Wall object
     */
    public MazeWall getWallNorth() {
        return wallNorth;
    }

    /**
     * Returns Wall object of south facing wall
     * @return south Wall object
     */
    public MazeWall getWallSouth() {
        return wallSouth;
    }

    /**
     * Returns Wall object of east facing wall
     * @return east Wall object
     */
    public MazeWall getWallEast() {
        return wallEast;
    }

    /**
     * Returns Wall object of west facing wall
     * @return west Wall object
     */
    public MazeWall getWallWest() {
        return wallWest;
    }

    /**
     * Sets Wall object of north facing wall
     * @param wallNorth north facing wall
     */
    public void setWallNorth(MazeWall wallNorth) {
        this.wallNorth = wallNorth;
    }

    /**
     * Sets Wall object of south facing wall
     * @param wallSouth south facing wall
     */
    public void setWallSouth(MazeWall wallSouth) {
        this.wallSouth = wallSouth;
    }

    /**
     * Sets Wall object of east facing wall
     * @param wallEast east facing wall
     */
    public void setWallEast(MazeWall wallEast) {
        this.wallEast = wallEast;
    }

    /**
     * Sets Wall object of west facing wall
     * @param wallWest west facing wall
     */
    public void setWallWest(MazeWall wallWest) {
        this.wallWest = wallWest;
    }

    /**
     * Returns the blocks Arraylist index
     * @return blocks Arraylist index
     */
    public int getBlockIndex() {
        return blockIndex;
    }

    public JLabel getLabel(){
        String locationString = location[0] + " - " + location[1];
        JLabel blockLabel = new JLabel(locationString);
        blockLabel.setHorizontalAlignment(SwingConstants.CENTER);
        Border border = BorderFactory.createMatteBorder(1,1,1,1, Color.black);
        blockLabel.setBorder(border);

        return blockLabel;
    }

    public void setSouthWall(){
        Border southBorder = BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0,0,3,0, Color.blue),
                BorderFactory.createMatteBorder(1,1,0,1, Color.black)
        );
        label.setBorder(southBorder);
    }

    public void setNorthWall(){
        Border northBorder = BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(3,0,0,0, Color.blue),
                BorderFactory.createMatteBorder(0,1,1,1, Color.black)
        );
        label.setBorder(northBorder);
    }

    public void setWestWall(){
        Border westBorder = BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0,3,0,0, Color.blue),
                BorderFactory.createMatteBorder(1,0,1,1, Color.black)
        );
        label.setBorder(westBorder);
    }

    public void setEastWall(){
        Border eastBorder = BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0,0,0,3, Color.blue),
                BorderFactory.createMatteBorder(1,1,1,0, Color.black)
        );
        label.setBorder(eastBorder);
    }

    public void resetWalls(){
        Border border = BorderFactory.createMatteBorder(1,1,1,1, Color.black);
        label.setBorder(border);
    }
}