package com.example.samples;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

import org.picketlink.Identity;
import org.picketlink.Identity.AuthenticationResult;
import org.picketlink.credential.DefaultLoginCredentials;

@Named("myCdiImpl1")
@Dependent
public class MyCdiImpl1 implements MyCdi {

    @Inject
    private Identity identity;

    @Inject
    private DefaultLoginCredentials credentials;

    @Override
    public String hello() {
        credentials.setUserId("user1");
        credentials.setPassword("mypassword");
        AuthenticationResult res = identity.login();
        System.out.println(res);

        return "Hello MyCdiImpl1";
    }

}
