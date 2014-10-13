package a.tools.alfresco.constants;

/**
 * 
 * Labels for properties on the Document View page
 * 
 */
public enum PropertiesLabel {
    
	Proj_Name("Project Name:"),
    Isbn("ISBN:"),
    Alternative_ID("Alternative ID:"),
    Alternative_Identifier_Type("Alternative Identifier Type:"),
    Working_Title("Working Title:"),
    Title("Title:"),
    Status("Status:"),
    Product_Description("Product Description:"),
    Project_Type("Project Type:"),
    Product_Author("Product Author:"),
    Project_Status("Project Status:"),
    Target_Publication_Date("Target Publication Date:", true),
    Publication_Date("Publication date:", true),
    Campaign_Year("Campaign Year:"),
    Publishing_Group("Publishing Group:"),
    Project_Team("Project Team:"),
    Product_Owner("Product Owner:"),
    Product_Type("Product Type:"),
    Publishing_Mediums("Publishing Mediums:"),
    Target_Territories("Target Territories:"),
    Rights_Requirements("Rights Requirements:"),
    Linked_Locations("Linked Locations:"),
    Name("Name:"), 
	Description("Description:"),
	Mimetype("Mimetype:"),
	Creator("Creator:"),
	Modifier("Modifier:"),
	Review_Count("Review Count:"), 
	Modified_Date("Modified Date:"), 
	Subject_Classification("Subject Classification:"),
	Derived_From("Derived from:"),
	Derived_Descanedants("Derived descendants:"), 
	Rendition_From("Rendition from:"),
	Renditions("Renditions:"), 
	Inactive_Project_Team("Inactive Project Team:"),
	Language("Language:"),
	Series_Code("Series Code:"),
	Responsible_Editor("Responsible Editor:");
    

    private final String labelText;
    private final boolean isDate;
	
    private PropertiesLabel(final String labelText) {
        this(labelText, false);
    }
    

    private PropertiesLabel(final String labelText, boolean isDate) {
        this.labelText = labelText;
        this.isDate = isDate;
    }
    
   

    /**
     * Get the label text for this field
     * 
     * @return the label text for this field
     */
    public String getLabelText() {
        return labelText;
    }
    
    /**
     * @return true if the field is supposed to contain a date value
     */
    public boolean isDate() {
        return isDate;
    }
}
