package com.amber.receiver;

import java.util.regex.Pattern;

/**
 * @Author: Amber
 */
public class TestReceiver extends AbstractReceiver {

    @Override
    public void receiverMessage(Object message) {
        System.out.println(message);
    }
}
