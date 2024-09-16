import java.util.Scanner;
import java.util.ArrayList;
public class ToDoListApp{
    private static ArrayList<String> tasks = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Engine: while(true){
            showMenu();
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    System.out.println("Enter the name of your task: ");
                    String a = sc.nextLine();
                    addTask(a);
                    System.out.println("Task Successfully added.");
                    break;
                case 2:
                    if(tasks.isEmpty()){
                        System.out.println("No task to delete, I am sorry.");
                        break;
                    }
                    removeTask();
                    break;
                case 3:
                    System.out.println("Okay, Here is all of you tasks: ");
                    printAllTask();
                    break;

                case 4:
                    if(tasks.isEmpty()){
                        System.out.println("No task to delete, I am sorry.");
                        break;
                    }
                    editTask();
                    break;
                case 5:
                    try {
                        System.out.println("Exiting application....");
                        Thread.sleep(1500);
                        System.out.println("ShutDown Successfull!");
                        break Engine;
                    }
                    catch (InterruptedException p){
                        System.out.println("Interrupted....");
                    }

                default:
                    System.out.println("Provide a correct Operation Number, please! ");
                    break;
            }
        }
    }

    private static void addTask(String p){
        tasks.add(p);
    }

    private static void editTask(){
        System.out.println("So, you want to edit a task, I see.");
        System.out.println("Here is the list of your Tasks: ");
        printAllTask();
        System.out.println("Please provide the number of task you wanna edit: ");
        int ac = Integer.parseInt(sc.nextLine());
        if(ac < 0 || ac > tasks.size()){
            System.out.println("You haven't provided a valid task number, I am sorry!");
            return;
        }
        System.out.println("Okay, now edit the text: ");
        String editedTask = sc.nextLine();
        tasks.set(ac-1 , editedTask);
    }

    private static void removeTask(){
        System.out.println("So, you want to delete a task, I see.");
        try{
            Thread.sleep(1500);
        }
        catch (InterruptedException p){
            System.out.println("Interrupted...");
        }
        System.out.println("Here is the list of your Tasks: ");
        printAllTask();
        System.out.println("Please provide the number of task you wanna delete: ");
        int ac = Integer.parseInt(sc.nextLine());
        if(ac < 0 || ac > tasks.size()){
            System.out.println("You haven't provided a valid task number");
            return;
        }
        String stringToBeRemoved  = tasks.get(0);
        for(int i=0; i<ac; i++){
            if(i != ac-1) continue;
            stringToBeRemoved = tasks.get(i);
        }
        tasks.remove(stringToBeRemoved);
        System.out.println("Successfully deleted");
    }

    private static void printAllTask(){
        int u = 1;
        for(String a : tasks){
            System.out.println(u++ +". "+ a);
        }
    }

    private static void showMenu(){
        System.out.println("What do you want?");
        System.out.println("1. Add Task");
        System.out.println("2. Delete Task");
        System.out.println("3. Show Task");
        System.out.println("4. Edit Task");
        System.out.println("5. Exit");
        System.out.println("Choose your option: ");
    }
}
