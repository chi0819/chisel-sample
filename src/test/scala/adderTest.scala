/* src/test/scala/adderTest.scala */
import chisel3._
import chisel3.simulator.EphemeralSimulator._
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.must.Matchers

class adderTest extends AnyFreeSpec with Matchers {
    "Add two 7 bits number correctly" in {
        simulate(new adder) { c =>
            for(i <- 0 until 20 ) {
                val in1 = i
                val in2 = i + 1
                c.io.in1.poke(in1.U)
                c.io.in2.poke(in2.U)
                val expected_output = in1 + in2
                c.io.out.expect(expected_output.U)
                val output = c.io.out.peek().litValue
                println(f"${in1}%4d + ${in2}%4d = ${expected_output}%4d -> ${output}%4d")
            }
        }
    }
}
