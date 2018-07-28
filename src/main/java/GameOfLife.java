import java.util.*;

public class GameOfLife{

    private Map<Point, Cell> state = new HashMap<>();

    public void set(int x, int y, Cell cell) {
        state.put(new Point(x, y), cell);
    }

    public Cell get(int x, int y) {
        return state.get(new Point(x, y));
    }
    public void tick() {

        Map<Point, Cell> newState = new HashMap<>();

        for (Point point : state.keySet()) {

            List<Cell> neighbours = new ArrayList<>();

            neighbours.add(get(point.x + 1, point.y));
            neighbours.add(get(point.x - 1, point.y));
            neighbours.add(get(point.x + 1, point.y -1));
            neighbours.add(get(point.x, point.y - 1));
            neighbours.add(get(point.x -1, point.y - 1));
            neighbours.add(get(point.x + 1, point.y + 1));
            neighbours.add(get(point.x , point.y + 1));
            neighbours.add(get(point.x - 1, point.y + 1));

            long aliveCount = neighbours
                    .stream()
                    .filter((Cell cell) -> cell == Cell.ALIVE)
                    .count();

            if (aliveCount > 3) {
                newState.put(point, Cell.DEAD);
            } else if (aliveCount == 3 && get(point.x, point.y) == Cell.DEAD) {
                newState.put(point, Cell.ALIVE);
            } else if (aliveCount < 2 && get(point.x, point.y) == Cell.ALIVE) {
                newState.put(point, Cell.DEAD);
            } else {
                newState.put(point, get(point.x, point.y));
            }
        }

        state = newState;
    }

    @Override
    public String toString() {

        int maxX = state
                .keySet()
                .stream()
                .mapToInt((Point point) -> point.x)
                .max()
                .orElse(0);
        int maxY = state
                .keySet()
                .stream()
                .mapToInt((Point point) -> point.y)
                .max()
                .orElse(0);
        int minX = state
                .keySet()
                .stream()
                .mapToInt((Point point) -> point.x)
                .min()
                .orElse(0);
        int minY = state
                .keySet()
                .stream()
                .mapToInt((Point point) -> point.y)
                .min()
                .orElse(0);

        StringBuilder representation = new StringBuilder();

        for (; minY <= maxY; minY++) {
            for (int x = minX; x <= maxX; x++) {
                if (get(x, minY) == Cell.ALIVE) {
                    representation.append("X");
                } else {
                    representation.append(" ");
                }
            }
            representation.append('\n');
        }

       return representation.toString();
    }
}
