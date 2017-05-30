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
package com.sanger.api.labware.container.sample;

/**
 * Interface providing an object the ability to store data
 * 
 * @author eiathom
 *
 */
public interface Sample {

    /**
     * Get the data defined in this {@link Sample} 
     * 
     * @return the {@link Sample} data
     */
    Object getData();

    /**
     * Populate this {@link Sample} with data
     * 
     * @param data the data describing this {@link Sample}
     */
    void setData(final Object data);

}
