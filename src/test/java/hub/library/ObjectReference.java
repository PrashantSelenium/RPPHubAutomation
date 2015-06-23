package hub.library;

public class ObjectReference {

	ReadXmlData rxml = new ReadXmlData();
   
    public String prod_url = rxml.data("prod_url");
    public String local_url = rxml.data("local_url");
 
////USER PAGE////
    
    //User login Page
    public static String userLoginUsername = "//input[@id='userName']";
    public static String userLoginPassword = "//input[@id='password']";
    public static String userLoginButton = "(//input[@id='subRegInd'])[2]";
    public static String hubLoginError = "//div[@id='hubLoginError']";
    public static String userLogoutLink = "//a[@id='logoutLink']";
    public static String emptyErrorMessage = "Username or Password should not be empty.";
    public static String invalidErrorMessage = "//*[text()='Invalid Username and/or Password, please try again.']";
    public static String loginMandatoryFields = "//*[text()='Please complete all mandatory fields.']";
    public static String loginNotEmpty = "//*[text()='Username and/or Password should not be empty.']";
    public static String registerButton = "(//input[@id='subRegInd'])[1]";
    public static String loginButton = "(//input[@id='subRegInd'])[2]";
    public static String mandatoryFields = "//div[@id=flashMessageContent']";
    public static String mandatoryMessage = "Please complete all mandatory fields.";
    public static String loginSecurityError = "//div[@id='flashMessageContent']/div";
    public static String loginSecurityMessage = "You have attempted 3 times to login. Please click on Forgot My Password to reset your account's password.";
    public static String loginErrorMessage = "//*[@id='hubLoginError']";
    public static String register = "//input[@value='Register New User']";
    public static String login_FlashMessage = "//*[@id='flashMessage']";
    public static String LoginButton = "//input[@value='Login']";
    
    //Forgot Password
    public static String forgotPasswordUsername = "//*[@id='user-name']";
    public static String forgotPasswordEmail = "//*[@id='email-address']";
    public static String forgotPasswordLabel = "//*[@id='hub-forgot-password']/div/div[2]/div[1]";
    public static String forgotPasswordValidationOnEmptyFields = "//*[text()='Username and/or Email Address field should not be empty.']";
    public static String forgotPasswordValidationOnInvalidInputs = "//*[text()='Invalid Username and/or Email Address.']";
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
    
    //Signup page
    public static String registrationForm = "//form[@id='hubRegisForm']";
    public static String signupCaptchaImg = "//img[@id='scImage']";
    public static String signupCaptcha = "//input[@id='validationCode']";
    public static String signupDone ="//input[@id='subRegInd']";
    public static String signUpErrorFN = "//*[@class='errorMessage firstNameError']";
    public static String signUpErrorLN = "//*[@class='errorMessage lastNameError']";
    public static String signUpErrorBranchId = "//*[@class='BranchIDError errorMessage']";
    public static String signUpErrorStaffId = "//*[@class='StaffIDBrokerIDError errorMessage']";
    public static String signUpErrorProfId = "//*[@class='ProfessionalIndustryBodyIDError errorMessage']";
    public static String signUpErrorUserRole = "//*[text()='User role should not be empty.']";
    public static String signUpErrorEmail = "//*[text()='Email should not be empty.']";
    public static String signUpErrorEmailInvalidInput = "//*[text()='Invalid email format.']";
    public static String signUpErrorEmailNotMatch = "//*[text()='Email does not match.']";
    public static String signUpErrorConfirmEmail = "//*[text()='Confirm email should not be empty.']";
    public static String signUpErrorConfirmEmailNotMatch = "//*[@class='errorMessage confirmUserPassError']";
    public static String signUpErrorMobile = "//*[text()='Mobile number should not be empty.']";
    public static String signUpErrorMobileInvalid = "//*[text()='Invalid mobile number.']";
    public static String signUpErrorPhone = "//*[text()='Phone number should not be empty.']";
    public static String signUpErrorPhoneInvalid = "//*[text()='Invalid phone number.']";
    public static String signUpErrorUsername = "//*[text()='Username should not be empty.']";
    public static String signUpErrorUsernameSymbol = "//*[text()='Please use only letters, numbers or symbols.']";
    public static String signUpErrorPassword = "//*[text()='Password should not be empty.']";
    public static String signUpErrorPasswordMinChar = "//*[text()='Password must be at least 6 characters long.']";
    public static String signUpErrorConfirmPass = "//*[text()='Confirm password should not be empty.']";
    public static String signUpErrorSecurityQuestion = "//*[text()='Security question should not be empty.']";
    public static String signUpErrorSecurityAnswer = "//*[text()='Security answer should not be empty.']";
    public static String signUpErrorCaptcha = "//*[text()='Validation code should not be empty.']";
    public static String signUpErrorCaptchaValidation = "//*[text()='Error validating your security verification code.']";
    public static String signUpErrorTermsnConditions = "//*[text()='Please read and accept the Terms & Conditions.']";    
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
    public static String myAccountFN = "//*[@id='firstName']";
    public static String myAccountLN = "//*[@id='lastName']";
    public static String myAccountBranchId = "//*[@id='BranchID']";
    public static String myAccountStaffId = "//*[@id='CompanyID']";
    public static String myAccountProfId = "//*[@id='ProfessionalIndustryBodyID']";
    public static String myAccountEmail = "//*[@id='userEmail']";
    public static String myAccountConfirmEmail = "//*[@id='confirmUserEmail']";
    public static String myAccountMobile = "//*[@id='mobileNumber']";
    public static String myAccountPhone = "//*[@id='phoneNumber']";
    public static String myAccountUsername = "//*[@id='userName']";
    public static String myAccountPassword = "//*[@id='newPassword']";
    public static String myAccountConfirmPassword = "//*[@id='confirmUserPass']";
    public static String myAccountSecurityQuestion = "//*[@id='securityQuestion']";
    public static String myAccountSecurityAnswer = "//*[@id='securityAnswer']";
    public static String myAccountUserRole = "//*[@id='userRole']";
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
    public static String myAccountErrorStaffId = "//*[text()=' Staff ID/Broker ID should not be empty.']";
    public static String myAccountErrorBranchId = "//*[text()=' Branch ID should not be empty.']";
    public static String myAccountErrorPasswordNotMatch = "//*[text()='Password does not match.']";

