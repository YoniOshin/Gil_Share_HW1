public class Action {
    protected Board newBoard;
    protected Board oldBoard;
    protected final Direction movedDirection;
    private Tile movedTile;

    public Action(Board board, Direction direction){
        this.oldBoard = board;
        this.movedDirection = direction;
         Board newBoard = new Board(board.tiles, board.rows, board.columns);
        int[] emptyCoordinates = newBoard.emptyFinder();
        int xEmpty = emptyCoordinates[0];
        int yEmpty = emptyCoordinates[1];
        Tile empty = newBoard.tiles[xEmpty][yEmpty];
        if (direction.equals(Direction.up)){
            this.movedTile = newBoard.tiles[xEmpty+1][yEmpty];
            newBoard.tiles[xEmpty][yEmpty] = newBoard.tiles[xEmpty+1][yEmpty];
            newBoard.tiles[xEmpty+1][yEmpty] = empty;
        }
        if (direction.equals(Direction.down)){
            this.movedTile = newBoard.tiles[xEmpty-1][yEmpty];
            newBoard.tiles[xEmpty][yEmpty] = newBoard.tiles[xEmpty-1][yEmpty];
            newBoard.tiles[xEmpty-1][yEmpty] = empty;
        }
        if (direction.equals(Direction.right)){
            this.movedTile = newBoard.tiles[xEmpty][yEmpty-1];
            newBoard.tiles[xEmpty][yEmpty] = newBoard.tiles[xEmpty][yEmpty-1];
            newBoard.tiles[xEmpty][yEmpty-1] = empty;
        }
        if (direction.equals(Direction.left)){
            this.movedTile = newBoard.tiles[xEmpty][yEmpty+1];
            newBoard.tiles[xEmpty][yEmpty] = newBoard.tiles[xEmpty][yEmpty+1];
            newBoard.tiles[xEmpty][yEmpty+1] = empty;
        }
        this.newBoard = newBoard;
    }

    @Override
    public String toString(){
        return "Move" + this.movedTile.value + this.movedDirection;
    }
}
