package com.citylife.function.bff.demo.action;

import com.citylife.common.model.RequestVO;
import com.citylife.common.model.ResponseVO;
import com.citylife.function.core.boot.template.AbstractTemplateAction;

public abstract class AbstractFunctionAction<P  extends RequestVO<?>, R  extends ResponseVO<?>> extends AbstractTemplateAction<P, R> {



}
