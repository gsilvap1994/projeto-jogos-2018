package com.jogosufabc.projeto.box2d;

import com.badlogic.gdx.math.Vector2;
import com.jogosufabc.projeto.enums.UserDataType;
import com.jogosufabc.projeto.utils.Constants;

public class MainCharacterUserData extends UserData {
	
    private final Vector2 runningPosition = new Vector2(Constants.MAIN_CHARACTER_X, Constants.MAIN_CHARACTER_Y);
    private final Vector2 dodgePosition = new Vector2(Constants.MAIN_CHARACTER_DODGE_X, Constants.MAIN_CHARACTER_DODGE_Y);
    private Vector2 jumpingLinearImpulse;

    public MainCharacterUserData(float width, float height) {
        super(width, height);
        jumpingLinearImpulse = Constants.MAIN_CHARACTER_JUMPING_LINEAR_IMPULSE;
        userDataType = UserDataType.MAIN_CHARACTER;
    }

    public Vector2 getJumpingLinearImpulse() {
        return jumpingLinearImpulse;
    }

    public void setJumpingLinearImpulse(Vector2 jumpingLinearImpulse) {
        this.jumpingLinearImpulse = jumpingLinearImpulse;
    }
    
    public float getDodgeAngle() {
        
        return (float) (-90f * (Math.PI / 180f));
    }

    public Vector2 getRunningPosition() {
        return runningPosition;
    }

    public Vector2 getDodgePosition() {
        return dodgePosition;
    }
    
    public float getHitAngularImpulse() {
        return Constants.MAIN_CHARACTER_HIT_ANGULAR_IMPULSE;
    }

}
