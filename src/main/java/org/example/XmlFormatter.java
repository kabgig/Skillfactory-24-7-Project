package org.example;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.*;

public class XmlFormatter extends Formatter {
    @Override
    public String format(LogRecord record) {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<logRecord>\n");
        xmlBuilder.append("\t<level>").append(record.getLevel()).append("</level>\n");
        xmlBuilder.append("\t<timestamp>").append(record.getMillis()).append("</timestamp>\n");
        xmlBuilder.append("\t<logger>").append(record.getLoggerName()).append("</logger>\n");
        xmlBuilder.append("\t<message>").append(escapeXml(record.getMessage())).append("</message>\n");

        Throwable thrown = record.getThrown();
        if (thrown != null) {
            xmlBuilder.append("\t<exception>").append(escapeXml(getStackTraceAsString(thrown))).append("</exception>\n");
        }

        xmlBuilder.append("</logRecord>\n");
        return xmlBuilder.toString();
    }

    private String escapeXml(String str) {
        return str.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&apos;");
    }

    private String getStackTraceAsString(Throwable throwable) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        throwable.printStackTrace(pw);
        return sw.toString();
    }
}

