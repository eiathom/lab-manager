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
package com.sanger.api.labware.container.tube;

import static com.sanger.api.helpers.BarcodeCreator.createBarcode;
import static com.sanger.api.helpers.StateLogic.moveLogic;

import com.sanger.api.State;
import com.sanger.api.impl.LocationImpl;
import com.sanger.api.labware.LabwareWithBarcode;
import com.sanger.api.labware.location.Location;

/**
 * @author eiathom
 *
 */
public abstract class Tube implements LabwareWithBarcode {

    protected static final String BARCODE_PREFIX = "NT";

    protected String barcode;

    protected Location location;

    protected State state;

    public Tube(final Location location, final int code) {
        this.location = location;
        this.state = State.PENDING;
        this.setBarcode(code);
    }

    @Override
    public Location getLocation() {
        return location;
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
    public String getBarcode() {
        return barcode;
    }

    @Override
    public void setBarcode(final int code) {
        this.barcode = createBarcode(BARCODE_PREFIX, code, ((LocationImpl)location).getName());
    }

    @Override
    public void resetState() {
        this.state = State.PENDING;
    }

}
