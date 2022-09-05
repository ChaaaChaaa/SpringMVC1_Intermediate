package com.springmvc1.intermediate.basic.request;

import com.springmvc1.intermediate.basic.HelloData;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RequestParamController {
    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userName = request.getParameter("userName");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("userName={},age={}", userName, age);
        response.getWriter().write("ok");
    }

    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("userName") String memberName,
            @RequestParam("age") int memberAge) {
        log.info("useName={},age={}", memberName, memberAge);
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String memberName,
            @RequestParam int memberAge) {
        log.info("useName={},age={}", memberName, memberAge);
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(
            String memberName,
            int memberAge) {
        log.info("useName={},age={}", memberName, memberAge);
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String userName,
            @RequestParam(required = false) int age) {
        log.info("userName={}, age={}", userName, age);
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(required = true, defaultValue = "guest") String userName,
            @RequestParam(required = false, defaultValue = "-1") int age) {
        log.info("userName={}, age={}", userName, age);
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(
           @RequestParam Map<String,Object> paramMap) {
        log.info("userName={}, age={}",paramMap.get("userName"),paramMap.get("age"));
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/model-attribut-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData) {
        log.info("userName={}, age={}",helloData.getUserName(),helloData.getAge());
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/model-attribut-v2")
    public String modelAttributeV2(HelloData helloData) {
        log.info("userName={}, age={}",helloData.getUserName(),helloData.getAge());
        return "OK";
    }
}
