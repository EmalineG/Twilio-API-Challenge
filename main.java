import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.net.URI;
import java.util.Arrays;

public class main {
    /*CAN GET THESE VALUES AT CONSOLE.TWILIO.COM AFTER REGISTERING*/
    /*SET VARIABLES: RUN -> EDIT CONFIGURATIONS -> ENVIRONMENT VARIABLES*/
    public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");
    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(
                /* INSERT PHONE NUMBER THAT WILL RECEIVE TEXT */
                new PhoneNumber("TO PHONE NUMBER"),
                /* INSERT PHONE NUMBER THAT WILL SEND TEXT (TWILIO NUMBER)*/
                new PhoneNumber("FROM PHONE NUMBER"),
                /* INSERT TEXT MESSAGE TO SEND */
                "TEXT MESSAGE HERE")
                /* CHANGE IMAGE URL TO YOUR DESIRED IMAGE URL */
                .setMediaUrl(
                        Arrays.asList(URI.create("https://pbs.twimg.com/media/Enm7QC7XYAEO-4L?format=jpg&name=large")))
                /* SET UP YOUR OWN BIN & INSERT BIN URL HERE TO TRACK DELIVERY STATUS OF TEXTS*/
                .setStatusCallback(URI.create("https://www.toptal.com/developers/postbin/YOURBINNUMBER"))
                .create();

/*RETURNS MESSAGE ID AND RETURNS 0 UPON SUCCESSFUL SEND*/
        System.out.println(message.getSid());
    }
}