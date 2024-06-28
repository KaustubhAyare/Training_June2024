package Array;

public class forEachArray {

	public static void main(String[] args) {
		int[] runs = {5,26,75,100,99};
		int orangecap = runs[0];
		
		for (int i : runs)
		{
			if(i>orangecap)
				orangecap=i;
		}
		System.out.println("Orangecap Holder Runs are "+ orangecap);
		
		int poorperformer=runs[0];
		for(int i=0;i<runs.length;i++)
		{
			if(runs[i]<poorperformer)
				poorperformer=i;
		}
		System.out.println("Least runs scored are "+poorperformer);
		
	}

}
