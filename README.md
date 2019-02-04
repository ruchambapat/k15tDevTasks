# Full-Stack Developer Sample Project

Assignment Implementation notes:

##The classes implemented are:
1. RegistrationController: This class gets the data from registration velocity template and shows the data entered by user in Form velocity template.
2. RegistrationResource: This class gets the value entered by user in registration form and saves them in memory. The save values are then put into the Form template.
3. AddressSplit: This class splits the address input entered by user into housenumber, street, postcode, city and country for future use.
4. RegistrationForm: This class has get and set methods for user inputs.

##Velocity templates:
1. registration.vm: This template has the html file for registration.
2. Form.vm: This template is to show data entered by user after successful submitting and saving data in memory.
3. error.vm: This template is to show if the registration fails.

##Other Notes:
1. The user is asked to fill the address in requested format, which helps us to save in the format mentioned above. Regular expression is used in registration html
to validate these fields.
2. For this assignment, the registration form fields values are only saved in memory objects. These values in the objects can be further saved into any database
for future use.