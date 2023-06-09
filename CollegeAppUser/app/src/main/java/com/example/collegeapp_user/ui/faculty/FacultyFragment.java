package com.example.collegeapp_user.ui.faculty;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.collegeapp_user.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FacultyFragment extends Fragment {

    private RecyclerView caDepartment, managementDepartment, lawDepartment, commerceDepartment, otherDepartment;
    private LinearLayout caNoData, managementNoData, lawNoData, commerceNoData, othersNoData;
    private List<TeacherData> list1, list2, list3, list4, list5;
    private TeacherAdapter adapter;

    private DatabaseReference reference, dbRef;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_faculty, container, false);

        caDepartment = view.findViewById(R.id.caDepartment);
        managementDepartment = view.findViewById(R.id.managementDepartment);
        lawDepartment = view.findViewById(R.id.lawDepartment);
        commerceDepartment = view.findViewById(R.id.commerceDepartment);
        otherDepartment = view.findViewById(R.id.otherDepartment);

        caNoData = view.findViewById(R.id.caNoData);
        managementNoData = view.findViewById(R.id.managementNoData);
        lawNoData = view.findViewById(R.id.lawNoData);
        commerceNoData = view.findViewById(R.id.commerceNoData);
        othersNoData = view.findViewById(R.id.othersNoData);

        reference = FirebaseDatabase.getInstance().getReference().child("Faculty");

        caDepartment();
        managementDepartment();
        lawDepartment();
        commerceDepartment();
        otherDepartment();

        return view;
    }

    private void caDepartment() {
        dbRef = reference.child("Computer Applications");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    caNoData.setVisibility(View.VISIBLE);
                    caDepartment.setVisibility(View.GONE);
                }else {

                    caNoData.setVisibility(View.GONE);
                    caDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    caDepartment.setHasFixedSize(true);
                    caDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list1, getContext());
                    caDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void managementDepartment() {
        dbRef = reference.child("Management");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    managementNoData.setVisibility(View.VISIBLE);
                    managementDepartment.setVisibility(View.GONE);
                }else {

                    managementNoData.setVisibility(View.GONE);
                    managementDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    managementDepartment.setHasFixedSize(true);
                    managementDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list2, getContext());
                    managementDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void lawDepartment() {
        dbRef = reference.child("Law");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    lawNoData.setVisibility(View.VISIBLE);
                    lawDepartment.setVisibility(View.GONE);
                }else {

                    lawNoData.setVisibility(View.GONE);
                    lawDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    lawDepartment.setHasFixedSize(true);
                    lawDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list3, getContext());
                    lawDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void commerceDepartment() {
        dbRef = reference.child("Commerce");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    commerceNoData.setVisibility(View.VISIBLE);
                    commerceDepartment.setVisibility(View.GONE);
                }else {

                    commerceNoData.setVisibility(View.GONE);
                    commerceDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    commerceDepartment.setHasFixedSize(true);
                    commerceDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list4, getContext());
                    commerceDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void otherDepartment() {
        dbRef = reference.child("Other");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list5 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    othersNoData.setVisibility(View.VISIBLE);
                    otherDepartment.setVisibility(View.GONE);
                }else {

                    othersNoData.setVisibility(View.GONE);
                    otherDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list5.add(data);
                    }
                    otherDepartment.setHasFixedSize(true);
                    otherDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list5, getContext());
                    otherDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });
    }

}