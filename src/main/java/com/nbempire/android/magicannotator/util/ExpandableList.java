/*
 * Magic Annotator - The only thing you need to write down whatever you want.
 * Copyright (C) 2013 Nahuel Barrios <barrios.nahuel@gmail.com>.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * ExpandableList.java Created by: Nahuel Barrios: 24/03/2012, 11:00:28.
 */
package com.nbempire.android.magicannotator.util;

import java.util.List;

/**
 * Interface to work with expandable list of items where each item has a label and a list of subitems to show.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public interface ExpandableList extends List<ExpandableGroup> {

}
