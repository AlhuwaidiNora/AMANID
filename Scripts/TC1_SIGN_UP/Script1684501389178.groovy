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

Mobile.tap(findTestObject('Object Repository/android.widget.ImageView (4)'), 0)

Mobile.tap(findTestObject('Object Repository/android.widget.ImageView (5)'), 0)

Mobile.tap(findTestObject('Object Repository/android.widget.ImageView (6)'), 0)

Mobile.tap(findTestObject('Object Repository/android.widget.ImageView (7)'), 0)

Mobile.setText(findTestObject('Object Repository/android.widget.EditText - Enter your Digital ID provided by bank (1)'), 
    '1104194368', 0)

Mobile.setEncryptedText(findTestObject('Object Repository/android.widget.EditText -  Enter your password (1)'), 'ZGMICzUoDAg=', 
    0)

Mobile.setEncryptedText(findTestObject('Object Repository/android.widget.EditText -  Confirm your password (1)'), 'ZGMICzUoDAg=', 
    0)

Mobile.tap(findTestObject('Object Repository/android.widget.Spinner (1)'), 0)

Mobile.tap(findTestObject('Object Repository/android.widget.CheckedTextView - What is the city where you were born (1)'), 
    0)

Mobile.setText(findTestObject('Object Repository/android.widget.EditText - Enter your answer (1)'), 'kharj', 0)

Mobile.tap(findTestObject('Object Repository/android.widget.CheckBox -  I have read and agree to the (1)'), 0)

Mobile.tap(findTestObject('Object Repository/android.widget.Button - VERIFY AND PROCEED (1)'), 0)

Mobile.closeApplication()

Mobile.startExistingApplication('com.example.amanid')

Mobile.closeApplication()

