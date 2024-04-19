package ir.oraclej.hsqlDemo;

import java.util.List;
import java.util.Scanner;


public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int c = printMenu();
        while (c != 0) {
            switch (c) {
                case 1 -> listPerson();
                case 2 -> addAPerson();
            }
            c = printMenu();
        }
    }

    private static void addAPerson() {
        PersonEntity p = new PersonEntity();
        System.out.println("Enter ID>");
        p.setId(Integer.parseInt(scanner.nextLine()));
        System.out.println("Enter Name>");
        p.setName(scanner.nextLine());
        System.out.println("Enter Family>");
        p.setFamily(scanner.nextLine());
        System.out.println("Enter Age>");
        p.setAge(Integer.parseInt(scanner.nextLine()));
        PersonDao.addPerson(p);
    }

    private static void listPerson() {
        List<PersonEntity> list = PersonDao.getAllPeople();
        for (PersonEntity p : list) {
            System.out.println(String.format("%d : %s %s (%d)%n", p.getId(), p.getName(), p.getFamily(), p.getAge()));
        }
    }

    private static int printMenu() {
        System.out.println("1. list all people");
        System.out.println("2. add new person");
        System.out.println("0. exit");
        System.out.print("Choose one>");

        return Integer.parseInt(scanner.nextLine());
    }
}
