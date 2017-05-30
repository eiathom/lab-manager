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

import com.sanger.api.labware.container.Container;
import com.sanger.api.labware.container.SingleSampleContainer;
import com.sanger.api.labware.container.sample.Sample;
import com.sanger.api.labware.container.tube.Tube;
import com.sanger.api.labware.location.Location;

/**
 * @author eiathom
 *
 */
public class SampleTube extends Tube implements SingleSampleContainer {

    private final Sample sample;

    public SampleTube(final Location location, final Sample sample, final int code) {
        super(location, code);
        this.sample = sample;
    }

    @Override
    public void copySamples(@SuppressWarnings("rawtypes") final Container container) {
        if (container instanceof SingleSampleContainer) {
            final SingleSampleContainer singleSampleContainer = (SingleSampleContainer) container;
            final Sample sample = (Sample)singleSampleContainer.getSamples();
            this.sample.setData(sample.getData());
        } else {
            System.err.println("unable to add '" + container.getSamples() + "' to this SingleSampleContainer");
        }
    }

    @Override
    public Sample getSamples() {
        return sample;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((sample == null) ? 0 : sample.hashCode());
        result = prime * result + ((location == null) ? 0 : location.hashCode());
        result = prime * result + ((barcode == null) ? 0 : barcode.hashCode());
        result = prime * result + ((state == null) ? 0 : state.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj != null && obj instanceof SampleTube) {
            final SampleTube other = (SampleTube) obj;
            return this.sample.equals(other.sample) && this.location.equals(other.location)
                    && this.barcode.equals(other.barcode) && this.state.equals(other.state);
        }
        return false;
    }

    @Override
    public String toString() {
        return new StringBuilder("SampleTube [sample=").append(sample)
                .append(", barcode=").append(barcode).append(", location=")
                .append(location).append(", state=").append(state)
                .append("]").toString();
    }

}
