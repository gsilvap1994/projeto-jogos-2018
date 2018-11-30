package com.jogosufabc.projeto.box2d;

import com.jogosufabc.projeto.enums.UserDataType;

public abstract class UserData {

    protected UserDataType userDataType;

    public UserData() {

    }

    public UserDataType getUserDataType() {
        return userDataType;
    }

}
