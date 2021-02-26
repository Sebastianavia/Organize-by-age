package ui;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;


public class Main {
	public static String [] arrayString;
	public static Double [] arrayDouble;
	public final static String separator=" ";
	
	
	
	public static void main(String[] args) throws IOException {
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(bf.readLine()); //Primer numero que se ingresa, significa el numero de casos (lineas)
		String line="";
		String message="";
		
		for(int i = 0; i<n; i++) {
			line = bf.readLine();
			arrayString = line.split(separator);
			arrayDouble=new Double[arrayString.length];
			for (int j=0;j<arrayString.length;j++) {
				arrayDouble[j]=Double.parseDouble(arrayString[j]);
			}
		message+=bubbleSort(arrayDouble)+"\n";
			
		}

		System.out.println(message);
		
		bf.close();
		//bw.close();
	}
	
	
	public static String bubbleSort(Double [] array) {
		String line="";
		Double arrayprom[];
		arrayprom = new Double[array.length];
		Double changes;
		for(int i = 1; i<array.length;i++) {
			
			changes = 0.0;
			for(int j=0; j<array.length-i;j++) {
				if(array[j]>array[j+1]) {
					Double temp = array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
					changes++;
				}
			}
			
			arrayprom[i] = changes;

		}
		
		
		Double prom = 0.0;
		Double div=0.0;
		for(int i = 0; i<arrayprom.length;i++ ) {
			if (arrayprom[i]!=0) {
				prom = prom + arrayprom[i];
			div++;
			}
			
	
		}
		prom = prom / arrayprom.length;
		//System.out.println(div);
		
		
		line+=prom+"-";
		for(int i = 0; i<array.length;i++ ) {
			line+= array[i]+" ";
	
		}
		
		
		return line;
	}
	
}
