package com.tdh.mybatisplus.config;

import io.micrometer.core.lang.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.function.Predicate;

/**
 * @Description:
 * @Author : TYQ
 * @Date: 2020-08-16 11:21
 */
public class WebUtil {

    public static void writeJsonToResponse(HttpServletResponse response, R vo, int status, boolean close) throws IOException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setStatus(status);
        response.getWriter().write(JsonUtil.toJson(vo));
        if (close) {

            response.getWriter().close();
        }
    }

    public static void writeJsonToResponse(HttpServletResponse response, R vo) throws IOException {

        writeJsonToResponse(response, vo, HttpStatus.OK.value(), false);
    }

    public static void writeJsonToResponseClosable(HttpServletResponse response, R vo) throws IOException {

        writeJsonToResponse(response, vo, HttpStatus.OK.value(), true);
    }

//    public static String getIpAddress(HttpServletRequest request){
//        return "";
//    }

    /**
     * 获取ip
     *
     * @return {String}
     */
//    @Nullable
//    public static String getIP() {
//        return Optional.ofNullable(getRequest())
//                .map(WebUtil::getIP)
//                .orElse(null);
//    }

    private static final String[] IP_HEADER_NAMES = new String[]{
            "x-forwarded-for",
            "Proxy-Client-IP",
            "WL-Proxy-Client-IP",
            "HTTP_CLIENT_IP",
            "HTTP_X_FORWARDED_FOR"
    };

    private static final Predicate<String> IP_PREDICATE = (ip) -> !StringUtils.hasText(ip) || "UNKNOWN".equalsIgnoreCase(ip);

    /**
     * 获取ip
     *
     * @param request HttpServletRequest
     * @return {String}
     */
    @Nullable
    public static String getIP(@Nullable HttpServletRequest request) {
        if (request == null) {
            return "";
        }
        String ip = null;
        for (String ipHeader : IP_HEADER_NAMES) {
            ip = request.getHeader(ipHeader);
            if (!IP_PREDICATE.test(ip)) {
                break;
            }
        }
        if (IP_PREDICATE.test(ip)) {
            ip = request.getRemoteAddr();
        }
        return !StringUtils.hasText(ip) ? null : StringUtils.delimitedListToStringArray(ip, ",")[0];
    }


    public static Boolean isLong(String value) {
        try{
            Long.valueOf(value);
            return true;
        } catch (Exception e){
            return false;
        }
    }

}
