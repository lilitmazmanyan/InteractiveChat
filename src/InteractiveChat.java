import java.util.*;

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


    public static void chatPart(Member member) {
        int index = arr.indexOf(member);
        System.out.println("Member" + (index + 1) + "\nPlease enter 1 if you want to send a messange and 2 to exit");
        Scanner in = new Scanner(System.in);
        int decision = in.nextInt();

        System.out.println("Please enter your message");
        Scanner msg = new Scanner(System.in);


        switch (decision) {
            case 1:
                Date date = new Date();
                String message = msg.nextLine();
                String forAdd = date + " " + arr.get(speakerIndex).name + " " + message;
                conv.add(forAdd);
                break;

            case 2:
                arr.remove(arr.get(speakerIndex));
                System.out.println("You rejected");
                break;

            default:
                System.out.println("Not a valid number");
        }
    }


    public static void printArr(ArrayList<String> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }

    public static Member getRandom(ArrayList<Member> arr) {
        Random mem = new Random();
        int number = mem.nextInt((arr.size() - 1));
        return arr.get(number);
    }

    static int speakerIndex = 0;

    public static void main(String[] args) {
        initializeArr(numOfParticipants());

        while (!arr.isEmpty()) {
            Member m1 = getRandom(arr);
            chatPart(m1);
        }
        printArr(conv);
    }
}
