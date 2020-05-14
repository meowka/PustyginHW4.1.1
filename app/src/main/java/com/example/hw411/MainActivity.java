package com.example.hw411;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    final String TEXT_1 = "text1";
    final String TEXT_2 = "text2";
    ListView lvSimple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Map<String, String>> values = prepareContent();

        BaseAdapter listContentAdapter = createAdapter(values);

        lvSimple.setAdapter(listContentAdapter);

    }

    @NonNull
    private BaseAdapter createAdapter(List<Map<String, String>> values) {
        String [] from = {TEXT_1, TEXT_2};
        int[] to = {R.id.textView, R.id.textView2};
         SimpleAdapter sAdapter = new SimpleAdapter(this, values, R.layout.item,
                from, to);
        lvSimple = (ListView) findViewById(R.id.list);
        return sAdapter;
    }

    @NonNull
    private List<Map<String, String>> prepareContent() {
        String[] arrayContent = getString(R.string.large_text).split("\n\n");
        List<Map<String, String>>list = new ArrayList<>();
        Map<String, String>mapList;
        for (int i = 0; i <arrayContent.length ; i++) {
            mapList = new HashMap<>();
            mapList.put(TEXT_1,arrayContent[i]);
            mapList.put(TEXT_2, String.valueOf(arrayContent[i].length()));
            list.add(mapList);
        }
        return list;
    }
}

