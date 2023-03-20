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
//        messageDelay("5 seconds have passed", 5 * 1000);//time from 0 to 5 seconds
        messageDelay("30 seconds have passed", 30 * 1000);//time from 0 to 30 seconds
        timeLog = 30;
        messageDelay("1 minute has passed", 60 * 1000);//time from 30 seconds to 1 minute
        timeLog = 60;
        messageDelay("2 minutes have passed", 2*60 * 1000);//time from 1 minute to 2 minutes
        timeLog = 120;
        messageDelay("5 minutes have passed", 5 * 60 * 1000);//time from 2 minutes to 5 minutes
        timeLog = 300;
        messageDelay("10 minutes have passed", 10 * 60 * 1000);//time from 5 minutes to 10 minutes
        timeLog = 600;
        starSystem();
    }

    private static void starSystem() {
        if(Main.endSequence == true){
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

//I wish you goodluck with this

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

}
