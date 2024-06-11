package br.edu.leonardo.jaf.android;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;

import br.edu.leonardo.jaf.sensors.Sensor;
import br.edu.leonardo.jaf.sensors.SensorInitializationException;
import br.edu.leonardo.jaf.sensors.SensorValue;

/**
 * An abstract implementation of an Android device sensor for agents in JAF. It is possible to
 * implement a specific sensor in Android creating a subclass of this class.
 */
public abstract class AndroidDeviceSensor extends Sensor implements SensorEventListener {

    ///////////////////////////////////////////////////////////////////////////////////////////////
    // P U B L I C   C O N S T R U C T O R S
    ///////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * This constructor build a new AndroidDeviceSensor from the given context and that encapsulates
     * the given Android sensor reference.
     *
     * @param context The Android application context.
     * @param sensor The desired Android sensor.
     * @param samplingPeriod The sensor sampling period passed to the Android system (the desired
     *                       delay between two consecutive events in microseconds).
     * @param reportLatency The sensor report latency passed to the Android system. It is the
     *                      maximum time in microseconds that events can be delayed before being
     *                      reported to the application. A large value allows reducing the power
     *                      consumption associated with the sensor. If the report latency is set to
     *                      zero, events are delivered as soon as they are available.
     */
    public AndroidDeviceSensor(Context context, android.hardware.Sensor sensor, int samplingPeriod, int reportLatency) {
        this.sensorMgr = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        this.sensor = sensor;
        this.samplingPeriod = samplingPeriod;
        this.reportLatency = reportLatency;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    // P U B L I C   M E T H O D S
    ///////////////////////////////////////////////////////////////////////////////////////////////

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public void init() throws SensorInitializationException {
        if(!sensorMgr.registerListener(this, sensor, samplingPeriod, reportLatency))
            throw new SensorInitializationException("The sensor is not supported or it is not successfully enabled.");
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        newReading(createSensorValue(event.values));
    }

    @Override
    public void onAccuracyChanged(android.hardware.Sensor sensor, int i) {
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    // P R O T E C T E D   M E T H O D S
    ///////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * This method should be implemented in subclasses to created the appropriate sensor value to
     * the implemented sensor.
     *
     * @param values The values reported by the Android sensor.
     * @return The generated SensorValue reference.
     */
    protected abstract SensorValue createSensorValue(float[] values);

    ///////////////////////////////////////////////////////////////////////////////////////////////
    // G E T T E R S   A N D   S E T T E R S
    ///////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * This method obtains the Android sensor reference encapsulated by this object.
     *
     * @return The Android sensor reference.
     */
    public android.hardware.Sensor getSensor() {
        return sensor;
    }

    /**
     * This method obtains the sensor sampling period passed to the Android system (the desired
     * delay between two consecutive events in microseconds).
     *
     * @return The sampling period value.
     */
    public int getSamplingPeriod() {
        return samplingPeriod;
    }

    /**
     * This method obtains the sensor report latency passed to the Android system. It is the maximum
     * time in microseconds that events can be delayed before being reported to the application. A
     * large value allows reducing the power consumption associated with the sensor. A zero value
     * indicates that events are delivered as soon as they are available.
     *
     * @return The report latency value.
     */
    public int getReportLatency() {
        return reportLatency;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    // P R I V A T E   A T T R I B U T E S
    ///////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * The sensor manager obtained from the application context given to this object.
      */
    private final SensorManager sensorMgr;

    /**
     * The Android sensor reference encapsulated by this object.
     */
    private final android.hardware.Sensor sensor;

    /**
     * The sensor sampling period passed to the Android system (the desired delay between two
     * consecutive events in microseconds).
     */
    private final int samplingPeriod;

    /**
     * The sensor report latency passed to the Android system. It is the maximum time in
     * microseconds that events can be delayed before being reported to the application. A large
     * value allows reducing the power consumption associated with the sensor. If the report latency
     * is set to zero, events are delivered as soon as they are available.
     */
    private final int reportLatency;
}
