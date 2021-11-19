package com.myloginsystem.retrofit_consume_apis;

public class RecycleItemModel {

    private int profileImage;
    private String userName, lastMessage,messageTime;


    public RecycleItemModel(int profileImage, String userName, String lastMessage, String messageTime){
            this.profileImage=profileImage;
            this.userName=userName;
            this.lastMessage=lastMessage;
            this.messageTime=messageTime;
    }

    public int getProfileImage() {
        return profileImage;
    }

    public String getUserName() {
        return userName;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public String getMessageTime() {
        return messageTime;
    }
}
