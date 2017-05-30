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

import com.sanger.api.QualityCheck;
import com.sanger.api.labware.container.Container;
import com.sanger.api.labware.container.MultiSampleContainer;
import com.sanger.api.labware.container.sample.Sample;
import com.sanger.api.labware.container.sample.TaggedSample;
import com.sanger.api.labware.location.Location;

/**
 * Physical 'lane' on a flow cell</br>
 * A lane can contain multiple samples
 * 
 * @author eiathom
 *
 */
public class Lane implements MultiSampleContainer {

    private final Set<TaggedSample> samples = new HashSet<>(1);

    private final Location location;

    private QualityCheck qualityCheck;

    public Lane(final Location location, final Set<TaggedSample> samples) {
        this.qualityCheck = QualityCheck.FAIL;
        this.location = location;
        this.samples.addAll(samples);
    }

    public QualityCheck getQualityCheck() {
        return qualityCheck;
    }

    public void setQualityCheck(final QualityCheck qualityCheck) {
        this.qualityCheck = qualityCheck;
    }

    @Override
    public Location getLocation() {
        return location;
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
        result = prime * result + ((qualityCheck == null) ? 0 : qualityCheck.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj != null && obj instanceof Lane) {
            final Lane other = (Lane) obj;
            return this.samples.equals(other.samples)
                    && this.location.equals(other.location)
                    && this.qualityCheck.equals(other.qualityCheck);
        }
        return false;
    }

    @Override
    public String toString() {
        return new StringBuilder("Lane [samples=").append(samples).append(", location=")
                .append(location).append(", qualityCheck=").append(qualityCheck).append("]").toString();
    }

}
