package rltut;

public class WorldBuilder {
    private int width;
    private int height;
    private Tile[][] tiles;

    public WorldBuilder(int width, int height){
        this.width = width;
        this.height = height;
        this.tiles = new Tile[width][height];
    }

    public World build(){
        return new World(tiles);
    }

    private WorldBuilder randomiseTiles(){
        for (int x=0; x<width; x++){
            for (int y=0; y<height; y++){
                tiles[x][y] = Math.random() < 0.5 ? Tile.FLOOR : Tile.WALL;
            }
        }
        return this;
    }

    private WorldBuilder smooth(int times){
        for (int i = 0; i < times; i++) {

            Tile[][] tiles2 = new Tile[width][height];
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    // count up adjacent walls and floors
                    int floors = 0;
                    int walls = 0;

                    for (int dx = -1; dx < 2; dx++) {
                        for (int dy = -1; dy < 2; dy++) {
                            if (x + dx < 0 || x + dx >= width || y + dy < 0 || y + dy >= height) {
                                //out of bounds -> ignore
                                continue;
                            }
                            if (tiles[x + dx][y + dy].equals(Tile.FLOOR))
                                floors++;
                            else if (tiles[x + dx][y + dy].equals(Tile.WALL))
                                walls++;
                        }

                    }

                    tiles2[x][y] = floors >= walls ? Tile.FLOOR : Tile.WALL;


                }
            }

            tiles = tiles2;
        }
        return this;
    }

    public WorldBuilder makeCaves(){
        return randomiseTiles().smooth(8);
    }

}
