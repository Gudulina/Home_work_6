public class DataException extends Exception{
    public DataException() {
    }

    public void dataException(String data) {
        System.out.printf("Некорректный формат: %s", data);
        System.out.println();
    }
}
