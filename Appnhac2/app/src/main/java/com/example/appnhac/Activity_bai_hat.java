package com.example.appnhac;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Activity_bai_hat extends AppCompatActivity {
    TextView txt_tencasi, txt_tenbaihatdangphat, txt_tgdangphat, txt_tgketthuc;
    ImageButton IMGB_play, IMGB_next, IMGB_re;
    ListView listView_baihat;
    SeekBar seekBar;

    int vitri;

    ArrayList<list_baihat> list_baihats;

    MediaPlayer player = new MediaPlayer();

    @SuppressLint("WrongViewCast")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai_hat);

        Intent intent = getIntent();
        int vt = intent.getIntExtra("position", 0);
        String cs = intent.getStringExtra("tencasi");

        txt_tencasi = (TextView) findViewById(R.id.txt_casi);
        txt_tenbaihatdangphat = (TextView) findViewById(R.id.txt_dang_phat);
        txt_tgdangphat = (TextView) findViewById(R.id.txt_time_play);
        txt_tgketthuc = (TextView) findViewById(R.id.txt_time_out);
        IMGB_next = (ImageButton) findViewById(R.id.bt_next);
        IMGB_play = (ImageButton) findViewById(R.id.bt_pause);
        IMGB_re = (ImageButton) findViewById(R.id.bt_re);

        listView_baihat = (ListView) findViewById(R.id.list_nhac);
        seekBar = (SeekBar) findViewById(R.id.seebar);

        txt_tencasi.setText("Ca sĩ: " + cs);

        list_baihats = new ArrayList<list_baihat>();

        switch (vt){
            case 0:
                list_baihats.add(new list_baihat("Điều anh biết",time(R.raw.chidan_dieu_anh_biet),R.raw.chidan_dieu_anh_biet));
                list_baihats.add(new list_baihat("Làm vợ anh nhé",time(R.raw.chidan_lam_vo_anh_nhe),R.raw.chidan_lam_vo_anh_nhe));
                list_baihats.add(new list_baihat("Sự thật sau một lời hứa", time(R.raw.chidan_su_that_sau_mot_loi_hua), R.raw.chidan_su_that_sau_mot_loi_hua));
                break;
            case 1:
                list_baihats.add(new list_baihat("Bức tranh từ nước mắt", time(R.raw.siro_buc_tranh_tu_nuoc_mat), R.raw.siro_buc_tranh_tu_nuoc_mat));
                list_baihats.add(new list_baihat("Chỉ có một người để yêu trên thế gian", time(R.raw.siro_chi_co_mot_nguoi_de_yeu_tren_the_gian), R.raw.siro_chi_co_mot_nguoi_de_yeu_tren_the_gian));
                list_baihats.add(new list_baihat("Dây dức nổi đau", time(R.raw.siro_day_duc_noi_dau), R.raw.siro_day_duc_noi_dau));
                list_baihats.add(new list_baihat("Dưới những cơn mưa",time(R.raw.siro_duoi_nhung_con_mua),  R.raw.siro_duoi_nhung_con_mua));
                list_baihats.add(new list_baihat("Giấc mơ củ anh",time(R.raw.siro_giac_mo_cua_anh), R.raw.siro_giac_mo_cua_anh));
                list_baihats.add(new list_baihat("Gương mặt lạ lẵm",time(R.raw.siro_guong_mat_la_lam), R.raw.siro_guong_mat_la_lam));
                list_baihats.add(new list_baihat("Không cần thêm một ai nữa",time(R.raw.siro_khong_can_them_mot_ai_nua),R.raw.siro_khong_can_them_mot_ai_nua));
                list_baihats.add(new list_baihat("Lặng lẽ tổn thương",time(R.raw.siro_lang_le_ton_thuong),R.raw.siro_lang_le_ton_thuong));
                list_baihats.add(new list_baihat("Lắng nghe nước mắt",time(R.raw.siro_lang_nghe_nuoc_mat),R.raw.siro_lang_nghe_nuoc_mat));
                list_baihats.add(new list_baihat("Người con gái anh không thể quên",time(R.raw.siro_nguoi_con_gai_anh_khong_the_quen),R.raw.siro_nguoi_con_gai_anh_khong_the_quen));
                list_baihats.add(new list_baihat("Phai chi lúc trước anh sai",time(R.raw.siro_phai_chi_luc_truoc_anh_sai), R.raw.siro_phai_chi_luc_truoc_anh_sai));
                list_baihats.add(new list_baihat("Sống trong nổi nhớ",time(R.raw.siro_song_trong_noi_nho), R.raw.siro_song_trong_noi_nho));
                list_baihats.add(new list_baihat("Thời gian của tình yêu",time(R.raw.siro_thoi_gian_cua_tinh_yeu), R.raw.siro_thoi_gian_cua_tinh_yeu));
                list_baihats.add(new list_baihat("Tiếng sét trong anh",time(R.raw.siro_tieng_set_trong_anh),R.raw.siro_tieng_set_trong_anh));
                list_baihats.add(new list_baihat("Tìm được nhau khó thế nào",time(R.raw.siro_tim_duoc_nhau_kho_the_nao),R.raw.siro_tinh_yeu_chap_va));
                list_baihats.add(new list_baihat("Vô hình trong em",time(R.raw.siro_vo_hinh_trong_em),R.raw.siro_vo_hinh_trong_em));
                break;
            case 2:
                list_baihats.add(new list_baihat("Bí mật của hạnh phúc",time(R.raw.ngokienhuy_bi_mat_cua_hanh_phuc),R.raw.ngokienhuy_bi_mat_cua_hanh_phuc));
                list_baihats.add(new list_baihat("Chúc em ngủ ngon",time(R.raw.ngokienhuy_chuc_em_ngu_ngon),R.raw.ngokienhuy_chuc_em_ngu_ngon));
                list_baihats.add(new list_baihat("Chuyện tình lá cây và gió",time(R.raw.ngokienhuy_chuyen_tinh_la_cay_va_gio),R.raw.ngokienhuy_chuyen_tinh_la_cay_va_gio));
                list_baihats.add(new list_baihat("Định mệnh ta gập nhau",time(R.raw.ngokienhuy_dinh_menh_ta_gap_nhau),R.raw.ngokienhuy_dinh_menh_ta_gap_nhau));
                list_baihats.add(new list_baihat("Giả vờ yêu",time(R.raw.ngokienhuy_gia_vo_yeu),R.raw.ngokienhuy_gia_vo_yeu));
                list_baihats.add(new list_baihat("Vội vã yêu vội vã rời",time(R.raw.ngokienhuy_vo_va_yeu_voi_va_roi),R.raw.ngokienhuy_vo_va_yeu_voi_va_roi));
                break;
            case 3:
                list_baihats.add(new list_baihat("Đừng nói",time(R.raw.dinhdung_dung_noi),R.raw.dinhdung_dung_noi));
                list_baihats.add(new list_baihat("Sai lầm của anh",time(R.raw.dinhdung_sai_lam_cua_anh),R.raw.dinhdung_sai_lam_cua_anh));
                list_baihats.add(new list_baihat("Tình yêu tuyệt vời",time(R.raw.dinhdung_tinh_yeu_tuyet_voi),R.raw.dinhdung_tinh_yeu_tuyet_voi));
                list_baihats.add(new list_baihat("Tránh duyên",time(R.raw.dinhdung_tranh_duyen), R.raw.dinhdung_tranh_duyen));
                break;
            case 4:
                list_baihats.add(new list_baihat("Rời bỏ",time(R.raw.hoaminzy_roi_bo),R.raw.hoaminzy_roi_bo));
                list_baihats.add(new list_baihat("Chấp nhận",time(R.raw.hoaminzy_chap_nhan), R.raw.hoaminzy_chap_nhan));
                list_baihats.add(new list_baihat("Chỉ là tình cờ",time(R.raw.hoaminzy_chi_la_tinh_co),R.raw.hoaminzy_chi_la_tinh_co));
                list_baihats.add(new list_baihat("Tự nhiên buồn ",time(R.raw.hoaminzy_tu_nhien_buon),R.raw.hoaminzy_tu_nhien_buon));
                list_baihats.add(new list_baihat("Vì anh là của em ",time(R.raw.hoaminzy_vi_anh_la_cua_em),R.raw.hoaminzy_vi_anh_la_cua_em));
                break;
            case 5:
                list_baihats.add(new list_baihat("Anh nhớ em người yêu cũ",time(R.raw.minhvuong_m4u_anh_nho_em_nguoi_yeu_cu_cua),R.raw.minhvuong_m4u_anh_nho_em_nguoi_yeu_cu_cua));
                list_baihats.add(new list_baihat("Anh vẫn còn yêu em",time(R.raw.minhvuong_m4u_anh_van_con_yeu_em),R.raw.minhvuong_m4u_anh_van_con_yeu_em));
                list_baihats.add(new list_baihat("Chờ định mệnh mĩm cười",time(R.raw.minhvuong_m4u_cho_dinh_menh_mim_cuoi),R.raw.minhvuong_m4u_cho_dinh_menh_mim_cuoi));
                list_baihats.add(new list_baihat("Đừng làm anh đau",time(R.raw.minhvuong_m4u_dung_lam_anh_dau),R.raw.minhvuong_m4u_dung_lam_anh_dau));
                list_baihats.add(new list_baihat("Nỗi đau xót xa",time(R.raw.minhvuong_m4u_noi_dau_xot_xa),R.raw.minhvuong_m4u_noi_dau_xot_xa));
                break;
            case 6:
                list_baihats.add(new list_baihat("Góc nhỏ trong tim",time(R.raw.khoimy_goc_nho_trong_tim),R.raw.khoimy_goc_nho_trong_tim));
                list_baihats.add(new list_baihat("Vì sao",time(R.raw.khoimy_vi_sao),R.raw.khoimy_vi_sao));
                list_baihats.add(new list_baihat("Gửi cho anh",time(R.raw.khoimy_gui_cho_anh),R.raw.khoimy_gui_cho_anh));
                list_baihats.add(new list_baihat("Người lạ thoáng qua",time(R.raw.khoimy_nguoi_la_thoang_qua),R.raw.khoimy_nguoi_la_thoang_qua));
                list_baihats.add(new list_baihat("Người yêu cũ", time(R.raw.khoimy_nguoi_yeu_cu),R.raw.khoimy_nguoi_yeu_cu));
                break;
            case 7:
                list_baihats.add(new list_baihat("Ai đưa em về",time(R.raw.duonghoangyen_ai_dua_em_ve),R.raw.duonghoangyen_ai_dua_em_ve));
                list_baihats.add(new list_baihat("Dù chỉ là",time(R.raw.duonghoangyen_du_chi_la),R.raw.duonghoangyen_du_chi_la));
                list_baihats.add(new list_baihat("Em một mình quen rồi",time(R.raw.duonghoangyen_em_mot_minh_quen_roi),R.raw.duonghoangyen_em_mot_minh_quen_roi));
                list_baihats.add(new list_baihat("Tình cũ bao giờ cũng tốt hơn",time(R.raw.duonghoangyen_tinh_cu_bao_gio_cung_tot_hon),R.raw.duonghoangyen_tinh_cu_bao_gio_cung_tot_hon));
                list_baihats.add(new list_baihat("Không phải em đúng không",time(R.raw.duonghoangyen_khong_phai_em_dung_khong),R.raw.duonghoangyen_khong_phai_em_dung_khong));
                break;
            case 8:
                list_baihats.add(new list_baihat("Cất giấu kí ức",time(R.raw.dongnhi_cat_giau_ki_uc),R.raw.dongnhi_cat_giau_ki_uc));
                list_baihats.add(new list_baihat("Nắm tay anh nhé",time(R.raw.dongnhi_nam_tay_anh_nhe),R.raw.dongnhi_nam_tay_anh_nhe));
                list_baihats.add(new list_baihat("Ta là của nhau",time(R.raw.dongnhi_ta_la_cua_nhau),R.raw.dongnhi_ta_la_cua_nhau));
                list_baihats.add(new list_baihat("Yêu là cưới",time(R.raw.dongnhi_yeu_la_cuoi),R.raw.dongnhi_yeu_la_cuoi));
                break;
        }

        Adapter_listbaihat adapter_listbaihat = new Adapter_listbaihat(Activity_bai_hat.this, R.layout.list_baihat, list_baihats);
        listView_baihat.setAdapter(adapter_listbaihat);
        khoitao();
        player.start();
        IMGB_play.setImageResource(R.drawable.pause);
        thoigian_hientai();
        listView_baihat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (player.isPlaying()) {
                    player.stop();
                }
                else {
                    vitri = position;
                    khoitao();
                }
                IMGB_play.setImageResource(R.drawable.pause);
            }
        });

        IMGB_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(player.isPlaying()) {
                    player.pause();
                    IMGB_play.setImageResource(R.drawable.play);
                }
                else {
                    player.start();
                    IMGB_play.setImageResource(R.drawable.pause);
                }
            }
        });
        IMGB_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vitri++;
                if (vitri > (list_baihats.size() -1)) {
                    vitri = 0;
                }
                player.stop();
                khoitao();
            }
        });
        IMGB_re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vitri--;
                if (vitri < 0) {
                    vitri = list_baihats.size()-1;
                }
                player.stop();
                khoitao();
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                player.seekTo(seekBar.getProgress());
            }
        });
    }

    void thoigian_hientai() {
        final Handler handler = new Handler();
        boolean b = handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
                txt_tgdangphat.setText(simpleDateFormat.format(player.getCurrentPosition()));
                seekBar.setProgress(player.getCurrentPosition());
                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        vitri++;
                        if (vitri > list_baihats.size() - 1) {
                            vitri = 0;
                            player.stop();
                            IMGB_play.setImageResource(R.drawable.play);
                        }
                        else {
                            player.stop();
                            khoitao();
                            player.start();
                        }
                    }
                });
                handler.postDelayed(this, 500);
            }
        }, 100);

    }

    private void khoitao() {
        player = MediaPlayer.create(Activity_bai_hat.this, list_baihats.get(vitri).bathat);
        txt_tenbaihatdangphat.setText("Đang phát: " + list_baihats.get(vitri).tenbaihat);
        txt_tgketthuc.setText(time(list_baihats.get(vitri).bathat));
        seekBar.setMax(player.getDuration());
        player.start();
    }

    private  String time(int baihat) {
        String t;
        MediaPlayer player = new MediaPlayer();
        player = MediaPlayer.create(Activity_bai_hat.this, baihat);
        SimpleDateFormat tg = new SimpleDateFormat("mm:ss");
        t = tg.format(player.getDuration());
        return t;
    }

    @Override
    protected void onStop() {
        player.stop();
        super.onStop();
    }

}