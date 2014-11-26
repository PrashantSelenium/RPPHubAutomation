package hub.library;

public class ObjectReference {

	ReadXmlData rxml = new ReadXmlData();
   
    public String prod_url = rxml.data("prod_url");
    public String local_url = rxml.data("local_url");
    
    //User login
    public static String userLoginUsername = "//input[@id='userName']";
    public static String userLoginPassword = "//input[@id='password']";
    public static String userLoginButton = "(//input[@id='subRegInd'])[2]";
    public static String hubLoginError = "//div[@id='hubLoginError']";
    public static String userLogoutLink = "//a[@id='logoutLink']";
    public static String emptyErrorMessage = "Username or Password should not be empty.";
    public static String invalidErrorMessage = "//*[text()='Invalid Username and/or Password, please try again.']";
    //login error
    public static String loginMandatoryFields = "//*[text()='Please complete all mandatory fields.']";
    public static String loginNotEmpty = "//*[text()='Username and/or Password should not be empty.']";
    
  
    //User Login new
    public static String registerButton = "(//input[@id='subRegInd'])[1]";
    public static String loginButton = "(//input[@id='subRegInd'])[2]";
    public static String mandatoryFields = "//div[@id=flashMessageContent']";
    public static String mandatoryMessage = "Please complete all mandatory fields.";
    public static String loginSecurityError = "//div[@id='flashMessageContent']/div";
    public static String loginSecurityMessage = "You have attempted 3 times to login. Please click on Forgot My Password to reset your account's password.";
    public static String loginErrorMessage = "//*[@id='hubLoginError']";
    public static String register = "//input[@value='Register New User']";
    public static String login_FlashMessage = "//*[@id='flashMessage']";

  //new Arvin
    public static String LoginButton = "//input[@value='Login']";
    
    //Forgot Password
    public static String forgotPasswordUsername = "//*[@id='user-name']";
    public static String forgotPasswordEmail = "//*[@id='email-address']";
    public static String forgotPasswordLabel = "//*[@id='hub-forgot-password']/div/div[2]/div[1]";
    public static String forgotPasswordValidationOnEmptyFields = "//div[text()='Username and/or Email Address field should not be empty.']";
    public static String forgotPasswordValidationOnInvalidInputs = "//div[text()='Invalid Username and/or Email Address.']";
    
    //Signup page
    public static String registrationForm = "//form[@id='hubRegisForm']";
    public static String signupCaptchaImg = "//img[@id='scImage']";
    public static String signupCaptcha = "//input[@id='validationCode']";
    public static String signupDone ="//input[@id='subRegInd']";
    public static String signUpErrorFN = "//div[text()='First name should not be empty.']";
    public static String signUpErrorLN = "//div[text()='Last name should not be empty.']";
    public static String signUpErrorBranchId = "//div[text()='Branch ID should not be empty.']";
    public static String signUpErrorStaffId = "//div[text()='Staff ID/Broker ID should not be empty.']";
    public static String signUpErrorProfId = "//div[text()='Professional Industry Body ID should not be empty.']";
    public static String signUpErrorUserRole = "//div[text()='User role should not be empty.']";
    public static String signUpErrorEmail = "//div[text()='Email should not be empty.']";
    public static String signUpErrorEmailInvalidInput = "//div[text()='Invalid email format.']";
    public static String signUpErrorEmailNotMatch = "//div[text()='Email does not match.']";
    public static String signUpErrorConfirmEmail = "//div[text()='Confirm email should not be empty.']";
    public static String signUpErrorConfirmEmailNotMatch = "//*[@class='errorMessage confirmUserPassError']";
    public static String signUpErrorMobile = "//div[text()='Mobile number should not be empty.']";
    public static String signUpErrorMobileInvalid = "//div[text()='Invalid mobile number.']";
    public static String signUpErrorPhone = "//div[text()='Phone number should not be empty.']";
    public static String signUpErrorPhoneInvalid = "//div[text()='Invalid phone number.']";
    public static String signUpErrorUsername = "//div[text()='Username should not be empty.']";
    public static String signUpErrorUsernameSymbol = "//div[text()='Please use only letters, numbers or symbols.']";
    public static String signUpErrorPassword = "//div[text()='Password should not be empty.']";
    public static String signUpErrorPasswordMinChar = "//div[text()='Password must be at least 6 characters long.']";
    public static String signUpErrorConfirmPass = "//div[text()='Confirm password should not be empty.']";
    public static String signUpErrorSecurityQuestion = "//div[text()='Security question should not be empty.']";
    public static String signUpErrorSecurityAnswer = "//div[text()='Security answer should not be empty.']";
    public static String signUpErrorCaptcha = "//div[text()='Validation code should not be empty.']";
    public static String signUpErrorCaptchaValidation = "//div[text()='Error validating your security verification code.']";
    public static String signUpErrorTermsnConditions = "//div[text()='Please read and accept the Terms & Conditions.']";
    
    public static String firstNameReg = "//*[@id='firstName']";
    public static String lastNameReg = "//*[@id='lastName']";
    public static String staffIDReg = "//*[@id='StaffIDBrokerID']";
    public static String branchIDReg = "//*[@id='BranchID']";
    public static String bodyIDReg = "//*[@id='ProfessionalIndustryBodyID']";
    public static String userRoleReg = "//*[@id='userRole']";
    public static String emailReg = "//*[@id='userEmail']";
    public static String confirmEmailReg = "//*[@id='confirmUserEmail']";
    public static String mobileReg = "//*[@id='mobileNumber']";
    public static String phoneReg = "//*[@id='phoneNumber']";
    public static String usernameReg = "//*[@id='userName']";
    public static String passwordReg = "//*[@id='userPass']";
    public static String confirmPasswordReg = "//*[@id='confirmUserPass']";
    public static String securityQuestionReg = "//*[@id='securityQuestion']";
    public static String answerReg = "//*[@id='securityAnswer']";
    public static String agreementReg = "//*[@id='termsAndConditions']";
    public static String doneBTNReg = "//input[@value='Done']";
    public static String rightLogoReg = "//img[@alt='ACME']";
    public static String leftLogoReg = "//*[@id='masthead']/table/tbody/tr[1]/td[2]/img";
    public static String suggestion1 = "//*[text()='arvin2']";
    public static String suggestion2 = "//*[text()='arvin3']";
    public static String suggestion3 = "//*[text()='arvin4']";
    public static String emailsuffix = "//*[text()='@cba.com.au']";
    public static String validationCodeReg = " //*[@id='validationCode']";
    public static String myAccountSuggestion1 = "//*[text()='jennifer-acme2']";
    public static String myAccountSuggestion2 = "//*[text()='jennifer-acme3']";
    public static String myAccountSuggestion3 = "//*[text()='jennifer-acme4']";
 
    //My Account 
    public static String userMyAccount = "//li[@id='myAccount']/div/a";
    public static String myAccountFN = "//input[@id='firstName']";
    public static String myAccountLN = "//input[@id='lastName']";
    public static String myAccountBranchId = "//input[@id='BranchID']";
    public static String myAccountStaffId = "//input[@id='CompanyID']";
    public static String myAccountProfId = "//input[@id='ProfessionalIndustryBodyID']";
    public static String myAccountEmail = "//input[@id='userEmail']";
    public static String myAccountConfirmEmail = "//input[@id='confirmUserEmail']";
    public static String myAccountMobile = "//input[@id='mobileNumber']";
    public static String myAccountPhone = "//input[@id='phoneNumber']";
    public static String myAccountUsername = "//input[@id='userName']";
    public static String myAccountPassword = "//input[@id='newPassword']";
    public static String myAccountConfirmPassword = "//input[@id='confirmUserPass']";
    public static String myAccountSecurityQuestion = "//input[@id='securityQuestion']";
    public static String myAccountSecurityAnswer = "//input[@id='securityAnswer']";
    public static String myAccountUserRole = "//select[@id='userRole']";
    public static String myAccountSavebtn = "//*[text()='Save']";
    public static String myAccountDialogBoxOK = "//a[text()='OK']";
    public static String myAccountCancelBtn = "//a[text()='Cancel']";
  
    public static String myAccountLabelFN = "//*[text()='First Name:']";
    public static String myAccountLabelLN = "//*[text()='Last Name:']";
    public static String myAccountLabelEmail = "//*[text()='Email:']";
    public static String myAccountLabelMobile = "//*[text()='Mobile Number (e.g 0444555666) :']";
    public static String myAccountLabelPhone = "//*[text()='Phone Number (e.g 0281009999) :']";
    public static String myAccountLabelUsername = "//*[text()='Username:']";
    public static String myAccountLabelNewPassword = "//*[text()='New Password:']";
    public static String myAccountLabelConfirmPassword = "//*[text()='Confirm Password:']";
    public static String myAccountLabelSecQuestion = "//*[text()='Security Question:']";
    public static String myAccountLabelSecAnswer = "//*[text()='Answer to Security Question:']";
    public static String myAccountLabelStaffID = "//*[text()='Staff ID/Broker ID:']";
    public static String myAccountLabelBranchID = "//*[text()='Branch ID:']";
    public static String myAccountLabelBodyID = "//*[text()='Professional Industry Body ID:']";
    public static String myAccountLabelUserRole = "//*[text()=' User Role:']";
   
