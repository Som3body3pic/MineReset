/*
 * Mine.java
 * 
 * MineReset
 * Copyright (C) 2013 bitWolfy and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
*/

package com.wolvencraft.minereset.data;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.configuration.serialization.ConfigurationSerializable;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * Contains mine configuration data
 * @author bitWolfy
 *
 */
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class Mine implements ConfigurationSerializable {
    
    private String id;
    private String name;
    
    private WorldRegion region;
    
    public Mine(WorldRegion region) {
        this.region = region.clone();
    }
    
    public Mine(Map<String, Object> map) {
        id = (String) map.get("id");
        name = (String) map.get("name");
        
        region = (WorldRegion) map.get("region");
    }
    
    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);
        map.put("name", name);
        map.put("region", region);
        return map;
    }
    
}
