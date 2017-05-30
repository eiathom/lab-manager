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

import org.junit.Test;

import com.sanger.api.labware.Labware;
import com.sanger.api.labware.LabwareWithBarcode;
import com.sanger.api.labware.container.Container;

/**
 * @author eiathom
 *
 */
public class SampleTubeTest {

    @Test
    public void testMultiInheritence_sampleTube() {
        final LocationImpl location = new LocationImpl("other");
        final SampleImpl sample = new SampleImpl("someData");
        final int code = 123456789;
        @SuppressWarnings("rawtypes")
        final Container sampleTube = new SampleTube(location, sample, code);
        assertTrue("we expect a SampleTube to be a Container", sampleTube instanceof Container);
        assertTrue("we expect a SampleTube to be a Labware", sampleTube instanceof Labware);
        assertEquals("we expect a SampleTube barcode to be created", "SANGER_NT" + code + "_" + location.getName(),
                ((LabwareWithBarcode)sampleTube).getBarcode());
        assertEquals("we expect a SampleTube barcode to be created", sample, sampleTube.getSamples());
    }

}
