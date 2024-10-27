package uk.co.leoaureum.testdriver.utils;

import gg.jte.CodeResolver;
import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.TemplateOutput;
import gg.jte.output.StringOutput;
import gg.jte.resolve.DirectoryCodeResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;
import uk.co.leoaureum.testdriver.core.logging.LogEntry;
import uk.co.leoaureum.testdriver.core.logging.TestdriverLogger;

import java.io.*;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestdriverReporter implements IReporter {
    private static final Map<String, List<LogEntry>> logs = new HashMap<>();
    private static final Logger log = LoggerFactory.getLogger(TestdriverReporter.class);

    public static void addLogger(TestdriverLogger logger) {
        logs.put(logger.getMethod(), logger.getEntries());
    }

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
            TemplateOutput output = new StringOutput();
            templateEngine.render("report.jte", logs, output);

            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("target" + File.separator + "detailed-report.html"));
                writer.write(output.toString());
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
