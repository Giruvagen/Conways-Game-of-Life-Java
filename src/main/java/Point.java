public class Point {

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    final int x;
    final int y;

    @Override
    public boolean equals(Object o) {
        if (o instanceof Point) {
            Point point = (Point) o;
            return this.x == point.x && this.y == point.y;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return x + y;
    }
}
