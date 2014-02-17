/*
 * LocationSerializable.java
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

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

/**
 * Serializable implementation of the Bukkit Location.<br />
 * In addition to coordinates, stores world name, yaw, and pitch.
 * @author bitWolfy
 *
 */
public class LocationSerializable implements ConfigurationSerializable {
    
    private String world;
    
    private double x;
    private double y;
    private double z;
    
    private float yaw;
    private float pitch;
    
    public LocationSerializable(Location location) {
        world = location.getWorld().getName();
        
        x = location.getX();
        y = location.getY();
        z = location.getZ();
        
        yaw = (float) location.getY();
        pitch = location.getPitch();
    }
    
    public LocationSerializable(Map<String, Object> map) {
        world = (String) map.get("world");
        
        x = (double) map.get("x");
        y = (double) map.get("y");
        z = (double) map.get("z");
        
        yaw = (float) map.get("yaw");
        pitch = (float) map.get("pitch");
    }

    @Override
    public Map<String, Object> serialize() {
        @SuppressWarnings("serial")
        Map<String, Object> map = new HashMap<String, Object>() {{
            put("world", world);
            
            put("x", x);
            put("y", y);
            put("z", z);
            
            put("yaw", yaw);
            put("pitch", pitch);
        }};
        return map;
    }
    
    /**
     * Returns a new location based on the data stored in LocationSerializable
     * @return Location
     */
    public Location toLocation() {
        World w = Bukkit.getWorld(world);
        if(w == null) return null;
        
        return new Location(w, x, y, z, yaw, pitch);
    }
    
}
