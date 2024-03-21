/*
 * Copyright (C) 2024 Whitehole Team
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package whitehole.db;

import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
import whitehole.rendering.BmdRenderer;
import whitehole.rendering.GLRenderer;
import static whitehole.rendering.RendererFactory.createDummyCubeRenderer;
import whitehole.rendering.special.*;
import whitehole.smg.object.AbstractObj;

/**
 *
 * @author Hackio
 */
public final class SpecialRenderers extends GameAndProjectDataHolder {
    public SpecialRenderers()
    {
        super("data/specialrenderers.json", "/specialrenderers.json", true);
    }
    
    public String tryGetAdditiveCacheKey(String objModelName, AbstractObj obj)
    {
        SpecialRenderInfo renderinfo = getSpecialRenderInfo(obj.name);
        if (renderinfo != null)
            switch(renderinfo.rendererType)
            {
                case "PowerStar":
                    return PowerStarRenderer.getAdditiveCacheKey(obj,
                            (Integer)renderinfo.getRenderParamByName("DefaultFrame"));
                case "SuperSpinDriver":
                    return SuperSpinDriverRenderer.getAdditiveCacheKey(obj);
            }
        return "";
    }
    
    public GLRenderer tryGetSpecialRenderer(GLRenderer.RenderInfo info, String objModelName, AbstractObj obj)
    {
        SpecialRenderInfo renderinfo = getSpecialRenderInfo(obj.name);
        GLRenderer result = null;
        if (renderinfo != null)
            switch(renderinfo.rendererType)
            {
                case "PowerStar":
                    result = new PowerStarRenderer(info, objModelName, obj,
                            (Integer)renderinfo.getRenderParamByName("DefaultFrame"),
                            (Boolean)renderinfo.getRenderParamByName("IsGrand"));
                    break;
                case "SuperSpinDriver":
                    result =  new SuperSpinDriverRenderer(info, objModelName, obj);
                    break;
            }
        if (result instanceof BmdRenderer)
            if (!((BmdRenderer)result).isValidBmdModel())
                return null;
        
        return result;
    }
    
    private SpecialRenderInfo getSpecialRenderInfo(String objName)
    {
        SpecialRenderInfo x = getSpecialRenderInfo(objName, projectData);
        if (x == null)
            x = getSpecialRenderInfo(objName, baseGameData);
        return x;
    }
    private SpecialRenderInfo getSpecialRenderInfo(String objName, JSONObject src)
    {
        if (src == null || objName == null)
            return null;
        
        JSONArray root = src.getJSONArray("SpecialRenderers");
        for (int i = 0 ; i < root.length(); i++) {
            JSONObject Current = root.getJSONObject(i);
            String ObjectName = Current.optString("ObjectName", null);
            if (!objName.equals(ObjectName))
                continue;
            
            SpecialRenderInfo info = new SpecialRenderInfo();
            info.objectName = ObjectName;
            info.rendererType = Current.optString("RendererType", null);
            JSONArray rawParameters = Current.optJSONArray("RendererParams");
            if (rawParameters != null && !rawParameters.isEmpty()) {
                if (info.rendererParams == null)
                    info.rendererParams = new HashMap(rawParameters.length());
                
                for (int j = 0 ; j < rawParameters.length(); j++)
                {
                    JSONObject CurrentParam = rawParameters.getJSONObject(j);
                    for(String paramName : CurrentParam.keySet())
                    {
                        if (!info.rendererParams.containsKey(paramName))
                        {
                            if (isSupportedAnimationParam(paramName))
                            {
                                info.rendererParams.put(paramName, new AnimationParam(CurrentParam.getJSONObject(paramName)));
                            }
                            else
                                info.rendererParams.put(paramName, CurrentParam.get(paramName));
                        }
                    }
                }
            }
            return info;
        }
        
        return null;
    }
    
    
    
    private class SpecialRenderInfo
    {
        public String objectName;
        public String rendererType;
        public HashMap<String, Object> rendererParams;
        
        public Object getRenderParamByName(String name)
        {
            return rendererParams.get(name);
        }
    }
    
    private class AnimationParam
    {        
        public final String filename;
        public final Integer frame;
        public final String frameSource;
        
        public AnimationParam(JSONObject obj)
        {
            filename = obj.getString("Filename");
            frame = obj.optInt("Frame", 0);
            frameSource = obj.optString("FrameSource", null);
        }
    }
        
    public static boolean isSupportedAnimationParam(String n)
    {
        switch(n)
        {
            case "BRK":
            case "BTK":
            case "BTP":
            case "BVA":
                return true;
            default:
                return false;
        }
    }
}
