package com.main.test.util;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class ResponseUtils {

    public static void updateHeaders(Map<String, String> headers, HttpServletResponse response) {
        headers.forEach(response::setHeader);
    }

    public static Map<String, String> generateHeaders(Header... headers) {
        return Arrays.stream(headers).collect(Collectors.toMap(Header::getKey, Header::getValue));
    }
}
