package operator.service.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.stereotype.Service;

@Service
public class SmsService {

    public static final String ACCOUNT_SID = "ACb3858fd628da1777ea302a892aedf50c";
    public static final String AUTH_TOKEN = "2e12ed60ee2fdf2ad5433beec444f981";

    public void sendSms(String phoneNumber) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+212"+phoneNumber),
                new com.twilio.type.PhoneNumber("+17164188144"),
                "Votre recharche à été bien effectuée !")
                .create();
    }

}
