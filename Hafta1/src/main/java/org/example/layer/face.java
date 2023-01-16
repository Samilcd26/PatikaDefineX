package org.example.layer;

import org.example.business.Home;
import org.example.business.SummerHouse;
import org.example.business.Villa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class face {
    private static ArrayList<ArrayList> HomeStore = new ArrayList<ArrayList>();
    private static ArrayList<ArrayList> VillaStore = new ArrayList<ArrayList>();
    private static ArrayList<ArrayList> SummerHouseStore = new ArrayList<ArrayList>();
    private static Home newHome = new Home();
    private static Villa newVilla = new Villa();
    private static SummerHouse newSummerHouse = new SummerHouse();
    public static void UI(){
        Scanner inputObj = new Scanner(System.in);
        System.out.println("********************************");
        System.out.println("Welcome,\nWhat do you want to do?\n********************************");
        System.out.println("0->List all houses.\n1->Create a entity.\n2->Methods of houses.\n3->Methods of villa.\n4->Methods of summerhouse.\n5->Average areas of all houses.\n6->Search houses by number of rooms.");
        String userInput = inputObj.nextLine();
        System.out.println("********************************");

        //All instance

        //*************************

        if (userInput.equals("")){
            System.out.println("Please enter a number between 1 and 5");
        }
        switch (userInput){
            case "0":
                System.out.println("Total home:");
                System.out.println(HomeStore);

                System.out.println("Total villa:");
                System.out.println(VillaStore);

                System.out.println("Total summerhouse:");
                System.out.println(SummerHouseStore);
                UI();

            //Create to obje
            case "1":
                ArrayList newItem = new ArrayList<>();
                System.out.println("Enter the type of house to be created.(Home, Villa, Summerhouse)");
                String createItemType = inputObj.nextLine();
                newItem.add(createItemType);

                System.out.println("Enter the Name of the house to be created. (Home1)");
                String createItemName = inputObj.nextLine();
                newItem.add(createItemName);

                System.out.println("Enter the number of rooms of the house to be created enter. (2+1, 3+1, 1+1)");
                String createItemRooms = inputObj.nextLine();
                newItem.add(createItemRooms);

                System.out.println("Enter the area of the house to be created.");
                double createItemArea = Double.parseDouble(inputObj.nextLine());
                newItem.add(createItemArea);

                System.out.println("Enter the price of the house to be created.");
                double createItemPrice = Double.parseDouble(inputObj.nextLine());
                newItem.add(createItemPrice);

                //Home
                if (createItemType.equals("Home") ||createItemType.equals("home")){

                    HomeStore.add(newHome.setEntity(newItem));
                    UI();
                }else if (createItemType.equals("Villa") ||createItemType.equals("villa")){

                    VillaStore.add(newVilla.setEntity(newItem));
                    UI();
                }else if (createItemType.equals("Villa") ||createItemType.equals("villa")){

                    SummerHouseStore.add(newSummerHouse.setEntity(newItem));
                    UI();
                }else {
                    System.out.println("You entered incorrect data, try again.");
                    UI();
                }

            case "2":
                System.out.println("0->The total prices of the houses.\n1->Average square meter of houses.");
                String HemeMethodType = inputObj.nextLine();
                if (HemeMethodType.equals("0")){
                    System.out.println(newHome.totalEntityPrice());
                    UI();
                } else if (HemeMethodType.equals("1")) {
                    System.out.println(newHome.avarageEntityArea());
                    UI();
                }else {
                    System.out.println("You entered incorrect data, try again.");
                    UI();
                }
            case "3":
                System.out.println("0->The total prices of the villa.\n1->Average square meter of Villa.");
                String VillaMethodType = inputObj.nextLine();
                if (VillaMethodType.equals("0")){
                    System.out.println(newVilla.totalEntityPrice());
                    UI();
                } else if (VillaMethodType.equals("1")) {
                    System.out.println(newVilla.avarageEntityArea());
                    UI();
                }else {
                    System.out.println("You entered incorrect data, try again.");
                    UI();
                }

            case "4":
                System.out.println("0->The total prices of the Summerhouse.\n1->Average square meter of Summerhouse.");
                String SummerHouseMethodType = inputObj.nextLine();
                if (SummerHouseMethodType.equals("0")){
                    System.out.println(newSummerHouse.totalEntityPrice());
                    UI();
                } else if (SummerHouseMethodType.equals("1")) {
                    System.out.println(newSummerHouse.avarageEntityArea());
                    UI();
                }else {
                    System.out.println("You entered incorrect data, try again.");
                    UI();
                }

            case "5":
                System.out.println("Average square meter of houses: "+newSummerHouse.avarageEntityArea()+
                        "\nAverage square meter of Villa: "+newVilla.avarageEntityArea()+
                        "\nAverage square meter of Summerhouse: "+newSummerHouse.avarageEntityArea());
                UI();

            case "6":
                System.out.println("Please enter number of rooms. (2+1)");
                String roomNumber = inputObj.nextLine();

                System.out.println("Home:");
                for (ArrayList homeRome:HomeStore) {
                    if (homeRome.get(2).equals(roomNumber)) System.out.println(homeRome);;
                }
                System.out.println("\n**************************");
                System.out.println("Villa:");
                for (ArrayList villaRome:VillaStore) {
                    if (villaRome.get(2).equals(roomNumber)) System.out.println(villaRome);;
                }

                System.out.println("\n**************************");
                System.out.println("Summerhouse:");
                for (ArrayList villaRome:SummerHouseStore) {
                    if (villaRome.get(2).equals(villaRome)) System.out.println(villaRome);;
                }
                System.out.println("\n**************************");
                UI();
            default:
                System.out.println("Incorrect or out of range value.");
                UI();
        }
    }
}
