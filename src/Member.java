import java.util.Date;

public class Member {
    String name;
    String message;
    Date sentMessageTime;

    public Member(String name) {
        this.name = name;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Date getSentMessageTime() {
        return sentMessageTime;
    }

    public void setSentMessageTime(Date sentMessageTime) {
        this.sentMessageTime = sentMessageTime;
    }

}