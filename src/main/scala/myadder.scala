/* src/main/scala/myadder.scala */
import chisel3._

import _root_.circt.stage.ChiselStage

class myadder extends Module {
    val io = IO(new Bundle {
       val in1 = Input(UInt(8.W))
       val in2 = Input(UInt(8.W))
       val out = Output(UInt(8.W))
    })

    io.out := io.in1 + io.in2
}

object myadderVerilog extends App {
  ChiselStage.emitSystemVerilogFile(
    new myadder,
    firtoolOpts = Array("-disable-all-randomization", "-strip-debug-info")
  )
}