    public static String myAccountErrorStaffId = "//div[text()=' Staff ID/Broker ID should not be empty.']";
    public static String myAccountErrorBranchId = "//div[text()=' Branch ID should not be empty.']";
    public static String myAccountErrorPasswordNotMatch = "//div[text()='Password does not match.']";

    //My Transactions
    public static String userMyTransactions = "//li[@id='myTransactions']/div/a";
    public static String userMyTransactionList = "//div[@class='TransactionList']";
    
    //Reset Password
    public static String oldForgotPassword = "//input[@value='validateEmail']";
    public static String userForgotPasswordInstruction = "//*[text()='Enter Username and Email Address below.']";
    public static String userForgotPasswordBtn = "(//input[@id='subRegInd'])[3]";
    public static String userForgotPasswordUsername = "//input[@id='user-name']";
    public static String userForgotPasswordEmailAddress = "//input[@id='email-address']";
    public static String userForgotPasswordError = "//div[@id='errorMessage']";
    public static String userForgotPasswordEmpty = "//div[@id='errorMessage']";
    public static String userResetPasswordBtn = "(//input[@id='subRegInd'])[4]";
    public static String userResetPasswordMessage = "(//span)[6]";
    public static String userResetPasswordEmailSent = "//label[@class='fontStyle12']";
    public static String userResetPasswordSuccessPopup = "//div[@id='cboxContent']";
    public static String userResetPasswordSuccessPopupMessage = "(//div/p)[5]";
    public static String userResetPasswordSuccessPopupClose = "//img[@src='/ttsvr/myrp/images/ui/modalbox/close.png']";
    public static String userResetPasswordSuccessModalBox = "//*[@id='cboxLoadedContent']/div";
    public static String userResetPasswordClose = "//*[@id='cboxClose']";
    public static String userResetPasswordChangeMessage = "(//td/div)[3]";
    public static String userResetPasswordChangeMessage2 = "(//td/div)[4]";
    public static String userResetPasswordChange = "";
    public static String userResetPasswordNewPass = "//input[@id='newPassword']";
    public static String userResetPasswordConfirmPass = "//input[@id='confirmPassword']";
    public static String userResetPasswordCancelBtn = "//input[@id='cancel']";
    public static String userResetPasswordResetPassBtn = "//input[@id='resetPassword']";
    public static String userResetPasswordInfo = "//div[@class='pass_info']";
    public static String userResetPasswordError = "";
    public static String userResetPasswordSuccess = "";
    public static String userOneTimePasswordFirstPopup = "//div[@class='oneTimePassword']";
    public static String userOneTimePasswordMessage = "(//div[@class='oneTimePasswordMessage']/div)[1]";
    public static String userOneTimePasswordLabel = "//div[@class='oneTimePasswordForm']/label";
    public static String userOneTimePasswordField ="//input[@id='inputPasswordField']";
    public static String userOneTimePasswordConfirm ="//input[@id='oneTime-button']";
    public static String userOneTimePasswordClose ="//img[@src='/ttsvr/myrp/images/ui/modalbox/close.png']";
    public static String userShowValidation = "//h4";
    public static String userShowValidationOneNumber = "//td[@id='one_number']";
    public static String userShowValidationLowerCase = "//td[@id='lower_case']";
    public static String userShowValidationUpperCase = "//td[@id='upper_case']";
    public static String userShowValidationSpecialChar = "//td[@id='special_character']";
    public static String userResetPasswordButton = "//input[@value='Reset Password']";
    public static String ForgotPassword = "//input[@value='Forgot My Password!']";
    
    public static String userOTPLabel = "//*[@class='one-time-password']";

    //Property Search
    public static String userPropertySearch = "//input[@id='hubSearchAddress']";
    public static String userSearchButton = "//input[@id='hubSearchButton']";
    public static String userPropertyDetails = "//div[@id='propdetails']";
    public static String coverFlow = "//*[@id='workspace']/table/tbody/tr/td[2]/div/div[2]";
    public static String unfortunately_Error_Msg = "(//*[@class='message'])[1]";
    
    //CFA                             
    public static String userCFAButton = "//*[@id='hubSearchAddressForm']/div[1]/img[2]";
    public static String userCFAUnitNumber = "//input[@id='hubSearchAddress_unitNumber']";
    public static String userCFAStreetNumber = "//input[@id='hubSearchAddress_streetNumber']";
    public static String userCFALotNumber = "//input[@id='hubSearchAddress_lotNumber']";
    public static String userCFAStreetName = "//input[@id='hubSearchAddress_streetName']";
    public static String userCFAStreetType = "//input[@id='hubSearchAddress_street_Type']";
    public static String userCFAStatePostcode = "//input[@id='hubSearchAddress_suburbStatePostcode']";
    public static String userCFABackSearch = "(//div[@id='clearAllIcon'])[1]";
    public static String userCFAClear = "(//div[@id='clearAllIcon'])[2]";
    public static String userCFAConfirm = "//div[@id='proceedBtn']";
    public static String userCFASuggestion = "//div[@class='hubResults cantfindAddListContainer']";
    public static String userCFASuburbList = "//*[@id='hubSearchAddress_suburbStatePostcode']";
    public static String cfaErrorMessageUnitNumber = "//*[text()='At least one of Unit Number, Street Number and Lot Number must be complete']";
    public static String cfaErrorMessageStreetName = "//*[text()='Street name cannot be empty']";
    public static String cfaErrorMessageStreetType = "//*[text()='Street type cannot be empty']";
    public static String cfaErrorMessageSuburb = "//*[text()='Suburb, State and Postcode cannot be empty']";
    
    //Pending Transactions
    public static String userPendingTransactionMessage ="//div[@id='divContainer']";
    
    //Property Details
    public static String userCart ="//a[@id='cartCount']";
    public static String userPropertyPhoto = "//*[@alt='Property Photo']";

    //originator
    public static String userOriginatorDetails = "//div[@id='div_questionnaire']";
    public static String originatorHeader = "//form[@id='propertyDetailQuestions']//label";
    public static String xButton = "//form[@id='propertyDetailQuestions']//img[contains(@src,'xButton')]";
    public static String propertyTypeLabel = "(//form[@id='propertyDetailQuestions']//td[@class='propertyDetailLabels'])[1]";
    public static String propertyTypeSelect = "(//form[@id='propertyDetailQuestions']//select[@class='propertyType'])[1]";
    public static String propertyTypeSelectValue = "(//form[@id='propertyDetailQuestions']//select[@value])";
    public static String infoIcon = "//form[@id='propertyDetailQuestions']//img[contains(@src,'infoIcon')]";
    public static String oevppLabel = "(//form[@id='propertyDetailQuestions']//td[@class='propertyDetailLabels'])[2]";
    public static String oevppLabelDollar = "//form[@id='propertyDetailQuestions']//span[contains(text(),'$')]";
    public static String userOEVPP = "//input[@id='2']";
    public static String oevppErrorMsg = "//form[@id='propertyDetailQuestions']//div[@class='propertyValue errorMessage']";
    public static String userNoneApply ="//input[@id='26']";
    public static String userAVMAck ="//input[@id='6']";
    public static String loanApplication ="//input[@id='5']";
    public static String iconOriginatorToProductSelection = "//form[@id='propertyDetailQuestions']//img[contains(@src,'proceedIcon')]";
    public static String userOriginatorToProductSelection = "(//form[@id='propertyDetailQuestions']//a)[3]";
    public static String userOriginatorProceed = "(//table[@class='propertyDetailQuestionLink']//a)[2]";
    public static String costingReport ="//input[@id='12']";

    
    //Product tabs
    public static String productTabsMenu = "//div[@id='containerTab']";
    public static String tabReports = "//a[@id='linkReports']";
    public static String tabValuations = "//a[@id='linkValuations']";
     
    public static String userProductTab = "//input[@id='linkResidential_Valuations']";
    public static String tabResidentialValuation = "//input[@id='linkResidential_Valuations']";
    public static String tabRetroReports = "//div[@id='linkRetro_Reports']";
    public static String tabCommercialValuations ="//div[@id='linkCommercial_Valuations']";
    public static String tabRuralValuations ="//div[@id='linkRural_Valuations']";
    public static String userValuationsTab = "//div[@id('tabValuations')]";
    public static String userRetroReportsTab = "//div[@id='tabRetro_Reports']";
    
