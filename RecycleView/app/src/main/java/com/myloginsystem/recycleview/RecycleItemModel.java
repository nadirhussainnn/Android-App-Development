package com.myloginsystem.recycleview;

public class RecycleItemModel {

    private int profileImage;
    private String userName;
    private String lastMessage;
    private String lastMessageTime;

    public RecycleItemModel(int profileImage, String userName, String lastMessage, String lastMessageTime){
        this.profileImage=profileImage;
        this.userName=userName;
        this.lastMessage=lastMessage;
        this.lastMessageTime=lastMessageTime;
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

    public String getLastMessageTime() {
        return lastMessageTime;
    }
}
