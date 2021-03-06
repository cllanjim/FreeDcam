package com.troop.freedcam.camera.parameters.manual;

import android.util.Log;

import com.troop.freedcam.i_camera.parameters.AbstractParameterHandler;

import java.util.HashMap;

/**
 * Created by troop on 17.08.2014.
 */
public class BrightnessManualParameter extends BaseManualParameter
{
    private static  String TAG = "freedcam.ManualBrightnessParameter";

    public BrightnessManualParameter(HashMap<String, String> parameters, String value, String maxValue, String MinValue, AbstractParameterHandler camParametersHandler)
    {
        super(parameters, value, maxValue, MinValue, camParametersHandler);
        this.value = "brightness";
        if (!hasSupport())
        {
            try
            {
                this.value = "luma-adaptation";
                hasSupport();
            }
            catch (Exception ex)
            {
                isSupported = false;
            }
        }
        if (isSupported)
        {
            max_value = "max-brightness";
            min_value = "min-brightness";

        }
        Log.d(TAG, "support brightness:" + isSupported);

    }

    @Override
    public int GetMaxValue()
    {
        int max = 100;
        try {
            max = super.GetMaxValue();
        }
        catch (Exception ex)
        {

        }
        if (max > 0)
            return max;
        else return 100;
    }

    @Override
    public int GetMinValue() {
        int min = 0;
        try {
            min = super.GetMinValue();
        }
        catch (Exception ex)
        {

        }
        if (min < 0)
            return min;
        else return 0;
    }

    @Override
    public String GetStringValue() {
        return null;
    }
}
