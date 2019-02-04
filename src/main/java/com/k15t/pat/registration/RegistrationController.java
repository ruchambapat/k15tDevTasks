package com.k15t.pat.registration;

import lombok.extern.java.Log;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.StringWriter;

/**
 * Controller publishing endpoint to handle form registrations.
 */
@RestController
@Log
public class RegistrationController {

    @Autowired private VelocityEngine velocityEngine;
    final RegistrationResource registrationResource = new RegistrationResource();


    @RequestMapping(method = RequestMethod.GET, value = "/registration.html")
    public String registration() {

        velocityEngine.init();
        Template template = velocityEngine.getTemplate("templates/registration.vm");
        VelocityContext vc = new VelocityContext();
        StringWriter sw = new StringWriter();
        template.merge(vc, sw);
        return sw.toString();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/registration.html")
    @ResponseBody
    public String showResult(final HttpServletRequest request) {
        String result = registrationResource.makeContextTemplateForm(request,
                velocityEngine.getTemplate("templates/form.vm"));
        //log.info("Result template returned");
        return result;
    }
}