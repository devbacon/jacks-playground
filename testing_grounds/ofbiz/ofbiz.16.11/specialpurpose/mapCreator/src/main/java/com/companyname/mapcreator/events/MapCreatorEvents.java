package com.companyname.mapcreator.events;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ofbiz.base.util.Debug;
import org.apache.ofbiz.base.util.UtilMisc;
import org.apache.ofbiz.base.util.UtilValidate;
import org.apache.ofbiz.entity.Delegator;
import org.apache.ofbiz.entity.GenericValue;
import org.apache.ofbiz.entity.GenericEntityException;
import org.apache.ofbiz.service.GenericServiceException;
import org.apache.ofbiz.service.LocalDispatcher;

public class MapCreatorEvents {
    public static final String module = MapCreatorEvents.class.getName();
 
    public static String createGameMap(HttpServletRequest request, HttpServletResponse response) {
        Delegator delegator = (Delegator) request.getAttribute("delegator");
        LocalDispatcher dispatcher = (LocalDispatcher) request.getAttribute("dispatcher");
        GenericValue userLogin = (GenericValue) request.getSession().getAttribute("userLogin");

        String mapId = delegator.getNextSeqId("GameMap");
        String name = request.getParameter("name");
        String height = request.getParameter("height");
        String width = request.getParameter("width");
        Integer heightInt = Integer.parseInt(height);
        Integer widthInt = Integer.parseInt(width);
 
        if (UtilValidate.isEmpty(name) || UtilValidate.isEmpty(height) || UtilValidate.isEmpty(width)) {
            String errMsg = "Name, Height, and Width are required fields on the form and can't be empty.";
            request.setAttribute("_ERROR_MESSAGE_", errMsg);
            return "error";
        }
 
        try {
            Debug.logInfo("======= Creating GameMap record: mapId=" + mapId + " =========", module);
            GenericValue newGameMap = delegator.makeValue("GameMap", UtilMisc.toMap("mapId", mapId, "name", name, "height", heightInt, "width", widthInt));
            newGameMap.create();
        } catch (GenericEntityException e) {
            String errMsg = "Unable to create new records in GameMap entity: " + e.toString();
            request.setAttribute("_ERROR_MESSAGE_", errMsg);
            return "error";
        }

        request.setAttribute("_EVENT_MESSAGE_", "Game Map created successfully.");
        return "success";
    }
}