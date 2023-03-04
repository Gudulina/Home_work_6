import java.util.LinkedList;
import java.util.Queue;

public class WaveAlgorithm {
    
        int[][] map;
    
        public WaveAlgorithm(int[][] map) {
            this.map = map;
        }
    
        public void Colorize(Point2D startPoint) {
            Queue<Point2D> queue = new LinkedList<Point2D>();
            queue.add(startPoint);
            map[startPoint.x][startPoint.y] = 1;
    
            while (queue.size() != 0) {
                Point2D p = queue.remove();
    
                if (map[p.x - 1][p.y] == 0) {
                    queue.add(new Point2D(p.x - 1, p.y));
                    map[p.x - 1][p.y] = map[p.x][p.y] + 1;
                }
                if (map[p.x][p.y - 1] == 0) {
                    queue.add(new Point2D(p.x, p.y - 1));
                    map[p.x][p.y - 1] = map[p.x][p.y] + 1;
                }
                if (map[p.x + 1][p.y] == 0) {
                    queue.add(new Point2D(p.x + 1, p.y));
                    map[p.x + 1][p.y] = map[p.x][p.y] + 1;
                }
                if (map[p.x][p.y + 1] == 0) {
                    queue.add(new Point2D(p.x, p.y + 1));
                    map[p.x][p.y + 1] = map[p.x][p.y] + 1;
                }
            }
        }    
}
