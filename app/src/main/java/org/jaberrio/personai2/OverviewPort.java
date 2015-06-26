//This work is licensed under the Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License.
//        To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.

package org.jaberrio.personai2;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class OverviewPort extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewRoot = inflater.inflate(R.layout.fragment_overview_port, container, false);

        viewRoot.setBackgroundColor(Color.rgb(255, 155, 93));

        return viewRoot;

    }


}
