
import java.util.LinkedList;
import java.util.Queue;

public class Program {

    public static void main(String[] args) {
        var mg = new MapGenerator();

        // Печать "сырой" карты
        System.out.println(
                new MapPrinter().rawData(
                        mg.getMap()));

        // Печать "красивой" карты
        System.out.println(
                new MapPrinter().mapColor(
                        mg.getMap()));


        var lee = new WaveAlgorithm(mg.getMap());
        lee.Colorize(new Point2D(3, 3));

        System.out.println(
                new MapPrinter().rawData(
                        mg.getMap()));

        getRoad getRoad = new getRoad(mg.getMap());
        System.out.println(getRoad.shortWay(new Point2D(12, 11)));
    }
}

class Point2D {
    int x, y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("x: %d  y: %d", x, y);
    }
}

class MapGenerator {
    int[][] map;

    public MapGenerator() {
        int[][] map = {
                { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
                { -1, 00, 00, 00, -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
                { -1, 00, 00, 00, 00, 00, 00, -1, 00, 00, 00, 00, 00, 00, -1 },
                { -1, 00, 00, -2, -1, 00, 00, -1, 00, 00, 00, 00, 00, 00, -1 },
                { -1, 00, 00, 00, -1, 00, -1, -1, -1, -1, 00, 00, 00, 00, -1 },
                { -1, 00, 00, 00, -1, 00, -1, 00, 00, -1, 00, 00, 00, 00, -1 },
                { -1, -1, -1, 00, -1, 00, -1, 00, 00, -1, 00, 00, 00, 00, -1 },
                { -1, 00, 00, 00, -1, 00, -1, 00, 00, -1, -1, -1, 00, 00, -1 },
                { -1, 00, 00, 00, -1, 00, 00, 00, 00, -1, 00, 00, 00, 00, -1 },
                { -1, 00, 00, 00, -1, 00, 00, 00, 00, -1, 00, 00, 00, 00, -1 },
                { -1, 00, 00, 00, -1, -1, -1, -1, -1, -1, 00, 00, 00, 00, -1 },
                { -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
                { -1, 00, 00, 00, -1, -1, -1, -1, -1, -1, -1, 00, 00, 00, -1 },
                { -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
                { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }
        };

        this.map = map;
    }

    public int[][] getMap() {
        return map;
    }

    public void setCat(Point2D pos) {
        map[pos.x][pos.y] = -2;
    }
}

class MapPrinter {

    public MapPrinter() {
    }

    public String rawData(int[][] map) {
        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                sb.append(String.format("%5d", map[row][col]));
            }
            sb.append("\n");
        }
        for (int i = 0; i < 3; i++) {
            sb.append("\n");
        }

        return sb.toString();
    }

    public String mapColor(int[][] map) {
        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                switch (map[row][col]) {
                    case 0:
                        sb.append(" 0 ");
                        break;
                    case -1:
                        sb.append(" # ");
                        break;
                    case -2:
                        sb.append("^.^");
                        break;
                    case 99:
                        sb.append(" = ");
                        break;
                    default:
                        break;
                }
            }
            sb.append("\n");
        }
        for (int i = 0; i < 3; i++) {
            sb.append("\n");
        }
        return sb.toString();
    }
}

class WaveAlgorithm {
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

class getRoad {

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