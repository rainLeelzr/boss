package com.rain.boss.base.controller;

import com.rain.boss.base.entity.RequestLog;
import com.rain.boss.base.mapper.RequestLogMapper;
import com.rain.boss.base.service.RequestLogService;
import com.rain.boss.baseClass.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/boss/base")
public class RequestLogController extends BaseController<RequestLog, RequestLogMapper, RequestLogService> {

}
