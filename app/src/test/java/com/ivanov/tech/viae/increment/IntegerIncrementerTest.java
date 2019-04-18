package com.ivanov.tech.viae.increment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class IntegerIncrementerTest {

    private IntegerIncrementer incrementer;

    @Before
    public void createIncrementer() {
        incrementer = new IntegerIncrementer();
    }

    /**
     * @see Incrementer#getNumber()
     * Возвращает текущее число.
     * В самом начале это ноль.
     */
    @Test
    public void getNumber_isZeroInitially() {

        int initialValue = incrementer.getNumber();

        assertEquals(0, initialValue);
    }

    /**
     * @see IntegerIncrementer#incrementNumber()
     * Увеличивает текущее число на один. После каждого вызова этого
     * метода getNumber() будет возвращать число на один больше.
     */
    @Test
    public void incrementNumber_increasesByOne() {
        for (int i = 0; i < 5; i++) {
            int initialValue = incrementer.getNumber();

            incrementer.incrementNumber();
            int incremented_value = incrementer.getNumber();

            assertEquals(incremented_value, initialValue + 1);
        }

        int value = incrementer.getNumber();
        assertEquals(5, value);
    }

    /**
     * @see IntegerIncrementer#setMaximumValue(Integer)
     * Устанавливает максимальное значение текущего числа.
     *
     * Если при смене максимального значения число резко начинает
     * превышать максимальное значение, то число надо обнулить.
     */
    public void setMaximumValue_resetsWhenReachMaxValue() {
        incrementer.setMaximumValue(5);

        int initialValue = incrementer.getNumber();
        assertEquals("Initially value equals 0", 0, initialValue);

        for (int i = 0; i < 5; i++) {
            incrementer.incrementNumber();
        }

        int value = incrementer.getNumber();

        assertEquals("When reach maxValue a value equals 0", 0, value);

        incrementer.incrementNumber();
        value = incrementer.getNumber();

        assertEquals("After reaching maxValue it still increments", 1, value);
    }

    /**
     * @see IntegerIncrementer#setMaximumValue(Integer)
     * Устанавливает максимальное значение текущего числа.
     *
     * По умолчанию максимум -- максимальное значение int.
     */
    @Test
    public void setMaximumValue_isTypesMaxValueByDefault() {

        long value = new IntegerIncrementer(){
            public int getMaximum() {
                return maxValue;
            }
        }.getMaximum();

        assertEquals("maxValue by defalt is Integer.MAX_VALUE", Integer.MAX_VALUE, value);
    }


    /**
     * @see IntegerIncrementer#setMaximumValue(Integer)
     * Устанавливает максимальное значение текущего числа.
     *
     * Если при смене максимального значения число резко начинает
     * превышать максимальное значение, то число надо обнулить.
     */
    @Test
    public void setMaximumValue_resetsIfExceed() {

        while (incrementer.getNumber() < 6) {
            incrementer.incrementNumber();
        }

        incrementer.setMaximumValue(5);
        int value = incrementer.getNumber();

        assertEquals("Value reset to 0 when value exceed maximum", 0, value);
    }

    /**
     * @see IntegerIncrementer#setMaximumValue(Integer)
     * Устанавливает максимальное значение текущего числа.
     *
     * Нельзя позволять установить тут число меньше нуля.
     */
    @Test(expected = IllegalArgumentException.class)
    public void setMaximumValue_throwsIfNegativeMaxValue() {
        incrementer.setMaximumValue(-5);
    }
}
