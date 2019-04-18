package com.ivanov.tech.viae.increment;

public class IntegerIncrementer implements Incrementer<Integer>{

    protected Integer value = 0;
    protected Integer maxValue = Integer.MAX_VALUE;

    @Override
    public Integer getNumber() {
        return value;
    }

    @Override
    public void incrementNumber() {
        value = value+1;
        if (value > maxValue - 1) value = 0;
    }

    @Override
    public void setMaximumValue(Integer maximumValue) {
        if (maximumValue < 0) throw new IllegalArgumentException("Negative argument isn't allowed");
        if (maximumValue <= value) value = 0;

        maxValue = maximumValue;
    }

}
