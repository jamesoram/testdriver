@import uk.co.leoaureum.testdriver.core.logging.LogEntry
@import uk.co.leoaureum.testdriver.core.logging.LogLevel
@import uk.co.leoaureum.testdriver.core.logging.TestdriverResults
@param TestdriverResults results

<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Test Report</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <div class="container-fluid mt-2">
        <div class="mx-auto">
            <h1>Detailed Report</h1>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
                    crossorigin="anonymous"></script>
            <h2>In this report:</h2>
            <ul>
                @for (String method : results.getMethods())
                    <li>
                        <a href="#${method}">${method}</a>
                        @if (results.isFailed(method))
                            <em class="text-danger">✕</em>
                        @else
                            <em class="text-success">✓</em>
                        @endif
                    </li>
                @endfor
            </ul>

            @for (String method : results.getMethods())
                @if (results.isFailed(method))
                    <div class="bg-danger" id="${method}">
                @else
                    <div class="bg-success" id="${method}">
                @endif

                <h2>${method}</h2>
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Time</th>
                        <th scope="col">Message</th>
                        <th scope="col">Screenshot</th>
                    </tr>
                    </thead>
                    <tbody>
                    @for (LogEntry entry : results.getEntries(method))
                        @if (entry.getLogLevel().equals(LogLevel.ASSERTION) && results.isFailed(method))
                            <tr>
                                <td>
                                    <div class="p-3 mb-2 bg-danger text-white">
                                        ${entry.getFormattedTime()}
                                    </div>
                                </td>
                                <td>
                                    <div class="p-3 mb-2 bg-danger text-white">
                                        ${entry.getMessage()}
                                    </div>
                                </td>
                                <td>
                                    <div class="p-3 mb-2 bg-danger text-white">
                                        <a href="${entry.getFilename()}">
                                            <img width="300" height="200" src="${entry.getFilename()}"/>
                                        </a>
                                    </div>
                                </td>
                            </tr>
                        @elseif(entry.getLogLevel().equals(LogLevel.USER))
                            <tr>
                                <td class="p-3 mb-2 bg-primary text-white">${entry.getFormattedTime()}</td>
                                <td class="p-3 mb-2 bg-primary text-white">${entry.getMessage()}</td>
                                <td class="p-3 mb-2 bg-primary text-white"></td>
                            </tr>
                        @else
                            <tr>
                                <td class="p-3 mb-2 bg-secondary text-white">${entry.getFormattedTime()}</td>
                                <td class="p-3 mb-2 bg-secondary text-white">${entry.getMessage()}</td>
                                <td class="p-3 mb-2 bg-secondary text-white"></td>
                            </tr>
                        @endif
                    @endfor
                    </tbody>
                </table>
                </div>
                </div>
            @endfor
        </div>
    </div>
  </body>
</html>
