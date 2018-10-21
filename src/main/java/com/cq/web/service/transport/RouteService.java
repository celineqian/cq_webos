package com.cq.web.service.transport;

import com.cq.web.entity.transport.Route;
import com.cq.web.service.BaseService;

/**
 * @author: Celine Q
 * @create: 2018-10-21 17:43
 **/
public interface RouteService extends BaseService<Route,Integer> {

    void saveOrUpdate(Route route);
}
