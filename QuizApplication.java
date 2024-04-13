import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication {
    private static int score = 0;
    private static int currentQuestionIndex = 0;
    private static Question[] questions;
    private static Timer timer;

    public static void main(String[] args) {
        
        initializeQuestions();

        
        startQuiz();
    }

    private static void initializeQuestions() {
        // Define your quiz questions here
        questions = new Question[]{
            new Question("What is the capital of France?", new String[]{"A. London", "B. Paris", "C. Berlin", "D. Rome"}, "B"),
            new Question("What is the largest planet in our solar system?", new String[]{"A. Earth", "B. Jupiter", "C. Mars", "D. Saturn"}, "B"),
           
        };
    }

    private static void startQuiz() {
        Scanner scanner = new Scanner(System.in);
        
        for (Question question : questions) {
            // Display question and options
            displayQuestion(question);

            // Start the timer
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Time's up!");
                    nextQuestion();
                }
            }, 10000); // 10 seconds timer

            // Get user input
            String answer = scanner.nextLine().toUpperCase();

            // Cancel the timer
            timer.cancel();

            // Check answer
            if (answer.equals(question.getCorrectAnswer())) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect!");
            }

            
            nextQuestion();
        }

        
        System.out.println("Quiz ended! Your score is: " + score);
    }

    private static void displayQuestion(Question question) {
        System.out.println(question.getQuestion());
        for (String option : question.getOptions()) {
            System.out.println(option);
        }
        System.out.print("Enter your answer: ");
    }

    private static void nextQuestion() {
        currentQuestionIndex++;
        if (currentQuestionIndex < questions.length) {
            System.out.println("\nNext question:");
        }
    }

    // Question class
    static class Question {
        private String question;
        private String[] options;
        private String correctAnswer;

        public Question(String question, String[] options, String correctAnswer) {
            this.question = question;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }

        public String getQuestion() {
            return question;
        }

        public String[] getOptions() {
            return options;
        }

        public String getCorrectAnswer() {
            return correctAnswer;
        }
    }
}