    //Products
    public static String productLenderEmpowerment = "//div[@id='tabReports']/table/tbody/tr/td/div/div/ul/li[2]/div/input[@id='purchaseButton']";
    public static String productLenderAVM = "//div[@id='tabValuations']//input[@id='purchaseButton']";
    public static String productShorFormVal = "//div[@id='tabValuations']/table/tbody/tr[2]/td/div/div/ul/li[2]/div/input[@id='purchaseButton']";
    public static String titleName = "(//h2[@class='hubHeaderBodyText'])[1]";
    public static String titleMoreDetails = "(//a[@class='hubTextlink moreDetails'])[1]";
    public static String titleShort = "(//span[@class='hubHeaderBodyText shortDescription'])[1]";
    public static String titleLong = "(//span[@class='hubHeaderBodyText longDescription'])[1]";

    //Product selection
    public static String userAddToCart = "(//input[@id='purchaseButton'])[1]";
    public static String userProceedToProductSelection = "(//a[@class='hubTextlink'])[4]";
    public static String userResidentialTabLink = "//a[@id='linkResidential_Valuations']";
    public static String userValuationsTabLink = "//a[@id='linkValuations']";
    public static String userRetroReportsTabLink = "//a[@id='linkRetro_Reports']";
    public static String userNavProductSelection = "(//div[@class='navigation'])[1]";
    public static String userProductSelectionList = "//div[@class='ProductSelectionList']";
    public static String userProductSelectionListOverview = "//div[@class='overview']";
    public static String proceedtoInstuction = "//*[@id='instructionDetails']/a[2]";
    public static String titleRef = "//";
    public static String backBtn = "//*[@class='navigationBtn hubNavigation_back']";
    
    
    
    
    //Instruction details
    public static String userProceedToInstructionDetails = "//*[text()='Proceed to instruction details']";  
    public static String userInstructionDetails = "//div[@id='instructionDetails_acc']";
    public static String userCustomerFName = "//input[@id='1_1_value']";
    public static String userCustomerLName = "//input[@id='2_1_value']";
    public static String userCustomerContact = "//input[@id='13_1_value']";
    public static String userCustomerEmail = "//input[@id='14_1_value']";
    public static String userSameAsCustomer = "//input[@id='checkbox_16_2_value']";
    public static String builderName = "//*[@id='50_6_value']";
    public static String builderContactNumber = "//*[@id='51_6_value']";
    public static String applicationId = "//*[@id='54_7_value']";
    public static String construction = "//*[@value='27']";
    public static String companyTitle = "//*[@id='11']"; 
    public static String leasehold = "//*[@id='16']";

    //Cart Count Pop up
    public static String userCartCountPopup = "//table[@id='cartCountRestrictionPopup']/tbody/tr[2]/td";
    public static String userCartCountContinue = "//a[@id='cartCountRestrictionContinueBtn']";
    public static String userCartCountOk= "//a[@id='cartCountRestrictionOkBtn']";
    public static String userCartCountChange = "//a[@id='cartCountRestrictionChangeProductBtn']";
    public static String userCartCountCancel = "//input[@id='cartCountRestrictionCancel']";

    // Payment Details
    public static String userProceedToPaymentDetails = "Proceed to payment details";  
    public static String userPaymentDetailsForm = "//div[@id='paymentDetailForm']";
    public static String userPaymentItem = "//td[@class='labelText hubHeaderBodyText']";
    public static String userPaymentTermsConditions = "//input[@id='termsAndConditions']";
    public static String userPaymentPassword = "//input[@id='accountPassword']";
    public static String userPaymentBroker = "//input[@id='accountId']";
    public static String userPaymentCreditName = "//input[@id='nameForTaxInvoice']";
    public static String userPaymentCreditEmail = "//input[@id='emailForTaxInvoice']";
    public static String userPaymentCreditNumber = "//input[@id='cardNumber']";
    public static String userPaymentCreditSecurity = "//input[@id='securityCode']";
    public static String userPaymentDetailsRemove = "//input[@class='hubRemoveButton']";
    public static String userPaymentDetailsRemovePopup = "//div[@id='hubCboxLoadedContent']";
    public static String userPaymentDetailsRemoveOk = "//a[contains(text(),'OK')]";
    public static String confirmPayment = "//*[@class='navigationBtn hubNavigation_next']";
    
    //Order Confirmation
    public static String userConfirmPayment = "//img[@src='/myrp/images/hub/hub_confirm.png']"; 
    public static String userOrderItem = "//*[@class='labelText']";
    public static String userOrderDetailFN = "(//div[@class='wrap']/div/div[@class='hubHeaderBodyText'])[1]";
    public static String userOrderDetailLN = "(//div[@class='wrap']/div/div[@class='hubHeaderBodyText'])[2]";
    public static String userOrderDetailCN = "(//div[@class='wrap']/div/div[@class='hubHeaderBodyText'])[3]";
    public static String userOrderDetailCA = "(//div[@class='wrap']/div/div[@class='hubHeaderBodyText'])[4]";
    
    //Mortgage Valuation Notification
    public static String userMortgagePopup = "//table[@class='hubHeaderBodyText']//td[@align='center']";
    public static String userMortgagePopupOkBtn = "(//a[@class='hubButtonText'])[6]";

    //RetroVal
    public static String userRetroValuationDate = "(//input[@id='retroDate_108'])";
    public static String userDatePickerMonth = "//select[@class='ui-datepicker-month']";
    public static String userDatePickerYear = "//select[@class='ui-datepicker-year']";
    public static String userRetroBedroom = "//select[@id='bedroom_108']";
    public static String userRetroBathroom = "//select[@id='bathroom_108']";
    public static String userRetroCarspace = "//select[@id='carspace_108']";
    public static String userRetroCheckAvailability = "(//input[@id='checkAvailability'])[2]";
    public static String errorRetroContainer ="//span[@id='checkAvailabilityError']";
    public static String errorRetroValuationDate = "//span[@colspan='4']";
    
    
    //Channels
    public static String cbaLender = "https://stage-cbalender.rppropertyhub.com";
    public static String aussieSelect = "https://stage-aussieselect.rppropertyhub.com";
    public static String bankMelbourne = "https://stage-bankmelbourne.rppropertyhub.com";
    
    
    
    //Admin Login
    public static String adminLoginUsername = "//input[@id='hubAdminLoginUsername']";
    public static String adminLoginPassword = "//input[@id='hubAdminLoginPassword']";
    public static String adminLoginButton = "//input[@id='hubAdminLoginBtn']";
    public static String adminLinkLogout = "//*[text()='Logout']";
    
    //Admin Channel - Details
    public static String adminChannelTable = "//div[@id='baseProductGroupForm']";
    public static String adminChannelHeader = "//label[@class='mainLabel']";
    public static String adminChannelEdit = "//a[contains(@href, '/n/Channel-Details/myrp-783?channelId=18')]"; //bglChannelId20
    
    //Admin Channel - Cart and Payment
    public static String adminChannelCartAndPayment = "//a[text()='Cart and Payment']";
    public static String adminChannelOrderConfirmation = "(//label[@class='mainLabel'])[1]"; 
    public static String adminCartCountCheckbox = "//input[@id='isActiveCartCountRestriction']";
    public static String adminCartCountValue = "//input[@id='isActiveCartCountRestrictionValue']";
    public static String adminCartCountNumber = "//input[@id='cartCountRestrictionNumber']";  
    public static String adminButtonSave = "//input[@value='Save']"; 
    public static String adminAccountPasswordCheckbox = "//*[@id='isDisplayAccountPassword']";
    public static String adminStaffIDCheckbox = "//*[@id='isDisplayStaffBrokerId']";
    public static String adminOnAccountHeaderMessage = "//*[contains(text(),'If both options are turned off then the On Account Payment Details section will be hidden.')]";
    public static String adminOnAccountMainHeaderMessage = "//*[contains(text(),'On Account Payment Options')]";
    public static String adminOnAccountReenterStaffIDLabel = "//*[text()[contains(.,'Re-enter Staff ID / Broker ID? Warning: Only enable if Staff ID / Broker ID is mandatory on user sign-up.')]]";
    public static String adminOnAccountReenterAccountPasswordLabel = "//*[text()[contains(.,'Re-enter Account Password?')]]";
  
    //Admin menu
    public static String  adminHome= "(//span[@class='parent'])[1]";
    public static String  adminProducts = "(//span[@class='parent'])[2]";
    public static String  adminChannels = "(//span[@class='parent'])[3]";
    public static String  adminChannelsLink = "//span[text()='Channel List']";
    public static String  adminUsers = "(//span[@class='parent'])[4]";
    public static String  adminUtilities = "(//span[@class='parent'])[5]";
    
