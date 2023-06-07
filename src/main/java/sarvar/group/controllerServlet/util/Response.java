package sarvar.group.controllerServlet.util;

import sarvar.group.service.util.Result;

import java.io.PrintWriter;

public class Response {

    public static void respond(PrintWriter printWriter, Result result) {
        if (result.isSuccess()) {
            printWriter.write(
                    "<!DOCTYPE html>\n" +
                            "<html lang=\"en\">\n" +
                            "<head>\n" +
                            "    <meta charset=\"UTF-8\">\n" +
                            "    <title>Title</title>\n" +
                            "    <style type=\"text/css\">\n" +
                            "        @import url('//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css');\n" +
                            "\n" +
                            "        .success-msg{\n" +
                            "            margin: 10px 0;\n" +
                            "            padding: 10px;\n" +
                            "            border-radius: 3px 3px 3px 3px;\n" +
                            "        }\n" +
                            "        .success-msg {\n" +
                            "            color: #270;\n" +
                            "            background-color: #DFF2BF;\n" +
                            "        }\n" +
                            "    </style>\n" +
                            "</head>\n" +
                            "<body>\n" +
                            "    <div class=\"success-msg\">\n" +
                            "        <i class=\"fa fa-check\"></i>\n" +
                            result.getMessage() +
                            "    </div>\n" +
                            "</body>\n" +
                            "</html>"
            );
        } else {
            printWriter.write(
                    "<!DOCTYPE html>\n" +
                            "<html lang=\"en\">\n" +
                            "<head>\n" +
                            "    <meta charset=\"UTF-8\">\n" +
                            "    <title>Title</title>\n" +
                            "    <style type=\"text/css\">\n" +
                            "        @import url('//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css');\n" +
                            "\n" +
                            "        .warning-msg {\n" +
                            "            margin: 10px 0;\n" +
                            "            padding: 10px;\n" +
                            "            border-radius: 3px 3px 3px 3px;\n" +
                            "        }\n" +
                            "        .warning-msg {\n" +
                            "            color: #9F6000;\n" +
                            "            background-color: #FEEFB3;\n" +
                            "        }\n" +
                            "    </style>\n" +
                            "</head>\n" +
                            "<body>\n" +
                            "    <div class=\"warning-msg\">\n" +
                            "        <i class=\"fa fa-warning\"></i>\n" +
                            result.getMessage() +
                            "    </div>\n" +
                            "</body>\n" +
                            "</html>"
            );
        }
    }
}
