package com.companyname.gamemap.services;
import java.util.Map;
 
import org.apache.ofbiz.base.util.Debug;
import org.apache.ofbiz.entity.Delegator;
import org.apache.ofbiz.entity.GenericEntityException;
import org.apache.ofbiz.entity.GenericValue;
import org.apache.ofbiz.service.DispatchContext;
import org.apache.ofbiz.service.ServiceUtil;
 
public class GameMapServices {
 
    public static final String module = GameMapServices.class.getName();
 
    public static Map<String, Object> createGameMap(DispatchContext dctx, Map<String, ? extends Object> context) {
        Map<String, Object> result = ServiceUtil.returnSuccess();
        Delegator delegator = dctx.getDelegator();
        try {
            GenericValue gameMap = delegator.makeValue("GameMap");
            // Auto generating next sequence of gameMapId primary key
            gameMap.setNextSeqId();
            // Setting up all non primary key field values from context map
            gameMap.setNonPKFields(context);
            // Creating record in database for GameMap entity for prepared value
            gameMap = delegator.create(gameMap);
            result.put("gameMapId", gameMap.getString("gameMapId"));
            Debug.log("==========This is my first Java Service implementation in Apache OFBiz. GameMap record created successfully with gameMapId: "+gameMap.getString("gameMapId"));
        } catch (GenericEntityException e) {
            Debug.logError(e, module);
            return ServiceUtil.returnError("Error in creating record in GameMap entity ........" +module);
        }
        return result;
    }
}
