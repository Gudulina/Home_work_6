public class BirthdateException extends Exception{
    public BirthdateException() {
    }
    public void birthdateException(String date){
        System.out.println("Некорректный формат даты рождения: "+date+". Необходимо вводить в таком виде: dd.mm.yyyy");
    }
}
