package br.edu.leonardo.jaf.android;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;

import java.util.List;

import javax.measure.Quantity;

import br.edu.leonardo.jaf.sensors.LocationSensorValue;
import br.edu.leonardo.jaf.sensors.Sensor;
import br.edu.leonardo.jaf.sensors.SensorException;
import tec.units.ri.AbstractUnit;
import tec.units.ri.unit.MetricPrefix;
import tec.units.ri.unit.Units;

/**
 * An Android location sensor (a GPS receiver).
 */
public class AndroidLocationSensor extends Sensor implements LocationListener {

    ///////////////////////////////////////////////////////////////////////////////////////////////
    // P U B L I C   C O N S T R U C T O R S
    ///////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * This method builds a new AndroidLocationSensor from the given context and that encapsulates
     * a location sensor with the given parameters.
     *
     * @param context The Android application context.
     * @param minTime The minimum time interval between location updates.
     * @param minDistance The minimum distance between location updates.
     */
    public AndroidLocationSensor(Context context, Quantity minTime, Quantity minDistance) {
        this.context = context;
        this.locationMgr = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        this.minTime = minTime;
        this.minDistance = minDistance;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    // P U B L I C   M E T H O D S
    ///////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void init() throws SensorException {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            throw new SensorException(this, "The application does not have permissions to access user location.");
        }
        locationMgr.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                minTime.to(MetricPrefix.MILLI(Units.SECOND)).getValue().longValue(),
                minDistance.to(Units.METRE).getValue().floatValue(),
                this);
    }

    @Override
    public void onLocationChanged(Location location) {
    }

    @Override
    public void onLocationChanged(List<Location> locations) {
        for(Location loc : locations) {
            newReading(new LocationSensorValue(
                    loc.getLatitude(),
                    loc.getLongitude(),
                    loc.getAltitude(),
                    AbstractUnit.ONE,
                    Units.METRE
            ));
        }
    }

    @Override
    public void onFlushComplete(int requestCode) { }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) { }

    @Override
    public void onProviderEnabled(String provider) { }

    @Override
    public void onProviderDisabled(String provider) { }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    // P R I V A T E   A T T R I B U T E S
    ///////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * The location manager obtained from the application context given to this object.
     */
    private final LocationManager locationMgr;

    /**
     * The Android application context used by this object.
     */
    private final Context context;

    /**
     * The minimum time interval between location updates.
     */
    private final Quantity minTime;

    /**
     * The minimum distance between location updates.
     */
    private final Quantity minDistance;
}
