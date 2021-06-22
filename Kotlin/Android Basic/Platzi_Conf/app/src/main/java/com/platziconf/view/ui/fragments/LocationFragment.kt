package com.platziconf.view.ui.fragments

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.type.LatLng
import com.platziconf.R
import com.platziconf.model.Location

class LocationFragment : Fragment(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_location, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment

        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        val location = Location()

        val zoom = 17f
        val coordinates= com.google.android.gms.maps.model.LatLng(location.latitude, location.lenght)

        googleMap?.addMarker(
                MarkerOptions()
                        .position(coordinates)
                        .title("Platzi Conf")
        )

        googleMap?.animateCamera(CameraUpdateFactory.newLatLngZoom(coordinates,zoom))

        /*
        With image png
        val bitMapDraw = context?.applicationContext?.let{ContextCompat.getDrawable(it,R.drawable.ic_baseline_location_on_24)} as BitmapDrawable
        val smallMarker = Bitmap.createScaledBitmap(bitMapDraw.bitmap, 150,150,false)

        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(smallMarker))
        googleMap?.addMarker(markerOptions)*/

        googleMap?.setOnMarkerClickListener(this)
    }

    override fun onMarkerClick(p0: Marker?): Boolean {
        findNavController().navigate(R.id.LocationDetailFragmentDialog)
        return true
    }
}