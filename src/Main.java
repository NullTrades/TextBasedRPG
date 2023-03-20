//Your task will be to create a text-based role playing game in Java. This game should take user input, process this input, and then do different actions based on the input. The game should take into account OOP principles (e.g., encapsulation, modularity, polymorphism, inheritance).

/*Modularization
I/P/O structure for user interaction
Decisions made based on this information
Repeated actions via looping
Demonstrate your planning!
Repeat behavior - calling a method with different parameters
E.g., encounter method
E.g., private boolean encounter(String name, int hp){}
How will you be modularizing your project? I will need to see a planning component on what you want to include. Could be commented into code, could be UML Use Case diagrams (but not required)
Comment Requirements:
comment in your understanding of a method in one class: explain usage of parameter/return value type (i.e., could be void!)
comment in somewhere a flag/code you used for debugging - could be a System.out message or a try/catch - explain what you were doing here
Groups - identify who is working on what!
*/

import java.util.Scanner;

public class Main {
    public static boolean menuChoice;
    private static Scanner scanner = new Scanner(System.in);
    private static int sanityBar;
    static boolean endSequence = false;

    public static void main(String[] args) {

        //This will determine what type of result you'll get at the end of the game
        sanityBar = 100;

        //Chelsea: Prints out title
        //Used the dashes in order for the reader to understand and follow along with the game *clarity*
        //Thought about using "\n" but it was easier for us to organize our thoughts by showing the line of dashes
        System.out.println("---------------");
        System.out.println("Countdown Chaos: Exam in 30 Minutes");
        System.out.println("---------------");

        //Calls the menu method
        menuSelection();

        //Calls getShirt method
        int shirt = getShirt();
        //This is tested code to make sure that whatever shirt you choose is returned
        //System.out.println("Shirt: " + shirt);

        //Calls getDrinks method
        int drinks = getDrinks();
        //This is tested code to make sure that whatever drink you choose is returned
        //System.out.println("Drink: " + drinks);

        //Calls wildKaren method
        wildKaren(drinks, shirt);

        //Calls finalResult method
        finalResult();

        //Close the scanner - common courtesy
        scanner.close();
    }

    //DANIEL'S CODE
    //This section of code is for our menu
    //Explains what the game is about or player can choose to play right away
    private static void menuSelection() {
        boolean menuChoice = false;
        while (!menuChoice) {
            System.out.print("Enter your selection (Play[1], About[2]): ");
            String menuChosen = scanner.nextLine();
            if (menuChosen.equals("1")) {
                menuChoice = true;
                Timer.main(null);
            } else if (menuChosen.equals("2")) {
                System.out.println("---------------");
                System.out.println("Context: You woke up 30 minutes before your final exam starts to get into post-secondary school!");
                System.out.println("Objective: Get to the final exam on time, and pass the exam! Make sure to not lose your sanity along the way there...");
                System.out.println("---------------");
                menuChoice = false;
            }
        }
    }

    //DANIEL'S + CHELSEA'S CODE
    //This method is in charge of selecting your shirt for the game
    //It starts off by displaying some context
    //The 2 options are placed within a while loop so that user input error is negated
    //The shirts are assigned a number and then returned
    //This allows for the shirts to be used in other methods, as the code won't know what the user chose without its return
    //Each shirt is also assigned a sanity level, which affects the overall sanity of the user
    //This is also printed out so the user knows their current sanity
    private static int getShirt() {
        System.out.println("---------------");
        System.out.println("It's currently 11:30 am. The final exam starts at 12 sharp and you're still in pyjamas!");
        System.out.println("Choose which shirt to wear! The black one, or the white one!");
        System.out.println("The black shirt will give -10 sanity, while the white short will give +10 Sanity!");
        System.out.println("---------------");

        //This will determine the selection of shirt for future events
        int shirtColour = 0;
        //since we used while(true) we added in the breaks after each option to stop the loop
        while (true) {
            System.out.print("Selection (Black[1], White[2]): ");
            String shirtChosen = scanner.nextLine();
            if (shirtChosen.equals("1")) {
                shirtColour = 1;
                sanityBar = sanityBar - 10;
                // Lose 10 sanity from the sanity bar
                System.out.println("---------------");
                System.out.println("You chose to wear the back shirt!");
                System.out.println("Current Sanity: " + sanityBar);
                break;
            } else if (shirtChosen.equals("2")) {
                shirtColour = 2;
                sanityBar = sanityBar + 10;
                // Gain 10 sanity from the sanity bar
                System.out.println("---------------");
                System.out.println("You chose to wear the white shirt!");
                System.out.println("Current Sanity: " + sanityBar);
                break;
            }
        }
        //We return this value as we need to know what shirt the user chooses in other methods
        return shirtColour;
    }

