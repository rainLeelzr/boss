package com.rain.boss.base.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rain.boss.exception.system.SystemException;
import com.rain.boss.web.Resp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.InvocationTargetException;

@Controller
@RequestMapping("/boss/base")
public class OptionController {

    @RequestMapping(value = "/option/{optName}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Resp getUserById(@PathVariable String optName) throws IllegalAccessException, NoSuchMethodException,
            InvocationTargetException, SystemException, JsonProcessingException {
        Object[] options = com.rain.boss.init.SysOption.get(optName);
        System.out.println(options);

        ObjectMapper mapper = new ObjectMapper();
        String Json = mapper.writeValueAsString(options);
        System.out.println(Json);
        return Resp.success(options);
    }
}
