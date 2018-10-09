public class Eexample {

		public void etest(int i){
				if (i >10){
						//throw new IndexOutOfBoundsException();
						//throw new ArrayIndexOutOfBoundsException();
						throw new ArithmeticException();
				}

				System.out.println("In etest - we're ok, about to return");
		}

}
