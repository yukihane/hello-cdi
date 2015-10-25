package com.example.servlet;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.example.bridge.Bridge;

@RunWith(CdiTestRunner.class)
public class BridgeEjbServletTest {

    @Inject
    private Bridge bridge;

    @Test
    public void test() {
        assertEquals("", bridge.getBridgeText());
    }

}
