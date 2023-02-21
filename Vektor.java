import java.util.Scanner;

public class Vektor {
	private int[] arr;
	private int Size;
	private final int pos = 32;
	private void countArrSize(int num) { 
		this.Size = num / pos;	
		if (num % pos == 0) {
			arr = new int[Size];
		} else {
			arr = new int[++Size]; 
		}
	}
	public void set(int  num) { 
		int tmp = num;
		while(num >= pos){
			num = num - pos;
		}
		if (arr == null) {		
			countArrSize(tmp);   
		}
		int n = arr.length;
		if ((float)arr.length >= (float)((float)tmp / (float)pos)) {
			arr[n - 1 - tmp / pos] = (1 << num) | arr[n - 1 - tmp / pos];
		}
		if ((float)((float)tmp / (float)pos) > (float)n) {
			int array[] = arr;
			System.out.println("tmp = " + tmp);
			countArrSize(tmp); 
			for(int i = 0; i < n; ++i) {
				arr[Size - 1 - i] = array[n - 1 - i];
			}	
			array = null;     
        	        arr[Size - 1 - tmp / pos] = (1 << num) | arr[Size - 1 - tmp / pos];  
		}
		for(int i = 0; i < arr.length; ++i){
			String binaryString = Integer.toBinaryString(arr[i]);
			System.out.println(binaryString);
                }
	}
	public void reset(int num) {
		int f = arr.length;
		int position;
		if (num % pos == 0) {
			position = num / pos; 
		} else {
			position = num / pos + 1; 
		}
		while (num >= pos) { 
			num = num - pos;
		}
		int tmp = 1;
 		arr[f - position] = ((~(1 << num)) & arr[f - position]);
		for(int i = 0; i < arr.length; ++i){
			String binaryString = Integer.toBinaryString(arr[i]);			
			System.out.println(binaryString);
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num2;
		Vektor vektor = new Vektor();
		boolean result = true;
		while (result) {
			System.out.print("Please enter 1 for set or 0 for reset (enter 2 for ending the program - )");
			switch(scan.nextInt()){
				case 2: result = false;
					break;
				case 1: System.out.println("Please enter the position of the bit"); 
					vektor.set(num2 = scan.nextInt());
					break;
				case 0: System.out.println("Please enter the position of the bit");
					vektor.reset(num2 = scan.nextInt());
					break;
				default:
					break;
			}
			System.out.println();
		}
	}
}
