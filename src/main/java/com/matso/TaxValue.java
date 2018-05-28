package com.matso;

public class TaxValue {
    private char currency;
    private long value;

    public char getCurrency() {
        return currency;
    }

    public void setCurrency(char currency) {
        this.currency = currency;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TaxValue{" +
                "currency=" + currency +
                ", value=" + value +
                '}';
    }
}
