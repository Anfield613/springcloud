package com.fill.apps.config.ribbon;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;


@Component
public class CustomRibbonRule extends AbstractLoadBalancerRule {


    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }
    protected Server choose(ILoadBalancer loadBalanced, Object object) {

        if (Objects.isNull(loadBalanced)) {
            return null;
        }

        List<Server> allServerList = loadBalanced.getAllServers();
        List<Server> serverList = loadBalanced.getReachableServers();
        if (CollectionUtils.isEmpty(allServerList) || CollectionUtils.isEmpty(serverList)) {
            return null;
        }
        return serverList.get(0);
    }
}