    //Admin Channel List
    public static String adminChannelList = "//span[text()='Channel List']";
    public static String channelListHeader = "//a[text()='CHANNEL LIST']";
    public static String channelListSearchField = "//input[@id='channelSingleLineSearchTextField']";
    public static String channelListSearchBtn = "//input[@id='channelSingleLineSearchIcon']";
    public static String channelListRow = "//td[@class='list_item_container']";
    public static String channelListLender = "//a[contains(@href, '/n/Channel-Details/myrp-1072?channelId=2')]";
    public static String channelPropertyAddressNav = "//a[text()='Property Address']";
    public static String channelSearchBtn = "//*[@id='channelSingleLineSearchIcon']";
    public static String channelResult = "//*[text()=' Commonwealth Bank (Lender)']";
    public static String channelPropertyProfilerReport = "//a[text()='Property Profiler']";
    public static String channelContainer = "//*[@class='list_item_container']";
    public static String channelCBALenderEMPValue = "//*[@id='110_breCodeValue']";
    public static String channelProductSelectionSaveBtn = "(//*[@value='Save'])[1]";
    public static String channelAVMValue = "//*[@id='84_breCodeValue']";
    
    public static String propAddressAVMSource = "id='avmMainLabel'";
    public static String propAddressDropdown = "id='avmSource'";
    public static String propAddressDropdownLabel = "id='avmSourceLable'";
    public static String propAddressAVMOption1 = "id='avmSource1'";
    public static String propAddressAVMOption2 = "id='avmSource1'";
    public static String channelListProductSelectionTab = "//*[contains(text(),'Product Selection')]";
    
    //Admin Products - Base Products
    public static String adminBaseProductLink = "//a[contains(@href, 'n/Base-Products/')]";
    public static String baseProductHeader = "//a[text()='BASE PRODUCTS']";
    public static String baseProductList = "//div[@id='adminBaseProductListContainer']";
    public static String baseProductType = "//*[@id='productType']";
    public static String baseProductAddNew = "//a[text()='Add New']";
    public static String baseProductListContainer = "//*[@id='adminBaseProductListContainer']/table[1]/tbody/tr[3]";
  
    public static String baseProdAddNewLink = "//a[text()='Add New']";
    public static String baseProdCancelBtn = "(//div[@class='button-text'])[1]";
    public static String baseProdSaveBtn = "//div[@class='button-text-save']";
    public static String baseProdBackToListBtn = "(//div[@class='button-text'])[2]";
    public static String baseProductErrorMessage = "//div[@id='errorMessage']";
    public static String baseProdActivate = "//input[@id='isActivate']";
    
    public static String baseProdAddNewHeader = "//a[text()='ADD BASE PRODUCT']";
    public static String baseProdAddNewLabel = "//label[@id='base-product-mail-label']";
    public static String baseProdNameFieldLabel = "//label[text()='* Name:']";
    public static String baseProdDataGroupFieldLabel = "//label[text()='* Product Data Group:']";
    public static String baseProdTypeFieldLabel = "//label[text()='* Product Type:']";
    public static String baseProdNameField = "//input[@id='baseProductName']";
    public static String baseProdDataGroupField = "//select[@id='baseProductGroupId']";
    public static String baseProdTypeField = "//select[@id='productType']";
    public static String prodTypeReport = "//select[@id='productType']/option[@value='27']";
    public static String prodTypeService = "//select[@id='productType']/option[@value='28']";
    public static String prodTypeProcessedReport = "//select[@id='productType']/option[@value='29']";
    public static String baseProdReportSourceLabel = "//label[text()='* Report Source:']";
    public static String baseProdReportSourceField = "//select[@id='reportSourceLookup']";
    public static String repSourceValexRequestMethod = "//select[@id='reportSourceLookup']/option[@value='33']";
    public static String repSourceBSG = "//select[@id='reportSourceLookup']/option[@value='34']";
    public static String repSourceRPPropertyHub = "//select[@id='reportSourceLookup']/option[@value='35']";
    public static String repSourceValexFindMethod = "//select[@id='reportSourceLookup']/option[@value='36']";
    public static String baseProdReportTypeLabel = "//label[text()='* Report Type:']";
    public static String baseProdReportTypeField = "//select[@id='reportType']";
    public static String repTypePropertyProfile = "//option[@value='Property Profile']";
    public static String repTypeRetroVal = "//option[@value='RetroVal']";
    public static String repTypeRPAVM = "//option[@value='RP AVM']";
    public static String repTypeScorecard = "//option[@value='Scorecard']";
    public static String repTypeCBAAVM = "//option[@value='CBA AVM']";
    public static String repTypeAussieAVM = "//option[@value='Aussie AVM']";
    public static String reportNameLabel = "//label[text()='* Report Name:']";
    public static String reportNameField = "//input[@id='reportName']";
    public static String baseProdDupValServiceTypeLabel = "//td[text()='* Dup Valuation Service Type:']";
    public static String baseProdDupValServiceTypeField = "//select[@id='dupValServiceType']";
    public static String dupValServiceResidetialSF = "//select[@id='dupValServiceType']/option[@value='23']";
    public static String dupValServiceConstructionSF = "//select[@id='dupValServiceType']/option[@value='24']";
    public static String dupValServiceCompTitleSF = "//select[@id='dupValServiceType']/option[@value='25']";
    public static String dupValServiceLeaseTitleSF = "//select[@id='dupValServiceType']/option[@value='26']";
    public static String baseProdValServiceTypeLabel = "//td[text()='* Valex Service Type:']";
    public static String baseProdValServiceTypeField = "//input[@id='valexServiceType']";
    
    public static String baseProdValSubTypeLabel = "//td[text()='* ValSubType:']";
    public static String baseProdValSubTypeField = "//select[@id='valSubType']";
    public static String valSubTypeNA = "//select[@id='valSubType']/option[@value='2']";
    public static String valSubTypeDesktopValuation = "//select[@id='valSubType']/option[@value='10']";
    public static String valSubTypeShortForm = "//select[@id='valSubType']/option[@value='11']";
    public static String valSubTypeStandard = "//select[@id='valSubType']/option[@value='12']";
   
    public static String baseProdValSubTypeNoteLabel = "//td[text()='ValSubTypeNote:']";
    public static String baseProdValSubTypeNoteField = "//input[@id='valSubTypeNote']";
   
    public static String baseProdConstructionLabel = "//td[text()='* Construction:']"; 	 
    public static String baseProdConstructionField = "//select[@id='construction']";
   
    public static String valexRequestAVMSourceLabel = "//td[text()='Valex Request AVM Source:']";
    public static String valexRequestAVMSourceField = "//select[@id='requestAvmSource']";
   
    public static String valexResponseAVMSourceLabel = "//td[text()='Valex Response AVM Source:']";
    public static String valexResponseAVMSourceField = "//select[@id='responseAvmSource']";
    public static String BREServiceCode = "//*[@id='breServiceCode']";

    
    
    //Admin Products - Base Product Groups
    public static String  adminBaseProductGroupsLink= "//a[contains(@href, 'n/Base-Products-Groups/')]";
    
    //Admin Products - Custom Products
    public static String  adminCustomProductLink= "//a[contains(@href, 'n/Custom-Products/')]";
    
    //Admin Promotion Code UI List
    public static String adminPromotionLink = "//a[contains(@href, 'n/Promotions/')]";
    public static String productsTab = "//*[@id='cssmenu']/ul/li[2]/span";
    public static String adminPromotionsTab = "//*[@id='cssmenu']/ul/li[2]/ul/li[5]/a/span";
    public static String adminPromotionsSearchTextField = "//input[@id='promotionSearchTextField']";
    public static String adminPromotionsSearchCloseButton = "//img[@id='baseProductSearchClearIcon']";
    public static String adminPromotionsSearchButton = "//input[@id='baseProductSearchIcon']";
    
    public static String adminPromotionListHeaderText = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/table/tbody/tr/td[1]/table/tbody/tr/td/span/a";
    public static String adminPromotionListAddNewText = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/table/tbody/tr/td[2]/table/tbody/tr/td[1]/a";
    public static String adminPromotionListHelpLink = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/table/tbody/tr/td[2]/table/tbody/tr/td[3]/table/tbody/tr/td[3]/a";
    public static String adminPromotionListHelpIcon = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/table/tbody/tr/td[2]/table/tbody/tr/td[3]/table/tbody/tr/td[1]/img";
    public static String result = "//*[@id='adminPromotionListContainer']/table[1]/tbody/tr[3]/td/table/tbody/tr/td[1]/table/tbody/tr[1]/td/span";
    
   //Admin Promotion Code UI Add New Header
    public static String adminPromotionNew_HeaderText = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td[1]/table/tbody/tr/td[1]/span/a";
    public static String adminPromotionNew_ShowHistoryText = "";
    public static String adminPromotionNew_HelpLink = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td[5]/a";
    public static String adminPromotionNew_HelpIcon = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td[3]/img";
    public static String adminPromotionNew_BaseProdLabel = "//*[@id='base-product-mail-label']";
    
