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
package com.sanger.api.labware.container.sample.tag;

import com.sanger.api.labware.container.sample.Sample;

/**
 * Object to uniquely identify a modification to a {@link Sample} 
 * using a sequence of DNA
 * 
 * @author eiathom
 *
 */
public class Tag {

    private String identifier;

    public Tag(final String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(final String identifier) {
        this.identifier = identifier;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((identifier == null) ? 0 :
            identifier.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj != null && obj instanceof Tag) {
            final Tag other = (Tag) obj;
            return this.identifier.equals(other.identifier);
        }
        return false;
    }

    @Override
    public String toString() {
        return new StringBuilder("Tag [identifier=").append(identifier)
                .append("]").toString();
    }

}
