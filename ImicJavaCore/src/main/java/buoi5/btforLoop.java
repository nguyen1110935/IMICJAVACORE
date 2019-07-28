package buoi5;

public class btforLoop {
    public static void main(String[] args) {
        int[] workingday_nu = {10, 21, 30, 20,  20, 15,  8, 0, 9,  0, 7, 12, 12, 18, 30, 27, 3, 0, 14, 15};
        int[] bonus         = { 1, 10, 99,  0, 100, 20, 13, 0, 0, 10, 1,  5,  6, 14, 23,  2, 7, 4, 17,  0};
        int i = 0;
        double salary = 0;
        for (int number :workingday_nu)
        {
            try {
                salary = number*500 + 200/bonus[i];
            }
            catch (ArithmeticException e){
                System.out.println("####################################");
                System.out.println("Error ! Divide by zero");
                i++;
                continue;
            }
            catch (Exception e){
                System.out.println("Unknown Error !");
            }
            System.out.println("####################################");
            System.out.println("Number of working days: "+number);
            System.out.println("Bonus                 : "+bonus[i]);
            System.out.println("Salary index "+ i+ " is "+salary+ "(thousand VND)");
            i++;
        }
    }
}
