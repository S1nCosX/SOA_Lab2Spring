package org.server.services;

import org.Dragon.Dragon;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DragonsService {
    StringBuilder basicUrl = new StringBuilder("https://localhost:8443/Lab2JaxRs/api/dragons/");
    private final RestTemplate restTemplate ;

    public DragonsService() {
        this.restTemplate = new RestTemplate();
    }

    public Dragon findDeepestDragon(String order) {
        return restTemplate.getForObject(
            basicUrl.append("?page=1&size=1&sort=d.cave.depth ")
                    .append(order == "max" ? "desc" : "")
                    .append("&filter=").toString(),
            Dragon.class
        );
    }
    public void killDragon(Long id) {
        restTemplate.delete(basicUrl.append(id.toString()).toString());
    }
}
