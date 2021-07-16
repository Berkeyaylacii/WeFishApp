package com.example.wefish;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import com.example.fishingapp.R;

import static android.content.Context.NOTIFICATION_SERVICE;

public class SettingsFragment extends Fragment {
    Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        button = view.findViewById(R.id.buttonSettings);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("My Notification", "My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getActivity().getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String message = getResources().getString(R.string.notification);
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext(), "My Notification")
                        .setSmallIcon(R.drawable.ic_baseline_message_24)
                        .setContentTitle("Notification")
                        .setContentText(message)
                        .setAutoCancel(true);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(getActivity());
                managerCompat.notify(1,builder.build());

            }

        });

        return view;
    }
}
