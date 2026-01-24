package org.server.services;

import org.Dragon.Dragon;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class DragonsService {
    private static final String SERVICE_NAME = "Lab2JaxRs";
    private final RestTemplate restTemplate;
    private final DiscoveryClient discoveryClient;

    public DragonsService(RestTemplate restTemplate, DiscoveryClient discoveryClient) {
        this.restTemplate = restTemplate;
        this.discoveryClient = discoveryClient;
    }

    private String getServiceUrl() {
        List<ServiceInstance> instances = discoveryClient.getInstances(SERVICE_NAME);
        if (instances == null || instances.isEmpty()) {
            // Fallback to HAProxy if Consul is not available
            return "https://localhost:8443/Lab2JaxRs/api/dragons/";
        }
        ServiceInstance instance = instances.get(0);
        return instance.getUri().toString() + "/api/dragons/";
    }

    public Dragon findDeepestDragon(String order) {
        String url = getServiceUrl() + "?page=1&size=1&sort=d.cave.depth "
                + ("max".equals(order) ? "desc" : "")
                + "&filter=";
        return restTemplate.getForObject(url, Dragon.class);
    }

    public void killDragon(Long id) {
        String url = getServiceUrl() + id.toString();
        restTemplate.delete(url);
    }
}