    //My Transactions
    public static String userMyTransactions = "//li[@id='myTransactions']/div/a";
    public static String userMyTransactionList = "//div[@class='TransactionList']"; 
    public static String transactionList ="//*[@class='TransactionList']";
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
    public static String cantFindAddressbtn = "//*[contains(@src,'cantFindAddress')]";
    public static String unitNumberSearchAddress = "//*[@id='hubSearchAddress_unitNumber']";
    public static String streetNumberSearchAddress = "//*[@id='hubSearchAddress_streetNumber']";
    public static String lotNumberSearchAddress = "//*[@id='hubSearchAddress_lotNumber']";
    public static String streetNameSearchAddress = "//*[@id='hubSearchAddress_streetName']";
    public static String streetTypeSearchAddress = "//*[@id='hubSearchAddress_street_Type']";
    public static String suburbSearchAddress = "//*[@id='hubSearchAddress_suburbStatePostcode']";
    public static String confirmbtnSearchAddress = "//*[@id='proceedBtn']";
    public static String changeAddressLink = "//*[@id='changeAddressLink']/a[2]";
    public static String proceedNextLink = "//a[text()='Proceed to product selection']";
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
    public static String CFASuburbSuggestion = "//*[@class='jquery-autocomplete-selected-item acSelect']";
    
    //Pending Transactions
    public static String userPendingTransactionMessage ="//*[@id='divContainer']";
    public static String startNewTransaction = "//*[@onclick='javascript:HubPendingTransaction.startNewTransaction();']";
    
  //Property Detail
    public static String propertDetailsTile = "//*[@id='propdetails']";
    public static String userCart ="//a[@id='cartCount']";
    public static String userPropertyPhoto = "//*[@alt='Property Photo']";
    public static String userCartPropertyDetail = "//a[@id='cartCount']";
    public static String propertyAddress = "//*[@class='bold hubHeaderBodyText']";
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
    public static String inconsistentData = "//*[text()='Inconsistent Data']";
    public static String hubReferenceNumberLabel = "//*[@class='hubHeaderBodyText']//label";
    public static String hubReferenceNumber = "//*[@class='hubHeaderBodyText']//label//span";

    //User Product tabs
    public static String productTabsMenu = "//div[@id='containerTab']";
    public static String tabReports = "//a[@id='linkReports']";
    public static String tabValuations = "//a[@id='linkValuations']";
    public static String userProductTab = "//input[@id='linkResidential_Valuations']";
    public static String tabResidentialValuation = "//input[@id='linkResidential_Valuations']";
    public static String tabRetroReports = "//div[@id='linkRetro_Reports']";
    public static String tabCommercialValuations ="//div[@id='linkCommercial_Valuations']";
    public static String tabCommercial = "//*[@id='linkCommercial']";
    public static String tabRuralValuations ="//div[@id='linkRural_Valuations']";
    public static String userValuationsTab = "//div[@id('tabValuations')]";
    public static String userRetroReportsTab = "//div[@id='tabRetro_Reports']";
    public static String tabAffordability = "//*[@id='linkAffordability']";
    
    //User Base Products
    public static String productLenderEmpowerment = "//*[@id='tabReports']//input[@id='purchaseButton']";
    public static String lenderEmpAdded = "//*[@id='tabReports']//*[contains(@class,'itemAdded')]";
    public static String productLenderAVM = "//div[@id='tabValuations']//input[@id='purchaseButton']";
    public static String productShorFormVal = "//div[@id='tabValuations']/table/tbody/tr[2]/td/div/div/ul/li[2]/div/input[@id='purchaseButton']";
    public static String productName = "//*[@id='tabReports']//h2[@class='hubHeaderBodyText']";
    public static String productShort = "//*[@id='tabReports']//*[contains(@class,'shortDescription')]";
    public static String productMore = "//*[@id='tabReports']//*[contains(@class,'moreDetails')]";    
    public static String productLong = "//*[@id='tabReports']//*[contains(@class,'longDescription')]";
    public static String productHide = "//*[@id='tabReports']//*[contains(@class,'hideDetails')]";
    public static String onAccountDisplay = "//*[@id='tabReports']//*[contains(@class,'price')]";
    public static String titleName = "(//h2[@class='hubHeaderBodyText'])[1]";
    public static String titleMoreDetails = "(//a[@class='hubTextlink moreDetails'])[1]";
    public static String titleShort = "(//span[@class='hubHeaderBodyText shortDescription'])[1]";
    public static String titleLong = "(//span[@class='hubHeaderBodyText longDescription'])[1]";
    public static String shortFormAddToCart = "//*[@class='hubButtonText hubButtonBg purchaseButton_71']";
    public static String constructionAddToCart = "//*[@class='hubButtonText hubButtonBg purchaseButton_72']";
    public static String commercialDesktopDualAddToCart = "//*[@class='hubButtonText hubButtonBg purchaseButton_101']";
    public static String SuburbScorecardAddToCart = "//*[@class='hubButtonText hubButtonBg purchaseButton_31']";
    public static String RPDtataAutovalAddToCart = "//*[@class='hubButtonText hubButtonBg purchaseButton_10']";
    public static String aussieShortFormAddToCart = "//*[@class='hubButtonText hubButtonBg purchaseButton_104']";
    public static String propProfileV3AddToCart = "//*[@class='hubButtonText hubButtonBg purchaseButton_130']";

