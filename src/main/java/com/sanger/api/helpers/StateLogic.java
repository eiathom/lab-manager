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

import com.sanger.api.State;

/**
 * Helper object to move object {@link State}
 * 
 * @author eiathom
 *
 */
public final class StateLogic {

    private StateLogic() {}

    /**
     * Can move from pending to started and then started to passed or failed
     * 
     * @param currentState
     * @param nextState
     * @return the next valid state
     */
    public static State moveLogic(final State currentState, final State nextState) {
        if (currentState.getValue() < 1 && nextState.getValue() < 2) {
            return nextState;
        } else if (currentState.getValue() == 1 && nextState.getValue() > 1) {
            if (nextState.getValue() == 2) {
                return State.PASSED;
            }
            return State.FAILED;
        }
        return currentState;
    }

}