  //Admin Promotion Code UI Add New Label
    public static String adminPromotionNew_Name = "//*[@id='addPromotionForm']/tbody/tr[1]/td[1]/label";
    public static String adminPromotionNew_Description = "//*[@id='addPromotionForm']/tbody/tr[3]/td[1]/label";
    public static String adminPromotionNew_CodePrefix = "//*[@id='addPromotionForm']/tbody/tr[5]/td[1]/label";
    public static String adminPromotionNew_CodeNumber = "//*[@id='addPromotionForm']/tbody/tr[7]/td[1]/label";
    public static String adminPromotionNew_Multiplier = "//*[@id='addPromotionForm']/tbody/tr[9]/td[1]/label";
    public static String adminPromotionNew_UserLimit = "//*[@id='addPromotionForm']/tbody/tr[13]/td[1]/label";
    public static String adminPromotionNew_StartDate = "//*[@id='addPromotionForm']/tbody/tr[17]/td[1]/label";
    public static String adminPromotionNew_FinishDate = "//*[@id='addPromotionForm']/tbody/tr[19]/td[1]/label";
    public static String adminPromotionNew_Status = "//*[@id='addPromotionForm']/tbody/tr[21]/td[1]/label";
    public static String adminPromotionNew_Type = "//*[@id='addPromotionForm']/tbody/tr[23]/td[1]/label";
    public static String adminPromotionNew_TypeValue = "//*[@id='addPromotionForm']/tbody/tr[25]/td[1]/label";
    public static String adminPromotionNew_Channel = "//*[@id='addPromotionForm']/tbody/tr[27]/td[1]/label";
    public static String adminPromotionNew_BaseProduct = "//*[@id='addPromotionForm']/tbody/tr[29]/td[1]/label";
    public static String adminPromotionNew_WeekDays = "//*[@id='addPromotionForm']/tbody/tr[31]/td[1]/label";
    public static String adminPromotionNew_Region = "//*[@id='addPromotionForm']/tbody/tr[33]/td[1]/label";
    
    
  //Admin Promotion Code UI Add New Input fields
    public static String adminPromotionNew_Input_Name = "//*[@id='promotionName']";
    public static String adminPromotionNew_Input_Description = "//*[@id='description']";
    public static String adminPromotionNew_Input_CodePrefix = "//*[@id='codePrefix']";
    public static String adminPromotionNew_Input_CodeNumber = "//*[@id='codeNumber']";
    public static String adminPromotionNew_Input_chk_Multiplier = "//*[@id='isCodeMultiplier']";
    public static String adminPromotionNew_Input_txtbox_Multiplier = "//*[@id='codeMultiplier']";
    public static String adminPromotionNew_Input_chk_UserLimit = "//*[@id='isUserLimit']";
    public static String adminPromotionNew_Input_txtbox_UserLimit = "//*[@id='userLimit']";
    public static String adminPromotionNew_Input_StartDate = "//*[@id='startDate']";
    public static String adminPromotionNew_Input_FinishDate = "//*[@id='endDate']";
    public static String adminPromotionNew_Input_Status = "//*[@id='status']";
    public static String adminPromotionNew_Input_Type = "//*[@id='type']";
    public static String adminPromotionNew_Input_TypeValue = "//*[@id='typeValue']";
    public static String adminPromotionNew_Input_Channel = "//*[@id='channelId']";
    public static String adminPromotionNew_Input_BaseProduct = "//*[@id='baseProductId']";
    public static String adminPromotionNew_Input_chk_WeekDays_Sun = "(//*[@id='promotionDays'])[1]";
    public static String adminPromotionNew_Input_chk_WeekDays_Mon = "(//*[@id='promotionDays'])[2]";
    public static String adminPromotionNew_Input_chk_WeekDays_Tue = "(//*[@id='promotionDays'])[3]";
    public static String adminPromotionNew_Input_chk_WeekDays_Wed = "(//*[@id='promotionDays'])[4]";
    public static String adminPromotionNew_Input_chk_WeekDays_Thu = "(//*[@id='promotionDays'])[5]";
    public static String adminPromotionNew_Input_chk_WeekDays_Fri = "(//*[@id='promotionDays'])[6]";
    public static String adminPromotionNew_Input_chk_WeekDays_Sat = "(//*[@id='promotionDays'])[7]";
    public static String adminPromotionNew_Input_chk_Region_Act = "(//*[@id='promotionRegions'])[1]";
    public static String adminPromotionNew_Input_chk_Region_Nt = "(//*[@id='promotionRegions'])[2]";
    public static String adminPromotionNew_Input_chk_Region_Nsw = "(//*[@id='promotionRegions'])[3]";
    public static String adminPromotionNew_Input_chk_Region_Qld = "(//*[@id='promotionRegions'])[4]";
    public static String adminPromotionNew_Input_chk_Region_Sa = "(//*[@id='promotionRegions'])[5]";
    public static String adminPromotionNew_Input_chk_Region_Tas = "(//*[@id='promotionRegions'])[6]";
    public static String adminPromotionNew_Input_chk_Region_Vic = "(//*[@id='promotionRegions'])[7]";
    public static String adminPromotionNew_Input_chk_Region_Wa = "(//*[@id='promotionRegions'])[8]";
    
  //Admin Promotion Code UI Add New Buttons
    public static String adminPromotionNew_Cancel = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr/td/div/table[2]/tbody/tr/td[1]/div/div";
    public static String adminPromotionNew_Save = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr/td/div/table[2]/tbody/tr/td[3]/div/div";
    public static String adminPromotionNew_Back = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr/td/div/table[2]/tbody/tr/td[4]/div/div";
    
  //Admin Promotion Code UI Add New Horizontal Lines
    public static String adminPromotionNew_HorizontalLine1 = "//*[@id='addPromotionForm']/tbody/tr[4]/td/hr";
    public static String adminPromotionNew_HorizontalLine2 = "//*[@id='addPromotionForm']/tbody/tr[16]/td/hr";
    public static String adminPromotionNew_HorizontalLine3 = "//*[@id='addPromotionForm']/tbody/tr[26]/td/hr";
    public static String adminPromotionNew_HorizontalLine4 = "//*[@id='addPromotionForm']/tbody/tr[30]/td/hr";
    public static String adminPromotionNew_HorizontalLine5 = "//*[@id='addPromotionForm']/tbody/tr[32]/td/hr";
    
    public static String adminPromotionNew_RegionErrMsg = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr/td/div/table/tbody/tr[33]/td[2]/div[9]";
    public static String adminPromotionNew_WeekdaysErrMsg = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr/td/div/table/tbody/tr[31]/td[2]/div[8]";
    public static String adminPromotionNew_BaseProdErrMsg = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr/td/div/table/tbody/tr[29]/td[2]/div";
    public static String adminPromotionNew_CodeMultiErrMsg = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr/td/div/table/tbody/tr[11]/td[2]/div";
    public static String adminPromotionNew_UserLimitErrMsg = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr/td/div/table/tbody/tr[15]/td[2]/div";
    public static String adminPromotion_FlashMessage = "//*[@id='flashMessage']";

    //Admin Add/Edit Product Tab
    public static String adminProductTabName = "//*[@id='hubAdminChannelTab']"; 
    public static String adminProductTabDescription = "//*[@id='productTabDescription']";
    public static String adminProductTabIsActive = "//*[@id='isActive']";
    public static String adminProductTabSave = "//div[@class='button-text-save']"; 
    public static String adminChannelTab = "//*[@id='cssmenu']/ul/li[3]/span";
    public static String adminChannelListTab = "//*[@id='cssmenu']/ul/li[3]/ul/li[2]/a/span";
    public static String adminChannelSearchTextField = "//*[@id='channelSingleLineSearchTextField']";
    public static String flashMessage = "//*[@id='flashMessageContent']";  
    public static String upload = "//*[@id='thumbNailUpload']";  
    public static String ckeditor = "//*[@id='cke_contents_productTabDescription']/iframe"; 
    public static String body = "/html/body";
    public static String addNew = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td[3]/table/tbody/tr[1]/td/table/tbody/tr/td[2]/table/tbody/tr/td[5]/a";
    public static String thumbNailImg = "//*[@id='addChannelTabForm']/tbody/tr[6]/td[2]/table/tbody/tr[2]/td/img";
    public static String channelTabsContainer = "//*[@id='channelTabsContainer']/div[2]/table[1]";
    
    //Footer
    public static String userManual = "//a[@id='userManualDownload']";
    public static String contactUs = "//*[@id='custservice']/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[2]/div/a[2]";
    public static String feedback = "//*[@id='custservice']/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[2]/div/a[3]";
    public static String contactUsPage = "//div[contains(text(),'Contact Us')]";
    public static String feedbackPage = "//div[contains(text(),'Feedback')]";
    public static String poweredByBar = "//*[@id='poweredby']";
   
