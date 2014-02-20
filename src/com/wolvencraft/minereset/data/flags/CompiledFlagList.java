/*
 * CompiledFlagList.java
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

package com.wolvencraft.minereset.data.flags;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.wolvencraft.minereset.exceptions.FlagNotFoundException;
import com.wolvencraft.minereset.exceptions.InvalidFlagException;

/**
 * Contains an instantiated list of flags.<br />
 * 
 * Actual implementation includes a simple <code>Map&lt;MineFlag, ToggleableFlag&gt;</code>, with additional methods for ease of access.
 * @author bitWolfy
 *
 */
@SuppressWarnings("rawtypes")
public class CompiledFlagList implements Serializable {
    
    private static final long serialVersionUID = -4815588715126968818L;
    
    Map<MineFlag, ToggleableFlag> flags;
    
    /**
     * Default constructor
     */
    public CompiledFlagList() {
        flags = new HashMap<MineFlag, ToggleableFlag>();
    }
    
    /**
     * De-serializing constructor
     * @param map Serialization map
     */
    public CompiledFlagList(Map<String, Object> map) {
        flags = new HashMap<MineFlag, ToggleableFlag>();
        
        Iterator it = map.values().iterator();
        while(it.hasNext()) {
            Map.Entry value = (Map.Entry) it.next();
            flags.put(MineFlag.valueOf((String) value.getKey()), (ToggleableFlag) value.getValue());
        }
    }
    
    /**
     * Serializing method
     * @return Serialization map
     */
    public Map<String, Object> serialize() {
        Map<String, Object> serializableMap = new HashMap<String, Object>();
        Iterator it = flags.values().iterator();
        while(it.hasNext()) {
            Map.Entry value = (Map.Entry) it.next();
            serializableMap.put(((MineFlag) value.getKey()).name(), value.getValue());
        }
        return serializableMap;
    }
    
    /**
     * Instantiates a ToggleableFlag associated with the specified MineFlag and adds it to the list
     * @param type Flag type
     * @throws InvalidFlagException Thrown if an error occurs while instantiating a ToggleableFlag
     */
    public void put(MineFlag type) throws InvalidFlagException {
        try {
            ToggleableFlag instance = type.getFlag().newInstance();
            flags.put(type, instance);
        } catch (Throwable t) {
            throw new InvalidFlagException("Attempted to add an invalid flag", t);
        }
    }
    
    /**
     * Returns a ToggleableFlag associated with the specified MineFlag
     * @param type MineFlag
     * @return ToggleableFlag
     * @throws FlagNotFoundException Thrown if the specified flag is not present in the list
     */
    public ToggleableFlag get(MineFlag type) throws FlagNotFoundException {
        if(flags.containsKey(type)) return flags.get(type);
        else throw new FlagNotFoundException("Flag not found");
    }
    
    /**
     * Returns a list of all active flags
     * @return Active flags
     */
    public List<ToggleableFlag> getActiveFlags() {
        List<ToggleableFlag> result = new ArrayList<ToggleableFlag>();
        Iterator it = flags.values().iterator();
        while(it.hasNext()) {
            ToggleableFlag next = (ToggleableFlag) it.next();
            if(next.isEnabled()) result.add(next);
        }
        return result;
    }
    
}
