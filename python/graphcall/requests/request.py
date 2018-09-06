"""Module defining the request object."""
from graphcall.nodes.node import Node
import json
import requests


class Request(object):
    """Class defining the request object."""

    def __init__(self, node: Node) -> None:
        """Initialize the object with a request."""
        self.request = json.dumps({
            "query": node.compile().replace("\n", "\t")
                                   .replace("\t", " ")
                                   .replace(" +", " ")
        })

    def send(self, url: str) -> dict:
        """Make a request to the url with the node as body."""
        headers = {'Content-Type': 'application/json'}
        response = requests.post(url, data=self.request, headers=headers)
        return response.json()
