# accumulator

Given the following interface, create a Java implementation and a reasonable amount of tests (i.e. JUnit, TestNG, Spock or Cucumber; choose freely) to prove it correct. The implemetation should follow the guidelines described in the Javadoc of the interface.

An Accumulator maintains a running total sum of one or more variables. Updating of this total value is done by accumulating more variables. Reading the total value is done by calling the getTotal method. The accumulate method returns the sum of its arguments (which is added to the total running value).

# Extensions

This project is minimal, and I considered extending it to demonstrate some of the concepts I discussed with Trent. The `server` branch of this project contains an incomplete attempt at adding a RESTful web interface to the accumulator using Jersey. Let me know if I should complete it! The next thing to add is a dependency injection component with Guice, to manage dependencies between the servlet and accumulator components, followed either by packaging the project as a WAR (to be deployed to a webapp container) or embedding a Jetty (to build a standalone server).
