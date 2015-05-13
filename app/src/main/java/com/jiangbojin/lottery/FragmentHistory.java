package com.jiangbojin.lottery;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * Created by yerongtian on 2015/5/12.
 */
class OneItem
{
    String date;
    String type;
    String input;
    String result;
    String output;
    public OneItem(String pdate,String ptype,String pinput,String presult,String poutput)
    {
        date = pdate;
        input = pinput;
        type = ptype;
        result = presult;
        output = poutput;
    }
    public OneItem(){}
}
public class FragmentHistory extends Fragment {
    private Vector<OneItem> recordList;
    private String oneRecord[];
    private String ColumnStr[];
    private int ColumnId[];
    private GridView myGridView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_history,null);
        oneRecord = new String[]{"投注日期","投注金额","玩法","战绩","净盈亏"};
        ColumnStr = new String[]{"ItemText"};
        ColumnId  = new int[]{R.id.ItemText};
        myGridView = (GridView)view.findViewById(R.id.id_gridview);
        SimpleAdapter adapter = new SimpleAdapter(getActivity(),getInitData(),R.layout.fragment_history_first_item,ColumnStr,ColumnId);
        myGridView.setAdapter(adapter);
        return view;
    }
    public FragmentHistory()
    {
        super();
    }
    private List<Map<String,String>> getInitData()
    {
        List<Map<String,String>> listData = new ArrayList<Map<String,String>>();

        for (int i = 0 ; i < 5; i++)
        {
            Map<String, String> map = new HashMap<String, String>();
            map.put("ItemText",oneRecord[i]);
            listData.add(map);
        }
        for(int i=0;i<3;i++){
            String items[]={ "语文", "数学","英语","体育","计算机"};
            for (String strText:items) {
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("ItemText",strText);
                listData.add(map);
            }
        }
        return listData;
    }
}
