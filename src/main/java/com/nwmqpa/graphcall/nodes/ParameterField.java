package com.nwmqpa.graphcall.nodes;

import com.nwmqpa.graphcall.interfaces.ICompilable;

public class ParameterField implements ICompilable {

    private final String parameter;
    private final Object value;

    public ParameterField(String parameter, Object value) {
        this.parameter = parameter;
        this.value = value;
    }

    @Override
    public String compile() {
        if (this.value instanceof Integer)
            return String.format("%s: %d", this.parameter, this.value);
        return String.format("%s: \\\"%s\\\"", this.parameter, this.value);
    }
}
