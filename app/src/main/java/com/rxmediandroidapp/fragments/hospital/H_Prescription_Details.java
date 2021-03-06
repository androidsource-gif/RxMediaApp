package com.rxmediandroidapp.fragments.hospital;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListPopupWindow;
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
import com.rxmediandroidapp.customfonts.CustomEditText;
import com.rxmediandroidapp.storedobjects.StoredObjects;

public class H_Prescription_Details extends Fragment {

    ImageView backbtn_img;
    TextView title_txt,own_prescription_txt;

    RecyclerView prescrption_details_recyler,diagnose_recyler;

    EditText doc_attender_edtx;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate( R.layout.h_prescription_details,null,false );
        StoredObjects.page_type="prescription_details";
        StoredObjects.back_type="home";
        SideMenu.updatemenu(StoredObjects.page_type);
        initilization(v);
        return v;
    }

    private void initilization(View v) {

        backbtn_img = v.findViewById( R.id. backbtn_img);
        title_txt= v.findViewById( R.id. title_txt);
        prescrption_details_recyler= v.findViewById( R.id. prescrption_details_recyler);
        diagnose_recyler = v.findViewById( R.id. diagnose_recyler);
        own_prescription_txt = v.findViewById( R.id. own_prescription_txt);

        title_txt.setText( "Prescription Details" );


        backbtn_img.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                if (fm.getBackStackEntryCount() > 0) {
                    fm.popBackStack();
                }
            }
        });

        own_prescription_txt.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  fragmentcallinglay( new Add_Appointment() );
            }
        } );




        StoredObjects.hashmaplist(3);
        final LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        prescrption_details_recyler.setLayoutManager(linearLayoutManager);

        prescrption_details_recyler.setAdapter(new HashMapRecycleviewadapter(getActivity(),StoredObjects.dummy_list,"prescrption_details",prescrption_details_recyler,R.layout.prescription_details_listitem));


        StoredObjects.hashmaplist(3);
        final LinearLayoutManager linearLayoutManagerone=new LinearLayoutManager(getActivity());
        diagnose_recyler.setLayoutManager(linearLayoutManagerone);
        diagnose_recyler.setAdapter(new HashMapRecycleviewadapter(getActivity(),StoredObjects.dummy_list,"diagnose_recyler",diagnose_recyler,R.layout.diagnose_suggestion_listitem));






    }
    public void fragmentcallinglay(Fragment fragment) {

        FragmentManager fragmentManager = getActivity ().getSupportFragmentManager ();
        fragmentManager.beginTransaction ()/*.setCustomAnimations(R.anim.falldown, R.anim.falldown)*/.replace (R.id.frame_container , fragment).addToBackStack( "" ).commit ();

    }





}


