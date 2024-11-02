package gg.jte.generated.ondemand;
import uk.co.leoaureum.testdriver.core.logging.LogEntry;
import uk.co.leoaureum.testdriver.core.logging.LogLevel;
import uk.co.leoaureum.testdriver.core.logging.TestdriverResults;
@SuppressWarnings("unchecked")
public final class JtereportGenerated {
	public static final String JTE_NAME = "report.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,3,3,3,20,20,20,22,22,22,22,22,22,22,23,23,25,25,27,27,29,29,32,32,33,33,34,34,34,34,34,34,34,34,34,35,35,36,36,36,36,36,36,36,36,36,37,37,39,39,39,49,49,50,50,54,54,54,59,59,59,64,64,64,64,64,64,64,64,64,65,65,65,65,65,65,65,65,65,70,70,72,72,72,73,73,73,76,76,77,77,82,82,85,85,85,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, TestdriverResults results) {
		jteOutput.writeContent("\n<head>\n    <meta charset=\"utf-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n    <title>Test Report</title>\n    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\n          integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">\n</head>\n<body>\n<div class=\"mx-auto\">\n    <h1>Detailed Report</h1>\n    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\"\n            integrity=\"sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz\"\n            crossorigin=\"anonymous\"></script>\n    <h2>In this report:</h2>\n    <ul>\n        ");
		for (String method : results.getMethods()) {
			jteOutput.writeContent("\n            <li>\n                <a href=\"#");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(method);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\">");
			jteOutput.setContext("a", null);
			jteOutput.writeUserContent(method);
			jteOutput.writeContent("</a>\n                ");
			if (results.isFailed(method)) {
				jteOutput.writeContent("\n                    <em class=\"text-danger\">✕</em>\n                ");
			} else {
				jteOutput.writeContent("\n                    <em class=\"text-success\">✓</em>\n                ");
			}
			jteOutput.writeContent("\n            </li>\n        ");
		}
		jteOutput.writeContent("\n    </ul>\n\n    ");
		for (String method : results.getMethods()) {
			jteOutput.writeContent("\n        ");
			if (results.isFailed(method)) {
				jteOutput.writeContent("\n            <div class=\"bg-danger\"");
				var __jte_html_attribute_0 = method;
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" id=\"");
					jteOutput.setContext("div", "id");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("div", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">\n        ");
			} else {
				jteOutput.writeContent("\n            <div class=\"bg-success\"");
				var __jte_html_attribute_1 = method;
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
					jteOutput.writeContent(" id=\"");
					jteOutput.setContext("div", "id");
					jteOutput.writeUserContent(__jte_html_attribute_1);
					jteOutput.setContext("div", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">\n        ");
			}
			jteOutput.writeContent("\n\n        <h2>");
			jteOutput.setContext("h2", null);
			jteOutput.writeUserContent(method);
			jteOutput.writeContent("</h2>\n        <table class=\"table\">\n            <thead>\n            <tr>\n                <th scope=\"col\">Time</th>\n                <th scope=\"col\">Message</th>\n                <th scope=\"col\">Screenshot</th>\n            </tr>\n            </thead>\n            <tbody>\n            ");
			for (LogEntry entry : results.getEntries(method)) {
				jteOutput.writeContent("\n                ");
				if (entry.getLogLevel().equals(LogLevel.ASSERTION) && results.isFailed(method)) {
					jteOutput.writeContent("\n                    <tr>\n                        <td>\n                            <div class=\"p-3 mb-2 bg-danger text-white\">\n                                ");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(entry.getFormattedTime());
					jteOutput.writeContent("\n                            </div>\n                        </td>\n                        <td>\n                            <div class=\"p-3 mb-2 bg-danger text-white\">\n                                ");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(entry.getMessage());
					jteOutput.writeContent("\n                            </div>\n                        </td>\n                        <td>\n                            <div class=\"p-3 mb-2 bg-danger text-white\">\n                                <a");
					var __jte_html_attribute_2 = entry.getFilename();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
						jteOutput.writeContent(" href=\"");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(__jte_html_attribute_2);
						jteOutput.setContext("a", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(">\n                                    <img width=\"300\" height=\"200\"");
					var __jte_html_attribute_3 = entry.getFilename();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_3)) {
						jteOutput.writeContent(" src=\"");
						jteOutput.setContext("img", "src");
						jteOutput.writeUserContent(__jte_html_attribute_3);
						jteOutput.setContext("img", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent("/>\n                                </a>\n                            </div>\n                        </td>\n                    </tr>\n                ");
				} else {
					jteOutput.writeContent("\n                    <tr>\n                        <td>");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(entry.getFormattedTime());
					jteOutput.writeContent("</td>\n                        <td>");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(entry.getMessage());
					jteOutput.writeContent("</td>\n                        <td></td>\n                    </tr>\n                ");
				}
				jteOutput.writeContent("\n            ");
			}
			jteOutput.writeContent("\n            </tbody>\n        </table>\n        </div>\n        </div>\n    ");
		}
		jteOutput.writeContent("\n</div>\n</body>\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		TestdriverResults results = (TestdriverResults)params.get("results");
		render(jteOutput, jteHtmlInterceptor, results);
	}
}
