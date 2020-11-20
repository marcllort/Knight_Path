import java.util.ArrayList;
import java.util.LinkedList;

public class BFS {

    // Knight possible movements
    private static final int[] X_MOVEMENT = {2, 2, -2, -2, 1, 1, -1, -1};
    private static final int[] Y_MOVEMENT = {-1, 1, 1, -1, 2, -2, 2, -2};
    // Board number of lines/rows
    private final int N;


    public BFS(int N) {
        this.N = N;
    }

    private boolean isInsideBoard(int x, int y) {
        if (x >= N || y >= N || x < 0 || y < 0) {
            return false;
        }
        return true;
    }

    private boolean isDestination(Cell destination, Cell cell) {
        return cell.getX() == destination.getX() && cell.getY() == destination.getY();
    }

    public int findShortestPath(Cell origin, Cell destination) {

        LinkedList<Cell> queue = new LinkedList<>();
        ArrayList<Cell> visitedCells = new ArrayList<>();

        queue.add(origin);

        while (!queue.isEmpty()) {
            Cell cell = queue.poll();

            if (isDestination(destination, cell)) {
                return cell.getDist();
            }

            if (!visitedCells.contains(cell)) {
                visitedCells.add(cell);

                for (int i = 0; i < 8; ++i) {

                    int cellX = cell.getX() + X_MOVEMENT[i];
                    int cellY = cell.getY() + Y_MOVEMENT[i];

                    if (isInsideBoard(cellX, cellY)) {
                        queue.add(new Cell(cellX, cellY, cell.getDist() + 1));
                    }
                }
            }
        }

        return -1;
    }


}
