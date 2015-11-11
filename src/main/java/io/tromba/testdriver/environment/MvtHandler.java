package io.tromba.testdriver.environment;

import org.openqa.selenium.WebDriver;

import java.util.List;

/**
 * Interface for dealing with multi-variate tests.
 */
public interface MvtHandler {

    List<String> getMvts();

    void setMvts(List<String> mvts);

    void addMvts(List<String> mvts, WebDriver driver);
}
