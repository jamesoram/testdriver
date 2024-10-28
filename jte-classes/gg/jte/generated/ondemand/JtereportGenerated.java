package gg.jte.generated.ondemand;
import uk.co.leoaureum.testdriver.core.logging.LogEntry;
import uk.co.leoaureum.testdriver.core.logging.LogLevel;
import java.util.List;
import java.util.Map;
@SuppressWarnings("unchecked")
public final class JtereportGenerated {
	public static final String JTE_NAME = "report.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,4,4,4,4,22,22,22,25,25,25,32,32,33,33,37,37,37,42,42,42,47,47,47,52,52,52,52,52,52,52,52,52,56,56,59,59,59,60,60,60,61,61,61,63,63,64,64,65,65,69,69,69,4,4,4,4};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Map<String, List<LogEntry>> logs) {
		jteOutput.writeContent("\n<head>\n    <meta charset=\"utf-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n    <title>Test Report</title>\n    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">\n</head>\n<body>\n    <h1>Detailed Report</h1>\n    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz\" crossorigin=\"anonymous\"></script>\n    <h2>In this report:</h2>\n    <ul>\n        <li>a test</li>\n        <li>another test</li>\n    </ul>\n    <h2>Class1.test1:</h2>\n    <table class=\"table\">\n        ");
		for (String method : logs.keySet()) {
			jteOutput.writeContent("\n            <thead>\n                <tr>\n                    <th scope=\"col\">");
			jteOutput.setContext("th", null);
			jteOutput.writeUserContent(method);
			jteOutput.writeContent("</th>\n                    <th scope=\"col\">Time</th>\n                    <th scope=\"col\">LogLevel</th>\n                    <th scope=\"col\">Message</th>\n                </tr>\n            </thead>\n            <tbody>\n            ");
			for (LogEntry entry : logs.get(method)) {
				jteOutput.writeContent("\n                ");
				if (!entry.getLogLevel().equals(LogLevel.INFO)) {
					jteOutput.writeContent("\n                    <tr>\n                        <td>\n                            <div class=\"p-3 mb-2 bg-danger text-white\">\n                                ");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(entry.getFormattedTime());
					jteOutput.writeContent("\n                            </div>\n                        </td>\n                        <td>\n                            <div class=\"p-3 mb-2 bg-danger text-white\">\n                                ");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(entry.getLogLevel());
					jteOutput.writeContent("\n                            </div>\n                        </td>\n                        <td>\n                            <div class=\"p-3 mb-2 bg-danger text-white\">\n                                ");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(entry.getMessage());
					jteOutput.writeContent("\n                            </div>\n                        </td>\n                        <td>\n                            <div class=\"p-3 mb-2 bg-danger text-white\">\n                                <img");
					var __jte_html_attribute_0 = entry.getFilename();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
						jteOutput.writeContent(" src=\"");
						jteOutput.setContext("img", "src");
						jteOutput.writeUserContent(__jte_html_attribute_0);
						jteOutput.setContext("img", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(" />\n                            </div>\n                        </td>\n                    </tr>\n                ");
				} else {
					jteOutput.writeContent("\n                    <tr>\n                        <td></td>\n                        <td>");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(entry.getFormattedTime());
					jteOutput.writeContent("</td>\n                        <td>");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(entry.getLogLevel());
					jteOutput.writeContent("</td>\n                        <td>");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(entry.getMessage());
					jteOutput.writeContent("</td>\n                    </tr>\n                ");
				}
				jteOutput.writeContent("\n            ");
			}
			jteOutput.writeContent("\n        ");
		}
		jteOutput.writeContent("\n        </tbody>\n    </table>\n</body>\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Map<String, List<LogEntry>> logs = (Map<String, List<LogEntry>>)params.get("logs");
		render(jteOutput, jteHtmlInterceptor, logs);
	}
}
