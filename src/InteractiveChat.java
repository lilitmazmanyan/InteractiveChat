import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class InteractiveChat {
    static int numberOfParticipants;
    static ArrayList<Member> arr = new ArrayList<>();
    static ArrayList<String> conv = new ArrayList<>();

    public static int numOfParticipants() {
        System.out.println("Please enter the number of members");
        Scanner num = new Scanner(System.in);
        numberOfParticipants = num.nextInt();
        return numberOfParticipants;
    }

    public static ArrayList<Member> initializeArr(int numberOfParticipants) {
        for (int i = 0; i < numberOfParticipants; i++) {
            arr.add(new Member("Member" + (i + 1)));
        }
        return arr;
    }

    public static void chatPart() {
        int speakerIndex = 0;

        System.out.println("Please enter 1 if you want to send a messange and 0 to exit");
        Scanner in = new Scanner(System.in);
        int decision = in.nextInt();

        Scanner msg = new Scanner(System.in);

        if (decision == 1) {
            Date date = new Date();

            String message = msg.nextLine();
            String forAdd = date + " " + arr.get(speakerIndex).name + " " + message;
            conv.add(forAdd);
            speakerIndex++;

        } else if (decision == 0) {
            msg.close();
            System.out.println("You rejected");
            printArr(conv);
        } else {
            System.out.println("Not a valid number");
        }

    }


    public static void printArr(ArrayList<String> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }

    public static void main(String[] args) {
//        numOfParticipants();
        initializeArr(numOfParticipants());
        for (int i = 0; i < numberOfParticipants; i++) {
            chatPart();
        }
        printArr(conv);

    }
}
