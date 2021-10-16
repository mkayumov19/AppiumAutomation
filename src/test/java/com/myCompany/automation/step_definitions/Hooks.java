package com.myCompany.automation.step_definitions;

import com.myCompany.automation.utils.Driver;
import io.cucumber.java.After;

public class Hooks {

    @After
    public void tearDown() {
        Driver.closeDriver();
    }
}
