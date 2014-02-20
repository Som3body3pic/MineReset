/*
 * MineFlag.java
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

import lombok.AccessLevel;
import lombok.Getter;

import com.wolvencraft.minereset.exceptions.InvalidFlagException;
import com.wolvencraft.unity.exceptions.ExceptionHandler;

@SuppressWarnings("rawtypes")
public enum MineFlag {
    
    TestFlagPleaseIgnore(ZTestFlagPleaseIgnore.class),
    ;
    
    @Getter(AccessLevel.PUBLIC) private Class<? extends ToggleableFlag> flag;
    
    MineFlag(Class<? extends ToggleableFlag> flag) {
        this.flag = flag;
    }
    
    /**
     * Compiles and returns a list of flags
     * @return List of flags
     */
    public static CompiledFlagList getStockFlags() {
        CompiledFlagList flags = new CompiledFlagList();
        for(MineFlag f : MineFlag.values()) {
            try { flags.put(f); }
            catch (InvalidFlagException e) { ExceptionHandler.handle(e); }
        }
        return flags;
    }
    
}
