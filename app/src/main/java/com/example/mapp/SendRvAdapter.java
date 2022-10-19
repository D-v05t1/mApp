package com.example.mapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.icu.number.CompactNotation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class SendRvAdapter extends RecyclerView.Adapter<SendRvAdapter.ViewHolder> {

    private ArrayList<SendAppraisalModal> Sedmodalist;

    private Context context;
    int lastPos=-1;

     private Dataviewclick dataviewclick;


    public SendRvAdapter(ArrayList<SendAppraisalModal> sedmodalist, Context context, Dataviewclick dataviewclick) {
        Sedmodalist = sedmodalist;
        this.context = context;
        this.dataviewclick = dataviewclick;
    }

    @NonNull
    @Override
    public SendRvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.sendappraisalrv,parent,false);
        return new ViewHolder(v);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SendAppraisalModal sendAppraisalModal=Sedmodalist.get(position);
        holder.objectivetv.setText(sendAppraisalModal.getObjective());
        holder.indicatorstv.setText(sendAppraisalModal.getIndicators());
        holder.proofofresulttv.setText(sendAppraisalModal.getProofofresult());
        holder.agreedtargetstv.setText(sendAppraisalModal.getAgreedtargets());
        holder.selfmarktv.setText(sendAppraisalModal.getSelfmark());

        holder.technicalcompetencytv.setText(sendAppraisalModal.getTechnicalcompetency());
        holder.teamworktv.setText(sendAppraisalModal.getTeamwork());
        holder.trainingdurationtv.setText(sendAppraisalModal.getTreainingduration());
        holder.commentstv.setText(sendAppraisalModal.getComments());
        holder.agreedtrainingtv.setText(sendAppraisalModal.getAgreedtraining());
        holder.professionalismtv.setText(sendAppraisalModal.getProfessionalism());

        setAnimation(holder.itemView,position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataviewclick.onclickdata(position);
            }
        });
    }

    private void setAnimation(View itemView, int position){
        if (position>lastPos){
            Animation animation= AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            itemView.setAnimation(animation);
            lastPos=position;
        }


    }


    public interface Dataviewclick{
        void onclickdata(int position);

    }
    @Override
    public int getItemCount() {
        return Sedmodalist.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView objectivetv,indicatorstv,proofofresulttv, agreedtargetstv,selfmarktv,
                professionalismtv,technicalcompetencytv,teamworktv,trainingdurationtv, commentstv,agreedtrainingtv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            objectivetv=itemView.findViewById(R.id.obj);
            indicatorstv=itemView.findViewById(R.id.ind);
            proofofresulttv=itemView.findViewById(R.id.proof);
            agreedtargetstv=itemView.findViewById(R.id.agreed);
            selfmarktv=itemView.findViewById(R.id.self);

            trainingdurationtv=itemView.findViewById(R.id.traindurationview);
            commentstv=itemView.findViewById(R.id.commview);
            agreedtrainingtv=itemView.findViewById(R.id.trainingAgview);
            
            professionalismtv=itemView.findViewById(R.id.professionview);
            technicalcompetencytv=itemView.findViewById(R.id.technicalcompview);
            teamworktv=itemView.findViewById(R.id.teamworkview);






        }
    }
}
