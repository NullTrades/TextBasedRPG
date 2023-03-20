import java.util.TimerTask;

public class Timer {
    // call menuChoice from Main.java
    public static boolean menuChoice = Main.menuChoice;
    static int timeLog = 0;
    // change it to if menuChoice = true
    //      debug if it does not run because if is called initially(when menuChoice is false)
    //      while loop might not work in this case because it might call the print statements infinitely
    public static void main(String[] args) {
        //while menuChoice from Main.java is equal to 1
        //write an if statement with the condition of menuChoice variable from the main method being true
// the messageDelay function must be called with two parameters
        // the first parameter is the message{string} that will be printed
        // the second parameter is the time in milliseconds
        // the time in milliseconds is the time that will pass before the message is printed
        // since eacth messageDelay function is called initially the star system function is called aswell
        timeLog = 30;
        messageDelay("1 minute has passed", 60 * 1000);//time from 30 seconds to 1 minute
        timeLog = 60;
        messageDelay("2 minutes have passed", 2 * 60 * 1000);//time from 1 minute to 2 minutes
        timeLog = 120;
        messageDelay("5 minutes have passed", 5 * 60 * 1000);//time from 2 minutes to 5 minutes
        timeLog = 300;
        messageDelay("10 minutes have passed", 10 * 60 * 1000);//time from 5 minutes to 10 minutes
        timeLog = 600;
        starSystem();
    }


    public static void messageDelay(String messageShown, int delayValue) {
        java.util.Timer timer = new java.util.Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println();
                System.out.println(messageShown);
                //since there could be input requested before this print bring the user cursor to the next line
                System.out.println();
            }
        }, delayValue);
    }

    // star system function
    // this function is called endSequence variable from the main method is true
    // the endSequence variable is set to true when the user has completed the game
    // the timeLog variable is set to the time that the user has taken to complete the game
    //
    // the star system is as follows
    // 5 stars if the user has completed the game in 30 seconds or less
    // 4 stars if the user has completed the game in 31 seconds or more and 60 seconds or less
    // 3 stars if the user has completed the game in 61 seconds or more and 120 seconds or less
    // 2 stars if the user has completed the game in 121 seconds or more and 300 seconds or less
    // 1 star if the user has completed the game in 301 seconds or more and 600 seconds or less
    // 0 stars if the user has completed the game in 601 seconds or more
    private static void starSystem() {
        if (Main.endSequence == true) {
            if (timeLog >= 0 && timeLog <= 30) {
                System.out.println("Congratulations! You have completed the game and earned five stars!");
                System.out.println("☆☆☆☆☆");
            } else if (timeLog >= 31 && timeLog <= 60) {
                System.out.println("Congratulations! You have completed the game and earned four stars!");
                System.out.println("☆☆☆☆");
            } else if (timeLog >= 61 && timeLog <= 120) {
                System.out.println("Congratulations! You have completed the game and earned three stars!");
                System.out.println("☆☆☆");
            } else if (timeLog >= 121 && timeLog <= 300) {
                System.out.println("Congratulations! You have completed the game and earned two stars!");
                System.out.println("☆☆");
            } else if (timeLog >= 301 && timeLog <= 600) {
                System.out.println("Congratulations! You have completed the game and earned one star!");
                System.out.println("☆");
            } else if (timeLog >= 601) {
                System.out.println("Congratulations! You have completed the game and earned no stars!");
            }
        }
    }
}
