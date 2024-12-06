#include "Vadder.h"
#include "verilated.h"
#include "verilated_vcd_c.h"

int main(int argc, char **argv) {
    Verilated::commandArgs(argc, argv);

    // Instantiate the module
    Vadder *top = new Vadder;

    // Enable waveform dump
    Verilated::traceEverOn(true);
    VerilatedVcdC *vcd = new VerilatedVcdC;
    top->trace(vcd, 99);  // Trace 99 levels of hierarchy
    vcd->open("waveform.vcd");

    // Simulate inputs
    for (int i = 0; i < 20; ++i) {
        top->io_in1 = i;                  // Test input 1
        top->io_in2 = i * 2;              // Test input 2
        top->clock = 1; top->eval();      // Toggle clock
        vcd->dump(i * 10);
        top->clock = 0; top->eval();      // Toggle clock
        vcd->dump(i * 10 + 5);

        // Print the output
        printf("io_in1: %d, io_in2: %d, io_out: %d\n",
               top->io_in1, top->io_in2, top->io_out);
    }

    // Cleanup
    top->final();
    vcd->close();
    delete top;
    delete vcd;

    return 0;
}

