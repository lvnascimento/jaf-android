package br.edu.leonardo.jaf.android;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;

import javax.measure.Quantity;
import javax.measure.Unit;

import br.edu.leonardo.jaf.sensors.SensorValue;
import br.edu.leonardo.jaf.sensors.SingleSensorValue;
import br.edu.leonardo.jaf.sensors.ThreeAxisSensorValue;
import tec.units.ri.AbstractUnit;
import tec.units.ri.unit.MetricPrefix;
import tec.units.ri.unit.Units;

/**
 * This class is a factory for agent sensors in an Android device.
 */
public class AndroidDeviceSensorFactory {

    ///////////////////////////////////////////////////////////////////////////////////////////////
    // P U B L I C   M E T H O D S
    ///////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * This method creates a new Sensor object for an Android accelerometer. The created sensor
     * object can be added to an agent.
     *
     * @param context The Android application context.
     * @param samplingPeriod The sensor sampling period passed to the Android system (the desired
     *                       delay between two consecutive events in microseconds).
     * @param reportLatency The sensor report latency passed to the Android system. It is the
     *                      maximum time in microseconds that events can be delayed before being
     *                      reported to the application. A large value allows reducing the power
     *                      consumption associated with the sensor. If the report latency is set to
     *                      zero, events are delivered as soon as they are available.
     * @return The Sensor reference.
     */
    public static AndroidDeviceSensor createAccelerometer(Context context, int samplingPeriod, int reportLatency) {
        return createAndroidDeviceSensor(context, Sensor.TYPE_ACCELEROMETER, SENSOR_VALUE_3D, Units.METRE_PER_SQUARE_SECOND, samplingPeriod, reportLatency);
    }

    /**
     * This method creates a new Sensor object for an Android ambient temperature sensor. The
     * created sensor object can be added to an agent.
     *
     * @param context The Android application context.
     * @param samplingPeriod The sensor sampling period passed to the Android system (the desired
     *                       delay between two consecutive events in microseconds).
     * @param reportLatency The sensor report latency passed to the Android system. It is the
     *                      maximum time in microseconds that events can be delayed before being
     *                      reported to the application. A large value allows reducing the power
     *                      consumption associated with the sensor. If the report latency is set to
     *                      zero, events are delivered as soon as they are available.
     * @return The Sensor reference.
     */
    public static AndroidDeviceSensor createAmbientTemperatureSensor(Context context, int samplingPeriod, int reportLatency) {
        return createAndroidDeviceSensor(context, Sensor.TYPE_AMBIENT_TEMPERATURE, SENSOR_VALUE_SINGLE, Units.CELSIUS, samplingPeriod, reportLatency);
    }

    /**
     * This method creates a new Sensor object for an Android gravity sensor. The created sensor
     * object can be added to an agent.
     *
     * @param context The Android application context.
     * @param samplingPeriod The sensor sampling period passed to the Android system (the desired
     *                       delay between two consecutive events in microseconds).
     * @param reportLatency The sensor report latency passed to the Android system. It is the
     *                      maximum time in microseconds that events can be delayed before being
     *                      reported to the application. A large value allows reducing the power
     *                      consumption associated with the sensor. If the report latency is set to
     *                      zero, events are delivered as soon as they are available.
     * @return The Sensor reference.
     */
    public static AndroidDeviceSensor createGravity(Context context, int samplingPeriod, int reportLatency) {
        return createAndroidDeviceSensor(context, Sensor.TYPE_GRAVITY, SENSOR_VALUE_3D, Units.METRE_PER_SQUARE_SECOND, samplingPeriod, reportLatency);
    }

    /**
     * This method creates a new Sensor object for an Android gyroscope. The created sensor object
     * can be added to an agent.
     *
     * @param context The Android application context.
     * @param samplingPeriod The sensor sampling period passed to the Android system (the desired
     *                       delay between two consecutive events in microseconds).
     * @param reportLatency The sensor report latency passed to the Android system. It is the
     *                      maximum time in microseconds that events can be delayed before being
     *                      reported to the application. A large value allows reducing the power
     *                      consumption associated with the sensor. If the report latency is set to
     *                      zero, events are delivered as soon as they are available.
     * @return The Sensor reference.
     */
    public static AndroidDeviceSensor createGyroscope(Context context, int samplingPeriod, int reportLatency) {
        return createAndroidDeviceSensor(context, Sensor.TYPE_GYROSCOPE, SENSOR_VALUE_3D, Units.RADIAN.divide(Units.SECOND), samplingPeriod, reportLatency);
    }

