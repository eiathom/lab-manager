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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.sanger.api.labware.container.Container;
import com.sanger.api.labware.container.sample.TaggedSample;
import com.sanger.api.labware.container.sample.tag.Tag;
import com.sanger.api.labware.location.Location;

/**
 * @author eiathom
 *
 */
public class LaneTest {

    private TaggedSample sample;

    private Location location;

    @Before
    public void setup() {
        sample = new TaggedSampleImpl(new Tag("CXP1234"), "taggedData");
        location = new LocationImpl("other");
    }

    @Test
    public void testIdentity_Lane() {
        final Set<TaggedSample> samples = new HashSet<>(Arrays.asList(sample));
        final Container<?> lane = new Lane(location, samples);
        assertTrue("we expect a Lane object to be a Container", lane instanceof Container);
        assertTrue("we expect a Lane object to be a Lane", lane instanceof Lane);
    }

    @Test
    public void testCopySamples_Lane() {
        final Set<TaggedSample> samples = new HashSet<>(Arrays.asList(sample));
        final Container<?> lane = new Lane(location, samples);

        final TaggedSample otherSample = new TaggedSampleImpl(new Tag("CXP5678"), "otherTaggedData");
        final Set<TaggedSample> otherSamples = new HashSet<>(Arrays.asList(otherSample));
        final Container<?> other = new Lane(location, otherSamples);

        final Set<TaggedSample> expectedSamples = new HashSet<>();
        expectedSamples.add(sample);
        expectedSamples.add(otherSample);

        lane.copySamples(other);

        assertEquals("we expect our container to include copied Sample data", expectedSamples, lane.getSamples());

    }

}