    //Contact Us
    public static String contactUsName = "//*[@id='contactUsName']";
    public static String contactUsEmail = "//*[@id='contactUsEmail']";
    public static String contactUsPropertyAddress = "//*[@id='contactUsAddress']";
    public static String contactUsContactNumber = "//*[@id='contactUscontactNumber']";
    public static String contactUsContactNotes = "//*[@id='contactUsNotes']";
    public static String contactUsClosebtn = "(//*[@class='simplemodal-close'])[2]";
    public static String contactUsSendEnquiry = "//*[@id='sendEnquiryButton']";
    public static String contactUsWheresMyRefNumberImg = "//*[@id='showMeSecurityCode']";
    public static String contactUsWheresMyRefNumber = "//*[@class='hubTextlink']";
    public static String contactUsModalBox = "//*[@id='process-container']/div";
    public static String contactUsCheckboxYes = "//*[@id='answerAsap']";
    public static String contactUsCheckboxNoBut = "//*[@id='answerSometimeToday']";
    public static String contactUsCheckboxNoGive = "//*[@id='nextBusinessDay']";
    //Contact Us Validation message
    public static String contactUsInvalidContactNumber = "//*[text()='Invalid contact number.']";
    public static String contactUsNameFieldRequiredError = "//*[@class='contactUsError contactUsName']";
    public static String contactUsEmailFieldRequiredError = "//*[@class='contactUsError contactUsEmail']";
    public static String contactUsPropertyAddressFieldRequiredError = "//*[@class='contactUsError contactUsAddress']";
    public static String contactUsContactNumberFieldRequiredError = "//*[@class='contactUsError contactUscontactNumber']";
    public static String contactUsContactNotesFieldRequiredError = "//*[@class='contactUsError contactUsNotes']";
    public static String contactUsUrgentMatterChooseOneError = "//*[text()='Please choose at least one.']";
    //Contact Us Labels
    public static String contactUsNameLabel = "//*[@id='contactUsForm']/table[1]/tbody/tr[1]/td[1]";
    public static String contactUsPropertyAddressLabel = "//*[@id='contactUsForm']/table[2]/tbody/tr[1]/td[1]";
    public static String contactUsUrgentMatterLabel = "//*[@class='contactUsLabel hubHeaderBodyText']";
    public static String contactUsContactNotesLabel = "//*[@id='contactUsForm']/div[7]/div/span[1]";
    public static String contactUsEmailLabel = "//*[@id='contactUsForm']/table[1]/tbody/tr[1]/td[4]";
    public static String contactUsContactNumberLabel = "//*[@id='contactUsForm']/table[3]/tbody/tr[1]/td[4]";
    public static String contactUsSuccessfullySent = "//*[text()='Your enquiry has been successfully sent.']";
    //Contact Us CFA
    public static String contactUsCFABtn = "//*[@id='cantFindAddress']";
    public static String contactUsUnitNumberLabel = "//*[text()='Unit Number:']";
    public static String contactUsStreetNumberLabel = "//*[text()='Street Number:']";
    public static String contactUsStreetNameLabel = "//*[text()='Street Name:']";
    public static String contactUsStreetTypeLabel = "//*[text()='Street Type:']";
    public static String contactUsSuburbLabel = "//*[text()='Suburb:']";
    public static String contactUsStateLabel = "//*[text()='State:']";
    public static String contactUsPostalCodeLabel = "//*[text()='Postcode:']";

    //Feedback
    public static String feedbackName = "//*[@id='feedbackName']";
    public static String feedbackEmail = "//*[@id='feedbackEmail']";
    public static String feedbackContactNumber = "//*[@id='feedbackContactNumber']";
    public static String feedbackNotes = "//*[@id='feedbackNotes']";
    public static String feedbackSuccessMsg = "//*[@id='contactUsSuccessMessage']";
    public static String feedbackSendButton = "//*[@id='sendFeedbackButton']";
    public static String feedbackerrorMsgName = "//*[@class='feedbackErrorMessage feedbackName']";
    public static String feedbackerrorMsgEmail = "//*[@class='feedbackErrorMessage feedbackEmail']";
    public static String feedbackerrorMsgContactNumber = "//*[@class='feedbackErrorMessage feedbackContactNumber']";
    public static String feedbackerrorMsgNotes = "//*[@class='feedbackErrorMessage feedbackNotes']";
    public static String feedbackclose = "(//*[@class='simplemodal-close'])[2]";
    
  //HealthCheck
    public static String dbConnection = "(//*[@class='type-number'])[1]";
    public static String bsgConnection = "(//*[@class='type-number'])[2]";
    public static String sharedStorageAccess = "(//*[@class='type-number'])[3]";
    public static String paymentGatewayConnection = "(//*[@class='type-number'])[4]";	
    public static String invoiceDirectory = "(//*[@class='type-number'])[5]";
    public static String titleAuthenticationService = "(//*[@class='type-number'])[7]";
    public static String titleDocumentService = "(//*[@class='type-number'])[6]";
    public static String cbaMultiAVMService = "(//*[@class='type-number'])[10]";
    public static String hubValex = "(//*[@class='type-number'])[8]";
    public static String hubBRE = "(//*[@class='type-number'])[9]";
    
    public static String dbLabel = "//*[contains(text(),'database')]";
    public static String bsgv2Label = "//*[contains(text(),'bsgv2')]";
    public static String sharedStorageLabel = "//*[contains(text(),'sharedstorage')]";
    public static String merchantGatewayLabel = "//*[contains(text(),'merchantgateway')]";
    public static String invoiceFolderLabel = "//*[contains(text(),'hub.invoicefolder')]";
    public static String titleDocumentLabel = "//*[contains(text(),'hub.titledocumentservice')]";
    public static String titleAuthLabel = "//*[contains(text(),'hub.titleauthservice')]";
    public static String valexLabel = "//*[contains(text(),'hub.valex')]";
    public static String breLabel = "//*[contains(text(),'hub.bre')]";
    public static String cbaMultiavmLabel = "//*[contains(text(),'cba.multiavm.ws')]";
  
    public static String HealthCheck = "//*[text()[contains(.,'\"database\"')]]";
    
  //HubTracker
    public static String hubSql = "//*[@id='sqlStatement']";
    public static String hubExecuteBtn = "//*[@value='Execute']";
    public static String hubLoggerLevel = "//*[text()='CBA AVM Service']";
    public static String hubLoggerStatus = "//*[text()='Success']";
    public static String hubLoggerResponse = "(//*[contains(text(),'SA42657')])[2]";
    
  //CFA
    public static String cantFindAddressbtn = "//*[@id='hubSearchAddressForm']/div[1]/input[3]";
    public static String unitNumberSearchAddress = "//*[@id='hubSearchAddress_unitNumber']";
    public static String streetNumberSearchAddress = "//*[@id='hubSearchAddress_streetNumber']";
    public static String lotNumberSearchAddress = "//*[@id='hubSearchAddress_lotNumber']";
    public static String streetNameSearchAddress = "//*[@id='hubSearchAddress_streetName']";
    public static String streetTypeSearchAddress = "//*[@id='hubSearchAddress_street_Type']";
    public static String suburbSearchAddress = "//*[@id='hubSearchAddress_suburbStatePostcode']";
    public static String confirmbtnSearchAddress = "//*[@id='proceedBtn']";
    public static String changeAddressLink = "//*[@id='changeAddressLink']/a[2]";
    public static String proceedNextLink = "//a[text()='Proceed to product selection']";
    //public static String completeAddress = "//*[@id='propdetails']/div[1]/div/table/tbody/tr/td[3]/table/tbody/tr[1]/td/div";
    public static String completeAddress = "//*[@class='bold hubHeaderBodyText']";
    public static String propertySearch = "//*[@id='hubSearchAddress']";
    public static String propertySearchbtn = "//*[@id='hubSearchButton']";
    public static String changePropertyPopupOK = "(//a[@class='hubButtonText'])[7]";
    public static String changePropertyAddress = "//a[text()='Change property address']";
    public static String CFASearchtrigger = "//*[@class='hubResults cantfindAddListContainer']";
    public static String CFASearchinglabel = "//*[@class='cantFindAddIndicator']";
    public static String UnitErrorMessageHidden = "//*[@class='addressDesignator errorMessage']";
    public static String StreetNameErrorMessageHidden = "//*[@class='hubSearchAddress_streetName errorMessage']";
    public static String StreetTypeErrorMessageHidden = "//*[@class='hubSearchAddress_street_Type errorMessage']";
    public static String SuburbErrorMessageHidden = "//*[@class='hubSearchAddress_suburbStatePostcode errorMessage']";
    public static String IncorrectSuburb = "(//*[@class='acResults'])[2]";
    public static String SorryCFA = "//*[contains(text(),'Sorry, we are still unable to find an address match.')]";
    public static String CFAIndicatorSearching = "//*[@class='cantFindAddIndicator']";
    public static String SuggestedList = "//*[@class='jquery-autocomplete-selected-item acSelect']";
    public static String CFABorderColor = "//*[@class='cantFindAddressContainer roundedYellowBg']";
    public static String DidYouMean = "//*[@class='searchMessage roundedYellowBg']";
    public static String NundraLink = "//a[text()='Nundah Street Brighton QLD 4017']";
    public static String DidYouMeanListWithPicture = "//*[@class='fontStyle5 hubHeaderBodyText']";
    public static String NundraLinkWithPicture = "//*[text()='10 Nundah Street,']";
    public static String NundraLotProperty = "//*[contains(text(),'236/RP76332')]";
    
