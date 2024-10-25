@import uk.co.leoaureum.testdriver.core.logging.LogEntry
@import java.util.List
@import java.util.Map
@param Map<String, List<LogEntry>> logs

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Test Report</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <h1>Detailed Report</h1>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <h2>In this report:</h2>
    <ul>
        <li>a test</li>
        <li>another test</li>
    </ul>
    <h2>Class1.test1:</h2>
    <table class="table">
        <thead>
            <tr>
                <th scope="col">Time</th>
                <th scope="col">LogLevel</th>
                <th scope="col">Message</th>
            </tr>
        </thead>
        <tbody>
        @for(String method : logs.keySet())
            @for(LogEntry entry : logs.get(method))
                <tr>
                    <td>${method}</td>
                    <td>${entry.getTimeInMillis()}</td>
                    <td>${entry.getLogLevel()}</td>
                    <td>${entry.getMessage()}</td>
                </tr>
            @endfor
        @endfor
        </tbody>
    </table>
</body>
