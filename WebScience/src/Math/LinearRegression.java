package Math;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import Datamining.Datawriter;

public class LinearRegression {
	
	public static double calculatesteam()
	{
	
		double sumxy = 0;
		double sumxx = 0;
		double[] x = {220245,257009,259944,144550,149092,109961,86381,62461,70613,45495};
		double[] y = {23143723,18643807,14371996,13062700,11218936,6404450,6132366,5751466,5222533,4585616};
		
		for (int i = 0; i<10; i++)
		{
			sumxy = x[i]*y[i] + sumxy;
			sumxx = x[i]*x[i] + sumxx;
		}
		
		double answer = (sumxy) / (sumxx);
		return answer;
	}
	
	public static double calculateglobal()
	{
	
		double sumxy = 0;
		double sumxx = 0;
		double[] x = {301,351,3317,1572,721,814,98};
		double[] y = {1000000,850000,3000000,707000,254000,151000};
		
		for (int i = 0; i<5; i++)
		{
			sumxy = x[i]*y[i] + sumxy;
			sumxx = x[i]*x[i] + sumxx;
		}
		
		double answer = (sumxy) / (sumxx);
		return answer;
	}
	
	
	public static void main(String[] argz) throws InvalidFormatException, IOException
	{
    	LinearRegression.calculatesteam();
    	System.out.println(LinearRegression.calculateglobal());
	}

}

