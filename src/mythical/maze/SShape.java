package mythical.maze;

/**
 * Object class for creating "S" shapes.
 * @author Richard Dong
 */
public class SShape extends Shape
{   
    /**
     * Creates a "S" shape.
     * @param x an integer that represents the x coordinate.
     * @param y an integer that represents the y coordinate.
     * @param l an integer that represents the level the user is currently on.
     * @see Shape
     */
    public SShape(int x, int y, int l)
    {
        super(x,y,l);
        this.getBlockList().add(new Block(x,y-1,true,false,false,true));
        this.getBlockList().add(new Block(x+1,y-1,true,false,true,false));
        this.getBlockList().add(new Block(x-1,y,true,false,true,false));
        this.getBlockList().add(new Block(x,y,false,true,true,false));   
        //shape appears below with coordinate labels.
        //         ______________
        //        |(x,    (x+1,
        //        | y-1)   y)
        //  ______|       _______
        //  (x-1,  (x,y) |
        //     y)        |
        //  _____________|
    } 
}
