package com.android.baikt3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.android.baikt3.my_interface.IClickItemLanguagueListener;

import org.intellij.lang.annotations.Language;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private LanguaguesAdapter languaguesAdapter;
    RecyclerView languageRV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handleRecycleView();

    }

    private void handleRecycleView() {
        languageRV = (RecyclerView) findViewById(R.id.languageRV);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        languageRV.setLayoutManager(layoutManager);
        languageRV.setHasFixedSize(true);
        languaguesAdapter = new LanguaguesAdapter(getData(), MainActivity.this, new IClickItemLanguagueListener() {
            @Override
            public void onClickItemLanguague(Languague languague) {
                handleClickItemLanguagueRV(languague);
            }
        });
        languageRV.setAdapter(languaguesAdapter);
    }

    private List<Languague> getData() {
        List<Languague> languagues = new ArrayList<>();
        languagues.add(new Languague("Dế Mèn phiêu lưu ký", " Nội dung truyện là chuyến phiêu lưu kỳ thú và đầy sóng gió của Dế Mèn, cùng tình bạn với Dế Trũi, Dế Choắt, Châu Chấu Voi... để bao người được tắm mình trong sự sáng tạo, bay bổng. "));
        languagues.add(new Languague("Vợ chồng A Phủ", "Vợ chồng A Phủ là một trong những tác phẩm quan trọng trong chương trình Ngữ văn của teen phổ thông. Qua hình ảnh của Mị và A Phủ, tác phẩm ngợi ca phẩm chất, khát vọng tự do của con người lao động miền núi."));
        languagues.add(new Languague("Chiều Chiều", "Ta thấy hình ảnhTô Hoài như chính lão Ngải kia trong Chiều chiều- ngày ngày vẫn bên ấm nước chè vò , ngồi bên bụi tre lép,  mắt nhìn xa xăm, nhớ chuyện cũ, người xưa mặc thế thái nhân tình dù có đổi thay"));
        languagues.add(new Languague("Sổ tay viết văn", "Song tuy viết về nhưng đau thương, mất mát mà chiến tranh gây ra, tác giả vẫn giữ vững niềm tin ở tính cách Nga kiên cường cũng như lòng tin ở cuộc sống bao "));
        languagues.add(new Languague("Giữ gìn 36 phố phường", "Song tuy viết về nhưng đau thương, mất mát mà chiến tranh gây ra, tác giả vẫn giữ vững niềm tin ở tính cách Nga kiên cường cũng như lòng tin ở cuộc sống bao "));
        return languagues;
    }

    private void handleClickItemLanguagueRV(Languague language) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("language",language);
        startActivity(intent);
    }
}