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

import org.junit.Before;

import static com.sanger.api.helpers.barcode.constants.Constants.COMPANY_ID;
import static com.sanger.api.helpers.barcode.constants.Constants.UNDERSCORE;

import org.junit.Test;

/**
 * @author eiathom
 *
 */
public class BarcodeCreatorTest {

    String prefix;
    int code;
    String location;

    @Before
    public void setup() {
        prefix = "CXP";
        code = 1234567;
        location = "other";
    }

    @Test
    public void testBarcodeCreation_allParams_BarcodeCreator() {
        final String expectedBarcode = COMPANY_ID + UNDERSCORE + prefix + code + UNDERSCORE + location;
        final String actualBarcode = BarcodeCreator.createBarcode(prefix, code, location);

        assertEquals("we expect a formatted Barcode to created",  expectedBarcode, actualBarcode);
    }

    @Test
    public void testBarcodeCreation_noLocation_BarcodeCreator() {
        String expectedBarcode = COMPANY_ID + UNDERSCORE + prefix + code;
        String actualBarcode = BarcodeCreator.createBarcode(prefix, code, null);

        assertEquals("we expect a formatted Barcode to created",  expectedBarcode, actualBarcode);

        actualBarcode = BarcodeCreator.createBarcode(prefix, code, "");

        assertEquals("we expect a formatted Barcode to created",  expectedBarcode, actualBarcode);
    }

    @Test
    public void testBarcodeCreation_noPrefix_BarcodeCreator() {
        String expectedBarcode = COMPANY_ID + UNDERSCORE + code + UNDERSCORE + location;
        String actualBarcode = BarcodeCreator.createBarcode(null, code, location);

        assertEquals("we expect a formatted Barcode to created",  expectedBarcode, actualBarcode);

        actualBarcode = BarcodeCreator.createBarcode("", code, location);

        assertEquals("we expect a formatted Barcode to created",  expectedBarcode, actualBarcode);
    }

    @Test
    public void testBarcodeCreation_noPrefix_noLocation_BarcodeCreator() {
        String expectedBarcode = COMPANY_ID + UNDERSCORE + code;
        String actualBarcode = BarcodeCreator.createBarcode(null, code, null);

        assertEquals("we expect a formatted Barcode to created",  expectedBarcode, actualBarcode);

        actualBarcode = BarcodeCreator.createBarcode("", code, "");

        assertEquals("we expect a formatted Barcode to created",  expectedBarcode, actualBarcode);
    }

}
