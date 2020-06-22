package com.amber.receiver;

/**
 * @Author: Amber
 */
public class AmberReceiver extends AbstractReceiver {

    @Override
    public void receiverMessage(Object message) {
        System.out.println(message);
    }
}
