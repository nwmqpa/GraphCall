package com.nwmqpa.graphcall.nodes;

import com.nwmqpa.graphcall.interfaces.ICompilable;

public class ParameterField implements ICompilable {

    private final String parameter;
    private final String value;

    public ParameterField(String parameter, String value) {
        this.parameter = parameter;
        this.value = value;
    }

    @Override
    public String compile() {
        return String.format("%s: \"%s\"", this.parameter, this.value);
    }
}
