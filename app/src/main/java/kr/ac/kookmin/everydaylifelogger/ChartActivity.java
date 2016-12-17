package kr.ac.kookmin.everydaylifelogger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * Created by user on 2016-12-01.
 */

public class ChartActivity extends MemoActivity{

    ArrayList<String> staList;
    ArrayList<Integer> idxList;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        PieChart pieChart = (PieChart)findViewById((R.id.chart));

        ArrayList<Entry> entries = new ArrayList<>();

        /*
        entries.add(new Entry(3f, 0));
        entries.add(new Entry(2f, 1));
        entries.add(new Entry(4f, 2));
        entries.add(new Entry(2f, 3));
        entries.add(new Entry(1f, 4));
        */

        entries.add(new Entry((float)idxList.get(1), 0));
        entries.add(new Entry((float)idxList.get(2), 1));
        entries.add(new Entry((float)idxList.get(3), 2));
        entries.add(new Entry((float)idxList.get(4), 3));
        entries.add(new Entry((float)idxList.get(5), 4));


        PieDataSet dataset = new PieDataSet(entries, " < My Log >");

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("공부");
        labels.add("약속");
        labels.add("여가");
        labels.add("휴식");
        labels.add("상황목격");

        ArrayList<String> getAsType = getIntent().getStringArrayListExtra("종류");
        ArrayList<String> getTypeArr = getIntent().getStringArrayListExtra("총종류");


        for(int a=1; a < getAsType.size(); a++){
            String insertStats = getAsType.get(a);
            staList.add(insertStats);

            int numOfStats = 0;
            for(int b=0; b < getTypeArr.size(); b++){
                if(getAsType.get(a).equals(getTypeArr.get(b))){
                    numOfStats++;
                }
            }
            float percent = Float.parseFloat(String.valueOf(numOfStats))/Float.parseFloat(String.valueOf(getTypeArr.size()));
            insertStats = (percent*100)+"%";
            staList.add(insertStats);

            idxList.add(Integer.parseInt(staList.get(a)));
        }



        PieData data = new PieData(labels, dataset);
        dataset.setColors(ColorTemplate.COLORFUL_COLORS); //
        pieChart.setDescription("Life Logger");
        pieChart.setData(data);
        pieChart.setCenterTextSizePixels(90);

        pieChart.animateY(5000);

        pieChart.saveToGallery("/sd/mychart.jpg", 85);

    }
}
