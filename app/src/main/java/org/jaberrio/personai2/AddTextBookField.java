package org.jaberrio.personai2;

import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AddTextBookField extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewRoot = inflater.inflate(R.layout.fragment_add_text_book_field, container, false);

        RefreshViews refreshViews = new RefreshViews();
        refreshViews.infoRefresh(viewRoot.getRootView(),getActivity().getApplicationContext());

        final NumberPicker numberPicker = (NumberPicker)viewRoot.findViewById(R.id.numberPickerPeriod);
        final TextView periodText = (TextView)viewRoot.findViewById(R.id.periodText);

        numberPicker.setMaxValue(8);
        numberPicker.setMinValue(1);
        numberPicker.setValue(1);
        numberPicker.setWrapSelectorWheel(false);
        final DataBaseManager dataBaseManager = new DataBaseManager();

        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

                dataBaseManager.tempSaveCurrentEvent(DataBaseManager.FieldTypes.PERIOD,
                        String.valueOf(newVal),
                        getActivity().getApplicationContext());

                periodText.setText("Period: " + dataBaseManager.tempGetCurrentEvent(DataBaseManager.FieldTypes.PERIOD,
                        getActivity().getApplicationContext()));


            }
        });

        return viewRoot;
    }

}