    //User Originator
    public static String userOriginatorDetails = "//div[@id='div_questionnaire']";
    public static String originatorHeader = "//form[@id='propertyDetailQuestions']//label";
    public static String xButton = "//*[@class='simplemodal-close questionaireClose']";
    public static String propertyTypeLabel = "(//form[@id='propertyDetailQuestions']//td[@class='propertyDetailLabels'])[1]";
    public static String propertyTypeSelect = "(//form[@id='propertyDetailQuestions']//select[@class='propertyType'])[1]";
    public static String propertyTypeSelectValue = "(//form[@id='propertyDetailQuestions']//select[@value])";
    public static String infoIcon = "//form[@id='propertyDetailQuestions']//img[@class='infoIcon']";
    public static String oevppLabel = "(//form[@id='propertyDetailQuestions']//td[@class='propertyDetailLabels'])[2]";
    public static String oevppLabelDollar = "//form[@id='propertyDetailQuestions']//span[contains(text(),'$')]";
    public static String userOEVPP = "//input[@id='2']";
    public static String oevppErrorMsg = "//form[@id='propertyDetailQuestions']//div[@class='propertyValue errorMessage']";
    public static String loanAmountLabel = "(//form[@id='propertyDetailQuestions']//td[@class='propertyDetailLabels'])[3]";
    public static String loanAmountDollar = "(//form[@id='propertyDetailQuestions']//span[contains(text(),'$')])[2]";
    public static String orgLoanAmount = "//*[@id='7']";
    public static String loanPurposeLabel = "(//form[@id='propertyDetailQuestions']//td[@class='propertyDetailLabels'])[3]";
    public static String loanPurposeRefinance = "(//*[@id='3'])[2]";
    public static String daotaLabel = "(//form[@id='propertyDetailQuestions']//td[@class='propertyDetailLabels'])[4]";
    public static String daotaErrorMsg = "//form[@id='propertyDetailQuestions']//div[@id='errorMessage4']";
    public static String userNoneApply ="//input[@id='26']";
    public static String avmAckLabel = "(//form[@id='propertyDetailQuestions']//td[@class='propertyDetailLabels'])[6]";
    public static String avmAckSelect = "//form[@id='propertyDetailQuestions']//input[@id='6']";
    public static String avmAckDesc = "(id('propertyDetailQuestions')//span)[25]";
    public static String avmAckError = "(//form[@id='propertyDetailQuestions']//div[contains(@class,'AvmAckError')])[2]";
    public static String daotaCompanyTitle = "//form[@id='propertyDetailQuestions']//input[@id='11']";
    public static String loanAppLabel = "(//form[@id='propertyDetailQuestions']//td[@class='propertyDetailLabels'])[5]";
    public static String loanAppSelect = "//form[@id='propertyDetailQuestions']//input[@id='5']";
    public static String loanAppDesc = "(id('propertyDetailQuestions')//span)[23]";
    public static String loanAppError = "(//form[@id='propertyDetailQuestions']//*[contains(text(),'Loan Application')])[1]";
    public static String userAVMAck ="//input[@id='6']";
    public static String loanApplication ="//input[@id='5']";
    public static String iconOriginatorToProductSelection = "//form[@id='propertyDetailQuestions']//img[contains(@src,'proceedIcon')]";
    public static String proceedToProductSelection = "//*[@id='propertyDetailQuestions']/div[2]/table[2]/tbody/tr[1]/td[2]/a[2]";
    public static String userOriginatorToProductSelection = "//*[text()='Proceed to product selection']";
    public static String userOriginatorProceed = "(//table[@class='propertyDetailQuestionLink']//a)[2]";
    public static String costingReport ="//input[@id='12']";
    public static String loanPurchase ="//*[@value='8']";
    public static String loanRefinance ="//*[@value='9']";
    public static String loanTopup ="//*[@value='10']";
    public static String loanConstruction ="//*[@value='27']";
    public static String loanCHLM ="//*[@value='30']";
    public static String doAnyApplyConstructionCompleted = "//*[@id='31']";		
    public static String doAnyApplyCostingReport ="//*[@id='12']";		
    public static String doAnyApplyDevelopmentSite ="//*[@id='13']";		
    public static String doAnyApplyDHA ="//*[@id='33']";		
    public static String doAnyApplyDisplayHome ="//*[@id='34']";		
    public static String doAnyApplyLeasehold ="//*[@id='16']";		
    public static String doAnyApplyMultipleDwelling ="//*[@id='18']";		
    public static String doAnyApplyNonResidential ="//*[@id='19']";		
    public static String doAnyApplyNonHabitable ="//*[@id='20']";		
    public static String doAnyApplyOffThePlan ="//*[@id='21']";		
    public static String doAnyApplyPropertyBeing ="//*[@id='22']";		
    public static String doAnyApplyPropertySize40ha ="//*[@id='36']";		
    public static String doAnyApplyPropertySize50haor22ha ="//*[@id='32']";		
    public static String doAnyApplyReverseMortgage ="//*[@id='38']";		
    public static String doAnyApplyServiceManagement ="//*[@id='37']";		
    public static String doAnyApplyStudentStyle ="//*[@id='25']";		
    
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
    public static String emptyCartMessage = "//*[@class='cartCountMessage']//*[@class='hubHeaderBodyText']";
    public static String emptyCartOkBtn = "//*[@class='cartCountMessage']//*[@id='continueChangeAdd']";
    public static String emptyCartXBtn = "//*[@id='hubCboxClose']";
    public static String cartInstructionMessage = "//table[@class='hubHeaderBodyText']";
    public static String workflowBar = "//*[@id='flowbar']";
    public static String productSelectionBar ="//*[@id='flowbar']//*[contains(text(),'PRODUCT')]";
    public static String instructionDetailsTab = "//*[@id='flowbar']//*[contains(text(),'INSTRUCTION')]";
    public static String paymentDetailsBar ="//*[@id='flowbar']//*[contains(text(),'PAYMENT')]";
    public static String OrderConfirmationBar ="//*[@id='flowbar']//*[contains(text(),'ORDER')]";
    public static String userOnAccountLabel = "(//*[@class='hubHeaderBodyText productPrice'])[4]";
    public static String dynamicProductTabLink = "//a[@id='link{?}']";
    public static String propertyType = "//*[@class='propertyType']";
    public static String productNavBar = "//*[@id='flowbar']/div[1]/div/div[1]/div[2]/span[1]";
    public static String instructionNavBar = "//*[@class='topLabel instructionDetailsLink']";
    public static String paymentNavBar = "//*[@class='topLabel paymentDetailsLink";
    public static String orderNavBar = "//*[@id='flowbar']/div[1]/div/div[4]/div[2]/span[1]";
    public static String reportsTab = "//*[@id='245']";
    public static String valuationsTab = "//*[@id='linkValuations']";
    public static String cbatitle = "//*[@id='tabReports']/table/tbody/tr/td/div/div[1]";
    public static String cbatitlestatus = "//*[@id='tabReports']/table/tbody/tr/td/div/div[2]";
    public static String purchaseBtn = "//*[@id='purchaseButton']";
    public static String purchaseBtnSingle = "(//*[@id='purchaseButton'])[1]";
    public static String purchaseBtnSecondLine = "(//*[@id='purchaseButton'])[2]";
    public static String purchaseBtnThirdLine = "(//*[@id='purchaseButton'])[3]";
    public static String purchaseBtnFourthLine = "(//*[@id='purchaseButton'])[4]";
    public static String purchaseBtnFifthLine = "(//*[@id='purchaseButton'])[5]";
    public static String addToCartLabel = "//label[text()='Added to cart']";
    public static String cartCount = "//a[@id='cartCount']";
    public static String nextBtn = "//*[@class='navigationBtn hubNavigation_next']";
    public static String pendingTransaction = "//*[text()='Start a new transaction for this property']";
    public static String CommercialTab = "//*[@id='linkCommercial']";
    public static String promotionLogo = "//*[@id='tabCommercial']/table/tbody/tr[2]/td/div/div[1]/ul/li[4]/img"; 
    public static String AVMProduct = "//*[text()='Automated Valuation Model']";
    public static String ShortForm = "//*[text()='Short Form Valuation']";
    public static String ShortFormLeaseHold = "//*[text()='Short Form Leasehold Title Valuation']";
    public static String ShortFormPrice = "(//*[@class='hubHeaderBodyText productPrice'])[2]";
    public static String ConstructionPrice = "(//*[@class='hubHeaderBodyText productPrice'])[5]";
    public static String NoAvailableMessage ="//*[@id='noPackagesAvailableMessage']";
    public static String SampleReport = "(//*[@alt='PDF Icon'])[3]";  //valuation form
    public static String unitValuation = "//*[@id='1']";
    public static String unitPriceValuation = "//*[@id='2']";
    public static String noneApplyCheckboxValuation = "//*[@id='26']";
    public static String avm = "//*[@id='6']";
    public static String proceedToProductValuation = "//*[text()='Proceed to product selection']";
    public static String combanklabel = "//*[text()='CommBank Property Report']";
    public static String loanAmount = "//*[@name='7']";
 
