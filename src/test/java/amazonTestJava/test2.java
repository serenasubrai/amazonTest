package amazonTestJava;

import junit.framework.Assert;

public class test2 {

	public static void main(String[] args) {
		int thousand = 1000;
		String price = "£629.00";



		String[] priceArray = price.split("\\.");

		System.out.println("priceArray[0] "+priceArray[0]);
		System.out.println("priceArray[1] "+priceArray[1]);


		//approach 1
		String[] priceArray2 = priceArray[0].split("£");
		System.out.println("priceArray2[0] "+priceArray2[0]);
		System.out.println("priceArray2[1] "+priceArray2[1]);

		//approach 2
		String priceValue =priceArray[0].substring(1, priceArray[0].length());
		System.out.println("priceValue is "+priceValue);

		if (Integer.parseInt(priceValue)<thousand) {
			System.out.println("pass");
			Assert.assertTrue("Price is less than 1000", true);
		}
		else {
			System.out.println("fail");
			Assert.assertTrue("Price is not less than 1000", false);
		}
	}

}
