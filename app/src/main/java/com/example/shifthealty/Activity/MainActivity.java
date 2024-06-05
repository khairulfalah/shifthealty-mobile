package com.example.shifthealty.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.shifthealty.Adapter.BestDealAdapter;
import com.example.shifthealty.Adapter.CategoryAdapter;
import com.example.shifthealty.Domain.CategoryDomain;
import com.example.shifthealty.Domain.ItemsDomain;
import com.example.shifthealty.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private RecyclerView.Adapter catAdapter, bestDealAdapter;
private  RecyclerView recyclerViewCat, recyclerViewBestDeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerviewCat();
    initLocation();
    initRecyclerViewBestDeal();
    }

    private void initLocation() {
        String[] items=new String[]{"Jakarta.idn", "Tanggerang.idn", "Bekasi.idn"};
        final Spinner locationSpin= findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSpin.setAdapter(adapter);
    }

    private void initRecyclerviewCat() {
        ArrayList<CategoryDomain> items=new ArrayList<>();
        items.add(new CategoryDomain("cat1","Vegetable"));
        items.add(new CategoryDomain("cat2","Fruits"));
        items.add(new CategoryDomain("cat3","Dairy"));
        items.add(new CategoryDomain("cat4","Drinks"));
        items.add(new CategoryDomain("cat5","Grain"));

        recyclerViewCat = findViewById(R.id.catView);
        recyclerViewCat.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

        catAdapter = new CategoryAdapter(items);
        recyclerViewCat.setAdapter(catAdapter);

    }
    private void initRecyclerViewBestDeal(){
        recyclerViewBestDeal=findViewById(R.id.bestView);
        recyclerViewBestDeal.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        bestDealAdapter=new BestDealAdapter(getData());
        recyclerViewBestDeal.setAdapter(bestDealAdapter);
    }

    public ArrayList<ItemsDomain> getData() {
        ArrayList<ItemsDomain> items = new ArrayList<>();
        items.add(new ItemsDomain("orange","Fresh Orange",20.000,"With its Vibrant orange hue and aburst of resreshing" +
                "citrus flavor, the juicy orange is a natural source of" +
                "vitamin C, invigorating your sense amd" +
                "supporting your immune system. A delightful snack" +
                "that combines health and taste",4.2));
        items.add(new ItemsDomain("apple","Fresh apple",40.000,"Apples are an excellent source of dietary fiber, both soluble and insoluble. Fiber is crucial for digestive health, as it helps regulate bowel movements and may contribute to a feeling of fullness, aiding in weight management",4.8));
        items.add(new ItemsDomain("watermelon","fresh Watermelon",11.000,"Watermelon is composed of about 92% water, making it an excellent hydrating fruit. Staying hydrated is crucial for overall health, as water is essential for various bodily functions, including digestion, circulation, and temperature regulation.",4.0));
        items.add(new ItemsDomain("berry","Fresh berry",55.000,"Regular consumption of berries has been associated with a reduced risk of heart disease. The antioxidants and fiber in berries may help lower blood pressure, reduce cholesterol levels, and improve overall cardiovascular health.",4.2));
        items.add(new ItemsDomain("pineaplle","Fresh pineapple",90,"The fiber, potassium, and bromelain in pineapple can contribute to heart health. Potassium helps regulate blood pressure, and the fiber content may help lower cholesterol levels.",4.1));
        items.add(new ItemsDomain("strawberry","Fresh strawberry",80.000,"Vitamin C is essential for a healthy immune system, and strawberries are a great source of this vitamin. Regular consumption may help boost the immune response and protect against infections.",4.5));
        return items;
    }
}