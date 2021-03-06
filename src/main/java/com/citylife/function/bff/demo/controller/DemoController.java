package com.citylife.function.bff.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.citylife.common.model.AnyRequestVO;
import com.citylife.common.model.AnyResponseVO;
import com.citylife.common.model.ResultEntity;
import com.citylife.function.bff.demo.action.SayHelloAction;
import com.citylife.function.core.api.feign.IApiClient;
import com.citylife.function.core.boot.template.AbstractTemplateController;
import com.citylife.function.core.boot.template.TemplateService;

@RestController
public class DemoController extends AbstractTemplateController<TemplateService> implements IApiClient {

	@Autowired
	private SayHelloAction sayHelloAction;

	@PostMapping("/{" + VERSION_KEY + "}/sayHello")
	public ResultEntity<AnyResponseVO> sayHello(@RequestBody final AnyRequestVO query,
			@PathVariable(VERSION_KEY) String version, @RequestHeader(HEADER_TOKEN_KEY) final String token) {
		return doAction(sayHelloAction, query, version, token);
	}

}
