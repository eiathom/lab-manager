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
package com.sanger.api.helpers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sanger.api.State;
import com.sanger.api.helpers.StateLogic;

/**
 * @author eiathom
 *
 */
public class StateLogicTest {

    @Test
    public void testChangingState_StateLogic() {
        assertEquals(State.STARTED, StateLogic.moveLogic(State.PENDING, State.STARTED));
        assertEquals(State.PENDING, StateLogic.moveLogic(State.PENDING, State.PENDING));
        assertEquals(State.PENDING, StateLogic.moveLogic(State.PENDING, State.PASSED));
        assertEquals(State.PENDING, StateLogic.moveLogic(State.PENDING, State.FAILED));

        assertEquals(State.STARTED, StateLogic.moveLogic(State.STARTED, State.STARTED));
        assertEquals(State.STARTED, StateLogic.moveLogic(State.STARTED, State.PENDING));
        assertEquals(State.PASSED, StateLogic.moveLogic(State.STARTED, State.PASSED));
        assertEquals(State.FAILED, StateLogic.moveLogic(State.STARTED, State.FAILED));

        assertEquals(State.PASSED, StateLogic.moveLogic(State.PASSED, State.PASSED));
        assertEquals(State.PASSED, StateLogic.moveLogic(State.PASSED, State.PENDING));
        assertEquals(State.PASSED, StateLogic.moveLogic(State.PASSED, State.STARTED));
        assertEquals(State.PASSED, StateLogic.moveLogic(State.PASSED, State.FAILED));

        assertEquals(State.FAILED, StateLogic.moveLogic(State.FAILED, State.FAILED));
        assertEquals(State.FAILED, StateLogic.moveLogic(State.FAILED, State.PENDING));
        assertEquals(State.FAILED, StateLogic.moveLogic(State.FAILED, State.STARTED));
        assertEquals(State.FAILED, StateLogic.moveLogic(State.FAILED, State.PASSED));
    }

}
