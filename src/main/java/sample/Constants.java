package sample;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
public class Constants {

    public Constants(){

    }
    private final static String PHONE_NUMBER = " +18582120560";
    private final static String MY_PHONE_NUMBER = " +100000000";

    private final static String ACCOUNT_SID = "ACf5d09859f655b8879a3613251424e673";
    private final static String AUTH_TOKEN = "bb0ff630d6666a76b64495d4cece2621";

    public  void TwilioMessage() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message messageCreator = Message.creator(new PhoneNumber(MY_PHONE_NUMBER), new PhoneNumber(PHONE_NUMBER),
                "All water used. User intervention required.").create();

        System.out.println(messageCreator.getSid());
    }
}


//
