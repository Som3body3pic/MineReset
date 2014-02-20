/*
 * MineReset.java
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

import com.wolvencraft.unity.UnityCommandManager;
import com.wolvencraft.unity.UnityPlugin;
import com.wolvencraft.unity.util.PluginVersion;

/**
 * Main MineReset class
 * @author bitWolfy
 *
 */
public class MineReset extends UnityPlugin {
    
    public static MineReset instance;
    
    @Override
    public void onEnable() {
        super.onEnable();
        
        UnityCommandManager.bindCommand("mine", PluginCommands.values());
    }
    
    @Override
    public void onDisable() {
        
    }
    
    @Override
    public PluginVersion getVersion() {
        return new PluginVersion(1, 0, 0);
    }
    
    /**
     * Returns the static MineReset instance
     * @return MineReset instance
     */
    public static MineReset getInstance() {
        return instance;
    }
    
}
