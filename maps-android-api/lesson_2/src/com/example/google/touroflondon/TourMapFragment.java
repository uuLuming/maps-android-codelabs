/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.google.touroflondon;

import com.example.google.R;
import com.example.google.touroflondon.data.MapLoaderCallbacks;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

/** An interactive map fragment that shows a tour of London. */
public class TourMapFragment extends MapFragment implements MapLoaderCallbacks.MapDataLoader {

    /** Callbacks for loading data into this TourMapFragment */
    private MapLoaderCallbacks mLoaderCallbacks;

    /** The Google Map object. */
    private GoogleMap mMap;

    /**
     * The saved instance state passed in in onCreate that we need later for
     * setupMapIfNeeded.
     */
    private Bundle mSavedInstanceState;

    /** Starting position for the camera. */
    public static final LatLng LONDON = new LatLng(51.5, -0.12);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSavedInstanceState = savedInstanceState;

        // Initialise loader callbacks, used to notify this fragment once data
        // has been loaded from the database
        mLoaderCallbacks = new MapLoaderCallbacks(this, getActivity());

        // For the action bar.
        setHasOptionsMenu(true);
    }

    @Override
    public void onResume() {
        super.onResume();

        // See the javadoc for this method for why we should call this here as
        // well..
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play
     * services APK is correctly installed) and the map has not already been
     * instantiated.
     * <p>
     * If it isn't installed {@link MapFragment} will show a prompt for the user
     * to install/update the Google Play services APK on their device.
     * <p>
     * A user can return to this FragmentActivity after following the prompt and
     * correctly installing/updating/enabling the Google Play services. Since
     * the FragmentActivity may not have been completely destroyed during this
     * process (it is likely that it would only be stopped or paused),
     * {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the
        // map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                // We can now set up the map.

                if (mSavedInstanceState == null) {
                    // The map automatically saves the camera position so we
                    // only want to set it if we are starting
                    // fresh.
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LONDON, 12));
                }

                // Disable the on screen zoom controls.
                mMap.getUiSettings().setZoomControlsEnabled(false);
            }
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.map, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_map_center:
                showAllPois();
                return true;
            case R.id.menu_map_type:
                showMapTypeSelector();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    /** Moves the camera back to a position which includes all the POIs. */
    private void showAllPois() {
    }

    /**
     * Show a dialog to allow the user to choose which map type they want.
     */
    private void showMapTypeSelector() {
    }

    /**
     * Called when a POI is selected from the list of POIs.
     * 
     * @param title The title of the POI.
     */
    public void onPoiSelected(String title) {
    }

    /**
     * Called when a selection is made from the select map type dialog.
     * 
     * @param type One of the constants listed in {@link SelectMapTypeDialog}.
     */
    public void onSelectMapTypeDialogSelected(int type) {
    }

    /**
     * Called to add a point of interest to the map.
     */
    public void addPoi(PointOfInterest poi) {
    }

    /**
     * Called with a list of LatLng route coordinates.
     */
    public void addRoute(ArrayList<LatLng> list) {
    }
}
