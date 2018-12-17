package com.citylife.function.bff.demo.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.citylife.function.biz.zz.client.api.IProductClient;
import com.citylife.function.biz.zz.client.entity.Product;
import com.citylife.function.biz.zz.client.entity.SearchRequest;
import com.citylife.function.core.boot.template.bean.AnyRequest;
import com.citylife.function.core.boot.template.bean.AnyResponse;
import com.citylife.function.core.boot.template.bean.ResultEntity;
import com.citylife.function.core.boot.template.context.IActionContext;

@Component
public class SayHelloAction extends AbstractFunctionAction<AnyRequest, AnyResponse> {
  
  @Autowired
  private IProductClient productClient;

  @Override
  public ResultEntity<AnyResponse> execute(IActionContext<AnyRequest> context) {
    
    ResultEntity<List<Product>> result = productClient.selectAll(new SearchRequest() , context.getToken());
    if (result.hasError()) {
      return ResultEntity.failure(result.getRtnCode());
    }
    return ResultEntity.ok(AnyResponse.build().put("title", "hello ".concat(context.getParameter().get("name"))).put("products", result.getValue()));
  }
}