    //Instruction details
    public static String userProceedToInstructionDetails = "//*[text()='Proceed to instruction details']";  
    public static String insBackBtn = "//*[@src='/ttsvr/myrp/images/hub/hub_back.png']";
    public static String insNextBtn = "//*[@src='/ttsvr/myrp/images/hub/hub_next.png']";	
    public static String insPaymentIcon = "//*[@src='/ttsvr/cropImage/myrp.images.hub_i_proceedIcon.png']";
    public static String insPaymentLink = "//*[text()='Proceed to payment details']";
    public static String insChangeAddIcon = "//*[@src='/ttsvr/cropImage/myrp.images.hub_i_changeAddressIcon.png']";
    public static String insChangeAddLink = "//*[text()='Change property address']";
    public static String userInstructionDetails = "//div[@id='instructionDetails_acc']";
    public static String insCustomerDetails = "//*[@id='CustomerDetails']";
    public static String insPropertyAccess = "//*[@id='PropertyAccessDetails']";
    public static String insConstructionDetails = "//*[@id='ConstructionDetails']";
    public static String insLoanDetails = "//*[@id='LoanDetails']";
    public static String insStrataDetails = "//*[@id='StrataDetails']";
    public static String insDocumentUpload = "//*[@id='documentUploads']";
    public static String insSpecialInstructions = "//*[@id='SpecialInstructions']";
    public static String insCustomerDetailsForm = "//*[@id='CustomerDetails_form']";
    public static String insPropertyAccessForm = "//*[@id='PropertyAccessDetails_form']";
    public static String insLoanDetailsForm = "//*[@id='LoanDetails_form']";
    public static String insDocumentUploadForm = "//*[@id='documentUploads_form']";
    public static String insSpecialInstructionsForm = "//*[@id='SpecialInstructions_form']";
    public static String custFnameLabel = "//label[@for='1_1_value']";
    public static String custLnameLabel = "//label[@for='2_1_value']";
    public static String custCustomerIsLabel = "//label[@for='3_1_value']";
    public static String custContactLabel = "//label[@for='13_1_value']";
    public static String custEmailLabel = "//label[@for='14_1_value']";
    public static String userCustomerFName = "//*[@id='1_1_value']";
    public static String userCustomerLName = "//*[@id='2_1_value']";
    public static String userCustomerContact = "//*[@id='13_1_value']";
    public static String userCustomerEmail = "//*[@id='14_1_value']";
    public static String userCustomerCompany = "//*[@id='66_1_value']";
    public static String custFnameError = "//*[@class='1_1_value errorMessage']";
    public static String custLnameError = "//*[@class='2_1_value errorMessage']";
    public static String custContactError = "//*[@class='13_1_value errorMessage']";
    public static String custEmailError = "//*[@class='14_1_value errorMessage']";
    public static String accessFnameLabel = "//label[@for='17_2_value']";
    public static String accessLnameLabel = "//label[@for='18_2_value']";
    public static String accessCompanyLabel = "//label[@for='19_2_value']";
    public static String accessContactLabel = "//label[@for='21_2_value']";
    public static String accessEmailLabel = "//label[@for='22_2_value']";
    public static String accessFName = "//*[@id='17_2_value']";
    public static String accessLName = "//*[@id='18_2_value']";
    public static String accessCompany = "//*[@id='19_2_value']";
    public static String accessContact = "//*[@id='21_2_value']";
    public static String accessEmail = "//*[@id='22_2_value']";
    public static String accessFnameError = "//*[@class='17_2_value errorMessage']";
    public static String accessLnameError = "//*[@class='18_2_value errorMessage']";
    public static String accessCompanyError = "//*[@class='19_2_value errorMessage']";
    public static String accessContactError = "//*[@class='21_2_value errorMessage']";
    public static String accessEmailError = "//*[@class='22_2_value errorMessage']";
    public static String loanApplicationIdLabel = "//label[@for='54_7_value']";
    public static String loanValuationIdLabel = "//label[@for='62_7_value']";    
    public static String loanApplicationId = "//*[@id='54_7_value']";
    public static String loanValuationId = "//*[@id='62_7_value']";    
    public static String loanApplicationIdError = "//*[@class='54_7_value errorMessage']";
    public static String loanValuationIdError = "//*[@class='62_7_value errorMessage']";    
    public static String insCustomerIs = "//*[@id='3_1_value']";
    public static String theOwner = "//*[@id='3_1_value']//option[@value='1']";
    public static String theAgent = "//*[@id='3_1_value']//option[@value='2']";
    public static String theBorrower = "//*[@id='3_1_value']//option[@value='3']";
    public static String thePurchaser = "//*[@id='3_1_value']//option[@value='4']";
    public static String theOther = "//*[@id='3_1_value']//option[@value='5']";    
    public static String specialInstruction = "//*[@id='60_8_value']";
    public static String userSameAsCustomer = "//*[@id='checkbox_16_2_value']";
    public static String accessSameAsLabel = "//label[@for='16_2_value']";    
    public static String insAddress = "//*[@id='4_1_value']";
    public static String insCantFindAddress = "//*[@id='5_1_value']";
    public static String insLotUnitNumber = "//*[@id='6_1_value']";
    public static String insStreetNumber = "//*[@id='7_1_value']";
    public static String insStreetName = "//*[@id='8_1_value']";
    public static String insStreetType = "//*[@id='9_1_value']";
    public static String insSuburb = "//*[@id='10_1_value']";
    public static String insState = "//*[@id='11_1_value']";
    public static String insPostcode = "//*[@id='12_1_value']";   
    public static String consCompNameLabel = "//label[@for='49_6_value']";
    public static String builderNameLabel = "//label[@for='50_6_value']";
    public static String builderContactNumberLabel = "//label[@for='51_6_value']";   
    public static String consCompName = "//*[@id='49_6_value']";
    public static String builderName = "//*[@id='50_6_value']";
    public static String builderContactNumber = "//*[@id='51_6_value']";
    public static String applicationId = "//*[@id='54_7_value']";
    public static String construction = "//*[@value='27']";
    public static String companyTitle = "//*[@id='11']";    
    public static String leasehold = "//*[@id='16']";    
    public static String strataNetLabel = "//label[@for='67_3_value']";
    public static String strataRentalLabel = "//label[@for='68_3_value']";
    public static String strataOutgoingsLabel = "//label[@for='69_3_value']";
    public static String strataNet = "//*[@id='67_3_value']";
    public static String strataRental = "//*[@id='68_3_value']";
    public static String strataOutgoings = "//*[@id='69_3_value']";
    public static String specialInstructions = "//*[@id='60_8_value']";
    public static String cartCountPopup = "//*[@class='cartCountMessage']";
    public static String cartCountOK = "//*[text()='OK']";
    public static String popupCancel = "//*[text()='Cancel']";
    public static String pleaseWaitBlock = "//*[@class='blockUI blockOverlay']";
    public static String insChangeAddress = "//*[text()='Change property address']";
    public static String changeAddressPopup = "//*[@id='hubCboxLoadedContent']//*[@class='changeAddress']";
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
    public static String InstructionDetailsTab = "//*[@class='bottomLabel instructionDetailsLink']";
    public static String instructionDetailSameAsCustomerCheckbox = "//*[@id='checkbox_16_2_value']";
    public static String instructionDetailAddress = "//*[@id='4_1_value']";

