package com.matso;

public class Compensation {
    private char currency;
    private long salary;
    private TaxValue taxValue;

    public void setTaxValue(TaxValue taxValue) {
        this.taxValue = taxValue;
    }

    public TaxValue getTaxValue() {
        return taxValue;
    }

    public void setCurrency(char currency) {
        this.currency = currency;
    }
    public void setSalary(long salary) {
        this.salary = salary;
    }
    public char getCurrency() {
        return this.currency;
    }
    public long getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        return "Compensation{" +
                "currency=" + currency +
                ", salary=" + salary +
                ", taxValue=" + taxValue +
                '}';
    }
}