    //DANIEL'S CODE
    //This code is in charge of selecting what drink you want before the exam
    //The code is pretty much the same as the getShirt method
    private static int getDrinks() {
        System.out.println("---------------");
        System.out.println("It's currently 11:40 am. You decided to buy a drink from SquareBucks to energize!");
        System.out.println("---------------");
        System.out.println("Coffee: Better memory + won’t asleep because of caffeine overload (+20 Sanity)");
        System.out.println("Iced Tea: Won’t fall asleep (+10 Sanity)");
        System.out.println("Water: High chance of dozing off (+0 Sanity)");
        System.out.println("---------------");

        int drinkOption = 0;

        while (true) {
            System.out.print("Selection (Coffee[1], Iced Tea[2], Water [3]): ");
            String drinkChosen = scanner.nextLine();
            if (drinkChosen.equals("1")) {
                drinkOption = 1;
                sanityBar = sanityBar + 10;
                System.out.println("---------------");
                System.out.println("You chose the coffee!");
                System.out.println("---------------");
                System.out.println("Because you chose the coffee, you got an additional 10 Sanity!");
                System.out.println("Current Sanity: " + sanityBar);
                break;
            } else if (drinkChosen.equals("2")) {
                drinkOption = 2;
                sanityBar = sanityBar - 5;
                System.out.println("---------------");
                System.out.println("You chose the iced tea!");
                System.out.println("---------------");
                System.out.println("Because you chose the iced tea, you gian no additional Sanity!");
                System.out.println("Current Sanity: " + sanityBar);
                break;
            } else if (drinkChosen.equals("3")) {
                drinkOption = 3;
                sanityBar = sanityBar - 15;
                System.out.println("---------------");
                System.out.println("You chose the water!");
                System.out.println("---------------");
                System.out.println("Because you chose the water, you lose 10 Sanity!");
                System.out.println("Current Sanity: " + sanityBar);
                break;
            }
        }
        return drinkOption;
    }

