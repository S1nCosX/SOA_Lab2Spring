package org.server.ejb;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.client.WebTarget;
import org.Dragon.Dragon;
import org.server.ejb.interfaces.DragonsBusinessInterface;
import org.server.ejb.util.ServiceClient;

@Stateless
public class DragonsBusinessBean implements DragonsBusinessInterface {
    private static final String SERVICE_NAME = "Lab2JaxRs";

    @Inject
    private ServiceClient serviceClient;

    @Override
    public Dragon findDeepestDragon(String order) {
        WebTarget target = serviceClient.getTarget();
        String sortOrder = "d.cave.depth " + ("max".equals(order) ? "desc" : "");
        return target.queryParam("page", 1)
                .queryParam("size", 1)
                .queryParam("sort", sortOrder)
                .queryParam("filter", "")
                .request()
                .get(Dragon.class);
    }

    @Override
    public void killDragon(Long id) {
        WebTarget target = serviceClient.getTarget();
        target.path(id.toString()).request().delete();
    }
}
