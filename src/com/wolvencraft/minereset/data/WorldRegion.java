/*
 * WorldRegion.java
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

import lombok.AccessLevel;
import lombok.Getter;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

/**
 * Represents a cubic region of a Minecraft world defined by two locations.
 * @author bitWolfy
 *
 */
@Getter(AccessLevel.PUBLIC)
public class WorldRegion implements ConfigurationSerializable {
    
    private World world;
    
    private Location min;
    private Location max;
    
    public WorldRegion(Location one, Location two) {
        world = one.getWorld();
        
        Location[] sortedLoc = sort(one, two);
        min = sortedLoc[0];
        max = sortedLoc[1];
    }
    
    public WorldRegion(Map<String, Object> map) {
        world = Bukkit.getWorld((String) map.get("world"));
        
        Location[] sortedLoc = sort(
                ((LocationSerializable) map.get("min")).toLocation(),
                ((LocationSerializable) map.get("max")).toLocation()
                );
        min = sortedLoc[0];
        max = sortedLoc[1];
    }
    
    @Override
    public Map<String, Object> serialize() {
        @SuppressWarnings("serial")
        Map<String, Object> map = new HashMap<String, Object>() {{
            put("world", world.getName());
            put("min", new LocationSerializable(min));
            put("max", new LocationSerializable(max));
        }};
        return map;
    }
    
    /**
     * Takes up two locations as arguments and sorts them in ascending order
     * @param one First location
     * @param two Second location
     * @return Sorted array
     */
    private static Location[] sort(Location one, Location two) {
        Location[] set = {
                one.clone(),
                two.clone()
        };
        if(one.getBlockX() > two.getBlockX()) {
            set[0].setX(two.getBlockX());
            set[1].setX(one.getBlockX());
        }
        if(one.getBlockY() > two.getBlockY()) {
            set[0].setY(two.getBlockY());
            set[1].setY(one.getBlockY());
        }
        if(one.getBlockZ() > two.getBlockZ()) {
            set[0].setZ(two.getBlockZ());
            set[1].setZ(one.getBlockZ());
        }
        return set;
    }
    
    /**
     * Returns a copy of this WorldRegion
     * @return WorldRegion copy of the world region
     */
    public WorldRegion clone() {
        return new WorldRegion(min, max);
    }
    
}