    //Cart Count Pop up
    public static String userCartCountPopup = "//table[@id='cartCountRestrictionPopup']/tbody/tr[2]/td";
    public static String userCartCountContinue = "//a[@id='cartCountRestrictionContinueBtn']";
    public static String userCartCountOk= "//a[@id='cartCountRestrictionOkBtn']";
    public static String userCartCountChange = "//a[@id='cartCountRestrictionChangeProductBtn']";
    public static String userCartCountCancel = "//input[@id='cartCountRestrictionCancel']";

    // Payment Details
    public static String ProceedToPaymentDetails = "//*[text()='Proceed to payment details']";
    public static String userPaymentDetailsForm = "//div[@id='paymentDetailForm']";
    public static String userPaymentItem = "//td[@class='labelText hubHeaderBodyText']";
    public static String userPaymentTermsConditions = "//input[@id='termsAndConditions']";
    public static String accountPasswordPaymentDetails = "//input[@id='accountPassword']";
    public static String staffIDPaymentDetails = "//input[@id='accountId']";
    public static String userPaymentCreditName = "//input[@id='nameForTaxInvoice']";
    public static String userPaymentCreditEmail = "//input[@id='emailForTaxInvoice']";
    public static String userPaymentCreditNumber = "//input[@id='cardNumber']";
    public static String userPaymentCreditSecurity = "//input[@id='securityCode']";
    public static String userPaymentDetailsRemove = "//input[@class='hubRemoveButton']";
    public static String userPaymentDetailsRemovePopup = "//div[@id='hubCboxLoadedContent']";
    public static String userPaymentDetailsRemoveOk = "//a[contains(text(),'OK')]";
    public static String confirmPayment = "//*[@class='navigationBtn hubNavigation_next']";
    public static String termAndConditionsErrorPaymentDetails = "//*[@class='termsAndConditionsError errorMessage']";		
    public static String accountPasswordErrorPaymentDetails = "//*[@class='accountPasswordError errorMessage']";		
    public static String staffIDErrorPaymentDetails = "//*[@class='accountIdError errorMessage']";
    public static String CPSIframe = "//iframe[@id='card_payment_iframe']";
    public static String CPSCardNumber = "//*[@id='CardNumber']";
    public static String CPSCardHolderName = "//*[@id='CardHolderName']";
    public static String CPSDateExpiry = "//*[@id='DateExpiry_1']";
    public static String CPSDateExpiry2 = "//*[@id='DateExpiry_2']";
    public static String CPSCvc2 = "//*[@id='Cvc2']";
    public static String LabelPaymentDetails = "//*[@id='paymenDetailForm']/ul/li[1]/label";
    public static String TermsandConditionPaymentDetails = "//*[@id='termsAndConditions']";
    public static String AccountPasswordPaymentDetails = "//*[@id='accountPassword']";
    public static String AccountIDPaymentDetails = "//*[@id='accountId']";
    public static String ConfirmBtnPaymentDetails = "//*[@id='hubNavigation_next']";
    public static String PromoLabel = "//*[contains(text(),'Enter Promo Code:')]";
    public static String CreditCardName = "//*[@name='nameForTaxInvoice']";
    public static String CreditCardEmail = "//*[@name='emailForTaxInvoice']";
    public static String CreditCardNumber = "//*[@name='cardNumber']";
    public static String CreditCardSecurityCode = "//*[@name='securityCode']";
    public static String PromoField = "//*[@id='promoCode']";
    public static String PromoAddBtn = "//*[@class='hubButtonBg hubButtonText']";
    public static String ProductPrice = "(//*[@class='hubHeaderBodyText'])[3]";
    public static String MainTotalAmount = "//*[@id='mainTotalAmount']";
    public static String InvoiceName = "//*[@name='nameForTaxInvoice']";
    public static String InvoiceEmail = "//*[@name='emailForTaxInvoice']";
    public static String InvoiceNameErrorMessage = "//*[@class='nameForTaxInvoice errorMessage']";
    public static String InvoiceEmailErrorMessage = "//*[@class='emailForTaxInvoice errorMessage']";
    public static String PaymentProductName = "(//*[@class='labelText hubHeaderBodyText'])[1]";
    public static String paymentDetailPrice = "//*[@id='purchaseReports']/table/tbody/tr[1]/td[3]";
    public static String paymentDetailTotalPrice = "//*[@id='mainTotalAmount']";
    public static String paymentDetailTitle1 = "//*[@id='purchaseReports']/table/tbody/tr[1]";
    public static String paymentDetailTitle2 = "//*[@id='purchaseReports']/table/tbody/tr[3]";
    public static String paymentOnAccountFields = "(//*[@class='padding'])[3]";
    public static String paymentCPSFields = "(//*[@class='padding'])[4]";

