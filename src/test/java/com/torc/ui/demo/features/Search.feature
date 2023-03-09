@searches @regression
Feature: Scenarios of searches
	This feature validates some scenarios about searching.
	
Scenario: Searching an URL
		Given 	I search "The dev-friendly football API"
		When 	Open the first result
		Then 	Check if the URL is "https://www.football-data.org/" 