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

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

import com.wolvencraft.minereset.MineReset;
import com.wolvencraft.minereset.data.flags.CompiledFlagList;
import com.wolvencraft.unity.util.Message;
import com.wolvencraft.unity.world.WorldRegion;

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
    
    private WorldRegion resetArea;
    
    private CompiledFlagList flags;
    
    public Mine(WorldRegion region) {
        this.resetArea = region.clone();
    }
    
    public Mine(Map<String, Object> map) {
        id = (String) map.get("id");
        name = (String) map.get("name");
        
        resetArea = (WorldRegion) map.get("region");
    }
    
    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);
        map.put("name", name);
        map.put("region", resetArea);
        return map;
    }
    
    /**
     * Saves the mine data to file.
     * @return <b>true</b> if the save was successful, <b>false</b> if an error occurred
     */
    public boolean saveFile() {
        File mineFile = new File(new File(MineReset.getInstance().getDataFolder(), "data"), id + ".mdata.yml");
        FileConfiguration mineConf =  YamlConfiguration.loadConfiguration(mineFile);
        mineConf.set("mine", this);
        try {
            mineConf.save(mineFile);
        } catch (IOException e) {
            Message.log(Level.SEVERE, "Unable to serialize mine '" + id + "'!");
            e.printStackTrace();
            return false;
        }
        return true;
    }
     
    /**
     * Deletes the mine data file.<br />
     * <b>Warning:</b> invoking this method will not remove the mine from the list of active mines
     * @return <b>true</b> if the deletion was successful, <b>false</b> if an error occurred
     */
    public boolean deleteFile() {
        File mineFolder = new File(MineReset.getInstance().getDataFolder(), "data");
        if(!mineFolder.exists() || !mineFolder.isDirectory()) return false;
         
        File[] mineFiles = mineFolder.listFiles(new FileFilter() {
            public boolean accept(File file) { return file.getName().contains(".mdata.yml"); }
        });
         
        for(File mineFile : mineFiles) {
            if(mineFile.getName().equals(id + ".pmine.yml")) {
                return mineFile.delete();
            }
        }
         
        return false;
    }
    
}
