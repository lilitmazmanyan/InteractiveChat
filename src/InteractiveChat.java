import java.util.*;

public class InteractiveChat {
    private static ArrayList<Member> arr = new ArrayList<>();
    private static ArrayList<String> conv = new ArrayList<>();
    private static  ArrayList<Member> activeMemb = new ArrayList<>();

    private static void chatPart(Member member) {
        int index = arr.indexOf(member);
        System.out.println("Member" + (index + 1) + "\nPlease enter 1 if you want to send a messange and 2 to exit");
        Scanner in = new Scanner(System.in);
        int decision = in.nextInt();

        System.out.println("Please enter your message");
        Scanner msg = new Scanner(System.in);


        int speakerIndex = 0;
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
    private static void printArr(ArrayList<String> arr) {
        for (String s : arr) {
            System.out.println(s);
        }
    }
    private static Member getRandom(ArrayList<Member> arr) {
        Random mem = new Random();
        int number = mem.nextInt(arr.size());
        return arr.get(number);
    }
    public static void main(String[] args) {
        initializeArr(numOfParticipants());

        while (!arr.isEmpty()) {
            Member m1 = getRandom(arr);
            chatPart(m1);
        }
        printArr(conv);
    }
}
