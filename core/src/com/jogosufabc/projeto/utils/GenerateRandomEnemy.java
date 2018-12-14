package com.jogosufabc.projeto.utils;

import com.jogosufabc.projeto.enums.EnemyType;

import java.util.Random;

public class GenerateRandomEnemy {
	
	public static EnemyType getRandomEnemyType() {
		RandomEnum<EnemyType> randomEnum = new RandomEnum<EnemyType>(EnemyType.class);
		return randomEnum.random();
	}
	
	/**
     * reference - Stack Overflow (http://stackoverflow.com/a/1973018)
     */
	
	private static class RandomEnum<E extends Enum<?>> {

        private static final Random RND = new Random();
        private final E[] values;

        public RandomEnum(Class<E> token) {
            values = token.getEnumConstants();
        }

        public E random() {
            return values[RND.nextInt(values.length)];
        }
    }
}