  //Menu
    public static String home = "//a[text()='HOME >']";
    public static String rpProfessional = "//a[text()='RP PROFESSIONAL >']";
    public static String myAccount = "//a[text()='MY ACCOUNT >']";
    public static String myTransactions = "//a[text()='MY TRANSACTIONS >']";
    public static String logout = "//*[@id='logoutLink']";
    
  //ProductSelection
    public static String productNavBar = "//*[@id='flowbar']/div[1]/div/div[1]/div[2]/span[1]";
    public static String instructionNavBar = "//*[@id='flowbar']/div[1]/div/div[2]/div[2]/span[1]";
    public static String paymentNavBar = "//*[@id='flowbar']/div[1]/div/div[3]/div[2]/span[1]";
    public static String orderNavBar = "//*[@id='flowbar']/div[1]/div/div[4]/div[2]/span[1]";
    public static String reportsTab = "//*[@id='245']";
    public static String valuationsTab = "//*[@id='linkValuations']";
    public static String cbatitle = "//*[@id='tabReports']/table/tbody/tr/td/div/div[1]";
    public static String cbatitlestatus = "//*[@id='tabReports']/table/tbody/tr/td/div/div[2]";
    public static String purchaseBtn = "//*[@id='purchaseButton']";
    public static String pruchaseBtnSingle = "(//*[@id='purchaseButton'])[1]";
    public static String pruchaseBtnSecondLine = "(//*[@id='purchaseButton'])[2]";
    public static String addToCartLabel = "//label[text()='Added to cart']";
    public static String cartCount = "//a[@id='cartCount']";
    public static String nextBtn = "//*[@id='workspace']/table/tbody/tr[5]/td[2]/div[2]/img";
    //public static String pendingTransaction = "//*[@id='workspace']/table/tbody/tr[3]/td/div/table/tbody/tr/td[1]/div/div[2]/table/tbody/tr/td[3]/img";
    public static String pendingTransaction = "//*[text()='Start a new transaction for this property']";
    public static String CommercialTab = "//*[@id='linkCommercial']";
    public static String promotionLogo = "//*[@id='tabCommercial']/table/tbody/tr[2]/td/div/div[1]/ul/li[4]/img";
    
  //valuation form
    public static String unitValuation = "//*[@id='1']";
    public static String unitPriceValuation = "//*[@id='2']";
    public static String noneApplyCheckboxValuation = "//*[@id='26']";
    public static String avm = "//*[@id='6']";
    public static String proceedToProductValuation = "//*[text()='Proceed to product selection']";
    public static String combanklabel = "//*[text()='CommBank Property Report']";
    public static String loanAmount = "//*[@name='7']";
   
  //Instruction Details
    public static String FnameInstructionDetails = "//*[@id='1_1_value']";
    public static String LnameInstructionDetails = "//*[@id='2_1_value']";
    public static String MobileInstructionDetails = "//*[@id='13_1_value']";
    public static String EmailInstructionDetails = "//*[@id='14_1_value']";
    public static String OwnerInstructionDetails = "//*[@id='3_1_value']";
    public static String CompanyNameInstructionDetails = "//*[@id='66_1_value']";
    public static String NextBtnInstructionDetails = "//*[@id='workspace']/table/tbody/tr[2]/td[2]/div[2]/img";
    public static String NetLendableInstructionDetails = "//*[@id='67_3_value']";
    public static String RentalAmountInstructionDetails = "//*[@id='68_3_value']";
    public static String OutgoingMonthlyInstructionDetails = "//*[@id='69_3_value']";
    
    //Payment Details
    public static String LabelPaymentDetails = "//*[@id='paymenDetailForm']/ul/li[1]/label";
    public static String TermsandConditionPaymentDetails = "//*[@id='termsAndConditions']";
    public static String AccountPasswordPaymentDetails = "//*[@id='accountPassword']";
    public static String AccountIDPaymentDetails = "//*[@id='accountId']";
    public static String ConfirmBtnPaymentDetails = "//*[@id='workspace']/table/tbody/tr[4]/td[2]/div[2]/img";
    public static String PromoLabel = "//*[contains(text(),'Enter Promo Code:')]";
    public static String CreditCardName = "//*[@name='nameForTaxInvoice']";
    public static String CreditCardEmail = "//*[@name='emailForTaxInvoice']";
    public static String CreditCardNumber = "//*[@name='cardNumber']";
    public static String CreditCardSecurityCode = "//*[@name='securityCode']";
    public static String PromoField = "//*[@id='promoCode']";
    public static String PromoAddBtn = "//*[@class='hubButtonBg hubButtonText']";
    public static String ProductPrice = "(//*[@class='hubHeaderBodyText'])[3]";
    public static String MainTotalAmount = "//*[@id='mainTotalAmount']";
    
  //Order Confirmation
    public static String referenceNumber = "//label[contains(text(),'RP Data HUB Reference Number:')]";
    public static String downloadPDF = "//*[@id='checkOrderConfirmationReport']/a";
    public static String startNewOrder = "//*[@id='startAnotherOrder']/a[2]";
    public static String emailInformation = "//*[@id='workspace']/table/tbody/tr[1]/td[2]/div/div[1]/ul[1]/li";
    public static String youOrderedLabel = "//*[@id='paymentDetailForm']/ul/li/label";
    public static String customerDetailLabel = "//*[@id='workspace']/table/tbody/tr[1]/td[2]/div/table/tbody/tr[1]/td/label";
    public static String fNameInfoOrderConfirmation = "//*[@id='workspace']/table/tbody/tr[1]/td[2]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/div[1]/div[2]";
    public static String lNameInfoOrderConfirmation = "//*[@id='workspace']/table/tbody/tr[1]/td[2]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/div[2]/div[2]";
    public static String theCustomer = "//*[@id='workspace']/table/tbody/tr[1]/td[2]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/div[4]/div[2]";
    public static String mobileInfoOrderConfirmation = "(//*[@class='hubHeaderBodyText'])[10]";
    public static String startNewOrderBTN = "//*[@id='workspace']/table/tbody/tr[2]/td[2]/div[2]/img";
    public static String openReportpopup = "//*[@id='hubCboxLoadedContent']/div/table[1]/tbody/tr[2]/td";
    public static String yesBTN = "//*[text()='Yes']";
    public static String noBTN = "//*[text()='No']";
    //AussieSelect
    public static String fNameInfoOrderConfirmationAussie = "(//*[@id='workspace']/table/tbody/tr[1]/td[2]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/div[1]/div[2])[1]";
    public static String lNameInfoOrderConfirmationAussie = "(//*[@id='workspace']/table/tbody/tr[1]/td[2]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/div[2]/div[2])[1]";
    public static String mobileInfoOrderConfirmationAussie = "(//*[@id='workspace']/table/tbody/tr[1]/td[2]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/div[5]/div[2])[2]";
  //My Transaction
    public static String customerName= "//*[text()='Customer Name']";
    public static String address = "//th[@class='address']";
    public static String serviceType = "//th[@class='serviceType']";
    public static String referenceNumberTransaction = "//th[@class='referenceNumber']";
    public static String dateTransaction = "//th[@class='status'][1]";
    public static String statusTransaction = "//th[@class='status'][2]";
    public static String customerNameDetail = "(//*[@class='customerName'])[2]";
    public static String addressDetail = "(//*[@class='address'])[2]";
    public static String serviceTypeDetail = "(//*[@class='serviceType'])[2]";
    public static String referenceNumberDetail = "(//*[@class='referenceNumber'])[2]";
    public static String statusTansactionDetails = "(//*[@class='status'])[3]";
    public static String myTransactionNoTransactionAvail = "//*[text()='No available transactions yet.']";
    
  //Admin Login
    public static String loginAdminUsername = "//*[@id='hubAdminLoginUsername']";
    public static String loginAdminPassword = "//*[@id='hubAdminLoginPassword']";
    public static String loginAdminBtn = "//*[@id='hubAdminLoginBtn']";
    
  //Admin Menu
    public static String adminHomeMenu = "//*[@id='cssmenu']/ul/li[1]";
    public static String adminProductsMenu = "//*[@id='cssmenu']/ul/li[2]";
    public static String adminChannelsMenu = "//*[@id='cssmenu']/ul/li[3]";
    public static String adminUsersMenu = "//*[@id='cssmenu']/ul/li[4]";
    public static String adminUtilitiesMenu = "//*[@id='cssmenu']/ul/li[5]";
    public static String adminPromotionMenu = "//*[@id='cssmenu']/ul/li[2]/ul/li[5]/a";
    
    
    
