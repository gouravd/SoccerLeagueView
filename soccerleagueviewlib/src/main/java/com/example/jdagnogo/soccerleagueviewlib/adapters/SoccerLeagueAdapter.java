package com.example.jdagnogo.soccerleagueviewlib.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jdagnogo.soccerleagueviewlib.R;
import com.example.jdagnogo.soccerleagueviewlib.comparator.BeComparator;
import com.example.jdagnogo.soccerleagueviewlib.comparator.BmComparator;
import com.example.jdagnogo.soccerleagueviewlib.comparator.DiffComparator;
import com.example.jdagnogo.soccerleagueviewlib.comparator.GComparator;
import com.example.jdagnogo.soccerleagueviewlib.comparator.MjComparator;
import com.example.jdagnogo.soccerleagueviewlib.comparator.NComparator;
import com.example.jdagnogo.soccerleagueviewlib.comparator.Pcomparator;
import com.example.jdagnogo.soccerleagueviewlib.comparator.Pointscomparator;
import com.example.jdagnogo.soccerleagueviewlib.models.TeamInLeague;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SoccerLeagueAdapter extends RecyclerView.Adapter<SoccerLeagueAdapter.SoccerLeagueAdapterViewHolder> {
    private ArrayList<TeamInLeague> mDataset;
    private Context context;

    public SoccerLeagueAdapter(ArrayList<TeamInLeague> mDataset, Context context) {
        this.mDataset = mDataset;
        this.context = context;
    }

    public void order(int i) {
        if (i == R.id.mj) {
            Collections.sort(mDataset, new MjComparator());
        } else if (i == R.id.g) {
            Collections.sort(mDataset, new GComparator());
        } else if (i == R.id.n) {
            Collections.sort(mDataset, new NComparator());
        } else if (i == R.id.p) {
            Collections.sort(mDataset, new Pcomparator());
        } else if (i == R.id.bm) {
            Collections.sort(mDataset, new BmComparator());
        } else if (i == R.id.be) {
            Collections.sort(mDataset, new BeComparator());
        } else if (i == R.id.diff) {
            Collections.sort(mDataset, new DiffComparator());
        } else{
            Collections.sort(mDataset, new Pointscomparator());
        }
        notifyDataSetChanged();
    }

    public void setDataSet(ArrayList<TeamInLeague> dataSet) {
        if (null != dataSet) {
            this.mDataset.clear();
            this.mDataset = new ArrayList<>();
            this.mDataset.addAll(dataSet);
            order(0);
        }

    }

    @Override
    public SoccerLeagueAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.soccer_league_item, parent, false);
        return new SoccerLeagueAdapter.SoccerLeagueAdapterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(SoccerLeagueAdapterViewHolder holder, int position) {
        holder.teamName.setText(mDataset.get(position).getTeam().getName());
        holder.rank.setText(String.valueOf(position + 1));
        holder.mj.setText(String.valueOf(mDataset.get(position).getNumberOfMatchPlayed()));
        holder.g.setText(String.valueOf(mDataset.get(position).getNumberOfmatchWin()));
        holder.n.setText(String.valueOf(mDataset.get(position).getNumberOfmatchDraw()));
        holder.p.setText(String.valueOf(mDataset.get(position).getNumberOfmatchLost()));
        holder.bm.setText(String.valueOf(mDataset.get(position).getGoalScored()));
        holder.be.setText(String.valueOf(mDataset.get(position).getGoalConceded()));
        holder.diff.setText(String.valueOf(mDataset.get(position).getDiff()));
        holder.pts.setText(String.valueOf(mDataset.get(position).getCurrentPoints()));


    }

    @Override
    public int getItemCount() {
        return mDataset == null ? 0 : mDataset.size();
    }


    public class SoccerLeagueAdapterViewHolder extends RecyclerView.ViewHolder {
        final TextView teamName;
        final TextView rank;
        final TextView mj;
        final TextView g;
        final TextView n;
        final TextView p;
        final TextView bm;
        final TextView be;
        final TextView diff;
        final TextView pts;

        public SoccerLeagueAdapterViewHolder(View itemView) {
            super(itemView);
            teamName = (TextView) itemView.findViewById(R.id.team_name);
            rank = (TextView) itemView.findViewById(R.id.rank);
            mj = (TextView) itemView.findViewById(R.id.mj);
            g = (TextView) itemView.findViewById(R.id.g);
            n = (TextView) itemView.findViewById(R.id.n);
            p = (TextView) itemView.findViewById(R.id.p);
            bm = (TextView) itemView.findViewById(R.id.bm);
            be = (TextView) itemView.findViewById(R.id.be);
            diff = (TextView) itemView.findViewById(R.id.diff);
            pts = (TextView) itemView.findViewById(R.id.pts);
        }
    }
}