    /**
     * This method creates a new Sensor object for an Android light sensor. The created sensor
     * object can be added to an agent.
     *
     * @param context The Android application context.
     * @param samplingPeriod The sensor sampling period passed to the Android system (the desired
     *                       delay between two consecutive events in microseconds).
     * @param reportLatency The sensor report latency passed to the Android system. It is the
     *                      maximum time in microseconds that events can be delayed before being
     *                      reported to the application. A large value allows reducing the power
     *                      consumption associated with the sensor. If the report latency is set to
     *                      zero, events are delivered as soon as they are available.
     * @return The Sensor reference.
     */
    public static AndroidDeviceSensor createLight(Context context, int samplingPeriod, int reportLatency) {
        return createAndroidDeviceSensor(context, Sensor.TYPE_LIGHT, SENSOR_VALUE_SINGLE, Units.LUX, samplingPeriod, reportLatency);
    }

    /**
     * This method creates a new Sensor object for an Android linear accelerometer. The created
     * sensor object can be added to an agent.
     *
     * @param context The Android application context.
     * @param samplingPeriod The sensor sampling period passed to the Android system (the desired
     *                       delay between two consecutive events in microseconds).
     * @param reportLatency The sensor report latency passed to the Android system. It is the
     *                      maximum time in microseconds that events can be delayed before being
     *                      reported to the application. A large value allows reducing the power
     *                      consumption associated with the sensor. If the report latency is set to
     *                      zero, events are delivered as soon as they are available.
     * @return The Sensor reference.
     */
    public static AndroidDeviceSensor createLinearAcceleration(Context context, int samplingPeriod, int reportLatency) {
        return createAndroidDeviceSensor(context, Sensor.TYPE_LINEAR_ACCELERATION, SENSOR_VALUE_3D, Units.METRE_PER_SQUARE_SECOND, samplingPeriod, reportLatency);
    }

    /**
     * This method creates a new Sensor object for an Android magnetic field sensor. The created
     * sensor object can be added to an agent.
     *
     * @param context The Android application context.
     * @param samplingPeriod The sensor sampling period passed to the Android system (the desired
     *                       delay between two consecutive events in microseconds).
     * @param reportLatency The sensor report latency passed to the Android system. It is the
     *                      maximum time in microseconds that events can be delayed before being
     *                      reported to the application. A large value allows reducing the power
     *                      consumption associated with the sensor. If the report latency is set to
     *                      zero, events are delivered as soon as they are available.
     * @return The Sensor reference.
     */
    public static AndroidDeviceSensor createMagneticField(Context context, int samplingPeriod, int reportLatency) {
        return createAndroidDeviceSensor(context, Sensor.TYPE_MAGNETIC_FIELD, SENSOR_VALUE_3D, MetricPrefix.MICRO(Units.TESLA), samplingPeriod, reportLatency);
    }

    /**
     * This method creates a new Sensor object for an Android pressure sensor. The created sensor
     * object can be added to an agent.
     *
     * @param context The Android application context.
     * @param samplingPeriod The sensor sampling period passed to the Android system (the desired
     *                       delay between two consecutive events in microseconds).
     * @param reportLatency The sensor report latency passed to the Android system. It is the
     *                      maximum time in microseconds that events can be delayed before being
     *                      reported to the application. A large value allows reducing the power
     *                      consumption associated with the sensor. If the report latency is set to
     *                      zero, events are delivered as soon as they are available.
     * @return The Sensor reference.
     */
    public static AndroidDeviceSensor createPressure(Context context, int samplingPeriod, int reportLatency) {
        return createAndroidDeviceSensor(context, Sensor.TYPE_PRESSURE, SENSOR_VALUE_SINGLE, MetricPrefix.HECTO(Units.PASCAL), samplingPeriod, reportLatency);
    }

    /**
     * This method creates a new Sensor object for an Android proximity sensor. The created sensor
     * object can be added to an agent.
     *
     * @param context The Android application context.
     * @param samplingPeriod The sensor sampling period passed to the Android system (the desired
     *                       delay between two consecutive events in microseconds).
     * @param reportLatency The sensor report latency passed to the Android system. It is the
     *                      maximum time in microseconds that events can be delayed before being
     *                      reported to the application. A large value allows reducing the power
     *                      consumption associated with the sensor. If the report latency is set to
     *                      zero, events are delivered as soon as they are available.
     * @return The Sensor reference.
     */
    public static AndroidDeviceSensor createProximity(Context context, int samplingPeriod, int reportLatency) {
        return createAndroidDeviceSensor(context, Sensor.TYPE_PROXIMITY, SENSOR_VALUE_SINGLE, MetricPrefix.CENTI(Units.METRE), samplingPeriod, reportLatency);
    }

