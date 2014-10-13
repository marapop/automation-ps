package a.tools.alfresco;

import net.thucydides.core.annotations.Feature;

public class Application {
	
	@Feature
	public class BasicFunctionality{
		public class LoginIntoShare {}
		public class NavigateToRepository{}
		public class NavigateToDocumentView{}
		public class DashboardHeaderButtons{}
		public class CreateSite{}
		public class DeleteSite{}
		public class CreateUser{}
	}

	@Feature
	public class Search{
		public class Simple{}
		public class Advanced{}
	}
	
	@Feature
	public class Assets{		
		public class CancelEditing{}
		public class Edit{}
		public class History {}
		public class Comments {}
		public class Upload{}
		public class Versions{}
		public class Delete{}
		public class RightsStatements{}
		public class Tags{}
		public class Cost{}
	}	
	
	@Feature 
	public class Workflows {}
	
	@Feature
	public class Transformations{}
	
	@Feature
	public class GeneralFeatures{
		public class Inherit{}
		public class Dashboard{}
		public class Project{}
		public class AssetSpecification {}
		public class Collections{}
		public class Icons{}
		public class CompositeLinks{}
		public class RagStatus{}
		public class Derive{}
		public class Series{}
	}
	
	@Feature
	public class Permissions{
		public class CancelEditing{}
		public class Project{}
		public class Asset{}
		public class Folders{}
		
	}
}