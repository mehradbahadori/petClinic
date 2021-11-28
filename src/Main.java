import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        home();
    }
    public static void home(){
        System.out.println("Hello\nWelcome To the PetClinic Page!");
        while (true){
            System.out.println("Are You Registered Your Pet?");
            String input=sc.nextLine();
            switch (input){
                case "no":
                    Pet pet=getPetInformation();
                    saveToDatabase(pet);
                    return;
                case "yes":
                    System.out.println("Do you want to see the Pet List? y(Yes) / n(No)");
                    input= sc.nextLine();
                    if (input.equals("y")) {
                        showPets();
                        return;
                    }else if (input.equals("n")){

                        System.out.println("What Can I Do For You?\nHome? / Exit?");
                        input= sc.nextLine();
                        if ((input.equals("home") || input.equals("Home"))){
                            break;
                        }else if (input.equals("exit") || input.equals("Exit")){
                            System.out.println("Ok\nHave a Good Day!");
                            return;
                        }
                    }
                    break;
            }
        }

    }

    public static Pet getPetInformation() {
        System.out.println("Please Register Your Pet!\nWhats Your Name?");
        String ownerName= sc.nextLine();
        System.out.println("Whats Your Pets Type?");
        String type=sc.nextLine();
        System.out.println("Whats Your Pets Name?");
        String name=sc.nextLine();
        System.out.println("How Old Is Your Pet?");
        int age= sc.nextInt();
        return new Pet(ownerName,type,name,age);


    }
    public static void saveToDatabase(Pet pet) {
        boolean save = DBManager.getInstance().savePets(pet);
        if (save) {
            System.out.println("Process Successfully Saved !");
        } else {
            System.err.println("Save Process Unsuccessful!");
        }
    }
    private static void showPets() {
        ArrayList<Pet> pets=DBManager.getInstance().loadPets();
        for (Pet pet:pets){
            System.out.println(pet);
        }
    }
}



