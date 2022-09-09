package pl.cyber.trainess.demo.dto;

import java.beans.ConstructorProperties;

public class RownanieKwRequest {

    private Double a;
    private Double b;
    private Double c;

    @ConstructorProperties({"a","b","c"})
    public RownanieKwRequest(final Double a, final Double b, final Double c) {
        if (a==0) {
            throw new RuntimeException("Parametr A jest rowny 0");
        }
        this.a=a;
        this.b=b;
        this.c=c;
    }

    public Double getB() {
        return b;
    }

    public void setB(final Double b) {
        this.b = b;
    }

    public Double getA() {
        return a;
    }

    public void setA(final Double a) {
        this.a = a;
    }

    public Double getC() {
        return c;
    }

    public void setC(final Double c) {
        this.c = c;
    }
}
