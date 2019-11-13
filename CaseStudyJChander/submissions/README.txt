Github Link: https://github.com/jatinchander/CaseStudyJChander


1. The idea:  Good Vibes
- Social Media Web-Application that focuses on posting positive, happy, inspiring, motivational, feel-good content
      Examples: Picture of a dog, inspirational quote, user written story, etc

2. Type of Application:
      - Social Media

3. Key Functions:
      - Responsive on all devices
      - Login/Signup
      - Ability to upload pictures
      - Ability to type quotes and stories 
      - Ability to like a post
      - Ability to comment

4. Key Feature Decisions:
- This Web-Application would be recommended to anyone that wants to view/post feel-good content (ideally frequently)

5. Challenges:
      - Being able to store pictures in database
      - Ensuring content fits overall theme of the application

6. Technical Understanding:
      - Models: User, Admin, Posts, Comments, Likes
      - CRUD functionality
      - Deployed on Tomcat Server
      - Pages: Homepage, Login, Signup, About, Contact, Posted Content

7. User Roles:
	Guest User: 
	- User will go to the site, and see a static homepage
	- On the homepage, there will be a button to see posted content
      - Users can only post/comment on the content if they’re logged in (redirect to login/register page)

Register:
      - User will be asked to enter first name, last name, username, password and email to registration form.
      - After registration is complete, redirect to homepage

Login:
      - User will be asked to enter username and password to login form
      - If login is successful, redirect to posted content
      - If login failed, stay on login page

About:
      - User will see static about page

Contact:
      - User will either see just information for contact or can fill out a form

Posted Content:
      - User will see posted content. Only certain options will only appear if the user is logged in.

Admin:
      - Adam sees everything listed above and must be signed in. They also have the added features of being able to remove any post/comments
