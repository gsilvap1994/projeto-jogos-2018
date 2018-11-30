package com.jogosufabc.projeto.box2d;

import com.badlogic.gdx.math.Vector2;
import com.jogosufabc.projeto.enums.UserDataType;
import com.jogosufabc.projeto.utils.Constants;

public class Main_CharacterUserData extends UserData {

    private Vector2 jumpingLinearImpulse;

    public Main_CharacterUserData() {
        super();
        jumpingLinearImpulse = Constants.MAIN_CHARACTER_JUMPING_LINEAR_IMPULSE;
        userDataType = UserDataType.MAIN_CHARACTER;
    }

    public Vector2 getJumpingLinearImpulse() {
        return jumpingLinearImpulse;
    }

    public void setJumpingLinearImpulse(Vector2 jumpingLinearImpulse) {
        this.jumpingLinearImpulse = jumpingLinearImpulse;
    }

}