    /**
     * This method creates a new Sensor object for an Android relative humidity sensor. The created
     * sensor object can be added to an agent.
     *
     * @param context The Android application context.
     * @param samplingPeriod The sensor sampling period passed to the Android system (the desired
     *                       delay between two consecutive events in microseconds).
     * @param reportLatency The sensor report latency passed to the Android system. It is the
     *                      maximum time in microseconds that events can be delayed before being
     *                      reported to the application. A large value allows reducing the power
     *                      consumption associated with the sensor. If the report latency is set to
     *                      zero, events are delivered as soon as they are available.
     * @return The Sensor reference.
     */
    public static AndroidDeviceSensor createRelativeHumidity(Context context, int samplingPeriod, int reportLatency) {
        return createAndroidDeviceSensor(context, Sensor.TYPE_RELATIVE_HUMIDITY, SENSOR_VALUE_SINGLE, Units.PERCENT, samplingPeriod, reportLatency);
    }

    /**
     * This method creates a new Sensor object for an Android step counter sensor. The created
     * sensor object can be added to an agent.
     *
     * @param context The Android application context.
     * @param samplingPeriod The sensor sampling period passed to the Android system (the desired
     *                       delay between two consecutive events in microseconds).
     * @param reportLatency The sensor report latency passed to the Android system. It is the
     *                      maximum time in microseconds that events can be delayed before being
     *                      reported to the application. A large value allows reducing the power
     *                      consumption associated with the sensor. If the report latency is set to
     *                      zero, events are delivered as soon as they are available.
     * @return The Sensor reference.
     */
    public static AndroidDeviceSensor createStepCounter(Context context, int samplingPeriod, int reportLatency) {
        return createAndroidDeviceSensor(context, Sensor.TYPE_STEP_COUNTER, SENSOR_VALUE_SINGLE, AbstractUnit.ONE, samplingPeriod, reportLatency);
    }

    /**
     * This method creates a new Sensor object for an Android hardware location sensor. The created
     * sensor object can be added to an agent.
     *
     * @param context The Android application context.
     * @param minTime The minimum time interval between location updates.
     * @param minDistance The minimum distance between location updates.
     * @return The Sensor reference.
     */
    public static AndroidLocationSensor createLocationSensor(Context context, Quantity minTime, Quantity minDistance) {
        return new AndroidLocationSensor(context, minTime, minDistance);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    // P R I V A T E   M E T H O D S
    ///////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * This internal method creates a new generic Android sensor and it is used by the other factory
     * methods to generate a specific Sensor object.
     *
     * @param context The Android application context.
     * @param sensorType The Android sensor type (see constants in the Android Sensor class).
     * @param valType The type of the value (SENSOR_VALUE_SINGLE or SENSOR_VALUE_3D).
     * @param unit The Unit used in the sensor values.
     * @param samplingPeriod The sensor sampling period passed to the Android system (the desired
     *                       delay between two consecutive events in microseconds).
     * @param reportLatency The sensor report latency passed to the Android system. It is the
     *                      maximum time in microseconds that events can be delayed before being
     *                      reported to the application. A large value allows reducing the power
     *                      consumption associated with the sensor. If the report latency is set to
     *                      zero, events are delivered as soon as they are available.
     * @return An AndroidDeviceSensor reference; or null, if the device does not contain a sensor
     *         related to the given sensor type.
     */
    private static AndroidDeviceSensor createAndroidDeviceSensor(Context context, int  sensorType, int valType, Unit unit, int samplingPeriod, int reportLatency) {
        SensorManager sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        Sensor androidSensor = sensorManager.getDefaultSensor(sensorType);
        if(androidSensor == null)
            return null;
        return new AndroidDeviceSensor(context, androidSensor, samplingPeriod, reportLatency) {
            @Override
            protected SensorValue createSensorValue(float[] values) {
                switch(valType) {
                    case SENSOR_VALUE_3D: return new ThreeAxisSensorValue(values, unit);
                    default: return new SingleSensorValue(values[0], unit);
                }
            }
        };
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    // P R I V A T E   C O N S T A N T S
    ///////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * A constant that represents a sensor that notifies a unique value.
     */
    private static final int SENSOR_VALUE_SINGLE = 0;

    /**
     * A constant that represents a sensor that notifies a three axis vector value.
     */
    private static final int SENSOR_VALUE_3D = 1;
}
