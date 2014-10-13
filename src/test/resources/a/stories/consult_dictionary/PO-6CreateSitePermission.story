Narrative:
In order to create a site
As a User
I want to have the right permissions


Scenario: Only users assigned to both GROUP_ALFRESCO_ADMINISTRATORS and GROUP_IXXUS_STAFF can see the ‘create’ action from within the ‘My Sites’ dashlet on the ‘My Dashboard’
Given I log in with user [admin] and password [admin]
And [user3] is part of [a]
And [user3] is part of [i]
And I log out
And I log in with user [user3] and password [user34]
When I click on 'Create a site' in the User Dashboard screen
Then the pop-up 'Create Site' should appear
And I should be able to create a public site named [siteUNU]
And the site named [siteUNU] is present in MySites

Scenario: The ‘create’ action on the top menu ribbon in Alfresco in the ‘Sites’ drop down shouldn't be visible for regular users 
Given I log in with user [user3] and password [user34]
When I click on the 'Create a site' action in the the 'Sites' menu from Alfresco header
Then I should be able to create a public site named [siteDOI]
And the site named [siteDOI] is present in MySites

Scenario: Only users assigned to both GROUP_ALFRESCO_ADMINISTRATORS and GROUP_IXXUS_STAFF can create public, private or moderated sites
Given I log in with user [admin] and password [admin]
And [user3] is not part of Administrator and Ixxus Staff
And I log out
When I log in with user [user3] and password [user34]
Then I cannot see the 'Create a site' button in the the 'Sites' menu from Alfresco header
