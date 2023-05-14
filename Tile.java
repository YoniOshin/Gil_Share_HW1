public class Tile {
    protected final int value;

    /**
     * Constructor for String input.
     */
    public Tile(String tile) {
        if (!tile.equals("_")){
            this.value = Integer.parseInt(tile);
        }
        else {
            this.value = 0;
        }
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Tile)) {
            return false;
        }
        Tile tile = (Tile) other;
        return value == tile.value;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }
}