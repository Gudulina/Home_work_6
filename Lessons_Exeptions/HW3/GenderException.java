public class GenderException extends Exception {
    public GenderException() {
    }
    public void genderException(String g){
        System.out.println("Некорректно введен пол: "+g+". Необходимо указать f или m.");
    }
}
