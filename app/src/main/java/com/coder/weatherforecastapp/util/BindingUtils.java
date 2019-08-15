package com.coder.weatherforecastapp.util;

import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;

public class BindingUtils {
    @BindingAdapter("tools:text")
    public static void setFloat(TextView view, float value) {
        if (Float.isNaN(value)) view.setText("");
        else view.setText(String.valueOf(value));
    }

    @InverseBindingAdapter(attribute = "android:text")
    public static float getFloat(TextView view) {
        String num = view.getText().toString();
        if (num.isEmpty()) return 0.0F;
        try {
            return Float.parseFloat(num);
        } catch (NumberFormatException e) {
            return 0.0F;
        }
    }

    @BindingAdapter("tools:url")
    public static void loadImage(ImageView imageView, String url) {
        Log.e("Gourav", "Url - " + url);
        Picasso.get()
                .load(url)
                .into(imageView);
        Picasso.get()
                .setLoggingEnabled(true);
    }
}
