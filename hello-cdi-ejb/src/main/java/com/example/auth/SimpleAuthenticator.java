package com.example.auth;

import javax.inject.Inject;

import org.picketlink.annotations.PicketLink;
import org.picketlink.authentication.BaseAuthenticator;
import org.picketlink.credential.DefaultLoginCredentials;
import org.picketlink.idm.model.basic.User;

/**
 * <a href=
 * "http://docs.jboss.org/picketlink/2/latest/reference/html/sect-The_Authentication_Process.html#A_Basic_Authenticator"
 * >参考</a>
 */
@PicketLink
public class SimpleAuthenticator extends BaseAuthenticator {

    @Inject
    DefaultLoginCredentials credentials;

    @Override
    public void authenticate() {
        setStatus(AuthenticationStatus.SUCCESS);
        setAccount(new User("jsmith"));
    }
}
