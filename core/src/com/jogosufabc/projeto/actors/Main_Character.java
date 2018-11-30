package com.jogosufabc.projeto.actors;

import com.badlogic.gdx.physics.box2d.Body;
import com.jogosufabc.projeto.box2d.Main_CharacterUserData;

public class Main_Character extends GameActor {

	private boolean jumping;

    public Main_Character(Body body) {
        super(body);
    }

    @Override
    public Main_CharacterUserData getUserData() {
        return (Main_CharacterUserData) userData;
    }

    public void jump() {

        if (!jumping) {
            body.applyLinearImpulse(getUserData().getJumpingLinearImpulse(), body.getWorldCenter(), true);
            jumping = true;
        }

    }

    public void landed() {
        jumping = false;
    }
}