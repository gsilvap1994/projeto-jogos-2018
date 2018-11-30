package com.jogosufabc.projeto.actors;

import com.badlogic.gdx.physics.box2d.Body;
import com.jogosufabc.projeto.box2d.MainCharacterUserData;

public class MainCharacter extends GameActor {

	private boolean jumping;

    public MainCharacter(Body body) {
        super(body);
    }

    @Override
    public MainCharacterUserData getUserData() {
        return (MainCharacterUserData) userData;
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