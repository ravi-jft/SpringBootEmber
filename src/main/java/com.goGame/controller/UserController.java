package com.goGame.controller;

import com.goGame.service.UserService;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import com.twilio.sdk.resource.instance.Sms;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import com.goGame.commands.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ravi on 4/7/17.
 */
@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    String webhook_url = "https://hooks.slack.com/services/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";
    private String text;
    private String username;
    private String channel;
    //String payload= {"username": "raviaggar", "channel": "#general", "text": "Hi, I am Ravi Kumar"};
    private String TWILIO_NUMBER = "+12562174196";
    private String ACCOUNT_SID = "AC86c4dde2465f10bd780956ffae3d79e2";
    private String AUTH_TOKEN = "cbc5c25710fe642b35743918794b3644";


    @RequestMapping("/index")
    public String index(){
        System.out.println("=======index===========");
        return "index";
    }

    @RequestMapping(value = "/sendmail",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = org.springframework.http.HttpStatus.OK)
    public void sendmail(@RequestBody Email email){
        userService.sendSimpleEmail(email);
    }

    @RequestMapping(value = "/showChannels")
    public String channelsList(){

     /*   String channelUrl = "https://slack.com/api/channels.list?token=xoxp-187863030016-188552177570-189628865826-a149855214b6eb1cf6e12f02c5c99b3b&pretty=1";
        return "redirect: /index";*/
        return "showChannelList";
    }

    @RequestMapping(value = "/sendslack")
    public String sendslack(){
        try {

            HttpClient c = HttpClientBuilder.create().build();
            HttpPost p = new HttpPost(webhook_url);
            p.setEntity(new StringEntity(
                    "payload= {\"username\": \"raviaggar\", \"icon_url\": \"https://media.glassdoor.com/sqll/780298/jellyfish-technologies-squarelogo-1427198372245.png\", \"channel\": \"#general\", \"text\": \"Hi, I am Ravi Kumar\"}"
            ));
            p.setHeader(new Header() {
                @Override
                public String getName() {
                    return "Content-Type";
                }

                @Override
                public String getValue() {
                    return "application/x-www-form-urlencoded";
                }

                @Override
                public HeaderElement[] getElements() throws ParseException {
                    return new HeaderElement[0];
                }
            });
            HttpResponse r = c.execute(p);
            System.out.println("kkkkkkkk"+ r.getEntity().getContent());
        }
        catch (Exception e){
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return "redirect:/index";
    }

/*    @RequestMapping(value = "/sendSMS",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void sendSMS(@RequestBody Sms sms) throws TwilioRestException {
        TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID,AUTH_TOKEN);
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("Body",sms.getContent()));
        params.add(new BasicNameValuePair("To","+918467972264"));
        params.add(new BasicNameValuePair("From",TWILIO_NUMBER));

        MessageFactory messageFactory = client.getAccount().getMessageFactory();
        Message message = messageFactory.create(params);
    }*/
}
