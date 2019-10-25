package Ch_03;

//random point in a rectangle , center at (0,0)

public class Exercise03_16 {
	public static void main(String[] args) {
		 
		
		int x = (int)((Math.random()* 100 ) - 50);
		int y = (int)((Math.random()* 200 ) - 100);
		
		System.out.println("(" + x + "," + y + ")");
	}

}
