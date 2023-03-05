public class MapPrinter {    

        /**
         * Печать карты в консоль
         */
        public MapPrinter() {
        }
    
        /**
         * Печать "сырой" карты
         * @param map карта
         * @return возвращается карта с цифрами
         */
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
    
        /**
         * Печать "красивой" карты
         * @param map карта
         * @return возвращается "раскрашенная" карта
         */
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