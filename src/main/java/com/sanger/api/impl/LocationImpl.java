/**
 * Copyright 2017 eiathom
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sanger.api.impl;

import com.sanger.api.labware.location.Location;

/**
 * {@link Location} implementation
 * 
 * @author eiathom
 *
 */
public class LocationImpl implements Location {

    private String name;

    public LocationImpl(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj != null && obj instanceof LocationImpl) {
            final LocationImpl other = (LocationImpl) obj;
            return this.name.equals(other.name);
        }
        return false;
    }

    @Override
    public String toString() {
        return new StringBuilder("LocationImpl [name=").append(name)
                .append("]").toString();
    }

}
