package com.rxmediandroidapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rxmediandroidapp.R;
import com.rxmediandroidapp.Sidemenu.SideMenu;
import com.rxmediandroidapp.customadapter.HashMapRecycleviewadapter;
import com.rxmediandroidapp.storedobjects.StoredObjects;

public class TL_Franchisee_List extends Fragment {

    ImageView backbtn_img;
    TextView title_txt;
    LinearLayout add_franchisee_lay;

    RecyclerView tl_franchises_recyler;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate( R.layout.tl_franchisee_list,null,false );
        StoredObjects.page_type="tl_franchisee_list";
        StoredObjects.back_type="home";
        SideMenu.updatemenu(StoredObjects.page_type);
        initilization(v);
        return v;
    }

    private void initilization(View v) {

        backbtn_img = v.findViewById( R.id. backbtn_img);
        title_txt= v.findViewById( R.id. title_txt);
        add_franchisee_lay = v.findViewById( R.id. add_franchisee_lay);
        tl_franchises_recyler = v.findViewById( R.id.tl_franchises_recyler);
        title_txt.setText( "Franchises" );




        backbtn_img.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentcallinglay( new Home() );
            }
        } );


        add_franchisee_lay.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentcallinglay( new TL_Add_Marketing_Exicutive_One() );
            }
        } );





        StoredObjects.hashmaplist(5);
       // customRecyclerview.Assigndatatorecyleviewhashmap( marketing_exicutive_recyler, StoredObjects.dummy_list,"marketing_exicutive", StoredObjects.Listview, 0, StoredObjects.ver_orientation, R.layout.marketing_exicutive_listitem);

        final LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        tl_franchises_recyler.setLayoutManager(linearLayoutManager);

        tl_franchises_recyler.setAdapter(new HashMapRecycleviewadapter(getActivity(),StoredObjects.dummy_list,"tl_franchises",tl_franchises_recyler,R.layout.tl_franchisee_list_listitem));


    }
    public void fragmentcallinglay(Fragment fragment) {

        FragmentManager fragmentManager = getActivity ().getSupportFragmentManager ();
        fragmentManager.beginTransaction ()/*.setCustomAnimations(R.anim.falldown, R.anim.falldown)*/.replace (R.id.frame_container , fragment).addToBackStack( "" ).commit ();

    }




}

