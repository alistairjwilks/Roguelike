package rltut;

import asciiPanel.AsciiPanel;

import java.awt.*;

public enum Tile {
    FLOOR((char) 250, AsciiPanel.yellow),
    WALL((char) 177, AsciiPanel.yellow),
    BOUNDS('X', AsciiPanel.brightBlack);

    public final char glyph;
    public final Color color;

    Tile (char glyph, Color color){
        this.glyph = glyph;
        this.color = color;
    }

    public boolean isDiggable(){
        return this.equals( Tile.WALL );
    }
    public boolean isGround(){
        return (! (this.equals(Tile.BOUNDS) || this.equals(Tile.WALL)));
    }
}
