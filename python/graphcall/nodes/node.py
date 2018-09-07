"""Module defining what a node is."""
from graphcall.interfaces.compilable import Compilable
from graphcall.nodes.edge import Edge
from graphcall.nodes.parameter_field import ParameterField


class Node(Compilable):
    """Node class."""

    def __init__(self, name: str):
        """Initialize the node."""
        self._init(name, None, "")

    def _init(self, name: str, parent: Compilable, nesting: str):
        """Initialize fully the node."""
        self.name = name
        self.parent = parent
        self.nesting = nesting
        self.nodes = None
        self.parametersField = None

    def addNode(self, name: str):
        """Add a node to the current node."""
        if self.nodes is None:
            self.nodes = []
        node = Node("")
        node._init(name, self, self.nesting + "\t")
        self.nodes.append(
            node
        )
        return node

    def compile(self) -> str:
        """Compile the current node into string"""
        result = self.nesting + self.name
        if self.parametersField is not None:
            result += "("
            for index in range(len(self.parametersField)):
                result += self.parametersField[index].compile()
                if index != len(self.parametersField) - 1:
                    result += ", "
            result += ")"
        if self.nodes is not None:
            result += " {\n"
            for index in range(len(self.nodes)):
                result += self.nodes[index].compile()
            result += self.nesting + "}\n"
        return result


    def buildNode(self):
        """Mark the current node as built."""
        return self.parent if self.parent is not None else self

    def addParameterField(self, parameter: str, value):
        """Add a parameter field to the current node."""
        if self.parametersField is None:
            self.parametersField = []
        self.parametersField.append(
            ParameterField(parameter, value)
        )
        return self

    def addEdge(self, name: str):
        if self.nodes is None:
            self.nodes = []
        self.nodes.append(
            Edge(name, self.nesting + "\t")
        )
        return self

    def __str__(self):
        """Return a str version of the query."""
        return self.compile()

    def __repl__(self):
        return str(self)
