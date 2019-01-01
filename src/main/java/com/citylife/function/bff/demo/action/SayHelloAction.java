package com.citylife.function.bff.demo.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.citylife.common.model.AnyRequestVO;
import com.citylife.common.model.AnyResponseData;
import com.citylife.common.model.AnyResponseVO;
import com.citylife.common.model.ResponseVO;
import com.citylife.common.model.ResultEntity;
import com.citylife.common.model.builder.RequestVOBuilder;
import com.citylife.function.api.demo.client.IUserClient;
import com.citylife.function.api.demo.client.entity.User;
import com.citylife.function.core.api.feign.ApiClientResultUtils;
import com.citylife.function.core.boot.template.context.IActionContext;

@Component
public class SayHelloAction extends AbstractFunctionAction<AnyRequestVO, AnyResponseVO> {

  @Autowired
  private IUserClient productClient;

  @Override
  public ResultEntity<AnyResponseVO> execute(IActionContext<AnyRequestVO> context) {
	long userId = Long.parseLong(context.getParameter().getData().get("userId"));
    ResultEntity<ResponseVO<User>> result = productClient.getUser(RequestVOBuilder.build(userId), context.getVersion(), context.getToken());
    ApiClientResultUtils.validate(result);
    AnyResponseData responseData = AnyResponseData.build().put("userInfo", result.getBody().getData());
    return ResultEntity.ok(new AnyResponseVO(responseData));
  }
}
