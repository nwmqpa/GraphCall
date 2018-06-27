package com.nwmqpa.graphcall.nodes;

import com.nwmqpa.graphcall.interfaces.ICompilable;

import java.util.ArrayList;
import java.util.List;

public class Node implements ICompilable {

    private final String name;
    private final ICompilable parent;
    private final String nesting;

    private List<ICompilable> nodes;
    private List<ICompilable> parametersField;

    public Node(String name) {
        this(name, null, "");
    }

    private Node(String name, ICompilable parent, String nesting) {
        this.name = name;
        this.parent = parent;
        this.nesting = nesting;
        this.nodes = null;
        this.parametersField = null;
    }

    @Override
    public String compile() {
        StringBuilder sb = new StringBuilder();
        sb.append(nesting).append(this.name);
        if (this.parametersField != null) {
            sb.append("(");
            for (ICompilable parameterField: parametersField) {
                sb.append(parameterField.compile());
                if (parametersField.lastIndexOf(parameterField) != parametersField.size() - 1)
                    sb.append(", ");
            }
            sb.append(")");
        }
        if (this.nodes != null) {
            sb.append(" {\n");
            for (ICompilable node : nodes) {
                sb.append(node.compile());
            }
            sb.append(nesting + "}\n");

        }
        return sb.toString();
    }

    public Node addNode(String name) {
        if (this.nodes == null)
            this.nodes = new ArrayList<>();
        Node node = new Node(name, this, this.nesting + "\t");
        this.nodes.add(node);
        return (node);
    }

    public Node addEdge(String name) {
        if (this.nodes == null)
            this.nodes = new ArrayList<>();
        Edge edge = new Edge(name, this.nesting + "\t");
        this.nodes.add(edge);
        return this;
    }

    public Node buildNode() {
        return (Node) this.parent;
    }

    public Node addParameterField(String parameter, String value) {
        if (this.parametersField == null)
            this.parametersField = new ArrayList<>();
        ParameterField parameterField = new ParameterField(parameter, value);
        this.parametersField.add(parameterField);
        return this;
    }
}
