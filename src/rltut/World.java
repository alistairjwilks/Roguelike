package rltut;

import java.awt.*;

public class World {
    private Tile[][] tiles;

    private int width;
    public int getWidth(){
        return width;
    }

    private int height;
    public int getHeight(){
        return height;
    }

    public World(Tile[][] tiles){
        this.tiles = tiles;
        this.width = tiles.length;
        this.height = tiles[0].length;
    }

    public Tile tile(int x, int y){
        if (x<0 || x>=width || y<0 || y>=height)
            return Tile.BOUNDS;
        return tiles[x][y];
    }

    public void dig(int x, int y){
        if( tile(x,y).isDiggable())
            tiles[x][y] = Tile.FLOOR;
    }

    public char glyph(int x, int y){
        return tile(x,y).glyph;
    }
    public Color color(int x, int y){
        return tile(x,y).color;
    }

    public void addAtEmptyLocation(Creature creature) {
        int x;
        int y;

        do{ // find an empty place
            x = (int) (Math.random() * width);
            y = (int) (Math.random() * height);
        } while (!tile(x,y).isGround() );

        creature.x = x;
        creature.y = y;
    }


}
