package com.example.bmicalc;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;


import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Fragment wyświetlający wykres BMI z danych historycznych.
 */
public class BMIGraphFragment extends Fragment {

    /**
     * Tworzy i zwraca widok wykresu BMI.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bmi_graph, container, false);

        LineChart chart = view.findViewById(R.id.bmiChart);

        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0, 24.5f));
        entries.add(new Entry(1, 24.8f));
        entries.add(new Entry(2, 25.0f));
        entries.add(new Entry(3, 24.9f));
        entries.add(new Entry(4, 25.1f));

        LineDataSet dataSet = new LineDataSet(entries, "BMI w czasie");
        dataSet.setColor(Color.BLUE);
        dataSet.setValueTextColor(Color.BLACK);
        dataSet.setLineWidth(2f);
        dataSet.setCircleRadius(4f);

        chart.setData(new LineData(dataSet));
        chart.getDescription().setEnabled(false);
        chart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        chart.getAxisRight().setEnabled(false);
        chart.invalidate();

        return view;
    }
}
