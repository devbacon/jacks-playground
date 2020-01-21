package com.companyname.gamemap.events;
 
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

public class GameMapEvents {
    public static final String module = GameMapEvents.class.getName();
 
    public static String createGameMap(HttpServletRequest request, HttpServletResponse response) {
        Delegator delegator = (Delegator) request.getAttribute("delegator");
        LocalDispatcher dispatcher = (LocalDispatcher) request.getAttribute("dispatcher");
        GenericValue userLogin = (GenericValue) request.getSession().getAttribute("userLogin");

        String gameMapId = delegator.getNextSeqId("GameMap");
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String heightStr = request.getParameter("height");
        String widthStr = request.getParameter("width");
        Integer heightInt = Integer.parseInt(heightStr);
        Integer widthInt = Integer.parseInt(widthStr);

        if (UtilValidate.isEmpty(name) || UtilValidate.isEmpty(description) || UtilValidate.isEmpty(heightStr) || UtilValidate.isEmpty(widthStr)) {
            String errMsg = "Name, Height, and Width are required fields on the form and can't be empty.";
            request.setAttribute("_ERROR_MESSAGE_", errMsg);
            return "error";
        }
 
        try {
            Debug.logInfo("======= Creating GameMap record: gameMapId=" + gameMapId + " =========", module);
            GenericValue newGameMap = delegator.makeValue("GameMap", UtilMisc.toMap("gameMapId", gameMapId, "name", name, "description", description, "height", heightInt, "width", widthInt));
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