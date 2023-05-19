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

Mobile.startExistingApplication('com.example.amanid')

Mobile.tap(findTestObject('Object Repository/Test Cases/android.widget.ImageView'), 0)

Mobile.tap(findTestObject('Object Repository/Test Cases/android.widget.TextView - Forget your password'), 0)

Mobile.tap(findTestObject('Object Repository/Test Cases/android.widget.TextView - Touch the fingerprint sensor'), 0)

Mobile.setText(findTestObject('Object Repository/Test Cases/android.widget.EditText - Enter your ID'), 'NVLzcP-06IVsQvC13_x', 
    0)

Mobile.tap(findTestObject('Object Repository/Test Cases/android.widget.Spinner'), 0)

Mobile.tap(findTestObject('Object Repository/Test Cases/android.widget.TextView - What is your favorite book'), 0)

Mobile.setText(findTestObject('Object Repository/Test Cases/android.widget.EditText - Enter your hint answer'), 'nothing', 
    0)

Mobile.tap(findTestObject('Object Repository/Test Cases/android.widget.Button -  SEND'), 0)

Mobile.closeApplication()

