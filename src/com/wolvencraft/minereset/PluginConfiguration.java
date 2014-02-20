/*
 * PluginConfiguration.java
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

package com.wolvencraft.minereset;

import java.util.ArrayList;
import java.util.List;

import com.wolvencraft.unity.UnityConfigurationManager;
import com.wolvencraft.unity.UnityConfigurationManager.ConfigurationNode;
import com.wolvencraft.unity.config.ConfigurationNodeList;

import lombok.AccessLevel;
import lombok.Getter;

/**
 * MineReset configuration
 * @author bitWolfy
 *
 */
public enum PluginConfiguration implements ConfigurationNodeList {
    
    ;
    
    @Getter(AccessLevel.PUBLIC) private String node;
    
    PluginConfiguration(String node) {
        this.node = node;
    }
    
    @Override
    public ConfigurationNode get() {
        return UnityConfigurationManager.get(node);
    }
    
    /**
     * Returns all configuration nodes as a list of strings
     * @return  Configuration nodes
     */
    public static String[] getAllNodes() {
        List<String> result =  new ArrayList<String>();
        for(PluginConfiguration c : PluginConfiguration.values()) result.add(c.node);
        return result.toArray(new String[result.size()]);
    }
    
}
