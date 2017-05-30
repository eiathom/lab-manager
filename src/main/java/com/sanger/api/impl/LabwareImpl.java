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

import static com.sanger.api.helpers.StateLogic.moveLogic;

import java.util.List;

import com.sanger.api.State;
import com.sanger.api.labware.BaseLabware;
import com.sanger.api.labware.Labware;
import com.sanger.api.labware.container.Container;
import com.sanger.api.labware.location.Location;

/**
 * {@link Labware} implementation
 * 
 * @author eiathom
 *
 */
public class LabwareImpl extends BaseLabware {

    private Location location;

    private State state;

    public LabwareImpl(@SuppressWarnings("rawtypes") final List<Container> containers,
            final Location location) {
        super(containers);
        this.location = location;
        this.state = State.PENDING;
    }

    @Override
    public void changeLocation(final Location location) {
        this.location = location;
    }

    @Override
    public void moveState(final State nextState) {
        this.state = moveLogic(state, nextState);
    }

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public void resetState() {
        state = State.PENDING;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((containers == null) ? 0 : containers.hashCode());
        result = prime * result + ((location == null) ? 0 : location.hashCode());
        result = prime * result + ((state == null) ? 0 : state.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj != null && obj instanceof LabwareImpl) {
            final LabwareImpl other = (LabwareImpl) obj;
            return this.containers.equals(other.containers)
                    && this.location.equals(other.location)
                    && this.state.equals(other.state);
        }
        return false;
    }

    @Override
    public String toString() {
        return new StringBuilder("LabwareImpl [location=").append(location)
                .append(", state=").append(state).append(", containers=")
                .append(containers).append("]").toString();
    }

}
