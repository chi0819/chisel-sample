# Sample Code for Implementation of an Adder Using Chisel

Our project's name is defined in the `build.sc`.

## Compile the Digital Circuit Design to SystemVerilog

The source code for the adder is located at `src/main/scala/myadder.scala`.  
We use `mill` to elaborate the design. There is only one entry point, which is the `object myadderVerilog` extending the `App` class. Therefore, we need to specify the entry point for `mill` to generate the SystemVerilog code.

```shell
$ mill adder.runMain myadderVerilog
```

## Test the Digital Circuit Functionality

We can write unit tests in `src/test/scala` to verify our design. For the `myadder`, there is a test located at `src/test/scala/myadderTest.scala`. We can specify which test to run or execute all tests simultaneously.

```shell
$ mill adder.test # Run all tests
$ mill adder.test.testOnly myadderTest # Run a specific test
```
