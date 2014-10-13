package a.tools.alfresco;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import a.tools.alfresco.Constants;

public class AlfrescoHttpHelper {

	private ApacheHttpHelper http = new ApacheHttpHelper();

	/**
	 * @param args
	 *            - 0 -> path, 1 -> title, 2 -> description
	 * @throws Exception
	 */
	public String createContainer(String name, String type, String site, String... args) throws Exception {
		JSONObject payload = new JSONObject();
		payload.put("name", name);
		payload.put("type", type);
		payload.put("title", "");
		String postUrl = Constants.CREATE_FOLDER_API_URL + site + Constants.DOCUMENT_LIBRARY_API;
		if (args != null && args.length > 0) {
			postUrl += args[0];
			if (args.length > 1) {
				payload.put("title", args[1]);
				if (args.length > 2) {
					payload.put("description", args[2]);
				}
			}
		}
		JSONObject response = new JSONObject(http.sendPost(postUrl, payload.toString()));
		return response.getString("nodeRef");
	}

	/**
	 * @param nodeRef
	 *            node to manage
	 * @param toAdd
	 *            list of aspects to add
	 * @param toRemove
	 *            lists of aspects to remove
	 * @throws Exception
	 */
	private boolean manageAspects(String nodeRef, List<String> toAdd, List<String> toRemove) throws Exception {
		JSONObject payload = new JSONObject();
		if (toAdd != null) {
			payload.put("added", new JSONArray(toAdd));
		}
		if (toRemove != null) {
			payload.put("removed", new JSONArray(toRemove));
		}
		String response = http.sendPost(Constants.MANAGE_ASPECTS_API_URL + nodeRef.replaceAll("://", "/"), payload.toString());
		JSONObject result = new JSONObject(response);
		return result.getBoolean("overallSuccess");
	}

	/**
	 * @param nodeRef
	 * @param aspectsToAdd
	 * @return
	 * @throws Exception
	 */
	public boolean addAspects(String nodeRef, List<String> aspectsToAdd) throws Exception {
		return manageAspects(nodeRef, aspectsToAdd, null);
	}

	/**
	 * @param nodeRef
	 * @param aspectsToRemove
	 * @return
	 * @throws Exception
	 */
	public boolean removeAspects(String nodeRef, List<String> aspectsToRemove) throws Exception {
		return manageAspects(nodeRef, null, aspectsToRemove);
	}

	// DELETE site
	public void deleteSite(String siteShortname) throws Exception {
		String link = Constants.ALFRESCO_SERVICE_URL + "/api/sites/" + siteShortname;
		http.sendDelete(link);
	}

	/**
	 * CREATE site
	 */
	public void createSite(String shortName, String sitePreset, String title, String description, String visibility) throws Exception {

		String link = Constants.ALFRESCO_SERVICE_URL + "/api/sites";

		// create JSON request body
		JSONObject json = new JSONObject();
		json.put("shortName", shortName);
		json.put("sitePreset", sitePreset);
		json.put("title", title);
		json.put("description", description);
		json.put("visibility", visibility);

		http.sendPost(link, json.toString());

		//http.sendGet(Constants.SERVER_URL + "/share/page/site/" + shortName + "/documentlibrary");
		//http.sendGet(Constants.ALFRESCO_SERVICE_URL + "/slingshot/doclib/treenode/site/" + shortName + "/documentLibrary");
	}

	/**
	 * Upload file
	 * 
	 * @param fileName
	 * @param site
	 * @param path
	 *            path in site
	 * @throws Exception
	 */
	public String uploadFile(String site, String fileName, String path) throws Exception {
		File f = new File(Constants.TESTDATA_FILES_PATH + fileName);

		JSONObject response = new JSONObject(http.uploadDocument(Constants.UPLOAD_API_URL, f, site, Constants.DOCUMENT_LIBRARY_CONTAINER, path));
		return response.getString("nodeRef");
	}

	public String uploadFileFromCustomFolder(String site, String fileName, String path) throws Exception {
		File f = new File(Constants.TESTDATA_FILES_BASE_PATH + fileName);

		JSONObject response = new JSONObject(http.uploadDocument(Constants.UPLOAD_API_URL, f, site, Constants.DOCUMENT_LIBRARY_CONTAINER, path));
		return response.getString("nodeRef");
	}

	/**
	 * Gets nodeRef
	 * e.g. http://ix-iclbigtest1.ixxus.co.uk:8080/alfresco/service/slingshot/doclib/treenode/site/test1/documentlibrary/Book/Folder1
	 * @throws Exception 
	 * @throws JSONException 
	 */
	public String getNodeRef(String site, String path) throws JSONException, Exception {
		String url = Constants.ALFRESCO_SERVICE_URL + "/slingshot/doclib/treenode/site/" + site + "/documentlibrary" + path;
		System.out.println("Get nodeRef: " + url);
		JSONObject response = new JSONObject(http.sendGet(url));
		return (response.getJSONObject("parent")).getString("nodeRef");
	}


	/**
	 * Delete nodeRef
	 * e.g. http://ix-iclbigtest1.ixxus.co.uk:8080/alfresco/service/slingshot/doclib/action/files?alf_method=delete
	 * @throws Exception 
	 */
	public void deleteNodeRef(String nodeRef) throws Exception {
		String url = Constants.ALFRESCO_SERVICE_URL + "/slingshot/doclib/action/files?alf_method=delete";
		System.out.println("Delete nodeRef: " + nodeRef);
		// create JSON request body
		JSONObject json = new JSONObject();
		List<String> nodes = new ArrayList<String>();
		nodes.add(nodeRef);
		json.put("nodeRefs", new JSONArray(nodes));
		System.out.println("Delete nodeRef JSON: " + json.toString());
		http.sendPost(url, json.toString());
	}

