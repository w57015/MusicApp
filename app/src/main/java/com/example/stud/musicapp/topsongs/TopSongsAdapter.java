package com.example.stud.musicapp.topsongs;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.stud.musicapp.R;
import com.example.stud.musicapp.api.TrendingList;
import com.example.stud.musicapp.api.TrendingSingle;

import java.util.List;

/**
 * Created by W57015 on 2018-04-26.
 */

public class TopSongsAdapter extends RecyclerView.Adapter<TopSongsAdapter.TopSongsViewHolder> {

    private List<TrendingSingle> trending;

    public TopSongsAdapter(List<TrendingSingle> trending){
        this.trending = trending;

    }

    @Override
    public TopSongsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_top_songs, parent, false);

        return new TopSongsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TopSongsViewHolder holder, int position) {

        final TrendingSingle trendingSingle = trending.get(position);

        holder.tvPlace.setText(String.valueOf(trendingSingle.intChartPlace));
        holder.tvTrack.setText(trendingSingle.strTrack);
        holder.tvArtist.setText(trendingSingle.strArtist);
        holder.tvAlbum.setText(trendingSingle.strAlbum);

        holder. llContainer .setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SongDetailsActivity. class );
                intent.putExtra(SongDetailsActivity.TRACK, trendingSingle.strTrack);
                intent.putExtra(SongDetailsActivity.ARTIST,trendingSingle.strArtist);
                intent.putExtra(SongDetailsActivity.TRACK_ID,trendingSingle.idTrack);

                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.trending != null ? this.trending.size() : 0;
    }

    public class TopSongsViewHolder extends RecyclerView.ViewHolder {

        LinearLayout llContainer;
        TextView tvPlace;
        TextView tvTrack;
        TextView tvArtist;
        TextView tvAlbum;



        public TopSongsViewHolder(View itemView) {
            super(itemView);

            llContainer = itemView.findViewById(R.id.llContainer);
            tvPlace = itemView.findViewById(R.id.tvPlace);
            tvTrack = itemView.findViewById(R.id.tvTrack);
            tvArtist = itemView.findViewById(R.id.tvArtist);
            tvAlbum = itemView.findViewById(R.id.tvAlbum);
        }
    }
}
