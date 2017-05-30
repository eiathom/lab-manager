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

import static com.sanger.api.helpers.BarcodeCreator.createBarcode;

import java.util.Arrays;

import com.sanger.api.PlateSize;
import com.sanger.api.State;
import com.sanger.api.helpers.StateLogic;
import com.sanger.api.labware.LabwareWithBarcode;
import com.sanger.api.labware.location.Location;

/**
 * Microtiter {@link Plate} with multiple {@link Well}
 * 
 * @author eiathom
 *
 */
public class Plate implements LabwareWithBarcode {

    private static final String BARCODE_PREFIX = "DN";

    private final Well[][] wells;

    private String barcode;

    private Location location;

    private State state;

    public Plate(final int code, final PlateSize plateSize, final Location location) {
        final int size = plateSize.getSize();
        this.wells = new Well[size][size];
        this.location = location;
        this.state = State.PENDING;
        this.setBarcode(code);
    }

    @Override
    public void changeLocation(final Location location) {
        this.location = location;
    }

    @Override
    public void moveState(final State nextState) {
        this.state = StateLogic.moveLogic(state, nextState);
    }

    public Well[][] getWells() {
        return wells;
    }

    @Override
    public String getBarcode() {
        return barcode;
    }

    @Override
    public void setBarcode(final int code) {
        this.barcode = createBarcode(BARCODE_PREFIX, code, ((LocationImpl)location).getName());
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
        result = prime * result + ((wells == null) ? 0 : wells.hashCode());
        result = prime * result + ((location == null) ? 0 : location.hashCode());
        result = prime * result + ((state == null) ? 0 : state.hashCode());
        result = prime * result + ((barcode == null) ? 0 : barcode.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj != null && obj instanceof Plate) {
            final Plate other = (Plate) obj;
            return this.wells.equals(other.wells) && this.location.equals(other.location)
                    && this.state.equals(other.state) && this.barcode.equals(other.barcode);
        }
        return false;
    }

    @Override
    public String toString() {
        return new StringBuilder("Plate [wells=").append(Arrays.toString(wells))
                .append(", barcode=").append(barcode).append(", location=")
                .append(location).append(", state=").append(state).append("]")
                .toString();
    }

}
