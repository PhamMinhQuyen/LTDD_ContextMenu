package com.example.contextmenu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    Context context;
    ArrayList<CountriesModel> countriesData;
    CustomAdapter customAdapter;
    CountriesModel countriesModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;
        setContentView(R.layout.activity_main);

        //getviews
        listView = findViewById(R.id.listView);
        registerForContextMenu(listView);
        countriesData = new ArrayList<>();

        //add Countries Data
        populateCountriesData();
        customAdapter = new CustomAdapter(context,countriesData);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(context,countriesData.get(position).getTieuDe(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void populateCountriesData() {
        //country 1
        countriesModel = new CountriesModel();
        countriesModel.setId(1);
        countriesModel.setTieuDe("Hoa Hải Đường");
        countriesModel.setImage(R.drawable.jack);
        countriesModel.setTieuDePhu("Jack");
        countriesData.add(countriesModel);


        //country 2
        countriesModel = new CountriesModel();
        countriesModel.setId(1);
        countriesModel.setTieuDe("Bỏ Lỡ Một Người");
        countriesModel.setImage(R.drawable.blmn);
        countriesModel.setTieuDePhu("Lê Bảo Bình");
        countriesData.add(countriesModel);

        //country 3
        countriesModel = new CountriesModel();
        countriesModel.setId(1);
        countriesModel.setTieuDe("Ai Mang Cô Đơn Đi");
        countriesModel.setImage(R.drawable.amcdd);
        countriesModel.setTieuDePhu("K-ICM,APJ");
        countriesData.add(countriesModel);

        //country 4
        countriesModel = new CountriesModel();
        countriesModel.setId(1);
        countriesModel.setTieuDe("Mãi Mãi Không Phải Anh");
        countriesModel.setImage(R.drawable.mmkpa);
        countriesModel.setTieuDePhu("Thanh Bình");
        countriesData.add(countriesModel);


        //country 5
        countriesModel = new CountriesModel();
        countriesModel.setId(1);
        countriesModel.setTieuDe("Gánh Mẹ");
        countriesModel.setImage(R.drawable.ganhme);
        countriesModel.setTieuDePhu(" Quach Been");
        countriesData.add(countriesModel);

        //country 6
        countriesModel = new CountriesModel();
        countriesModel.setId(1);
        countriesModel.setTieuDe("Hai Chữ Đã Từng");
        countriesModel.setImage(R.drawable.hcdt);
        countriesModel.setTieuDePhu("Phạm Minh Quyền");
        countriesData.add(countriesModel);



    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater =getMenuInflater();
        menu.setHeaderTitle("Menu context");
        inflater.inflate(R.menu.menu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.delete:
            countriesData.remove(info.position);
            customAdapter.notifyDataSetChanged();
            return  true;
            case R.id.add:
            countriesData.add(info.position,countriesModel);
             customAdapter.notifyDataSetChanged();
            return true;

            default:
                return super.onContextItemSelected(item);
        }

    }
}