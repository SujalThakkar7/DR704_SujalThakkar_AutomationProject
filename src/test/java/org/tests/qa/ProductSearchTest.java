package org.tests.qa;

import org.base.qa.BaseTest;
import org.pages.qa.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.utilities.qa.ExcelReader;

public class ProductSearchTest extends BaseTest {
	
	@DataProvider(name = "searchData")
	public Object[][] getSearchData() throws Exception {
		return ExcelReader.getExcelData();
		
	}
	
	@Test(dataProvider = "searchData")
	  public void verifyProductSearch(String testID, String searchProduct, String expectedProduct) {

        ProductsPage pp = new ProductsPage(driver);

        pp.openProductsPage();

        pp.searchProduct(searchProduct);

        String actualProduct = pp.getProductName();

        Assert.assertEquals(actualProduct, expectedProduct,
                "Product name mismatch for " + testID);
	}

}