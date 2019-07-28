package FinalTest;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] arg) {
        Scanner scan = new Scanner(System.in);
        //System.out.println("Please input size of array: ");
        double[] list_unorderd = user_input(10);
        double[] list_ordered;
        int index;
        double f_value;
//Ex 5
        list_ordered = arrange_arr(list_unorderd);
//Ex 6
// Look for a value
        System.out.println("Please input a value looked for: ");
        f_value = scan.nextDouble();
        index = look_for(f_value, list_ordered, 0, list_ordered.length - 1);
        if (index == -1) {
            System.out.println("Not detect");
        } else {
            System.out.println("Detected in index= " + index);
//Look for this value in other surrounding index
            int variant = -1;
            if (index != 0) {
                while (true) {
                    int index1 = index + variant;
                    if (index1 >= 0) {
                        if (f_value == list_ordered[index + variant]) {
                            System.out.println("Detected in index= " + index1);
                            variant--;
                        } else break;
                    } else {
                        break;
                    }
                }
            }
            variant = 1;
            if (index != list_ordered.length - 1) {
                while (true) {
                    int index1 = index + variant;
                    if (index1 < list_ordered.length) {
                        if (f_value == list_ordered[index1]) {
                            System.out.println("Detected in index= " + index1);
                            variant++;
                        } else break;
                    } else {
                        break;
                    }
                }
            }
        }
//Ex 7
// double number;
// System.out.println("Please input a value check if it is prime: ");
// number = scan.nextDouble();
// if (check_num(number)) {
// System.out.printf("This value (%s) is prime", number);
// } else {
// System.out.printf("This value (%s) is NOT prime", number);
// }
    }
    public static int look_for(double value, double[] list, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid_idx = (end + start) / 2;
        if (value > list[mid_idx]) {
            return look_for(value, list, mid_idx + 1, end);
        } else if (value < list[mid_idx]) {
            return look_for(value, list, 0, mid_idx - 1);
        } else {
            return mid_idx;
        }
    }
    public static double[] arrange_arr(double[] my_list) {
        double tmp;
        int i, sat = 0;
        i = my_list.length - 1;
        System.out.println("Max index: " + i);
        for (int j = 0; j <= i - 1; j++) {
            if (my_list[j] > my_list[j + 1]) {
//Dao gia tri
                tmp = my_list[j + 1];
                my_list[j + 1] = my_list[j];
                my_list[j] = tmp;
                sat = 1;
            }
            if (j == i - 1 && sat == 1) {
                j = -1;
                sat = 0;
            }
        }
//Print array
        i = 0;
        while (true) {
            System.out.println(my_list[i]);
            i++;
            if (i == my_list.length) break;
        }
        return my_list;
    }
    public static boolean check_num(double number) {
        if (number == 1 || number == 0) return false;
        for (int a = 2; a <= number / 2; a++) {
            if (number % a == 0) return false;
        }
        return true;
    }
    private static double[] user_input(int num_element) {
        double[] input_list = new double[num_element];
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < num_element; i++) {
            System.out.println("Please in put element of index " + i);
            input_list[i] = scan.nextDouble();
        }
        return input_list;
    }
}