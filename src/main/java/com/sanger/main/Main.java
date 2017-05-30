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
package com.sanger.main;

import com.sanger.api.PlateSize;
import com.sanger.api.impl.*;
import com.sanger.api.labware.Labware;

/**
 * Main class to run operations over {@link Labware}
 * 
 * @author eiathom
 *
 */
public class Main {

    /**
     * Run operations
     * Get a particular {@link Well} on a {@link Plate}
     * 
     * @param args 0=xOrdinate, 1=yOrdinate of target {@link Well} on {@link Plate}
     */
    public static void main(final String[] args) {
        final Labware plate = getPlate();
        populateWells((Plate)plate);
        try {
            final Integer xOrdinate = Integer.valueOf(args[0]);
            final Integer yOrdinate = Integer.valueOf(args[1]);
            final Well well = getWell((Plate)plate, xOrdinate, yOrdinate);
            if (well != null) {
                System.out.println("Well found!");
                System.out.println(well);
            }
        } catch (final NumberFormatException | IndexOutOfBoundsException exception) {
            System.err.println(
                    exception.getClass().getSimpleName() + "; " + exception.getMessage());
            System.err.println(
                    "unable to parse input values: 2 values must passed and, "
                            + "must be numbers: args=" + args.length);
        }
    }

    /**
     * Identify a particular well
     * 
     * @param plate the {@link Plate} containing multiple {@link Well}
     * @param yOrdinate position of a {@link Well} on the {@link Plate} y-axis
     * @param xOrdinate position of a {@link Well} on the {@link Plate} x-axis
     * @return a particular {@link Well}
     */
    public static Well getWell(final Plate plate, final int xOrdinate,
            final int yOrdinate) {
        if (xOrdinate > plate.getWells().length || yOrdinate > plate.getWells().length) {
            System.err.println(
                    "unable to get a Well as position of Well requested is outside of this Plate");
            return null;
        }
        return plate.getWells()[xOrdinate][yOrdinate];
    }

    private static void populateWells(final Plate plate) {
        final int plateSize = plate.getWells().length;
        for (int rowIndex = 0; rowIndex < plateSize; rowIndex++) {
            for (int columnIndex = 0; columnIndex < plateSize; columnIndex++) {
                final Well well = new Well(
                        new LocationImpl(getLocationName(plate, rowIndex, columnIndex)),
                        new SampleImpl("someData_" + (rowIndex + columnIndex)));
                plate.getWells()[rowIndex][columnIndex] = well;
            }
        }
    }

    private static Labware getPlate() {
        final int code = 1234567;
        final String kocationName = "PLate-X_-_LAB-XX";
        final Labware plate = new Plate(code, PlateSize.MEDIUM, new LocationImpl(kocationName));
        return plate;
    }

    private static String getLocationName(final Plate plate, int rowIndex, int columnIndex) {
        return "Well_" + rowIndex + ":" + columnIndex + "_-_"
                + ((LocationImpl)plate.getLocation()).getName();
    }

}
