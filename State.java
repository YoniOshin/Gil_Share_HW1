public class State {
    private final Board board;

    public State(Board board){
        this.board = board;
    }


    public boolean isGoal(){// Checks if board is solved
        for (int i = 0; i< board.rows; i++){
            for (int j = 0; j< board.columns; j++){
                if (board.tiles[i][j].value == 0){
                    if(!((i+1)*(j+1) == board.columns*board.rows)){
                        return false;
                    }
                }
                if (!(board.tiles[i][j].value == ((i*board.columns)+j+1))){
                    return false;
                }
            }
        }
        return true;
    }
    public Action[] actions() {// Checks valid moves, returns array of valid actions
        int[] emptyCoordinates = board.emptyFinder();
        int xEmpty = emptyCoordinates[0];
        int yEmpty = emptyCoordinates[1];
        int number_of_valid_moves = 0;
        boolean up = false;
        boolean down = false;
        boolean left = false;
        boolean right = false;
        if (xEmpty + 1 < board.rows) {
            number_of_valid_moves++;
            down = true;
        }
        if (xEmpty - 1 >= 0) {
            number_of_valid_moves++;
            up = true;
        }
        if (yEmpty - 1 >= 0) {
            number_of_valid_moves++;
            right = true;
        }
        if (yEmpty + 1 < board.columns) {
            number_of_valid_moves++;
            left = true;
        }
        Action[] validActions = new Action[number_of_valid_moves];
        int add_index = 0;
        if (up) {
            validActions[add_index] = new Action(board, Direction.up);
            add_index++;
        }
        if (down) {
            validActions[add_index] = new Action(board, Direction.down);
            add_index++;
        }
        if (right) {
            validActions[add_index] = new Action(board, Direction.right);
            add_index++;
        }
        if (left) {
            validActions[add_index] = new Action(board, Direction.left);
        }
        return validActions;
    }

    public Board result(Action action){
        Board resultBoard = new Board(action.newBoard.tiles, action.newBoard.rows, action.newBoard.columns);
        return resultBoard;
    }
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof State)) {
            return false;
        }
        State otherState = (State) other;
        return board.equals(otherState.board);
    }

    @Override
    public int hashCode() {
        return board.hashCode();
    }
}
