package org.structural.decorator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//class that will use Food interface to use which type of food customer wants means (Decorates).
public class DecoratorPatternCustomer {

    private static int choice;

    public static void main(String[] args) throws NumberFormatException, IOException {
        do {
            System.out.print("========= Food Menu ============ \n");
            System.out.print("            1. Vegetarian Food.   \n");
            System.out.print("            2. Non-Vegetarian Food.\n");
            System.out.print("            3. Chineese Food.         \n");
            System.out.print("            4. Exit                        \n");
            System.out.print("Enter your choice: ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            choice = Integer.parseInt(br.readLine());
            switch (choice) {
                case 1 -> {
                    VegFood vf = new VegFood();
                    System.out.println(vf.prepareFood());
                    System.out.println(vf.foodPrice());
                }
                case 2 -> {
                    Food f1 = new NonVegFood(new VegFood());
                    System.out.println(f1.prepareFood());
                    System.out.println(f1.foodPrice());
                }
                case 3 -> {
                    Food f2 = new ChineeseFood(new VegFood());
                    System.out.println(f2.prepareFood());
                    System.out.println(f2.foodPrice());
                }
                default -> {
                    {
                        System.out.println("Other than these no food available");
                    }
                    return;
                }
            }//end of switch

        } while (choice != 4);
    }
}
