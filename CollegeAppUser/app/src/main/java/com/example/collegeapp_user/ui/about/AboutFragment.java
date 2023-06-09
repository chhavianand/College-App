package com.example.collegeapp_user.ui.about;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.collegeapp_user.R;

import java.util.ArrayList;
import java.util.List;

public class AboutFragment extends Fragment {

    private ViewPager viewPager;
    private CourseAdapter adapter;
    private List<CourseModel> list;

    private ImageView map;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        list = new ArrayList<>();
        list.add(new CourseModel(R.drawable.ic_bca, "BCA", "BCA course is the first step towards entering the IT world. The three year undergraduate program aims to provide the students knowledge about various IT subjects. BCA from INMANTEC comes with the advantage of additional courses in soft skills, summer training with IT companies, analytical and technical test training, live projects and workshops. This ensures that each student develops holistically and is able to not only excel in their job but also build their own businesses."));
        list.add(new CourseModel(R.drawable.ic_graduation, "BBA", "BA at INMANTEC is more superior to BBA from just any institute. It makes more value addition to a student’s career and knowledge. The course is not only limited to the university curriculum, it includes a number of Top Up courses in different semesters to enhance students’ analytical skills. The entrepreneurship development cell provides support and guidance to the budding entrepreneurs. The cell conducts live projects for the students to give them the confidence and first-hand knowledge from initiating a business to its successful run."));
        list.add(new CourseModel(R.drawable.ic_graduation, "LLB", "The Integrated School of Law (a constituent unit of INMANTEC) is affiliated with Ch. Charan Singh University, Meerut and approved by the Bar Council of India, New Delhi to run 3-year LL.B. (Six semesters) program professional degree in law. Unlike several other law schools the primary focus at ISL is not only on equipping the law graduates with a qualifying professional degree but also on preparing them for the real world of legal affairs. "));
        list.add(new CourseModel(R.drawable.ic_graduation, "B.Com", "Bachelor of Commerce or B.Com degree is becoming a popular choice among students now. This course aims at building competence in particular areas of business studies while providing the students with a wide range of managerial skills. The program imparts strong subject-matter expertise by focusing on the learning that includes the knowledge of basic theories, principles, methods and procedures of commerce and accounting."));

        adapter = new CourseAdapter(getContext(), list);

        viewPager = view.findViewById(R.id.viewPager);

        viewPager.setAdapter(adapter);

        ImageView imageView = view.findViewById(R.id.collegeImage);

        //Glide.with(getContext())
         //       .load("https://www.google.com/maps/uv?pb=!1s0x390cf244d2e44a25:0x866c6717e6acda19!3m1!7e115!4shttps://lh5.googleusercontent.com/p/AF1QipNljHSCf34u0s2u0KZ461qC8wgtr2fUgf8Pt3So%3Dw309-h160-k-no!5sinmantec+-+Google+Search!15zQ2dJZ0FRPT0&imagekey=!1e10!2sAF1QipNljHSCf34u0s2u0KZ461qC8wgtr2fUgf8Pt3So&hl=en&sa=X&ved=2ahUKEwjei8-Mzp34AhXgIbcAHYK_DSoQoip6BAhKEAM")
         //       .into(imageView);

        Glide.with(getContext()).load(R.drawable.pic_campus).into(imageView);

        map = view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });

        return view;
    }

    private void openMap() {
        Uri uri = Uri.parse("geo:0, 0?q=INMANTEC Instituions, Delhi-Hapur Bypass (NH-9 near Dasna Flyover Udyog Kunj, Ghaziabad, Uttar Pradesh 201009");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }
}