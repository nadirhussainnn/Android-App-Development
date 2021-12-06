package com.myloginsystem.mui_finalapp;

public class Users {

    int profileImage;
    String name;
    String lastMessage;
    String time;

    public void setProfileImage(int profileImage) {
        this.profileImage = profileImage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getProfileImage() {
        return profileImage;
    }

    public String getName() {
        return name;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public String getTime() {
        return time;
    }
}
