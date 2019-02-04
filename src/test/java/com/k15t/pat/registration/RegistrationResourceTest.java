package com.k15t.pat.registration;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;

public class RegistrationResourceTest {

    RegistrationResource registrationResource = new RegistrationResource();

    @Test
    public void testGetParameter() {

        //Arrange
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addParameter("firstname", "someFirstname");
        request.addParameter("lastname", "someLastname");
        request.addParameter("email", "someEmail");
        request.addParameter("phone", "somePhone");
        request.addParameter("password", "somePassword");
        request.addParameter("address1", "123 street 456");
        request.addParameter("address2", "city, country");

        //Act
        registrationResource.getParameters(request);

        //Assert
        assert(registrationResource.registrationForm.getFirstname().equals("someFirstname"));
    }

}
