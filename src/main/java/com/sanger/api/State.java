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
package com.sanger.api;

/**
 * Identifies the {@link State} an object can acquire during its life-cycle
 * 
 * @author eiathom
 *
 */
public enum State {

    PENDING(0), STARTED(1), PASSED(2), FAILED(3);

    private final int value;

    private State(final int value) {
        this.value = value;
    }

    /**
     * @return the {@link State} value
     */
    public int getValue() {
        return value;
    }

}
