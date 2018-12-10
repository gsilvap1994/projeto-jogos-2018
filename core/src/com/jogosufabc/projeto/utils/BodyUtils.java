package com.jogosufabc.projeto.utils;

import com.badlogic.gdx.physics.box2d.Body;
import com.jogosufabc.projeto.box2d.UserData;
import com.jogosufabc.projeto.enums.UserDataType;

public class BodyUtils {

    public static boolean bodyIsMainCharacter(Body body) {
        UserData userData = (UserData) body.getUserData();

        return userData != null && userData.getUserDataType() == UserDataType.MAIN_CHARACTER;
    }

    public static boolean bodyIsGround(Body body) {
        UserData userData = (UserData) body.getUserData();

        return userData != null && userData.getUserDataType() == UserDataType.GROUND;
    }
    
    public static boolean bodyInBounds(Body body) {
    	UserData userData = (UserData) body.getUserData();
    	
    	switch(userData.getUserDataType()) {
	    	case MAIN_CHARACTER:
	    	case ENEMY:
	    		return body.getPosition().x + userData.getWidth() / 2 > 0;
		default:
			break;
    	}
    	
    	return true;
    }
    
    public static boolean bodyIsEnemy (Body body) {
    	UserData userData = (UserData) body.getUserData();
    	
    	return userData != null && userData.getUserDataType() == UserDataType.ENEMY;
    }

}