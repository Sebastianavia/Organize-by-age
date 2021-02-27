package ui;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;


public class Main {
	public static String [] arrayString;
	public static Double [] arrayDouble;
	public static ArrayList <Integer> arrayProm;
	public final static String separator=" ";



	public static void main(String[] args) throws IOException {
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));

		int n=Integer.parseInt(bf.readLine()); 
		String line="";
		String message="";

		for(int i = 0; i<n; i++) {
			line = bf.readLine();
			arrayString = line.split(separator);
			arrayDouble=new Double[arrayString.length];
			arrayProm=new ArrayList<Integer>();
			for (int j=0;j<arrayString.length;j++) {
				arrayDouble[j]=Double.parseDouble(arrayString[j]);
			}
			message+=bubbleSort(arrayDouble,arrayProm)+"\n";

		}

		System.out.println(message);

		bf.close();
	}


	public static String bubbleSort(Double [] array,ArrayList<Integer>  arrayprom) {
		String line="";
		int changes;
		for(int i = 1; i<array.length;i++) {

			changes = 0;
			for(int j=0; j<array.length-i;j++) {
				if(array[j]>array[j+1]) {
					Double temp = array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
					changes++;
				}
			}

			arrayprom.add(changes);

		}
		
		double prom = 0;

		for(int i = 0; i<arrayprom.size();i++ ) {

			prom = prom + arrayprom.get(i);

		}
		prom = prom /arrayprom.size() ;
		BigDecimal bd = new BigDecimal(prom).setScale(2, RoundingMode.DOWN);
	     prom = bd.doubleValue();
		
		DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
		separadoresPersonalizados.setDecimalSeparator('.');
		

		DecimalFormat formato1 = new DecimalFormat("#.00", separadoresPersonalizados);
		formato1.setRoundingMode(RoundingMode.DOWN);
		
		if (prom*10%1 ==0) {
			formato1 = new DecimalFormat("#.0", separadoresPersonalizados);
			formato1.setRoundingMode(RoundingMode.DOWN);

		}

		


		line+=formato1.format(prom)+"-";
		for(int i = 0; i<array.length;i++ ) {
			if (i==array.length-1) {
				line+= array[i];
			}else {
				line+= array[i]+" ";
			}
			

		}

		return line;
	}

}