    //We all worked on this method, but on different parts of it as it was bigger than the other ones
    //CHELSEA'S CODE
    // This code is in charge of the wild karen encounter
    // Passed drinks and shirt through the methods since that is what determines the sanity *depending on what happens when meeting Karen*
    private static void wildKaren(int drinks, int shirt) {
        System.out.println("---------------");
        System.out.println("It's currently 11:45 am. You're in a rush to get to the final exam. But, on your way there you encounter a WILD KAREN!");
        System.out.println("Wild Karen: Hey, YOU! What drink do you have in your hand?!");
        System.out.println("---------------");

        //This is the random number generator, which will be used to determine certain events by chance
        //Made it so that there's a higher chance of getting the Karen to spill the coffee all over the player
        //Following code will be used if selected drink is coffee
        int currentSanity = 0;
        if (drinks == 1) {
            System.out.println("Having chosen the coffee, the Wild Karen wants to ruin your day!");
            System.out.println("Wild Karen: I WANT THAT COFFEE!!!");
            System.out.println("---------------");

            System.out.println("Will you give it to her, or will you resist?");

            // Used boolean to save time and effort by eliminating inappropriate hits that must be scanned before discarding
            //They connect our search words together to either narrow or broaden the set of results.
            //Same code as the one above
            boolean karenChoice1 = true;
            while (karenChoice1 = true) {
                System.out.print("Selection (Give[1], Resist[2]): ");
                String karenChosen1 = scanner.nextLine();
                if (karenChosen1.equals("1")) {
                    sanityBar = sanityBar - 25;
                    System.out.println("---------------");
                    System.out.println("You generously give your coffee away!");
                    System.out.println("---------------");
                    System.out.println("But now you don't have any caffeine to energize you! So, you lost 20 sanity!");
                    System.out.println("Current Sanity: " + sanityBar);

                } else if (karenChosen1.equals("2")) {
                    System.out.println("You decide to stand up for yourself and defy the crazy Karen!");

                    int dice = (int) (Math.random() * 12 + 1);
                    if (dice >= 1 && dice <= 6) {
                        //This is for when the coffee spills all over your shirt
                        if (shirt == 1) {
                            //This is the black shirt
                            sanityBar = sanityBar - 65;
                            System.out.println("---------------");
                            System.out.println("The coffee spills on your black shirt! Though it spilled over you, at least there's no visible stain.");
                            System.out.println("---------------");
                            System.out.println("You still lost 60 sanity because you burned yourself from the hot drink!");
                            System.out.println("Current Sanity: " + sanityBar);

                        } else if (shirt == 2) {
                            //This is the white shirt
                            sanityBar = sanityBar - 55;
                            System.out.println("---------------");
                            System.out.println("The coffee spills on your white shirt showing a visible stain!");
                            System.out.println("---------------");
                            System.out.println("You lost 50 sanity!");
                            System.out.println("Current Sanity: " + sanityBar);
                        }
                    } else if (dice >= 7 && dice <= 9) {
                        //Karen takes the coffee - code
                        if (shirt == 1) {
                            //This is the black shirt
                            sanityBar = sanityBar - 50;
                            System.out.println("---------------");
                            System.out.println("the Wild Karen took your coffee and ran away with the wind!");
                            System.out.println("---------------");
                            System.out.println("You lost 45 sanity!");
                            System.out.println("Current Sanity: " + sanityBar);

                        } else if (shirt == 2) {
                            //This is the white shirt
                            sanityBar = sanityBar - 40;
                            System.out.println("---------------");
                            System.out.println("the Wild Karen took your coffee and ran away with the wind!");
                            System.out.println("---------------");
                            System.out.println("You lost 35 sanity!");
                            System.out.println("Current Sanity: " + sanityBar);
                        }
                    } else if (dice >= 10 && dice <= 12) {
                        //You keep the coffee - code
                        System.out.println("---------------");
                        System.out.println("Karen doesn't see you and you keep your coffee!");
                        System.out.println("---------------");
                        System.out.println("You lost 0 sanity!");
                        System.out.println("Current Sanity: " + sanityBar);
                    }
                    //This is to break out of the karen loop
                    break;
                }
            }

            //Following code will be used if selected drink is iced tea
        } else if (drinks == 2) {
            int dice = (int) (Math.random() * 12 + 1);

            System.out.println("Having chosen the iced tea, the wild karen wants to ruin your day!");
            System.out.println("---------------");
            System.out.println("Wild Karen: I WANT THAT ICED TEA!!!");
            System.out.println("---------------");

            System.out.println("Will you give it to her, or will you resist?");

            boolean karenChoice2 = true;
            while (karenChoice2 = true) {
                System.out.print("Selection (Give[1], Resist[2]: ");
                String karenChosen2 = scanner.nextLine();
                if (karenChosen2.equals("1")) {
                    sanityBar = sanityBar - 20;
                    System.out.println("---------------");
                    System.out.println("You generously give your iced tea away!");
                    System.out.println("---------------");
                    System.out.println("But now you don't have a refreshing drink to sustain you! So, you lose 20 sanity :(");
                    System.out.println("Current Sanity: " + sanityBar);

                } else if (karenChosen2.equals("2")) {
                    System.out.println("You decide to stand up for yourself and defy the crazy Karen!");

                    if (dice >= 1 && dice <= 6) {
                        //Code here for karen takes iced tea
                        if (shirt == 1) {
                            sanityBar = sanityBar - 40;
                            System.out.println("---------------");
                            System.out.println("the Wild Karen took your Iced Tea and ran away with the wind!");
                            System.out.println("---------------");
                            System.out.println("You lost 35 sanity!");
                            System.out.println("Current Sanity: " + sanityBar);

                        } else if (shirt == 2) {
                            sanityBar = sanityBar - 40;
                            System.out.println("---------------");
                            System.out.println("the Wild Karen took your Iced Tea and ran away with the wind!");
                            System.out.println("---------------");
                            System.out.println("You lost 35 sanity!");
                            System.out.println("Current Sanity: " + sanityBar);

                        }
                        //This is to break out of the karen loop
                        break;
                    } else if (dice >= 7 && dice <= 12) {
                        //Code here for you keeping the iced tea
                        System.out.println("---------------");
                        System.out.println("The wild Karen doesn't like cold drinks and you keep your Iced Tea!");
                        System.out.println("---------------");
                        System.out.println("You lost 0 sanity!");
                        System.out.println("Current Sanity: " + sanityBar);
                        //This is to break out of the karen loop
                        break;
                    }
                }
            }
            //Following code will be used if selected drink is water
        } else if (drinks == 3) {
            sanityBar = sanityBar - 10;
            System.out.println("You reveal to the Wild Karen that your drink was a simple cup of water!");
            System.out.println("---------------");
            System.out.println("Wild Karen: ONLY WATER?! YOU'RE POOR!!!");
            System.out.println("---------------");
            System.out.println("The Wild Karen leaves in anger, leaving you to dwell on her harsh comment...");
            System.out.println("Current Sanity: " + sanityBar);
        }
    }

    // OSY'S CODE
    // This method is in charge of what education you'll get depending on sanity
    private static void finalResult() {
        endSequence = true;
        System.out.println("---------------");
        //letting the user know their final sanity
        System.out.println("Your final sanity is: " + sanityBar);
        System.out.println("---------------");
        //Your final sanity will determine what university (if any) you'll go to!
        if (sanityBar >= 100) {
            System.out.println("You ascended to Heaven's University Honors Program!");
        } else if (sanityBar >= 81 && sanityBar < 100) {
            System.out.println("CONGRATULATIONS! You got into Harvard University!");
        } else if (sanityBar <= 80 && sanityBar >= 61) {
            System.out.println("You Applied for University of Toronto Engineering program and you got accepted!");
        } else if (sanityBar <= 60 && sanityBar >= 31) {
            System.out.println("Although you applied for U of T and Harvard, they both rejected your offer and you're now enrolled in a community college");
        } else if (sanityBar <= 30 && sanityBar >= 11) {
            System.out.println("You failed life bro. Retake High school again...");
        } else if (sanityBar <= 10) {
            System.out.println("You went mentally insane and got locked up in an asylum. This is the worst ending...");
        }
    }
}