package com.myloginsystem.usinglist;

public class Users {

    private int profileImage;
    private String name;
    private String lastMsg;


    public void setProfileImage(int profileImage) {
        this.profileImage = profileImage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastMsg(String lastMsg) {
        this.lastMsg = lastMsg;
    }

    public int getProfileImage() {
        return profileImage;
    }

    public String getName() {
        return name;
    }

    public String getLastMsg() {
        return lastMsg;
    }
}
