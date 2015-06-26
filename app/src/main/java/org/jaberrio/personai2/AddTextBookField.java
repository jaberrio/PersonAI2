//This work is licensed under the Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License.
//        To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.

package org.jaberrio.personai2;

import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AddTextBookField extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewRoot = inflater.inflate(R.layout.fragment_add_text_book_field, container, false);

        RefreshViews refreshViews = new RefreshViews();
        refreshViews.infoRefresh(viewRoot.getRootView(), getActivity().getApplicationContext());

        final NumberPicker numberPicker = (NumberPicker) viewRoot.findViewById(R.id.numberPickerPeriod);
        final TextView periodText = (TextView) viewRoot.findViewById(R.id.periodText);
        final DataBaseManager dataBaseManager = new DataBaseManager();
        final SeekBar seekBar = (SeekBar)viewRoot.findViewById(R.id.seekBar);
        final TextView numberSelOdd = (TextView)viewRoot.findViewById(R.id.numberOdd);

        numberSelOdd.setText("Odd");

        getActivity().setTitle("Period One: Math: Textbook");

        numberPicker.setMaxValue(5000);
        numberPicker.setMinValue(0);
        try {

            if ((dataBaseManager.tempGetCurrentEvent(DataBaseManager.FieldTypes.PAGE_NUMBER, getActivity().getApplicationContext())) != null) {
                numberPicker.setValue(Integer.parseInt(dataBaseManager.tempGetCurrentEvent(DataBaseManager.FieldTypes.PAGE_NUMBER, getActivity().getApplicationContext())));
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                switch (progress){
                    case 0:
                        numberSelOdd.setText("Odd");
                        dataBaseManager.tempSaveCurrentEvent(DataBaseManager.FieldTypes.EVENODDALL,
                                "Odd",getActivity().getApplicationContext());
                        break;
                    case 1:
                        numberSelOdd.setText("All");
                        dataBaseManager.tempSaveCurrentEvent(DataBaseManager.FieldTypes.EVENODDALL,
                                "All",getActivity().getApplicationContext());
                        break;
                    case 2:
                        numberSelOdd.setText("Even");
                        dataBaseManager.tempSaveCurrentEvent(DataBaseManager.FieldTypes.EVENODDALL,
                                "Even",getActivity().getApplicationContext());
                        break;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        numberPicker.setWrapSelectorWheel(false);



        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

                dataBaseManager.tempSaveCurrentEvent(DataBaseManager.FieldTypes.PAGE_NUMBER,
                        String.valueOf(newVal),
                        getActivity().getApplicationContext());

                periodText.setText("Page Number: " + dataBaseManager.tempGetCurrentEvent(DataBaseManager.FieldTypes.PAGE_NUMBER,
                        getActivity().getApplicationContext()));


            }
        });

        return viewRoot;
    }

}