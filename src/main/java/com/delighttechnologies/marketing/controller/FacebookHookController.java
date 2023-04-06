package com.delighttechnologies.marketing.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/")
public class FacebookHookController {
    @GetMapping("webhooks")
    public ResponseEntity<String> checkStatus(@RequestParam("hub.mode") Integer hubMode,@RequestParam("hub.challenge") String hubChallenge,@RequestParam("hub.verify_token") String hubVerifyToken){
        //https://www.your-clever-domain-name.com/webhooks?hub.mode=subscribe&hub.challenge=1158201444&hub.verify_token=meatyhamhock
        String receivedData = "hubMode : " + hubMode +" - "+" hubChallenge : " + hubChallenge +" - "+" hubVerifyToken : " + hubVerifyToken;
        return new ResponseEntity<>(hubChallenge, HttpStatus.OK);
    }

    @PostMapping("/test")
    public ResponseEntity<String> connectWebHook(@RequestBody String data){
        return new ResponseEntity<>("Working" + data, HttpStatus.OK);
    }
}
