import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class Question {
    String question;
    String[] options;
    int answer;

    Question(String question, String[] options, int answer) {
        this.question = question;
        this.options = options;
        this.answer = answer;
    }
}

public class QuizApplication {

    static Scanner sc = new Scanner(System.in);
    static boolean timeUp;

    public static void main(String[] args) {

        Question[] quiz = {
            new Question(
                "1. Which language is used for Android development?",
                new String[]{"1. Java", "2. Python", "3. C", "4. HTML"},
                1
            ),
            new Question(
                "2. Which keyword is used to create an object?",
                new String[]{"1. class", "2. object", "3. new", "4. static"},
                3
            ),
            new Question(
                "3. Java is a ______ language.",
                new String[]{"1. Procedural", "2. Object Oriented", "3. Assembly", "4. Machine"},
                2
            ),
            new Question(
                "4. Which package contains Scanner class?",
                new String[]{"1. java.io", "2. java.util", "3. java.net", "4. java.sql"},
                2
            ),
            new Question(
                "5. Which loop executes at least once?",
                new String[]{"1. for", "2. while", "3. do-while", "4. foreach"},
                3
            )
        };

        int score = 0;

        System.out.println("QUIZ APPLICATION ");

        for (Question q : quiz) {

            System.out.println("\n" + q.question);

            for (String option : q.options) {
                System.out.println(option);
            }

            timeUp = false;

            Timer timer = new Timer();

            timer.schedule(new TimerTask() {
                public void run() {
                    timeUp = true;
                    System.out.println("\nTime is up!");
                }
            }, 10000);

            System.out.print("Enter your answer (1-4): ");

            long start = System.currentTimeMillis();
            int userAnswer = -1;

            while (!timeUp) {
                if (sc.hasNextInt()) {
                    userAnswer = sc.nextInt();
                    break;
                }
            }

            timer.cancel();

            if (timeUp) {
                System.out.println("Question skipped.");
            } else if (userAnswer == q.answer) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! Correct answer is Option " + q.answer);
            }
        }

        System.out.println("\n RESULT ");
        System.out.println("Total Questions: " + quiz.length);
        System.out.println("Correct Answers: " + score);
        System.out.println("Wrong Answers  : " + (quiz.length - score));
        System.out.println("Score          : " + score + "/" + quiz.length);

        sc.close();
    }
}