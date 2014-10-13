package a.tools.alfresco;

public class Constants {

	// API LOGIN
	public static final String ALFRESCO_USER_LOGIN = "admin";
	public static final String ALFRESCO_PASS_LOGIN = "admin";

	public static final String TESTDATA_FILES_BASE_PATH = "src/test/resources/";

	//public static final String SERVER_URL = "http://172.22.4.164:8080";
	public static final String SERVER_URL = "http://172.22.4.164:8080";
	public static final String SHARE_URL = SERVER_URL + "/share";
	public static final String LOCAL_URL = "http://172.22.4.164:8080/share/page";
	public static final String EXPLORER_URL = SERVER_URL + "/alfresco";
	public static final String ALFRESCO_SERVICE_URL = SERVER_URL
			+ "/alfresco/service";
	
	public static final String DOCUMENT_LIBRARY_PREFIX = "/page/site/";
	public static final String DOCUMENT_LIBRARY_SUFIX = "/documentlibrary";

	public static final String RESTRICTED_CHILD_ASSOCIATION = "Restricted Child Association";

	// Collection Aspect - and Collection icon
	public static final String COLLECTABLE = "Collectable";
	public static final String BOOK_CUSTOM_ICON_LARGE = "/share/res/components/images/filetypes/generic-book-64.png";
	public static final String BOOK_CUSTOM_ICON_SMALL = "/share/res/components/images/filetypes/generic-book-16.png";
	public static final String CONTENTS_CUSTOM_ICON_LARGE = "/share/res/components/images/filetypes/generic-contents-64.png";
	public static final String CONTENTS_CUSTOM_ICON_SMALL = "/share/res/components/images/filetypes/generic-contents-16.png";

	// API RELATED
	public static final String DOCUMENT_LIBRARY_API = "/documentLibrary";
	public static final String DOCUMENT_LIBRARY_CONTAINER = "documentLibrary";
	public static final String UPLOAD_API_URL = ALFRESCO_SERVICE_URL
			+ "/api/upload";
	public static final String CREATE_FOLDER_API_URL = ALFRESCO_SERVICE_URL
			+ "/api/site/folder/";
	public static final String MANAGE_ASPECTS_API_URL = ALFRESCO_SERVICE_URL
			+ "/slingshot/doclib/action/aspects/node/";

	// Default wait time
	public static final long WAIT_TIME = 2000;

	public static final String SITE_NAME = "DanTest";

	// Link To - related constants
	public static final String LINK_ICON_URL = "/share/res/components/ixxus-collections/css/images/link-16.png";
	public static final String LINK_TO_PREFIX = "Link to: ";

	// MODEL Related
	public static final String TYPE_FOLDER = "cm:folder";
	public static final String ASPECT_COLLECTABLE = "ixc:collectable";
	
	public static final String ALFRESCO_API_BASE_URL = "http://alfresco.int.pson.ixxus.co.uk";

 
    public static final String MY_DASHBOARD_SUFIX = "user/admin/dashboard";

    public static final String[] SITE_VISIBILITIES = new String[] { "PUBLIC",
            "MODERATED", "PRIVATE" };

    
    public static final int EMAIL_RETRY_CYCLEs = 5;
    public static final int MAX_NO_OF_WORKFLOWS_PER_PAGE = 50;


    // -------Admin details---------
    public static final String ALFRESCO_ADMIN_USERNAME = "admin";
    public static final String ALFRESCO_ADMIN_PASSWORD = "";
    public static final String OLD_ALFRESCO_INTERFACE_URL = ALFRESCO_API_BASE_URL
            + "/alfresco/faces/jsp/login.jsp";

    // --------new test user -------------
    public static final String TEST_USERNAME = "validUsername";
    public static final String TEST_LASTNAME = "lastnameTestAPI";
    public static final String TEST_FIRSTNAME = "firstNameTestApi";
    public static final String TEST_EMAIL = "testAPI@yopmail.com";
    public static final String TEST_PASSWORD = "";

    // User Agent
    public static final String USER_AGENT = "Mozilla/5.0";

    public static final String FILES_FOLDER = FileUtils.getProjectPath()
            + "\\src\\test\\resources\\testdata\\";

    //public final static String TESTDATA_FILES_PATH =  "\\src\\test\\resources\\testdata\\";
    public final static String TESTDATA_FILES_PATH =  "src/test/resources/testdata/";
    public static final String SIKULI_IMAGES_FOLDER = FileUtils
            .getProjectPath() + "/src/test/resources/com/tools/";
	public static final long WAIT_TIME_SHORT = 2000;

