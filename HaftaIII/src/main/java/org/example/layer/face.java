package org.example.layer;


import org.example.data.EntityPattern;
import org.example.data.MethodPattern;

import java.text.SimpleDateFormat;
import java.util.*;

public class face implements MethodPattern {
    private ArrayList EntityStore = new ArrayList<>();
    private List<EntityPattern> Serach = new ArrayList<>();
    private List<EntityPattern> newıtem = new ArrayList<>();
    private Scanner inputItem = new Scanner(System.in);
    private Date date = new Date();
    private List globalStore = new ArrayList();
    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    public void UI(){

        //        Test Users *****************************************
        newıtem.add(new EntityPattern("Test1","TestComp",400,"02-06-2001"));
        newıtem.add(new EntityPattern("Test2","TestComp",200,"08-06-2021"));
        newıtem.add(new EntityPattern("Test3","TestComp2",1700,"22-04-2021"));
        newıtem.add(new EntityPattern("TestC3","TestComp2",2000,"20-010-2871"));
        newıtem.add(new EntityPattern("Testc4","TestComp2",8800,"13-01-2003"));
        //************************************************************



        //Program interface and selection screen.
        System.out.println("Welcome,\nWhich action would you like to take?\n\n0->List all users.\n1->Create new user.\n2->Search by letter\n3->Total amount of invoices of customers registered in June.\n4->1500 TL transactions in the system.");
        int userInput = Integer.parseInt(inputItem.nextLine());
        switch (userInput){
            case 0:
                System.out.println("All users:");
                getAllEntity();
            case 1:
                setEntity();
            case 2:
                searchEntity();
            case 3:
                getMonthSum();
            case 4:
                getListEntity();
            default:
                UI();
        }
    }

    //New user creation method
    @Override
    public List<EntityPattern> setEntity() {
        System.out.println("User Name:");
        String userName = inputItem.nextLine();

        System.out.println("Company Name:");
        String companyName = inputItem.nextLine();

        System.out.println("Price:");
        double price = Double.parseDouble(inputItem.nextLine());

        newıtem.add(new EntityPattern(userName,companyName,price,formatter.format(date)));

        EntityStore.add(newıtem);
        System.out.println("User added:"+userName+" Company Name:"+companyName+" Price:"+price+" Date:");


        System.out.println();
        UI();

        return newıtem;
    }


    @Override
    public void getListEntity() {
        double total=0;
        int say=0;
        for (EntityPattern let:newıtem) {
            if (let.price<500){
                System.out.println("Customers with invoices under 500TL in the system:");
                System.out.println(let.name);
            }else if (let.price>1500){
                total+=let.price;
                say+=1;
                System.out.println("Invoices over 1500 TL in the system:");
                System.out.println("User added:"+let.name+" Company Name:"+let.company+" Price:"+let.price+" Date:"+let.date);
            }
        }

        System.out.println("Average of invoices over 1500TL in the system:");
        System.out.println(total/say);
        UI();
    }

    //Method that searches by the entered letter
    @Override
    public void searchEntity() {
        System.out.println("Enter letters:");
        String letters = inputItem.nextLine().toLowerCase();

        newıtem.stream().forEach(let->{
            if(let.name.indexOf(letters)>-1 ||let.name.indexOf(letters.toUpperCase())>-1) Serach.add(let);
        });

        System.out.println("Search Results:\n**********************************");
        Serach.stream().forEach(serc-> System.out.println("User added:"+serc.name+" Company Name:"+serc.company+" Price:"+serc.price+" Date:"+serc.date));
        System.out.println("**********************************");
        Serach.clear();
        UI();
    }


    //Method to list all users.
    @Override
    public void getAllEntity() {
        newıtem.stream().forEach(en-> System.out.println("Name:"+en.name+" Company Name:"+en.company+" Price:"+en.price+" Date:"+en.date));
        UI();
    }


    //Method to calculate the total amount of invoices of customers registered in June
    @Override
    public void getMonthSum() {
        System.out.println("Total:");
        double total=0;
        String Mon;

        for (EntityPattern let:newıtem) {
            Mon=let.date.charAt(3)+""+let.date.charAt(4);
            if (Mon.equals("06"))total+=let.price;

        }
        System.out.println(total+"\n\n");
        UI();
    }
}
