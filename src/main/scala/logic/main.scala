package logic

object main extends App {

	val branch_taken = Wire[Boolean]
	val branch_target = Wire[Int]

	val pc = Counter(
		load = branch_taken,
		value = branch_target,
		step = 4, 
		init = 0x300)

	for (i <- 0 until 10) {
		println("%d: %x".format(i,pc(i)))
	}


}
