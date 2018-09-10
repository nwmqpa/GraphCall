package com.nwmqpa.graphcall.nodes;

import com.nwmqpa.graphcall.interfaces.ICompilable;

public class ParameterField implements ICompilable {

    private final String parameter;
    private final Object value;

    ParameterField(String parameter, Object value) {
        this.parameter = parameter;
        this.value = value;
    }

    @Override
    public String compile() {
        if (this.value instanceof Integer)
            return String.format("%s: %d", this.parameter, (int) this.value);
        else if (this.value instanceof Double)
            return String.format("%s: %f", this.parameter, this.value);
        else if (this.value instanceof Boolean)
            return (Boolean) this.value ? String.format("%s: true", this.parameter) : String.format("%s: false", this.parameter);
        else
            return String.format("%s: \\\"%s\\\"", this.parameter, this.value);
    }
}
