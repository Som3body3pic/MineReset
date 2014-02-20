/* ZTestFlagPleaseIgnore.java
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

import java.util.Map;

/**
 * Test flag, please ignore
 * @author bitWolfy
 *
 */
public class ZTestFlagPleaseIgnore extends ToggleableFlag<Boolean> {
    
    private static final long serialVersionUID = -4337236461094365265L;
    
    private static final String FLAG_ID = "test_flag_please_ignore";
    private static final boolean DEFAULT_VALUE = true;
    
    public ZTestFlagPleaseIgnore() {
        super(FLAG_ID, DEFAULT_VALUE, false);
    }
    
    public ZTestFlagPleaseIgnore(Map<String, Object> map) {
        super(FLAG_ID, DEFAULT_VALUE, map);
    }

}
