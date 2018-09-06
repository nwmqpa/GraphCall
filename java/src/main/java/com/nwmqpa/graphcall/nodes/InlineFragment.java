package com.nwmqpa.graphcall.nodes;

import com.nwmqpa.graphcall.interfaces.ICompilable;

public class InlineFragment implements ICompilable {

    private final String name;
    private String nesting;

    InlineFragment(String name, String nesting) {
        this.name = name;
        this.nesting = nesting;
    }

    public String getName() {
        return name;
    }

    @Override
    public String compile() {
        StringBuilder sb = new StringBuilder();
        return sb.append(nesting).append("...").append(name).append("\n").toString();
    }
}
