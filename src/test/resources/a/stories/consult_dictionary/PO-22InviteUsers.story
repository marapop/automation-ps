Narrative:
In order to didn't be able to Add External users
As a User
I want to be disable the 'Invite Users' capability

Scenario: Add external user section shouldn't be visible for a regular user
Given I log in with user [user] and password [user234] and I open [DanTest] site
When I wait [3] seconds
Then the user wants to click on 'Invite people'

Scenario: Add external user section should be visible for an administrator user
Given I log in with user [dmocan] and password [asfD%&Ssa&98da^*] and I open [DanTest] site
When the user wants to click on 'Invite people'
Then they should see the Add External Users section