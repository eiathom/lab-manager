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
package com.sanger.api.labware;

import com.sanger.api.State;
import com.sanger.api.labware.location.Location;
import com.sanger.api.labware.location.Locationable;

/**
 * Interface providing the ability for an object to be a piece of lab equipment
 * 
 * @author eiathom
 *
 */
public interface Labware extends Locationable {

    /**
     * @param location the {@link Location} to set this object to
     */
    void changeLocation(final Location location);

    /**
     * Can move from pending to started, and then started to passed or failed
     * 
     * @param nextState the next {@link State} this object is expected to proceed to
     */
    void moveState(final State nextState);

    /**
     * initialize {@link State} to dafault
     */
    void resetState();

}
