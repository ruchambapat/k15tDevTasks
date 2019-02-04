package com.k15t.pat.registration;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.StringWriter;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationControllerTest {

    @Autowired
    private static final VelocityEngine velocityEngine = new VelocityEngine();
    private static final VelocityContext vc =  new VelocityContext();
    private static final StringWriter sw = new StringWriter();

    @Test
    public void isTemplateLoded() {

        //Arrange
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.init();
        Template template = velocityEngine.getTemplate("templates/testTemplate.vm");

        //Act
        vc.put("test", "Hello");
        template.merge(vc, sw);
        System.out.println(sw.toString());

        //Assert
        assert(sw.toString()).equals("test Hello");
    }
}