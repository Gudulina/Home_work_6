import java.util.LinkedList;

public class getRoad {    

        int[][] map;
    
        public getRoad(int[][] map) {
            this.map = map;
        }
    
        public int count = 0;
    
        public LinkedList<Point2D> shortWay(Point2D stopPoint) {
            LinkedList<Point2D> road = new LinkedList<Point2D>();
            road.add(stopPoint);
    
            LinkedList<Integer> way = new LinkedList<>();
    
            while (map[stopPoint.x][stopPoint.y] != 1) {
                Point2D p = road.remove();
    
                if (map[p.x - 1][p.y] == map[p.x][p.y] - 1) {
                    road.add(new Point2D(p.x - 1, p.y));
                    count++;
                    way.add(map[p.x - 1][p.y]);
                }
    
                if (map[p.x][p.y - 1] == map[p.x][p.y] - 1) {
                    road.add(new Point2D(p.x, p.y - 1));
                    count++;
                    way.add(map[p.x][p.y - 1]);
                }
    
                if (map[p.x + 1][p.y] == map[p.x][p.y] - 1) {
                    road.add(new Point2D(p.x + 1, p.y));
                    count++;
                    way.add(map[p.x + 1][p.y]);
                }
    
                if (map[p.x][p.y + 1] == map[p.x][p.y] - 1) {
                    road.add(new Point2D(p.x, p.y + 1));
                    count++;
                    way.add(map[p.x][p.y + 1]);
                }
    
                System.out.println("Шаг " + count);
                System.out.println("Путь: " + way);
                System.out.println();
            }
            return road;
        }    
}
