Read Me
========
**Walmart Assignment:**

Scenario to automate:
1. Perform a search on home page from a pool of key words given below
2. Identify an item from the result set that you can add to cart
3. Add the item to cart and then login using existing account which is set up with at least one shipping address
4. Validate that item added is present in the cart and is the only item in the cart
5. Select Ship to Home as shipping method for your order
6. Validate that you are on Payment details page
7. Go back to Cart Page, Remove the item from cart and validate cart is empty
8. Sign out from your account

**Tools Used:**
Selenium Webdriver 4.27
Junit 4.1
Eclipse IDE 4.4
ChromeBrowser 33
ChromeDriver
JDK 1.7
Test data :
username:test@gmail.com
password:password

**Approach:**
Page Object Model: For maintainable and reusable test routines.
Identify the web elements on the page by (**id, class name, xpath, link text**)

Perform a search on home page from a pool of key words given below:
1.	Identify the search button using Inspect element by id
2.	Enter the keywords(*tv*, *socks*) by using **<code>sendkeys()</code>** method
3.	Wait until the page loads
4.Look for the result of items by class name using javascript executor.As each item is having unique **<code>&lt;div&gt;</code>** element, I used javascript executor to go find the anchor tag (**<code>&lt;a&gt;</code>**) and click on the link by using index number.
5.	check the condition for number of items quantity using **<code>select()</code>** and **<code>selectindex()</code>** method  
5.	Click on Add to cart item button by id
6.	verified number of items added to the cart by using **<code>getText()</code>** and parsed it to an integer.checked the condition if item is 1 log in with the credentials using send keys() method and click on sign in button
7.	click on proceed to check out button by id and verified the default shipping address is selected using **<code>isSelected()</code>** method
8.	click on continue button using id and go to payment details page.validated the page by using get **<code>currenturl()</code>**
9.	click on the cart logo to go back to the cart page using **<code>navigate.to()</code>** method and removed the item by clicking remove button by id
10.	validated the cart is empty by getting the text of the class and parsed it into integer value as zero
11.	used hover method to get the specific element signout from the my account drop down using link **<code>text ()</code>** method and click on sign out button

**Note:**
1.	Currently kept all the element locators in a single class. Hard coded the search terms
2. The jar files are not checked into the repository

**Enhancements:**

If I would have more time to work on the project, I will address the following:

1.	Add object elements for each page
2.	create generic methods such as **<code>click()</code>**, **<code>waitForPageLoad()</code>**, **<code>FluentWait()</code>**-Instead of Thread.sleep(),**<code>elementWaitUntilDisplayed()</code>**, **<code>elementWaitUntilClickable()</code>**, **<code>getElement(By by)</code>**
3.	Read the search items from a file, For Example:excel sheet, text or Json files
4.	Investigate page latencies, page layouts based on user agents and devices for accurate automated test
5.  Android Studio, Xcode, Appium, Npm and Node, driver.properties is needed for testing in mobile platforms.