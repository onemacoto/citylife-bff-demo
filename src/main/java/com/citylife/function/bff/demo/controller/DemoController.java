package com.citylife.function.bff.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.citylife.function.bff.demo.action.SayHelloAction;
import com.citylife.function.bff.demo.service.DemoService;
import com.citylife.function.core.api.feign.IApiClient;
import com.citylife.function.core.boot.template.AbstractTemplateController;
import com.citylife.function.core.boot.template.bean.AnyRequest;
import com.citylife.function.core.boot.template.bean.AnyResponse;
import com.citylife.function.core.boot.template.bean.ResultEntity;

@RestController
public class DemoController extends AbstractTemplateController<DemoService>  {

  @Autowired
  private SayHelloAction sayHelloAction;

  @PostMapping("/sayHello")
  public ResultEntity<AnyResponse> sayHello(@RequestBody(required=false) final AnyRequest request, @RequestHeader(name = IApiClient.HEADER_TOKEN_KEY) final String token) {
    return doAction(sayHelloAction, request, token);
  }

}
