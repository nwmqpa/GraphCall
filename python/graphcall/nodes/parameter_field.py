"""Module defining the parameter field of a Node."""
from graphcall.interfaces.compilable import Compilable


class ParameterField(Compilable):
    """Class defining the parameter field."""

    def __init__(self, parameter: str, value) -> None:
        """Initialize the object."""
        self.parameter = parameter
        self.value = value

    def compile(self):
        """Compile the parameter field."""
        if isinstance(self.value, str):
            return "{0}: \"{1}\"".format(self.parameter, self.value)
        if isinstance(self.value, bool):
            return "{0}: {1}".format(self.parameter, str(self.value).lower())
        return "{0}: {1}".format(self.parameter, str(self.value))
