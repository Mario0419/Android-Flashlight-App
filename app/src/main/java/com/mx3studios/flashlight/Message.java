package com.mx3studios.flashlight;

/**
 * Created by Mario on 9/7/2015.
 */

public class Message {

    private String mMessage;


    Message(String m){
        mMessage = m;

    }

    private void validateMessage(){
        String newMessage = "";
        for(int i = 0; i < mMessage.length(); i++) {
            if (Character.isDigit(mMessage.charAt(i)) || Character.isSpaceChar(mMessage.charAt(i)) || Character.isLetter(mMessage.charAt(i))) {

                newMessage += mMessage.charAt(i) + "";
            }else if(mMessage.charAt(i) == '.'){
                newMessage += " ";
            }else{
                continue;
            }
        }
        mMessage = newMessage;
    }
}
