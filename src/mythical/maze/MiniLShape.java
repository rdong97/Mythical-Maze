/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mythical.maze;

/**
 * Creates a mini L-shaped block to be used in the grid
 * @author Richard
 */
public class MiniLShape extends Shape{

    /**
    * Gets three integers x, y, l.
    * Uses the integers x and y as the coordinate (x, y) as the beginning point for drawing the shape.
    * Uses l as the integer to represent the level that the user is currently on.
    * @param x an integer that represents the shape's x coordinate
    * @param y an integer that represents the shape's y coordinate
    * @param l an integer that represents the level the user is currently on
    * @see Shape
    */
    public MiniLShape(int x, int y,int l)
    {
        super(x,y,l);
        this.getBlockList().add(new Block(x-1,y-1,false,true,false,true));
        this.getBlockList().add(new Block(x-1,y,false,false,true,true));
        this.getBlockList().add(new Block(x,y,true,false,true,false));
    }
}
