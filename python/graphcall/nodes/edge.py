"""Module defining the edge of a Node."""
from graphcall.interfaces.compilable import Compilable


class Edge(Compilable):
    """Class defining the edge."""

    def __init__(self, name: str, nesting: str) -> None:
        """Initialize the object."""
        self.name = name
        self.nesting = nesting

    def compile(self):
        """Compile the edge."""
        return self.nesting + self.name + "\n"
