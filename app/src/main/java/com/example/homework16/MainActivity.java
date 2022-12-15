package com.example.homework16;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.homework16.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private  MyEntryAdapter adapter;
    ActivityMainBinding binding;
    private Entry[] entries= new Entry[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        entries[0] = new Entry("EEEEL PRIMO",R.drawable.elprimo,R.drawable.dedelprimo);
        entries[1] = new Entry("Shelly",R.drawable.shelly,R.drawable.shellymeme);
        entries[2] = new Entry("Raven",R.drawable.raven,R.drawable.ravenmem);
        entries[3] = new Entry("Mortis",R.drawable.mortis,R.drawable.mortismeme);
        entries[4] = new Entry("Collet",R.drawable.collet,R.drawable.colletmeme);
        entries[5] = new Entry("Mendi",R.drawable.mendi,R.drawable.mendimeme);
        listView = findViewById(R.id.listview);
        adapter = new MyEntryAdapter(this,entries);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new ItemClickListener());
    }
    class ItemClickListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Log.v("A","pochemy");
            Toast.makeText(MainActivity.this, "sfdsd", Toast.LENGTH_SHORT).show();
            adapter.notifyDataSetChanged();
        }
    }
    class MyEntryAdapter extends ArrayAdapter<Entry>{
        final Entry[] entries;
        public MyEntryAdapter(@NonNull Context context, Entry[] entries){
            super(context,R.layout.list,entries);
            this.entries=entries;
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            Entry entry=entries[position];
            if(convertView==null){
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.list,null);
            }
            convertView.findViewById(R.id.like).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Button likes = view.findViewById(R.id.like);
                    Drawable like = view.getResources().getDrawable(R.drawable.like);
                    Drawable like2 = view.getResources().getDrawable(R.drawable.like2);
                    if(entry.getLiked()){
                        likes.setCompoundDrawablesWithIntrinsicBounds(like,null,null,null);
                        entry.setLikes(entry.getLikes()-1);
                        likes.setText(""+entry.getLikes());
                        entry.setLiked();
                    }
                    else{
                        likes.setCompoundDrawablesWithIntrinsicBounds(like2,null,null,null);
                        entry.setLikes(entry.getLikes()+1);
                        likes.setText(""+entry.getLikes());
                        entry.setLiked();
                    }
                }
            });
            convertView.findViewById(R.id.author_art).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, "За всех, кто хотел меня убить", Toast.LENGTH_SHORT).show();
                }
            });
            convertView.findViewById(R.id.send).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, "За всех, кто хотел меня убить", Toast.LENGTH_SHORT).show();
                }
            });
            convertView.findViewById(R.id.comments).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this,ElprimoActivity.class);
                    intent.putExtra("Text",entry.getAuthor());
                    startActivity(intent);
                    finish();
                }
            });
            ImageView authorArt = convertView.findViewById(R.id.author_art);
            authorArt.setImageResource(entry.getAuthorArtid());
            ImageView memes = convertView.findViewById(R.id.memes);
            memes.setImageResource(entry.getMemeid());
            TextView author = convertView.findViewById(R.id.author);
            author.setText(entry.getAuthor());
            return convertView;
        }
    }
}