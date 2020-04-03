package com.shengda.sentinel;

import cn.hutool.json.JSONUtil;
import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlBlockHandler;
import com.alibaba.csp.sentinel.adapter.servlet.callback.WebCallbackManager;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.shengda.base.wrapper.WrapMapper;
import com.shengda.base.wrapper.Wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author takesi
 * @date 2020-03-27
 */
public class SentinelAutoConfigure {

    public SentinelAutoConfigure() {
        WebCallbackManager.setUrlBlockHandler(new CustomUrlBlockHandler());
    }

    /**
     * 限流、熔断统一处理类
     */
    public static class CustomUrlBlockHandler implements UrlBlockHandler {
        @Override
        public void blocked(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws IOException {
            Wrapper<String> result = WrapMapper.error("flow-limiting");
            httpServletResponse.getWriter().print(JSONUtil.toJsonStr(result));
        }
    }

}
