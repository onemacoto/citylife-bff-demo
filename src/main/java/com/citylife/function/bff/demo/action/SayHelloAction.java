package com.citylife.function.bff.demo.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.citylife.common.model.AnyRequest;
import com.citylife.common.model.AnyResponse;
import com.citylife.common.model.ResultEntity;
import com.citylife.function.api.demo.client.IProductClient;
import com.citylife.function.api.demo.client.entity.GetProductListRequest;
import com.citylife.function.api.demo.client.entity.Product;
import com.citylife.function.core.boot.template.context.IActionContext;

@Component
public class SayHelloAction extends AbstractFunctionAction<AnyRequest, AnyResponse> {
  
  @Autowired
  private IProductClient productClient;

  @Override
  public ResultEntity<AnyResponse> execute(IActionContext<AnyRequest> context) {
    
    ResultEntity<List<Product>> result = productClient.getProductList(new GetProductListRequest() , context.getToken());
    if (result.hasError()) {
      return ResultEntity.failure(result.getRtnCode());
    }
    return ResultEntity.ok(AnyResponse.build().put("title", "hello ".concat(context.getParameter().get("name"))).put("products", result.getValue()));
  }
}
