package com.example.calculator.lv3;

public abstract class OperatingSystem<T extends Number> {
    public abstract T operate(T a, T b);
}

class Add<T extends Number> extends OperatingSystem<T> {
    private final Class<T> classType;

    public Add(Class<T> classType) {
        this.classType = classType;
    }
    @Override
    public T operate(T a, T b) {
        if (a instanceof Double || b instanceof Double) {
            return classType.cast(a.doubleValue() + b.doubleValue());
        } else {
            return classType.cast(a.intValue() + b.intValue());
        }
    }
}
