package com.thegeekyasian.controllers;

import com.thegeekyasian.sockets.Socket;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.EncodeException;
import java.io.IOException;

/**
 * Created by The Geeky Asian
 */
@Controller
@RequestMapping(value = "/")
public class AppController {
    @RequestMapping(value = "/broadcast")
    public ResponseEntity<String> testSocket() throws IOException, EncodeException {
        String message="hello world";
        Socket.broadcast(message);
        String successMessage = String.format("Operation completed! " +
                "Data broadcast to %s listeners", Socket.listeners.size());
        return new ResponseEntity<>(successMessage, HttpStatus.OK);
    }
}
