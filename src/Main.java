public class Main {

    public static void main(String[] args) {
        int N = 8;
        BFS bfs = new BFS(N);

        Cell src = new Cell(0, 6,0);
        Cell dest = new Cell(6, 0,0);

        int result = bfs.findShortestPath(src, dest);

        if (result == -1) {
            System.out.println("Illegal Knight movement");
        } else {
            System.out.println("The minimum steps are: " + result);
        }
    }

}