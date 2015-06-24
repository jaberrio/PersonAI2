package org.jaberrio.personai2;

import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;

public class AddTextBookField extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewRoot = inflater.inflate(R.layout.fragment_add_text_book_field, container, false);

        RefreshViews refreshViews = new RefreshViews();
        refreshViews.infoRefresh(viewRoot.getRootView(),getActivity().getApplicationContext());

        NumberPicker numberPicker = (NumberPicker)viewRoot.findViewById(R.id.numberPickerPeriod);

        numberPicker.getValue();

        return viewRoot;
    }

}