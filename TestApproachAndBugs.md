# Test approach
To select the most suitable test strategy, the following factors are considered.:
 - The requirements of the application are unknown.
 - The test plan/design/execution time is strictly limited.

The test was performed with the Heuristic approach and Risk-based approach.
For example: 
 - Using Heuristic approach, the same web component should have the same behaviour on every page it is used.
 - Using Risk based approach, if couple web pages(Lamborghini, Alfa Romeo etc.) of the same web page category (car make page etc.) have been validated, the rest of the pages are not required to be tested.

# Test scope
 - Using Chrome browser version 113.0.5672.64.
 - Using Chrome on Window laptop.
 - Using screen resolution 1920 x 1080.

# Critical Bugs

<b>SUBJECT</b>

On car make page, sorting Votes column returns random votes order.

<b>STEPS TO REPLICATE</b>
1. Goes to https://buggy.justtestit.org/make/c4u1mqnarscc72is00ng
2. Click Votes column header
4. Data in Votes column is not in ascending nor descending order.

<b>EXPECTED BEHAVIOUR</b>
- Given I land on a car make page
- When I click Votes column header
- Then I can see Votes column in ascending order.

-----------------------------------

<b>SUBJECT</b>

On OverallRating page, a logged in user cannot log out.

<b>STEPS TO REPLICATE</b>
1. Goes to https://buggy.justtestit.org/overall
2. Log in with valid credential
3. Click Logout button.
4. User is still in logged in state.

<b>EXPECTED BEHAVIOUR</b>
 - Given I am a logged in user
 - When I land on any pages
    - And log out
 - Then I can log out successfully.

-----------------------------------

<b>SUBJECT</b>

On Car Model page of Alfa Romeo make, Comment authors are not displayed

<b>STEPS TO REPLICATE</b>
1. Goes to https://buggy.justtestit.org/model/c4u1mqnarscc72is00ng%7Cc4u1mqnarscc72is00sg
2. See the comments details table
3. Author column is empty.

<b>EXPECTED BEHAVIOUR</b>
- Given I am a user.
- When I land on a car model page.
- Then I should see comment authors in the comment details table.

-----------------------------------

<b>SUBJECT</b>

On Profile page, unknown error are displayed when trying to save Age field with invalid value.

<b>STEPS TO REPLICATE</b>
1. Goes to https://buggy.justtestit.org/profile
2. Type invalid value such as characters or blanks in Age field.
3. Click Save button
4. "Unknown error" or "Get a candy ;)" error message are displayed.

<b>EXPECTED BEHAVIOUR</b>
- Given I am a logged in user
- When I update my age with invalid value
- Then i should see an informative error message (to help me resolve my action).

-----------------------------------

<b>SUBJECT</b>

On car make page, "Buggy Rating" icon on Navigation bar does not redirect to home page.

<b>STEPS TO REPLICATE</b>
1. Goes to https://buggy.justtestit.org/make/c4u1mqnarscc72is00ng
2. Click "Buggy Rating" icon on Navigation bar
4. Home page does not display.

<b>EXPECTED BEHAVIOUR</b>
- Given I land on a car make page
- When I click "Buggy Rating" icon on Navigation bar
- Then I can see home page (https://buggy.justtestit.org/)

-----------------------------------