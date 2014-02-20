/*
 * ToggleableFlag.java
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
import java.util.HashMap;
import java.util.Map;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("unchecked")
@Getter(AccessLevel.PUBLIC)
public abstract class ToggleableFlag<T> implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private final String id;
    private final T defaultValue;
    
    @Setter(AccessLevel.PUBLIC) private boolean enabled;
    @Setter(AccessLevel.PUBLIC) private T value;
    
    /**
     * Default constructor
     * @param id Flag ID
     * @param defaultValue Default flag value
     * @param isEnabledByDefault <b>true</b> if the flag should be enabled by default, <b>false</b> otherwise
     */
    public ToggleableFlag(String id, T defaultValue, boolean isEnabledByDefault) {
        this.id = id;
        this.defaultValue = defaultValue;
        
        this.enabled = isEnabledByDefault;
        this.value = defaultValue;
    }
    
    /**
     * De-serializing constructor
     * @param id Flag ID
     * @param defaultValue Default flag value
     * @param map Serialization map
     */
    public ToggleableFlag(String id, T defaultValue, Map<String, Object> map) {
        this.id = id;
        this.defaultValue = defaultValue;
        
        enabled = (boolean) map.get("enabled");
        value = (T) map.get("value");
    }

    /**
     * Serializing method
     * @return Serialization map
     */
    @SuppressWarnings("serial")
    public Map<String, Object> serialize() {
        return new HashMap<String, Object>() {{
            put("enabled", enabled);
            put("value", value);
         }};
    }
    
}
