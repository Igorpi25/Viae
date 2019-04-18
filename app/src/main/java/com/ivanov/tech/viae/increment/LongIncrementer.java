package com.ivanov.tech.viae.increment;

public class LongIncrementer implements Incrementer<Long> {

    Long value = 0L;
    Long maxValue = Long.MAX_VALUE;

    @Override
    public Long getNumber() {
        return value;
    }

    @Override
    public void incrementNumber() {
        value = value+1;
        if (value > maxValue - 1) {
            value = 0L;
        }
    }

    @Override
    public void setMaximumValue(Long maximumValue) {
        if (maximumValue < 0) throw new IllegalArgumentException("Negative max value is not allowed");
        if (maximumValue <= value) value = 0L;

        maxValue = maximumValue;
    }
}