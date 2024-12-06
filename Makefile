TOP = adder
VERILATOR = verilator
CXXFLAGS = -Wall -Wextra -std=c++11

all: sim

sim: src/main
	@mill $(TOP).runMain $(TOP)EmitVerilog
	@$(VERILATOR) --cc $(TOP).sv --exe testbench.cpp --trace
	@make -C obj_dir -f V$(TOP).mk V$(TOP)
	@./obj_dir/V$(TOP)

test: src
	@mill $(TOP).test

clean:
	@rm -rf $(TOP).sv out obj_dir waveform.vcd

