package org.example;

import org.example.business.Home;
import org.example.model.BaseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static ArrayList<ArrayList> store = new ArrayList<ArrayList>();
    public static void main(String[] args) {

        UI();

    }

    public static void UI(){
        Scanner inputObj = new Scanner(System.in);
        System.out.println("Ne Yapmak İstersiniz");
        System.out.println("1->Obje oluştur\n2->Evlerin Methodları\n3->Villaların Methodları\n4->Yazlıkların Methodları\n5->Tüm evlerin ortalama metrekaresi\n6->Oda sayısına göre evleri filitrele");
        String userInput = inputObj.nextLine();
        switch (userInput){

            //Create to obje
            case "1":
                ArrayList newItem = new ArrayList<>();
                System.out.println("Yaratılacak evin tipini girin");
                String createItemType = inputObj.nextLine();
                newItem.add(createItemType);

                System.out.println("Yaratılacak evin İsmi girin");
                String createItemName = inputObj.nextLine();
                newItem.add(createItemName);

                System.out.println("Yaratılacak evin odası girin");
                int createItemRooms = Integer.parseInt(inputObj.nextLine());
                newItem.add(createItemRooms);

                System.out.println("Yaratılacak evin alanı girin");
                double createItemArea = Double.parseDouble(inputObj.nextLine());
                newItem.add(createItemArea);

                System.out.println("Yaratılacak evin fiyatı girin");
                double createItemPrice = Double.parseDouble(inputObj.nextLine());
                newItem.add(createItemPrice);


                store.add((ArrayList) Home.setHome(newItem));

                UI();
                //System.out.println(createItemType+" tipinde "+createItemName+" isminde "+createItemRooms+" oda sayısına sahip"+createItemArea+" Alan Sahip"+createItemPrice);
            case "2":
                //Evlerin toplam fiyatları
                System.out.println("1->Evlerin Toplam fiyatları için\n2->Evlerin ortalama metre karaleri için\n");
                String homeMethodType = inputObj.nextLine();
                if (homeMethodType.equals("1")){
                    Home.totalHomePrice();
                }else {
                    Home.avarageHomeArea();
                }
        }
    }
}