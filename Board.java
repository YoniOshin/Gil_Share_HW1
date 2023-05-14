import java.util.Arrays;

public class Board {
    public Tile[][] tiles;
    protected int rows;
    protected int columns;


    public Board(Tile[][] tiles, int rows, int columns ){
        this.tiles = tiles;
        this.rows = rows;
        this.columns = columns;
    }


    /**
     * Constructor for String input.
     */
    public Board(String boardString) {
        char someChar = '|';
        this.rows = 1;
        for (int i = 0; i < boardString.length(); i++) {
            if (boardString.charAt(i) == someChar) {
                this.rows++;
            }
        }
        String[] boardStringArray = boardString.split(" ");
        int maxTile = 0;
        for (int i = 0; i < boardStringArray.length; i++) {
            if (!boardStringArray[i].equals("|") && !boardStringArray[i].equals("_")) {
                if (maxTile < Integer.parseInt(boardStringArray[i])) {
                    maxTile = Integer.parseInt(boardStringArray[i]);
                } else {
                    i++;
                }
            }
        }
        this.columns = ((maxTile) + 1) / this.rows;
        Tile[][] board = new Tile[this.rows][columns];

        for (int j = 0; j < this.rows; ) {
            for (int i = 0; i < this.columns; ) {

                if (boardStringArray[i].equals("|")) {
                    j++;
                } else if (boardStringArray[i].equals("_")) {
                    board[j][i] = new Tile(boardStringArray[i]);
                    i++;
                    if (rows == 1 && i == columns) {
                        j++; }
                } else {
                    board[j][i] = new Tile(boardStringArray[i]);
                    i++;
                    if (rows == 1 && i == columns) {
                        j++; }
                }
            }
        }
        this.tiles = board;
    }
    public int[] emptyFinder(){
        int[] coordinates = new int[2];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (tiles[i][j].value == (0)) {
                    coordinates[0] = i;
                    coordinates[1] = j;
                }
            }
            return coordinates;
        }
        return null;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Board)) {
            return false;
        }
        Board board = (Board) other;
        return Arrays.deepEquals(tiles, board.tiles);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(tiles);
    }
}

