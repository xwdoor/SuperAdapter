package net.xwdoor.superadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.TextView;

import net.xwdoor.superadapter.adapter.IViewItemBindData;
import net.xwdoor.superadapter.adapter.SuperAdapter;
import net.xwdoor.superadapter.adapter.SuperViewHolder;
import net.xwdoor.superadapter.mock.MockModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IViewItemBindData<MockModel> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        GridView lvList = (GridView) findViewById(R.id.lv_list);
        SuperAdapter<MockModel> adapter = new SuperAdapter<>(this,models,R.layout.item_list);
        adapter.setItemBindListener(this);
        lvList.setAdapter(adapter);
    }

    @Override
    public void onBindItem(SuperViewHolder holder, int viewType, int position, MockModel mockModel) {
        TextView tvName = holder.getView(R.id.tv_name);
        tvName.setText(mockModel.getName());
    }

    private List<String> names = new ArrayList<>();
    private List<MockModel> models = new ArrayList<>();

    private void initData() {
        names.add("John");
        names.add("Michelle");
        names.add("Amy");
        names.add("Kim");
        names.add("Mary");
        names.add("David");
        names.add("Sunny");
        names.add("James");
        names.add("Maria");
        names.add("Betty");
        names.add("Brian");
        names.add("Candy");
        names.add("Charles");
        names.add("Vicky");
        names.add("James");

        int size = names.size();
        for (int i = 0; i < size; i++) {
            models.add(new MockModel(names.get(i), 16 + (int) (Math.random() * 24)));
        }
    }
}
