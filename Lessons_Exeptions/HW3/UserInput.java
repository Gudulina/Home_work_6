import java.util.Scanner;

public class UserInput {
    public String[] inputData (){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Введите через пробел данные латиницей в формате:\n" +
                    "Фамилия Имя Отчество датаРождения(dd.mm.yyyy) номерТелефона(только цифры) пол(f или m):");
            String data = scanner.nextLine();
            String[] arrData = data.split(" ");
            if (arrData.length == 6){
                return arrData;
            } else if (arrData.length < 6) {
                System.out.println("Введены не все данные, пожалуйста, попробуйте ещё раз.");
            } else System.out.println("Введены лишние данные, пожалуйста, попробуйте ещё раз.");
        }
    }
}