	/**
	 * Gets children
	 * e.g. http://ix-iclbigtest1.ixxus.co.uk:8080/alfresco/service/api/node/workspace/SpacesStore/984b4a03-ef1e-4354-9534-ff39601b4df6/children
	 * @throws Exception 
	 * @throws JSONException 
	 */
	public String getChildren(String site, String path) throws JSONException, Exception {
		String nodeRef = getNodeRef(site, path).replaceAll("://", "/");
		String url = Constants.ALFRESCO_SERVICE_URL + "/api/node/" + nodeRef + "/children";
		System.out.println("Get children: " + url);
		String response = http.sendGet(url);
		return response.toString();
	}


	/**
	 * @param title
	 * @param content
	 * @param nodeRef
	 * @throws Exception
	 */
	public void createComment(String title, String content, String storeId) throws Exception {

		String link = Constants.ALFRESCO_SERVICE_URL + "/api/node/" + storeId.replaceAll("://", "/") + "/comments";

		// create JSON request body
		JSONObject json = new JSONObject();
		json.put("title", title);
		json.put("content", content);

		http.sendPost(link, json.toString());
	}

	/**
	 * @param tag
	 * @param storeId
	 * @throws Exception
	 */
	public void createTag(String tag, String storeId) throws Exception {

		String link = Constants.ALFRESCO_SERVICE_URL + "/api/node/" + storeId.replaceAll("://", "/") + "/tags";

		http.sendPost(link, "[ \"" + tag + "\" ]");
	}

	public void createSite(String shortName, String... args) throws Exception {

		String link = Constants.ALFRESCO_SERVICE_URL + "/api/sites";

		// create JSON request body
		JSONObject json = new JSONObject();

		json.put("shortName", shortName.toLowerCase());
		json.put("visibility", "PUBLIC");
		json.put("sitePreset", "site-dashboard");

		if (args != null && args.length > 0) {
			json.put("title", args[0]);
			if (args.length > 1) {
				json.put("description", args[1]);
				if (args.length > 2) {
					json.put("visibility", args[2]);
					if (args.length > 3) {
						json.put("sitePreset", args[3]);
					}
				}
			}
		}
		http.sendPost(link, json.toString());
	}

	public void addNewPerson(String userName, String lastName,
			String firstName, String email, String password) throws Exception {

		String link = Constants.ALFRESCO_SERVICE_URL + "/api/people";

		// create JSON request body
		JSONObject json = new JSONObject();

		json.put("userName", userName);
		json.put("lastName", lastName);
		json.put("firstName", firstName);
		json.put("email", email);
		json.put("password", password);

		http.sendPost(link, json.toString());
	}

	/**
	 * DELETE person
	 * 
	 * @throws Exception
	 * @param userName
	 * */
	public void deleteUser(String userName) throws Exception {
		String link = Constants.ALFRESCO_SERVICE_URL + "/api/people/"
				+ userName;
		http.sendDelete(link);
	}

	public void deleteGroup(String shortName) throws Exception {
		String link = Constants.ALFRESCO_SERVICE_URL + "/api/groups/"
				+ shortName;
		http.sendDelete(link);
	}

	public void deleteWorkflow(String workflowId) throws Exception {
		String link = Constants.ALFRESCO_SERVICE_URL
				+ String.format("api/workflow-instances/%s?forced=true",
						workflowId);
		http.sendDelete(link);
	}

	public void cancelWorkflow(String workflowId) throws Exception {
		String link = Constants.ALFRESCO_SERVICE_URL
				+ String.format("api/workflow-instances/%s?forced=false",
						workflowId);
		http.sendDelete(link);
	}

	public boolean checkIfUserExists(String userName) throws Exception {
		String link = Constants.ALFRESCO_SERVICE_URL + "/api/people/"
				+ userName;
		//http.validateResponseStatusCode = false;
		String response = http.sendGet(link);
		//http.validateResponseStatusCode = true;
		return response.contains("\"enabled\":");
	}

	public boolean checkIfGroupExists(String shortName) throws Exception {
		String link = Constants.ALFRESCO_SERVICE_URL + "/api/groups/"
				+ shortName;
		//http.validateResponseStatusCode = false;
		String response = http.sendGet(link);
		//http.validateResponseStatusCode = true;
		return response.contains("\"shortName\":");
	}

	public boolean checkIfWorkflowExists(String workflowId) throws Exception {
		String link = Constants.ALFRESCO_SERVICE_URL
				+ String.format("api/workflow-instances/%s?includeTasks=true",
						workflowId);
		//http.validateResponseStatusCode = false;
		String response = http.sendGet(link);
		//http.validateResponseStatusCode = true;
		return response.contains("\"shortName\":");
	}

	public boolean checkIfSiteExists(String siteName) throws Exception {
		String link = Constants.ALFRESCO_SERVICE_URL + "/api/sites/"
				+ siteName.toLowerCase();
		//http.validateResponseStatusCode = false;
		String response = http.sendGet(link).toLowerCase();
		//http.validateResponseStatusCode = true;
		boolean exists = response.contains("\"shortname\": \""
				+ siteName.toLowerCase());
		return exists;
	}


}
