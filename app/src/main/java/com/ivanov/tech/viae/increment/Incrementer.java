package com.ivanov.tech.viae.increment;

import android.icu.lang.UCharacter;

/**
 * Интерфейс для последующей реализации алгоритма инкремент
 *
 * @see Incrementer#getNumber()
 * @see Incrementer#incrementNumber()
 * @see Incrementer#setMaximumValue(T)
 */
public interface Incrementer<T extends Comparable> {
    /**
     * Возвращает текущее число. В самом начале это ноль.
     *
     * @return Текущее значение. В самом начале это ноль.
     * @see Incrementer#incrementNumber()
     * @see Incrementer#setMaximumValue(T)
     */
    T getNumber();

    /**
     * Увеличивает текущее число на один. После каждого вызова этого
     * метода {@link Incrementer#getNumber()} будет возвращать число на один больше.
     */
    void incrementNumber();

    /**
     * Устанавливает максимальное значение текущего числа.
     * Когда при вызове {@link Incrementer#incrementNumber()} текущее число достигает
     * этого значения, оно обнуляется, т.е. {@link Incrementer#getNumber()} начинает
     * снова возвращать ноль, и снова один после следующего
     * вызова {@link Incrementer#incrementNumber()} и так далее.
     * По умолчанию максимум -- максимальное значение ({@link T}).
     * Если при смене максимального значения число резко начинает
     * превышать максимальное значение, то число надо обнулить.
     * Нельзя позволять установить тут число меньше нуля.
     *
     * @param maximumValue Число на которое сменится максимальное значение
     */
    void setMaximumValue(T maximumValue);
}
