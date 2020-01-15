package nlwl.lanaer.ui.pagerpreviewlib;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import nlwl.lanaer.ui.pagerpreviewlib.custom.PreviewViewPager;
import nlwl.lanaer.ui.pagerpreviewlib.fragment.PictureImagePreviewFragment;
import nlwl.lanaer.ui.pagerpreviewlib.model.PreviewMoel;


public class PagerPreviewActivity extends AppCompatActivity {
    private ImageButton left_back;
    private TextView tv_title;
    private PreviewViewPager viewPager;
    private List<PreviewMoel> images = new ArrayList<>();
    private int position = 0;
    private SimpleFragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_preview);
        overridePendingTransition(R.anim.p_in, 0);
        tv_title = (TextView) findViewById(R.id.picture_title);
        left_back = (ImageButton) findViewById(R.id.left_back);
        viewPager = (PreviewViewPager) findViewById(R.id.preview_pager);
        position = getIntent().getIntExtra("postion", 0);
        images = (List<PreviewMoel>) getIntent().getSerializableExtra("datas");
        left_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PagerPreviewActivity.this.finish();
            }
        });
        initViewPageAdapterData();
    }


    private void initViewPageAdapterData() {
        tv_title.setText(position + 1 + "/" + images.size());
        adapter = new SimpleFragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(position);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tv_title.setText(position + 1 + "/" + images.size());
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }


    public class SimpleFragmentAdapter extends FragmentPagerAdapter {

        public SimpleFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            PreviewMoel media = images.get(position);
            PictureImagePreviewFragment fragment = PictureImagePreviewFragment.getInstance(media);
            return fragment;
        }

        @Override
        public int getCount() {
            return images.size();
        }
    }


    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.p_out);
    }
}
