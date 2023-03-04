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