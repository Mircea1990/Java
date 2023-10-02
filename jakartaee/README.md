# Jakarta EE 10 Examples

This repository contains code examples for Jakarta EE 10.

A selection of these examples have an elaborate explanation in the Jakarta EE Tutorial.

### Focused

[Focused](focused/README.md) examples demonstrate a single Jakarta technology and/or a single Jakarta API in a coherent
and consistent way.
Such focused examples are a little like an [SSCCE](http://sscce.org) (Short, Self Contained, Correct Example),
but with a slightly different goal. Where the main purpose of an SSCCE is to be able to reproduce a bug, the purpose
of the focused example is to demonstrate a technology.

Each focused example is its own Maven module, and (typically) its own war. Such war can be deployed standalone to a
server of choice, where it can be manually run, debugged, modified, etc.

To assure focused examples actually work, and as implicit documentation of how the example is run (what requests need to
be done), most examples are accompanied by a test (in the future all examples should have a test). All tests follow the
same pattern:

* A server/runtime is started (if needed)
* The actually build output of the Maven module (typically a war) is deployed to said server/runtime
* The test, which runs on the client, issues HTTP requests to the server/runtime
* The test assures the response of the server/runtime is expected
* The application is undeployed
* The server/runtime is stopped (if needed)

Focused examples use Maven for building and starting the tests and JUnit for defining and executing the tests.
Arquillian is used, but only to start/stop a server, and to deploy/undeploy the test application for a given
server/runtime.

### Tutorial

[Tutorial](tutorial/README.md) examples are examples that happen to be used in the current version of the tutorial. They
are a mix of focused examples, and more elaborate examples. 
