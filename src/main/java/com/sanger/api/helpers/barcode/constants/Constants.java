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
package com.sanger.api.helpers.barcode.constants;

/**
 * Constants used when identifying and creating a barcode
 * 
 * @author eiathom
 *
 */
public final class Constants {

    public static final String COMPANY_ID = "SANGER";

    public static final String UNDERSCORE = "_";

    public static final String FORMAT_PART = COMPANY_ID + UNDERSCORE + "%1$s%2$d" + UNDERSCORE + "%3$s";

    public static final String FORMAT_PART_NO_PREFIX = COMPANY_ID + UNDERSCORE + "%1$d" + UNDERSCORE + "%2$s";

    public static final String FORMAT_PART_NO_LOCATION = COMPANY_ID + UNDERSCORE + "%1$s%2$d";

    public static final String FORMAT_PART_NO_PREFIX_LOCATION_INFO = COMPANY_ID + UNDERSCORE + "%d";

    private Constants() {}

}
