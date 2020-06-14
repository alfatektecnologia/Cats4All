package br.com.oliveiraemanoel.cats4all.adapters;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.oliveiraemanoel.cats4all.R;

public class CatsAdapter extends RecyclerView.Adapter<CatsAdapter.ViewHolder> {

    private List<String> catImagesList = new ArrayList<>();
    private final Context context;

    public CatsAdapter(Context context, List<String> catImagesList) {
        this.catImagesList = catImagesList;
        this.context = context;
    }

    @NonNull
    @Override
    public CatsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.recycler_item,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CatsAdapter.ViewHolder holder, int position) {
       Uri url = Uri.parse(catImagesList.get(position));
        Picasso.get()
                .load(catImagesList.get(position))
                .fit()
                .centerCrop()
                .placeholder(R.drawable.ic_pets)
                .into(holder.image);
        holder.cardView.setOnClickListener(v -> {
            //some cat sound to play when click the card
            int[] sounds = {R.raw.zapsplat_cat_kitten_meow_004,
                    R.raw.zapsplat_cat_kitten_meow_006,
                    R.raw.zapsplat_cat_kitten_meow_007};
            Random rnd = new Random();
            int rndSound = rnd.nextInt(3);
            MediaPlayer mediaPlayer = MediaPlayer.create(context,sounds[rndSound]);
            mediaPlayer.start();
        });

    }

    @Override
    public int getItemCount() {
        return catImagesList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView image;
        final CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.ivItem);
            cardView = itemView.findViewById(R.id.cvItem);
        }
    }
}
