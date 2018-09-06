"""Module defining the compilable interface."""


class Compilable(object):
    """Class defining a lightweight interface."""

    def compile(self):
        raise NotImplementedError
