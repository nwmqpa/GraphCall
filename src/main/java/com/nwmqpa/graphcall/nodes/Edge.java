package com.nwmqpa.graphcall.nodes;

import com.nwmqpa.graphcall.interfaces.ICompilable;

public class Edge implements ICompilable {

    private final String name;
    private String nesting;

    Edge(String name, String nesting) {
        this.name = name;
        this.nesting = nesting;
    }

    @Override
    public String compile() {
        StringBuilder sb = new StringBuilder();
        return sb.append(nesting).append(name).append("\n").toString();
    }
}
