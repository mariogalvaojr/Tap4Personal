package com.example.mriogalvojnior.tap4personal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by Mário Galvão Júnior on 10/06/2016.
 */
public class DatePickerDialog extends DialogFragment implements View.OnClickListener, DatePicker.OnDateChangedListener {

    private DatePicker datePicker;
    private Button button;
    private String datecontrato;
    private GetDateListener listener;

    public static final String TAG = DatePickerDialog.class.getSimpleName();

    public void setListener(GetDateListener listener) {
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.date_picker, null);}

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        datePicker = (DatePicker) view.findViewById(R.id.date_picker);
        button = (Button) view.findViewById(R.id.btn_date_seleced);
        button.setOnClickListener(this);

        final Calendar calendar = Calendar.getInstance();
        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), this);

    }

    @Override
    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        datecontrato = String.valueOf(formatNumber(dayOfMonth) + "/" + formatNumber((monthOfYear + 1)) + "/" + year);
    }

    private String formatNumber(int number) {
        String formattedNumber = String.valueOf(number);
        if (number < 10) {
            formattedNumber = "0" + number;
        }
        return formattedNumber;
    }

    @Override
    public void onClick(View view) {
        if (datecontrato != null) {
            listener.onDateContratoSelected("" + datecontrato);
        } else {
            Toast.makeText(getActivity(), "Selecione a Data", Toast.LENGTH_SHORT).show();
        }
    }
}
