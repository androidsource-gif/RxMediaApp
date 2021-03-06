package com.rxmediandroidapp.fragments.patient;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

public class P_Test_Sugestions extends Fragment {

    ImageView backbtn_img;
    TextView title_txt;
    static RecyclerView p_test_recyler;
    public static HashMapRecycleviewadapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate( R.layout.p_test_sugestions,null,false );
        StoredObjects.page_type="p_test_sugest";
        StoredObjects.back_type="p_test_sugest";
        SideMenu.updatemenu(StoredObjects.page_type);
        initilization(v);
        return v;
    }

    private void initilization(View v) {

        backbtn_img = v.findViewById(R.id.backbtn_img);
        title_txt = v.findViewById(R.id.title_txt);
        p_test_recyler = v.findViewById(R.id.p_test_recyler);

        title_txt.setText("Test Suggestion List");
        backbtn_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fm = getActivity().getSupportFragmentManager();
                if (fm.getBackStackEntryCount() > 0) {
                    fm.popBackStack();
                }
            }
        });

        final LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        p_test_recyler.setLayoutManager(linearLayoutManager);

        StoredObjects.hashmaplist(3);
        adapter = new HashMapRecycleviewadapter(getActivity(),StoredObjects.dummy_list,"p_tst_sugstn",p_test_recyler,R.layout.p_test_sugtn_lstitem);
        p_test_recyler.setAdapter(adapter);

    }

    public void fragmentcallinglay(Fragment fragment) {
        FragmentManager fragmentManager = getActivity ().getSupportFragmentManager ();
        fragmentManager.beginTransaction ().replace (R.id.frame_container , fragment).addToBackStack( "" ).commit ();

    }

}