    //Order Confirmation
    public static String proceedToOrderConfirmation = "//*[text()='Proceed to order confirmation']";
    public static String userConfirmPayment = "//img[@src='/myrp/images/hub/hub_confirm.png']"; 
    public static String userOrderItem = "//*[@class='labelText']";
    public static String userOrderDetailFN = "(//div[@class='wrap']/div/div[@class='hubHeaderBodyText'])[1]";
    public static String userOrderDetailLN = "(//div[@class='wrap']/div/div[@class='hubHeaderBodyText'])[2]";
    public static String userOrderDetailCN = "(//div[@class='wrap']/div/div[@class='hubHeaderBodyText'])[3]";
    public static String userOrderDetailCA = "(//div[@class='wrap']/div/div[@class='hubHeaderBodyText'])[4]";
    public static String referenceNumber = "//label[contains(text(),'RP Data HUB Reference Number:')]";
    public static String downloadPDF = "//*[@id='checkOrderConfirmationReport']/a";
    public static String startNewOrder = "//*[@id='startAnotherOrder']/a[2]";
    public static String emailInformation = "//*[@id='workspace']/table/tbody/tr[1]/td[2]/div/div[1]/ul[1]/li";
    public static String youOrderedTile = "//*[@id='paymentDetailForm']";
    public static String youOrderedLabel = "//*[@id='paymentDetailForm']//*[@class='mainLabel youPurchasedLabel hubHeaderBodyText']";
    public static String youOrderedTotal = "//*[@id='paymentDetailForm']//*[@class='redLabel hubHeaderBodyText']";
    public static String youOrderedItem = "//*[@id='purchaseReports']//*[@class='labelText']";
    public static String youOrderedPrice = "(//*[@id='purchaseReports']//td)[2]";
    public static String customerDetailLabel = "//*[@id='workspace']/table/tbody/tr[1]/td[2]/div/table/tbody/tr[1]/td/label";
    public static String fNameInfoOrderConfirmation = "//*[@id='workspace']/table/tbody/tr[1]/td[2]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/div[1]/div[2]";
    public static String lNameInfoOrderConfirmation = "//*[@id='workspace']/table/tbody/tr[1]/td[2]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/div[2]/div[2]";
    public static String theCustomer = "//*[@id='workspace']/table/tbody/tr[1]/td[2]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/div[4]/div[2]";
    public static String mobileInfoOrderConfirmation = "(//*[@class='hubHeaderBodyText'])[10]";
    public static String startNewOrderBTN = "//*[@id='hubNavigation_next']";
    public static String startNewOrderIcon = "//*[@id='startAnotherOrder']//*[@href='javascript:ReferenceNumber.navigateHome();'][1]";
    public static String startNewOrderLink = "//*[@id='startAnotherOrder']//*[@href='javascript:ReferenceNumber.navigateHome();'][2]";
    public static String openReportpopup = "//*[@id='hubCboxLoadedContent']//*[@class='hubHeaderBodyText']";
    public static String yesBTN = "//*[text()='Yes']";
    public static String noBTN = "//*[text()='No']";
    public static String ocOriginatorEmail = "//*[@class='orderConfirmationDesc'][1]//li[1]";
    public static String ocCustomerEmail = "//*[@class='orderConfirmationDesc'][1]//li[2]";
    public static String ocTaxDesc = "//*[@class='orderConfirmationDesc'][2]//li[1]";
    public static String ocConfInfo = "//*[@class='orderConfirmationDesc'][2]//li[2]";
    public static String ocCopyPage = "//*[@class='orderConfirmationDesc'][2]//li[2]//td[1]";
    public static String ocProductEnquiry = "(//*[@class='orderConfirmationDesc'][2]//li[2]//td)[2]";
    public static String ocGenReport = "//*[@class='orderConfirmationDesc'][2]//li[3]";
    public static String ocFirstName = "(//*[@class='innerDiv']//div[2])[1]";
    public static String ocLastName = "(//*[@class='innerDiv']//div[2])[2]";
    public static String ocContact = "(//*[@class='innerDiv']//div[2])[4]";
    public static String ocEmail = "(//*[@class='innerDiv']//div[2])[5]";
    public static String ocCustomer = "(//*[@class='innerDiv']//div[2])[3]";
    public static String ocAccessFirstName = "(//*[@class='innerDiv']//div[2])[6]";
    public static String ocAccessLastName = "(//*[@class='innerDiv']//div[2])[7]";
    public static String ocCompany = "(//*[@class='innerDiv']//div[2])[8]";
    public static String ocAccessContact = "(//*[@class='innerDiv']//div[2])[9]";
    public static String ocAccessEmail = "(//*[@class='innerDiv']//div[2])[10]";
    public static String ocLoanApp = "(//*[@class='innerDiv']//div[2])[11]";
    public static String ocLoanVal = "(//*[@class='innerDiv']//div[2])[12]";
    public static String mortgageValuationPopup = "//*[@id='hubCboxLoadedContent']//*[@class='hubHeaderBodyText']";
    
