package a.tools.alfresco.datamodels;

import org.apache.commons.lang3.RandomStringUtils;

import a.tools.alfresco.Constants;

/**
 * This content model is used for asset creation. It will generate values when it is called to create a new asset.
 * @author vladvoicu
 *
 */
public class ContentModel {
	public String contentName = Constants.CONTENT_PREFIX + RandomStringUtils.randomAlphabetic(6);
	public String contentTitle = RandomStringUtils.randomAlphabetic(6);
	public String contentDescription = RandomStringUtils.randomAlphabetic(6);
	public String contentBody = RandomStringUtils.randomAlphabetic(6);
	public String supplierName = RandomStringUtils.randomAlphabetic(6);
}
