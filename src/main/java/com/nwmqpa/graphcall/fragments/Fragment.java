package com.nwmqpa.graphcall.fragments;

import com.nwmqpa.graphcall.nodes.Node;

public class Fragment extends Node {

    public Fragment(String name, String type) {
        super("fragment " + name + " on " + type);
    }
}
