package com.vg;

import java.time.LocalDate;

public final class MyImmutable implements Cloneable {

    private Integer myInt;
    private String myString;
    private LocalDate myDate;

    public MyImmutable(Integer newMyInt, String newMyString, LocalDate newMyDate) {
        this.myInt = Integer.valueOf(newMyInt);
        this.myString = String.valueOf(newMyString);
        this.myDate = LocalDate.of(newMyDate.getYear(), newMyDate.getMonth(), newMyDate.getDayOfMonth());
    }


    public Integer getMyInt() {
        return myInt;
    }

    public String getMyString() {
        return myString;
    }

    public LocalDate getMyDate() {
        return LocalDate.of(this.myDate.getYear(), this.myDate.getMonth(), this.myDate.getDayOfMonth());
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("MyImmutable class is Immutable. Cloning not supported");
    }
}
