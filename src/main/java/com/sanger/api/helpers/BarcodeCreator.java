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

import static com.sanger.api.helpers.barcode.constants.Constants.FORMAT_PART;
import static com.sanger.api.helpers.barcode.constants.Constants.FORMAT_PART_NO_LOCATION;
import static com.sanger.api.helpers.barcode.constants.Constants.FORMAT_PART_NO_PREFIX;
import static com.sanger.api.helpers.barcode.constants.Constants.FORMAT_PART_NO_PREFIX_LOCATION_INFO;

/**
 * Helper object to create barcodes
 * 
 * @author eiathom
 *
 */
public final class BarcodeCreator {

    private BarcodeCreator(){}

    /**
     * For a given value and ID, return a barcode in the format:</br>
     * </b>COMPANY_BARCODE_LOCATION</b></br>
     * of the {@link Sample}
     * 
     * @param prefix the id of the barcode
     * @param code unique numeric value of the barcode
     * @param location location of the sample
     * @return a barcode
     */
    public static String createBarcode(final String prefix, final int code, final String location) {
        if ((prefix == null || prefix.isEmpty()) && (location == null || location.isEmpty())) {
            return String.format(FORMAT_PART_NO_PREFIX_LOCATION_INFO, code);
        } else if (prefix == null || prefix.isEmpty()) {
            return String.format(FORMAT_PART_NO_PREFIX, code, location);
        } else if (location == null || location.isEmpty()) {
            return String.format(FORMAT_PART_NO_LOCATION, prefix, code);
        }
        return String.format(FORMAT_PART, prefix, code, location);
    }

}