    // menu labels
    public static String CONVERSION_COMPLETED_MESSAGE = "Do you want to open the conversion report?";
    public static String DOCUMENT_LIBRARY = "Document Library";
    public static String UPLOAD = "Upload";
    public static String CREATE = "Create";
    public static String FOLDER = "Folder";
    
    
    public static final String SITE_PREFIX = "/page/site/";
	public static final String SITE_SUFIX = "/dashboard";
	
	public static final String GLOBAL_CONFIG_FULL_NAME = "global-config.properties";
	public static final String GLOBAL_CONFIG_PATH = "/testdata/global-config.properties";

	//POM property for site base url
	public static final String URL_PROPERTY = "webdriver.base.url";

	public final static String PROPERTY_FILE_SUFFIX = "-config.properties";

	public static final String LOCAL_HOST = "localhost";
	public static final String ALFRESCO_URL = "http://ix-iclbigtest1.ixxus.co.uk:8080/share/page/";
	public static final String ALFRESCO_URL_Cengage = "http://54.85.197.85:8080/share/";

	
	//used for url validation when building the string url to compare
	public static final String SITE_URL_PREFIX = "/company_home/sites/";
	public static final String SITE_URL_SUFIX = "/documentLibrary";

	public static final String ENVIRONMENT_JENKINS = "jenkins";
	public static final String YES = "Yes";

	public static final String PATH_SEPARATOR = " > ";

	public static final long WAIT_TIME_LONG = 9000;

	public static final String FIREFOX = "firefox";
	public static final char CSV_SEPARATOR = ',';

	public static final String PUPPET_TEST_FILES_PATH = "D:\\temp\\testing\\";

	public static final long EMAIL_WAIT_TIME = 4000;
	public static final long EMAIL_WAIT_CYCLE = 5000;

	public static final String CREATE_COLLECTION = "Collection";
	public static final String CREATE_FOLDER = "Folder";
	public static final String CREATE_PROJECT = "Project";
	public static final String CREATE_TEXT = "Placeholder Asset";
	public static final String CREATE_ASSET_SPEC = "Asset Specification";
	public static final String CREATE_SERIES = "Series";

	public static final String ASSET_LABEL_NAME = "Name:";
	public static final String ASSET_LABEL_TITLE = "Title:";
	public static final String ASSET_LABEL_DESCRIPTION = "Description:";
	public static final String ASSET_LABEL_MODIFIED_DATE = "Modified Date:";
	public static final String ASSET_LABEL_CREATED_DATE = "Created Date:";
	public static final String ASSET_LABEL_MODIFIER = "Modifier:";
	public static final String ASSET_LABEL_CREATOR = "Creator:";
	public static final String ASSET_LABEL_AUTHOR = "Author:";
	public static final String ASSET_LABEL_LANGUAGE_TOPIC = "Language Teaching Aspect";
	
	// asset metadata
	public static final String ASSET_METADATA_LABEL = "Asset";
	public static final String EXTERNAL_LINK_LABEL = "External Link:";
	public static final String SUPPLIER_NAME_LABEL = "Supplier Name:";
	public static final String SUPPLIER_ID_LABEL = "Supplier Asset ID:";
	public static final String METADATA_COMPLETE_LABEL = "Metadata Complete:";
	public static final String METADATA_COMPLETE_VALUE = "Yes";
	

	public static final String DAY_MONTH_YEAR_DATE = "dd/MM/yyyy";
	public static final String WEEKDAY_MONTH_YEAR_DATE = "EEE dd MMM yyyy";

	public static final String ASSET_FIRST_VERSION = "0.1";
//	 public static final String ASSET_FIRST_VERSION = "1.0";

//	public static final String LOCKED_DOCUMENT_MESSAGE = "This document is locked by you for offline editing.";
	 public static final String LOCKED_DOCUMENT_MESSAGE = "This document is locked by";

	public static final String CANCEL_EDITING = "Cancel Editing";

	// User Roles
	public static final String USER_ROLE_MANAGER = "Manager";
	public static final String USER_ROLE_COLLABORATOR = "Collaborator";
	public static final String USER_ROLE_CONTRIBUTOR = "Contributor";
	public static final String USER_ROLE_CONSUMER = "Consumer";
//	public static final String USER_ROLE_OUP_MANAGERS = "OUP Managers";
//	public static final String USER_ROLE_OUPMANAGERS = "roles.oupmanager";
	public static final String USER_ROLE_EDITOR = "Editor";
	
