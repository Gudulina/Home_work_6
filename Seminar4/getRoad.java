import java.util.LinkedList;

public class getRoad {

    int[][] map;

    public getRoad(int[][] map) {
        this.map = map;
    }

    public int count = 1;

    /**
     * Медот поиска кратчайшего пути от финиша до старта
     * 
     * @param Point2D   - получение координат
     * @param stopPoint - точка выхода из лабиринта
     */
    public void method(Point2D stopPoint) {
        LinkedList<Point2D> road = new LinkedList<Point2D>(); // координаты карты
        road.add(stopPoint);

        LinkedList<Integer> way = new LinkedList<>(); // значения координат
        way.addFirst(18);

        try {

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
            }
        } catch (Exception exception) {
            System.out.println("Произошла какая-то ошибка, но выход из лабиринта найден.");
        }

        // Выводит количество шагов и обратный путь:
        finally {
            System.out.println("Количество шагов: " + count);
            System.out.println("Путь: " + way);
        }
    }
}
