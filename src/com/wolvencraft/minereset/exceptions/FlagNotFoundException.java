/*
 * FlagNotFoundException.java
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

package com.wolvencraft.minereset.exceptions;

public class FlagNotFoundException extends Exception {
    
    private static final long serialVersionUID = 2055920078519574693L;

    public FlagNotFoundException(String message) {
        super(message);
    }
    
    public FlagNotFoundException(String message, Throwable t) {
        super(message, t);
    }
    
    public FlagNotFoundException(Throwable t) {
        super(t);
    }
    
}
