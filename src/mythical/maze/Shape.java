package mythical.maze;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Parent class for the shape objects of the game.
 * @author Richard Dong
 */
public class Shape 
{  
    public int xPos,yPos,level;
    private ArrayList<Block>blockList = new ArrayList<>();
    private ArrayList<Block>occupy;
    
    /**
     * Gets three integer values x, y, l and public integers xPos, yPos and level to these values, respectively.
     * @param x the integer value to be represented by xPos.
     * @param y the integer value to be represented by yPos.
     * @param l the integer value to be represented by level.
     */
    public Shape(int x, int y, int l)
    {
        xPos = x;
        yPos = y;
        level = l;
    }

    /**
     * Draws the shape.
     * @param g the <code>Graphics</code> to paint to
     * @param boardSizeX an integer that represents the horizontal length of the grid.
     * @param boardSizeY an integer that represents the vertical length of the grid.
     * @param offsetX an integer that represents the space between blocks.
     * @param rightBound an integer that represents right boundary in blocks.
     */
    public void drawShape(Graphics g, int boardSizeX, int boardSizeY, int offsetX, int rightBound)
    {
        for(Block b:blockList)
        {
            b.drawBlock(g,level,boardSizeX,boardSizeY,offsetX, rightBound);
        }
    }

    /**
     * Moves each block of the shape down and adds one to yPos.
     */
    public void moveDown()
    {
        yPos+=1;
        for(Block b:blockList)
        {
            b.setY(b.getY()+1);
        }
    }
    
    /**
     * Moves each block of the shape up and subtracts one from yPos.
     */
    public void moveUp()
    {
        yPos-=1;
        for(Block b:blockList)
        {
            b.setY(b.getY()-1);
        }
    }
    
    /**
     * Moves each block of the shape to the right and adds one to xPos.
     */
    public void moveRight()
    {
        xPos+=1;
        for(Block b:blockList)
        {
            b.setX(b.getX()+1);
        }     
    }

    /**
     * Moves each block of the shape to the left and subtracts one from xPos.
     */
    public void moveLeft()
    {
        xPos-=1;
        for(Block b:blockList)
        {
            b.setX(b.getX()-1);
        }
    }

    /**
     * Rotates each block of the shape clockwise.
     */
    public void rotateClockwise() {
        for(Block b:blockList)
        {
            //each block is translated with respect to the center of the shape.
            int xDistance = b.getX()-xPos;//distance to center
            int yDistance = b.getY()-yPos;//distance to center
            b.setX(xPos-yDistance-1);//-1 offsets due to block size
            b.setY(yPos+xDistance);
            b.rotateClockwise();
        }
        
    }

    /**
     * Rotates each block of the shape counterclockwise.
     */
    public void rotateCounterClockwise() {
        for(Block b:blockList)
        {
            //same logical rules apply as above, only in reverse.
            int xDistance = b.getX()-xPos;
            int yDistance = b.getY()-yPos;
            b.setX(xPos+yDistance);
            b.setY(yPos-xDistance-1);
            b.rotateCounterClockwise();
        }        
    }

    /**
     * Returns the <code>ArrayList</code> of the blocks of the shape rotated counterclockwise
     * but does not actually rotate the blocks counterclockwise.
     * @return occupy an <code>ArrayList</code> of the blocks of the shape if the shape was rotated.
     */
    public ArrayList<Block>getClockwiseOccupied()
    {
        occupy = new ArrayList<>();
        for(Block b:blockList)
        {
            int xDistance = b.getX()-xPos;
            int yDistance = b.getY()-yPos;
            occupy.add(new Block(xPos-yDistance-1,yPos+xDistance));
        }
        return occupy;
    }

    /**
     * Returns the <code>ArrayList</code> of the blocks of the shape rotated clockwise
     * but does not actually rotate the blocks clockwise
     * @return occupy an <code>ArrayList</code> of the blocks of the shape if the shape was rotated.
     */
    public ArrayList<Block>getCounterClockwiseOccupied()
    {
        occupy = new ArrayList<>();
        for(Block b:blockList)
        {
            int xDistance = b.getX()-xPos;
            int yDistance = b.getY()-yPos;
            occupy.add(new Block(xPos+yDistance,yPos-xDistance-1));
        }
        return occupy;
    }

    /**
     * Returns the <code>ArrayList</code> of the blocks that the shape is composed of.
     * @return blockList an <code>ArrayList</code> of the blocks that shape is composed of.
     */
    public ArrayList<Block> getBlockList()
    {
        return blockList;
    }
}
