// Generated by CIRCT firtool-1.62.1
module myadder(
  input        clock,
               reset,
  input  [7:0] io_in1,
               io_in2,
  output [7:0] io_out
);

  assign io_out = io_in1 + io_in2;
endmodule
