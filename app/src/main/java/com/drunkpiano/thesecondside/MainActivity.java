package com.drunkpiano.thesecondside;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<ApplicationInfo> mAppList;
    private AppAdapter mAdapter;
    private SwipeMenuListView mListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_new);
        getSupportActionBar().hide();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(Color.parseColor("#303F9F"));

        }
        mAppList = getPackageManager().getInstalledApplications(0);
//        mAppList.add("String1");
//        mAppList.add("String2");
//        mAppList.add("String3");
//        mAppList.add("String4");
//        mAppList.add("String5");
//        mAppList.add("String6");

        mListView = (SwipeMenuListView) findViewById(R.id.new_listView);
        mAdapter = new AppAdapter();
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new MyItemClickLisener());

        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                // create "open" item
                SwipeMenuItem openItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                openItem.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,
                        0xCE)));
                // set item width
                openItem.setWidth(dp2px(90));
                // set item title
                openItem.setTitle("Open");
                // set item title fontsize
                openItem.setTitleSize(18);
                // set item title font color
                openItem.setTitleColor(Color.WHITE);
                // add to menu
                menu.addMenuItem(openItem);

                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                        0x3F, 0x25)));
                // set item width
                deleteItem.setWidth(dp2px(90));
                // set a icon
                deleteItem.setIcon(R.drawable.drunkpiano_ic_delete);
                // add to menu
                menu.addMenuItem(deleteItem);
            }
        };

        // set creator
        mListView.setMenuCreator(creator);

        mListView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index) {
                    case 0:
                        // open
                        break;
                    case 1:
                        // delete
                        break;
                }
                // false : close the menu; true : not close the menu
                return false;
            }
        });

        // Right
        mListView.setSwipeDirection(SwipeMenuListView.DIRECTION_RIGHT);

        // Left
        mListView.setSwipeDirection(SwipeMenuListView.DIRECTION_LEFT);
    }

    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }


    class AppAdapter extends BaseSwipListAdapter {

        @Override
        public int getCount() {
            return mAppList.size();
        }

        @Override
        public ApplicationInfo getItem(int position) {
            return mAppList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = View.inflate(getApplicationContext(),
                        R.layout.item_list_app, null);
                new ViewHolder(convertView);
            }
            //获取ViewHolder
            ViewHolder holder = (ViewHolder) convertView.getTag();
            if (position == 0) {
                holder.iv_icon.setImageDrawable(getResources().getDrawable(R.drawable.drunkpiano_baitiao));
                holder.tv_name.setText("这是一封信");
            } if (position == 1) {
                holder.iv_icon.setImageDrawable(getResources().getDrawable(R.drawable.corner_logo));
                holder.tv_name.setText("你好,京东钱包");
            } if (position == 2) {
                holder.iv_icon.setImageDrawable(getResources().getDrawable(R.drawable.drunkpiano_duobao));
                holder.tv_name.setText("你好,京东钱包");
            } if (position == 3) {
                holder.iv_icon.setImageDrawable(getResources().getDrawable(R.drawable.drunkpiano_baitiao));
                holder.tv_name.setText("你好,京东钱包");
            } if (position == 4) {
                holder.iv_icon.setImageDrawable(getResources().getDrawable(R.drawable.drunkpiano_duobao));
                holder.tv_name.setText("你好,京东钱包");
            } if (position == 5) {
                holder.iv_icon.setImageDrawable(getResources().getDrawable(R.drawable.drunkpiano_baitiao));
                holder.tv_name.setText("你好,京东钱包");
            }
// else {
//                //这个else是position非0的情况
//
//                //按照position获取安装程序的item,准备从中读取Icon和Label
//                ApplicationInfo item = getItem(position);
//                holder.iv_icon.setImageDrawable(item.loadIcon(getPackageManager()));
//                holder.tv_name.setText(item.loadLabel(getPackageManager()));
//
//
//                holder.iv_icon.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(MainActivity.this, "iv_icon_click", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                holder.tv_name.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(MainActivity.this, "iv_icon_click", Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }


            return convertView;
        }

        class ViewHolder {
            ImageView iv_icon;
            TextView tv_name;

            public ViewHolder(View view) {
                iv_icon = (ImageView) view.findViewById(R.id.iv_icon);
                tv_name = (TextView) view.findViewById(R.id.tv_name);
                view.setTag(this);
            }
        }

        @Override
        public boolean getSwipEnableByPosition(int position) {
//            if(position % 2 == 0){
//                return false;
//            }
            return true;
        }
    }


    //item点击事件
    private class MyItemClickLisener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (position == 0) {
//                getFragmentManager().beginTransaction().replace(R.id.activity_main_container,new LetterFragment()).commit();
                Toast.makeText(MainActivity.this, "这是一封信", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,LetterActivity.class);
                startActivity(intent);
            }
        }
    }

}