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
package com.sanger.api.labware;

import java.util.ArrayList;
import java.util.List;

import com.sanger.api.labware.container.Container;

/**
 * Abstract class to hold {@link Container} objects
 * 
 * @author eiathom
 *
 */
public abstract class BaseLabware implements Labware {

    @SuppressWarnings("rawtypes")
    protected final List<Container> containers = new ArrayList<>(1);

    public BaseLabware(@SuppressWarnings("rawtypes") final List<Container> containers) {
        this.containers.addAll(containers);
    }

    @SuppressWarnings("rawtypes")
    public List<Container> getContainers() {
        return containers;
    }

}
