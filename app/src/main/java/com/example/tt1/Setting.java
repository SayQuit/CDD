package com.example.tt1;

public class Setting {
    private String UserName;
    int musicID;

    void setUserName(String Name){
        this.UserName=Name;
    }
    String getUserName(){
        return this.UserName;
    }
    void setMusicID(int ID){
        this.musicID=ID;
    }
    int getMusic(){
        return this.musicID;
    }

}
