import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil

WebUI.callTestCase(findTestCase('Starter'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.click(findTestObject('Homepage/tombol_login_di_homepage'))

WebUI.click(findTestObject('Login page/a_Continue with Email or Phone Number'))

WebUI.setText(findTestObject('Login page/input_Email or Phone Number_username'), usname)

WebUI.setText(findTestObject('Login page/input_Password_password'), pwd)

WebUI.click(findTestObject('Login Page/button_Log In'))

WebUI.delay(2)
//String object1 = WebUI.getText(findTestObject('error messages/phone number is incorrect'))
//String object2 = WebUI.getText(findTestObject('error messages/email or phone invalid'))
////WebUI.verifyElementPresent(findTestObject('error messages/email or phone invalid'), 10)
//
//if (WebUI.verifyElementPresent(object1, timeout, FailureHandling.OPTIONAL)) {
//	KeywordUtil.markPassed("Success, Element is present")
//}
//if (WebUI.verifyElementPresent(object2, timeout, FailureHandling.OPTIONAL)) {
//	KeywordUtil.markPassed("Success, Element is present")
//}

if (WebUI.verifyElementPresent(findTestObject('error messages/email or phone invalid'), 5, FailureHandling.OPTIONAL)) { KeywordUtil.markPassed("Success") } else { }
if (WebUI.verifyElementPresent(findTestObject('error messages/phone number is incorrect'), 5, FailureHandling.OPTIONAL)) { KeywordUtil.markPassed("Success") } else { }
WebUI.delay(3)
WebUI.verifyElementNotPresent(findTestObject('Homepage/logo_rplus_di_homepage'), 10)

WebUI.closeBrowser()
