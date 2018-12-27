package com.citylife.function.bff.demo.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.citylife.common.model.AnyRequest;
import com.citylife.common.model.AnyResponse;
import com.citylife.common.model.ResultEntity;
import com.citylife.function.api.demo.client.IUserClient;
import com.citylife.function.api.demo.client.entity.User;
import com.citylife.function.core.api.feign.ApiClientResultUtils;
import com.citylife.function.core.boot.template.context.IActionContext;

@Component
public class SayHelloAction extends AbstractFunctionAction<AnyRequest, AnyResponse> {

  @Autowired
  private IUserClient productClient;

  @Override
  public ResultEntity<AnyResponse> execute(IActionContext<AnyRequest> context) {
    ResultEntity<User> result = productClient.getUser(Long.parseLong(context.getParameter().get("userId")), context.getVersion(), context.getToken());
    ApiClientResultUtils.validate(result);
    return ResultEntity.ok(
        AnyResponse.build().put("userInfo", result.getValue()));
  }
}
