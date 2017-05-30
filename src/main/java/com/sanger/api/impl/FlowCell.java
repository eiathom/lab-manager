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

import java.util.Arrays;

import com.sanger.api.FlowCellSize;
import com.sanger.api.State;
import com.sanger.api.helpers.StateLogic;
import com.sanger.api.labware.Labware;
import com.sanger.api.labware.location.Location;

/**
 * Holds individual DNA strands
 * 
 * @author eiathom
 *
 */
public class FlowCell implements Labware {

    private Lane[] lanes;

    private Location location;

    private State state;

    public FlowCell(final FlowCellSize flowCellSize, final Location location) {
        this.lanes = new Lane[flowCellSize.getSize()];
        this.location = location;
        this.state = State.PENDING;
    }

    public Lane[] getLanes() {
        return lanes;
    }

    public void setLanes(final Lane[] lanes) {
        if (lanes.length > this.lanes.length) {
            System.out.println("cannot add more lanes than available");
        } else {
            this.lanes = lanes;
        }
    }

    @Override
    public void changeLocation(final Location location) {
        this.location = location;
    }

    @Override
    public void moveState(final State nextState) {
        this.state = StateLogic.moveLogic(state, nextState);
    }

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public void resetState() {
        this.state = State.PENDING;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((lanes == null) ? 0 : lanes.hashCode());
        result = prime * result + ((location == null) ? 0 : location.hashCode());
        result = prime * result + ((state == null) ? 0 : state.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj != null && obj instanceof FlowCell) {
            final FlowCell other = (FlowCell) obj;
            return this.lanes.equals(other.lanes)
                    && this.location.equals(other.location)
                    && this.state.equals(other.state);
        }
        return false;
    }

    @Override
    public String toString() {
        return new StringBuilder("FlowCell [lanes=").append(Arrays.toString(lanes))
                .append(", location=").append(location).append(", state=")
                .append(state).append("]").toString();
    }

}
