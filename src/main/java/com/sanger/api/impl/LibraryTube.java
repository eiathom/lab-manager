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

import java.util.HashSet;
import java.util.Set;

import com.sanger.api.labware.container.Container;
import com.sanger.api.labware.container.MultiSampleContainer;
import com.sanger.api.labware.container.sample.Sample;
import com.sanger.api.labware.container.sample.TaggedSample;
import com.sanger.api.labware.container.tube.Tube;
import com.sanger.api.labware.location.Location;

/**
 * {@link Tube} to store multiple {@link TaggedSample}
 * 
 * @author eiathom
 *
 */
public class LibraryTube extends Tube implements MultiSampleContainer {

    private final Set<TaggedSample> samples = new HashSet<>(1);

    public LibraryTube(final Location location, final Set<TaggedSample> samples, final int code) {
        super(location, code);
        this.samples.addAll(samples);
    }

    @Override
    public void copySamples(@SuppressWarnings("rawtypes") final Container container) {
        if (container instanceof MultiSampleContainer) {
            final MultiSampleContainer otherContainer = (MultiSampleContainer) container;
            @SuppressWarnings("unchecked")
            final Set<TaggedSample> samples = (Set<TaggedSample>)otherContainer.getSamples();
            this.samples.addAll(samples);
        } else {
            System.err.println("unable to add '" + container.getSamples() + "' to this MultiSampleContainer");
        }
    }

    @Override
    public Set<? extends Sample> getSamples() {
        return samples;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((samples == null) ? 0 : samples.hashCode());
        result = prime * result + ((location == null) ? 0 : location.hashCode());
        result = prime * result + ((barcode == null) ? 0 : barcode.hashCode());
        result = prime * result + ((state == null) ? 0 : state.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj != null && obj instanceof LibraryTube) {
            final LibraryTube other = (LibraryTube) obj;
            return this.samples.equals(other.samples)
                    && this.location.equals(other.location)
                    && this.barcode.equals(other.barcode)
                    && this.state.equals(other.state);
        }
        return false;
    }

    @Override
    public String toString() {
        return new StringBuilder("LibraryTube [samples=").append(samples)
                .append(", barcode=").append(barcode).append(", location=")
                .append(location).append(", state=").append(state)
                .append("]").toString();
    }

}
