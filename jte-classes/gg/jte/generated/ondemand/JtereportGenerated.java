package gg.jte.generated.ondemand;
import uk.co.leoaureum.testdriver.core.logging.LogEntry;
import java.util.List;
import java.util.Map;
@SuppressWarnings("unchecked")
public final class JtereportGenerated {
	public static final String JTE_NAME = "report.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,3,3,3,21,21,21,24,24,24,31,31,32,32,34,34,37,37,37,38,38,38,39,39,39,41,41,43,43,44,44,45,45,49,49,49,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Map<String, List<LogEntry>> logs) {
		jteOutput.writeContent("\n<head>\n    <meta charset=\"utf-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n    <title>Test Report</title>\n    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">\n</head>\n<body>\n    <h1>Detailed Report</h1>\n    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz\" crossorigin=\"anonymous\"></script>\n    <h2>In this report:</h2>\n    <ul>\n        <li>a test</li>\n        <li>another test</li>\n    </ul>\n    <h2>Class1.test1:</h2>\n    <table class=\"table\">\n        ");
		for (String method : logs.keySet()) {
			jteOutput.writeContent("\n            <thead>\n                <tr>\n                    <th scope=\"col\">");
			jteOutput.setContext("th", null);
			jteOutput.writeUserContent(method);
			jteOutput.writeContent("</th>\n                    <th scope=\"col\">Time</th>\n                    <th scope=\"col\">LogLevel</th>\n                    <th scope=\"col\">Message</th>\n                </tr>\n            </thead>\n            <tbody>\n            ");
			for (LogEntry entry : logs.get(method)) {
				jteOutput.writeContent("\n                ");
				if (!entry.getLogLevel().equals("INFO")) {
					jteOutput.writeContent("\n                    <div class=\"text-danger\">\n                ");
				}
				jteOutput.writeContent("\n                <tr>\n                    <td></td>\n                    <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(entry.getTimeInMillis());
				jteOutput.writeContent("</td>\n                    <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(entry.getLogLevel());
				jteOutput.writeContent("</td>\n                    <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(entry.getMessage());
				jteOutput.writeContent("</td>\n                </tr>\n                ");
				if (entry.getLogLevel().equals("INFO")) {
					jteOutput.writeContent("\n                        </div>\n                ");
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