    //ADDED BY ARVIN
  public static String adminLogout = "//a[text()='Logout']";
    //Base Product
  public static String baseProductEdit = "//a[text()='Edit']";
  public static String baseProductReportSource = "//*[@id='reportSourceLookup']";
  public static String baseProductDataGroup= "//*[@id='baseProductGroupId']";
  public static String baseProductReportType = "//*[@id='reportType']";
  public static String baseProductValSubType = "//*[@id='valSubType']";
  public static String baseProductConstruction = "//*[@id='construction']";
  public static String baseProductValexRequestAVMSource = "//*[@id='requestAvmSource']";
  public static String baseProductValexResponseAVMSource = "//*[@id='responseAvmSource']";
  public static String baseProductValexServiceType = "//*[@id='valexServiceType']";
  public static String baseProductValSubTypeNote = "//*[@id='valSubTypeNote']";
  public static String baseProductSearch = "//*[@id='baseProductSearchTextField']";
  public static String baseProductSearchBtn = "//*[@id='baseProductSearchIcon']";
  public static String baseProductName = "//*[@id='baseProductName']";
  public static String baseProductBRECheckbox = "//*[@id='isBreRequired']";
  public static String baseProductBREServiceCode = "(//*[@class='breServiceCodeHolder'])[2]";

    //Custom Product
  public static String customProductHeader = "//a[text()='CUSTOM PRODUCTS']";
  public static String customProductSearch = "//*[@id='customProductName']";
  public static String customProductSearchBtn = "//input[@value='Search']";
  public static String customProductSearchResult = "//*[@id='Land Titles']/tbody/tr[2]/td[2]";
  public static String customProductShortDesc = "//*[@id='shortDesc']";
  public static String customProductLongDesc = "//*[@id='longDesc']";
  public static String customProductProductTab = "//*[@id='productTab']";
    //Product Data Groups
  public static String adminProductDataGroupsLink= "//a[contains(@href, 'Product-Data-Groups')]";
  public static String ProductDataGroupsSearch = "//*[@id='baseProductGroupName']";
  public static String ProductDataGroupsSearchBtn = "//input[@value='Search']";
  public static String ProductDataGroupsSearchResult = "//*[@id='baseProductGroupForm']/div/div[3]/table/tbody/tr[2]/td/table/tbody/tr/td[1]";
  public static String ProductDataGroupsFirstNameCheckbox = "//*[@name='59_1_1_active']";
  public static String ProductDataGroupsLastNameCheckbox = "//*[@name='59_1_2_active']";
  public static String ProductDataGroupsContactNumberCheckbox = "//*[@name='59_1_13_active']";
  public static String ProductDataGroupsEmailCheckbox = "//*[@name='59_1_14_active']";
  public static String ProductDataGroupsFirstNameMandatoryCheckbox = "//*[@name='59_1_1_mandatory']";
  public static String ProductDataGroupsLastNameMandatoryCheckbox = "//*[@name='59_1_2_mandatory']";
  public static String ProductDataGroupsContactNumberMandatoryCheckbox = "//*[@name='59_1_13_mandatory']";
  public static String ProductDataGroupsEmailMandatoryCheckbox = "//*[@name='59_1_14_mandatory']";
    //ADDED BY ARVIN .2
  //Instruction Detail page
  public static String instructionDetailSameAsCustomerCheckbox = "//*[@id='checkbox_16_2_value']";
  public static String instructionDetailAddress = "//*[@id='4_1_value']";
  //Admin Promotion
  public static String adminPromotionsLink= "//a[contains(@href, 'Promotions')]";
  public static String adminPromotionsHeader = "//a[text()='PROMOTIONS']";
  //Payment Detail page
  public static String paymentDetailPrice = "//*[@id='purchaseReports']/table/tbody/tr[1]/td[3]";
  public static String paymentDetailTotalPrice = "//*[@id='mainTotalAmount']";
  public static String paymentDetailTitle1 = "//*[@id='purchaseReports']/table/tbody/tr[1]";
  public static String paymentDetailTitle2 = "//*[@id='purchaseReports']/table/tbody/tr[3]";

  //Promotion
  public static String adminPromotionName = "//*[@id='promotionName']";
  public static String adminPromotionDescription = "//*[@id='description']";
  public static String adminPromotionCodePrefix = "//*[@id='codePrefix']";
  public static String adminPromotionCodeNumber = "//*[@id='codeNumber']";
  public static String adminPromotionCodeMultiplierUnliCheckbox = "//*[@id='isCodeMultiplier']";
  public static String adminPromotionUserLimitUnliCheckbox = "//*[@id='isUserLimit']";
  public static String adminPromotionStartDate = "//*[@id='startDate']";
  public static String adminPromotionStartDateNow = "//button[text()='Now']";
  public static String adminPromotionFinishDate = "//*[@id='endDate']";
  public static String adminPromotionFinishDate30 = "//a[text()='30']";
  public static String adminPromotionTypeValue = "//*[@id='typeValue']";
  public static String adminPromotionChannel = "//*[@id='channelId']";
  public static String adminPromotionBaseProduct = "//*[@id='baseProductId']";
  public static String adminPromotionDaySun = "//*[@id='promotionDays'][@value='1']";
  public static String adminPromotionDayMon = "//*[@id='promotionDays'][@value='2']";
  public static String adminPromotionDayTue = "//*[@id='promotionDays'][@value='3']";
  public static String adminPromotionDayWed = "//*[@id='promotionDays'][@value='4']";
  public static String adminPromotionDayThur = "//*[@id='promotionDays'][@value='5']";
  public static String adminPromotionDayFri = "//*[@id='promotionDays'][@value='6']";
  public static String adminPromotionDaySat = "//*[@id='promotionDays'][@value='7']";
  public static String adminPromotionRegionACT = "//*[@id='promotionRegions'][@value='ACT']";
  public static String adminPromotionRegionNT = "//*[@id='promotionRegions'][@value='NT']";
  public static String adminPromotionRegionNSW = "//*[@id='promotionRegions'][@value='NSW']";
  public static String adminPromotionRegionQLD = "//*[@id='promotionRegions'][@value='QLD']";
  public static String adminPromotionRegionSA = "//*[@id='promotionRegions'][@value='SA']";
  public static String adminPromotionRegionTAS = "//*[@id='promotionRegions'][@value='TAS']";
  public static String adminPromotionRegionVIC = "//*[@id='promotionRegions'][@value='VIC']";
  public static String adminPromotionRegionWA = "//*[@id='promotionRegions'][@value='WA']";
  public static String adminPromotionSave = "//div[@class='button-text-save']";

  //RP PROFESSIONAL
  public static String RPPusername = "//*[@id='rppUserName']";

  //CBA Multi AVM 
  public static String CBANotAvailableAVMBtn = "//*[@class='cartButtonDisabled purchaseButton_69']";
  
  //BUILD VERSION
  public static String BuildVersion = "//*[@id='poweredby']";
  
  //Property Detail
  public static String userCartPropertyDetail = "//a[@id='cartCount']";
  public static String propertyPhoto = "//*[@id='propdetails']/div[1]/div/table/tbody/tr/td[1]/img";
  public static String bedrooms = "//*[@id='propdetails']/div[1]/div/table/tbody/tr/td[3]/table/tbody/tr[5]/td/div/table/tbody/tr/td[1]";
  public static String bathRooms = "//*[@id='propdetail']/div[1]/div/table/tbody/tr/td[3]/table/tbody/tr[5]/td/div/table/tbody/tr/td[3]";
  public static String carSpace = "//*[@id='propdetails']/div[1]/div/table/tbody/tr/td[3]/table/tbody/tr[5]/td/div/table/tbody/tr/td[5]";
  public static String landArea = "//*[@id='propdetails']/div[1]/div/table/tbody/tr/td[3]/table/tbody/tr[5]/td/div/table/tbody/tr/td[7]";
  public static String lotNumber = "//*[@id='propdetails']/div[1]/div/table/tbody/tr/td[3]/table/tbody/tr[3]/td";
  public static String changePropertyAdress = "//*[@id='changeAddressLink']/a[2]";
  public static String proceedtoProductSelection = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[1]/td/table/tbody/tr/td[2]/div/a[2]";
  public static String pendingTransactionMessage = "//*[@class='hubPendingTransaction']";
  public static String deletePendingTransaction = "//*[@id='workspace']/table/tbody/tr[3]/td/div/table/tbody/tr/td[1]/div/div[2]/table/tbody/tr/td[3]/img";
  public static String homeButton = "//*[text()='HOME >']";
  public static String okButton = "//*[text()='OK']";
  public static String cancelButton = "//*[text()='Cancel']";
  public static String customerId = "//*[@id='customerId']";
  public static String guestId = "//*[@id='guestId']"; 
  
  
  //Product Selection
  
  
  
}




