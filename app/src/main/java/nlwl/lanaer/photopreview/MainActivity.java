package nlwl.lanaer.photopreview;

import androidx.appcompat.app.AppCompatActivity;
import nlwl.lanaer.ui.pagerpreviewlib.PagerPreviewActivity;
import nlwl.lanaer.ui.pagerpreviewlib.model.PreviewMoel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<PreviewMoel> datas = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    datas.add(new PreviewMoel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1579068097259&di=1d1fb10e56a9ef051ed890e49207ccc1&imgtype=0&src=http%3A%2F%2F2e.zol-img.com.cn%2Fproduct%2F101%2F90%2FceyxraHEIJFjw.jpg"));
                }

                Intent intent = new Intent(MainActivity.this, PagerPreviewActivity.class);
                intent.putExtra("datas", (Serializable) datas);
                intent.putExtra("postion", 0);

                MainActivity.this.startActivity(intent);
            }
        });
    }
}
