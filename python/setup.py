import setuptools

with open("README.md", "r") as fh:
    long_description = fh.read()

setuptools.setup(
    name="graphcall",
    version="0.0.6",
    author="nwmqpa",
    author_email="thomas.nicollet@epitech.eu",
    description="A lightweight graphQL library",
    long_description=long_description,
    long_description_content_type="text/markdown",
    url="https://github.com/nwmqpa/GraphCall",
    packages=setuptools.find_packages(),
    classifiers=[
        "Programming Language :: Python :: 3",
        "Operating System :: OS Independent"
    ],
    install_requires=['requests']
)
