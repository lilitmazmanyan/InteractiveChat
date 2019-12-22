import java.util.*;

public class InteractiveChat {
    private static ArrayList<Member> arr = new ArrayList<>();
    private static ArrayList<String> conv = new ArrayList<>();

    private static int numOfParticipants() {
        System.out.println("Please enter the number of members");
        Scanner num = new Scanner(System.in);
        return num.nextInt();
    }

    private static void initializeArr(int numberOfParticipants) {
        for (int i = 0; i < numberOfParticipants; i++) {
            arr.add(new Member("Member" + (i + 1)));
        }
    }

    private static void doAction(Member member) {
        System.out.println(member.name + "\nPlease enter 1 if you want to send a message and 2 to exit");
        Scanner in = new Scanner(System.in);
        int decision = in.nextInt();

        switch (decision) {
            case 1:
                System.out.println("Please enter your message");
                Scanner msg = new Scanner(System.in);
                Date date = new Date();
                String message = msg.nextLine();
                String forAdd = date + " " + member.name + " " + message;
                conv.add(forAdd);
                break;

            case 2:
                arr.remove(member);
                System.out.println("You left chat");
                break;

            default:
                System.out.println("Not a valid action");
        }
    }


    private static void printArr(ArrayList<String> arr) {
        for (String s : arr) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        initializeArr(numOfParticipants());
        Random random = new Random();
        while (!arr.isEmpty()) {
            doAction(arr.get(random.nextInt(arr.size())));
        }
        printArr(conv);
    }
}