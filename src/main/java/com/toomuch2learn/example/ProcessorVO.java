package com.toomuch2learn.example;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProcessorVO {
    
    private String valueFromA;
    private BigDecimal valueFromB;
    private LocalDate valueFromC;

    public String getValueFromA() {
        return valueFromA;
    }

    public void setValueFromA(String valueFromA) {
        this.valueFromA = valueFromA;
    }

    public BigDecimal getValueFromB() {
        return valueFromB;
    }

    public void setValueFromB(BigDecimal valueFromB) {
        this.valueFromB = valueFromB;
    }

    public LocalDate getValueFromC() {
        return valueFromC;
    }

    public void setValueFromC(LocalDate valueFromC) {
        this.valueFromC = valueFromC;
    }

    @Override
    public String toString() {
        return "ProcessorVO{" +
            "valueFromA='" + valueFromA + '\'' +
            ", valueFromB=" + valueFromB +
            ", valueFromC=" + valueFromC +
            '}';
    }
}
