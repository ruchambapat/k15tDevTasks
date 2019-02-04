package com.k15t.pat.registration;

import lombok.extern.java.Log;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.io.StringWriter;
import java.util.Map;

/**
 * Class to receive and store the data in memory.
 */
@Path("/registration")
@Component
@Log
public class RegistrationResource {

    @Autowired
    private VelocityEngine velocityEngine;

    public RegistrationForm registrationForm = new RegistrationForm();

    public void getParameters(HttpServletRequest request) {
        registrationForm.setFirstname(request.getParameter("firstname"));
        registrationForm.setLastname(request.getParameter("lastname"));
        registrationForm.setAddress1(request.getParameter("address1"));
        registrationForm.setAddress2(request.getParameter("address2"));
        registrationForm.setEmail(request.getParameter("email"));
        registrationForm.setPassword(request.getParameter("password"));
        registrationForm.setPhone(request.getParameter("phone"));

        AddressSplit addressSplit = new AddressSplit();
        Map<String, String> addressParts = addressSplit.partsOfAddress(registrationForm.getAddress1(),
                registrationForm.getAddress2());

        registrationForm.setHouseNumber(addressParts.get("houseNumber"));
        registrationForm.setStreet(addressParts.get("street"));
        registrationForm.setPostcode(addressParts.get("postcode"));
        registrationForm.setCity(addressParts.get("city"));
        registrationForm.setCountry(addressParts.get("country"));
    }

    public Response save() {
        return Response.ok().build();
    }

    public String makeContextTemplateForm(HttpServletRequest request, Template template) {

        getParameters(request);

        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("email", registrationForm.getEmail());
        velocityContext.put("firstname", registrationForm.getFirstname());
        velocityContext.put("lastname", registrationForm.getLastname());
        velocityContext.put("houseNumber", registrationForm.getHouseNumber());
        velocityContext.put("street", registrationForm.getStreet());
        velocityContext.put("postcode", registrationForm.getPostcode());
        velocityContext.put("city", registrationForm.getCity());
        velocityContext.put("country", registrationForm.getCountry());
        velocityContext.put("password", registrationForm.getPassword());
        velocityContext.put("phone", registrationForm.getPhone());
        StringWriter stringWriter = new StringWriter();
        template.merge(velocityContext, stringWriter);
        //log.info("Succesfully entered form information into context.");
        return stringWriter.toString();
    }
}