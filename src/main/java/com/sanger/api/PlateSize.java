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
package com.sanger.api;

/**
 * Identifies the number of {@link Well} on a {@link Plate}
 * 
 * @author eiathom
 *
 */
public enum PlateSize {

    MEDIUM(96), LARGE(384);

    private final int size;

    private PlateSize(final int size) {
        this.size = size;
    }

    /**
     * @return the size value
     */
    public int getSize() {
        return size;
    }

}
