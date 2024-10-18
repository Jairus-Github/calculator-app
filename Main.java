import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Workout {
    String type;
    int duration; // in minutes
    int caloriesBurned;

    public Workout(String type, int duration, int caloriesBurned) {
        this.type = type;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
    }

    @Override
    public String toString() {
        return "Workout Type: " + type + ", Duration: " + duration + " mins, Calories Burned: " + caloriesBurned;
    }
}

class FitnessTracker {
    private List<Workout> workouts;
    private int calorieGoal;

    public FitnessTracker(int calorieGoal) {
        workouts = new ArrayList<>();
        this.calorieGoal = calorieGoal;
    }

    public void logWorkout(String type, int duration, int caloriesBurned) {
        workouts.add(new Workout(type, duration, caloriesBurned));
    }

    public void showProgress() {
        int totalCalories = workouts.stream().mapToInt(w -> w.caloriesBurned).sum();
        System.out.println("Total Workouts: " + workouts.size());
        System.out.println("Total Calories Burned: " + totalCalories);
        System.out.println("Calorie Goal: " + calorieGoal);
        System.out.println("Calories Remaining to Goal: " + (calorieGoal - totalCalories));
    }

    public void showWorkouts() {
        if (workouts.isEmpty()) {
            System.out.println("No workouts logged yet.");
        } else {
            for (Workout workout : workouts) {
                System.out.println(workout);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your calorie goal for the week: ");
        int calorieGoal = scanner.nextInt();
        FitnessTracker fitnessTracker = new FitnessTracker(calorieGoal);
        
        while (true) {
            System.out.println("\n1. Log Workout");
            System.out.println("2. Show Progress");
            System.out.println("3. Show Workouts");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter workout type: ");
                    String type = scanner.next();
                    System.out.print("Enter duration (in minutes): ");
                    int duration = scanner.nextInt();
                    System.out.print("Enter calories burned: ");
                    int calories = scanner.nextInt();
                    fitnessTracker.logWorkout(type, duration, calories);
                    System.out.println("Workout logged successfully!");
                    break;
                case 2:
                    fitnessTracker.showProgress();
                    break;
                case 3:
                    fitnessTracker.showWorkouts();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
