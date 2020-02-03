package com.mad.grubx.Tabs;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.mad.grubx.R;
import com.shuhart.stepview.StepView;
import java.util.ArrayList;
import static androidx.constraintlayout.widget.Constraints.TAG;

public class Completed extends Fragment {
    View view;
    StepView stepView;

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.completed, container, false);


        init();

        stepView.getState()
                .selectedTextColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryDark))
                .animationType(StepView.ANIMATION_CIRCLE)
                .selectedCircleColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryDark))
                .doneStepLineColor(ContextCompat.getColor(getContext(), R.color.sky_blue))
                .selectedStepNumberColor(ContextCompat.getColor(getContext(), R.color.white))
                // You should specify only stepsNumber or steps array of strings.
                // In case you specify both steps array is chosen.
                .steps(new ArrayList<String>() {{
                    add("");
                    add("");
                    add("");
                    add("");
                }})
                // You should specify only steps number or steps array of strings.
                // In case you specify both steps array is chosen.
                .stepsNumber(4)
                .animationDuration(getResources().getInteger(android.R.integer.config_shortAnimTime))
                // other state methods are equal to the corresponding xml attributes
                .commit();

        stepView.go(3, true);

        stepView.done(true);


        return view;
    }

    private void init() {
        stepView = view.findViewById(R.id.completed_step_view);
    }
}
