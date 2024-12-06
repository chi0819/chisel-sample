# Sample Code for Implementation of an Adder Using Chisel

Our project's name is defined in the `build.sc`.

## Generate Top SystemVerilog File and Simulating by Verilator

Generate the top systemverilog file and run simulation by verilator, the simulation process defined in `testbench.cpp`, and the verilator will generate the `.vcd`(Value Change Dump) file, which can used to show the waveform.

```shell
$ make all
```

## Run the Testing Functions

Run the testing functions defined in `src/test/scala`.

```shell
$ make test
```
