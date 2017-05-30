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

import com.sanger.api.labware.container.sample.Sample;

/**
 * {@link Sample} implementation
 * 
 * @author eiathom
 *
 */
public class SampleImpl implements Sample {

    private Object data;

    public SampleImpl(final Object data) {
        this.data = data;
    }

    @Override
    public Object getData() {
        return data;
    }

    @Override
    public void setData(final Object data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj != null && obj instanceof SampleImpl) {
            final SampleImpl other = (SampleImpl) obj;
            return this.data.equals(other.data);
        }
        return false;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Sample [data=").append(data)
                .append("]").toString();
    }

}
