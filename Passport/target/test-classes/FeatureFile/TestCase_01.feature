Feature: Verify the Matter creation
Scenario: Matter Creation
Given I login as 'admin' with password 'datacert'
Then I prepare item screen 'New Claim Intake Header Item' for the entity 'Matter' in mode 'Add'
Then I provide field 'Is New Incident' with value 'Yes'
Then I verify field 'Appealed' with value 'No'
Then I logout
