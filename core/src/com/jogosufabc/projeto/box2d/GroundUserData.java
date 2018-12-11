package com.jogosufabc.projeto.box2d;

import com.jogosufabc.projeto.enums.UserDataType;

public class GroundUserData extends UserData {

    public GroundUserData(float width, float height) {
        super(width, height);
        userDataType = UserDataType.GROUND;
    }

}