    //Footer
    public static String userManual = "//a[@id='userManualDownload']";
    public static String contactUs = "//*[@class='contactUsLink hubFooterText']";
    public static String feedback = "//*[@class='feedbackLink hubFooterText']";
    public static String contactUsPage = "//*[contains(text(),'Contact Us')]";
    public static String feedbackPage = "//*[contains(text(),'Feedback')]";
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
    public static String contactUsInvalidContactNumber = "//*[text()='Invalid contact number.']";
    public static String contactUsNameFieldRequiredError = "//*[@class='contactUsError contactUsName']";
    public static String contactUsEmailFieldRequiredError = "//*[@class='contactUsError contactUsEmail']";
    public static String contactUsPropertyAddressFieldRequiredError = "//*[@class='contactUsError contactUsAddress']";
    public static String contactUsContactNumberFieldRequiredError = "//*[@class='contactUsError contactUscontactNumber']";
    public static String contactUsContactNotesFieldRequiredError = "//*[@class='contactUsError contactUsNotes']";
    public static String contactUsUrgentMatterChooseOneError = "//*[text()='Please choose at least one.']";
    public static String contactUsNameLabel = "//*[@id='contactUsForm']/table[1]/tbody/tr[1]/td[1]";
    public static String contactUsPropertyAddressLabel = "//*[@id='contactUsForm']/table[2]/tbody/tr[1]/td[1]";
    public static String contactUsUrgentMatterLabel = "//*[@class='contactUsLabel hubHeaderBodyText']";
    public static String contactUsContactNotesLabel = "//*[@id='contactUsForm']/div[7]/div/span[1]";
    public static String contactUsEmailLabel = "//*[@id='contactUsForm']/table[1]/tbody/tr[1]/td[4]";
    public static String contactUsContactNumberLabel = "//*[@id='contactUsForm']/table[3]/tbody/tr[1]/td[4]";
    public static String contactUsSuccessfullySent = "//*[text()='Your enquiry has been successfully sent.']";
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
   
    //Menu
    public static String home = "//a[text()='HOME >']";
    public static String rpProfessional = "//a[text()='RP PROFESSIONAL >']";
    public static String myAccount = "//a[text()='MY ACCOUNT >']";
    public static String myTransactions = "//a[text()='MY TRANSACTIONS >']";
    public static String logout = "//*[@id='logoutLink']";
    public static String admLogout = "//*[text()='Logout']";
    public static String adminLogout = "//a[text()='Logout']";
    
   //***********END of USER PAGE*****************//
    
    
 ////CHANNELS////
    
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
    
  //AussieSelect
    public static String fNameInfoOrderConfirmationAussie = "(//*[@id='workspace']/table/tbody/tr[1]/td[2]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/div[1]/div[2])[1]";
    public static String lNameInfoOrderConfirmationAussie = "(//*[@id='workspace']/table/tbody/tr[1]/td[2]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/div[2]/div[2])[1]";
    public static String mobileInfoOrderConfirmationAussie = "(//*[@id='workspace']/table/tbody/tr[1]/td[2]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/div[5]/div[2])[2]";
    
  //CBA Multi AVM 
    public static String CBANotAvailableAVMBtn = "//*[@class='cartButtonDisabled purchaseButton_69']";
    
   //***********END of CHANNELS*****************//    
    
    
////ADMIN PAGE////
    
