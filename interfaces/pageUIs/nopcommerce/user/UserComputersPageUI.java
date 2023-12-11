package pageUIs.nopcommerce.user;

public class UserComputersPageUI {
	public static final String COMPUTERS_HEADER_MENU = "xpath=//ul[@class='top-menu notmobile']//a[contains(text(),'Computers')]";
	public static final String DYNAMIC_PRODUCT_SUBLIST_AT_HEADER_MENU = "xpath=//ul[@class='top-menu notmobile']//a[contains(text(),'%s')]";
	public static final String FIRST_PRODUCT_TITLE = "xpath=//div[@class='item-grid']/div[1]//h2[@class='product-title']/a";
	public static final String SORT_BY_DROPDOWN = "css=select#products-orderby";
	public static final String PRODUCT_BUSY_LOADING_ICON = "css=div.ajax-products-busy";
	public static final String PRODUCTS_NAME = "css=h2.product-title>a";
	public static final String PRODUCTS_PRICE = "css=span.price";
	public static final String PRODUCTS_PAGE_SIZE_DROPDOWN = "css=select#products-pagesize";
	public static final String NEXT_PAGING_ICON = "css=li.next-page>a";
	public static final String PREVIOUS_PAGING_ICON = "css=li.previous-page>a";
}