	// user privileges
	public static final String CONSUMER_PRIVILEGES ="Consumer privileges";
	public static final String CONTRIBUTOR_PRIVILEGES ="Contributor privileges";
	public static final String COLLABORATOR_PRIVILEGES ="Collaborator privileges";
	

	public static final String BUTTON_YES = "Yes";
	public static final String BUTTON_DELETE = "Delete";

	public static final String SEARCH_SITE_URL_PREFIX = "/page/site-finder";

	public static final String ASSET_DELETED_OLDER_VERSION_MESSAGE = "This document has no previous versions";
	
	public static final String RAG_LABEL="RAG:";
	public static final String RAG_STATUS_BLACK="oupRAG-0";
	public static final String RAG_STATUS_RED="oupRAG-1";
	public static final String RAG_STATUS_AMBER="oupRAG-2";
	public static final String RAG_STATUS_GREEN="oupRAG-3";
	
	public static final String SELECT_SITES="Sites";

	public static final String DELETE_SITE_URL_PREFIX = "http://172.22.4.164:8080/alfresco/service/api/sites/";

	public static final String ADD_BUTTON_LABEL="Add";
	public static final String SEARCH_USERS_FOR_ROLES="Enter a search term to find users";

	public enum ENUM_VIEWS {SIMPLE_VIEW,DETAILED_VIEW,GALLERY_VIEW,SPREADSHEET_VIEW, FILMSTRIP_VIEW,TABLE_VIEW,AUDIO_VIEW,MEDIA_VIEW}
	
	// view mode display
	public static final String SIMPLE_VIEW="Simple View";
	public static final String DETAILED_VIEW="Detailed View";
	public static final String GALLERY_VIEW="Gallery View";
	public static final String SPREADSHEET_VIEW="spreadsheet-view";
	public static final String FILMSTRIP_VIEW="Filmstrip View";
	public static final String TABLE_VIEW="Table View";
	public static final String AUDIO_VIEW="Audio View";
	public static final String MEDIA_VIEW="Media View";
	public static final String CURRENT_VIEW_ATTRIBUTE="checked";
	public static final String DELETE_RESTRICTION_MESSAGE_SUFFIX = "Could not delete";
	public static final String DELETE_RESTRICTION_MESSAGE_PREFIX = "This could be because the item is used/referenced";
	
	// project ststuses
	public static final String DRAFT_REVIEW_STATUS = "Draft";
	public static final String INFORMAL_REVIEW_STATUS = "Informal Review";
	public static final String FORMAL_REVIEW_STATUS = "Formal Review";
	public static final String REWORK_STATUS = "Rework";
	public static final String FINAL_APPROVAL_STATUS="Final Approval";
	
	public static final String EMAIL_SUFFIX = "@Fiction23111.com";
	public static final String FUTURE_DATE = "31/5/2014";

	public static final String RAG_RED = "Red";
	public static final String RAG_AMBER = "Amber";
	public static final String RAG_GREEN = "Green";
	public static final String RAG_BLACK = "Black";
	public static final String SEARCH_PREFIX = "/page/search?t=";
	public static final String SEARCH_SUFFIX = "&r=true";
	
	public static final String MINUTE_LABEL = "Minute(s)";
	public static final String HOUR_LABEL = "Hour(s)";
	public static final String DAY_LABEL = "DAY";
	public static final String WEEK_LABEL = "Week(s)";
	public static final String MONTH_LABEL = "Month(s)";
	public static final String DELETE_MESSAGE_SUFFIX = " was deleted";
	
	// bulk metadata templates
	public static final String DOWNLOAD_TEMPLATE_FOR_SELECTED_ITEMS = "Download template for selected items";
	public static final String UPLOAD_ASSET_SPECIFICATION_TEMPLATE = "Upload asset specification template";
	public static final String TRUE = "true";
	
	public static final String CONTENT_SEARCH_LABEL = "Content";
	public static final String ASSET_SEARCH_LABEL = "Asset";
	
	public static final String METADATA_COMLETE_YES_LABEL = "Yes";
	public static final String METADATA_COMLETE_NO_LABEL = "No";
	
	// selected items
	public static final String DELETE_FROM_SELECTED_ITEMS = "Delete";
	
	// asset text types
	public static final String ARTICLE_TEXT_TYPE = "Article";
	public static final String MANUSCRIPT_TEXT_TYPE = "Manuscript";

	
	// derived assets
	public static final String DERVED_DESCENDANTS_PREFIX = "Copy of ";

