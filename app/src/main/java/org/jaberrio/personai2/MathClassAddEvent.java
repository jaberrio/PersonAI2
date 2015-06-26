//This work is licensed under the Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License.
//        To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.


package org.jaberrio.personai2;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class MathClassAddEvent extends Fragment {

    View viewRoot;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewRoot = inflater.inflate(R.layout.math_add_event, container, false);

        getActivity().setTitle("Period One: Math");

        final ImageButton textBook = (ImageButton) viewRoot.findViewById(R.id.textBook);
        final ImageButton workbook = (ImageButton) viewRoot.findViewById(R.id.workBook);
        final ImageButton mathproblem = (ImageButton) viewRoot.findViewById(R.id.mathProblem);
        final Button addCustomFieldOne = (Button) viewRoot.findViewById(R.id.addCustomFieldOne);
        final Button addCustomFieldTwo = (Button) viewRoot.findViewById(R.id.addCustomFieldTwo);
        final ImageButton other = (ImageButton) viewRoot.findViewById(R.id.other);
        final ImageButton afterSchool = (ImageButton) viewRoot.findViewById(R.id.afterSchool);
        final ImageButton reminder = (ImageButton) viewRoot.findViewById(R.id.reminder);
        final ImageButton event = (ImageButton) viewRoot.findViewById(R.id.event);

        View.OnClickListener oStartListener = new View.OnClickListener() {
            public void onClick(View v) {

                FragmentManager fm = getFragmentManager();
                FragmentTransaction fmtrans = fm.beginTransaction();

                switch (v.getId()) {
                    case R.id.textBook:

                        AddTextBookField addTextBookField = new AddTextBookField();
                        fmtrans.replace(android.R.id.content, addTextBookField);
                        fmtrans.commit();

                        break;
                    case R.id.workBook:

                        break;
                    case R.id.mathProblem:

                        addTextBookField = new AddTextBookField();
                        fmtrans.replace(android.R.id.content, addTextBookField);
                        fmtrans.commit();

                        break;
                    case R.id.addCustomFieldOne:

                        break;
                    case R.id.addCustomFieldTwo:

                        break;
                    case R.id.other:

                        break;
                    case R.id.afterSchool:

                        break;
                    case R.id.reminder:

                        break;
                    case R.id.event:

                        break;
                }

            }
        };

        textBook.setOnClickListener(oStartListener);
        workbook.setOnClickListener(oStartListener);
        mathproblem.setOnClickListener(oStartListener);
        addCustomFieldOne.setOnClickListener(oStartListener);
        addCustomFieldTwo.setOnClickListener(oStartListener);
        other.setOnClickListener(oStartListener);
        afterSchool.setOnClickListener(oStartListener);
        reminder.setOnClickListener(oStartListener);
        event.setOnClickListener(oStartListener);


        return viewRoot;
    }
}