    //Admin Login
    public static String adminLoginUsername = "//input[@id='hubAdminLoginUsername']";
    public static String adminLoginPassword = "//input[@id='hubAdminLoginPassword']";
    public static String adminLoginButton = "//input[@id='hubAdminLoginBtn']";
    public static String adminLinkLogout = "//*[text()='Logout']";
    public static String loginAdminUsername = "//*[@id='hubAdminLoginUsername']";
    public static String loginAdminPassword = "//*[@id='hubAdminLoginPassword']";
    public static String loginAdminBtn = "//*[@id='hubAdminLoginBtn']";
    
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
    public static String adminHomeMenu = "//*[@id='cssmenu']/ul/li[1]";
    public static String adminProductsMenu = "//*[@id='cssmenu']/ul/li[2]";
    public static String adminChannelsMenu = "//*[@id='cssmenu']/ul/li[3]";
    public static String adminUsersMenu = "//*[@id='cssmenu']/ul/li[4]";
    public static String adminUtilitiesMenu = "//*[@id='cssmenu']/ul/li[5]";
    public static String adminPromotionMenu = "//*[@id='cssmenu']/ul/li[2]/ul/li[5]/a";
    
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
    public static String baseProdAddNewLabel = "//*[@id='base-product-mail-label']";
    public static String baseProdNameFieldLabel = "//*[text()='* Name:']";
    public static String baseProdDataGroupFieldLabel = "//label[text()='* Product Data Group:']";
    public static String baseProdTypeFieldLabel = "//*[text()='* Product Type:']";
    public static String baseProdNameField = "//*[@id='baseProductName']";
    public static String baseProdDataGroupField = "//*[@id='baseProductGroupId']";
    public static String baseProdTypeField = "//*[@id='productType']";
    public static String prodTypeReport = "//*[@id='productType']/option[@value='27']";
    public static String prodTypeService = "//*[@id='productType']/option[@value='28']";
    public static String prodTypeProcessedReport = "//*[@id='productType']/option[@value='29']";
    public static String baseProdReportSourceLabel = "//*[text()='* Report Source:']";
    public static String baseProdReportSourceField = "//*[@id='reportSourceLookup']";
    public static String repSourceValexRequestMethod = "//*[@id='reportSourceLookup']/option[@value='33']";
    public static String repSourceBSG = "//*[@id='reportSourceLookup']/option[@value='34']";
    public static String repSourceRPPropertyHub = "//*[@id='reportSourceLookup']/option[@value='35']";
    public static String repSourceValexFindMethod = "//*[@id='reportSourceLookup']/option[@value='36']";
    public static String baseProdReportTypeLabel = "//*[text()='* Report Type:']";
    public static String baseProdReportTypeField = "//*[@id='reportType']";
    public static String repTypePropertyProfile = "//*[@value='Property Profile']";
    public static String repTypeRetroVal = "//*[@value='RetroVal']";
    public static String repTypeRPAVM = "//*[@value='RP AVM']";
    public static String repTypeScorecard = "//*[@value='Scorecard']";
    public static String repTypeCBAAVM = "//*[@value='CBA AVM']";
    public static String repTypeAussieAVM = "//*[@value='Aussie AVM']";
    public static String reportNameLabel = "//*[text()='* Report Name:']";
    public static String reportNameField = "//*[@id='reportName']";
    public static String baseProdDupValServiceTypeLabel = "//*[text()='* Dup Valuation Service Type:']";
    public static String baseProdDupValServiceTypeField = "//*[@id='dupValServiceType']";
    public static String dupValServiceResidetialSF = "//*[@id='dupValServiceType']/option[@value='23']";
    public static String dupValServiceConstructionSF = "//*[@id='dupValServiceType']/option[@value='24']";
    public static String dupValServiceCompTitleSF = "//*[@id='dupValServiceType']/option[@value='25']";
    public static String dupValServiceLeaseTitleSF = "//*[@id='dupValServiceType']/option[@value='26']";
    public static String baseProdValServiceTypeLabel = "//*[text()='* Valex Service Type:']";
    public static String baseProdValServiceTypeField = "//*[@id='valexServiceType']";   
    public static String baseProdValSubTypeLabel = "//*[text()='* ValSubType:']";
    public static String baseProdValSubTypeField = "//*[@id='valSubType']";
    public static String valSubTypeNA = "//*[@id='valSubType']/option[@value='2']";
    public static String valSubTypeDesktopValuation = "//*[@id='valSubType']/option[@value='10']";
    public static String valSubTypeShortForm = "//*[@id='valSubType']/option[@value='11']";
    public static String valSubTypeStandard = "//*[@id='valSubType']/option[@value='12']";  
    public static String baseProdValSubTypeNoteLabel = "//*[text()='ValSubTypeNote:']";
    public static String baseProdValSubTypeNoteField = "//*[@id='valSubTypeNote']";
    public static String baseProdConstructionLabel = "//*[text()='* Construction:']"; 	 
    public static String baseProdConstructionField = "//*[@id='construction']";   
    public static String valexRequestAVMSourceLabel = "//*[text()='Valex Request AVM Source:']";
    public static String valexRequestAVMSourceField = "//*[@id='requestAvmSource']";   
    public static String valexResponseAVMSourceLabel = "//*[text()='Valex Response AVM Source:']";
    public static String valexResponseAVMSourceField = "//*[@id='responseAvmSource']";
    public static String BREServiceCode = "//*[@id='breServiceCode']";
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
   
    //Admin Products - Base Product Groups
    public static String  adminBaseProductGroupsLink= "//a[contains(@href, 'n/Base-Products-Groups/')]";
    
    //Admin Products - Custom Products
    public static String  adminCustomProductLink= "//a[contains(@href, 'n/Custom-Products/')]";
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
    
  //Admin Promotion
    public static String adminPromotionsLink= "//a[contains(@href, 'Promotions')]";
    public static String adminPromotionsHeader = "//a[text()='PROMOTIONS']";
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
    public static String adminPromotionFinishDate28 = "//a[text()='28']";  
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
    
    
  //***********END of ADMIN PAGE*****************//
    
////OTHERS////
    
  //HubTracker
    public static String hubSql = "//*[@id='sqlStatement']";
    public static String hubExecuteBtn = "//*[@value='Execute']";
    public static String hubLoggerLevel = "//*[text()='CBA AVM Service']";
    public static String hubLoggerStatus = "//*[text()='Success']";
    public static String hubLoggerResponse = "(//*[contains(text(),'SA42657')])[2]";
   
  //RP PROFESSIONAL
  public static String RPPusername = "//*[@id='rppUserName']";
  
  //BUILD VERSION
  public static String BuildVersion = "//*[@id='poweredby']";
  
//***********END of OTHERS*****************//
  
}