	// selected items actions
	public static final String BULK_EDIT_METADATA = "Bulk Edit Metadata";
	public static final String WORKFLOW_ADHOC = "Adhoc Workflow";
	public static final String WORKFLOW_ASSET_SPEC_REVIEW = "Asset Specification Review";
	public static final String WORKFLOW_REVIEW_AND_APPROVE = "Review And Approve";
	
	public static final String MOVE_TO_FROM_SELECTED_ITEMS = "Move to...";
	public static final String LINK_TO_FROM_SELECTED_ITEMS = "Link To...";
	public static final String MANAGE_PERMISSIONS_FROM_SELECTED_ITEMS = "Manage Permissions...";
	public static final String START_WORKFLOW = "Start Workflow...";
	
	public static final String ASSET_UNDER_REVIEW = "Under Review";
	public static final String ASSET_UNDER_APPROVAL = "Under Approval";
	public static final String ASSET_REWORK = "Rework";
	public static final String ASSET_PENDING_FINAL_APPROVAL = "Pending Final Approval";
	public static final String ASSET_FINAL = "Final";
	public static final String ASSET_DRAFT = "Draft";
	

	// assey spec rights clearance status
	public static final String RIGHTS_PENDING = "Rights Pending";
	public static final String RIGHTS_CLEARED = "Rights Cleared";
	public static final String RIGHTS_DENIED = "Rights Denied";
	public static final String RIGHTS_UNABLED = "Unable to get rights after best effort";
	
	// transformation formats
	public static final String HTML_TRANSFORMATION = "HTML";
	public static final String PLAIN_TEXT_TRANSFORMATION = "Plain Text";
	public static final String XHTML_TRANSFORMATION = "XHTML";
	public static final String XML_TRANSFORMATION = "XML";
	public static final String PREFIX_TRANSFORMATION = "transf-";
	public static final String HTML_EXTENSION = ".html";
	public static final String XHTML_EXTENSION = ".xhtml";
	public static final String XML_EXTENSION = ".xml";
	public static final String TEXT_EXTENSION = ".txt";
	
	// properties view mode expandins fields
	public static final String DOCUMENT_ACTIONS = "Document Actions";
	public static final String PROPERTIES = "Properties";

	public static final String ITEM_NOT_FOUND_MESSAGE = "The item cannot be found. Either you do not have permissions to view the item, it has been removed or it never existed.";
	
	// workflow
	public static final String WORKFLOW_OUTCOME_START_PROGRESS = "Start Progress";
	public static final String WORKFLOW_OUTCOME_REVERT_TO_DRAFT = "Revert to Draft";
	public static final String WORKFLOW_OUTCOME_REQUEST_REWORK = "Request Rework";
	public static final String STATUS_IN_PROGRESS = "(In Progress)";
	public static final String WORKFLOW_OUTCOME_SUBMIT_FOR_APPROVAL = "Submit for Approval";
	public static final String STATUS_UNDER_APPROVAL = "(Under Approval)";
	public static final String WORKFLOW_OUTCOME_APPROVE = "Approve";
	public static final String STATUS_FULFILLED = "(Fulfilled)";

	public static final String STATUS_UNDER_REVIEW = "(Under Review)";
	public static final String STATUS_DRAFT = "(Draft)";
	public static final String FINAL_PROJECT_STATUS = "Final";
	
	public static final String CONTENT_PREFIX = "CONT";
	public static final String WORKFLOW_WARNING_OVERRIDE = "Warning Override Approve";
	public static final String WARNING_OVERRIDE_APPLIED = "Warning Override Applied";
	public static final String REVIEW_REJECTED = "The document was reviewed and rejected.";
	public static final String CLOSED_PROJECT_STATUS = "Closed";
	public static final String WORKFLOW_POOLED_REVIEW = "Pooled Review And Approve";
	public static final String RELEASE_TO_POOL = "Release to Pool";
	public static final String WORKFLOW_PARALLEL_REVIEW = "Parallel Review And Approve";
	public static final String WORKFLOW_REJECTED ="Rejected";
	public static final String WORKFLOW_REJECTED_BY="Rejected by ";
	public static final String WORKFLOW_APPROVED ="Approved";
	public static final String WORKFLOW_APPROVED_BY ="Approved by ";
	public static final String WORKFLOW_INITIATOR_TASK="InitiatorTask- ";
	public static final String WORKFLOW_SEQUENTIAL_REVIEW = "Sequential Review And Approve";
	public static final String ACTIVITY_WORKFLOW_CONSOLE_URL = "?";
}
