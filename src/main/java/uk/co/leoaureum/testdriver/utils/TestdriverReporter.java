package uk.co.leoaureum.testdriver.utils;

import gg.jte.CodeResolver;
import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.TemplateOutput;
import gg.jte.output.FileOutput;
import gg.jte.resolve.DirectoryCodeResolver;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;
import uk.co.leoaureum.testdriver.core.logging.LogEntry;
import uk.co.leoaureum.testdriver.core.logging.LogLevel;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class TestdriverReporter implements IReporter {

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        CodeResolver codeResolver = new DirectoryCodeResolver(Path.of("jte"));
        TemplateEngine templateEngine = TemplateEngine.create(codeResolver, ContentType.Html);
        for (ISuite suite : suites) {
            String suiteName = suite.getName();
            Map<String, ISuiteResult> results = suite.getResults();

            for (ISuiteResult sr : results.values()) {
                ITestContext tc = sr.getTestContext();
                System.out.println("Passed tests for suite '" + suiteName +
                        "' is:" + tc.getPassedTests().getAllResults().size());
                System.out.println("Failed tests for suite '" + suiteName +
                        "' is:" + tc.getFailedTests().getAllResults().size());
                System.out.println("Skipped tests for suite '" + suiteName +
                        "' is:" + tc.getSkippedTests().getAllResults().size());
            }
            try {
                TemplateOutput output = new FileOutput(Path.of("target/detailed-report.html"), Charset.defaultCharset());
                templateEngine.render("report.jte", new LogEntry("testmethod", LogLevel.INFO, "this is a message"), output);
                templateEngine.clearCache();

            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
}
